package A402.controller.admin_controllers.participant;

import A402.dao.DaoFactory;
import A402.dao.ParticipantDao;
import A402.model.Event_NV;
import A402.model.Participant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebServlet("/listParticipant")
public class ListParticipant extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ParticipantDao participantDao = DaoFactory.createParticipantDao();
        List<Participant> participants = participantDao.selectAll();
        Map<Integer, List<Participant>> participantByEventId = participants.stream().collect(Collectors.groupingBy(p -> p.getEventId()));
        request.setAttribute("participantByEventId", participantByEventId);

        Integer[] eventIds = participants.stream().map(Participant::getEventId).distinct().toArray(Integer[]::new);
        Map<Integer, Event_NV> eventById = DaoFactory.createEventDao_NV().getEventByIds(eventIds);
        //Calculate seats count for every participant
        HashMap<Integer, Integer> participantIdToSeatCount = new HashMap<>();
        for (Map.Entry<Integer, Event_NV> entry : eventById.entrySet()) {
            Event_NV e = entry.getValue();
            List<Integer> seatParticipants = e.getSeatParticipants();
            for (Integer id : seatParticipants) {
                participantIdToSeatCount.compute(id, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            }
        }

        request.setAttribute("participantIdToSeatCount", participantIdToSeatCount);
        request.setAttribute("eventById", eventById);

        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin3.jsp").forward(request, response);
    }
}