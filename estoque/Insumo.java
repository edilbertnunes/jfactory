package jfactory.estoque;

public class Insumo {
	int id;
	String nomeInsumo;
	int qtdInsumo;
	String unidadeDeMedida;
	double valor;
	
	public Insumo() {
		
	}
	
	public int getId() {
		return id;
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