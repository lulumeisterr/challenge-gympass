package br.com.gympass.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.gympass.main.UtilsGympass;
import br.com.gympass.model.Piloto;

/**
 * Classe responsavel por manipular o arquivo
 * @author lucasrodriguesdonascimento
 */

public class Desafio {

	// Ajustar o diretorio para pegar caminho relativo
	static File arq = new File("txt/V01_LOG_KART.txt");

	public static void main(String[] args) throws ParseException {
		try {
			resultadoEsperado();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author lucasrodriguesdonascimento
	 *  Metodo responsavel por ler o Arquivo  V01_LOG_KART.txt e trafegar os dados
	 *  para um objeto java (Piloto)
	 *  
	 * @param fileReader
	 * @return listaPiloto
	 * @throws IOException
	 * @throws ParseException
	 * @since 15/07/2019
	 */

	private static List<Piloto> recuperandoObjetoTXT(FileReader fileReader) throws IOException, ParseException {

		ArrayList<Piloto> listaPiloto = new ArrayList<Piloto>();

		String array [] = new String[5];
		Piloto piloto = null;

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String linha = "";

		linha = bufferedReader.readLine();

		while ((linha = bufferedReader.readLine()) != null) {

			array = linha.split(";");

			piloto = new Piloto();
			
			piloto.setId(Integer.parseInt(array[1]));
			piloto.setNome(array[2]);
			piloto.setNumeroVoltas(Integer.parseInt(array[3]));
			piloto.setHora(UtilsGympass.formatadorHoraStringHHmmssSSS(array[0]));
			piloto.setVelocidadeMedia(Float.parseFloat(array[5]));
			piloto.setTempoVolta(UtilsGympass.formatadorHoraStringHHmmss((array[4])));

			listaPiloto.add(piloto);
		}
		return listaPiloto;
	}

	/**
	 * @author lucasrodriguesdonascimento
	 * Metodo responsavel por exibir as regras de negocio solicitadas no exercicio
	 * 
	 * informações: Posição Chegada, 
	 * Código Piloto, Nome Piloto, Qtde Voltas Completadas e Tempo Total de Prova.
	 * 
	 * @throws IOException
	 * @throws ParseException
	 * @since 15/07/2019
	 */
	private static void resultadoEsperado() throws IOException, ParseException {
		FileReader fileReader = new FileReader(arq);
		List<Piloto> recuperandoObjeto = recuperandoObjetoTXT(fileReader);

		int posicao = 0;
		int qtdVoltasCompletas = 0;
		
		for (int i = 0; i < recuperandoObjeto.size(); i++) {
			if(recuperandoObjeto.get(i).getNumeroVoltas() >= 4 && recuperandoObjeto.get(i).getTempoVolta().compareTo(recuperandoObjeto.get(i+1).getTempoVolta()) < 0) {

				qtdVoltasCompletas = qtdVoltasCompletas + recuperandoObjeto.get(i).getNumeroVoltas();
				posicao = posicao + 1;

				System.out.println("Posicao de Chegada : " + posicao + "\t" +
						"Codigo do Piloto : " + recuperandoObjeto.get(i).getId() + "\t" +
						"Nome Piloto: " + recuperandoObjeto.get(i).getNome() + "\t" +
						"Qtde Voltas Completadas : " +  recuperandoObjeto.get(i).getNumeroVoltas() + "\t" +
						"Tempo Total de Prova : " +  recuperandoObjeto.get(i).getTempoVolta());
			}
		}
	}
}