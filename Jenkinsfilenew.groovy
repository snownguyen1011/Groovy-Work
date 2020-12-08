pipeline {
    agent any
    //parameters {
    //string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    //}
    stages {
        stage('Filter_Services') {
            steps {
                script {
                    git credentialsId: 'github', url: 'https://github.com/snownguyen1011/Groovy-Work.git'
//                    Def jenkinsFileNew = fileLoader.fromGit('Filtering_Services/Jenkinsfile.groovy', 'https://github.com/snownguyen1011/Groovy-Work.git', 'master', null, '')
//                    jenkinsFileNew.start()
                    dir("$WORKSPACE") {
                        A = load 'Filtering_Services/Jenkinsfile.groovy'
                        A.start()
                    }//dir
                }//script
            }//steps
        }//stage
    }//stages
}//pipeline