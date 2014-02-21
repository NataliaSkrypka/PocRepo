Feature: Full text search on booking.com

  Scenario : Full text search with valid parameters
    Given user open main page
    When user performs search for Lon on main page
    Then mentioned entity is shown in the result
    
 Scenario Outline: Full text search with invalid parameters
    Given user open main page
    When user performs search for <fullText> on main page
    Then message <message> is shown on search result
  Examples:
    |fullText         |message                              |
    |@#$ %^&          |Sorry, we don't recognise that name. |

 Scenario Outline: Full text search with empty parameters
	Given user open main page
	When user leave search fields empty
	Then message <message> is shown on search result
 Examples:
	|message                                                    |
	|Oops! We need at least part of the name to start searching.|

 Scenario Outline: Full text search with not specified dates
	Given user open main page
	When user performs search for <fullText> on main page and leave dates not specified
	Then error message <message> about invalid dates is shown on search result
 Examples:
	|fullText |message                                  |
	|New York |Please enter dates to check availability.|
