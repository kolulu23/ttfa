package io.kolulu.ttfa.hello;

import io.quarkus.arc.Priority;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Priority(2)
@Decorator
public class HarshWorldHtmlDecorator implements HelloWorldService {

    @Inject
    @Any
    @Delegate
    HelloWorldService helloWorldService;

    @Override
    public String greetings(String name) {
        String result = helloWorldService.greetings(name);
        return "<h1>" + result + "</h1>";
    }
}
