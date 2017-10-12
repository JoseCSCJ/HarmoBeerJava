/**
 * 
 */
package com.harmobeer.interfaces;

import java.util.List;

import com.harmobeer.vo.Cerveja;

/**
 * @author Usuário
 *
 */
public interface ICervejaDAO {
	
	public boolean incluir(Cerveja cerveja);
	
	public boolean editar(Cerveja cerveja);
	
	public boolean deletar(Cerveja cerveja);
	
	public List <Cerveja> listar();
	
	

}
