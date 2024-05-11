package rentalCarServer.reservation.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.car.model.CarResponseDto;
import rentalCarServer.reservation.model.ReservationDao;
import rentalCarServer.reservation.model.ReservationRequestDto;
import rentalCarServer.reservation.model.ReservationResponseDto;
import rentalCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class ReservateAction
 */
public class ReservateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservateAction() {
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

		CarResponseDto targetCar = (CarResponseDto)session.getAttribute("targetCar");
		String targetCarNumber = targetCar.getCarNumber();
		
		String resevDate = (String) session.getAttribute("resevDate");
		String returnDate = (String) session.getAttribute("returnDate");
		String resevTime = (String) session.getAttribute("resevTime");
		String returnTime = (String) session.getAttribute("returnTime");

		String resevtemp = resevDate + " " + resevTime;
		String returntemp = returnDate + " " + returnTime;

		Timestamp resevDateTime = Timestamp.valueOf(resevtemp);
		Timestamp returnDateTime = Timestamp.valueOf(returntemp);

		String userId = user.getId();

		ReservationRequestDto reservationDto = new ReservationRequestDto();
		reservationDto.setCarNumber(targetCarNumber);
		reservationDto.setUserId(userId);
		reservationDto.setResevDate(resevDateTime);
		reservationDto.setReturnDate(returnDateTime);

		ReservationDao reservationDao = ReservationDao.getInstance();
		ReservationResponseDto result = reservationDao.createReservation(reservationDto);

		if (result == null) {
			request.setAttribute("isReservated", false);
		} else {
			request.setAttribute("isReservated", true);
		}
		
		request.getRequestDispatcher("/reservationComplete").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
