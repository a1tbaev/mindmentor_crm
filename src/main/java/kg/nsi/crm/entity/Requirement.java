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
@Table(name = "requirements")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Requirement extends BaseEntity {

    @Id
    @SequenceGenerator(name = "requirement_gen", sequenceName = "requirement_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requirement_gen")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "stack_id",
            referencedColumnName = "id")
    Stack stack;

    @Column(name = "name")
    String name;
}
