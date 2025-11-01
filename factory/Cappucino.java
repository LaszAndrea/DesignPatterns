package factory;

public class Cappucino implements Coffee{

    @Override
    public String prepare() {
        return "\nMaking cappuccino...";
    }

    @Override
    public int cost() {
        return 800;
    }
    
}
