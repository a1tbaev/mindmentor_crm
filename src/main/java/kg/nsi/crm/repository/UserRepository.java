package kg.nsi.crm.repository;

import kg.nsi.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository <User, Long> {
}
