package io.kolulu.ttfa.hello;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * This world only insults you
 */
@ApplicationScoped  // @Component
@WorldInterceptor
@Default
@Named("harshWorldService")
public class HarshWorldService implements HelloWorldService {

    @Inject
    @WorldMemoryQualifier(longTerm = false)
    WorldMemory<String, Integer> nameMemory;

    @Override
    public String greetings(String name) {
        String txt = String.format("%s expects a hello, but the world just fucks %s over", name, name);
        String reply = nameMemory.read(name).map(cnt -> {
            if (cnt <= 1) {
                return txt;
            } else if (cnt == 2) {
                return txt + ", again.";
            } else {
                return String.format("%s for %d times", txt, cnt);
            }
        }).orElse("You are nobody, how pathetic");
        nameMemory.memorize(name, 1);
        return reply;
    }
}
