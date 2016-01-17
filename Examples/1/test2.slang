require("CONT")
if(true, {print("The condition was true")})
if(false, {print("The condition was true")}, {print("The condition was false")})
if(true, {
    print("This is the truth")
    2+2
})

$myVar = 0
while ($myVar <= 10, {print($myVar);$myVar = $myVar + 1})

foreach($myVar, [0,1,2,3,4], print($myVar))