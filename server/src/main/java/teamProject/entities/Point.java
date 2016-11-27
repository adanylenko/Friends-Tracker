package teamProject.entities;

import java.sql.Timestamp;

/**
 * Created by adanu on 31.10.2016.
 */
public class Point {
	private int id;
	private int id_user;
	private double lat;
	private double lng;
	private Timestamp date;

	public Point() {
	}

	public Point(int id_user, double lat, double lng) {
		this.id_user = id_user;
		this.lat = lat;
		this.lng = lng;
		this.date = null;
	}

	public Point(int id_user, double lat, double lng, Timestamp date) {
		this.id_user = id_user;
		this.lat = lat;
		this.lng = lng;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Point that = (Point) o;

		if (id != that.id)
			return false;
		if (date != null ? !date.equals(that.date) : that.date != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}
}
