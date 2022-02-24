/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Jeux;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;


/**
 *
 * @author Firas
 */
public class JeuxService  implements IService<Jeux>{
    Connection cnx= MaConnexion.getInstance().getCnx();
    private Statement ste ;



	@Override
	public void ajouter(Jeux J) {
		PreparedStatement pre;
	    try {
	        pre = cnx.prepareStatement("INSERT INTO jeux (nomjeux,datesortjeux,taillejeux,descjeux,platdispojeux,conreqjeux)VALUES (?,?,?,?,?,?);");
	        pre.setString(1, J.getNomjeux());
	        pre.setDate(2, J.getDatesortjeux());
	        pre.setInt(3, J.getTaillejeux());
	        pre.setString(4, J.getDescjeux());
	        pre.setString(5, J.getPlatdispojeux());
	        pre.setString(6, J.getConreqjeux());
	        


	        pre.executeUpdate();
	        } catch (SQLException ex) {
	                        System.out.println(ex.getMessage());

	        }		
	}

	@Override
	public void modifier(Jeux J) {
		try {
            PreparedStatement pre = cnx.prepareStatement("UPDATE jeux SET nomjeux= ? ,datesortjeux = ? , taillejeux = ?, descjeux = ?, platdispojeux = ?,conreqjeux=?  where idjeux= ? ;");
            pre.setString(1, J.getNomjeux());
	        pre.setDate(2, J.getDatesortjeux());
	        pre.setInt(3, J.getTaillejeux());
	        pre.setString(4, J.getDescjeux());
	        pre.setString(5, J.getPlatdispojeux());
	        pre.setString(6, J.getConreqjeux()); 
            pre.setInt(7, J.getIdjeux());   



            if (pre.executeUpdate() != 0) {
                System.out.println(" jeux updated");
                 } else {
                System.out.println("non");
            }
                 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }		
	}

	@Override
	public void supprimer(Jeux J) {
		 PreparedStatement pre;
		    try {
		        pre = cnx.prepareStatement("Delete from jeux where idjeux=? ;");
		    
		        pre.setInt(1, J.getIdjeux());
		        if (pre.executeUpdate() != 0) {
		            System.out.println("jeux Deleted");
		            
		        }else
		        System.out.println("idjeux not found!!!");
		        } catch (SQLException ex) {
		                        System.out.println(ex.getMessage());

		            
		        }
		
	}

	@Override
	public List<Jeux> afficher() {List<Jeux> je = new ArrayList<>();
    try {
    	ste = cnx.createStatement();
    ResultSet rs = ste.executeQuery("select *  from jeux");
    while (rs.next()) {
        int idjeux=rs.getInt("idjeux");
        String nomjeux = rs.getString("nomjeux");
        Date datesortjeux = rs.getDate("datesortjeux");

        int taillejeux = rs.getInt("taillejeux");
        String descjeux = rs.getString("descjeux");
        String platdispojeux = rs.getString("platdispojeux");
        String conreqjeux = rs.getString("conreqjeux");


        Jeux J = new Jeux(idjeux,nomjeux, datesortjeux, taillejeux ,descjeux,platdispojeux,conreqjeux);
        je.add(J);
    }
} catch (SQLException ex) {
                        System.out.println(ex.getMessage());

}
return je ;




		
	}
    
	public void recherche(Jeux J) {
        try{
    String sql="SELECT * FROM jeux WHERE idjeux = ?"; 
    PreparedStatement ste= cnx.prepareStatement(sql);
    ste.setInt(1,J.getIdjeux());
    ResultSet rst= ste.executeQuery();
    if (rst.next()) {
        int idjeux=rst.getInt("idjeux");
        String nomjeux = rst.getString("nomjeux");
        Date datesortjeux = rst.getDate("datesortjeux");

        int taillejeux = rst.getInt("taillejeux");
        String descjeux = rst.getString("descjeux");
        String platdispojeux = rst.getString("platdispojeux");
        String conreqjeux = rst.getString("conreqjeux");

        Jeux JE = new Jeux(idjeux,nomjeux, datesortjeux, taillejeux ,descjeux,platdispojeux,conreqjeux);
        System.out.println(JE);
    }  else{
            System.out.println("jeu non trouve");
       }
    }
 
	catch(SQLException ex){
     System.out.println(ex.getMessage());
 }

}

	@Override
	public List<Jeux> trie() {
		List<Jeux> jeux = new ArrayList<>();
        String sql ="SELECT * FROM jeux ORDER BY idjeux ASC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Jeux J =new Jeux();
               // p.setId(rs.getInt("id"));
                J.setIdjeux(rs.getInt("idjeux"));
                J.setNomjeux(rs.getString("nomevent"));
                J.setDatesortjeux(rs.getDate("datedebevent"));
                J.setTaillejeux(rs.getInt("datefinevent"));
                J.setDescjeux(rs.getString("descevent"));
                J.setPlatdispojeux(rs.getString("platdispojeux"));
                J.setConreqjeux(rs.getString("conreqjeux"));


               jeux.add(J);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return jeux;		
	}

	@Override
	public List<Jeux> triedesc() {
		List<Jeux> jeux = new ArrayList<>();
        String sql ="SELECT * FROM jeux ORDER BY idjeux DESC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Jeux J =new Jeux();
               // p.setId(rs.getInt("id"));
                J.setIdjeux(rs.getInt("idjeux"));
                J.setNomjeux(rs.getString("nomevent"));
                J.setDatesortjeux(rs.getDate("datedebevent"));
                J.setTaillejeux(rs.getInt("datefinevent"));
                J.setDescjeux(rs.getString("descevent"));
                J.setPlatdispojeux(rs.getString("platdispojeux"));
                J.setConreqjeux(rs.getString("conreqjeux"));


               jeux.add(J);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return jeux;				
	}

	
    
}
