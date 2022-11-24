public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Молоко", 1, 1,1.23);
        basket.add("Яйца", 2, 3,1.23);
        basket.printBasketInfo("Корзина");
        basket.printAllBasketsInfo();
    }
}
