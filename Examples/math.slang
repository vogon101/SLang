//Basic maths testing one operation each
print("Basic Expressions")
print("2+2 = 4 => ", 2+2)
print("4-3 = 1 => ", 4-3)
print("2*3 = 6 => ", 2*3)
print("6/3 = 2 => ", 6/3)
print("2^3 = 8 +> ", 2^3)
print("")
//Testing multiple operations and BIDMAS
print("Combined Expressions")
print("2+3*4*5 = 62 => ", (2+3*4*5))
print("2*(3+4) = 14 => ", (2*(3+4)))
print("2/(3+4)-5*3 = -14.714285714 => ", 2.0/(3+4)-5*3)
print("(2*3)^(3+4) = 256 => ", (2*2)^(2+2))
print("2*(3^2)+10 = 28 =>", (2*(3^2)+10))
print("")
//Checking maths works with variables
print("Element Expressions")
$myVar = 5*20
print("$myVar = 5*20 = 100 => ", $myVar)
print("$myVar+20 = 120 => ", $myVar + 20)
$myVar = $myVar / 20
print("$myVar = $myVar/20 = 5", $myVar)
print("")
//Checking maths works with strings
print("Strings")
print("'Hello ' + 'World' = 'Hello World' => ", "Hello " + "World")
print("'Hello '*3 = 'Hello Hello Hello ' => ", "Hello "*3)
print("")
//Appending to lists
print("Lists")
print("[1,2,3,4]+5 = [1,2,3,4,5] => ", [1,2,3,4] + 5)
print("[1,2,3,4]-4 = [1,2,3]     => ", [1,2,3] - 4)