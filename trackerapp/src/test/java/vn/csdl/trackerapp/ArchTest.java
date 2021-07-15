package vn.csdl.trackerapp;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("vn.csdl.trackerapp");

        noClasses()
            .that()
            .resideInAnyPackage("vn.csdl.trackerapp.service..")
            .or()
            .resideInAnyPackage("vn.csdl.trackerapp.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..vn.csdl.trackerapp.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
