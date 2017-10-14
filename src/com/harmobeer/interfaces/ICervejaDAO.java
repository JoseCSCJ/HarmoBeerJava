/**
 * 
 */
package com.harmobeer.interfaces;

import java.util.List;

import com.harmobeer.vo.Cerveja;

/**
 * @author Jos� Carlos Soares da Cruz J�nior / Luan Henrique Cunha Alves
 * Interface respons�vel pelos DAO's da classe Cerveja
 */
public interface ICervejaDAO {
	
	public boolean incluir(Cerveja cerveja);
	
	public boolean editar(Cerveja cerveja);
	
	public boolean deletar(Cerveja cerveja);
	
	public List <Cerveja> listarTodos();

}
