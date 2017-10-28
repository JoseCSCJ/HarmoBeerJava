/**
 *
 */
package com.harmobeer.mvc.controller;

import com.harmobeer.mvc.model.HarmonizacaoModel;
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
public class HarmonizacaoController
{
    private HarmonizacaoModel harmonizacaoModel;
    /**
     * Construtor do controller da classe Harmonizacao
     */

    public HarmonizacaoController()
    {
        harmonizacaoModel = new HarmonizacaoModel();
    }
/**
 *
 *
 *
 * @param cerveja
 * @param prato
 * @return
 */
    public boolean incluirHarmonizacao (Cerveja cerveja,Prato prato) {
        return harmonizacaoModel.incluirHarmonizacao(cerveja, prato);
    }


}
