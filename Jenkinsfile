pipeline{
    agent any
    tools{
        maven  "maven"
        dockerTool "docker"
    }
    stages{
        stage('compiling'){
            steps{
                echo "compiling the application"
                sh "mvn clean"
                sh "mvn compile"
                echo "compiling done"
            }
        }

        stage("test"){
            steps{
                echo "Testing phase"
                sh "mvn test"
                echo "Testing done"

            }
        }
        stage("package"){
            steps{
                echo "packaging the app into a jar file"
                sh "mvn package"
            }
        }
        stage("deploy"){
             steps{
                echo "deploying to docker"
                sh "docker build --tag=server:latest"
                sh "docker run -d -p 8081:8081 server:latest"
             }
        }
    }
}