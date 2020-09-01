#Selenium Lab version 4
## Setup
The following steps needs to be performed to run the tests
* Install Java 11
* Install Gradle
* Install a Java development environments, preferably IntelliJ. The community edition can be downloaded at: https://www.jetbrains.com/idea/download/
* Install Google Chrome browser (and/or Firefox)

### IntelliJ
If IntelliJ is installed you can do the following:
* Clone the git repository: `git clone https://github.com/danbry/selenium-lab-4.git`
* Download all the dependencies (will be automatically done by IntelliJ)
* Update the test configuration, described below.
* Run the tests
 
 

## The Twitter tests
The tests are structured using the PageObject pattern (to read more: https://martinfowler.com/bliki/PageObject.html). 
 
### Test code structure
The code and configuration is located in the src/test folder in package se.omegapoint.selenium.twitter
* browser - contains classes for configuring the different browsers
* infra - contains helper classes for the tests
* page - contains the page objects
* test - contains the test cases (using JUnit)
   * BaseTest - A base class for the tests to extend
   * LoginTest - Will do a correct login and an incorrect one
   * ProfileTest - Will do a login and go the the profile page
   * TwitterTest - Will send a correct Tweet and try to send a Tweet with 300 characters which will fail.
 
### Test configuration
To run the tests the configuration file config.properties must be updated. It's stored in src/test/resources
* You will also have to provide a valid Twitter account username and password. All tests except the TwitterTest/correctTweet won't cause any updates but that test will actually send a real Tweet. I'd recommend that you create a test Twitter account if you want to run it. 
 