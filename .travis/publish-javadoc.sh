#!/bin/bash
#
# Publish Javadoc of successful CI builds to http://cbeams.github.io/libjava/api
#
# See http://benlimmer.com/2013/12/26/automatically-publish-javadoc-to-gh-pages-with-travis-ci

if [ "$TRAVIS_REPO_SLUG" == "cbeams/libjava" ] \
        && [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] \
        && [ "$TRAVIS_PULL_REQUEST" == "false" ] \
        && [ "$TRAVIS_BRANCH" == "master" ]; then

    echo "Publishing javadoc..."

    git config --global user.email "travis@travis-ci.org"
    git config --global user.name "travis-ci"

    # Create a fresh clone in which to run delombok and commit the results to the delombok branch
    cd $HOME
    git clone --quiet --branch=delombok https://${GH_TOKEN}@github.com/cbeams/libjava delombok > /dev/null

    cd delombok
    git reset --hard origin/master
    ./gradlew delombok
    git rm .travis.yml # to avoid triggering a build when this branch is pushed
    git commit -am "Delombok Java sources"
    git push -fq origin delombok > /dev/null

    # Run javadoc over delomboked sources to pick up all methods and constructors
    ./gradlew javadoc
    cp -R build/docs/javadoc $HOME/api-temp

    # Create a fresh clone in which to publish Javadoc to gh-pages
    cd $HOME
    git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/cbeams/libjava gh-pages > /dev/null
    cd gh-pages
    git rm -rf ./api
    cp -Rf $HOME/api-temp ./api
    git add -f .
    git commit -m "Publish Javadoc from Travis CI build $TRAVIS_BUILD_NUMBER"
    git push -fq origin gh-pages > /dev/null

    echo "Published Javadoc to gh-pages. See http://cbeams.github.io/libjava/api"
fi
