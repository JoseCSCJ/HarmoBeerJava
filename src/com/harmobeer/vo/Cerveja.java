/**
 * 
 */
package com.harmobeer.vo;

/**
 * @author Usuário
 *
 */
public class Cerveja {
	
	private int id_cerv;
	private String nm_cerv;
	private String nm_estilo;
	private double teor_alcool;
	
	public Cerveja(int id_cerv) {
		this.id_cerv = id_cerv;
	}
	
	public Cerveja(int id_cerv, String nm_cerv, String nm_estilo, double teor_alcool) {
		this.id_cerv = id_cerv;
		this.nm_cerv = nm_cerv;
		this.nm_estilo = nm_estilo;
		this.teor_alcool = teor_alcool;
	}

	/**
	 * @return the id_cerv
	 */
	public int getId_cerv() {
		return id_cerv;
	}

	/**
	 * @param id_cerv the id_cerv to set
	 */
	public void setId_cerv(int id_cerv) {
		this.id_cerv = id_cerv;
	}

	/**
	 * @return the nm_cerv
	 */
	public String getNm_cerv() {
		return nm_cerv;
	}

	/**
	 * @param nm_cerv the nm_cerv to set
	 */
	public void setNm_cerv(String nm_cerv) {
		this.nm_cerv = nm_cerv;
	}

	/**
	 * @return the nm_estilo
	 */
	public String getNm_estilo() {
		return nm_estilo;
	}

	/**
	 * @param nm_estilo the nm_estilo to set
	 */
	public void setNm_estilo(String nm_estilo) {
		this.nm_estilo = nm_estilo;
	}

	/**
	 * @return the teor_alcool
	 */
	public double getTeor_alcool() {
		return teor_alcool;
	}

	/**
	 * @param teor_alcool the teor_alcool to set
	 */
	public void setTeor_alcool(double teor_alcool) {
		this.teor_alcool = teor_alcool;
	}
	
	

}
