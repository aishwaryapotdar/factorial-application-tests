# Automated Test Cases - Factorial Application

I have automated following test cases - 

### 1. Smoke Tests

While Testing the Application UI, smoke Tests need to be repeated to verify whether all the required UI elements are present and enabled on the application homepage. Hence the following test cases have been automated:

1. Checking the Page Title.

2. Checking the Heading Content

3. Checking the Calculate button

4. Checking the link for Privacy Document

5. Checking the link for Terms and Conditions Document

### 2. Functional Tests

To check whether the factorial calculation for the provided input is correct, a few input values along with expected output values have been passed.

1. Check Factorial Calculation of a positive integer

2. An application can tend to behave incorrectly for the boundary values 
   Hence input values 0,1,170,171

3. Check system validation for negative integer values


## Output of automated test cases - 

  ##### logs/app.log
    2020-10-15 00:35:57,126 INFO o.e.s.FactorialSmokeTest [main] Executing Smoke Test Cases...
    2020-10-15 00:36:00,443 INFO o.e.s.FactorialSmokeTest [main] Testing checkPageTitle()
    2020-10-15 00:36:00,463 INFO o.e.s.FactorialSmokeTest [main] Testing checkHeading()
    2020-10-15 00:36:00,587 INFO o.e.s.FactorialSmokeTest [main] Testing checkCalculateButton()
    2020-10-15 00:36:01,003 INFO o.e.s.FactorialSmokeTest [main] Testing checkPrivacyDocument()
    2020-10-15 00:36:01,184 ERROR o.e.s.FactorialSmokeTest [main] Test Case failed - checkPrivacyDocument()
    2020-10-15 00:36:01,332 INFO o.e.s.FactorialSmokeTest [main] Testing checkTermsAndConditionsDocument()
    2020-10-15 00:36:01,523 ERROR o.e.s.FactorialSmokeTest [main] Test Case failed - checkTermsAndConditionsDocument()
    2020-10-15 00:36:01,527 INFO o.e.f.FactorialFunctionalTest [main] Executing Functional Test Cases...
    2020-10-15 00:36:01,547 INFO o.e.f.FactorialFunctionalTest [main] Executing Test checkFactorialTestFor(Input: 3, Output: 6)
    2020-10-15 00:36:07,097 INFO o.e.f.FactorialFunctionalTest [main] Executing Test checkFactorialTestFor(Input: 0, Output: 1)
    2020-10-15 00:36:12,673 INFO o.e.f.FactorialFunctionalTest [main] Executing Test checkFactorialTestFor(Input: 1, Output: 1)
    2020-10-15 00:36:18,183 INFO o.e.f.FactorialFunctionalTest [main] Executing Test checkFactorialTestFor(Input: 170, Output: 7.257415615307999e+306)
    2020-10-15 00:36:23,690 INFO o.e.f.FactorialFunctionalTest [main] Executing Test checkFactorialTestFor(Input: 171, Output: Infinity)
    2020-10-15 00:36:29,298 INFO o.e.f.FactorialFunctionalTest [main] Executing Test checkFactorialTestFor(Input: -3, Output: Please enter a positive integer)
    2020-10-15 00:36:34,846 ERROR o.e.f.FactorialFunctionalTest [main] Test case failed - factorialOfNegativeInteger


## Bug Report 1 

Defect Summary: The documents for 'Terms and Conditions' and 'Privacy' are not present at their respective locations.

#### Steps to Reproduce

1. Go to the link https://qainterview.pythonanywhere.com/

2. Click on the link 'Terms and Conditions'
   The content displayed on this link is 

   `This is the privacy document. We are not yet ready with it. Stay tuned!`

3. Navigate back to the main page and click on the link 'Privacy'.
   The content displayed on this link is 
   
   `This is the terms and conditions document. We are not yet ready with it. Stay tuned!`
   
**Priority**: High

**Severity**: Low  
   
#### Expected Output: 

When a user clicks on the link 'Terms and Conditions' the document for 'Terms and Conditions' should be displayed.
When a user clicks on the link 'Privacy' the document for 'Privacy' should be displayed.

#### Actual Output: 

When a user clicks on the link 'Terms and Conditions' the document for 'Privacy' should be displayed.
When a user clicks on the link 'Privacy' the document for 'Terms and Conditions' should be displayed.

#### Suggested Solution: 

Although this defect does not have a functional impact on the system causing incorrect Factorial calculation,
The 'Terms and Conditions' and 'Privacy' are important links on the homepage of the system. 
Automated Test cases should be added in the Developer and QA test suites to avoid these errors.

## Bug Report 2

Defect Summary:  Negative integer input is not handled by the system.

#### Steps to Reproduce:

1. Go to the link https://qainterview.pythonanywhere.com/

2. Enter the integer 4 and click the Calculate button.
   The system displays correct answer as : The factorial of 4 is: 24 

3. Now change the input as integer -5 and click the Calculate button.
   The system continues to display the output from the previous calculation 
   The factorial of 4 is: 24 
   
**Priority**: High

**Severity**: High  
   
#### Expected Output: 

When a user enters the input (-5) the system should display an error message as "Please enter a positive integer".

#### Actual Output: 

When a user enters a negative integer as input, the system either does not display any output or continues to display the output for the input provided before the negative integer.

#### Possible Root Cause: 

As the input accepted by the system is of type 'integer', on entering negative integers the system does not throw any error, while it gives an error message when any character or special character values are entered.

#### Suggested Solution: 

1. The error message displayed by the system should be "Please enter a positive integer", or

2. Validations should be added to the input text box to accept only digits 0-9 and no characters or special characters, thus avoiding all incorrect inputs to be entered.
