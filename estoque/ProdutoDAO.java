package jfactory.estoque;

import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
	
	List<Produto> lista = new ArrayList<>();
	
	public void adicionarProduto(Produto produto) {
		lista.add(produto);
	}

	// crud select
	public List<Produto> listarProduto() {
		return lista;
	}
	
	public void removerProduto(int index) {
		lista.remove(index);
	}
	
	public String atualizarProduto(int id, Produto produto) {
		lista.set(id, produto);
		return "Atualizado com sucesso";
	}

	public Produto buscaPorId(int id) {
		
		for(Produto i : lista) {
			int indice = lista.indexOf(i);
			if (id == indice) {
				return i;
			}
		}
		return null;
	}
	
	public void darBaixaEstoque(int id, int quantidade) {
		Produto produto = buscaPorId(id);
		if(produto != null && produto.getQuantidade() >= quantidade) {
			produto.setQuantidade(produto.getQuantidade() - quantidade);
		}
		
	}

}