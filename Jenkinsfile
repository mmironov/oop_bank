pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''export M2_HOME=/usr/local/Cellar/maven/3.3.3/libexec
export PATH=$PATH:$M2_HOME/bin

mvn clean
mvn package'''
      }
    }
    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            sh '''export M2_HOME=/usr/local/Cellar/maven/3.3.3/libexec
export PATH=$PATH:$M2_HOME/bin

mvn verify'''
          }
        }
        stage('Log') {
          steps {
            echo 'Testing....'
          }
        }
      }
    }
    stage('Deploy to Production') {

    when {
        branch 'dev'
    }
    steps {
        input message: 'Deliver for development? (Click "Proceed" to continue)'
    }
      steps {
        input 'Do you want to deploy to production?'
      }
    }
  }
}