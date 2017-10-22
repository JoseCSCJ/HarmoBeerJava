/**
 * 
 */
package com.harmobeer.mvc.model;

import java.util.List;

import com.harmobeer.db.dao.PratoDAO;
import com.harmobeer.interfaces.IPratoDAO;
import com.harmobeer.vo.Prato;

/**
 * Classe respons�vel pelo Modelo dos objetos Prato
 * 
 * @author Jos� Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 * 
 */
public class PratoModel implements IPratoDAO {

	private PratoDAO pratoDAO;

	/**
	 * Construtor da classe Prato Model, utilizando a cria��o de um novo
	 * objeto da classe PratoDAO.
	 */
	public PratoModel() {
		pratoDAO = new PratoDAO();
	}

	/**
	 * M�todo que inclui uma prato no banco, utilizando o objeto pratoDAO
	 * para acessar o banco
	 * 
	 * @param Prato
	 *            a ser inclu�da
	 * @return boolean true para transa��o bem sucedida e false para transa��o
	 *         interrompida.
	 * 
	 */
	@Override
	public boolean incluir(Prato prato) {
		return pratoDAO.incluir(prato);
	}

	/**
	 * M�todo que edita uma prato no banco, utilizando o objeto pratoDAO
	 * para acessar o banco
	 * 
	 * @param Prato
	 *            a ser editada
	 * @return boolean true para transa��o bem sucedida e false para transa��o
	 *         interrompida.
	 */

	@Override
	public boolean editar(Prato prato) {
		return pratoDAO.editar(prato);
	}

	/**
	 * M�todo que exclui uma prato no banco, utilizando o objeto pratoDAO
	 * para acessar o banco
	 * 
	 * @param Prato
	 *            a ser exclu�da
	 * @return boolean true para transa��o bem sucedida e false para transa��o
	 *         interrompida.
	 */

	@Override
	public boolean deletar(Prato prato) {
		return pratoDAO.deletar(prato);
	}

	/**
	 * M�todo respons�vel por realizar a listagem de todas os Pratos
	 * cadastradas no banco.
	 * 
	 * @return ArrayList com os objetos da Classe Prato gerados com os dados
	 *         recebidos do banco de dados.
	 * 
	 */

	@Override
	public List<Prato> listarTodos() {
		return pratoDAO.listarTodos();
	}

	/**
	 * M�todo respons�vel por buscar e trazer o objeto de um Prato, com os dados do banco de dados.
	 * 
	 * @param id
	 *            ID do prato cadastrado no banco
	 * @return Prato selecionado
	 */

	public Prato selecionarPrato(int id) {
		return pratoDAO.selecionarPrato(id);
	}

}
