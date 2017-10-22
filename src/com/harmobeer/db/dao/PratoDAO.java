/**
 * 
 */
package com.harmobeer.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.harmobeer.interfaces.IPratoDAO;
import com.harmobeer.vo.Prato;

/**
 * 
 * Classe responsável pelo acesso ao banco de dados do objeto prato
 * 
 * @author José Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 * 
 */
public class PratoDAO implements IPratoDAO {

	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String LOCAL_HOST = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "harmobeer";
	private static final String DB_PASSWORD = "harmobeer";
	private static final String ERRO = "Não foi possível completar sua requisição.";

	/**
	 * Método responsável por realizar a inclusão de pratos no banco.
	 * 
	 * @param Prato
	 *            prato a ser incluído
	 * @return boolean true para transação bem sucedida e false para transação
	 *         interrompida.
	 * 
	 */
	@Override
	public boolean incluir(Prato prato) {
		Connection connection = null;
		PreparedStatement sttm = null;
		try {
			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

			sttm = connection.prepareStatement("insert into prato(id_prato, nm_prato) values(seqprato.nextval,?)");
			sttm.setString(1, prato.getNm_prato());

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
	 * Método responsável por realizar a edição de Pratos cadastradas no banco.
	 * 
	 * @param Prato
	 *            prato a ser editado
	 * @return boolean true para transação bem sucedida e false para transação
	 *         interrompida.
	 */
	@Override
	public boolean editar(Prato prato) {
		Connection connection = null;
		PreparedStatement sttm = null;
		try {
			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

			sttm = connection.prepareStatement("UPDATE prato SET nm_prato = ? where id_prato = ?");
			sttm.setString(1, prato.getNm_prato());
			sttm.setInt(2, prato.getId_prato());

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
	 * Método responsável por realizar a exclusão de Pratos cadastradas no banco
	 * 
	 * @param Prato
	 *            prato a deletada
	 * @return boolean true para transação bem sucedida e false para transação
	 *         interrompida.
	 */
	@Override
	public boolean deletar(Prato prato) {
		Connection connection = null;
		PreparedStatement sttm = null;
		try {
			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

			sttm = connection.prepareStatement("DELETE from prato where id_prato = ?");
			sttm.setInt(1, prato.getId_prato());
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
	 * Método responsável por realizar a listagem de todas os Pratos cadastrados
	 * no banco.
	 * 
	 * @return ArrayList com os objetos da Classe Prato gerados com os dados
	 *         recebidos do banco de dados.
	 * 
	 */
	@Override
	public List<Prato> listarTodos() {
		ArrayList<Prato> listaPrato = new ArrayList<Prato>();
		Connection connection = null;
		PreparedStatement sttm = null;
		try {
			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

			sttm = connection.prepareStatement("select * from prato");
			ResultSet rs = sttm.executeQuery();

			while (rs.next()) {

				int id_prato = rs.getInt("id_prato");
				String nm_prato = rs.getString("nm_prato");

				Prato prato = new Prato(id_prato, nm_prato);

				listaPrato.add(prato);
			}

			return listaPrato;

		} catch (ClassNotFoundException e) {
			System.out.println(ERRO);
			e.printStackTrace();
			return null;
		} catch (SQLException Except) {
			System.out.println(ERRO);
			Except.printStackTrace();
			return null;
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
	 * Método responsável por buscar e retornar um objeto da classe Prato no
	 * banco
	 * 
	 * @param id
	 *            ID da prato cadastrada no banco
	 * @return Prato selecionada
	 */
	public Prato selecionarPrato(int id) {
		Prato prato = new Prato(id);
		Connection connection = null;
		PreparedStatement sttm = null;
		try {
			Class.forName(JDBC_DRIVER);

			connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

			sttm = connection.prepareStatement("select * from prato where id_prato = ?");
			sttm.setInt(1, id);
			ResultSet rs = sttm.executeQuery();

			while (rs.next()) {

				prato.setNm_prato(rs.getString("nm_prato"));

			}
			return prato;
		} catch (ClassNotFoundException e) {
			System.out.println(ERRO);
			e.printStackTrace();
			return null;
		} catch (SQLException Except) {
			System.out.println(ERRO);
			Except.printStackTrace();
			return null;
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