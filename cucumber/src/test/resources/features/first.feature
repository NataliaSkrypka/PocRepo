Feature: first feature

  Scenario: some scenario
    Given aaa
    When bbb
    Then ccc

  Scenario Template:
    Given aaa <aa_t>
    When <when>
    Then <then>
  Examples:
    |aa_t|when|then|
    |aa  |bbb |ccc |
    |cc  |eee |ddd |