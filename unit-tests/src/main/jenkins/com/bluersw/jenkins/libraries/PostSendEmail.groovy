@Library('shared-library') _

pipeline {
	agent any
	stages {
		stage('处理过程1') {
			steps {
				script{
					Exception ex
					runWrapper.loadJSON('/json/post-send-email.json')
				}
			}
		}
		stage('处理过程2') {
			steps {
				script{
					println('处理过程2')
				}
			}
		}
		stage('处理过程3') {
			steps {
				script{
					println('处理过程3')
				}
			}
		}
	}
	post {
		failure {
			script{
				runWrapper.postFailure(ex)
			}
		}
		success{
			script{
				runWrapper.postSuccess()
			}
		}
	}
}

