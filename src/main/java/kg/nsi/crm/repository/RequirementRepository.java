package kg.nsi.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.nsi.crm.entity.Requirement;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long> {

}
