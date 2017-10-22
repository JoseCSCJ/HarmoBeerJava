package com.harmobeer.main;

import java.util.ArrayList;

import com.harmobeer.db.dao.PratoDAO;
import com.harmobeer.vo.Prato;

public class MainTeste {

	public static void main(String[] args) {
		PratoDAO pd = new PratoDAO();
		ArrayList <Prato> lista = new ArrayList<Prato>();
		lista=(ArrayList<Prato>) pd.listarTodos();
		
		for(Prato pratos : lista){
			
			System.out.println (pratos.getId_prato() + " "+ pratos. getNm_prato());
		}

	}

}
