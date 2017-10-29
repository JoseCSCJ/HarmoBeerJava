package com.harmobeer.main;

import java.util.ArrayList;

import com.harmobeer.db.dao.AvaliacaoDAO;
import com.harmobeer.db.dao.CervejaDAO;
import com.harmobeer.db.dao.HarmonizacaoDAO;
import com.harmobeer.db.dao.UsuarioDAO;
import com.harmobeer.vo.Avaliacao;
import com.harmobeer.vo.Cerveja;
import com.harmobeer.vo.Harmonizacao;
import com.harmobeer.vo.Prato;
import com.harmobeer.vo.Usuario;

public class MainTeste {

	public static void main(String[] args) {
		HarmonizacaoDAO hd = new HarmonizacaoDAO();
		Harmonizacao harmo = new Harmonizacao(1);
		Cerveja cerveja = new Cerveja(4);
		CervejaDAO cvd = new CervejaDAO();
		Prato prato = new Prato(5);
		Avaliacao aval = new Avaliacao(1,3,4,"Nao tomaria de novo");
		AvaliacaoDAO ad = new AvaliacaoDAO();
		UsuarioDAO ud =new UsuarioDAO();
		Usuario user = new Usuario(4);
		ArrayList<Cerveja> cv = new ArrayList<Cerveja>();
		
		cv=(ArrayList<Cerveja>) cvd.buscarCerv("oru");
		
		for (Cerveja cerv:cv){
			System.out.println(cerv.getNm_cerv());
		}
		
		
		
		
		
		
	}

}
