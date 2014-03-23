As a rule IDEA metadata is not checked in, but rather generated when importing
a project into IDEA from its `build.gradle` file. `inspectionProfiles` is an
exception to this rule--it does not contain system-specific paths and helps
ensure all developers see the same warnings, etc.

See the root [.gitignore](../.gitignore) file.
