require("MATH")
if (false) {
    print ("That is correct")
}
else if (false) {
    print ("That is not correct")
}
else {
    print ("God knows?")
}

myVar = toInt(input("Please enter an integer"))

if (myVar <= 3)
    print("You entered a number less than or equal to 3")
else if (myVar == 4)
    print("You entered 4")
else
    print("You entered a number greater than or equal to 5")

print (if (2>3) "Bad" else "Good")


x = 1
while (x < 10) {
    print (x)
    x = x + 1
}