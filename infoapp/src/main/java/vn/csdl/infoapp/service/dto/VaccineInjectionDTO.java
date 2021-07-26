package vn.csdl.infoapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.domain.Vaccine;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class VaccineInjectionDTO {

    Long id;

    Person person;

    Vaccine vaccine;

    Short injectNo;

    LocalDateTime examineBeforeInjectTime;

    String examineBeforeInjectDoctor;

    String examineBeforeInjectResult;

    LocalDateTime injectionTime;

    String injectionDoctor;

    Short injectResult; //0: Bình thường, 1: phản ứng nhẹ, 2: sốc phản vệ, 4: tử vong

    String note;
}
