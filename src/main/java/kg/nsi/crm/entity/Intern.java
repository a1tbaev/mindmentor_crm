package kg.nsi.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import kg.nsi.crm.entity.base.BaseEntity;
import kg.nsi.crm.enums.InternStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interns")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Intern extends BaseEntity{

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    @Email
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "is_paid")
    Boolean isPaid;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    InternStatus internStatus;

    @ManyToOne
    @JoinColumn(columnDefinition = "group_id",
            referencedColumnName = "id")
    Group group;

    @OneToMany(mappedBy = "intern")
    List<InternRequirement> requirements;
}
