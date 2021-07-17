package vn.csdl.infoapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aria")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Aria {

    @Id
    Integer ariaCode;

    @NotNull
    String ariaName;

    @NotNull
    @JsonIgnoreProperties(value = "arias")
    @ManyToOne
    @JoinColumn(name = "district_code")
    District district;

}
