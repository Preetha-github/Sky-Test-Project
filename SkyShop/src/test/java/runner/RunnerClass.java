package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="FeatureFiles/EditorialAndGenericSearch.feature", 
//@CucumberOptions(features="FeatureFiles/ShopPageNavigation.feature",
@CucumberOptions(features="FeatureFiles",
glue="stepDefinition",
//tags= {"@Offers"},
//tags= {"@Editorialsearch"},
dryRun = false)
public class RunnerClass {

}
