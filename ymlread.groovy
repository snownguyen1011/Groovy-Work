@Grab('org.yaml:snakeyaml:1.17')
import org.yaml.snakeyaml.Yaml
import java.util.LinkedHashMap
import java.util.List
import groovy.json.*

// This code Worked Successfully
//Reading yml file
Yaml yaml = new Yaml();
InputStream inputStream = this.getClass()
  .getClassLoader()
  .getResourceAsStream("test.yaml");
Map<String, Object> obj = yaml.load(inputStream);

// Prints Whole yaml file as a Map
System.out.println(obj);

//Printing an Object from yaml file
System.out.println(obj.Name);

// Converting a Map to JSON format
def mapAsJson = JsonOutput.toJson(obj)

//Printing whole JSON data
System.out.println(mapAsJson);

def readJSON = new JsonSlurper().parseText(mapAsJson)
// Printing an Object from JSON Data
System.out.println(readJSON.Number);


