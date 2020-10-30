pipeline{
    agent any
    stages{
        stage('Initial') {
            steps{
                step([$class: 'WsCleanup'])
                script{
                    git credentialsId: 'github', url: 'https://github.com/snownguyen1011/Groovy-Work.git'
                    dir("$WORKSPACE"){
                    def file = readProperties file: "${WORKSPACE}/inputfile1.properties"
                        println(file.getClass())
                        println(file)
                }
            }

        }
    }
}
