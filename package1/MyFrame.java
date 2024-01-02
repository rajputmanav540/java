package package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class MyFrame extends JFrame implements ActionListener {

    JButton buttonCut;
    JButton buttonCopy;
    JButton buttonPaste;
    JButton button1;
    JTextField textField;
    int cutStart;
    int cutEnd;
    String copiedText;

    MyFrame() {
        // First Button: Cut
        buttonCut = new JButton("Cut");
        buttonCut.setBounds(400, 100, 100, 50);
        buttonCut.addActionListener(e -> {
            cutStart = getIntegerInput("Enter start index:");
            cutEnd = getIntegerInput("Enter end index:");

            if (cutStart >= 0 && cutEnd <= textField.getText().length() && cutStart <= cutEnd) {
                copiedText = textField.getText().substring(cutStart, cutEnd);
                Document doc = textField.getDocument();
                try {
                    doc.remove(cutStart, cutEnd - cutStart);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Cut text = " + copiedText); // Display cut text on the terminal
                System.out.println("Final text = " + textField.getText()); // Display final text on the terminal
            } else {
                JOptionPane.showMessageDialog(this, "Invalid indices. Please enter valid indices.");
            }
        });

        // Second Button: Copy
        buttonCopy = new JButton("Copy");
        buttonCopy.setBounds(500, 100, 100, 50);
        buttonCopy.addActionListener(e -> {
            System.out.println("Text is copied"); // Display message on the terminal
        });

        // Third Button: Paste
        buttonPaste = new JButton("Paste");
        buttonPaste.setBounds(600, 100, 100, 50);
        buttonPaste.addActionListener(e -> {
            int pasteIndex = getIntegerInput("Enter paste index:");

            if (pasteIndex >= 0 && pasteIndex <= textField.getText().length()) {
                Document doc = textField.getDocument();
                try {
                    doc.insertString(pasteIndex, copiedText, null);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                textField.setCaretPosition(pasteIndex + copiedText.length());
                System.out.println("Pasted text at index " + pasteIndex + ": " + copiedText);
                System.out.println("Final text = " + textField.getText()); // Display final text on the terminal
            } else {
                JOptionPane.showMessageDialog(this, "Invalid paste index. Please enter a valid index.");
            }
        });

        this.setTitle("Manav's Text editor");
        this.setLayout(null);
        this.setSize(800, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("Enter text:");
        button1.setBounds(10, 100, 100, 50);
        button1.addActionListener(this);

        textField = new JTextField();
        textField.setBounds(120, 100, 250, 40);

        this.add(button1);
        this.add(textField);
        this.add(buttonCut);
        this.add(buttonCopy);
        this.add(buttonPaste);

        this.setVisible(true);
    }

    private int getIntegerInput(String message) {
        String input = JOptionPane.showInputDialog(this, message);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            System.out.println("Text you entered = " + textField.getText());
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new MyFrame());
    }
}
