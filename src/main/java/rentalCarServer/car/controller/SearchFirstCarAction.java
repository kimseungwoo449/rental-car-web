package rentalCarServer.car.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.car.model.CarDao;
import rentalCarServer.car.model.CarResponseDto;
import rentalCarServer.reservation.model.ReservationDao;
import rentalCarServer.reservation.model.ReservationRequestDto;
import rentalCarServer.reservation.model.ReservationResponseDto;

/**
 * Servlet implementation class SearchFirstCarAction
 */
public class SearchFirstCarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchFirstCarAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<CarResponseDto> list = null;
		List<ReservationResponseDto> resevList = null;
		HttpSession session = request.getSession();

		String searchOption = request.getParameter("search-option");
		String searchValue = request.getParameter("search-value");
		
		String resevDate = request.getParameter("resev-date");
		String returnDate = request.getParameter("return-date");
		String resevTime = request.getParameter("resev-time");
		String returnTime = request.getParameter("return-time");

		
		String resevtemp = resevDate + " " + resevTime;
		String returntemp = returnDate + " " + returnTime;

		Timestamp resevDateTime = Timestamp.valueOf(resevtemp);
		Timestamp returnDateTime = Timestamp.valueOf(returntemp);
		
		ReservationDao reservationDao = ReservationDao.getInstance();

		ReservationRequestDto reservationDto = new ReservationRequestDto();
		reservationDto.setResevDate(resevDateTime);
		reservationDto.setReturnDate(returnDateTime);
		
		resevList = reservationDao.createReservationList(reservationDto);
		session.setAttribute("reservationList", resevList);
		
		
		CarDao carDao = CarDao.getInstance();

		if (searchValue == null || searchValue.equals("")) {
			list = carDao.createAllCarList();
			System.out.println("first car all");
		} else if (searchOption.equals("category")) {
			int categoryNumber = Integer.parseInt(searchValue);
			list = carDao.findCarsByCategory(categoryNumber);
		} else if (searchOption.equals("car-name")) {
			list = carDao.findCarsByCarName(searchValue);
		} else if (searchOption.equals("passengers-number")) {
			int minimumPassengers = Integer.parseInt(searchValue);
			list = carDao.findCarsByMinimumPassengers(minimumPassengers);
		}
		
		
		session.setAttribute("carList", list);
		response.sendRedirect("/allCarView");
	}
}
