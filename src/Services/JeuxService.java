/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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

import Entities.Jeux;
import Tools.MaConnexion;


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
	        pre.setString(3, J.getTaillejeux());
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
	        pre.setString(3, J.getTaillejeux());
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
	public List<Jeux> afficher() {
            List<Jeux> je = new ArrayList<>();
    try {
    	 ste = cnx.createStatement();
    ResultSet rs = ste.executeQuery("select *  from jeux");
    while (rs.next()) {
        int idjeux=rs.getInt("idjeux");
        String nomjeux = rs.getString("nomjeux");
        Date datesortjeux = rs.getDate("datesortjeux");

        String taillejeux = rs.getString("taillejeux");
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
    
	public List<Jeux> recherche(Jeux j) {
        List<Jeux> jeu = new ArrayList<>();
        String sql="SELECT * FROM jeux WHERE idjeux ='"+j.getIdjeux()+"'OR nomjeux='"+j.getNomjeux()+"'OR datesortjeux='"+j.getDatesortjeux()+"'";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Jeux mm = new Jeux();
                mm.setIdjeux(rs.getInt("idjeux"));
                mm.setNomjeux(rs.getString("nomjeux"));
                mm.setDatesortjeux(rs.getDate("datesortjeux"));
                mm.setTaillejeux(rs.getString("taillejeux"));
                mm.setDescjeux(rs.getString("descjeux"));
                mm.setPlatdispojeux(rs.getString("platdispojeux"));
                mm.setConreqjeux(rs.getString("conreqjeux"));


                jeu.add(mm);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return jeu;
    }


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
                J.setNomjeux(rs.getString("nomjeux"));
                J.setDatesortjeux(rs.getDate("datesortjeux"));
                J.setTaillejeux(rs.getString("taillejeux"));
                J.setDescjeux(rs.getString("descjeux"));
                J.setPlatdispojeux(rs.getString("platdispojeux"));
                J.setConreqjeux(rs.getString("conreqjeux"));

               jeux.add(J);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return jeux;		
	}


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
                J.setNomjeux(rs.getString("nomjeux"));
                J.setDatesortjeux(rs.getDate("datesortjeux"));
                J.setTaillejeux(rs.getString("taillejeux"));
                J.setDescjeux(rs.getString("descjeux"));
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
