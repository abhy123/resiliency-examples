import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.RegistryStore;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

public class CustomResistry implements RegistryStore<CircuitBreaker> {

    @Override
    public CircuitBreaker computeIfAbsent(String key, Function<? super String, ? extends CircuitBreaker> mappingFunction) {
        return null;
    }

    @Override
    public CircuitBreaker putIfAbsent(String key, CircuitBreaker value) {
        return null;
    }

    @Override
    public Optional<CircuitBreaker> find(String key) {
        return Optional.empty();
    }

    @Override
    public Optional<CircuitBreaker> remove(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<CircuitBreaker> replace(String name, CircuitBreaker newEntry) {
        return Optional.empty();
    }

    @Override
    public Collection<CircuitBreaker> values() {
        return null;
    }
}
