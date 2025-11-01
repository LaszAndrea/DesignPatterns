package command;

public class StopCommand implements Command {

    private CoffeeMachine machine;

    public StopCommand(CoffeeMachine machine) { 
        this.machine = machine; 
    }
    
    public String execute() { return machine.stop(); }
    
}
