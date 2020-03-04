package ua.price.site.bdd_steps;

import java.util.List;

public abstract class CoreStories {

    @org.testng.annotations.Test
    public void run() {
        run();
    }

    protected abstract List<String> storyPaths();
}
