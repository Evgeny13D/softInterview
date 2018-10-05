package A402.controller;

import A402.dao.DaoFactory;
import A402.dao.SeatDao;
import A402.model.Seat;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listSeats")
public class ListSeatsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        String eventIdString = request.getParameter("eventId");
        int eventId = Integer.parseInt(eventIdString);

        SeatDao seatDao = DaoFactory.createSeatDao();
        List<Seat> seats = seatDao.listOfSeatsByEvent(eventId);

        Seat[][] seatsArray = makeSeatsArray(seats);

        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(seatsArray));
    }

    private Seat[][] makeSeatsArray(List<Seat> seats) {
        int maxRow = getMaxRow(seats);
        int maxSeat = getMaxSeat(seats);
        Seat[][] seatsArray = new Seat[maxRow][maxSeat];

        for (Seat seat : seats) {
            int row = seat.getRowNumber();
            int seatNumber = seat.getSeatNumber();
            seatsArray[row - 1][seatNumber - 1] = seat;
        }

        return seatsArray;
    }

    private int getMaxRow(List<Seat> seats) {
        int row = 0;

        for (Seat seat : seats) {
            int currentRow = seat.getRowNumber();
            if (currentRow > row) {
                row = currentRow;
            }
        }

        return row;
    }

    private int getMaxSeat(List<Seat> seats) {
        int seatNumber = 0;

        for (Seat seat : seats) {
            int currentSeatNumber = seat.getSeatNumber();
            if (currentSeatNumber > seatNumber) {
                seatNumber = currentSeatNumber;
            }
        }

        return seatNumber;
    }
}
