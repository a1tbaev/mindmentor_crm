package kg.nsi.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.nsi.crm.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

}
