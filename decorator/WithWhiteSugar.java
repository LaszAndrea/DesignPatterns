package decorator;

import factory.Coffee;

public class WithWhiteSugar extends PlusElements {

    public WithWhiteSugar(Coffee coffee) {
        super(coffee);
    }

    public String prepare() {
        return super.prepare() + " + White sugar added";
    }

    @Override
    public int cost() {
        return super.cost() + 150;
    }
    
}
