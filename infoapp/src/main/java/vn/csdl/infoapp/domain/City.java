package vn.csdl.infoapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "city")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class City {

    @Id
    Integer cityCode;

    @NotNull
    String cityName;

    @JsonIgnoreProperties(value = "city")
    @OneToMany(mappedBy = "city")
    List<District> districts;

}
