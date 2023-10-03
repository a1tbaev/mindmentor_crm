package kg.nsi.crm.repository;

import kg.nsi.crm.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> getAllEventsByGroupId(Long groupId);
}
