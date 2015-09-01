### Testing if I can control the log level of a logger that lives in a macro


Looks like "no". 


This project has two sub projects:

#### Macros:
`macros` is a project that provides an object that has two methods. One method calls a macro, the other calls println. Both methods have logger calls.

`core` is a project that uses the macros object for testing locally (within the same project).

Running `sbt run` shows that both the macro logger call and the regular logger call work correctly, and both can be silenced by changing the log level of `log back.xml` in `src/main/resources`

However, if the macros project is used as a dependency, say by `sbt publish-local`, and a new project is set up use the exact same calls used in `core`, then only the regular logger call can be silenced. The logger in the macro continues to log messages as if it can’t see the client’s `logback.xml`.

How can I get the macro logger be quiet?