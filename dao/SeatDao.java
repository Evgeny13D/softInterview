package A402.dao;

import A402.model.Seat;

import java.util.List;

public interface SeatDao {
    List<Seat> listOfSeatsByEvent(int eventId);

    Seat storeSeat(Seat seat);

    void updateParticipant(int[] seatIds, int participantId);
}
