pipeline {
  agent any
  environment { 
    LANG = 'C'
  }
  //triggers {
  //  pollSCM('H/2 * * * *')
  //}
  options {
    buildDiscarder(logRotator(numToKeepStr:'20'))
  }
  stages {

    // ----------------------------- CHECKOUT
    stage('checkout') {
        checkout scm
    }

    // ----------------------------- BUILD
    stage('build') {
      agent { docker { image 'dacr/jenkins-docker-agent-sbt' } }
      steps {
        sh 'sbt assembly'
      }
      post {
        success {
          archive '**/dummy.jar'
          junit 'target/junitresults/**/*.xml'
        }
      }
    }
  }

}
