package decorator;

import factory.*;

abstract class PlusElements implements Coffee {

    protected Coffee decoratedCoffee;

    public PlusElements(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String prepare() {
        return decoratedCoffee.prepare();
    }

    @Override
    public int cost() {
        return decoratedCoffee.cost();
    }
    
}
