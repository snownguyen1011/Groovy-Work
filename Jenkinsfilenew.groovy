node{
    cleanWs()
    checkout scm
    checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false,
              extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'Filtering_Services']],
              submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/snownguyen1011/Groovy-Work.git']]])
    withEnv (['BASE_WORKSPACE=$WORKSPACE']) {
        load 'Filtering_Services/Filtering_Services/Jenkinsfile.groovy'
    }
}