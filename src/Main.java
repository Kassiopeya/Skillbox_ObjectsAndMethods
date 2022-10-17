public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Молоко", 40, 3, 1);
        basket.add("Яйца", 20, 1,1.23);
        basket.print("Корзина");
    }
}
