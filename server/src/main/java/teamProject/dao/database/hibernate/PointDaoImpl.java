package teamProject.dao.database.hibernate;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teamProject.dao.database.PointDao;
import teamProject.entities.Point;

public class PointDaoImpl implements PointDao {
	private SessionFactory sessionFactory = null;
	private static final Logger LOG = LoggerFactory.getLogger(PointDaoImpl.class);

	public PointDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean add(Point point) {
		try {
			sessionFactory.getCurrentSession().save(point);

		} catch (Exception ex) {
			LOG.error("Error when trying to add Point.\n With User id: {}\n", point.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Point point) {
		try {
			sessionFactory.getCurrentSession().delete(point);
		} catch (Exception ex) {
			LOG.error("Error when trying to Delete Point with User id: {}.", point.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Point point) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(point);

		} catch (Exception ex) {
			LOG.error("Error when trying to change Point.\n With User id: {}\n", point.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public List<Point> getUserPoints(int id_user) {
		List<Point> points = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Point.class);
			points = criteria.add(Restrictions.eq("id_user", id_user)).list();
		} catch (Exception ex) {
			LOG.error("Error when trying to get all Points for user with id: {}.", id_user, ex);
		}
		if (points != null)
			points.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					return o2.getDate().compareTo(o1.getDate());
				}

			});
		return points;
	}

	@Override
	public Point getbyId(int id) {
		Point point = null;
		try {
			point = (Point) sessionFactory.getCurrentSession().get(Point.class, id);
		} catch (Exception e) {
			LOG.error("Error when try get Point with id={}", id);
		}
		return point;
	}

	@Override
	public List<Point> getAll() {
		List<Point> points = null;
		try {
			points = sessionFactory.getCurrentSession().createCriteria(Point.class).list();
		} catch (Exception ex) {
			LOG.error("Error when trying to get all Points.", ex);
		}
		return points;
	}

}
