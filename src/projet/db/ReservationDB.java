package projet.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projet.beans.Hotel;
import projet.beans.Reservation;

public class ReservationDB {
	public List<Reservation> getReservation(int id){
		List<Reservation> reservs= new ArrayList<Reservation>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from reservation where id_prs=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reservation reserv = new Reservation();
				reserv.setId_res(rs.getInt("id_res"));
				reserv.setId_prs(rs.getInt("id_prs"));
				reserv.setId_ch(rs.getInt("id_ch"));
				reserv.setDate_dep(rs.getDate("date_dep"));
				reserv.setDate_arr(rs.getDate("date_arr"));
				reserv.setDate_res(rs.getDate("date_res"));
				reserv.setConfirmation(rs.getInt("confirmation"));
				reservs.add(reserv);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return reservs;
	}
	public Reservation AddReservation(Reservation resv) {
		int rslt = 0;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			System.out.println("hi");
			PreparedStatement ps = cnx.prepareStatement("insert into reservation(id_res,id_ch,date_res,date_arr,date_dep,confirmation,id_prs) values(?,?,?,?,?,?,?);");
			ps.setString(1, null);
			System.out.println("hi");
			ps.setInt(2,resv.getId_ch());
			System.out.println("hi");
			ps.setDate(3,(Date) resv.getDate_res());
			System.out.println("hi");
			ps.setDate(4,(Date) resv.getDate_arr());
			System.out.println("hi");
			ps.setDate(5,(Date) resv.getDate_dep());
			System.out.println("hi");
			ps.setInt(6,0);
			System.out.println("hi");
			ps.setInt(7,resv.getId_prs());
			System.out.println();
			rslt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resv;
	}
	
	public boolean verifyReservation(Date date_dep,Date date_arr,int id) {
		boolean test = false;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			System.out.println("hi");
			PreparedStatement ps = cnx.prepareStatement("select date_dep,date_arr,id_ch from reservation where id_ch=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getDate("date_dep") == date_dep && rs.getDate("date_arr")==date_arr) {
					test = false;
				}
			}
			
		}catch(Exception e) {
			
		}
		return test;
	}
	public int deleteReservation(int id) {
		int status = 0;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("delete from reservation where id_res=?;");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public int updateReservation(int id) {
		int rowUpdated = 0;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("update reservation set confirmation=1 where id_res=?;");
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

}
