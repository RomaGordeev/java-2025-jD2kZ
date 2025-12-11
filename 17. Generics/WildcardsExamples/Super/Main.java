class Goods{}
class Grocery extends Goods{}
class Vegetables extends Grocery{}

public class Main{
    // (1)
    public static void addVegetables(List<Vegetables> goodsBasket){
        goodsBasket.add(new Vegetables());
    }
    
    // (2)
    public static void addVegetablesCommon(List<Goods> goodsBasket){
        goodsBasket.add(new Vegetables());
    }

    // (3)
    public static void addVegetablesWildcards(List<? super Vegetables> goodsBasket){
        goodsBasket.add(new Vegetables());
    }

    public static void main(String[] args) {
        List<Goods> goodsBasket = new ArrayList<>();
        List<Grocery> groceryBasket = new ArrayList<>();
        
        addVegetables(goodsBasket); // The method is not applicable for the arguments (List<Goods>)

        addVegetablesCommon(goodsBasket); // Да, но:
        addVegetablesCommon(groceryBasket); // The method is not applicable for the arguments (List<Goods>)

        addVegetablesWildcards(goodsBasket);
        addVegetablesWildcards(groceryBasket);

        
    }
}
