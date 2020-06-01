package projet.beans;

public class Hotel {
	private int id_hotel;
	private String nom_hotel;
	private String adresse_hotel;
	private String ville_hotel;
	private String tel_hotel;
	private String description;
	private int nbr_etoiles;
	private String image_hotel;
	private int id_prs;
	private int id_deal;
	private String rating;

	public Hotel() {
		super();
	}
	
	public Hotel(int id_hotel, String nom_hotel, String adresse_hotel, String ville_hotel, String tel_hotel,
			String description, int nbr_etoiles, String image_hotel, int id_prs) {
		super();
		this.id_hotel = id_hotel;
		this.nom_hotel = nom_hotel;
		this.adresse_hotel = adresse_hotel;
		this.ville_hotel = ville_hotel;
		this.tel_hotel = tel_hotel;
		this.description = description;
		this.nbr_etoiles = nbr_etoiles;
		this.image_hotel = image_hotel;
		this.id_prs = id_prs;
	}

	public Hotel(int id_hotel, String nom_hotel, String adresse_hotel, String ville_hotel, String tel_hotel,
			String description, int nbr_etoiles, String image_hotel) {
		super();
		this.id_hotel = id_hotel;
		this.nom_hotel = nom_hotel;
		this.adresse_hotel = adresse_hotel;
		this.ville_hotel = ville_hotel;
		this.tel_hotel = tel_hotel;
		this.description = description;
		this.nbr_etoiles = nbr_etoiles;
		this.image_hotel = image_hotel;
	}
	
	public Hotel(String ville_hotel) {
		this.ville_hotel = ville_hotel;
	}



	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public String getNom_hotel() {
		return nom_hotel;
	}
	public void setNom_hotel(String nom_hotel) {
		this.nom_hotel = nom_hotel;
	}
	public String getAdresse_hotel() {
		return adresse_hotel;
	}
	public void setAdresse_hotel(String adress_hotel) {
		this.adresse_hotel = adress_hotel;
	}
	public String getVille_hotel() {
		return ville_hotel;
	}
	public void setVille_hotel(String ville_hotel) {
		this.ville_hotel = ville_hotel;
	}
	public String getTel_hotel() {
		return tel_hotel;
	}
	public void setTel_hotel(String tel_hotel) {
		this.tel_hotel = tel_hotel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getNbr_etoiles() {
		return nbr_etoiles;
	}
	public void setNbr_etoiles(int i) {
		this.nbr_etoiles = i;
	}
	public String getImage_hotel() {
		return image_hotel;
	}
	public void setImage_hotel(String image_hotel) {
		this.image_hotel = image_hotel;
	}
	public int getId_prs() {
		return id_prs;
	}
	public void setId_prs(int id_prs) {
		this.id_prs = id_prs;
	}
	public int getId_deal() {
		return id_deal;
	}
	public void setId_deal(int id_deal) {
		this.id_deal = id_deal;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	
	
	
}