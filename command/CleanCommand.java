package command;

public class CleanCommand implements Command {
    
    private CoffeeMachine machine;

    public CleanCommand(CoffeeMachine machine) { 
        this.machine = machine; 
    }
    
    public String execute() { return machine.clean(); }

}
