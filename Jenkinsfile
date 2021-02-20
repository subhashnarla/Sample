node{
   stage('SCM Checkout'){
     git 'https://github.com/subhashnarla/Sample'
   }
   stage('Compile-Package'){
      def mvnHome = tool 'M3'
      // Get maven home path
     // def mvnHome =  tool name: 'M3', type: 'maven'   
     // sh "${mvnHome}/bin/mvn package"
      withEnv(["MVN_HOME=$mvnHome"]) {
           // if (isUnix()) {
             //   sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            //} else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
   }
   
   stage('SonarQube Analysis') {
       // def mvnHome =  tool name: 'M3', type: 'maven'
      def mvnHome = tool 'M3'
        withSonarQubeEnv('sonar') { 
          //sh "${mvnHome}/bin/mvn sonar:sonar"
            def sonarScanner = tool name: 'sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
              //bat "${sonarScanner}/bin/sonar-scanner -e -Dsonar.host.url=http://localhost:9000"
          bat "%mvnHome%\bin\mvn sonar:sonar"
        }
    }
   
   stage('Email Notification'){
      mail bcc: '', body: '''Hi Welcome to jenkins email alerts
      Thanks
      subhash''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'subhashnarla@gmail.com'
   }
   stage('Slack Notification'){
       slackSend baseUrl: 'https://hooks.slack.com/services/',
       channel: '#jenkins-pipeline-demo',
       color: 'good', 
       message: 'Welcome to Jenkins, Slack!', 
       teamDomain: 'javahomecloud',
       tokenCredentialId: 'slack-demo'
   }

}


