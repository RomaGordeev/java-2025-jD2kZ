package example.observer;

import java.util.ArrayList;
import java.util.List;

class DataSubject implements Subject<DataSubject> {
    private List<Observer<DataSubject>> observers = new ArrayList<>();

    public void SetData() {
        IO.println("Setting data");
        //Установка полезной информации

        Notify(); // Оповещение об изменении состояния
    }

    public void GetData() {
        //Получение полезной информации
    }

    @Override
    public void Attach(Observer<DataSubject> obs) {
        observers.add(obs);
    }

    @Override
    public void Detach(Observer<DataSubject> obs) {
        observers.remove(obs);
    }

    @Override
    public void Notify() {
        for (Observer<DataSubject> obs : observers) {
            obs.Update(this);
        }
    }
}

class PieChart implements Observer<DataSubject> {
    @Override
    public void Update(DataSubject dataSubj) {
        //Cообщение об изменении состояния отслеживаемого объекта
        IO.println("PieChart is refreshing");
    }
}

class PillarsGraph implements Observer<DataSubject> {
    @Override
    public void Update(DataSubject dataSubj) {
        //Cообщение об изменении состояния отслеживаемого объекта
        IO.println("PillarsGraph is refreshing");
    }
}
