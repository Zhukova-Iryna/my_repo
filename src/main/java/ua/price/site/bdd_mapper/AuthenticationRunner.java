package ua.price.site.bdd_mapper;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import ua.price.site.bdd_steps.AuthSteps;
import ua.price.site.bdd_steps.SearchResultsSteps;

import java.util.Arrays;
import java.util.List;

public class AuthenticationRunner extends JUnitStories {
    public AuthenticationRunner() {
        super();
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withFormats(Format.CONSOLE, Format.HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new AuthSteps(), new SearchResultsSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("authentication.story", "search.story");
    }
}

