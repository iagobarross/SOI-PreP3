/*	Pegar o conteudo do site:http://api.worldbank.org/v2/countries/IND/indicators/SP.POP.TOTL?per_page=5000&format=json 
 * 	(Usar modo RAW ou Dados Brutos), esse site traz um arquivo com a população indiana ao longo dos anos, a aprtir de 1960.
 *  Gravar em um arquivo chamado pop.json na pasta C:\TEMP (\tmp se for Linux) e fazer uma aplicacao java que, na classe 
 *  principal, no metodo Main peca ao usuario uma data, chame uma classe de controle que leia o arquivo, e, apresente o value
 *  com a população. (Caso nao exista, lancar uma excecao). Obs.: Não são permitidos usos de Bibliotecas, Frameworks e APIs,
 *  apenas operações de arquivos trabalhadas em aula.package controller;
 */

package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ControllerIndia {

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void searchPop(int ano) throws Exception {
		String os = os();
		int population = 0;
		boolean found = false;

		if (os.contains("Windows")) {
			String path = "C:/Temp";
			population = search(ano, path);
			found = true;
		}

		if (os.contains("Linux")) {
			String path = "/tmp";
			population = search(ano, path);
			found = true;
		}

		if (found) {
			JOptionPane.showMessageDialog(null, "A população indiana em " + ano + " era de " + population + " pessoas",
					"População Indiana", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private int search(int ano, String path) throws Exception {

		File arq = new File(path, "pop.json");
		FileInputStream fis = new FileInputStream(arq);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader buffer = new BufferedReader(isr);
		String linha = buffer.readLine();
		int population = 0;
		boolean found = false;

		while (linha != null) {
			linha.trim();
			String[] vetLinha = linha.split(":");
			if (vetLinha[0].contains("date") && vetLinha[1].contains(Integer.toString(ano))) {
				linha = buffer.readLine();
				String[] vetLinha2 = linha.split(":");
				String pop = vetLinha2[1].trim().replaceAll(",", "").replaceAll("}", "");
				population = Integer.parseInt(pop);
				found = true;
				break;
			}
			linha = buffer.readLine();
		}

		buffer.close();
		isr.close();
		fis.close();

		if (!found) {
			throw new Exception();
		}

		return population;
	}
}
