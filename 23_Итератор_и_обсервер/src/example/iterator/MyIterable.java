package example.iterator;

import java.util.function.Consumer;

public interface MyIterable<T> {
    MyIterator<T> getIterator();

    default void forEach(Consumer<? super T> action) {
        MyIterator<T> iterator = getIterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }
}