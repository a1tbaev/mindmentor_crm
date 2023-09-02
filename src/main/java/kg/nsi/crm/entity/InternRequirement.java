package kg.nsi.crm.entity;

import jakarta.persistence.*;
import kg.nsi.crm.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interns_requirements")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InternRequirement extends BaseEntity {

    @Id
    @SequenceGenerator(name = "intern_requirement_gen", sequenceName = "intern_requirement_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intern_requirement_gen")
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "intern_id",
    referencedColumnName = "id")
    Intern intern;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "requirement_id",
            referencedColumnName = "id")
    Requirement requirement;

    @Column(name = "is_finished")
    Boolean isFinished;
}
