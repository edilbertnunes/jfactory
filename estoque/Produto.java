package jfactory.estoque;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Produto {

	int id;
	String nome;
	LocalDate dataLancamento;
	LocalDate dataProducao;
	double percentualLucro;
	double valorProduto;
	int quantidade; // controle de estoque
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	List<Insumo> lista = new ArrayList<>();

	public Produto() {

	}

	// crud/insert
	public void adicionarItem(Insumo insumo) {
		lista.add(insumo);
	}

	// crud select
	public List<Insumo> listarInsumo() {
		return lista;
	}
	
	public boolean removerInsumo(int index) {
	    if (index < 0 || index >= lista.size()) {
	        System.out.println("Índice inválido. O insumo não foi removido.");
	        return false;
	    }
	    Insumo insumoRemovido = lista.remove(index);
	    System.out.println("Insumo \"" + insumoRemovido.getNomeInsumo() + "\" removido com sucesso.");
	    return true;
	}
	
	public String atualizarInsumo(int id, Insumo insumo) {
		lista.set(id, insumo);
		return "Atualizado com sucesso";
	}

	public Insumo buscaPorId(int id) {
		
		for(Insumo i : lista) {
			int indice = lista.indexOf(i);
			if (id == indice) {
				return i;
			}
		}
		return null;
	}
	
	public double somarInsumo() {
		double soma = 0;
		for (Insumo insumo : lista) {
			soma += insumo.getValor() * insumo.getQtdInsumo();
		}
		return soma;
	}
	
//	public void darBaixaEstoque(int id, int quantidade) { 
//		Produto produto = findById(id); 
//			if (produto != null && produto.getQuantidade() >= quantidade) { 
//				produto.setQuantidade(produto.getQuantidade() - quantidade); 
//				System.out.println("Baixa no estoque realizada com sucesso: " + produto); 
//				} else { 
//					System.out.println("Não foi possível dar baixa no estoque."); 
//					} 
//			}
	
	public long calcularDiasLancamento() {
		long diferenca = ChronoUnit.DAYS.between(dataProducao, dataLancamento) ;
		return diferenca;
	}
	
	public double valorDeVendaProduto(double percentual) {
		return this.valorProduto * (1 + percentual);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public LocalDate getDataProducao() {
		return dataProducao;
	}

	public void setDataProducao(LocalDate dataProducao) {
		this.dataProducao = dataProducao;
	}

	public List<Insumo> getItens() {
		return lista;
	}

	public void setItens(List<Insumo> itens) {
		this.lista = itens;
	}

	public int getId() {
		return id;
	}

	public double getPercentualLucro() {
		return percentualLucro;
	}

	public void setPercentualLucro(double percentualLucro) {
		this.percentualLucro = percentualLucro;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

}