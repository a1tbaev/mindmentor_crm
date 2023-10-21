package kg.nsi.crm.repository;

import kg.nsi.crm.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy,Long> {
    List<Vacancy> findAllByVendorId(Long vendorId);
}
