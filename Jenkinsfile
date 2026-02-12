pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps { git 'https://github.com/shreychoudhary/E2EAutomation.git' }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
                
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml'
        }
    }
}
