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

import rentalCarServer.car.model.CarResponseDto;
import rentalCarServer.reservation.model.ReservationDao;
import rentalCarServer.reservation.model.ReservationRequestDto;
import rentalCarServer.reservation.model.ReservationResponseDto;

/**
 * Servlet implementation class CheckReservationAction
 */
public class CheckReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckReservationAction() {
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

		CarResponseDto targetCar = (CarResponseDto) session.getAttribute("targetCar");
		String carNumber = targetCar.getCarNumber();

		Object tempResevNum = session.getAttribute("targetReservation");
		int resevNum = -1;

		ReservationDao reservationDao = ReservationDao.getInstance();

		ReservationRequestDto resevDto = new ReservationRequestDto();
		resevDto.setCarNumber(carNumber);
		resevDto.setResevDate(resevDateTime);
		resevDto.setReturnDate(returnDateTime);

		if (tempResevNum != null) {
			resevNum = (int) tempResevNum;
		}
		resevDto.setResevNumber(resevNum);

		if (reservationDao.isExist(resevDto)) {
			request.setAttribute("isReservated", false);
			request.getRequestDispatcher("/reservationComplete").forward(request, response);
		} else {
			System.out.println("resevNum : " + resevNum);
			if (resevNum != -1) {
				reservationDao.updateReservation(resevDto);
				session.removeAttribute("targetReservation");
				request.setAttribute("isReservated", true);
				request.getRequestDispatcher("/reservationComplete").forward(request, response);
			} else {
				response.sendRedirect("/reservateAction");
			}
		}
	}
}
