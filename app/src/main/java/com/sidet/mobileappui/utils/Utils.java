package com.sidet.mobileappui.utils;

import com.sidet.mobileappui.apis.SMSAPIs;
import com.sidet.mobileappui.apis.SMSClientAPIs;


public class Utils {
    public static SMSAPIs getClientsAPIs(){
        return  SMSClientAPIs.getSMSClientAPIs().create(SMSAPIs.class);
    }
}
