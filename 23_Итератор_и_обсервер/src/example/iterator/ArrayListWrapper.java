package example.iterator;

public class ArrayListWrapper<E> implements MyIterable<E> {
    private final java.util.ArrayList<E> internalList;

    public ArrayListWrapper() {
        this.internalList = new java.util.ArrayList<>();
    }

    public ArrayListWrapper(java.util.Collection<? extends E> collection) {
        this.internalList = new java.util.ArrayList<>(collection);
    }

    // Basic collection methods
    public boolean add(E element) {
        return internalList.add(element);
    }

    public void add(int index, E element) {
        internalList.add(index, element);
    }

    public E get(int index) {
        return internalList.get(index);
    }

    public E set(int index, E element) {
        return internalList.set(index, element);
    }

    public E remove(int index) {
        return internalList.remove(index);
    }

    public boolean remove(Object element) {
        return internalList.remove(element);
    }

    public int size() {
        return internalList.size();
    }

    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    public void clear() {
        internalList.clear();
    }

    public boolean contains(Object element) {
        return internalList.contains(element);
    }

    @Override
    public MyIterator<E> getIterator() {
        return new ArrayListWrapperIterator();
    }

    private class ArrayListWrapperIterator implements MyIterator<E> {
        private int currentIndex = 0;
        private boolean canRemove = false;
        private boolean nextWasCalled = false;

        @Override
        public boolean hasNext() {
            return currentIndex < internalList.size();  // Direct access!
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements in collection");
            }
            E element = internalList.get(currentIndex);
            currentIndex++;
            canRemove = true;
            nextWasCalled = true;
            return element;
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("next() method must be called before remove()");
            }
            internalList.remove(currentIndex - 1);
            currentIndex--;
            canRemove = false;
        }
    }

}