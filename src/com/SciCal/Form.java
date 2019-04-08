package com.SciCal;


import javax.swing.*;
import java.awt.event.*;

public class Form extends JFrame implements ActionListener
{
    private JPanel mainPanel;
    private JTextArea historyTextArea;
    private JTextField formulaInput;
    private JButton evalButton;
    private JList<Functions> functionsList;

    private String lastResult = "Empty";
    
    public Form()
    {

        DefaultListModel<Functions> model = new DefaultListModel<>();
        this.setTitle("SciCal");
        this.setVisible(true);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.setSize(800, 500);
        this.setLocation(50, 50);

        historyTextArea.setEditable(false);

        Functions f1 = new Functions("sin", "sin()");
        Functions f2 = new Functions("cos", "cos()");
        Functions f3 = new Functions("tg", "tg()");
        Functions f4 = new Functions("ctg", "ctg()");
        Functions f5 = new Functions("arcsin", "arcsin()");
        Functions f6 = new Functions("pi", "pi");
        Functions f7 = new Functions("e", "e");
        Functions f8 = new Functions("phi", "phi");
        Functions f9 = new Functions("+", "+");
        Functions f10 = new Functions("-", "-");
        Functions f11 = new Functions("*", "*");
        Functions f12 = new Functions("/", "/");
        Functions f13 = new Functions("Last result","");


        model.addElement(f1);
        model.addElement(f2);
        model.addElement(f3);
        model.addElement(f4);
        model.addElement(f5);
        model.addElement(f6);
        model.addElement(f7);
        model.addElement(f8);
        model.addElement(f9);
        model.addElement(f10);
        model.addElement(f11);
        model.addElement(f12);
        model.addElement(f13);

        functionsList.setModel(model);


        JMenu jMenuFile = new JMenu("Options");

        JMenuItem jMenuItemReset = new JMenuItem(new AbstractAction("Reset") {
            public void actionPerformed(ActionEvent e) {
                formulaInput.setText(null);
                historyTextArea.setText(null);
            }
        });
        jMenuFile.add(jMenuItemReset);

        JMenuItem jMenuItemExit = new JMenuItem(new AbstractAction("Exit") {
            public void actionPerformed(ActionEvent e) {
                System.exit(JFrame.EXIT_ON_CLOSE);
            }
        });

        jMenuFile.add(jMenuItemExit);
        JMenuBar mb = new JMenuBar();
        mb.add(jMenuFile);
        setJMenuBar(mb);

        evalButton.addActionListener(e -> {
            if (!formulaInput.getText().isEmpty())
            {
                lastResult = formulaInput.getText();

                Double result;
                try
                {
                    result = Calculate.calc(formulaInput.getText());
                    historyTextArea.append(formulaInput.getText() + " = ");
                    historyTextArea.append(result + "\n");
                    historyTextArea.append("----------------" + "\n");
                    historyTextArea.append("\n");
                    formulaInput.setText("");
                    lastResult = String.valueOf(result);
                }

                catch (InvalidEquationException e1)
                {

                }
            }
        });


        formulaInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    if (!formulaInput.getText().isEmpty())
                    {
                        lastResult = formulaInput.getText();

                        Double result;
                        try
                        {
                            result = Calculate.calc(formulaInput.getText());
                            historyTextArea.append(formulaInput.getText() + " = ");
                            historyTextArea.append(result + "\n");
                            historyTextArea.append("----------------" + "\n");
                            historyTextArea.append("\n");
                            formulaInput.setText("");
                            lastResult = String.valueOf(result);
                        }

                        catch (InvalidEquationException e1)
                        {

                        }
                    }
                }

            }
        });





        MouseListener mouseListener = new MouseAdapter()
        {

            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() >= 2)
                {
                    String equation;

                    Functions selectedItem = functionsList.getSelectedValue();


                    if (functionsList.getSelectedIndex() == 12) {
                        equation = lastResult;
                    }
                    else {
                        equation = selectedItem.funPrint;
                    }
                    String fullText = formulaInput.getText() + equation;
                    formulaInput.setText(fullText);


                    if (fullText.charAt(fullText.length() - 1) == ')')
                    {
                        int curetPosision = fullText.lastIndexOf('(' ) + 1;
                        formulaInput.requestFocusInWindow();
                        formulaInput.setCaretPosition(curetPosision);
                    }
                    else
                    {
                        formulaInput.requestFocusInWindow();
                        formulaInput.setCaretPosition(fullText.length());
                    }
                }
            }
        };
        functionsList.addMouseListener(mouseListener);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
