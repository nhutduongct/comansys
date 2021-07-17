package vn.csdl.infoapp;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("vn.csdl.infoapp");

        noClasses()
            .that()
            .resideInAnyPackage("vn.csdl.infoapp.service..")
            .or()
            .resideInAnyPackage("vn.csdl.infoapp.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..vn.csdl.infoapp.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
