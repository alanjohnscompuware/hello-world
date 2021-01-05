#!/usr/bin/env groovy
//import hudson.model.*
//import hudson.EnvVars
//import groovy.json.JsonSlurperClassic
//import groovy.json.JsonBuilder
//import groovy.json.JsonOutput
//import java.net.URL

// Jenkins pipeline name = BASIC_PIPELINE
//This is a basic pipeline script to upload source into the Jenkins workspace from
// a mainframe PDS. This is useful as it checks the 
 
// Jenkins credential ID and CES Personal Access token to be used for mainframe access
String Credentials_value         = "CWCC_TSO_LOGIN"                 // jenkins token for HUK0320 tso user used to
                                                                    // connect to the HCI
String Connection_value      = "CWCC_HCI"                           // Jenkins login credential token - obtained from the 
                                                                    // Compuware Common Configurations Connection Id
                                                                    // for the HCI/LPAR definition being used 

// Source code directory defs
String MF_Source          = 'HUK0320.DEMO.COB.SRC3'    //PDS containing just ALJOCOB source

node
{
    stage('Get source code for automated analysis from PDS')
    {
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