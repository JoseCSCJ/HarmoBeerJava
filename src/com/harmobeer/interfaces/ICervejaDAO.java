/**
 * 
 */
package com.harmobeer.interfaces;

import java.util.List;

import com.harmobeer.vo.Cerveja;

/**
 * @author José Carlos Soares da Cruz Júnior / Luan Henrique Cunha Alves
 * Interface responsável pelos DAO's da classe Cerveja
 */
public interface ICervejaDAO {
	
	public boolean incluir(Cerveja cerveja);
	
	public boolean editar(Cerveja cerveja);
	
	public boolean deletar(Cerveja cerveja);
	
	public List <Cerveja> listarTodos();

}
