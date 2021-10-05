package Calcul; // Используем пакет Калькулятор

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel; 

public class Calculate implements CalculateInterface{ // Создаем класс Calculate использующий CalculateInterface
	public static String result;
	boolean isPremia = false; 
	boolean ychitivatNalog = false;
	float H, T, a, D1,D2, C, Z, X; // H- налог T-тарифная ставка a-процент премии D1-новая сумма зарплаты(БЕЗ УЧЕТА НДФЛ) D2-новая сумма вклада(С УЧЕТОМ НДФЛ) С-
	
	@Override // Переопределяет метод интерфейса
	public void CalculateNalog()
	{
		if (isPremia)

			H = (float) (T*Z*X)*1.2f;
			else 
			H = (float) (T*Z*X);

			}
	@Override
	public void CalculatePrecent() {
		//высчитываем новую сумму зп с учетом процентов
		D1 =  (float) H;
	}
	@Override 
	public void CalculateDohod() {
		//считаем итоговое значение зп, с учетом или без учета налога
		if (ychitivatNalog)
			D2 = (float) (H * 0.87);
		else
			D2 = D1;
	}
	public Calculate(String X_str, String Z_str, String T_str, boolean premia, boolean _ychitivatNalog) // Конструктор
	{
	
		this.ychitivatNalog = _ychitivatNalog;
		this.isPremia = premia;
		if(!ParseAllData(X_str,Z_str,T_str)) 
		{
			// данные не удалось сконвертировать -  ошибка ввода
			JFrameText output = new JFrameText("Ошибка", 150, 50); //создаем всплывающее окно для вывода результатов
			output.SetData("Ошибка ввода"); //создаем лейбл на нашем окне с текстом ошибки
			return;
		}
		CalculateAll();
		JFrameText output = new JFrameText("Расчет", 250, 100);
		output.SetData("Сумма зарплаты составила:" + String.valueOf(D2));
		result = String.valueOf(D2);
	}
	//проверяем все ли введенные данные являются числами (могут ли быть сконвертированны в Float и не пустые) и запоминаем
	public boolean ParseAllData(String X_str, String Z_str, String T_str) 
	{
		if(isFloat(X_str) && X_str.length()!=0)
			X = Float.parseFloat(X_str);
		else return false;
		if(isFloat(Z_str) && Z_str.length()!=0)
			Z = Float.parseFloat(Z_str);
		else return false;
		if(isFloat(T_str) && T_str.length()!=0)
			T = Float.parseFloat(T_str);
		else return false;
		return true;
	}
	//может ли строка быть сконвертирована в Float
	public boolean isFloat(String x) throws NumberFormatException
	{
	    try {
	        Float.parseFloat(x);
	        return true;
	    } catch(Exception e) {
	        return false;
	    }
	}
	public float getFinalValue() {
		return D2; //возвращает итоговое значение 
	}
}
