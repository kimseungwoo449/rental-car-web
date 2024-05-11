package rentalCarServer.reservation.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.reservation.model.ReservationDao;
import rentalCarServer.reservation.model.ReservationRequestDto;
import rentalCarServer.reservation.model.ReservationResponseDto;

/**
 * Servlet implementation class findCarByResevTimeAction
 */
public class FindCarByResevTimeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindCarByResevTimeAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<ReservationResponseDto> list = null;

		HttpSession session = request.getSession();

		String resevDate = request.getParameter("resev-date");
		String returnDate = request.getParameter("return-date");
		String resevTime = request.getParameter("resev-time");
		String returnTime = request.getParameter("return-time");
		
		session.setAttribute("resevDate", resevDate);
		session.setAttribute("returnDate", returnDate);
		session.setAttribute("resevTime", resevTime);
		session.setAttribute("returnTime", returnTime);
		
		String resevtemp = resevDate + " " + resevTime;
		String returntemp = returnDate + " " + returnTime;

		Timestamp resevDateTime = Timestamp.valueOf(resevtemp);
		Timestamp returnDateTime = Timestamp.valueOf(returntemp);
		
		ReservationDao reservationDao = ReservationDao.getInstance();

		ReservationRequestDto reservationDto = new ReservationRequestDto();
		reservationDto.setResevDate(resevDateTime);
		reservationDto.setReturnDate(returnDateTime);
		list = reservationDao.createReservationList(reservationDto);
		session.setAttribute("reservationList", list);
		response.sendRedirect("/allCarView");
	}

}
