# BPDTS Technical Test

## How to run the tests
To run all the tests:
* Terminal: `mvn test`
* IntelliJ: Right-click on `bpdts.runner.TestRunner` and select `Run` from the drop down

The application url has a default set, but can be overridden with an environment variable:
* Terminal: `APP_URL=<hostURI> mvn test` 
* IntelliJ: `Edit Configuration` > in `Environment variables` field enter `APP_URL=<hostURI>` > Apply. Then you can run the test as normal.
