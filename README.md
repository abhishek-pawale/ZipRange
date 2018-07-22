# Java Coding Exercise

## BACKGROUND

Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5-digit codes. 

For example, if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

## PROBLEM statement

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input. 

NOTES

- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES

If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399]
Then the output should be = [94133,94133] [94200,94399]

## How to use this program
Make sure java 8 in installed on the system

1) Download the project as zip and extract or checkout using git
2) In eclipse, import using Existing Projects into Workspace menu
3) Libraries used are included and linked in classpath using relative path so should not be a problem.
4) The input is provided using the input.csv file under resource folder
5) Run the ZipRangeMerge.java

## Runtime required
Java 8

## Further Improvements possible
Null check using java optional
Apache Commons io to read file
Logging to file
