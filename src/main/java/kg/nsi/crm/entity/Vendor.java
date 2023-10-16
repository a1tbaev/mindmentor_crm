package kg.nsi.crm.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vendors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vendor {

    @Id
    @SequenceGenerator(name = "vendor_gen", sequenceName = "vendor_seq",
            allocationSize = 1, initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_gen")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "email")
    String email;

    @Column(name = "contact_number")
    String contactNumber;

    @Column(name = "image", length = 50000)
    String image;

    @Column(name = "information")
    String information;

    @OneToMany
    List<Vacancy>vacancies;


}
