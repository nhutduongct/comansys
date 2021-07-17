package vn.csdl.infoapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "district")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class District {

    @Id
    Integer districtCode;

    @NotNull
    String districtName;

    @NotNull
    @JsonIgnoreProperties(value = "districts")
    @ManyToOne
    @JoinColumn(name = "city_code")
    City city;

    @JsonIgnoreProperties(value = "district")
    @OneToMany(mappedBy = "district")
    List<Aria> arias;
}
