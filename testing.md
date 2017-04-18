# Testing
## Tuesday April 18

As preparation for Monday, you should view the following on Lynda:
<https://www.lynda.com/Developer-Programming-Foundations-tutorials/Welcome/124398/137955-4.html>. 
It is nearly two hours, so remember to set some time aside.

There are a few sections which can be skipped:

- There is a section on how to do it in Eclipse - we use Netbeans, so that is different for us.
- Section 5 "Additional topics" can be skipped

### Main leaning objectives are:
* test levels 
* automated unit testing
* test design with black-box + white-box test techniques
* test coverage tool

### Plan:
1. Designing for test ([slides](TestSlides.pdf))
1. Test Discussion
3. Demo - [coding bats](http://codingbat.com/prob/p192082) are really unit tests
4. Exercise: Transform [codingbat](http://codingbat.com/prob/p136351) into JUnit
5. Demo - making tests for an existing code base (sorting from week 5)
6. Exercise: Make a test for quicksort
7. Aspects of test ([slides](TestSlides.pdf))
	- Testing concept: Black-box and White-box testing
	- Testing concept: Test coverage
8. Exercise: Install [codecoverage in jacocoverage](Codecoverage in Netbeans.md) and check coverage of your test for quicksort.



## Wednesday April 19
Mostly it is not recommended to test the actual database layer. 
However, that is a shame as many get the database layer wrong. Once the structure is in place, it is fairly straight forward to do.

### Main leaning objectives are:
* database integration testing 
* Designing for testability


Reading:

- This [note by Lasse Koskela](databaseTest.md) explains the principle of how to seperate the connection object from the actual database facade.
