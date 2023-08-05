import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "pl.afranaso.quizzes")
public class ArchitectureTest {

    @ArchTest
    static final ArchRule modelClassesShouldNotAccessControllers =
            noClasses().that().resideInAPackage("..model..")
                    .should().dependOnClassesThat().resideInAPackage("..controller..");

    @ArchTest
    static final ArchRule modelClassesShouldNotUseSpringAnnotations =
            noClasses().that().resideInAPackage("..model..")
                    .should().beAnnotatedWith(Component.class)
                    .orShould().beAnnotatedWith(Service.class)
                    .orShould().beAnnotatedWith(Repository.class)
                    .orShould().beAnnotatedWith(Controller.class)
                    .orShould().beAnnotatedWith(Configuration.class);


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
    static final ArchRule controllerClassesShouldEndWithController =
            classes()
                    .that().resideInAPackage("..controller..")
                    .and().haveSimpleNameNotEndingWith("Test")
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static final ArchRule controllerClassesShouldOnlyBeAccessedByControllers =
            classes()
                    .that().resideInAPackage("..controller..")
                    .should().onlyBeAccessed().byAnyPackage("..controller..");

    @ArchTest
    static final ArchRule controllersShouldNotAccessRepositories =
            noClasses().that().resideInAPackage("..controller..")
                    .should().dependOnClassesThat().resideInAPackage("..repository..");


    @ArchTest
    static final ArchRule dtosShouldNotContainBusinessLogic =
            noClasses().that().resideInAPackage("..dto..")
                    .and().haveSimpleNameNotEndingWith("Mapper")
                    .should().beAnnotatedWith(Component.class)
                    .orShould().beAnnotatedWith(Service.class)
                    .orShould().beAnnotatedWith(Repository.class)
                    .orShould().beAnnotatedWith(Controller.class);

    @ArchTest
    static final ArchRule exceptionsShouldBeNamedCorrectly =
            classes().that().areAssignableTo(Exception.class)
                    .should().haveSimpleNameEndingWith("Exception");

    @ArchTest
    static final ArchRule noCyclicDependencies = slices().matching("..quizzes.(*)..").should().beFreeOfCycles();

    @ArchTest
    static final ArchRule fieldInjectionShouldNotBeUsed =
            noFields()
                    .should().beAnnotatedWith(org.springframework.beans.factory.annotation.Autowired.class)
                    .andShould().beAnnotatedWith("Inject");

    @ArchTest
    static final ArchRule noDeprecatedClassesOrMethods =
            noClasses().should().beAnnotatedWith(Deprecated.class);

    @ArchTest
    static final ArchRule noClassesShouldHaveImplSuffix =
            classes().should().haveSimpleNameNotEndingWith("Impl");

    @ArchTest
    static final ArchRule interfaceMethodsShouldBePublic =
            methods().that().areDeclaredInClassesThat().areInterfaces()
                    .should().bePublic();
}
