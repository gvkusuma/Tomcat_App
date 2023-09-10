pipeline
{
    agent any
    stages{
        stage('Build Application')
        {
        steps{
            echo "Build the project"
            sh 'mvn clean package'
        }
        post{
            success 
            {
                echo "Archive the artifacts"
                archiveArtifacts artifacts: '**/*.war'
            }
        }
        }
        stage('Deploy in Staging environment')
        {
        steps{
            echo "Deploy the project"
            build job: 'Deploy_staging_app'
        }
        }
         stage('Deploy in Prod environment')
        {
        steps{
            timeout(time:5, unit:'DAYS')
            {
                input message:"Approve production deployment"
            }
          echo "Deploy the project"
            build job: 'Deploy_prod_tomcat_app'
        }
        }
    }
}
