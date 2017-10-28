/**
 *
 */
package com.harmobeer.mvc.model;

import com.harmobeer.db.dao.HarmonizacaoDAO;
import com.harmobeer.vo.Cerveja;
import com.harmobeer.vo.Prato;

/**
 *
 *
 * Classe responsavel pelo model do objeto Harmonizacao
 *
 * @author Jose Carlos Soares da Cruz Junior / Luan Henrique Cunha Alves
 *
 */
public class HarmonizacaoModel
{
    private HarmonizacaoDAO harmonizacaoDAO;

    public HarmonizacaoModel() {
        harmonizacaoDAO = new HarmonizacaoDAO();
    }

    public boolean incluirHarmonizacao(Cerveja cerveja, Prato prato) {
        return harmonizacaoDAO.incluirHarmonizacao(cerveja, prato);
    }
}

