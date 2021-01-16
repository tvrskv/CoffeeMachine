package machine;

public enum CoffeeTypes {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int beans;
    private final int price;

    CoffeeTypes (int water, int milk, int coffeeBeans, int price) {
        this.water = water;
        this.milk = milk;
        this.beans = coffeeBeans;
        this.price = price;
    }

    public int getWater(){
        return water;
    }

    public int getMilk(){
        return milk;
    }

    public int getBeans(){
        return beans;
    }

    public int getPrice(){
        return price;
    }
}