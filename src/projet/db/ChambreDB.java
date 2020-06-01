package projet.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import projet.beans.Chambre;
import projet.beans.Hotel;

public class ChambreDB {
	
	
	public List<Chambre> getRoomsById(int id_hotel){
		List<Chambre> rooms = new ArrayList<Chambre>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			System.out.println("jeu");
			PreparedStatement ps = cnx.prepareStatement("select * from chambre where id_hotel=? and etat_ch=0;");
			ps.setInt(1, id_hotel);
			System.out.println("fie");
			ResultSet rs = ps.executeQuery();
			System.out.println("yew");
			while(rs.next()) {
				Chambre room = new Chambre();
				System.out.println("ppopo");
				room.setId_ch(rs.getInt("id_ch"));
				room.setId_hotel(rs.getInt("id_hotel"));
				
				System.out.println("lalal");
				System.out.println("lalal");
				room.setNbr_pers(rs.getInt("nbr_pers"));
				System.out.println("lalal");
				room.setEtat_ch(rs.getInt("etat_ch"));
				room.setSuperfice(rs.getString("superfice"));
				System.out.println("lalal");
				room.setDescp_ch(rs.getString("descp_ch"));
				System.out.println("lalal");
				room.setPrix_ch(rs.getString("prix_ch"));
				System.out.println("lalal");
				room.setType_ch(rs.getInt("type_ch"));
				System.out.println("psak");
				room.setImage_ch(rs.getString("image_ch"));
				room.setTitre_ch(rs.getString("titre_ch"));
				rooms.add(room);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return rooms;
	}
	
	public Chambre findRoomById(int id) {
		Chambre room = new Chambre();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			System.out.println("jeu");
			PreparedStatement ps = cnx.prepareStatement("select * from chambre where id_ch = ?;");
			ps.setInt(1, id);
			System.out.println("fie");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			
				System.out.println("1");
				room.setId_ch(rs.getInt("id_ch"));
				room.setId_hotel(rs.getInt("id_hotel"));
				
				room.setNbr_pers(rs.getInt("nbr_pers"));
				System.out.println("5");
				room.setEtat_ch(rs.getInt("etat_ch"));
				room.setSuperfice(rs.getString("superfice"));
				System.out.println("6");
				room.setDescp_ch(rs.getString("descp_ch"));
				System.out.println("7");
				room.setPrix_ch(rs.getString("prix_ch"));
				System.out.println("8");
				room.setType_ch(rs.getInt("type_ch"));
				System.out.println("9");
				room.setImage_ch(rs.getString("image_ch"));
				room.setTitre_ch(rs.getString("titre_ch"));
						
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return room;
	}
	
	public ArrayList<Chambre> SearchHotels(int id_hotel, Date date_init, Date date_end, String prs, String ch) {
		ArrayList<Chambre> rooms_list = new ArrayList<Chambre>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from chambre where id_hotel = ? and etat_ch=0 and nbr_pers=? and type_ch=? and id_ch"
					+ " NOT IN (select DISTINCT id_ch from reservation where ("+date_init+" between date_arr and date_dep) AND ("
							+ date_end+" between date_arr and date_dep))");
			System.out.println("hhhhh");
			ps.setInt(1, id_hotel);
			System.out.println("hhhh");
			ps.setString(2, prs);
			System.out.println("hhh");
			ps.setString(3, ch);
			System.out.println("hh");
			ResultSet rs = ps.executeQuery();
			System.out.println("h");
			while(rs.next()) {
				System.out.println("9");
				Chambre room = new Chambre();
				System.out.println("9");
				room.setId_ch(rs.getInt("id_ch"));
				System.out.println(rs.getInt("id_ch"));
				room.setId_hotel(rs.getInt("id_hotel"));
				System.out.println("9");
				
				System.out.println("9");
				room.setNbr_pers(rs.getInt("nbr_pers"));
				System.out.println("5");
				room.setEtat_ch(rs.getInt("etat_ch"));
				room.setSuperfice(rs.getString("superfice"));
				System.out.println("6");
				room.setDescp_ch(rs.getString("descp_ch"));
				System.out.println("7");
				room.setPrix_ch(rs.getString("prix_ch"));
				System.out.println("8");
				room.setType_ch(rs.getInt("type_ch"));
				System.out.println("9");
				room.setImage_ch(rs.getString("image_ch"));
				room.setTitre_ch(rs.getString("titre_ch"));
				System.out.println("done");
				rooms_list.add(room);
			}
	            
			}
			catch(Exception e) {
			e.printStackTrace();
		}
	return rooms_list;	
	}
	
	public int updateRoom(Chambre r) {
		int rowUpdated = 0;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("update chambre set prix_ch=?, image_ch=?,descp_ch=?,"
					+ "titre_ch=?,nbr_pers=?, type_ch=?, etat_ch= ?,superfice=?, id_hotel=?  where id_ch=?;");
			ps.setString(1, r.getPrix_ch());
			ps.setString(2, r.getImage_ch());
			ps.setString(3, r.getDescp_ch());
			ps.setString(4, r.getTitre_ch());
			ps.setInt(5, r.getNbr_pers());
			ps.setInt(6, r.getType_ch());
			ps.setInt(7, r.getEtat_ch());
			ps.setString(8, r.getSuperfice());
			ps.setInt(9, r.getId_hotel());
			ps.setInt(10,r.getId_ch());
			rowUpdated= ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("so sorry");
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	public int deleteRoom(int id) {
		int status = 0;
		try {
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			 Date date =  new Date(System.currentTimeMillis());
			 System.out.println(date);
			System.out.println("loser");
			System.out.println("god bless my family");
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("delete chambre, reservation from chambre inner join reservation on chambre.id_ch = reservation.id_ch"
					+ " where chambre.id_ch=? and chambre.id_ch NOT IN"
					+ " (select id_ch from reservation "
					+ "where reservation.date_dep<"+date+" );");
			
			ps.setInt(1, id);
			System.out.println("goooooooooooooooooooooooooooooood");
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String AddRoom(Chambre room) {
	int rslt = 0;
	Connection cnx = ConnectionDB.loadDatabase();
	System.out.println("coll");
	try {
		System.out.println("hey");
		PreparedStatement ht = cnx.prepareStatement("Insert into chambre(id_ch,id_hotel,type_ch,etat_ch,descp_ch,superfice,prix_ch,"
				+ "nbr_pers,image_ch,titre_ch) values(?,?,?,?,?,?,?,?,?,?);");
		
		ht.setString(1, null);
		ht.setInt(2, room.getId_hotel());
		ht.setInt(3, room.getType_ch());
		ht.setInt(4, room.getEtat_ch());
		ht.setString(5, room.getDescp_ch());
		ht.setString(6, room.getSuperfice());
		ht.setString(7, room.getPrix_ch());
		ht.setInt(8, room.getNbr_pers());
		ht.setString(9, room.getImage_ch());
		ht.setString(10, room.getTitre_ch());
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

	
}
