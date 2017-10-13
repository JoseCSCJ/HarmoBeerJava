/**
 * 
 */
package com.harmobeer.mvc.model;

import java.util.List;

import com.harmobeer.db.dao.CervejaDAO;
import com.harmobeer.interfaces.ICervejaDAO;
import com.harmobeer.vo.Cerveja;

/**
 * @author Usu�rio
 *
 */
public class CervejaModel implements ICervejaDAO {
	
	private CervejaDAO cervejaDAO;
	
	public CervejaModel(){
		cervejaDAO=new CervejaDAO();		
	}

	@Override
	public boolean incluir(Cerveja cerveja) {
		return cervejaDAO.incluir(cerveja);
	}

	@Override
	public boolean editar(Cerveja cerveja) {
		return cervejaDAO.editar(cerveja);
	}

	@Override
	public boolean deletar(Cerveja cerveja) {
		return cervejaDAO.deletar(cerveja);
	}

	@Override
	public List<Cerveja> listarTodos() {
		return cervejaDAO.listarTodos();
	}
	
	public Cerveja selecionarCerv(int id){
		return cervejaDAO.selecionarCerv(id);
	}

}
