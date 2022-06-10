/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexion {
  //*************************************Initiating our Connection
  // parameters******************************************

  private Connection cnx;
  /* public String url1="jdbc:sqlserver://devsecdv.mysql.database.azure.com";
   public String user1="root";
   public String pwd1 ="";*/
  public String url = "jdbc:mysql://localhost:3306/tunesport";
  public String user = "root";
  public String pwd = "";
  private static MaConnexion mc;

  //******************************Db Singleton Connectivity
  //*********************************

  private MaConnexion() {
    try {
      cnx = DriverManager.getConnection(url, user, pwd);
      // cnx=DriverManager.getConnection(url1, user1, pwd1);
      System.out.println("Connexion etablie");
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  //******************Insuring a single db connection***********************

  public static MaConnexion getInstance() {
    if (mc == null)
      mc = new MaConnexion();
    return mc;
  }

  //************Return our connection instance*********************

  public Connection getCnx() { return cnx; }
}
