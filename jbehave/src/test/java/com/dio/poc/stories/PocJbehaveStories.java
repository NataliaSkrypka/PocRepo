package com.dio.poc.stories;

import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingPaths;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.junit.AnnotatedPathRunner;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.runner.RunWith;

/**
 * Created by vanish on 2/19/14.
 */
@RunWith(AnnotatedPathRunner.class)
@Configure(parameterConverters = {
        ParameterConverters.EnumConverter.class,
        ParameterConverters.BooleanConverter.class,
        ParameterConverters.DateConverter.class
})
@UsingEmbedder(
        embedder = Embedder.class,
        generateViewAfterStories = true,
        ignoreFailureInStories = true,
        ignoreFailureInView = false,
        stepsFactory = false,
        threads = 1)
@UsingPaths(searchIn = "src/test/resources/", includes = "jbehave/*.story")
@UsingSteps(instances = {SearchOnBookingSteps.class})
public class PocJbehaveStories {
}
