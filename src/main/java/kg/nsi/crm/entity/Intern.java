package kg.nsi.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import kg.nsi.crm.entity.base.BaseEntity;
import kg.nsi.crm.enums.InternStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interns")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Intern {
    @Id
    @SequenceGenerator(name = "intern_gen", sequenceName = "intern_seq",
            allocationSize = 1, initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intern_gen")
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    @Email
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    Boolean isPaidForFirstMonth;
    Boolean isPaidForSecondMonth;
    Boolean isPaidForThirdMonth;
    int paymentCoastPerMonth;
    int balance;

    @Column(name = "creation_date")
    LocalDate creationDate;

    @Column(name = "update_date")
    LocalDate updateDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    InternStatus internStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    Mentor mentor;

    @ManyToOne(cascade = CascadeType.ALL)
    Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    Stack stack;

}
