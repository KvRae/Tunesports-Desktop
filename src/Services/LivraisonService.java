package Services;

import Entities.Livraison;
import Tools.MaConnexion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivraisonService implements IService<Livraison> {
	 Connection cnx= MaConnexion.getInstance().getCnx();
	    private Statement ste ;

	@Override
	public void ajouter(Livraison L) {
		PreparedStatement pre;
	    try {
	        pre = cnx.prepareStatement("INSERT INTO livraison (adressel,prixP,idC,validation)VALUES (?,?,?,?);");
	        pre.setString(1, L.getAdressel());
	        pre.setDouble(2, L.getPrixp());
	        pre.setInt(3, L.getIdc());
                pre.setString(4, L.getValidation());

	        


	        pre.executeUpdate();
	        } catch (SQLException ex) {
	                        System.out.println(ex.getMessage());

	        }				
	}

	public boolean modifier(String adressel , Double prixP ,int idC , int idliv , String validation ) {
		try {
            PreparedStatement pre = cnx.prepareStatement("UPDATE livraison SET adressel= ?  , prixP = ?, idC = ? ,validation=? where idliv= ? ;");
            
            pre.setString(1, adressel);
	        pre.setDouble(2, prixP);
	        pre.setInt(3, idC);
                 pre.setString(4, validation);

            pre.setInt(5, idliv);




            if (pre.executeUpdate() != 0) {
                System.out.println(" livraison updated");
                 } else {
                System.out.println("non");
            }
                 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                return true;
	}

	@Override
	public void supprimer(Livraison L) {
		PreparedStatement pre;
	    try {
	        pre = cnx.prepareStatement("Delete from livraison where idliv=? ;");
	    
	        pre.setInt(1, L.getIdliv());
	        if (pre.executeUpdate() != 0) {
	            System.out.println("livraison Deleted");
	            
	        }else
	        System.out.println("idliv not found!!!");
	        } catch (SQLException ex) {
	                        System.out.println(ex.getMessage());

	            
	        }		
	}

	@Override
	public List<Livraison> afficher() {List<Livraison> Le = new ArrayList<>();
		try {
	    	ste = cnx.createStatement();
	    ResultSet rs = ste.executeQuery("select * from livraison");
	    while (rs.next()) {
	        int idliv=rs.getInt("idliv");
	        String adressel = rs.getString("adressel");
	        Double prixp=rs.getDouble("prixP");
	        int idc=rs.getInt("idC");
                	        String validation = rs.getString("validation");

                
	        

	        Livraison L = new Livraison(idliv,adressel,prixp,idc,validation);
	        Le.add(L);
	    }
	} catch (SQLException ex) {
	                        System.out.println(ex.getMessage());

	}
	return Le ;
	}
	
	public void pdf() throws FileNotFoundException, DocumentException {
		try {
		String file_name="C:\\Users\\firas\\OneDrive\\Bureau\\pdff\\firas.pdf";
		Document doc =new Document();
		PdfWriter.getInstance(doc, new FileOutputStream(file_name));
		doc.open();
		PreparedStatement ps=null;
		ResultSet rs=null;
		 String querry="SELECT * FROM livraison";
		
			ps=cnx.prepareStatement(querry);
			rs=ps.executeQuery();
			while(rs.next()) {
				Paragraph para=new Paragraph(rs.getInt("idliv")+" "+rs.getString("adressel")+" "+rs.getDouble("prixP")+" "+rs.getInt("idC")+" "+rs.getString("validation"));
		        doc.add(para);
		        doc.add(new Paragraph(" "));	
				
			}
			doc.close();
		
		 
		
		}catch(Exception E){
			System.err.println(E);
			
		}
		

	}

	public List<Livraison> recherche(Livraison L) {
        List<Livraison> liv = new ArrayList<>();
        String sql="SELECT * FROM livraison WHERE idliv ='"+L.getIdliv()+"'OR adressel='"+L.getAdressel()+"'";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Livraison mm = new Livraison();
                mm.setIdliv(rs.getInt("idliv"));
                mm.setAdressel(rs.getString("adressel"));
                mm.setPrixp(rs.getDouble("prixP"));
                mm.setIdc(rs.getInt("idC"));
                mm.setValidation(rs.getString("validation"));
                


                liv.add(mm);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return liv;
    }
	/*@Override
	public List<Livraison> trie() {
		List<Livraison> livraison = new ArrayList<>();
        String sql ="SELECT * FROM livraison ORDER BY idliv ASC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Livraison L =new Livraison();
               // p.setId(rs.getInt("id"));
                L.setIdliv(rs.getInt("idliv"));
                L.setAdressel(new Commande(rs.getString("adressel")));

                L.setPrixp(new Commande( rs.getDouble("PrixP")));
                L.setIdc( new Commande( rs.getInt("idC")));
                


               livraison.add(L);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return livraison ;				
	}

	@Override
	public List<Livraison> triedesc() {
		List<Livraison> livraison = new ArrayList<>();
        String sql ="SELECT * FROM livraison ORDER BY idliv DESC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Livraison L =new Livraison();
               // p.setId(rs.getInt("id"));
                L.setIdliv(rs.getInt("idliv"));
                L.setAdressel(new Commande(rs.getString("adressel")));

                L.setPrixp(new Commande( rs.getDouble("PrixP")));
                L.setIdc( new Commande( rs.getInt("idC")));

               livraison.add(L);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return livraison ;				
	}

    
	*/


    public List<Livraison> trie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Livraison> triedesc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Livraison t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    
    
    private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("livraison");
            message.setText("livraison ajoutée avec succes");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
              }
	public static void sendMail(String recepient) throws Exception{
        System.err.println("preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true"); 
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "firasmohsni5@gmail.com";
        String password = "firasmoh222";

        Session session = Session.getInstance(properties, new  Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(myAccountEmail, password);
        }
      });

         Message message = prepareMessage(session, myAccountEmail,recepient);

         Transport.send(message);
         System.out.println("message sent successfully");
    }
		
	}


