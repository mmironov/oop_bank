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
        steps {
                sh '''export M2_HOME=/usr/local/Cellar/maven/3.3.3/libexec
        export PATH=$PATH:$M2_HOME/bin

        mvn verify'''
        }
    }

    stage('Deliver for development') {
          steps {
            input 'Deliver for development? (Click "Proceed" to continue)'
          }
    }

    stage('Deploy to Production') {

                when {
                  branch 'master'
                }
                steps {

                input 'Do you want to deploy to production?'
            }
    }
}