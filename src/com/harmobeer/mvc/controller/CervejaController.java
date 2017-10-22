/**
 * 
 */
package com.harmobeer.mvc.controller;

import java.util.List;

import com.harmobeer.interfaces.ICervejaDAO;
import com.harmobeer.mvc.model.CervejaModel;
import com.harmobeer.vo.Cerveja;


/**
 * 
 *  Classe respons�vel pelo controlador dos objetos Cerveja
 * @author Jos� Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 *
 */
public class CervejaController implements ICervejaDAO {
	private CervejaModel cervejaModel;
	/**
	 * Construtor da classe Cerveja Controller, utilizando a cria��o de um novo
	 * objeto da classe CervejaModel.
	 */
	public CervejaController() {
		cervejaModel = new CervejaModel();
	}
	/**
	 * M�todo que passa um objeto cerveja, caso ela esteja de acordo com os limites do banco de dados, para ser inclu�da no banco de dados pela classe CervejaModel. 
	 * @param Cerveja
	 *            a ser inclu�da
	 * @return boolean true para transi��o bem sucedida e false para transi��o
	 *         interrompida, quando o objeto cerveja est� fora do padr�o do banco.
	 * 
	 */
	@Override
	public boolean incluir(Cerveja cerveja) {
		if (validarCerveja(cerveja)){
			return cervejaModel.incluir(cerveja);
		}
		return false;
	}
	/**
	 * M�todo que passa um objeto cerveja, caso ela esteja de acordo com os limites do banco de dados, para ser atualizado no banco de dados pela classe CervejaModel. 
	 * @param Cerveja
	 *            a ser editada
	 * @return boolean true para transi��o bem sucedida e false para transi��o
	 *         interrompida, quando o objeto cerveja est� fora do padr�o do banco.
	 * 
	 */
	@Override
	public boolean editar(Cerveja cerveja) {
		if (validarCerveja(cerveja)) {
			return cervejaModel.editar(cerveja);
		}
		return false;
	}
	/**
	 * M�todo que passa um objeto cerveja para ser deletado no banco de dados pela classe CervejaModel. 
	 * @param cerveja
	 *            a ser deletada
	 * @return boolean true para transi��o bem sucedida e false para transi��o
	 *         interrompida.
	 * 
	 */
	@Override
	public boolean deletar(Cerveja cerveja) {
		return cervejaModel.deletar(cerveja);
	}
	/**
	 * M�todo respons�vel acionar a listagem de cervejas no banco de dados, atrav�s do objeto da classe CervejaModel.
	 * 
	 * @return ArrayList com os objetos da Classe Cerveja gerados com os dados
	 *         recebidos do banco de dados.
	 * 
	 */
	@Override
	public List<Cerveja> listarTodos() {
		return cervejaModel.listarTodos();
	}
	/**
	 * M�todo respons�vel por buscar e retornar o objeto de uma Cerveja, com os dados do banco de dados atrav�s do m�todo contido na classe CervejaModel.
	 * 
	 * @param id
	 *            ID da cerveja cadastrada no banco
	 * @return Cerveja selecionada
	 */
	public Cerveja selecionarCerveja(int id) {
		return cervejaModel.selecionarCerv(id);
	}
/** 
 * M�todo respons�vel por validar o objeto cerveja, garantindo que seus dados estejam dentro do permitido pelo banco de dados.
 * @param cerveja
 * @return boolean true para objeto dentro dos limites e false caso contr�rio
 */
	private boolean validarCerveja(Cerveja cerveja) {

		String nm_cerv = cerveja.getNm_cerv();
		String nm_estilo = cerveja.getNm_estilo();
		double teor_alcool = cerveja.getTeor_alcool();

		if (nm_cerv.length() > 60) {
			System.out.println("Nome de cerveja muito longo.");
			return false;
		}

		if (nm_estilo.length() > 60) {
			System.out.println("Nome do estilo da cerveja muito longo.");
			return false;
		}
				
		if (teor_alcool > 70 || teor_alcool < 0) {
			System.out.println("Teor Alcoolico fora dos valores permitidos.");
			return false;
		}

		return true;

	}
}
