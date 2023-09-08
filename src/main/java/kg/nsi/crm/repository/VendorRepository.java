package kg.nsi.crm.repository;

import kg.nsi.crm.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
