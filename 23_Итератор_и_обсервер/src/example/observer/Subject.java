package example.observer;

interface Subject<T> {
    void Attach(Observer<T> obs);
    void Detach(Observer<T> obs);
    void Notify();
}
