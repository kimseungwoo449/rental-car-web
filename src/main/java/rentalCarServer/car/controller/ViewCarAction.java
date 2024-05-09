package rentalCarServer.car.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.car.model.CarDao;
import rentalCarServer.car.model.CarResponseDto;

/**
 * Servlet implementation class ViewCarAction
 */
public class ViewCarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCarAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CarDao carDao = CarDao.getInstance();
		List<CarResponseDto> carList = carDao.createAllCarList();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("carList", carList);
		response.sendRedirect("/");
	}
}
