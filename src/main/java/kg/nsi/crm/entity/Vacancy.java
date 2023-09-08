package kg.nsi.crm.entity;

import jakarta.persistence.*;
import kg.nsi.crm.enums.DeveloperLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vacancy")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vacancy {

    @Id
    @SequenceGenerator(name = "vacancy_gen", sequenceName = "vacancy_seq",
            allocationSize = 1, initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacancy_gen")
    Long id;

    @OneToOne
    Stack stack;

    @Column(name = "release_day")
    LocalDate releaseDay;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    DeveloperLevel level;

    @Column(name = "requirements")
    String requirements;

    @ManyToOne
    Vendor vendor;
}
