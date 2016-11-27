package teamProject.controllers.servlets;

import teamProject.service.interfaces.PointService;

public class PointServlet {
	private PointService pointService;

	public void setPointService(PointService pointService) {
		this.pointService = pointService;
	}
}
