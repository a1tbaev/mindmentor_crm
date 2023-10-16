package kg.nsi.crm.repository;

import kg.nsi.crm.entity.History;
import kg.nsi.crm.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

    History getByInternId(Long id);

    void deleteAllByInternId(Long id);
}