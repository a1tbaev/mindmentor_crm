package kg.nsi.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.nsi.crm.entity.Stack;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long>{

}
