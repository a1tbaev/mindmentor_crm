package kg.nsi.crm.entity;

import jakarta.persistence.*;
import kg.nsi.crm.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
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

    @Column(name = "name", nullable = false)
    String name;

    @ManyToMany(mappedBy = "stacks")
    Set<Mentor> mentors;

    @OneToMany(mappedBy = "stack")
    List<Requirement> requirements;
}
