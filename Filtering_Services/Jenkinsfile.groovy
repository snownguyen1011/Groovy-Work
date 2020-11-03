//  1. Input file has properties. Match with services-list if found put it on validServices.txt otherwise on invalidServices.txt
//  2. From validServices.txt, match with scheduler-list.txt and filter valid services to validServices.txt


pipeline {
    agent any
    //parameters {
    //string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    //}
    stages {
        stage('Filter_Services') {
            steps {
                step([$class: 'WsCleanup'])
                script {
                    git credentialsId: 'github', url: 'https://github.com/snownguyen1011/Groovy-Work.git'
                    dir("$WORKSPACE") {
                        def validServices = []
                        def invalidServices = []
                        def validSchedulers = []
                        File file1 = new File("${WORKSPACE}/Filtering_Services/validServices.txt")
                        File file2 = new File("${WORKSPACE}/Filtering_Services/invalidServices.txt")
                        File file3 = new File("${WORKSPACE}/Filtering_Services/validSchedulers.txt")

                        def inputFile = readProperties file: "${WORKSPACE}/Filtering_Services/inputfile1.properties"
                        //println(inputFile.getClass())  // Hashmap
                        def serviceFile = readFile file: "${WORKSPACE}/Filtering_Services/services-list"
                        //println(serviceFile.getClass())  // String
                        def schedulersFile = readFile file: "${WORKSPACE}/Filtering_Services/scheduler-list.txt"

                        inputFile.each { key, value ->
                            if(serviceFile.contains(key))
                                println("key found: ${key}") {
                                    validServices.add(key)
                                    file1.append(key+"\n")
                                }
                                else{
                                    invalidServices.add(key)
                                    file2.append(key+"\n")
                                }
                        }
                        println("Valid Services:\n ${validServices}")
                        println("InValid Services:\n ${invalidServices}")
                        validServices.each{ item ->
                            if(schedulersFile.contains(item)){
                                validSchedulers.add(item)
                                file3.append(item+"\n")
                            }
                            else{
                                println("${item} not found on scheduler-list")
                            }
                        }
                        println("Valid Schedulers:\n ${validSchedulers}")

                    }//dir
                }//script
            }//steps
        }//stage
    }//stages
}//pipeline