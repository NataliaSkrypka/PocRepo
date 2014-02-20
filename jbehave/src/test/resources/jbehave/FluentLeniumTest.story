Full text search on booking.com

***

Changelog
|Date           |Author           |Change                              |
|Feb, 19th 2014 |Natalia Skrypka  |story file created                  |

Scenario: 1 Full text search with valid parameters
Given f user open main page
When f user performs search for <fullText> on main page
Then f mentioned entity is shown in the result

Examples:
|fullText            |
|Lon                 |
|Ellington           |

Scenario: 2 Full text search with invalid parameters
Given f user open main page
When f user performs search for <fullText> on main page
Then f message <message> is shown on search result

Examples:
|fullText         |message                              |
|@#$ %^&          |Sorry, we don't recognise that name. |

Scenario: 3 Full text search with empty parameters
Given f user open main page
When f user leave search fields empty
Then f message <message> is shown on search result

Examples:
|message                                                     |
|Oops! We need at least part of the name to start searching.|

Scenario: 4 Full text search with not specified dates
Given f user open main page
When f user performs search for <fullText> on main page and leave dates not specified
Then f error message <message> about invalid dates is shown on search result

Examples:
|fullText |message                                  |
|New York |Please enter dates to check availability.|