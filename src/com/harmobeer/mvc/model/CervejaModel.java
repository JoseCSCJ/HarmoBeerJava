/**
 * 
 */
package com.harmobeer.mvc.model;

import java.util.List;

import com.harmobeer.db.dao.CervejaDAO;
import com.harmobeer.interfaces.ICervejaDAO;
import com.harmobeer.vo.Cerveja;

/**
 * Classe responsável pelo Modelo dos objetos Cerveja
 * 
 * @author José Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 * 
 */
public class CervejaModel implements ICervejaDAO {

	private CervejaDAO cervejaDAO;

	/**
	 * Construtor da classe Cerveja Model, utilizando a criação de um novo
	 * objeto da classe CervejaDAO.
	 */
	public CervejaModel() {
		cervejaDAO = new CervejaDAO();
	}

	/**
	 * Método que inclui uma cerveja no banco, utilizando o objeto cervejaDAO
	 * para acessar o banco
	 * 
	 * @param Cerveja
	 *            a ser incluída
	 * @return boolean true para transição bem sucedida e false para transição
	 *         interrompida.
	 * 
	 */
	@Override
	public boolean incluir(Cerveja cerveja) {
		return cervejaDAO.incluir(cerveja);
	}

	/**
	 * Método que edita uma cerveja no banco, utilizando o objeto cervejaDAO
	 * para acessar o banco
	 * 
	 * @param Cerveja
	 *            a ser editada
	 * @return boolean true para transição bem sucedida e false para transição
	 *         interrompida.
	 */

	@Override
	public boolean editar(Cerveja cerveja) {
		return cervejaDAO.editar(cerveja);
	}

	/**
	 * Método que exclui uma cerveja no banco, utilizando o objeto cervejaDAO
	 * para acessar o banco
	 * 
	 * @param Cerveja
	 *            a ser excluída
	 * @return boolean true para transição bem sucedida e false para transição
	 *         interrompida.
	 */

	@Override
	public boolean deletar(Cerveja cerveja) {
		return cervejaDAO.deletar(cerveja);
	}

	/**
	 * Método responsável por realizar a listagem de todas as Cervejas
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
	 * Método responsável por buscar e trazer o objeto de uma Cerveja, com os dados do banco de dados.
	 * 
	 * @param id
	 *            ID da cerveja cadastrada no banco
	 * @return Cerveja selecionada
	 */

	public Cerveja selecionarCerv(int id) {
		return cervejaDAO.selecionarCerv(id);
	}

}
