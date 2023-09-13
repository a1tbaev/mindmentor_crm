package kg.nsi.crm.repository;

import kg.nsi.crm.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}