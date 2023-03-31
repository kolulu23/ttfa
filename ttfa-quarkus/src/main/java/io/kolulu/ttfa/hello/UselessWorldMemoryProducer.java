package io.kolulu.ttfa.hello;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Just some demonstration of bean declaration
 */
@ApplicationScoped // Doesn't need to put one on it
public class UselessWorldMemoryProducer {
    @Produces // @Bean
    @Named("shenanigans")
    WorldMemory<String, Integer> shenanigansMemory() {
        return new WorldMemory<>() {
        };
    }

    @Produces
    @WorldMemoryQualifier(longTerm = true, readonly = true)
    WorldMemory<String, String> viandsMemory() {
        Map<String, String> memory = new ConcurrentHashMap<>();
        memory.put("HUNGER", "HUNGER");
        return new WorldViandsMemory(memory);
    }

    /**
     * A read only memory
     */
    public static class WorldViandsMemory implements WorldMemory<String, String> {
        private final Map<String, String> memory;

        public WorldViandsMemory(Map<String, String> memory) {
            this.memory = memory;
        }

        @Override
        public Optional<String> read(String key) {
            return Optional.of(key).map(memory::get);
        }

        @Override
        public Map<String, String> read() {
            return new HashMap<>(memory);
        }
    }
}
