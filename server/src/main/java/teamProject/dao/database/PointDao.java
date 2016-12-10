package teamProject.dao.database;

import java.util.List;

import teamProject.entities.Point;

public interface PointDao {
	Point add(Point point) throws Exception;

	Point update(Point point) throws Exception;

	Point delete(Point point) throws Exception;

	Point getbyId(int id) throws Exception;

	List<Point> getAll() throws Exception;

	List<Point> getUserPoints(int id_user) throws Exception;

}
