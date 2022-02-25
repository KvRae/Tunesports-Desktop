package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexion {

    private Connection cnx;
    public String url="jdbc:mysql://localhost:3306/esprit3A10";
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
