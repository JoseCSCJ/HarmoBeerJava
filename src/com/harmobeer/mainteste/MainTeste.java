package com.harmobeer.mainteste;

import com.harmobeer.db.dao.CervejaDAO;
import com.harmobeer.vo.Cerveja;

public class MainTeste {

	public static void main(String[] args) {
		CervejaDAO cervDAO = new CervejaDAO();
		Cerveja cerveja1 = new Cerveja("Grimor 21", " Herb and Spice Beer", 4.5);
		Cerveja cerveja2 = new Cerveja("Eisenbahn Strong Golden Ale", "Belgian-Style Pale Strong Ale", 8.5);
		Cerveja cerveja3 = new Cerveja("Coruja Coice", "Specialty Beer", 11.5);

		Cerveja cerveja4 = new Cerveja(4, "Grimor 21", " Herb and Spice Beer", 4.5);

		Cerveja cerveja5 = new Cerveja(5);

		/*
		 * cervDAO.incluir(cerveja1); cervDAO.incluir(cerveja2);
		 * cervDAO.incluir(cerveja3);
		 */
		/*
		 * cervDAO.editar(cerveja4);
		 */

		/*
		 * cervDAO.deletar(cerveja5);
		 */

		/*
		 * for(Cerveja c : cervDAO.listarTodos()){
		 * 
		 * System.out.println(" "); System.out.println(c.getId_cerv() + "  " +
		 * c.getNm_cerv() + "  "); System.out.println(c.getNm_estilo() + "  " +
		 * c.getTeor_alcool()); System.out.println(" "); }
		 */
	}
}
