def myMap = [:]

myMap.put('a', 1)
myMap.put('b', 2)
myMap.put('c', 3)

// PRINTING ALL MAP KEYS
def myMapkeyset = myMap.keySet()
println "MY MAP KEYS: ${myMapkeyset}"
// PRINTING ALL MAP VALUES
def myMapvalueset = myMap.values()
println "MY MAP VALUES: ${myMapvalueset}"
// PRINTING ALL MAP KEYS
myMap.each { it ->
   println "MY MAP VALUE: ${it.value}"
}
// PRINTING ALL MAP VALUES
myMap.each { it ->
   println "MY MAP KEY: ${it.key}"
}

///////////////////////////////////////////////////////
def myMaplist =[:]

myMaplist.put('id', "123ABC")
myMaplist.put('error', ["ERROR IS EXPECTED", "IGNORE"])

myMaplist.put('id', "456XYZ")
myMaplist.put('error', ["ERROR IS NOT EXPECTED", "IGNORABLE"])

println(myMaplist)

// OUTPUT :  myMaplist will replace
// [id:456XYZ, error:[ERROR IS NOT EXPECTED, IGNORABLE]]
////////////////////////////////////////////////////////

def hobbyLiteral = "hobby"                /// STRING
def hobbyMap = ["hobby": "Singing"]       /// LIST
def map1 =[:]                             /// EMPTY MAP
map1.put("${hobbyLiteral}", "${hobbyMap}")
println(hobbyMap.hobby)
println(hobbyMap[hobbyLiteral])


LinkedHashMap.metaClass.multiPut << { key, value ->
   delegate[key] = delegate[key] ?: []; delegate[key] += value
}

def myMap2 = [:]

myMap2.multiPut("a", ["ERROR IS EXPECTED", "IGNORE"])
myMap2.multiPut("a", ["ERROR IS EXPECTED", "IGNORABLE"])
myMap2.multiPut("a", "3")

myMap2.each {key, list ->
   println "${key} -> ${list}"
}