/**
 * 
 */
package com.harmobeer.vo;

/** 
 * Classe que modela o objeto Cerveja
 * 
 * @author Jos� Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 */
public class Cerveja {
	
	private int id_cerv;
	private String nm_cerv;
	private String nm_estilo;
	private double teor_alcool;
	
	/**
	 * Construtor da classe cerveja passando o id como par�metro. 
	 * Utilizado para construir o objeto em situa��es onde o usu�rio seleciona uma cerveja.
	 * @param id_cerv
	 */
	public Cerveja(int id_cerv) {
		this.id_cerv = id_cerv;
	}
	
	/**
	 * Construtor da classe cerveja passando o id, nome, estilo e teor �lcoolico como par�metros.
	 * Utilizado para construir o objeto completo, com todos os par�metros poss�veis.
	 * @param id_cerv
	 * @param nm_cerv
	 * @param nm_estilo
	 * @param teor_alcool
	 */
	public Cerveja(int id_cerv, String nm_cerv, String nm_estilo, double teor_alcool) {
		this.id_cerv = id_cerv;
		this.nm_cerv = nm_cerv;
		this.nm_estilo = nm_estilo;
		this.teor_alcool = teor_alcool;
	}
	
	/**
	 * Construtor da classe cerveja passando o nome, estilo e teor �lcoolico como par�metros.
	 * Utilizado para inclus�o da cerveja no banco de dados. O par�metro id � recebido apenas no banco de dados. 
	 * @param nm_cerv
	 * @param nm_estilo
	 * @param teor_alcool
	 */
	public Cerveja(String nm_cerv, String nm_estilo, double teor_alcool) {
		this.nm_cerv = nm_cerv;
		this.nm_estilo = nm_estilo;
		this.teor_alcool = teor_alcool;
	}

	/**
	 * M�todo que recebe o id da cerveja
	 * @return the id_cerv
	 */
	public int getId_cerv() {
		return id_cerv;
	}

	/**
	 * M�todo que seta o valor do id da cerveja
	 * @param id_cerv the id_cerv to set
	 */
	public void setId_cerv(int id_cerv) {
		this.id_cerv = id_cerv;
	}

	/**
	 * M�todo que recebe o nome da cerveja
	 * @return the nm_cerv
	 */
	public String getNm_cerv() {
		return nm_cerv;
	}

	/**
	 * M�todo que seta o valor do nome da cerveja
	 * @param nm_cerv the nm_cerv to set
	 */
	public void setNm_cerv(String nm_cerv) {
		this.nm_cerv = nm_cerv;
	}

	/**
	 * M�todo que recebe o estilo da cerveja
	 * @return the nm_estilo
	 */
	public String getNm_estilo() {
		return nm_estilo;
	}

	/**
	 * M�todo que seta o valor do estilo da cerveja
	 * @param nm_estilo the nm_estilo to set
	 */
	public void setNm_estilo(String nm_estilo) {
		this.nm_estilo = nm_estilo;
	}

	/**
	 * M�todo que recebe o teor �lcoolico da cerveja
	 * @return the teor_alcool
	 */
	public double getTeor_alcool() {
		return teor_alcool;
	}

	/**
	 * M�todo que seta o valor do teor �lcoolico da cerveja
	 * @param teor_alcool the teor_alcool to set
	 */
	public void setTeor_alcool(double teor_alcool) {
		this.teor_alcool = teor_alcool;
	}
	
	

}
