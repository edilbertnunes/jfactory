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
		Insumo insumo = null;
		Produto produto = new Produto();
		
		int op = 0;
		System.out.println("Escolha o móduto 1-Fabrica, 2-Loja");
		op = entrada.nextInt();
		entrada.nextLine(); // buffer
		switch (op) {
		case 1:
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
					System.out.println("==== Etapa 5: deletar insumo  ==== ");
					System.out.println("==== Etapa 6: atualizar insumo  ==== ");
					System.out.println("==== Etapa 7: Contagem regressiva do lançamento ==== ");
					System.out.println("==== Etapa 8: Deseja sair? digite -1");
					System.out.println("==== Etapa 9: Pesquisar por id ====");
					opcao = entrada.nextInt();
					entrada.nextLine(); // buffer
					
					switch (opcao) {
					case 1: {
						
						int op2 = 0;
						do {
							System.out.println("==== Adicione um item ====");
						insumo = new Insumo();
						//System.out.print("Digite o id: ");
						// int idInsumo = entrada.nextInt();
						//insumo.setId(idInsumo);
						
						System.out.print("Nome Insumo: ");
						String nomeInsumo = entrada.nextLine();
						insumo.setNomeInsumo(nomeInsumo);
						entrada.nextLine(); // buffer
						
						System.out.print("Quantidade do Insumo: ");
						int qtdInsumo = entrada.nextInt();
						insumo.setQtdInsumo(qtdInsumo);
						
//						System.out.print("Unidade de Medida Insumo: ");
//						String unidadeMedida = entrada.nextLine();
//						insumo.setUnidadeDeMedida(unidadeMedida);
//						entrada.nextLine(); // buffer

						System.out.print("Valor Insumo: ");
						double valorInsumo = entrada.nextDouble();
						insumo.setValor(valorInsumo);
						
						produto.adicionarItem(insumo);
						System.out.println("Itens adicionados");
						
						System.out.print("Deseja acionar mais um item?");
						op2 = entrada.nextInt();
						entrada.nextLine(); // buffer	
						
						} while (op2 != -1);
						System.out.println("Saindo...");
						break;
						
					}
					
					case 2: {
						// Consumer -interface funcional
						// produto.listarItem().forEach(null);
						List<Insumo> lista = produto.listarInsumo();

						System.out.println("==== Lista de insumo cadastradas ====");
						// listando itens
						for (Insumo insumos : lista) {
							
							int position = lista.indexOf(insumos);
							System.err.println("Posição: "+position);
							//System.out.println("ID: "+insumos.getId());
							System.out.println("Insumo: "+insumos.getNomeInsumo());
							System.out.println("Valor: "+insumos.getValor());
							System.out.println("Quantidade: "+insumos.getQtdInsumo());
							//System.out.println("Unidade: "+insumos.getUnidadeDeMedida());
							System.out.println("==========");
						}

						// Mostrando total de itens
						System.out.println("Soma produtos: " + produto.somarInsumo());
						break;
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
						
						for (Insumo insumos : produto.listarInsumo()) {
							System.out.println(insumos.getNomeInsumo());
							System.out.println(insumos.getValor());
							System.out.println(insumos.getUnidadeDeMedida());
						}
						break;
					}
					
					case 5: {
						System.out.println("==== Digite a posição do produto para excluir o insumo ====");
						int deleteInsumo = entrada.nextInt();
						produto.removerInsumo(deleteInsumo);	
						break;
					}
					case 6: {
						System.out.println("==== Digite a posição do produto para atualizar o insumo ====");
						int indice = entrada.nextInt();
						
						insumo = produto.buscaPorId(indice);
						// criar switch
						System.out.println("MENU - 1 quantidade, 2 valor, 3 nome do insumo");
						System.out.println("Atualizar quantidade");
						insumo.setQtdInsumo(entrada.nextInt());
						
						// realizar pesquisa por id trazendo o insumo
						produto.atualizarInsumo(indice, insumo);	
						
						break;
					}
					
					case 7: {
						LocalDate dataProducao = LocalDate.now();
						produto.setDataProducao(dataProducao);
						System.out.print(String.format("faltam %d dias para data de lancamento do produto",
						produto.calcularDiasLancamento()));
						break;
					}
					case 8: {
						System.out.println("==== PESQUISAR POR ID ====");
						int indice = entrada.nextInt();
						insumo = produto.buscaPorId(indice);	
						System.out.println(insumo.getNomeInsumo());
						System.out.println(insumo.getValor());
						break;
					}
					
					}
					
				} while (opcao != -1);	
				
				System.out.println("saindo...");
				System.exit(0);

				break;

			} else if (bo.qtdTentativas < 3) {
				System.out.println("Tente novamente: " + (bo.limiteTentativa - bo.qtdTentativas));
				continue;
			}
			if (bo.qtdTentativas == 3) {
				System.out.println("Senha bloqueada: ");
			}

		} while (bo.qtdTentativas < bo.limiteTentativa);

		break;
		case 2:
			System.out.println("Seja bem vindo ao JStore");
	
			break;
		}
		entrada.close();

	}
}