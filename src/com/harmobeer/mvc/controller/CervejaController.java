/**
 * 
 */
package com.harmobeer.mvc.controller;

import java.util.List;

import com.harmobeer.interfaces.ICervejaDAO;
import com.harmobeer.mvc.model.CervejaModel;
import com.harmobeer.vo.Cerveja;

/**
 * @author Usuário
 *
 */
public class CervejaController implements ICervejaDAO{
private CervejaModel cervejaModel;
	
	public CervejaController(){
		cervejaModel=new CervejaModel();		
	}

	@Override
	public boolean incluir(Cerveja cerveja) {
		return cervejaModel.incluir(cerveja);
	}

	@Override
	public boolean editar(Cerveja cerveja) {
		return cervejaModel.editar(cerveja);
	}

	@Override
	public boolean deletar(Cerveja cerveja) {
		return cervejaModel.deletar(cerveja);
	}

	@Override
	public List<Cerveja> listarTodos() {
		return cervejaModel.listarTodos();
	}

	public Cerveja selecionarCerveja(int id){
		return cervejaModel.selecionarCerv(id);
	}
}
