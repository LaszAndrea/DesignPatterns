package factory;

public class Latte implements Coffee{

    @Override
    public String prepare() {
        return "\nMaking latte...";
    }

    @Override
    public int cost() {
        return 500;
    }
    
}
