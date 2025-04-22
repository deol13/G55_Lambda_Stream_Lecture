package se.lexicon;

@FunctionalInterface
public interface TaskFilter {
    boolean matches(Todo todo);
}
