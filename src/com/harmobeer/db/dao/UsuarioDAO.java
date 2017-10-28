/**
 *
 */
package com.harmobeer.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.harmobeer.interfaces.IUsuarioDAO;
import com.harmobeer.vo.Usuario;

/**
 * Classe responsavel pelo acesso ao banco de dados para Usuario
 * 
 * @author Jose Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 */
public class UsuarioDAO implements IUsuarioDAO {
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String LOCAL_HOST = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "harmobeer";
	private static final String DB_PASSWORD = "harmobeer";
	private static final String ERRO = "Nï¿½o foi possï¿½vel completar sua requisiï¿½ï¿½o.";

	/**
	 * Inclui um usuario no banco de dados.
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean incluir(Usuario user) {
		Connection connection = null;
		PreparedStatement sttm = null;

		try {
			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

			sttm = connection.prepareStatement(
					"insert into usuario(id_user, username, email, senha, privilegio, info) values (sequsuario.nextval,?,?,?, 0,?)");
			sttm.setString(1, user.getUsername());
			sttm.setString(2, user.getEmail());
			sttm.setString(3, user.getSenha());
			sttm.setString(4, user.getInfo());

			sttm.executeUpdate();

			return true;

		} catch (ClassNotFoundException e) {
			System.out.println(ERRO);
			e.printStackTrace();
			return false;
		} catch (SQLException Except) {
			System.out.println(ERRO);
			Except.printStackTrace();
			return false;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (sttm != null) {
					sttm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Edita um usuário no banco de dados, podendo atualizar as seguintes
	 * informacoes: username, email, info e senha.
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean editar(Usuario user) {
		Connection connection = null;
		PreparedStatement sttm = null;

		try {
			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

			sttm = connection
					.prepareStatement("UPDATE usuario set username=?, email=?, senha=?, info=? where id_user=?");

			sttm.setString(1, user.getUsername());
			sttm.setString(2, user.getEmail());
			sttm.setString(3, user.getSenha());
			sttm.setString(4, user.getInfo());
			sttm.setInt(5, user.getId_user());

			sttm.executeUpdate();

			return true;

		} catch (ClassNotFoundException e) {
			System.out.println(ERRO);
			e.printStackTrace();
			return false;
		} catch (SQLException Except) {
			System.out.println(ERRO);
			Except.printStackTrace();
			return false;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (sttm != null) {
					sttm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Deleta um usuário do banco de dados, atualizando as avaliações feitas por
	 * ele para um usuário pré-cadastrado Anônimo.
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean deletar(Usuario user) {
		Connection connection = null;
		PreparedStatement sttm = null;
		try {
			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);
			sttm = connection.prepareStatement("UPDATE Avaliacao set id_user = 1 where id_user=?");
			sttm.setInt(1, user.getId_user());
			sttm.executeUpdate();
			if (sttm != null) {
				sttm.close();
			}
			sttm = connection.prepareStatement("DELETE from usuario where id_user = ?");
			sttm.setInt(1, user.getId_user());
			sttm.executeUpdate();
			return true;

		} catch (ClassNotFoundException e) {
			System.out.println(ERRO);
			e.printStackTrace();
			return false;
		} catch (SQLException Except) {
			System.out.println(ERRO);
			Except.printStackTrace();
			return false;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (sttm != null) {
					sttm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
