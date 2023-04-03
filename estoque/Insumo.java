package jfactory.estoque;
/*
 	A interface collection estabelece alguns padroes 
 */

public class Insumo {
	int id;
	String nomeInsumo;
	int qtdInsumo;
	String unidadeDeMedida;
	double valor;

	public Insumo() {

	}

	public Insumo(int qtdInsumo) {
		this.qtdInsumo = qtdInsumo;
	}

	public Insumo(String nomeInsumo, int qtdInsumo, String unidadeDeMedida, double valor) {
		this.nomeInsumo = nomeInsumo;
		this.qtdInsumo = qtdInsumo;
		this.unidadeDeMedida = unidadeDeMedida;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeInsumo() {
		return nomeInsumo;
	}

	public void setNomeInsumo(String nomeInsumo) {
		this.nomeInsumo = nomeInsumo;
	}

	public int getQtdInsumo() {
		return qtdInsumo;
	}

	public void setQtdInsumo(int qtdInsumo) {
		this.qtdInsumo = qtdInsumo;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}