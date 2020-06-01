package projet.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projet.beans.Endroit;
public class EndroitDB {
	public List<Endroit> getEndroits(){
		List<Endroit> endroits = new ArrayList<Endroit>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from endroit where validation=1;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Endroit end = new Endroit();
				end.setId_endroit(rs.getInt("id_endroit"));
				end.setNom_endroit(rs.getString("nom_endroit"));
				end.setVille_endroit(rs.getString("ville_endroit"));
				end.setLocation_endroit(rs.getString("localisation_endroit"));
				end.setImage_endroit(rs.getString("image_endroit"));
				end.setDescp_endroit(rs.getString("descp_endroit"));
				end.setId_prs(rs.getInt("id_prs"));
				end.setValidation(rs.getInt("validation"));
				endroits.add(end);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return endroits;
	}
	
	public List<Endroit> getEndroitAll(){
		List<Endroit> endroits = new ArrayList<Endroit>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from endroit;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Endroit end = new Endroit();
				end.setId_endroit(rs.getInt("id_endroit"));
				end.setNom_endroit(rs.getString("nom_endroit"));
				end.setVille_endroit(rs.getString("ville_endroit"));
				end.setLocation_endroit(rs.getString("localisation_endroit"));
				end.setImage_endroit(rs.getString("image_endroit"));
				end.setDescp_endroit(rs.getString("descp_endroit"));
				end.setId_prs(rs.getInt("id_prs"));
				end.setValidation(rs.getInt("validation"));
				endroits.add(end);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return endroits;
	}
	
	public String AddEndroit(Endroit e) {
		int rslt=0;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("Insert into endroit(id_endroit,id_prs,nom_endroit,ville_endroit,descp_endroit,localisation_endroit,"
					+ "image_endroit,validation) values(?,?,?,?,?,?,?,?);");
			ps.setString(1, null);
			ps.setInt(2, e.getId_prs());
			ps.setString(3, e.getNom_endroit());
			System.out.println("lol");
			ps.setString(4, e.getVille_endroit());
			System.out.println("lol");
			ps.setString(5, e.getDescp_endroit());
			System.out.println("lol");
			ps.setString(6, e.getLocation_endroit());
			System.out.println("lol");
			ps.setString(7, e.getImage_endroit());
			ps.setInt(8, 0);
			System.out.println("lol");
			rslt = ps.executeUpdate();
			System.out.println("lol");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		if(rslt!=0) {
			return "sc";
		}else return "fls";
	}
	
	public List<Endroit> getRandomEndroits(){
		List<Endroit> list = new ArrayList<Endroit>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from endroit order by RAND() Limit 4");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Endroit end = new Endroit();
				end.setId_endroit(rs.getInt("id_endroit"));
				end.setNom_endroit(rs.getString("nom_endroit"));
				end.setVille_endroit(rs.getString("ville_endroit"));
				end.setLocation_endroit(rs.getString("localisation_endroit"));
				end.setImage_endroit(rs.getString("image_endroit"));
				end.setDescp_endroit(rs.getString("descp_endroit"));
				list.add(end);
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Endroit> searchByVille(String ville){
		List<Endroit> ends = new ArrayList<Endroit>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from endroit where ville_endroit=?");
			ps.setString(1, ville);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Endroit end = new Endroit();
				end.setId_endroit(rs.getInt("id_endroit"));
				end.setNom_endroit(rs.getString("nom_endroit"));
				end.setVille_endroit(rs.getString("ville_endroit"));
				end.setLocation_endroit(rs.getString("localisation_endroit"));
				end.setImage_endroit(rs.getString("image_endroit"));
				end.setDescp_endroit(rs.getString("descp_endroit"));
				ends.add(end);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ends;
	}
	public int updateEndroit(int id) {
		int rowUpdated = 0;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("update endroit set validation=1 where id_endroit=?;");
			System.out.println("cole");
			
			ps.setInt(1, id);
			
			System.out.println("colee");
			rowUpdated= ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("so sorry");
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	public int deleteEndroit(int id) {
		int status = 0;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("delete from endroit where id_endroit=?;");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
