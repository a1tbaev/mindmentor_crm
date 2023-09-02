package kg.nsi.crm.entity;

import jakarta.persistence.*;
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

    @Id
    @SequenceGenerator(name = "vendor_gen", sequenceName = "vendor_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_gen")
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "email")
    String email;

    @Column(name = "contact_number")
    String contactNumber;

}
