package kg.nsi.crm.repository;

import kg.nsi.crm.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    History getByInternId(Long id);

    List<History> findAllByInternId(Long internId);
}