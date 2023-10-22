package kg.nsi.crm.repository;

import kg.nsi.crm.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Mentor getById(Long id);

    Optional<Mentor> findByEmail(String email);
}