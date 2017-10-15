/**
 * 
 */
package com.harmobeer.mvc.model;

import java.util.List;

import com.harmobeer.db.dao.CervejaDAO;
import com.harmobeer.interfaces.ICervejaDAO;
import com.harmobeer.vo.Cerveja;

/**
 * Classe respons�vel pelo Modelo dos objetos Cerveja
 * 
 * @author Jos� Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 * 
 */
public class CervejaModel implements ICervejaDAO {

	private CervejaDAO cervejaDAO;

	/**
	 * Construtor da classe Cerveja Model, utilizando a cria��o de um novo
	 * objeto da classe CervejaDAO.
	 */
	public CervejaModel() {
		cervejaDAO = new CervejaDAO();
	}

	/**
	 * M�todo que inclui uma cerveja no banco, utilizando o objeto cervejaDAO
	 * para acessar o banco
	 * 
	 * @param Cerveja
	 *            a ser inclu�da
	 * @return boolean true para transi��o bem sucedida e false para transi��o
	 *         interrompida.
	 * 
	 */
	@Override
	public boolean incluir(Cerveja cerveja) {
		return cervejaDAO.incluir(cerveja);
	}

	/**
	 * M�todo que edita uma cerveja no banco, utilizando o objeto cervejaDAO
	 * para acessar o banco
	 * 
	 * @param Cerveja
	 *            a ser editada
	 * @return boolean true para transi��o bem sucedida e false para transi��o
	 *         interrompida.
	 */

	@Override
	public boolean editar(Cerveja cerveja) {
		return cervejaDAO.editar(cerveja);
	}

	/**
	 * M�todo que exclui uma cerveja no banco, utilizando o objeto cervejaDAO
	 * para acessar o banco
	 * 
	 * @param Cerveja
	 *            a ser exclu�da
	 * @return boolean true para transi��o bem sucedida e false para transi��o
	 *         interrompida.
	 */

	@Override
	public boolean deletar(Cerveja cerveja) {
		return cervejaDAO.deletar(cerveja);
	}

	/**
	 * M�todo respons�vel por realizar a listagem de todas as Cervejas
	 * cadastradas no banco.
	 * 
	 * @return ArrayList com os objetos da Classe Cerveja gerados com os dados
	 *         recebidos do banco de dados.
	 * 
	 */

	@Override
	public List<Cerveja> listarTodos() {
		return cervejaDAO.listarTodos();
	}

	/**
	 * M�todo respons�vel por buscar e trazer o objeto de uma Cerveja, com os dados do banco de dados.
	 * 
	 * @param id
	 *            ID da cerveja cadastrada no banco
	 * @return Cerveja selecionada
	 */

	public Cerveja selecionarCerv(int id) {
		return cervejaDAO.selecionarCerv(id);
	}

}
