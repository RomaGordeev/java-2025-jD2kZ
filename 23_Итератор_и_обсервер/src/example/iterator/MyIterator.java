package example.iterator;

public interface MyIterator<T> {
    boolean hasNext();
    T next();
    void remove();
}