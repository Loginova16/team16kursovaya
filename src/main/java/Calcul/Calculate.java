package Calcul; // Используем пакет Калькулятор

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel; 

public class Calculate implements CalculateInterface{ // Создаем класс Calculate использующий CalculateInterface
	public static String result;
	boolean isPremia = false; 
	boolean ychitivatNalog = false;
	public static float H, T, a, D1,D2, C, Z, X, c; // H- РЅР°Р»РѕРі T-С‚Р°СЂРёС„РЅР°СЏ СЃС‚Р°РІРєР° a-РїСЂРѕС†РµРЅС‚ РїСЂРµРјРёРё D1-РЅРѕРІР°СЏ СЃСѓРјРјР° Р·Р°СЂРїР»Р°С‚С‹(Р‘Р•Р— РЈР§Р•РўРђ РќР”Р¤Р›) D2-РЅРѕРІР°СЏ СЃСѓРјРјР° РІРєР»Р°РґР°(РЎ РЈР§Р•РўРћРњ РќР”Р¤Р›) РЎ-
	protected static String line;
	@Override // РџРµСЂРµРѕРїСЂРµРґРµР»СЏРµС‚ РјРµС‚РѕРґ РёРЅС‚РµСЂС„РµР№СЃР°
	public void CalculateNalog()
	{
		if(isPremia) {
			try {
			File file = new File("prem.txt");
			//создаем объект FileReader для объекта File
			FileReader fr = new FileReader(file);
			//создаем BufferedReader с существующего FileReader для построчного считывания
			BufferedReader reader = new BufferedReader(fr);
			// считаем сначала первую строку
			line = reader.readLine();


			
			c = Float.parseFloat(line);
			System.out.println(c);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}


	H = (float) (T*Z*X)*c;
	}else {
	H = (float) (T*Z*X);

	}}
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
