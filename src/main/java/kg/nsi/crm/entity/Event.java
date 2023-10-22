package kg.nsi.crm.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {

    @Id
    @SequenceGenerator(name = "event_gen", sequenceName = "event_seq",
            allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_gen")
    Long id;
    String meetingName;
    String location;
    String description;
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;

    @ManyToOne(cascade = CascadeType.ALL)
    Group group;





}
