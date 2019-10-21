#Author: mkefi
@tag
Feature: Client can create a student.

	Scenario: Client can add a list of students
		Given Client has an empty list of student
		When client create a list of students
		Then list can not be empty 
		
  @tag2
  Scenario Outline: Client create list of students
    Given  Client has a list of students
    When Client add a student with <id>  <name> and <className> to list
    Then I verify that student with <id> exist

    Examples: 
      | id  | name | className  |
      | 5 | "mohamed" | "class 10" |
      | 6 | "kefi" | "class 11"    |
