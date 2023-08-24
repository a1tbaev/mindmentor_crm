package kg.nsi.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Intern;

import java.util.List;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long>{
	Intern getInternById(Long id);
	
	List<Intern> getInternsByGroupId(Long groupId);
}
