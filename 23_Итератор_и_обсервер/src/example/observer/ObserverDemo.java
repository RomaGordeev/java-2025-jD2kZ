package example.observer;

class ObserverDemo {
    void main() {
        var ds = new DataSubject();

        var pc = new PieChart();
        var pg = new PillarsGraph();

        ds.Attach(pc);
        ds.Attach(pg);

        ds.SetData();
    }
}
