/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_records_mng_sys;

import MainWindow.Mainwindow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author S.Jayasinghe
 */
public class Patient_Records_Mng_Sys extends javax.swing.JFrame {
static String testv="HelloMoto!";
static String patient_id=" ";
static String patient_name=" ";
static String telephone="";
static String username="Dr.Sunil";
static String level="Admin";
static String session="";
static int key=0;
public static Mainwindow home;
//DataBase//
static String user="itp";
static String pass="itp";

public static void setReset(){
    patient_id="";
    
};

//DB // 
/*
    static Connection conn = null;
    static dbconnect connClass;
    //static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;
 */   

// DB //
public void setUserGroup(String user,int levels){
    username=user;
    if(100==levels){
        level="Admin";
        
    }
    else if(75==levels){
          level="Doctor";
    }
    else if(60==levels){
           level="Nurse/Medical Receptionist";
    }
    
    else
          level="Unknown";
    
};
 
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        
        
        
    }
 
    /**
     *
     * @param user
     * @param pass
     */
  
   

}
    
    

