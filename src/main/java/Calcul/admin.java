package Calcul;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class admin {
public admin(){
JFrame main_GUI = new JFrame("Зарплатный калькулятор"); // создание графического окна
main_GUI.setTitle ("Калькулятор");
main_GUI.setBounds(500,200,440,400);
main_GUI.setResizable(false); // фиксированный размер окна

final JPanel main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
main_panel.setLayout(null);
main_GUI.add(main_panel);

JLabel laba_info = new JLabel("Зарплатный калькулятор"); // Отображение текста или изображения
laba_info.setBounds(135,0,150,30);
main_panel.add(laba_info);

JButton button_exit = new JButton("Выход"); // добавляем кнопку Выход
button_exit.setBounds(270,280,130,40);
ActionListener actionListener = new ListenerButton(); //создаем слушатель
button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
main_panel.add(button_exit);
main_GUI.setVisible(true);

main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}} 