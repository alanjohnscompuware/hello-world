pipeline {
    agent any
    
    environment { 
    // Jenkins credential ID and CES Personal Access token to be used for mainframe access
        Credentials_value = "CWCC_TSO_LOGIN"                        //  user used to connect to the HCI

        Connection_value = "CWCC_HCI"                               //  user used to connect to the HCI                                              
                                                                    // Jenkins login credential token - obtained from the 
                                                                    // Compuware Common Configurations Connection Id
                                                                    // for the HCI/LPAR definition being used
        MF_Source = "HUK0320.DEMO.COB.SRC3"                         //PDS containing just ALJOCOB source
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