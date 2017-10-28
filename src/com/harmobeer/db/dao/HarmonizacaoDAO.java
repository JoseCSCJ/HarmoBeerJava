/**
 *
 */
package com.harmobeer.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.harmobeer.vo.Cerveja;
import com.harmobeer.vo.Harmonizacao;
import com.harmobeer.vo.Prato;

/**
 * @author Jos� Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 *
 */
/**
 * @author tgietds
 *
 */
public class HarmonizacaoDAO
{

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String LOCAL_HOST  = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String DB_USER     = "harmobeer";
    private static final String DB_PASSWORD = "harmobeer";
    private static final String ERRO        = "N�o foi poss�vel completar sua requisi��o.";

    /**
     * Método que verifica se a harmonização de uma cerveja com um prato já
     * existe no banco de dados. Caso exista, retorna a ID da harmonização do
     * banco de dados. Caso não exista, retorna o valor -1. Caso dê algum erro
     * de verificação no banco, retorna -2.
     *
     * @param cerveja
     * @param prato
     * @return inteiro
     */

    private int verificarHarmonizacao(Cerveja cerveja, Prato prato)
    {
        Connection connection = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        boolean verificarCerveja = false;
        boolean verificarPrato = false;
        int idHarmo = -1;
        try
        {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

            sttm = connection.prepareStatement(
                            "select p.id_prato, c.id_cerv, h.id_harmo from harmonizacao h "
                                            + "left join prato p on p.id_prato = h.id_prato "
                                            + "left join cerveja c on c.id_cerv = h.id_cerv");
            rs = sttm.executeQuery();
            while (rs.next())
            {
                verificarPrato = false;
                verificarCerveja = false;
                if (rs.getInt("id_prato") == prato.getId_prato())
                {
                    verificarPrato = true;
                }
                else
                {
                    verificarPrato = false;
                }
                if (rs.getInt("id_cerv") == cerveja.getId_cerv())
                {
                    verificarCerveja = true;
                }
                else
                {
                    verificarCerveja = false;
                }
                if (verificarPrato == true && verificarCerveja == true)
                {
                    idHarmo = rs.getInt("id_harmo");
                    return idHarmo;
                }
            }

        }
        catch (ClassNotFoundException e)
        {
            System.out.println(ERRO);
            e.printStackTrace();
            return -2;
        }
        catch (SQLException Except)
        {
            System.out.println(ERRO);
            Except.printStackTrace();
            return -2;
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
                return -2;
            }
        }
        return idHarmo;
    }

    /**
     * Método que inclui uma harmonização no banco de dados caso ela já não
     * exista.
     *
     * @param cerveja
     * @param prato
     * @return boolean
     */
    public boolean incluirHarmonizacao(Cerveja cerveja, Prato prato)
    {
        Connection connection = null;
        PreparedStatement sttm = null;
        int verificarHarmo = 0;

        try
        {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

            verificarHarmo = verificarHarmonizacao(cerveja, prato);
            if (verificarHarmo == -1)
            {
                // Harmonizacao nao existe - criar nova harmonizacao
                sttm = connection.prepareStatement(
                                "insert into harmonizacao (id_harmo, id_cerv, id_prato, media) "
                                                + "values (seqharmo.nextval,?,?,0)");
                sttm.setInt(1, cerveja.getId_cerv());
                sttm.setInt(2, prato.getId_prato());

                sttm.executeUpdate();

            }
            else
                if (verificarHarmo == -2)
                {
                    // Erro de banco
                    System.out.println("Harmonizacao nao incluida por ter dado erro no banco");
                    return false;
                }
                else
                {
                    // Harmonizacao ja existe, nao incluir nada
                    System.out.println("Harmonizacao nao incluida por já existir no banco de dados");
                    return false;

                }

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
        return false;

    }

    public boolean calcularMedia(Harmonizacao harmo)
    {
        int naval = 0;
        int nota = 0;
        double media = 0;
        Connection connection = null;
        PreparedStatement sttm = null;
        try
        {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(LOCAL_HOST, DB_USER, DB_PASSWORD);

            sttm = connection.prepareStatement(
                            "UPDATE cerveja SET nm_cerv = ?, nm_estilo = ?, teor_alcoolico = ? where id_cerv = ?");
            sttm.setString(1, cerveja.getNm_cerv());
            sttm.setString(2, cerveja.getNm_estilo());
            sttm.setDouble(3, cerveja.getTeor_alcool());
            sttm.setInt(4, cerveja.getId_cerv());

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
