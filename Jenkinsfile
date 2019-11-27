pipeline {
  agent {
    docker {
      image 'maven:3.6.1-jdk-8-alpine'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('Unit Tests') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Integration Testing') {
      steps {
        sh 'mvn verify'
      }
    }

  }
  environment {
    CI = 'true'
  }
}