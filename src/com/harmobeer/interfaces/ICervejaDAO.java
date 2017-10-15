/**
 * 
 */
package com.harmobeer.interfaces;

import java.util.List;

import com.harmobeer.vo.Cerveja;

/**
 * Interface responsável pelos DAO's da classe Cerveja
 * @author José Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 * 
 */
public interface ICervejaDAO {
	
	public boolean incluir(Cerveja cerveja);
	
	public boolean editar(Cerveja cerveja);
	
	public boolean deletar(Cerveja cerveja);
	
	public List <Cerveja> listarTodos();

}
