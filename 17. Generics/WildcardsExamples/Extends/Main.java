class Animal {
    public void feed() {
        System.out.println("Кормим животное");
    }
}

class Dog extends Animal {
    @Override
    public void feed() {
        System.out.println("Кормим собаку");
    }
}

class Cat extends Animal {
    @Override
    public void feed() {
        System.out.println("Кормим кошку");
    }
}

public class Main {

    // Метод принимает список любых наследников Animal
    public static void feedAllAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            a.feed(); // ✅ можно читать
        }

        // animals.add(new Dog()); // ❌ нельзя добавлять — неизвестно, какой конкретный тип стоит в списке
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());

        feedAllAnimals(dogs);     // Работает с List<Dog>
        feedAllAnimals(cats);     // Работает с List<Cat>
        feedAllAnimals(animals);  // Работает с List<Animal>

        // feedAllAnimals(new ArrayList<String>()); // ❌ не компилируется
    }
}
