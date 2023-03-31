package io.kolulu.ttfa.hello;

import java.util.Map;
import java.util.Optional;

/**
 * The world, it remembers. Memory is represented by a map
 *
 * @param <K> Key type of memory map
 * @param <V> Value type of memory map
 */
public interface WorldMemory<K, V> {
    default Optional<V> memorize(K key, V value) {
        return Optional.empty();
    }

    default Optional<V> forget(K key) {
        return Optional.empty();
    }

    default Optional<V> read(K key) {
        return Optional.empty();
    }

    /**
     * Read memory
     *
     * @return Whole or part of the world memory
     */
    default Map<K, V> read() {
        return null;
    }
}
