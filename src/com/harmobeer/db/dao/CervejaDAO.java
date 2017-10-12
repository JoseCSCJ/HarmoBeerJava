/**
 * 
 */
package com.harmobeer.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.harmobeer.interfaces.ICervejaDAO;
import com.harmobeer.vo.Cerveja;


/**
 * @author Usuário
 *
 */
public class CervejaDAO implements ICervejaDAO {

	@Override
	public boolean incluir(Cerveja cerveja) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "aluno", "aluno");

			PreparedStatement sttm = connection.prepareStatement(
					"insert into cerveja(id_cerv, nm_cerv, nm_estilo, teor_alcool) values(seqcerv.nextval,?,?,?)");
			sttm.setString(1, cerveja.getNm_cerv());
			sttm.setString(2, cerveja.getNm_estilo());
			sttm.setDouble(3, cerveja.getTeor_alcool());

			sttm.executeUpdate();
			return true;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException Except) {
			Except.printStackTrace();
			return false;
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean editar(Cerveja cerveja) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(Cerveja cerveja) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cerveja> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
