package projet.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projet.beans.Hotel;

public class ShowHotelList {
	public List<Hotel> searchByPriceAndEtoiles(int price,int etoiles){
    	List<Hotel> hotels = new ArrayList<Hotel>();
    	String sql = null;
    	try {
    		Connection cnx = ConnectionDB.loadDatabase();
    		if(price == 500) {
    			
    			sql = "select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles,hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,(SUM(rating.rating)/count(rating.rating)) as a from hotel,rating,chambre where hotel.id_hotel=rating.id_hotel and hotel.id_hotel=chambre.id_hotel and chambre.prix_ch<'500' and hotel.nbr_etoiles=? group by hotel.id_hotel";
    		}
    		if(price == 1000) {
    			sql = "select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
						+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,"
						+ "(SUM(rating.rating)/"
						+ "count(rating.rating)) as a from hotel,rating,chambre where hotel.id_hotel=rating.id_hotel and"
						+ " hotel.id_hotel=chambre.id_hotel and chambre.prix_ch>=500 and chambre.prix_ch<1000 and hotel.nbr_etoiles=? group by hotel.id_hotel";
    		}
    		if(price == 1500) {
    			sql = "select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
						+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,"
						+ "(SUM(rating.rating)/"
						+ "count(rating.rating)) as a from hotel,rating,chambre where hotel.id_hotel=rating.id_hotel and"
						+ " hotel.id_hotel=chambre.id_hotel and chambre.prix_ch>1000 and chambre.prix_ch<1500 and hotel.nbr_etoiles=? group by hotel.id_hotel";
    		}
    		if(price == 2000) {
    			sql = "select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
						+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,"
						+ "(SUM(rating.rating)/count(rating.rating)) as a from hotel,rating,chambre where "
						+ "hotel.id_hotel=rating.id_hotel and"
						+ " hotel.id_hotel=chambre.id_hotel and chambre.prix_ch>=1500 and hotel.nbr_etoiles=? group by hotel.id_hotel";
    		}
			System.out.println(sql);
    		PreparedStatement ps = cnx.prepareStatement(sql);
    		System.out.println("2111111111111111111111");
    		ps.setInt(1, etoiles);
    		System.out.println("daaaamn");
    		ResultSet st = ps.executeQuery();
    		System.out.println("looooooooooooooooolllllllllllllll");
			while(st.next()) {
				System.out.println("laaa vie");
				Hotel h = new Hotel();
				System.out.println("laaa vidaaa");
				h.setId_hotel(st.getInt("id_hotel"));
	        	h.setNom_hotel(st.getString("nom_hotel"));
	            h.setVille_hotel(st.getString("ville_hotel"));
	            h.setNbr_etoiles(st.getInt("nbr_etoiles"));
	            h.setImage_hotel(st.getString("image_hotel"));
	            h.setAdresse_hotel(st.getString("adresse_hotel"));
	            h.setDescription(st.getString("description"));
	            h.setTel_hotel(st.getString("tel_hotel"));
	            h.setId_deal(st.getInt("id_deal"));
	            System.out.println("bitcjessssssss");
	            h.setRating(st.getString("a").substring(0, 3));
	            hotels.add(h);}
	            
    	}catch(Exception e) {
    		
    	}
    	return hotels;
    }
	public ArrayList<Hotel> ShowList() {
		ArrayList<Hotel> list_hotels = new ArrayList<>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
					+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,(SUM(rating.rating)/"
					+ "count(rating.rating)) as a from hotel,rating where hotel.id_hotel=rating.id_hotel group by hotel.id_hotel");
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
	            h.setId_deal(st.getInt("id_deal"));
	            h.setRating(st.getString("a").substring(0, 3));
	            list_hotels.add(h);
			}
			cnx.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	return list_hotels;	
	}
		
		public Hotel findHotelById(int id) {
			Hotel h = new Hotel();
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("select id_hotel,nom_hotel, ville_hotel, nbr_etoiles, image_hotel, adresse_hotel,"
						+ "description, tel_hotel from hotel where id_hotel=?");
				ps.setInt(1, id);
				ResultSet st = ps.executeQuery();
				if(st.next()) {
					h.setId_hotel(st.getInt("id_hotel"));
		        	h.setNom_hotel(st.getString("nom_hotel"));
		            h.setVille_hotel(st.getString("ville_hotel"));
		            h.setNbr_etoiles(st.getInt("nbr_etoiles"));
		            h.setImage_hotel(st.getString("image_hotel"));
		            h.setAdresse_hotel(st.getString("adresse_hotel"));
		            h.setDescription(st.getString("description"));
		            h.setTel_hotel(st.getString("tel_hotel"));
		           
				}
				
			}catch(Exception e) {
				
			}
				return h;
		}
		
		public Hotel getHotelManager(int id) {
			Hotel hotel = new Hotel();
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				System.out.println("plala");
				PreparedStatement ps = cnx.prepareStatement("select personne.id_prs,hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel,hotel.adresse_hotel,hotel.tel_hotel"
						+ ", hotel.description, hotel.image_hotel,hotel.nbr_etoiles from hotel,personne where hotel.id_prs=personne.id_prs and hotel.id_prs=?;");
				ps.setInt(1, id);
				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				System.out.println(rs);
				
				if(rs.next()) {
					
					hotel.setId_hotel(rs.getInt("id_hotel"));
					hotel.setNom_hotel(rs.getString("nom_hotel"));
					hotel.setVille_hotel(rs.getString("ville_hotel"));
					hotel.setNbr_etoiles(rs.getInt("nbr_etoiles"));
					hotel.setImage_hotel(rs.getString("image_hotel"));
					hotel.setAdresse_hotel(rs.getString("adresse_hotel"));
					hotel.setDescription(rs.getString("description"));
					hotel.setTel_hotel(rs.getString("tel_hotel"));
					hotel.setId_prs(rs.getInt("id_prs"));
					System.out.println(hotel.getAdresse_hotel());
					System.out.println(hotel.getId_prs());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return hotel;
		}
		
		//Update hotel data
		public int updateHotel(Hotel h) {
			int rowUpdated = 0;
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("update hotel set nom_hotel=?, ville_hotel=?,nbr_etoiles=?,"
						+ "adresse_hotel=?,description=?, tel_hotel=?  where id_hotel=?;");
				System.out.println("cole");
				ps.setString(1, h.getNom_hotel());
				ps.setString(2, h.getVille_hotel());
				ps.setInt(3, h.getNbr_etoiles());
				
				ps.setString(4, h.getAdresse_hotel());
				ps.setString(5, h.getDescription());
				ps.setString(6, h.getTel_hotel());
				
				ps.setInt(7, h.getId_hotel());
				System.out.println("colee");
				rowUpdated= ps.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("so sorry");
				e.printStackTrace();
			}
			return rowUpdated;
		}
		
		public int deleteHotel(int id) {
			int status = 0;
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("delete from hotel where id_hotel=?;");
				ps.setInt(1, id);
				status = ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return status;
		}
		
		
	    public List<Hotel> GetRandomHotels(){
	    	List<Hotel> lists = new ArrayList<Hotel>();
	    	try {
	    		Connection cnx = ConnectionDB.loadDatabase();
	    		PreparedStatement ps = cnx.prepareStatement("select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles,"
	    				+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,"
	    				+ "(SUM(rating.rating)/count(rating.rating)) as a from hotel,rating where hotel.id_hotel=rating.id_hotel "
	    				+ "group by hotel.id_hotel order by RAND() LIMIT 5");
	    		System.out.println("hotel");
	    		ResultSet st = ps.executeQuery();
	    		while(st.next()) {
	    			Hotel h = new Hotel();
	    			System.out.println("in");
	    			h.setId_hotel(st.getInt("id_hotel"));
		        	h.setNom_hotel(st.getString("nom_hotel"));
		            h.setVille_hotel(st.getString("ville_hotel"));
		            h.setNbr_etoiles(st.getInt("nbr_etoiles"));
		            h.setImage_hotel(st.getString("image_hotel"));
		            h.setAdresse_hotel(st.getString("adresse_hotel"));
		            h.setDescription(st.getString("description"));
		            h.setTel_hotel(st.getString("tel_hotel"));
		            h.setId_deal(st.getInt("id_deal"));
		            h.setRating(st.getString("a").substring(0, 3));
		            System.out.println("out");
		            lists.add(h);
	    		}
	    		
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return lists;
	    	
	    }
//	    public ArrayList<Hotel> SearchHotels(String ville, Date dateinit, Date dateend, String prs, String ch) {
//			ArrayList<Hotel> hotels_list = new ArrayList<Hotel>();
//			try {
//				Connection cnx = ConnectionDB.loadDatabase();
//				PreparedStatement ps = cnx.prepareStatement("select hotel.id_hotel, hotel.nom_hotel, hotel.ville_hotel,hotel.nbr_etoiles, hotel.image_hotel,"
//						+ "hotel.adresse_hotel, hotel.description, hotel.tel_hotel, hotel.id_prs, hotel.id_deal from hotel,chambre where "
//						+ "hotel.id_hotel=chambre.id_hotel and hotel.ville_hotel=? and chambre.nbr_pers=? and chambre.type_ch=? and "
//						+ "chambre.id_ch NOT IN (select DISTINCT id_ch from reservation where ("+dateinit+" between date_arr and date_dep) AND( "+dateend
//					+" between date_arr and date_dep) );");
//				ps.setString(1, ville);
//				
//				ps.setString(2, prs);
//				ps.setString(3, ch);
//				System.out.println("hello world");
//				ResultSet st = ps.executeQuery();
//				System.out.println("hello world 1");
//				while(st.next()) {
//					System.out.println("hello world 2");
//					Hotel hot = new Hotel();
//					System.out.println("hello world 3");
//					hot.setId_hotel(st.getInt("id_hotel"));
//		        	hot.setNom_hotel(st.getString("nom_hotel"));
//		            hot.setVille_hotel(st.getString("ville_hotel"));
//		            hot.setNbr_etoiles(st.getString("nbr_etoiles"));
//		            System.out.println("hello world 4");
//		            hot.setImage_hotel(st.getString("image_hotel"));
//		            hot.setAdresse_hotel(st.getString("adresse_hotel"));
//		            hot.setDescription(st.getString("description"));
//		            hot.setTel_hotel(st.getString("tel_hotel"));
//		            hot.setId_prs(st.getInt("id_prs"));
//		            hot.setId_deal(st.getInt("id_deal"));
//		            System.out.println("hello world 5");
//		            hotels_list.add(hot);
//		            System.out.println("hello world 6");
//		            
//				}
//				cnx.close();
//			
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		return hotels_list;	
//		}
	    public ArrayList<Hotel> SearchHotels(String ville, Date dateinit, Date dateend, String prs, String ch) {
			ArrayList<Hotel> hotels_list = new ArrayList<Hotel>();
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("select * from hotel,chambre where "
						+ "hotel.id_hotel=chambre.id_hotel and hotel.ville_hotel=? and chambre.nbr_pers=? and chambre.type_ch=? and "
						+ "chambre.id_ch NOT IN (select DISTINCT id_ch from reservation where ("+dateinit+" between date_arr and date_dep) AND( "+dateend
					+" between date_arr and date_dep) )");
				ps.setString(1, ville);
				
				ps.setString(2, prs);
				ps.setString(3, ch);
				System.out.println("hello world");
				ResultSet st = ps.executeQuery();
				System.out.println("hello world 1");
				while(st.next()) {
					System.out.println("hello world 2");
					Hotel hot = new Hotel();
					System.out.println("hello world 3");
					hot.setId_hotel(st.getInt("id_hotel"));
		        	hot.setNom_hotel(st.getString("nom_hotel"));
		            hot.setVille_hotel(st.getString("ville_hotel"));
		            hot.setNbr_etoiles(st.getInt("nbr_etoiles"));
		            System.out.println("hello world 4");
		            hot.setImage_hotel(st.getString("image_hotel"));
		            hot.setAdresse_hotel(st.getString("adresse_hotel"));
		            hot.setDescription(st.getString("description"));
		            hot.setTel_hotel(st.getString("tel_hotel"));
		            hot.setId_prs(st.getInt("id_prs"));
		            hot.setId_deal(st.getInt("id_deal"));
		            System.out.println("hello world 5");
		            hotels_list.add(hot);
		            System.out.println("hello world 6");
		            
				}
				cnx.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return hotels_list;	
		}
	    public List<Hotel> searchByEtoiles(int etoiles){
	    	List<Hotel> hotels = new ArrayList<Hotel>();
	    	try {
	    		Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
						+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,(SUM(rating.rating)/"
						+ "count(rating.rating)) as a from hotel,rating where hotel.id_hotel=rating.id_hotel and hotel.nbr_etoiles=? group by hotel.id_hotel");
				ps.setInt(1, etoiles);
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
		            h.setId_deal(st.getInt("id_deal"));
		            h.setRating(st.getString("a").substring(0, 3));
		            hotels.add(h);}
		            
	    	}catch(Exception e) {
	    		
	    	}
	    	return hotels;
	    }
	    
	    public List<Hotel> searchByPrice(int price){
	    	List<Hotel> hotels = new ArrayList<Hotel>();
	    	String sql = null;
	    	try {
	    		Connection cnx = ConnectionDB.loadDatabase();
	    		if(price == 500) {
	    			
	    			sql = "select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
							+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,(SUM(rating.rating)/"
							+ "count(rating.rating)) as a from hotel,chambre where"
							+ " hotel.id_hotel=chambre.id_hotel and chambre.prix_ch<500";
	    			
	    		}
	    		else if(price == 1000) {
	    			sql = "select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
							+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,"
							+ "(SUM(rating.rating)/"
							+ "count(rating.rating)) as a from hotel,rating where hotel.id_hotel=rating.id_hotel and hotel.id_hotel=chambre.id_hotel "
							+ "and chambre.prix_ch>=500 and chambre.prix_ch<1000  group by hotel.id_hotel";
	    		}
	    		else if(price == 1500) {
	    			sql = "select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
							+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,"
							+ "(SUM(rating.rating)/"
							+ "count(rating.rating)) as a from hotel,rating where hotel.id_hotel=rating.id_hotel and"
							+ " hotel.id_hotel=chambre.id_hotel and chambre.prix_ch>=1000 and chambre.prix_ch<1500  group by hotel.id_hotel";
	    		}
	    		else if(price == 2000) {
	    			sql = "select hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel, hotel.nbr_etoiles, "
							+ "hotel.image_hotel, hotel.adresse_hotel,hotel.description, hotel.tel_hotel, hotel.id_deal,"
							+ "(SUM(rating.rating)/"
							+ "count(rating.rating)) as a from hotel,rating where hotel.id_hotel=rating.id_hotel and"
							+ "hotel.id_hotel=chambre.id_hotel and chambre.prix_ch>1500 group by hotel.id_hotel";
	    		}
	    		System.out.println("heeeeeeeeeeeeeyy");
				System.out.println(sql);
	    		PreparedStatement ps = cnx.prepareStatement(sql);
	    		ResultSet st = ps.executeQuery();
	    		System.out.println("faaaamn");
				while(st.next()) {
					System.out.println("hola bab");
					Hotel h = new Hotel();
					System.out.println("lalaaala1");
					h.setId_hotel(st.getInt("id_hotel"));
					System.out.println("lalaaala2");
		        	h.setNom_hotel(st.getString("nom_hotel"));
		        	System.out.println("lalaaala3");
		            h.setVille_hotel(st.getString("ville_hotel"));
		            System.out.println("lalaaala4");
		            h.setNbr_etoiles(st.getInt("nbr_etoiles"));
		            System.out.println("lalaaala5");
		            h.setImage_hotel(st.getString("image_hotel"));
		            System.out.println("lalaaala6");
		            h.setAdresse_hotel(st.getString("adresse_hotel"));
		            System.out.println("lalaaala7");
		            h.setDescription(st.getString("description"));
		            System.out.println("lalaaala8");
		            h.setTel_hotel(st.getString("tel_hotel"));
		            System.out.println("lalaaala9");
		            h.setId_deal(st.getInt("id_deal"));
		            System.out.println("lalaaala10");
		            h.setRating(st.getString("a").substring(0, 3));
		            hotels.add(h);}
		            
	    	}catch(Exception e) {
	    		
	    	}
	    	return hotels;
	    }
	 
}

