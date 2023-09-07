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
@Table(name = "mentors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class  Mentor extends BaseEntity {
    @Id
    @SequenceGenerator(name = "mentor_gen", sequenceName = "mentor_seq",
            allocationSize = 1, initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_gen")
    Long id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "is_billable", nullable = false)
    Boolean isBillable;

    @ManyToMany
    @JoinTable(name = "mentors_stacks",
            joinColumns = { @JoinColumn(name = "mentor_id") },
            inverseJoinColumns = { @JoinColumn(name = "stack_id") })
    Set<Stack> stacks;
}
