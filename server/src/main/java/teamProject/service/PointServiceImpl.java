package teamProject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import teamProject.dao.database.PointDao;
import teamProject.entities.Point;
import teamProject.service.interfaces.PointService;

public class PointServiceImpl implements PointService {
	private PointDao pointDao;

	public void setPointDao(PointDao pointDao) {
		this.pointDao = pointDao;
	}

	@Override
	@Transactional
	public boolean addPoint(Point point) {
		try {
			pointDao.add(point);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deletePoint(Point point) {
		try {
			pointDao.delete(point);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean changePoint(Point point) {
		return false;
	}

	@Override
	@Transactional
	public Point getPoint(int id_point) {
		Point point = null;
		try {
			point = pointDao.getbyId(id_point);
		} catch (Exception ex) {
			point = null;
		}
		return point;
	}

	@Override
	@Transactional
	public List<Point> getAll() {
		List<Point> points = null;
		try {
			points = pointDao.getAll();
		} catch (Exception ex) {
			points = null;
		}
		return points;
	}

	@Override
	@Transactional
	public List<Point> getAllUserPoint(int id_user) {
		List<Point> points = null;
		try {
			points = pointDao.getUserPoints(id_user);
		} catch (Exception ex) {
			points = null;
		}
		return points;
	}

	@Override
	@Transactional
	public List<Point> getCntLastUserPoint(int id_user, int cntPoint) {
		if (cntPoint <= 0)
			return null;
		final List<Point> points = getAllUserPoint(id_user);
		if (points == null)
			return null;
		if (points.size() <= cntPoint)
			return points;
		return points.subList(0, cntPoint);
	}
}
