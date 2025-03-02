import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, deleteButton, clearButton;
    JPanel panel;

    Font font = new Font("Arial", Font.BOLD, 30);

    double number1, number2, result;
    char operation;

    Calculator() {
        createGUI();
    }

    public void createGUI() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setFont(font);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        deleteButton = new JButton("DEL");
        clearButton = new JButton("CLR");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        equalsButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        addButton.setFont(font);
        subtractButton.setFont(font);
        multiplyButton.setFont(font);
        divideButton.setFont(font);
        equalsButton.setFont(font);
        deleteButton.setFont(font);
        clearButton.setFont(font);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divideButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(multiplyButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subtractButton);
        panel.add(numberButtons[0]);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(addButton);

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == addButton) {
            number1 = Double.parseDouble(textField.getText());
            operation = '+';
            textField.setText("");
        }

        if (e.getSource() == subtractButton) {
            number1 = Double.parseDouble(textField.getText());
            operation = '-';
            textField.setText("");
        }

        if (e.getSource() == multiplyButton) {
            number1 = Double.parseDouble(textField.getText());
            operation = '*';
            textField.setText("");
        }

        if (e.getSource() == divideButton) {
            number1 = Double.parseDouble(textField.getText());
            operation = '/';
            textField.setText("");
        }

        if (e.getSource() == equalsButton) {
            number2 = Double.parseDouble(textField.getText());

            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
            }

            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == deleteButton) {
            String str = textField.getText();
            textField.setText(str.substring(0, str.length() - 1));
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}