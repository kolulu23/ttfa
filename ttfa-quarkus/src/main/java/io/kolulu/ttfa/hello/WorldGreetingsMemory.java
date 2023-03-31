package io.kolulu.ttfa.hello;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@WorldMemoryQualifier(longTerm = false)
@Slf4j
public class WorldGreetingsMemory implements WorldMemory<String, Integer> {

    private final Map<String, Integer> memory = new ConcurrentHashMap<>();

    private final int maxNames = 1000;

    /**
     * Memorizes count per name
     *
     * @param key    Name
     * @param _value Ignored as this memory memorize count by one
     * @return The updated count if there's any
     */
    @Override
    public Optional<Integer> memorize(String key, Integer _value) {
        if (memory.size() >= maxNames) {
            memory.clear();
        }
        return Optional.of(key).map(k -> memory.compute(k, (_k, v) -> v == null ? 1 : v + 1));
    }

    @Override
    public Optional<Integer> forget(String key) {
        return Optional.of(key).map(memory::remove);
    }

    @Override
    public Optional<Integer> read(String key) {
        return Optional.of(key).map(memory::get);
    }

    @Override
    public Map<String, Integer> read() {
        return memory;
    }

    @PreDestroy
    void farewell() {
        memory.keySet().forEach(name -> log.info("Farewell {}", name));
    }
}
