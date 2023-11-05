# language: en

  @factorial
  Feature: The Greatest Factorial Calculator
    As an user, I want to calculate correctly the factorial of integer numbers using the system.

    @app-name
    Scenario: Title of Application
      Given the user access the application
      Then the Tab Name is correctly shown
      And the Title is correctly shown

    @app-anchor-terms
    Scenario: Validating the anchor tags for Terms of Service
      Given the user access the application
      When Click in the Terms of Service link
      Then the user will redirect to Terms of Service page

    @app-anchor-privacy
    Scenario: Validating the anchor tags for Terms of Service
      Given the user access the application
      When Click in the Privacy link
      Then the user will redirect to Privacy page

    @calculate-factorial
    Scenario Outline: Validate Factorial Calculation
      Given the user access the application
      And enter with <value>
      When click to calculate
      Then the answer is <answer>

      Examples:
      | value                | answer                       |
      | a                    | "Please enter an integer"    |
      | @                    | "Please enter an integer"    |
      | 0                    | "The factorial of 0 is: 1"   |
      | 1                    | "The factorial of 1 is: 1"   |
      | 150                  | "The factorial of 1 is: 5.713383956445855e+262"   |
      | 200                  | "The factorial of 1 is: 7.8865786736479050355236321393218506229513597768717326329474253324435944996340334292030428401198462390417721213891963883025764279024263710506192662495282993111346285727076331723739698894392244562145166e+374"   |
      | 992                  | "The factorial of 992 is: 4.1384239831282686689469647237139691944263492932485138892478080969796525462061857704439839034021817791094155458002385108518927103614316808533009033384537248034641783922008302869119381564270760037419964e+2543" |
      | -1                   | "The factorial of -1 is: -1"                                                                                                                                                                                                               |

#      * 0-: The system returns error 500 - Internal Error, but doesn't show anything to the User, even the message labeled with the answer.
#      * 0 to 170: The system calculate correctly and shows the correct answer to the User.
#      * 171 to 991: the system returns the answer as "Infinity".
#      * 992+: The system returns error 500 - Internal Error, but doesn't show anything to the User, even the message labeled with the answer.
#
#
#    **Visual Suggestion:**
#      * The current icon with the input, looks more like a button, but without any function on it. <br>
#      * IMG: https://imgur.com/lF8dnfM
#
#      * Probably would be more intuitive, some icon indicating "Integer Inputs" for the field.
#      * E.g.: https://imgur.com/UklhWRY

