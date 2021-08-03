package vn.csdl.infoapp.web.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import vn.csdl.infoapp.InfoappApp;
import vn.csdl.infoapp.config.TestSecurityConfiguration;
import vn.csdl.infoapp.domain.Ward;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.repository.WardRepository;
import vn.csdl.infoapp.repository.PersonRepository;
import vn.csdl.infoapp.security.AuthoritiesConstants;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link PersonResource} REST controller.
 */
@AutoConfigureMockMvc
@WithMockUser(authorities = {AuthoritiesConstants.ADMIN})
@SpringBootTest(classes = {InfoappApp.class, TestSecurityConfiguration.class})
public class PersonResourceIT {

//    @Autowired
//    private MockMvc restDonViMockMvc;
//
//    @Autowired
//    private WardRepository ariaRepository;
//
//    @Autowired
//    private PersonRepository repository;
//
//    private Person testEntity;
//
//    @BeforeEach
//    public void setup() {
//        testEntity = createEntity();
//    }
//
//    private Person createEntity(){
//        Person person = new Person();
//        person.setName("Duong Minh Nhut");
//        person.setAddress("23/BT To 1, Kv Binh Thuong B");
//        person.setPersonId("092092000305");
//        person.setIdType(Person.ID_CMND);
//        person.setPhone("+84939993304");
//        person.setYearOfBirth((short)1992);
//        person.setWard(ariaRepository.getOne(31183));
//        return person;
//    }
//
//    @Test
//    @Transactional
//    public void getAllPerson() throws Exception {
//        // Initialize the database
//        repository.saveAndFlush(testEntity);
//
//        restDonViMockMvc.perform(get("/api/person")
//            .accept(MediaType.APPLICATION_JSON))
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(jsonPath("$.length()", greaterThan(1)));
//    }
//
//    @Test
//    @Transactional
//    public void createValidPerson() throws Exception {
//
//        Ward ward = new Ward(); ward.setWardCode(31183);
//        testEntity.setWard(ward);
//
//        restDonViMockMvc.perform(post("/api/person")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(TestUtil.convertObjectToJsonBytes(testEntity))
//            .accept(MediaType.APPLICATION_JSON))
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(jsonPath("$.name").value(testEntity.getName()))
//            .andExpect(jsonPath("$.address").value(testEntity.getAddress()))
//            .andExpect(jsonPath("$.ward.wardCode").value(testEntity.getWard().getWardCode()));
//    }
//
//    @Test
//    @Transactional
//    public void createInvalidPerson() throws Exception {
//
//        //invalid aria
//        Ward ward = new Ward(); ward.setWardCode(-1000);
//        testEntity.setWard(ward);
//
//        restDonViMockMvc.perform(post("/api/person")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(TestUtil.convertObjectToJsonBytes(testEntity))
//            .accept(MediaType.APPLICATION_JSON))
//            .andDo(print())
//            .andExpect(status().is5xxServerError());
//
//        //name is null
//        testEntity = createEntity();
//        testEntity.setName(null);
//        restDonViMockMvc.perform(post("/api/person")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(TestUtil.convertObjectToJsonBytes(testEntity))
//            .accept(MediaType.APPLICATION_JSON))
//            .andDo(print())
//            .andExpect(status().is5xxServerError());
//    }
//
//    @Test
//    @Transactional
//    public void updatePerson() throws Exception {
//
//        testEntity = repository.saveAndFlush(createEntity());
//
//        //update name, aria, address
//        final String NEW_VALUE = "Le Hoai Bao";
//
//        testEntity.setName(NEW_VALUE);
//        Ward ward = new Ward();
//        ward.setWardCode(28291); //Tân mỹ chánh
//        testEntity.setWard(ward);
//        testEntity.setAddress("Mekong ITP");
//
//        restDonViMockMvc.perform(put("/api/person/{id}", testEntity.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(TestUtil.convertObjectToJsonBytes(testEntity))
//            .accept(MediaType.APPLICATION_JSON))
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(jsonPath("$.name").value(testEntity.getName()))
//            .andExpect(jsonPath("$.address").value(testEntity.getAddress()))
//            .andExpect(jsonPath("$.ward.wardCode").value(testEntity.getWard().getWardCode()));
//
//
//    }
//
//    @Test
//    @Transactional
//    public void deleteDonVi() throws Exception {
//        service.saveAndFlush(this.testEntity);
//
//        restDonViMockMvc.perform(delete("/api/category/don-vi/{id}", testEntity.getMaDonVi())
//            .accept(MediaType.APPLICATION_JSON))
//            .andDo(print())
//            .andExpect(status().isOk());
//
//        Optional<DonVi> entity = service.getRepository().findById(this.testEntity.getMaDonVi());
//        assertThat(entity.isPresent()).isFalse();
//    }
}
