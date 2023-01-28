pipeline {
    agent {
        label 'Slave-1'
    }


    stages {
        
        stage('Clean') {
            steps {
                echo 'Cleaning ....'
            
               bat "mvn clean"
            }
        }
        stage('Git Checkout') {
            steps {
                echo 'Get some code from a GitHub repository'
                git 'https://github.com/PivotITAcademy/30th-April-Selenium-Framework.git'
            }
        }
        
           stage('Test') {
            steps {
                echo 'Testing...'
                bat 'mvn test'
                
            }
           }
            
               stage('Install') {
            steps {
                echo 'Installing...'
                bat "mvn install -DskipTests=true"
            }
        }
        
              stage('Publish Result') {
            steps {
                echo 'Publishing Result...'
                testNG showFailedBuilds: true
            }
        }
        
        
    }
    post{
        success{
            archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false, onlyIfSuccessful: true
        }
        failure{
            echo 'Job has failed'
        }
        always{
            echo 'Sending Email'
        }
        
    }
}
