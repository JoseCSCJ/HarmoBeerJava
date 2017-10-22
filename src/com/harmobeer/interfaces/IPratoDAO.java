/**
 * 
 */
package com.harmobeer.interfaces;

import java.util.List;

import com.harmobeer.vo.Prato;

/**
 * Interface responsável pelos DAO's da classe Prato
 * @author José Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 *
 */
public interface IPratoDAO {
	public boolean incluir(Prato prato);
	
	public boolean editar(Prato prato);
	
	public boolean deletar(Prato prato);
	
	public List <Prato> listarTodos();
}
