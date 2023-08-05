import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "pl.afranaso.quizzes")
public class ArchitectureTest {

    @ArchTest
    static final ArchRule repositoryShouldEndWithRepository =
            classes()
                    .that().resideInAPackage("..repository..")
                    .should().haveSimpleNameEndingWith("Repository");

    @ArchTest
    static final ArchRule repositoryShouldBeAccessedOnlyFromServicesAndRepositories =
            classes()
                    .that().resideInAPackage("..repository..")
                    .should().onlyBeAccessed().byAnyPackage("..repository..", "..service..");

    @ArchTest
    static final ArchRule serviceClassesShouldEndWithService =
            classes()
                    .that().resideInAPackage("..service..")
                    .and().haveSimpleNameNotEndingWith("Test")
                    .should().haveSimpleNameEndingWith("Service");

    @ArchTest
    static final ArchRule serviceClassesShouldOnlyBeAccessedByServicesAndControllers =
            classes()
                    .that().resideInAPackage("..service..")
                    .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");

    @ArchTest
    static final ArchRule controllerClassesShouldEndWithService =
            classes()
                    .that().resideInAPackage("..controller..")
                    .and().haveSimpleNameNotEndingWith("Test")
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static final ArchRule controllerClassesShouldOnlyBeAccessedByControllers =
            classes()
                    .that().resideInAPackage("..controller..")
                    .should().onlyBeAccessed().byAnyPackage("..controller..");
}
