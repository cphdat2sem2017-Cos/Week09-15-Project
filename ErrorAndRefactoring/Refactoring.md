# Refactoring code
is a "...change made to the internal structure of software to make it easier to understand and cheaper to modify without changing its observable behavior… It is a disciplined way to clean up code that minimizes the chances of introducing bugs" *Martin Fowler*

## Refactoring what it is and is not
#### Refactoring is  
- fill in short-cuts  
- eliminate duplication and dead code  
- to make the design and logic clear  
- make better and clearer use of the programming language  
- Always to simplify the code and to make it easier to understand. Always to make it easier and safer to change in the future  

#### Refactoring is not
- Fixing any bugs found along the way
- Optimization
- Errorhandling
- Making the code more testable

## The Martin Fowler cataloque
Refactoring is descriped as a pattern (a general solution to a common problem)  
[Here is a list of refactoring patterns](http://refactoring.com/catalog)

## Netbeans support
Netbeans has a number of refactorings, in particular

- Rename (harder to do right without support than one might think)
- Introduce new method
- Introduce variables
- Introduce parameters, fields
- Inline a method body
- Incapsulate a field (add getter and setter)
- Generate constructors
- Extract an Interface

And last but not least - one can format the source code so it is reading friendly.
