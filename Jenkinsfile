pipeline {
   agent any

    environment {
        GIT_REPO = 'https://github.com/NacerKH/Montoring-containerization-springBoot-angular.git'
        BRANCH = 'main'
        DOCKER_IMAGE = 'nacerkh/devopsproject:backend-latest'
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
        SONARQUBE_ENV = 'SonarQube'
        SONARQUBE_PROJECT_KEY = 'NacerKH_Montoring-containerization-springBoot-angular_AY-Xciv7g-qPkHtLhErl'
        NEXUS_URL = 'http://localhost:8081/repository/maven-releases/'
        NEXUS_CREDENTIALS_ID = 'nexus-credentials'
        MAVEN_TOOL = 'mvn' // Maven tool name in Jenkins
        registryCredential = 'dockerhub'

    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: "${BRANCH}", url: "${GIT_REPO}"
            }
        }

        stage('Unit Test') {
            tools {
                maven "${MAVEN_TOOL}"
            }
            steps {
                dir('app/backend') {
                    sh 'mvn clean test'
                }
            }
        }


        stage('Build Application') {
            tools {
                maven "${MAVEN_TOOL}"
            }
            steps {
                dir('app/backend') {
                    sh 'mvn clean package'
                }
            }
        }
        
             stage('SonarQube Analysis') {
            environment {
                scannerHome = tool 'SonarQubeScanner' // SonarQube scanner tool name in Jenkins
            }
            
                   tools {
                maven "${MAVEN_TOOL}"
            }
            steps {
           
                dir('app/backend') {
                    withSonarQubeEnv(installationName :"${SONARQUBE_ENV}") {

                             sh "mvn clean verify sonar:sonar    -Dsonar.projectKey=${SONARQUBE_PROJECT_KEY} "

                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('app/backend') {
                    script {
               dockerImage = docker.build DOCKER_IMAGE


                    }
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    
                  docker.withRegistry( '', registryCredential ) {
dockerImage.push()
                }
                }
            }
        }

    
    }

    post {
        always {
            cleanWs()
        }
    }
}
