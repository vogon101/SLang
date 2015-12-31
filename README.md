# SLang
A basic programming language built in scala

## Features
* Function calls with unlimited arguments of any type
  * print("Hello World");
  * print (thisIsAFunction());
  * print (10.4);
* Variables (designated by a $)
  * $myVar = "This is a variable";
  * print ("The value of $myVar is ", $myVar);
* Lists (can contain multiple types)
  * [1,2,3,4]
  * [1,"Two",sqrt(9)]
* SemiColons optional at the end of lines
* Inline comments with //
* Math
  * 2*3
  * 2+3
  * 2/3
  * 2-3
  * 2^3
  * 2+4*(5+4)
  * Exponents don't have correct precedence
  * Works with all elements
    * $myVar * 2
    * "String" * 2
    * "String" + "Other String"
    * [1,2,3,4] + 5
    * [1,2,3,4] - 4
* Booleans
  * true && false
  * true | false
  * $myVar == $myOtherVar
  * 2 > 1
  * Not Perfect
    * 2 == 2 && 3!=4 Fails
    * Has to be (2==2) && (3!=4)

