pipeline{
    agent any
    stages{
        stage('compiling'){
            steps{
                echo "compiling the application"
               withMaven{
                 sh "mvn --version"
                 sh "mvn compile"
               }
                echo "compiling done"
            }
        }

        stage('building'){
            steps{
                echo "Building the application"
                withMaven{
                    sh "mvn clean"
                    sh "mvn build"
                }
                echo "Project was built"
            }
        }

        stage("test"){
            steps{
                echo "Testing phase"
                withMaven{
                    sh "mvn test"
                }
            }
        }
        stage("package"){
            steps{
                echo "packaging the app into a jar file"
                withMaven{
                    sh "mvn package"
                }
            }
        }
        stage("deploy"){
             steps{
                echo "deploying to docker"
             }
        }
    }
}