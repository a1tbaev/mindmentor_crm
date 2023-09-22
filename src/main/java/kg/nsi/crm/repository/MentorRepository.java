package kg.nsi.crm.repository;

import kg.nsi.crm.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Mentor getById(Long id);

}