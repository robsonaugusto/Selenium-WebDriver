package br.ce.robson.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	
	public static Date obterDataComDiferencaDias(int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();
		
	}
	
	public static String ObterDataFormatada(Date data) {
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		return format.format(data);
		
		
	}
	

}
