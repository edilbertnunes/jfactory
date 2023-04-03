package jfactory.estoque;

import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
	
    private List<Produto> listaProdutos;

    public ProdutoDAO() {
        listaProdutos = new ArrayList<>();
    }
	
	public void adicionarProduto(Produto produto) {
		listaProdutos.add(produto);
	}
	
	public void removerProduto(int index) {
		listaProdutos.remove(index);
	}
	
	public String atualizarProduto(int id, Produto produto) {
		listaProdutos.set(id, produto);
		return "Atualizado com sucesso";
	}

	public Produto buscaPorId(int id) {
		for(Produto produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;
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
	
    public List<Produto> listarProdutos() {
        return new ArrayList<>(listaProdutos);
    }
}
