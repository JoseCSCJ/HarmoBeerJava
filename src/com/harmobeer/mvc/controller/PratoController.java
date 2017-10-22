/**
 * 
 */
package com.harmobeer.mvc.controller;

import java.util.List;

import com.harmobeer.interfaces.IPratoDAO;
import com.harmobeer.mvc.model.PratoModel;
import com.harmobeer.vo.Prato;


/**
 * 
 *  Classe respons�vel pelo controlador dos objetos Prato
 * @author Jos� Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 *
 */
public class PratoController implements IPratoDAO {
	private PratoModel pratoModel;
	/**
	 * Construtor da classe Prato Controller, utilizando a cria��o de um novo
	 * objeto da classe PratoModel.
	 */
	public PratoController() {
		pratoModel = new PratoModel();
	}
	/**
	 * M�todo que passa um objeto prato, caso ela esteja de acordo com os limites do banco de dados, para ser inclu�da no banco de dados pela classe PratoModel. 
	 * @param Prato
	 *            a ser inclu�do
	 * @return boolean true para transa��o bem sucedida e false para transa��o
	 *         interrompida, quando o objeto prato est� fora do padr�o do banco.
	 * 
	 */
	@Override
	public boolean incluir(Prato prato) {
		if (validarPrato(prato)){
			return pratoModel.incluir(prato);
		}
		return false;
	}
	/**
	 * M�todo que passa um objeto prato, caso ela esteja de acordo com os limites do banco de dados, para ser atualizado no banco de dados pela classe PratoModel. 
	 * @param Prato
	 *            a ser editada
	 * @return boolean true para transa��o bem sucedida e false para transa��o
	 *         interrompida, quando o objeto prato est� fora do padr�o do banco.
	 * 
	 */
	@Override
	public boolean editar(Prato prato) {
		if (validarPrato(prato)) {
			return pratoModel.editar(prato);
		}
		return false;
	}
	/**
	 * M�todo que passa um objeto prato para ser deletado no banco de dados pela classe PratoModel. 
	 * @param prato
	 *            a ser deletada
	 * @return boolean true para transa��o bem sucedida e false para transa��o
	 *         interrompida.
	 * 
	 */
	@Override
	public boolean deletar(Prato prato) {
		return pratoModel.deletar(prato);
	}
	/**
	 * M�todo respons�vel acionar a listagem de pratos no banco de dados, atrav�s do objeto da classe PratoModel.
	 * 
	 * @return ArrayList com os objetos da Classe Prato gerados com os dados
	 *         recebidos do banco de dados.
	 * 
	 */
	@Override
	public List<Prato> listarTodos() {
		return pratoModel.listarTodos();
	}
	/**
	 * M�todo respons�vel por buscar e retornar o objeto de uma Prato, com os dados do banco de dados atrav�s do m�todo contido na classe PratoModel.
	 * 
	 * @param id
	 *            ID da prato cadastrada no banco
	 * @return Prato selecionada
	 */
	public Prato selecionarPrato(int id) {
		return pratoModel.selecionarPrato(id);
	}
/** 
 * M�todo respons�vel por validar o objeto prato, garantindo que seus dados estejam dentro do permitido pelo banco de dados.
 * @param prato
 * @return boolean true para objeto dentro dos limites e false caso contr�rio
 */
	private boolean validarPrato(Prato prato) {

		String nm_prato = prato.getNm_prato();
		
		if (nm_prato.length() > 30) {
			System.out.println("Nome de prato muito longo.");
			return false;
		}

		return true;

	}
}
