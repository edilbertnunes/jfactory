package jfactory.fabrica;

import java.util.ArrayList;
import java.util.List;

import jfactory.estoque.Item;

public class InventarioBO {
	List<Item> listaIngredientes = new ArrayList<>();
	
	
	public void adicionarIngredientes(Item item) {
		listaIngredientes.add(item);
	}

}
