package ua.price.tests;

import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.junit.Test;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;


public class LoginStory extends JUnitStories {

    @Override
    @Test
    public void run() {
        super.run();
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromPath("src/test/resources/features"), "**/*.story", "");
    }
}
