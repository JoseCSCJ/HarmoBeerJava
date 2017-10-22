/**
 * 
 */
package com.harmobeer.vo;

/**
 * Classe que modela o objeto Prato
 * 
 * @author José Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 */
public class Prato {

	private int id_prato;
	private String nm_prato;


	/**
	 * Construtor da classe prato passando o id como parâmetro. Utilizado para
	 * construir o objeto em situações onde o usuário seleciona um prato.
	 * 
	 * @param id_prato
	 */
	public Prato(int id_prato) {
		this.id_prato = id_prato;
	}

	/**
	 * Construtor da classe cerveja passando o ide nome. Utilizado para construir o objeto completo, com todos os
	 * parâmetros possíveis.
	 * 
	 * @param id_prato
	 * @param nm_prato

	 */
	public Prato(int id_prato, String nm_prato) {
		this.id_prato = id_prato;
		this.nm_prato = nm_prato;
		
	}

	/**
	 * Construtor da classe cerveja passando o nome. Utilizado para inclusão da cerveja no banco de dados. O
	 * parâmetro id é recebido apenas no banco de dados.
	 * 
	 * @param nm_prato
	 */
	public Prato(String nm_prato) {
		this.nm_prato = nm_prato;
	}

	/**
	 * Método que recebe o id da prato
	 * 
	 * @return the id_prato
	 */
	public int getId_prato() {
		return id_prato;
	}

	/**
	 * Método que seta o valor do id da prato
	 * 
	 * @param id_prato
	 *            the id_prato to set
	 */
	public void setId_prato(int id_prato) {
		this.id_prato = id_prato;
	}

	/**
	 * Método que recebe o nome da prato
	 * 
	 * @return the nm_prato
	 */
	public String getNm_prato() {
		return nm_prato;
	}

	/**
	 * Método que seta o valor do nome da prato
	 * 
	 * @param nm_prato
	 *            the nm_prato to set
	 */
	public void setNm_prato(String nm_prato) {
		this.nm_prato = nm_prato;
	}


}
