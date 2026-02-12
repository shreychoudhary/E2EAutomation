pipeline {
    agent any

    tools {
        maven 'Maven-3.9'     // Must match Global Tool Configuration name
        jdk 'JDK17'        // Must match Global Tool Configuration name
    }

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/shreychoudhary/E2EAutomation.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        success {
            echo 'Build Successful ✅'
        }

        failure {
            echo 'Build Failed ❌'
        }

        always {
            // Archive TestNG XML results
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml', fingerprint: true

            // Archive full test-output folder
            archiveArtifacts artifacts: 'test-output/**', fingerprint: true

            // Publish Extent HTML Report
            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'ExtentReport.html',
                reportName: 'Automation Report'
            ])
        }
    }
}
