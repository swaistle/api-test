# BPDTS Technical Test

## How to run the tests
To run a regression test:
* Terminal: `mvn test`
* IntelliJ: Right-click on `bpdts.runner.TestRunner` and select `Run` from the drop down

To run a `@smoke` test add the command:
`-Dcucumber.filter.tags="@smoke"`
* Terminal: `mvn -Dcucumber.filter.tags="@smoke" test`
* IntelliJ: `Edit Configuration` > in `VM options` field enter `-Dcucumber.filter.tags="@smoke"` > Apply. Then run the class as normal.

The application url has a default set, but can be overridden with an environment variable:
* Terminal: `APP_URL=<hostURI> mvn test` 
* IntelliJ: `Edit Configuration` > in `Environment variables` field enter `APP_URL=<hostURI>` > Apply. Then you can run the class as normal.
