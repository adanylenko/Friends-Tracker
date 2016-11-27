package teamProject.service.interfaces;

import java.util.List;

import teamProject.entities.Point;

public interface PointService {
	boolean addPoint(Point point);

	boolean deletePoint(Point point);

	boolean changePoint(Point point);

	Point getPoint(int id_point);

	List<Point> getAll();

	List<Point> getAllUserPoint(int id_user);

	List<Point> getCntLastUserPoint(int id_user, int cntPoint);
}
