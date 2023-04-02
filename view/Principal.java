package jfactory.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import jfactory.autenticacao.Login;
import jfactory.autenticacao.LoginBO;
import jfactory.estoque.Insumo;
import jfactory.estoque.Produto;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		LoginBO bo = new LoginBO();
		Login l = new Login();
		Insumo ins = null;
		Produto produto = new Produto();

		do {
			System.out.print("Digite o usuário: ");
			String usuario = entrada.nextLine();
			l.setUsuario(usuario);

			System.out.print("Digite a senha: ");
			String senha = entrada.nextLine();
			l.setSenha(senha);
			if (bo.validaSenha(l)) {

				int opcao = 0;
				do {
					System.out.println("Seja bem vindo ao JFactory");
					System.out.println("==== Etapa 1: Cadastrar Itens ==== ");
					System.out.println("==== Etapa 2: Listar Insumo do Estoque ==== ");
					System.out.println("==== Etapa 3: Definir Produto ==== ");
					System.out.println("==== Etapa 4: Listar insumos do produto  ==== ");
					System.out.println("==== Etapa 5: Contagem regressiva do lançamento ==== ");
					System.out.println("==== Etapa 6 Deseja sair? digite -1");
					opcao = entrada.nextInt();
					entrada.nextLine(); // buffer
					
					switch (opcao) {
					case 1: {
						
						int op2 = 0;
						do {
							System.out.println("==== Adicione um item ====");
						ins = new Insumo();
						System.out.print("Nome Insumo: ");
						String nomeInsumo = entrada.nextLine();
						ins.setNomeInsumo(nomeInsumo);
						//entrada.nextLine(); // buffer
						
						System.out.print("Quantidade do Insumo: ");
						int qtdInsumo = entrada.nextInt();
						ins.setQtdInsumo(qtdInsumo);
						
						System.out.print("Unidade de Medida Insumo: ");
						String unidadeMedida = entrada.nextLine();
						ins.setUnidadeDeMedida(unidadeMedida);
						entrada.nextLine(); // buffer

						System.out.print("Valor Insumo: ");
						double valorInsumo = entrada.nextDouble();
						ins.setValor(valorInsumo);
						
						produto.adicionarItem(ins);
						System.out.println("Itens adicionados");
						
						System.out.print("Deseja acionar mais um item?");
						op2 = entrada.nextInt();
						entrada.nextLine(); // buffer	
						
						} while (op2 != -1);
						
						break;
					}
					
					case 2: {
						// Consumer -interface funcional
						// produto.listarItem().forEach(null);
						List<Insumo> lista = produto.listarInsumo();

						System.out.println("==== Lista de insumo cadastradas ====");
						// listando itens
						for (Insumo insumo : lista) {
							
							int position = lista.indexOf(insumo);
							System.err.println("Posição: "+position);
							System.out.println("Insumo: "+insumo.getNomeInsumo());
							System.out.println("Valor: "+insumo.getValor());
							System.out.println("Quantidade: "+insumo.getQtdInsumo());
							System.out.println("Unidade: "+insumo.getUnidadeDeMedida());
							System.out.println("==========");
						}

						// Mostrando total de itens
						System.out.println("Soma produtos: " + produto.somarInsumo());
					}

					case 3: {
						System.out.println("==== Qual produto deseja produzir? ====");
						String nomeProduto = entrada.nextLine();
						produto.setNome(nomeProduto);
						entrada.nextLine(); // buffer	
						
						System.out.print("Digite data lançamento, no formado dd/MM/yyyy: ");
						String dataLancamento = entrada.nextLine();
						DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate data = LocalDate.parse(dataLancamento, dataFormatada);
						produto.setDataLancamento(data);

						System.out.print("Digite valor Produto: ");
						double valorProduto = entrada.nextDouble();
						produto.setValorProduto(valorProduto);

						System.out.print("Digite percentual de Lucro ");
						double percentual = entrada.nextDouble();
						produto.setPercentualLucro(percentual);
						break;
					}
					
					case 4: {
						System.out.println("Listar insumo do produto");
						System.out.println("Produto: "+produto.getNome());
						System.out.println("Produto: "+produto.getDataLancamento());
						
						for (Insumo insumo : produto.listarInsumo()) {
							System.out.println(insumo.getNomeInsumo());
							System.out.println(insumo.getValor());
							System.out.println(insumo.getUnidadeDeMedida());
						}
						
						
						
						break;
					}
					
					
					
					case 5: {
						LocalDate dataProducao = LocalDate.now();
						produto.setDataProducao(dataProducao);
						System.out.print(String.format("faltam %d dias para data de lancamento do produto",
								produto.calcularDiasLancamento()));
						break;
					}
					}
					
				} while (opcao != -1);	

				break;

			} else if (bo.qtdTentativas < 3) {
				System.out.println("Tente novamente: " + (bo.limiteTentativa - bo.qtdTentativas));
				continue;
			}
			if (bo.qtdTentativas == 3) {
				System.out.println("Senha bloqueada: ");
			}

		} while (bo.qtdTentativas < bo.limiteTentativa);

		entrada.close();

	}
}