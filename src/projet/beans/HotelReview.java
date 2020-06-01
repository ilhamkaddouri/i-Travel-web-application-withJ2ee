package projet.beans;

public class HotelReview {
	private int id_review;
	private String message;
	private int id_prs;
	private int id_hotel;
	public int getId_review() {
		return id_review;
	}
	public void setId_review(int id_review) {
		this.id_review = id_review;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId_prs() {
		return id_prs;
	}
	public void setId_prs(int id_prs) {
		this.id_prs = id_prs;
	}
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	
}
