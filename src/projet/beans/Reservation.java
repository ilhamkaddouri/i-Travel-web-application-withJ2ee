package projet.beans;

import java.util.Date;

public class Reservation {
	private int id_res;
	private int id_prs;
	private int id_ch;
	private Date date_res;
	private Date date_dep;
	private Date date_arr;
	private int confirmation;
	public int getId_res() {
		return id_res;
	}
	public void setId_res(int id_res) {
		this.id_res = id_res;
	}
	public int getId_prs() {
		return id_prs;
	}
	public void setId_prs(int id_prs) {
		this.id_prs = id_prs;
	}
	public int getId_ch() {
		return id_ch;
	}
	public void setId_ch(int id_ch) {
		this.id_ch = id_ch;
	}
	
	public Date getDate_res() {
		return date_res;
	}
	public void setDate_res(Date date_res) {
		this.date_res = date_res;
	}
	public Date getDate_dep() {
		return date_dep;
	}
	public void setDate_dep(Date date_dep) {
		this.date_dep = date_dep;
	}
	public Date getDate_arr() {
		return date_arr;
	}
	public void setDate_arr(Date date_arr) {
		this.date_arr = date_arr;
	}
	public int getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(int confirmation) {
		this.confirmation = confirmation;
	}
	
}
