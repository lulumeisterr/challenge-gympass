package br.com.gympass.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Classe utilitaria reponsavel por tratar tipagem de dados
 * @author lucasrodriguesdonascimento
 * @since 15/07/2019
 */
public class UtilsGympass {
	
	
	public static String formatadorHoraStringHHmmssSSS(String horas){
		Date hora = null;
		String dataFormatada = null;
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss:SSS");
		try {
			hora = formatador.parse(horas);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dataFormatada = formatador.format(hora);
	

		return dataFormatada;
	}
	
	public static String formatadorHoraStringHHmmss(String horas){
		Date hora = null;
		String dataFormatada = null;
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
		try {
			hora = formatador.parse(horas);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dataFormatada = formatador.format(hora);

		return dataFormatada;
	}

}