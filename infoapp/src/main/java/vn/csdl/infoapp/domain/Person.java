package vn.csdl.infoapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    public static final short ID_CMND = 1;
    public static final short ID_CCCD = 2;
    public static final short ID_PASSPORT = 3;
    public static final short ID_DRIVER_LICENSE = 4;
    public static final short ID_OTHER = 100;

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    @Column(unique = true)
    String personId;

    @NotNull
    Short idType;

    @NotNull
    String name;

    @NotNull
    String phone;

    @NotNull
    String address;

    @NotNull
    Short yearOfBirth;

    @NotNull
    Short sync = 0;

    @NotNull
    @ManyToOne
    Aria aria;

    @JsonIgnoreProperties(value = "person")
    @OneToMany(mappedBy = "person")
    List<Infection> infections;

    @JsonIgnoreProperties(value = "person")
    @OneToMany(mappedBy = "person")
    List<Quarantine> quarantines;
}
