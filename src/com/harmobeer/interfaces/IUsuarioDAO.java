/**
 * 
 */
package com.harmobeer.interfaces;

import com.harmobeer.vo.Usuario;

/**
 * Interface responsável pelos DAO da classe Usuario
 * @author Jose Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 *
 */
public interface IUsuarioDAO {
	public boolean incluir(Usuario usuario);
	
	public boolean editar(Usuario usuario);
	
	public boolean deletar(Usuario usuario);

}