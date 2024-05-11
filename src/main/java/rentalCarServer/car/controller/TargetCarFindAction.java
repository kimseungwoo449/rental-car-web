package rentalCarServer.car.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.car.model.CarDao;
import rentalCarServer.car.model.CarResponseDto;
import rentalCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class TargetCarFindAction
 */
public class TargetCarFindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TargetCarFindAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");

		if (user == null) {
			response.sendRedirect("/login");
		}else {
			String targetCarNumber = request.getParameter("targetCarNumber");
			
			CarDao carDao = CarDao.getInstance();
			CarResponseDto targetCar = carDao.findCarsByCarNumber(targetCarNumber);
			session.setAttribute("targetCar", targetCar);
			
			response.sendRedirect("/carDetail");
		}
	}

}
