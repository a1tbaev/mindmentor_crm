package kg.nsi.crm.entity;

import jakarta.persistence.*;
import kg.nsi.crm.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stacks")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stack extends BaseEntity {

    @Id
    @SequenceGenerator(name = "stack_gen", sequenceName = "stack_seq",
            allocationSize = 1,initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stack_gen")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @ManyToMany(mappedBy = "stacks")
    Set<Mentor> mentors;
}
