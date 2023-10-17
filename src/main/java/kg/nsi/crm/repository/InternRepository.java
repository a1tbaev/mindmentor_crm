package kg.nsi.crm.repository;

import kg.nsi.crm.dto.response.InternResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kg.nsi.crm.entity.Intern;

import java.util.List;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long>{
	Intern getInternById(Long id);
	List<Intern> getInternsByGroupId(Long groupId);
	List<Intern> findByMentorId(Long mentorId);
	Intern getInternByEmail(String email);
	List<Intern> getInternsByFirstName(String name);
	@Query("SELECT NEW kg.nsi.crm.dto.response.InternResponse(i.id, i.firstName, i.lastName, " +
		   "(CASE WHEN i.group IS NULL THEN 'Not Assigned to Group' ELSE i.group.name END), " +
		   "i.stack.name, i.internStatus, CONCAT(m.firstName, ' ', m.lastName)) " +
		   "FROM Intern i " +
		   "LEFT JOIN i.group g " +
		   "JOIN i.stack s " +
		   "FULL JOIN i.mentor m")
	List<InternResponse> getAll();


}
