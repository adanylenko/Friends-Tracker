package teamProject.dao.database;

import java.util.List;

import teamProject.entities.Point;

public interface PointDao {
	boolean add(Point point);

	boolean update(Point point);

	boolean delete(Point point);

	Point getbyId(int id);

	List<Point> getAll();

	List<Point> getUserPoints(int id_user);

}
