package kg.nsi.crm.entity;

import jakarta.persistence.*;
import kg.nsi.crm.entity.base.BaseEntity;
import kg.nsi.crm.enums.GroupStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group extends BaseEntity{

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "finish_date")
    LocalDate finishDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    GroupStatus groupStatus;

}
