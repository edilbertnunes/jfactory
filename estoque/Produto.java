package jfactory.estoque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jfactory.fabrica.InventarioBO;

import java.time.temporal.ChronoUnit;

public class Produto {

	int id;
	String nome;
	LocalDate dataLancamento;
	LocalDate dataProducao;
	double percentualLucro;
	double valorProduto;
	List<Item> lista = new ArrayList<>();

	public Produto() {

	}

	// crud/insert
	public void adicionarItem(Item item) {
		lista.add(item);
	}

	// crud select
	public List<Item> listarItem() {
		return lista;
	}

	public double somarItem() {
		double soma = 0;
		for (Item item : lista) {
			soma += item.getValor() * item.getQtdItem();
		}
		return soma;
	}
	
	public long calcularDiasLancamento() {
		long diferenca = ChronoUnit.DAYS.between(dataProducao, dataLancamento) ;
		return diferenca;
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

	public List<Item> getItens() {
		return lista;
	}

	public void setItens(List<Item> itens) {
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