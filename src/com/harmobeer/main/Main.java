/**
 * 
 */
package com.harmobeer.main;

import com.harmobeer.mvc.view.CervejaView;

/**
 * @author José Carlos Soares da Cruz Júnior / Luan Henrique Cunha Alves
 * Classe responsável por carregar o menu, puxando diretamente da View 
 *
 */
public class Main {

	/**
	 * Método para invocar a View da classe Cerveja
	 * @param args
	 */
	public static void main(String[] args) {
		CervejaView cv = new CervejaView();
		cv.menu();
		

	}

}
