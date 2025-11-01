package command;

public class StartCommand implements Command {

    private CoffeeMachine machine;

    public StartCommand(CoffeeMachine machine) { 
        this.machine = machine; 
    }
    
    public String execute() { return machine.start(); }
    
}
