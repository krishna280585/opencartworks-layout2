import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"html:target/cucu","json:target/cucuber.json"},
        features="src/test/resources/featurefiles/sample")
public class SampleTest {

}
