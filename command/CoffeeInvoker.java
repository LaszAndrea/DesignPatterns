package command;

public class CoffeeInvoker {
    
    private Command command;
    
    public void setCommand(Command command) { 
        this.command = command; 
    }
    
    public String pressButton() { 
        return command.execute(); 
    }
}
