public class Main {

    public static void main(String[] args) {
        Basket basket1 = new Basket();
        basket1.add("Молоко", 1, 1,1.23);
        basket1.add("Яйца", 2, 3,1.23);

        Basket basket2 = new Basket();
        basket2.add("Молоко", 1, 1,1.23);
        basket2.add("Яйца", 2, 3,1.23);

        basket1.printBasketInfo("---КОРЗИНА 1---");
        basket2.printBasketInfo("---КОРЗИНА 2---");
        Basket.printAllBasketsInfo();
    }
}
