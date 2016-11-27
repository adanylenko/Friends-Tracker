package teamProject.service;

import java.util.List;

import javax.transaction.Transactional;

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
		if (pointDao.add(point))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean deletePoint(Point point) {
		if (pointDao.delete(point))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean changePoint(Point point) {
		if (pointDao.delete(point))
			return true;
		return false;
	}

	@Override
	@Transactional
	public Point getPoint(int id_point) {
		return pointDao.getbyId(id_point);
	}

	@Override
	@Transactional
	public List<Point> getAll() {
		return pointDao.getAll();
	}

	@Override
	@Transactional
	public List<Point> getAllUserPoint(int id_user) {
		return pointDao.getUserPoints(id_user);
	}

	@Override
	@Transactional
	public List<Point> getCntLastUserPoint(int id_user, int cntPoint) {
		if (cntPoint <= 0)
			return null;
		List<Point> points = pointDao.getUserPoints(id_user);
		if (points == null)
			return null;
		if (points.size() <= cntPoint)
			return points;
		return points.subList(0, cntPoint);
	}
}
