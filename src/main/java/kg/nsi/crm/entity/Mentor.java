package kg.nsi.crm.entity;

import jakarta.persistence.*;
import kg.nsi.crm.dto.ExperienceDto;
import kg.nsi.crm.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
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

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

//    @Column(name = "phone_number", nullable = false)
//    String phoneNumber;

    @Column(name = "is_billable")
    Boolean isBillable;

    @Column(name="education")
    String education;

    @Column(name = "experience")
    String experience;


    @ManyToMany
    @JoinTable(name = "mentors_stacks",
            joinColumns = { @JoinColumn(name = "mentor_id") },
            inverseJoinColumns = { @JoinColumn(name = "stack_id") })
    Set<Stack> stacks;
}
