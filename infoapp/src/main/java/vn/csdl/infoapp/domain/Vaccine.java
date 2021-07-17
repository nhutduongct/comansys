package vn.csdl.infoapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vaccine")
public class Vaccine {
    @Id
    Long id;

    @NotNull
    String name;

    @NotNull
    String manufactures;

    @NotNull
    Short numberOfInjections;

    @NotNull
    Short efficiency;

    String note;


}
