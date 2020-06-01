package projet.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projet.beans.Deal;
import projet.beans.Rating;

public class RatingDB {
	//Ajouter un Deal
	
		public String AjouterRating(int id_hotel,int rating) {
			int result=0;
			Connection cnx = ConnectionDB.loadDatabase();
			try {
			PreparedStatement st = cnx.prepareStatement("Insert into rating (id_hotel,rating) values (?,?);");
			st.setInt(1, id_hotel);
			st.setInt(2, rating);
			result = st.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			if(result!=0) {
				return "sc";
			}else return "nn";
		}
		
		//Select deals
		
		public ArrayList<Rating> Calculate(){
			ArrayList<Rating> ratings = new ArrayList<Rating>();
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("Select SUM(rating.rating)/count(rating.rating) from rating where rating.id_hotel=?");
				ResultSet res = ps.executeQuery();
				while(res.next()) {
					Rating rating = new Rating();
					rating.setId_hotel(res.getInt("id_hotel"));
					rating.setRating(res.getInt("rating"));
		            ratings.add(rating);

				}
				cnx.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return ratings;
		}
}
