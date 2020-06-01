package projet.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import projet.beans.HotelReview;

public class ReviewDB {
	public List<HotelReview> getReviews(int id_hotel){
		List<HotelReview> reviews = new ArrayList<HotelReview>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from review where id_hotel=?");
			ps.setInt(1, id_hotel);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HotelReview hr = new HotelReview();
				hr.setMessage(rs.getString("message"));
				hr.setId_hotel(rs.getInt("id_hotel"));
				hr.setId_review(rs.getInt("id_review"));
				hr.setId_prs(rs.getInt("id_prs"));
				reviews.add(hr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return reviews;
	}
	
	public void AddReview(String message,int id_hotel, int id_prs) {
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("insert into review(id_review,message,id_prs,id_hotel) values(?,?,?,?)");
			ps.setString(1, null);
			ps.setString(2, message);
			ps.setInt(3, id_prs);
			ps.setInt(4, id_hotel);
			int s = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
