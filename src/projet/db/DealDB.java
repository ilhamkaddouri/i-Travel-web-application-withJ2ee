package projet.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import projet.beans.Deal;

public class DealDB {
	
	//Ajouter un Deal
	
	public String AjouterDeal(Deal d) {
		int result=0;
		Connection cnx = ConnectionDB.loadDatabase();
		try {
		PreparedStatement st = cnx.prepareStatement("Insert into deals (id_deal,desc_deal,type_deal) values (?,?,?);");
		st.setString(1, null);
		st.setString(2, d.getDesc_deal());
		st.setString(3, d.getType_deal());
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
	
	public ArrayList<Deal> ShowDeal(){
		ArrayList<Deal> list_deals = new ArrayList<Deal>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from deals");
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				Deal deal = new Deal();
				deal.setId_deal(res.getInt("id_deal"));
				deal.setDesc_deal(res.getString("desc_deal"));
				deal.setType_deal(res.getString("type_deal"));
	            list_deals.add(deal);

			}
			cnx.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list_deals;
	}
	
	public ArrayList<Deal> ShowDealId(int id_hotel){
		ArrayList<Deal> deals = new ArrayList<Deal>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select deals.id_deal, deals.desc_deal, deals.type_deal from deals,hotel where deals.id_deal=hotel.id_deal and hotel.id_hotel=?");
			ps.setInt(1, id_hotel);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				Deal deal = new Deal();
				deal.setId_deal(res.getInt("id_deal"));
				deal.setType_deal(res.getString("type_deal"));
				deal.setDesc_deal(res.getString("desc_deal"));
	            deals.add(deal);

			}
			cnx.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return deals;
	}
	
	public Deal ShowDealByID(int id_deal) {
		Deal deal = new Deal();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from deals where id_deal=?");
			ps.setInt(1, id_deal);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				deal.setId_deal(res.getInt("id_deal"));
				deal.setType_deal(res.getString("type_deal"));
				deal.setDesc_deal(res.getString("desc_deal"));

			}
			cnx.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return deal;
	}
	
	//Mettre a jour un deal 
	public int updateDeal(Deal deal) {
		int i =0;
		try {
			Connection conn = ConnectionDB.loadDatabase();
			System.out.println("first one");
			PreparedStatement ps = conn.prepareStatement("UPDATE deals set desc_deal=?, type_deal=? where id_deal=?");
			System.out.println("second one");
			ps.setString(1, deal.getDesc_deal());
			ps.setString(2, deal.getType_deal());
			ps.setInt(3, deal.getId_deal());
			System.out.println("third one");
			i = ps.executeUpdate();
			System.out.println("fourth one");
			System.out.println(deal.getDesc_deal());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//Supprimer un deal
	
	public int deleteDeal(int id) {
		int i =0;
		try {
			Connection connex  = ConnectionDB.loadDatabase();
			PreparedStatement ps = connex.prepareStatement("DELETE from deals where id_deal="+id+";");
			i = ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}

