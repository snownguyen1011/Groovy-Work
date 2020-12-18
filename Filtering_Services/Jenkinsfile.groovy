//  1. Input file has properties. Match with services-list if found put it on validServices.txt otherwise on invalidServices.txt
//  2. From validServices.txt, match with scheduler-list.txt and filter valid services to validServices.txt


pipeline {
    agent any
    //parameters {
    //string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    //}
    stages {
        stage('\u2756 U+2780 Filter_Services U+2744') {
            steps {
                step([$class: 'WsCleanup'])
                script {
                    git credentialsId: 'github', url: 'https://github.com/snownguyen1011/Groovy-Work.git'
                    dir("$WORKSPACE") {
                        def validServices = []
                        def invalidServices = []
                        def validSchedulers = []
                        File file1 = new File("${WORKSPACE}/Filtering_Services/validServices.properties")
                        File file2 = new File("${WORKSPACE}/Filtering_Services/invalidServices.properties")
                        File file3 = new File("${WORKSPACE}/Filtering_Services/validServicesSchedulers.properties")
                        File file4 = new File("${WORKSPACE}/Filtering_Services/validServicesRegular.properties")

//                        def inputFile = readProperties file: "${WORKSPACE}/Filtering_Services/inputfile.properties"
                        def inputFile = readProperties file: "${WORKSPACE}/Filtering_Services/errorinput.properties"
                        //println(inputFile.getClass())  // Hashmap
                        def serviceFile = readProperties file: "${WORKSPACE}/Filtering_Services/services-list"
                        //println(serviceFile.getClass())  // Hashmap
                        def schedulersFile = readProperties file: "${WORKSPACE}/Filtering_Services/scheduler-list.txt"
                        //println(schedulersFile.getClass())  // Hashmap

                        inputFile.each { key, value ->
                            if(serviceFile.containsKey(key)){
                                    validServices.add(key)
                                    file1.append(key+"="+value+"\n")
                            }
                            else{
                                invalidServices.add(key)
                                file2.append(key+"="+value+"\n")
                            }
                        }
                        println("\u2713 Valid Services:\n ${validServices}")
                        println("\u2717 InValid Services:\n ${invalidServices}")
                        validServices.each{ item ->
                            if(schedulersFile.containsKey(item)){
                                validSchedulers.add(item)
                            }
                            else{
                                println("${item} not found on valid scheduler-list")
                            }
                        }
                        println("Valid Schedulers:\n ${validSchedulers}")
                        def VALID_SERVICES_ALL = readProperties file:"${file1}"
                        VALID_SERVICES_ALL.each{ key,value ->
                            if(validSchedulers.contains(key)){
                                file3.append(key+"="+value+"\n")
                            }
                            else{
                                file4.append(key+"="+value+"\n")
                            }
                        }

                     }//dir
                }//script
            }//steps
        }//stage
    }//stages
}//pipeline
