node{
    cleanWs()
    checkout scm
    checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false,
              extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'Filtering_Services']],
              submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: 'url']]])
    withEnv (['BASE_WORKSPACE=$WORKSPACE']) {
        load 'Filtering_Services/Jenkinsfile.groovy'
    }
}