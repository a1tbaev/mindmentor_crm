package kg.nsi.crm.entity;

import jakarta.persistence.*;
import kg.nsi.crm.entity.base.BaseEntity;
import kg.nsi.crm.enums.GroupStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group extends BaseEntity{
    @Id
    @SequenceGenerator(name = "group_gen", sequenceName = "group_seq",
            allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_gen")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "finish_date")
    LocalDate finishDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    GroupStatus groupStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    List<Intern> interns;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    List<Event> events;

    public void addIntern(Intern intern){
        if (getInterns() == null){
            List<Intern> internList = new ArrayList<>();
            internList.add(intern);
            interns = internList;
        }else interns.add(intern);
    }
}
