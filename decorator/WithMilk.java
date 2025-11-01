package decorator;

import factory.*;

public class WithMilk extends PlusElements {
    
    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    public String prepare() {
        return  super.prepare() + " + Milk added";
    }

    @Override
    public int cost() {
        return super.cost() + 200;
    }

}
