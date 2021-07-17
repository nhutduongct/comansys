package vn.csdl.infoapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "quarantine")
public class Quarantine {
    @Id
    @GeneratedValue
    Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "quarantine_place_id")
    QuarantinePlace quarantinePlace;

    @NotNull
    LocalDateTime startDate;

    LocalDateTime endDate;

    @Min(value = 0)
    Short quarantineResult; //0: Khỏi bệnh, 1: chuyển nơi cách ly, 2: chuyển nơi điều trị, 3: trốn cách ly, 4: tử vong

    @Length(max = 5000)
    String note;
}
