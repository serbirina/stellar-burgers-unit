# Automated Unit Tests for "Stellar Burgers"
Automated unit tests cover the methods in the `Burger` class.  
The tests are implemented using Java, JUnit, and Mockito, and generate JaCoCo reports.
---
## Tech Stack

| Technology | Version  |
|------------|----------|
| Java       | 11       |
| Maven      | 3.9.10   |
| JUnit      | 4.13.1   |
| Mockito    | 3.12.4   |
| JaCoCo     | 0.8.7    |
---
## Run Tests
To run tests:  
```
mvn clean test
```
---
## JaCoCo Report

### Open an Already Generated Report
To open an already generated report, run:
- MacOs:
```
open target/site/jacoco/index.html
```

- Windows:
```
start target\site\jacoco\index.html
```

### Generate New Report
After running all tests, a new JaCoCo report can be generated: 
```
mvn jacoco:report
```
