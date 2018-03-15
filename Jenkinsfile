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
        stage('Debug Log') {
          steps {
            echo 'Logging...'
          }
        }
      }
    }
    stage('Deliver for development') {
      when {
        branch 'dev'
      }
      steps {
        input 'Deliver for development? (Click "Proceed" to continue)'
      }
    }
    stage('Deploy for production') {
      when {
        branch 'master'
      }
      steps {
        input 'Deliver for production? (Click "Proceed" to continue)'
      }
    }
  }
}