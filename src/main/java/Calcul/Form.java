package Calcul;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //библиотека для события слушателя
import java.io.File;

import javax.swing.*; // Библиотека для GUI (построена на основе awt)

import Calcul.ListenerCreate;
public class Form {
	static JComboBox<?> combobox; // добавление JComboBox
	public static JTextField sum_field;
	public static JTextField term_field;
	public static JTextField rate_field;
	public static JTextField output_field;
		
	public Form() {
		JFrame main_GUI = new JFrame("Зарплатный калькулятор");	// создание графического окна
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
		button_exit.setBounds(295,280,130,40);
		ActionListener actionListener = new ListenerButton(); //создаем слушатель
		button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
		main_panel.add(button_exit);
		
		JLabel sum_label = new JLabel ("Тарифная ставка: "); // Добавляем надпись 
		sum_label.setBounds(10,50,120,40);
		main_panel.add(sum_label);
		
		
		sum_field = new JTextField ();  // Добавляем поле ввода
		sum_field.setBounds(300, 55, 100, 30);
		main_panel.add(sum_field);
		
		
		
		
		JLabel term_label = new JLabel ("Кол-во раб. ед. времени за смену:"); // Добавляем надпись
		term_label.setBounds(10,90,300,60);
		main_panel.add(term_label);
		JLabel sum_labe2 = new JLabel ("(дневная (1) /часовая (кол-во часов за смену)"); // Добавляем надпись 
		sum_labe2.setBounds(10,113,300,60);
		main_panel.add(sum_labe2);
		term_field = new JTextField ();  // Добавляем поле для ввода
		term_field.setBounds(300, 105, 100, 30);
		main_panel.add(term_field);
		
		JLabel rate_label = new JLabel ("Кол-во рабочих дней в месяце: ");  // Добавляем надпись
		rate_label.setBounds(10,150,300,40);
		main_panel.add(rate_label);
		rate_field = new JTextField ();  // Добавляем поле для ввода 
		rate_field.setBounds(300, 155, 100, 30);
		main_panel.add(rate_field);
		
		JLabel premia_label = new JLabel ("Считать с премией "); // Добавляем надпись 
		premia_label.setBounds(10,230,115,40);
		main_panel.add(premia_label);
		
		JCheckBox premia_cbox = new JCheckBox();
		premia_cbox.setBounds(135,230,40,40);
		main_panel.add(premia_cbox);
		
		JButton button_create = new JButton("Create PDF"); // добавляем кнопку
		button_create.setBounds(160,280,125,40);
		ActionListener actionCreate = new ListenerCreate(); //создаем слушатель для кнопки PDF
		button_create.addActionListener(actionCreate); // добавляем слушатель к кнопке
		main_panel.add(button_create);
		
		JMenuBar bar = new JMenuBar();  
		main_GUI.setJMenuBar(bar);
		JMenu menu = new JMenu("Меню");
		main_panel.add(menu);
		bar.add(menu);
		
		JMenuItem info = new JMenuItem("Информация о расчете налога");
		main_panel.add(info);
		menu.add(info);
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				JOptionPane.showMessageDialog(main_panel, "Налоговый кодекс РФ предусматривает предусматривает налогооблажение \n на  доходы физических лиц в разамере 13%:\n"
					);
			}
		});
		JMenuItem prem = new JMenuItem("Информация о расчете премии");
		main_panel.add(prem);
		menu.add(prem);
		prem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				JOptionPane.showMessageDialog(main_panel, "Особое вознаграждение рабочим начисляется в размере 20% к основному \n доходу в месяц "
					);
			}
		});
		
		JMenuItem students = new JMenuItem("Информация о разработчиках");
		menu.add(students); // добавляем кнопку на выпадаюзее меню
		students.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				Info Information = new Info("Информация о разработчиках", 500, 110); 
				JLabel students_label1 = new JLabel ("Модератор - Логинова Анастасия"); // Добавляем надпись 
				students_label1.setBounds(20,10,250,30); // задаем размер
				Information.add(students_label1);
				JLabel students_label2 = new JLabel ("Разработчик 1 - Хайруллина Элина"); // Добавляем надпись 
				students_label2.setBounds(20,35,250,30); // задаем размер
				Information.add(students_label2); 
				JLabel students_label3 = new JLabel ("Разработчик 4 - User416"); // Добавляем надпись 
				students_label3.setBounds(260,10,250,30); // задаем размер
				Information.add(students_label3);
				JLabel students_label5 = new JLabel (""); // Добавляем надпись 
				students_label5.setBounds(260,35,250,30); // задаем размер
				Information.add(students_label5);
				
			}
		});
		
		JMenuItem exit = new JMenuItem("Выход");
		main_panel.add(exit);
		menu.add(exit);
		exit.addActionListener(actionListener);
		
		
		
		String [] tax = { "Включать в расчет", "Не включать в расчет"
		};
		
		JComboBox tax_box = new JComboBox(tax); // Создаем выпадающий бокс
		tax_box.setBounds(135,195,215,30);
		main_panel.add(tax_box);
		
		
		JButton calc = new JButton("Рассчитать");
		calc.addActionListener(new ActionListener() { // Добавляем слушателя нажатия кнопки
			@Override
			public void actionPerformed(ActionEvent e) {
				String nalogstr = tax_box.getSelectedItem().toString();
				boolean ychitivatNalog = true;
				if(nalogstr == "Не включать в расчет")
					ychitivatNalog = false;
				Calculate calc = new Calculate(rate_field.getText(),term_field.getText(),sum_field.getText(),premia_cbox.isSelected(),ychitivatNalog);
			}
	    });
		calc.setBounds(20, 280, 130, 40);
		main_panel.add(calc);
		
		JLabel tax_label = new JLabel ("Налог: "); // Добавляем надпись 
		tax_label.setBounds(10,190,115,40);
		main_panel.add(tax_label);
				
		main_GUI.setVisible(true);
		
		
		main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
		}
		
		
		public static void main(String[] args) {
			Avtorization student = new Avtorization();
			
		}
		

	}

