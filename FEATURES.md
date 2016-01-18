#Features
This is the full list of features that SLang (1.0) offers
* Function calls with unlimited arguments of any type
  * print("Hello World");
  * print (thisIsAFunction());
  * print (10.4);
  * For print, to remove the new line at the end, pass a "" last
    * print("Test ", "");print("- Same Line", "")
* Variables
  * myVar = "This is a variable";
  * print ("The value of $myVar is ", myVar);
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
  * Works with all elements (As long as it is defined in the scala source, there is no operator overloading)
    * myVar * 2
    * "String" * 2
    * "String" + "Other String"
    * [1,2,3,4] + 5
    * [1,2,3,4] - 4
* Booleans
  * true && false
  * true | false
  * myVar == myOtherVar
  * myVar == 4
  * 2 > 1
  * Not Perfect
    * 2 == 2 && 3!=4 Fails
    * Has to be (2==2) && (3!=4)
* User defined functions
  * Unlike in SLang0, SLang1 supports UDFs. These are simply assigned to variables
  * myFunction = () => {print("HI")}
  * They can also be passed as parameters
    * func ( () => {print("HI")} )
  * They cannot be called inline (i.e. ()={}() fails)
* Scoping
  * Also unlike SLang0, SLang1 has a scope stack behind it. This means that variables defined in a function, cannot be accessed from outside
  * Functions can read, but not write to variables above their scope
* Control Statements
  * Ifs
    * Ifs are like normal, modeled on Scala's
    * They return the value of code run
    * if (true) "Hello World" => Hello World
  * Whiles (Do not return anything)
    * while(true) print ("Loops")