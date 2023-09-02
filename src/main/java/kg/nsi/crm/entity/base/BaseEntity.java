package kg.nsi.crm.entity.base;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.ZoneId;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {

    @Column(name = "creation_date")
    LocalDate creationDate;

    @Column(name = "update_date")
    LocalDate updateDate;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDate.now(ZoneId.of("Asia/Bishkek"));
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDate = LocalDate.now(ZoneId.of("Asia/Bishkek"));
    }
}
