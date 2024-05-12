package rentalCarServer.reservation.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.car.model.CarDao;
import rentalCarServer.car.model.CarResponseDto;
import rentalCarServer.reservation.model.ReservationDao;
import rentalCarServer.reservation.model.ReservationResponseDto;

/**
 * Servlet implementation class UpdateReservationAction
 */
public class UpdateReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReservationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String temp = request.getParameter("resevNumber");
	
		int resevNumber = Integer.parseInt(temp);
		
		ReservationDao reservationDao = ReservationDao.getInstance();
		ReservationResponseDto reservation = reservationDao.findReservationByReservationNumber(resevNumber);
		
		String resevDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reservation.getResevDate());
		String returnDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reservation.getReturnDate());
		
		String resevDate = resevDt.substring(0,10);
		String resevTime = resevDt.substring(11,resevDt.length());
		
		String returnDate = returnDt.substring(0,10);
		String returnTime = returnDt.substring(11,resevDt.length());
		
		String carNumber = reservation.getCarNumber();
		
		CarDao carDao = CarDao.getInstance();
		CarResponseDto targetCar = carDao.findCarsByCarNumber(carNumber);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("targetCar", targetCar);
		session.setAttribute("resevDate", resevDate);
		session.setAttribute("returnDate", returnDate);
		session.setAttribute("resevTime", resevTime);
		session.setAttribute("returnTime", returnTime);
		session.setAttribute("targetReservation", resevNumber);
		
		response.sendRedirect("/carDetail");
	}
}
