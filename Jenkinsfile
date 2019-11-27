pipeline {
  agent {
    docker {
      image 'maven:3.6.1-jdk-8-alpine'
      args '-p "9000:9000"'
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