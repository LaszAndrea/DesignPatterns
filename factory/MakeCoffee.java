package factory;

// Factory
public class MakeCoffee {

    public static Coffee createCoffee(String type) {
        switch (type.toLowerCase()) {
            case "espresso": return new Espresso();
            case "latte": return new Latte();
            case "cappuccino": return new Cappucino();
            default: throw new IllegalArgumentException("Ismeretlen kávétípus: " + type);
        }
    }
    
}