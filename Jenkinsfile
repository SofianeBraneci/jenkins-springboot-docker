pipeline{
    agent any
    stages{
        stage('compiling'){
            steps{
                echo "compiling the application"
                sh "mvn compile"
                echo "compiling done"
            }
        }

        stage('building'){
            steps{
                echo "Building the application"
                sh "mvn clean"
                sh "mvn build"
                echo "Project was built"
            }
        }

        stage("test"){
            steps{
                echo "Testing phase"
                sh "mvn test"
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
             }
        }
    }
}