/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author achou
 */
public class MaConnexion {

    public static PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Connection cnx;
    public String url="jdbc:mysql://localhost:3306/tunesport";
    public String user="root";
    public String pwd ="";
    private static MaConnexion mc;

    private MaConnexion() {
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static MaConnexion getInstance(){
        if(mc==null)
        mc = new MaConnexion();
        return mc;
    
}

    public Connection getCnx() {
        return cnx;
    }
    
   
    
    
}
