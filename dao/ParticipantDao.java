package A402.dao;

import A402.model.Participant;

import java.util.List;

public interface ParticipantDao {
    Participant storeParticipant(Participant participant);
    List<Participant> selectAll();
}
