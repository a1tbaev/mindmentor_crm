package kg.nsi.crm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kg.nsi.crm.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vendors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vendor extends BaseEntity {

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "email")
    String email;

    @Column(name = "contact_number")
    String contactNumber;

}
