print("IF Tests")
print("1 => ", if(true, "Correct", "FAIL"))
print("2 => ", if((true && false), "FAIL", "Correct"))
print("3 => ", if(true, "Correct"))
print("4 => ", if(2>1, "Correct", "FAIL"))
print("5 => ", if((true && false),
 "FAIL",
  else("Correct")
))
print("6 => ", if((true && false),
 "FAIL",
  elseif (true, "Correct", "FAIL")
))
print("")

print("WHILE Tests")
$myVar = 0
while($myVar < 5, {$myVar = $myVar + 1})
print("1 => 5 => ", $myVar," => ", if($myVar == 5, "Correct", "FAIL"))
print("")

print("FOREACH Tests")
$myVar = 0
foreach($myVar, [0,1,2,3,4,5], {})
print("1 => 5 => ", $myVar," => ", if($myVar == 5, "Correct", "FAIL"))
print("")

print("RETURN Tests")
$myVar = {print("Correct");return(10);print("FAIL")}
print("1 => 10 => ", $myVar," => ", if($myVar == 10, "Correct", "FAIL"))