/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipmentManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

;

/**
 *
 * @author Prabhath
 */
public class sendSMS {
    
    /**
     *
     * @param var1
     * @param var2
     * @throws Exception
     */
    public  void sms(String var1,String var2) throws Exception {


URL textit = new URL("http://textit.biz/sendmsg/index.php?id=94767482482&pw=2878&to="+var1+"&text="+var2);
    try (BufferedReader in = new BufferedReader(
            new InputStreamReader(textit.openStream()))) {
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
    }
}
    
}
