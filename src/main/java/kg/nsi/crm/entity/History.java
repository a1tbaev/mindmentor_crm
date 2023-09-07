package kg.nsi.crm.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "history")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class History {
    @Id
    @SequenceGenerator(name = "history_gen", sequenceName = "history_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_gen")
    Long id;
    LocalDate date;
    String message;
    @ManyToOne(cascade = CascadeType.ALL)
    Intern intern;
}
