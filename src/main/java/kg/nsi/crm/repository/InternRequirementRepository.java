package kg.nsi.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.nsi.crm.entity.InternRequirement;

@Repository
public interface InternRequirementRepository extends JpaRepository<InternRequirement, Long>{

}
