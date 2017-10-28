/**
 *
 */
package com.harmobeer.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.harmobeer.vo.Usuario;

/**
 * @author tgietds
 *
 */
public class UsuarioDAO
{
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String LOCAL_HOST  = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String DB_USER     = "harmobeer";
    private static final String DB_PASSWORD = "harmobeer";
    private static final String ERRO        = "N�o foi poss�vel completar sua requisi��o.";

    public boolean incluir(Usuario user)
    {
        Connection connection = null;
        PreparedStatement sttm = null;

        try
        {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

            sttm = connection.prepareStatement(
                            "insert into usuario(id_user, username, email, senha, privilegio, info) values (sequser.nextval,?,?,?, false,?)");
            sttm.setString(1, user.getUsername());
            sttm.setString(2, user.getEmail());
            sttm.setString(3, user.getSenha());
            sttm.setString(3, user.getInfo());

            sttm.executeUpdate();

            return true;

        }
        catch (ClassNotFoundException e)
        {
            System.out.println(ERRO);
            e.printStackTrace();
            return false;
        }
        catch (SQLException Except)
        {
            System.out.println(ERRO);
            Except.printStackTrace();
            return false;
        }
        finally
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                if (sttm != null)
                {
                    sttm.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public boolean editar(Usuario user)
    {
        Connection connection = null;
        PreparedStatement sttm = null;

        try
        {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

            sttm = connection.prepareStatement(
                            "UPDATE usuario set username=?, email=?, senha=?, info=? where id_user=?");
            sttm.setInt(1, user.getId_user());
            sttm.setString(2, user.getUsername());
            sttm.setString(3, user.getEmail());
            sttm.setString(4, user.getSenha());
            sttm.setString(5, user.getInfo());

            sttm.executeUpdate();

            return true;

        }
        catch (ClassNotFoundException e)
        {
            System.out.println(ERRO);
            e.printStackTrace();
            return false;
        }
        catch (SQLException Except)
        {
            System.out.println(ERRO);
            Except.printStackTrace();
            return false;
        }
        finally
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                if (sttm != null)
                {
                    sttm.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public boolean deletar(Usuario user)
    {
        Connection connection = null;
        PreparedStatement sttm = null;
        try
        {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);
            sttm = connection.prepareStatement("UPDATE Avaliacao set id_user = 1 where id_user=?");
            sttm.setInt(1, user.getId_user());
            sttm.executeUpdate();
            if (sttm != null)
            {
                sttm.close();
            }
            sttm = connection.prepareStatement("DELETE from usuario where id_cerv = ?");
            sttm.setInt(1, user.getId_user());
            sttm.executeUpdate();
            return true;

        }
        catch (ClassNotFoundException e)
        {
            System.out.println(ERRO);
            e.printStackTrace();
            return false;
        }
        catch (SQLException Except)
        {
            System.out.println(ERRO);
            Except.printStackTrace();
            return false;
        }
        finally
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                if (sttm != null)
                {
                    sttm.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

}
