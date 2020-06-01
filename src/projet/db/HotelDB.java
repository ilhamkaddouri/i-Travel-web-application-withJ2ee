package projet.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;



import projet.beans.Hotel;

public class HotelDB implements Serializable{
	public ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	public ArrayList<Hotel> getHotels(){
		return hotels;
	}
	//Extract hotels by city or stars 
	
		public ArrayList<Hotel> findvilles(String ville) {
			ArrayList<Hotel> list_hotels = new ArrayList<Hotel>();
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("select * from hotel where ville_hotel=?");
				ps.setString(3, ville);
				ResultSet res = ps.executeQuery();
				while(res.next()) {
					Hotel hotel = new Hotel();
					hotel.setId_hotel(res.getInt("id_hotel"));
		        	hotel.setNom_hotel(res.getString("nom_hotel"));
		        	hotel.setAdresse_hotel(res.getString("adresse_hotel"));
		        	hotel.setDescription(res.getString("description"));
		            hotel.setTel_hotel(res.getString("tel_hotel"));
		            hotel.setNbr_etoiles(res.getInt("nbr_etoiles"));
		            hotel.setImage_hotel(res.getString("image_hotel"));
		            
		            list_hotels.add(hotel);
				}
				cnx.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return list_hotels;	
		}
	
	
	//Get all hotels
	
	public List<Hotel> getAll(){

		ArrayList<Hotel> list_hotels = new ArrayList<Hotel>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from hotel");
			ResultSet st = ps.executeQuery();
			while(st.next()) {
				Hotel h = new Hotel();
				h.setId_hotel(st.getInt("id_hotel"));
	        	h.setNom_hotel(st.getString("nom_hotel"));
	            h.setVille_hotel(st.getString("ville_hotel"));
	            h.setNbr_etoiles(st.getInt("nbr_etoiles"));
	            h.setImage_hotel(st.getString("image_hotel"));
	            h.setAdresse_hotel(st.getString("adresse_hotel"));
	            h.setDescription(st.getString("description"));
	            h.setTel_hotel(st.getString("tel_hotel"));
	            list_hotels.add(h);
			}
			cnx.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	return list_hotels;	
	}
	
	//Show Hotels List

	//Find an hotel
	public Hotel find(int id) {
		Hotel hotel = null;
		try {
			Connection conn = ConnectionDB.loadDatabase();
			System.out.println("hi");
			PreparedStatement ps = conn.prepareStatement("SELECT * from hotel where id_hotel=?");
			ps.setInt(1, id);
			System.out.println("lol2");
			ResultSet rs = ps.executeQuery();
			System.out.println("helo");
			while (rs.next()) {
				String nom = rs.getString("nom_hotel");
				String adresse = rs.getString("adresse_hotel");
				String description = rs.getString("description");
				String ville = rs.getString("ville_hotel");
				String tel = rs.getString("tel_hotel");
				String image = rs.getString("image_hotel") ;
				int etoiles = rs.getInt("nbr_etoiles");
				int id_manger = rs.getInt("id_prs");
				System.out.println("cool");
				hotel = new Hotel(id, nom, adresse, ville, tel, description, etoiles, image,id_manger);
				System.out.println("piw");
			}
		}catch(Exception e) {
			System.out.println("die");
			e.printStackTrace();
		}
		return hotel;
	}
	
	//Insert an hotel
	public String AddHotel(Hotel h) {
		int rslt = 0;
		Connection cnx = ConnectionDB.loadDatabase();
		System.out.println("coll");
		try {
			System.out.println("hey");
			PreparedStatement ht = cnx.prepareStatement("Insert into hotel(id_hotel,nom_hotel,ville_hotel,adresse_hotel,"
					+ "tel_hotel,description,nbr_etoiles,image_hotel,id_prs) values(?,?,?,?,?,?,?,?,?);");
			
			ht.setString(1, null);
			ht.setString(2, h.getNom_hotel());
			ht.setString(3, h.getVille_hotel());
			ht.setString(4, h.getAdresse_hotel());
			System.out.println("pe");
			ht.setString(5, h.getTel_hotel());
			ht.setString(6, h.getDescription());
			ht.setInt(7, h.getNbr_etoiles());
			ht.setString(8, h.getImage_hotel());
			ht.setInt(9, h.getId_prs());
			rslt =  ht.executeUpdate();
			System.out.println("cooooool");
		}catch(Exception e) {
			System.out.println("sorry");
			e.printStackTrace();
		}
		if(rslt!=0) {
			return "sc";
		}else return "nn";
		
		
	}
	
	
	//Delete an hotel
	public boolean delete(int id) {
		try {
			Connection connex  = ConnectionDB.loadDatabase();
			PreparedStatement ps = connex.prepareStatement("DELETE from hotel where id_hotel="+id+";");
			int i = ps.executeUpdate();
			if(i ==1) {
				connex.close();
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Update an hotel
	public boolean update(Hotel hotel) {
		try {
			Connection conn = ConnectionDB.loadDatabase();
			PreparedStatement ps = conn.prepareStatement("UPDATE hotel set nom_hotel=?, adresse_hotel=?, ville_hotel=?,"
					+ " tel_hotel=?, description=?,"
					+ "nbr_etoiles=?, image_hotel=? where id_hotel=?;");
			ps.setString(1, hotel.getNom_hotel());
			ps.setString(2, hotel.getAdresse_hotel());
			ps.setString(3, hotel.getVille_hotel());
			ps.setString(4, hotel.getTel_hotel());
			ps.setString(5, hotel.getDescription());
			ps.setInt(6, hotel.getNbr_etoiles());
			ps.setString(7, hotel.getImage_hotel());
			ps.setInt(8, hotel.getId_hotel());
			int i = ps.executeUpdate();
			if(i == 1) {
				conn.close();
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
