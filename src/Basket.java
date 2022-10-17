public class Basket {

    private static int basketCount = 0;

    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

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

    public static int getBasketCount() {
        return basketCount;
    }

    public double getTotalWeight(){
        return totalWeight;
    }

    public static void increaseBasketCount(int count) {
        Basket.basketCount = Basket.basketCount + count;
    }

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
            itemsCount + " шт. - " + price;
        totalPrice = totalPrice + itemsCount * price;
    }
    public void add(String name, int price, int itemsCount, double itemsWeight){
        this.add(name, price, itemsCount);
        totalWeight = totalWeight + itemsWeight * itemsCount;
    }
    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общий вес товаров: " + getTotalWeight());
        }
    }
}
