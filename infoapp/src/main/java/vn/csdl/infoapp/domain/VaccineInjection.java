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
@Table(name = "vaccine_injection")
public class VaccineInjection {
    @Id
    @GeneratedValue
    Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    Vaccine vaccine;

    @NotNull
    @Min(value = 1)
    Short injectNo;

    LocalDateTime examineBeforeInjectTime;

    String examineBeforeInjectDoctor;

    String examineBeforeInjectResult;

    LocalDateTime injectionTime;

    String injectionDoctor;

    @Min(value = 0)
    Short injectResult; //0: Bình thường, 1: phản ứng nhẹ, 2: sốc phản vệ, 4: tử vong

    @Length(max = 5000)
    String note;

}
