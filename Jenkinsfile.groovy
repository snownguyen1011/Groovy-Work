pipeline {
    agent any
    //parameters {
    //string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    //}
    stages {
        stage('Initial') {
            steps {
                step([$class: 'WsCleanup'])
                script {
                    git credentialsId: 'github', url: 'https://github.com/snownguyen1011/Groovy-Work.git'
                    dir("$WORKSPACE") {
                        def validServices = []
                        def invalidServices = []
                        def inputfile = readProperties file: "${WORKSPACE}/inputfile1.properties"
                        println(inputfile.getClass())
                        def servicefile = readFile file: "${WORKSPACE}/services-list.txt"
                        inputfile.each { key, value ->
                            //println(key)
                            servicefile.each{ String line ->
                                if(line == key){
                                    validServices.add(key)
                                }
                                else{
                                    invalidServices.add(key)
                                }
                        }
                            println("Valid Services:\n ${validServices}")
                            println("InValid Services:\n ${invalidServices}")


//                        def file1 = readFile("${WORKSPACE}/inputfile1.properties")  // Converts as a String
//                        println(file1.getClass())  // file1 is a string
//                        def inputlist = []
//                        println(file1.split("="))
//                        //for(line in file1) {
//                        //  println(line)
//                        //inputlist << line.tokenize("=")
//                        //}
//                        //println(inputlist)
//
//                        def file2 = new File("${WORKSPACE}/inputfile1.properties")
//                        file2.eachLine { String line ->
//                            println(line)
                        }

                    }//dir
                }//script
            }//steps
        }//stage
    }//stages
}//pipeline