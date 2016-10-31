package teamProject.dao.database;

import java.util.List;

import teamProject.entities.Point;

public interface PointDao {
	void addPoint(Point point);
	void deletePoint(Point point);
	void updatePoint(Point point);
	List<Point> getUserPoints(int id_user);
	

}
