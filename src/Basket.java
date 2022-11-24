public class Basket {

    public static double totalPriceInAllBaskets;
    public static int totalItemsCount;
    private static int basketCount = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public double getTotalWeight() {
        return totalWeight;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public Basket() {
        increaseBasketCount(1);
        items = "Список товаров:";
        this.limit = 10000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

        public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static void increaseBasketCount(int count) {
        Basket.basketCount = Basket.basketCount + count;
    }

    public static void increaseTotalItemsCount(int itemsCount){
        totalItemsCount = totalItemsCount + itemsCount;
    }

    public static void increaseTotalPriceInAllBaskets(int price, int itemsCount){
        totalPriceInAllBaskets = totalPriceInAllBaskets + price * itemsCount;
    }

    static double countBasketPriceAverage(){
        return totalPriceInAllBaskets / basketCount;
    }

    static double countItemPriceAverage(){
        return totalPriceInAllBaskets / totalItemsCount;
    }

// вот тут опасно. Если мы выводим в консоль общий вес товаров, то нельзя давать добавлять товар без указания веса
    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int itemsCount) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + itemsCount * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                itemsCount + " шт. - " + price + "руб./шт";
        totalPrice = totalPrice + itemsCount * price;
        increaseTotalItemsCount(itemsCount);
        increaseTotalPriceInAllBaskets(price, itemsCount);
    }

    public void add(String name, int price, int itemsCount, double itemsWeight) {
        this.add(name, price, itemsCount);
        totalWeight = totalWeight + itemsWeight * itemsCount;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void printBasketInfo(String title) {
        System.out.println("\n" + title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общий вес товаров: " + getTotalWeight());

        }
    }

    public static void printAllBasketsInfo(){
        System.out.println("\n" + "Информация по всем корзинам: ");
        System.out.println("Общее количество корзин: " + basketCount);
        System.out.println("Общее количество всех товаров во всех корзинах: " + totalItemsCount);
        System.out.println("Общая стоимость всех товаров во всех корзинах: " + totalPriceInAllBaskets);
        System.out.println("Средняя стоимость корзины: " + countBasketPriceAverage());
        System.out.println("Cредняя стоимость товара: " + countItemPriceAverage());
    }
}
