# SLang
A basic programming language built in scala

## Features
* Function calls with unlimited arguments of any type
  * print("Hello World");
  * print (thisIsAFunction());
  * print (10.4);
  * To remove the new line at the end, pass a "" last
    * print("Test ", "");print("- Same Line", "")
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
* Control Functions
  * All control is done with normal functions
  * if (true, {code_to_run_if_true}, {code_to_run_if_false})
    * Special function for else is just syntactic sugar
    * if (true, {code_to_run_if_true}, else({code_to_run_if_false}))
    * elseif is just an alias of if
    * Returns the value of the codeblock run
      * print(if(true,"Value")) => STDO - Value
  * foreach (var_to_use, iterable, {code_to run})
    * foreach ($myVar, [1,2,3,4,5], {print($myVar," ", "")})  => STDO - 1 2 3 4 5
      * myVar remains 5
    * Does not return a value
  * while (condition, {code})
    * while ($myVar < 5, {$myVar = $myVar + 1;print($myVar)}) => STDO - 0 1 2 3 4
      * $myVar remains 5
    * Does not return a value

## TODOs
* Add better list construction
* Add user defined functions
* Compile to runnable jar
* Make scripting adapter
  * This will make it easier to use SLang as a scripting module in other projects
  * ie for easy game modding