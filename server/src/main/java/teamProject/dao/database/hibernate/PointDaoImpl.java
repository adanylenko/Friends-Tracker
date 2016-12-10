package teamProject.dao.database.hibernate;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import teamProject.dao.database.PointDao;
import teamProject.entities.Point;

public class PointDaoImpl implements PointDao {
	private SessionFactory sessionFactory = null;

	public PointDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Point add(Point point) throws Exception {
		sessionFactory.getCurrentSession().save(point);
		return point;
	}

	@Override
	public Point delete(Point point) throws Exception {
		sessionFactory.getCurrentSession().delete(point);
		return point;
	}

	@Override
	public Point update(Point point) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(point);
		return point;
	}

	@Override
	public List<Point> getUserPoints(int id_user) throws Exception {
		List<Point> points = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Point.class);
		points = criteria.add(Restrictions.eq("id_user", id_user)).list();

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
	public Point getbyId(int id) throws Exception {
		Point point = null;
		point = (Point) sessionFactory.getCurrentSession().get(Point.class, id);
		return point;
	}

	@Override
	public List<Point> getAll() throws Exception {
		List<Point> points = null;
		points = sessionFactory.getCurrentSession().createCriteria(Point.class).list();
		return points;
	}

}
