package factory;

public class Espresso implements Coffee {

    @Override
    public String prepare() {
        return "\nMaking espresso...";
    }

    @Override
    public int cost() {
        return 300;
    }

}