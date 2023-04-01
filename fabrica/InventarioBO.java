package jfactory.fabrica;

import java.util.ArrayList;
import java.util.List;

import jfactory.estoque.Insumo;

public class InventarioBO {
	List<Insumo> listaIngredientes = new ArrayList<>();
	
	
	public void adicionarIngredientes(Insumo insumo) {
		listaIngredientes.add(insumo);
	}

}
