package teamProject.entities;

public class NearbyFriendsResponseEntity {
	private String login;
	private String phoneNumber;
	private double lat;
	private double lng;

	public NearbyFriendsResponseEntity(String login, String phoneNumber) {
		this.login = login;
		this.phoneNumber = phoneNumber;
	}

	public NearbyFriendsResponseEntity(String login, double lat, double lng, String phoneNumber) {
		this.login = login;
		this.lat = lat;
		this.lng = lng;
		this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
