package vn.csdl.infoapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "quarantine_place")
public class QuarantinePlace {
    @Id
    @GeneratedValue
    Long id;

    @NotNull
    String name;

    @NotNull
    String phone;

    @NotNull
    String address;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ward_code")
    Ward ward;
}
