package kg.nsi.crm.entity;

import jakarta.persistence.*;
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
@Table(name = "interview")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Interview {
    @Id
    @SequenceGenerator(name = "intern_gen", sequenceName = "intern_seq",
            allocationSize = 1, initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intern_gen")
    Long id;
    String nameOfInterview;
    LocalDate startDate;
    String startTime;
    String endTime;
    String location;
    String description;
    @ManyToMany
    List<Intern> interns;
}
