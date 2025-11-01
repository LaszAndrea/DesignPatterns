package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import command.*;
import factory.*;
import decorator.*;


public class CoffeeMakerPanel extends JFrame {
    
    private CoffeeInvoker invoker = new CoffeeInvoker();
    private CoffeeMachine machine = new CoffeeMachine();

    JPanel mainPanel;

    public static void main(String[] args) {
		CoffeeMakerPanel frame = new CoffeeMakerPanel();
		frame.setVisible(true);
	}

    public CoffeeMakerPanel(){

        //main screen
        setTitle("Coffee order screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 450);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.setBackground(new Color(201, 177, 148));
        mainPanel.setLayout(null);
		setContentPane(mainPanel);
		setLocationRelativeTo(null);

        //Top coffee order part - Factory & Decorator
        JPanel coffeeOrderPanel = new JPanel();
        coffeeOrderPanel.setBackground(new Color(160, 137, 99));
        coffeeOrderPanel.setBounds(0, 0, 515, 110);
        coffeeOrderPanel.setVisible(true);
        coffeeOrderPanel.setLayout(null);
        mainPanel.add(coffeeOrderPanel);

        //Label
        JLabel coffeeLabel = new JLabel();
        coffeeLabel.setText("Coffee to order ");
        coffeeLabel.setBounds(10, 10, 150, 25);
        coffeeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        coffeeLabel.setVisible(true);
        coffeeOrderPanel.add(coffeeLabel);

        //Coffee choices
        String[] choices = { "Espresso", "Latte", "Cappuccino"};
        JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setBounds(340, 10, 150, 25);
        cb.setVisible(true);
        coffeeOrderPanel.add(cb);

        //Extra choices
        JCheckBox milkCheckBox = new JCheckBox("Extra milk");
        milkCheckBox.setBounds(337, 50, 110, 15);
        milkCheckBox.setBackground(getForeground());
        milkCheckBox.setVisible(true);
        coffeeOrderPanel.add(milkCheckBox);

        JCheckBox sugarCheckBox = new JCheckBox("Extra sugar");
        sugarCheckBox.setBounds(337, 80, 110, 15);
        sugarCheckBox.setBackground(getForeground());
        sugarCheckBox.setVisible(true);
        coffeeOrderPanel.add(sugarCheckBox);

        //Middle panel - Command
        JPanel machineCommandPanel = new JPanel();
        machineCommandPanel.setBounds(0, 110, 515, 110);
        machineCommandPanel.setBackground(getForeground());
        machineCommandPanel.setVisible(true);
        machineCommandPanel.setLayout(null);
        mainPanel.add(machineCommandPanel);

        //Buttons to start the order
        JButton coffeeMachineStart = new JButton("Start coffee machine");
        coffeeMachineStart.setBounds(10, 20, 155, 40);
        coffeeMachineStart.setBackground(new Color(219, 219, 219));
        coffeeMachineStart.setVisible(true);
        machineCommandPanel.add(coffeeMachineStart);

        JButton coffeeMachineClean = new JButton("Clean coffee machine");
        coffeeMachineClean.setBounds(170, 20, 160, 40);
        coffeeMachineClean.setBackground(new Color(219, 219, 219));
        coffeeMachineClean.setVisible(true);
        machineCommandPanel.add(coffeeMachineClean);

        JButton coffeeMachineStop = new JButton("Stop coffee machine");
        coffeeMachineStop.setBounds(335, 20, 155, 40);
        coffeeMachineStop.setBackground(new Color(219, 219, 219));
        coffeeMachineStop.setVisible(true);
        machineCommandPanel.add(coffeeMachineStop);

        //CommentsScreen
        JPanel commentsPanel = new JPanel();
        commentsPanel.setBounds(0, 130, 515, 1500);
        commentsPanel.setBackground(new Color(112, 109, 84));
        commentsPanel.setVisible(true);
        commentsPanel.setLayout(null);
        mainPanel.add(commentsPanel);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(112, 109, 84));
        textArea.setForeground(new Color(219, 219, 219));
        textArea.setFont(new Font("Serif", Font.BOLD, 14));
        textArea.setEditable(false);

        JScrollPane scrollableArea = new JScrollPane(textArea);
        scrollableArea.setBounds(0, 90, 515, 192);
        commentsPanel.setBackground(new Color(112, 109, 84));
        scrollableArea.setVisible(true);
        commentsPanel.add(scrollableArea);

        //Printing out the actions
        coffeeMachineStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = cb.getSelectedItem().toString();
                Coffee currentCoffee = MakeCoffee.createCoffee(selectedType);

                Boolean extraMilk = milkCheckBox.isSelected();
                Boolean extraSugar = sugarCheckBox.isSelected();

                if(extraMilk){
                    currentCoffee = new WithMilk(currentCoffee);
                }

                if(extraSugar){
                    currentCoffee = new WithWhiteSugar(currentCoffee);
                }

                invoker.setCommand(new StartCommand(machine));

                textArea.append(invoker.pressButton());
                textArea.append(currentCoffee.prepare());
                textArea.append("\nCost: " + currentCoffee.cost() + " Ft");
            }
        });

        coffeeMachineClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.setCommand(new CleanCommand(machine));
                textArea.append(invoker.pressButton());
            }
        });

        coffeeMachineStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.setCommand(new StopCommand(machine));
                textArea.append(invoker.pressButton());
            }
        });

    }
}
