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

	public double somarInsumo() {
		double soma = 0;
		for (Insumo insumo : lista) {
			soma += insumo.getValor() * insumo.getQtdInsumo();
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