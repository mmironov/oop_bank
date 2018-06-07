pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''sh \'\'\'export M2_HOME=/usr/local/Cellar/maven/3.3.3/libexec
export PATH=$PATH:$M2_HOME/bin
	
mvn clean
mvn package\'\'\''''
      }
    }
    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            sh '''sh \'\'\'export M2_HOME=/usr/local/Cellar/maven/3.3.3/libexec
            export PATH=$PATH:$M2_HOME/bin

            mvn verify\'\'\''''
          }
        }
        stage('Log') {
          steps {
            echo 'Testing'
          }
        }
      }
    }
  }
}