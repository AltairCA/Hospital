/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_records_mng_sys;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

;

/**
 *
 * @author S.Jayasinghe
 */
public class sms {
    
public  void sms(String var1,String var2) throws Exception {

try{
URL textit = new URL("http://textit.biz/sendmsg/index.php?id=94767482482&pw=2878&to="+var1+"&text="+var2);
BufferedReader in = new BufferedReader(
new InputStreamReader(textit.openStream()));


String inputLine;
while ((inputLine = in.readLine()) != null)
System.out.println(inputLine);
in.close();
}catch(Exception e){
    System.out.println("Internet Connection Not Available,SMS process failed therefore");
}
}
    
}
