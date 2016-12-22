package teamProject.entities;

public class NearbyFriendsResponseEntity {
	private String login;
	private double lat;
	private double lng;

	public NearbyFriendsResponseEntity(String login, double lat, double lng) {
		this.login = login;
		this.lat = lat;
		this.lng = lng;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

}
