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
 * Servlet implementation class SearchCarAction
 */
public class SearchCarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCarAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<CarResponseDto> list =null;
		HttpSession session = request.getSession();
		
		String searchOption = request.getParameter("search-option");
		String searchValue  = request.getParameter("search-value");
		
		CarDao carDao = CarDao.getInstance();
		
		if(searchValue==null||searchValue.equals("")) {
			System.out.println("null");
		}else {
			if(searchOption.equals("category")) {
				int categoryNumber = Integer.parseInt(searchValue);
				list = carDao.findCarsByCategory(categoryNumber);
			}else if(searchOption.equals("car-name")) {
				list = carDao.findCarsByCarName(searchValue);			
			}else if(searchOption.equals("passengers-number")) {
				int minimumPassengers = Integer.parseInt(searchValue);
				list = carDao.findCarsByMinimumPassengers(minimumPassengers);			
			}			
		}
		
		
		session.setAttribute("carList", list);
		response.sendRedirect("/");
	}
}
