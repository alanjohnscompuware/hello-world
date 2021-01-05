pipeline {
    agent any
    parameters {
        // Jenkins pipeline name = BASIC_PIPELINE
            //This is a declaritive version of the jenkinsfile using pipeline, agent, stages, stage, steps
            //  
 
            // Jenkins credential ID and CES Personal Access token to be used for mainframe access
            string (defaultValue: "CWCC_TSO_LOGIN",
                 description: 'jenkins token for HUK0320 tso',
                 name: 'Credentials_value'                              //  user used to connect to the HCI

            string (defaultValue: "CWCC_HCI",
                 description: 'Jenkins login credential token',
                 name: 'Connection_value'                               //  user used to connect to the HCI                                              
                                                                        // Jenkins login credential token - obtained from the 
                                                                        // Compuware Common Configurations Connection Id
                                                                        // for the HCI/LPAR definition being used 

            string (defaultValue: "HUK0320.DEMO.COB.SRC3",
                 description: 'PDS containing just ALJOCOB source',
                 name: 'MF_Source'                                      //  user used to connect to the HCI
    }

    stages {
        stage('Get source code for automated analysis from PDS') {
            steps {
            // this is the modified version of the SCM plugin code created by the syntax generator 
            // between the curly brackets         
            checkout changelog: false, 
            poll: false, 
            scm: [$class:  'PdsConfiguration', 
            connectionId:  "${Connection_value}", 
            credentialsId: "${Credentials_value}", 
            fileExtension: 'CBL', 
            filterPattern: "${MF_Source}", 
            targetFolder:  '']
            }
        }
    } 
}