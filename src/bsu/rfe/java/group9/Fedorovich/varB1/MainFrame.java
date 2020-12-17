package bsu.rfe.java.group9.Fedorovich.varB1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainFrame extends JFrame
{

    }

    public static void main(String[] args)
    {
        // Если не задано ни одного аргумента командной строки -
        // Продолжать вычисления невозможно, коэффиценты неизвестны
        if (args.length==0)
        {
            System.out.println("Невозможно табулировать многочлен, для которого не задано ни одного коэффициента!");
            System.exit(-1);
        }
        // Зарезервировать места в массиве коэффициентов столько, сколько аргументов командной строки
        Double[] coefficients = new Double[args.length];
        int i = 0;
        try
        {
            // Перебрать аргументы, пытаясь преобразовать их в Double
            for (String arg: args)
            {
                coefficients[i++] = Double.parseDouble(arg);
            }
        }
        catch (NumberFormatException ex)
        {
            // Если преобразование невозможно - сообщить об ошибке и завершиться
            System.out.println("Ошибка преобразования строки '" +
                    args[i] + "' в число типа Double");
            System.exit(-2);
        }
        // Создать экземпляр главного окна, передав ему коэффициенты
        MainFrame frame = new MainFrame(coefficients);
        // Задать действие, выполняемое при закрытии окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}