pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''export M2_HOME=/usr/local/Cellar/maven/3.3.3/libexec
export PATH=$PATH:$M2_HOME/bin'''

        sh '''mvn clean'''

        sh '''mvn package'''
      }
    }
  }
}