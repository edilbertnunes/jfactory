package jfactory.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import jfactory.autenticacao.Login;
import jfactory.autenticacao.LoginBO;
import jfactory.estoque.Insumo;
import jfactory.estoque.Produto;
import jfactory.estoque.ProdutoDAO;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		LoginBO bo = new LoginBO();
		Login login = new Login();
		Insumo insumo = null;
		Produto produto = new Produto();
		ProdutoDAO produtoDao = new ProdutoDAO();
		

		int op = 0;
		while (op != 1 && op != 2) {
		    System.out.println("======== Bem vindo ao grupo JFactory ========");
		    System.out.println("=========== Selecione o módulo ==============");
		    System.out.println("[1] Fabrica");
		    System.out.println("[2] Loja");
		    System.out.println("==========================");
		    System.out.print("Módulo: ");
		    op = entrada.nextInt();
		    entrada.nextLine(); // buffer
		    if (op != 1 && op != 2) {
		        System.out.println("Opção inválida. Por favor, selecione [1] Fabrica ou [2] Loja.");
		    }
		}
		switch (op) {
		case 1:
			do {
				System.out.print("Digite o usuário: ");
				String usuario = entrada.nextLine();
				login.setUsuario(usuario);

				System.out.print("Digite a senha: ");
				String senha = entrada.nextLine();
				login.setSenha(senha);
				if (bo.validaSenha(login)) {

					int opcao = 0;
					do {
						System.out.println("=============Seja bem vindo ao JFactory=============");
						System.out.println("********* Selecione uma das opções abaixo **********");
						System.out.println("==== Etapa 1: Cadastrar Insumo                  ====");
						System.out.println("==== Etapa 2: Listar Insumo do Estoque          ====");
						System.out.println("==== Etapa 3: Cadastrar Produto                 ====");
						System.out.println("==== Etapa 4: Listar insumos do produto         ====");
						System.out.println("==== Etapa 5: Deletar Insumo                    ====");
						System.out.println("==== Etapa 6: Atualizar Insumo                  ====");
						System.out.println("==== Etapa 7: Contagem regressiva do lançamento ====");
						System.out.println("==== Etapa 8: Pesquisar por id                  ====");
						System.out.println("==== Etapa 9: Listar Produtos                   ====");
						System.out.println("==== Etapa 10: Editar Produto                   ====");
						System.out.println("==== Etapa 11: Deletar Produto                  ====");
						System.out.println("==== Etapa 15: Deseja sair? digite -1:          ====");
						System.out.println("=============**************************=============");
						opcao = entrada.nextInt();
						entrada.nextLine(); // buffer

						switch (opcao) {
						case 1: {

							int op2 = 0;
							do {
								System.out.println("==== Adicione um item ====");
								insumo = new Insumo();
								// System.out.print("Digite o id: ");
								// int idInsumo = entrada.nextInt();
								// insumo.setId(idInsumo);

								System.out.print("Nome Insumo: ");
								String nomeInsumo = entrada.nextLine();
								insumo.setNomeInsumo(nomeInsumo);
								// entrada.nextLine(); // buffer

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
								System.out.println("Item adicionado com sucesso");

								System.out.print("Deseja adicionar mais um item?");
								op2 = entrada.nextInt();
								entrada.nextLine(); // buffer

							} while (op2 != -1);
							System.out.println("Saindo...");
							break;

						}

						case 2: {
							List<Insumo> lista = produto.listarInsumo();
							System.out.println("==== Lista de insumos cadastrados ====");
							for (int i = 0; i < lista.size(); i++) {
							    Insumo insumos = lista.get(i);
							    System.out.println("Posição: " + i);
							    System.out.println("Insumo: " + insumos.getNomeInsumo());
							    System.out.println("Valor: " + insumos.getValor());
							    System.out.println("Quantidade: " + insumos.getQtdInsumo());
							    System.out.println("==========");
							}
							System.out.println("Soma dos insumos: " + produto.somarInsumo());
							System.out.println("==============================");
							break;
						}

						case 3: {
							int opProduto = 0;
							do {
							System.out.println("==== Adicionar Produto ====");
							produto = new Produto();
							System.out.print("Qual produto deseja produzir? ");
							String nomeProduto = entrada.nextLine();
							produto.setNome(nomeProduto);

							System.out.print("Digite valor Produto: ");
							double valorProduto = entrada.nextDouble();
							produto.setValorProduto(valorProduto);

							System.out.print("Digite percentual de Lucro ");
							double percentual = entrada.nextDouble();				
							
							produto.setPercentualLucro(percentual);
							double valorVenda = produto.valorDeVendaProduto(percentual);
							entrada.nextLine(); // buffer							
							System.out.printf("O valor para venda do produto deve ser de: %.2f ", valorVenda);
							System.out.println();							
							

							produtoDao.adicionarProduto(produto);
							System.out.println("Produto adicionado com sucesso");

							System.out.print("Deseja adicionar mais um Produto? ");
							opProduto = entrada.nextInt();
							entrada.nextLine(); // buffer

							} while (opProduto != -1);
							System.out.println("Saindo...");
							break;
						}

						case 4: {
						    System.out.println("Listar insumo do produto");
						    if (produto.listarInsumo().isEmpty()) {
						        System.out.println("Não há insumos cadastrados para este produto.");
						    } else {
						        System.out.println("Produto: " + produto.getNome());
						        //System.out.println("Data de Lançamento: " + produto.getDataLancamento());
						        for (Insumo insumos : produto.listarInsumo()) {
						            System.out.println(insumos.getNomeInsumo());
						            System.out.println(insumos.getValor());
						            System.out.println(insumos.getUnidadeDeMedida());
						        }
						    }
						    break;
						}

						case 5: {
							System.out.print("Digite a posição do produto para excluir o insumo: ");
							int deleteInsumo = entrada.nextInt();
							produto.removerInsumo(deleteInsumo);
							break;
						}
						case 6: {
						    System.out.print("Digite a posição do produto para atualizar o insumo: ");
						    int indice = entrada.nextInt();
						    entrada.nextLine();
						    
						    Insumo insumoUpdate = produto.buscaPorId(indice);
						    int opcaoUpdate = 0;
						    String opcaoContinuar;
						    do {
						        System.out.println("MENU - 1 quantidade, 2 valor, 3 nome do insumo");
						        opcaoUpdate = entrada.nextInt();
						        entrada.nextLine();
						        
						        switch(opcaoUpdate) {
						            case 1:
						                System.out.println("Atualizar quantidade: ");
						                insumoUpdate.setQtdInsumo(entrada.nextInt());
						                entrada.nextLine();
						                break;
						            case 2:
						                System.out.println("Atualizar valor: ");
						                insumoUpdate.setValor(entrada.nextDouble());
						                entrada.nextLine();
						                break;
						            case 3:
						                System.out.println("Atualizar nome do insumo: ");
						                insumoUpdate.setNomeInsumo(entrada.nextLine());
						                break;
						            default:
						                System.out.println("Opção inválida.");
						        }
						        
						        System.out.print("Deseja atualizar outro item? [s/n]: ");
						        opcaoContinuar = entrada.nextLine();
						    } while(opcaoContinuar.equalsIgnoreCase("s"));
						    
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
							System.out.println("Nome Insumo: "+insumo.getNomeInsumo());
							System.out.println("Valor insumo: "+insumo.getValor());
							break;
						}

						case 9: {			
						    System.out.println("==== Lista de produtos cadastrados ====");

						    List<Produto> produtos = produtoDao.listarProdutos();
						    if (produtos.isEmpty()) {
						        System.out.println("Nenhum produto cadastrado.");
						    } else {
						        for (Produto prod : produtos) {
						            int position = produtos.indexOf(prod);
						            System.out.println("Posição: " + position);
						            System.out.println("Produto: " + prod.getNome());
						            System.out.println("Valor: " + prod.getValorProduto());
						            System.out.println("Data lançamento: " + prod.getDataLancamento());
						            System.out.println("==========");
						        }
						    }
						    break;
						}
						case 10: {
							System.out.println("==== Editar Produto====");
							System.out.print("Digite a posição do produto para atualizar: ");
						    int indice = entrada.nextInt();
						    entrada.nextLine();
						    
						    Produto produtoUpdate = produtoDao.buscaPorId(indice);
						    int opcaoProd = 0;
						    String opcaoContinuar;
						    do {
						        System.out.println("MENU - 1 quantidade, 2 valor, 3 nome do insumo");
						        opcaoProd = entrada.nextInt();
						        entrada.nextLine();
						        
						        switch(opcaoProd) {
						            case 1:
						                System.out.println("Atualizar quantidade: ");
						                produtoUpdate.setQuantidade(opcaoProd);
						                entrada.nextLine();
						                break;
						            case 2:
						                System.out.println("Atualizar valor: ");
						                produtoUpdate.setValorProduto(opcaoProd);
						                entrada.nextLine();
						                break;
						            default:
						                System.out.println("Opção inválida.");
						        }
						        
						        System.out.print("Deseja atualizar outro item? [s/n]: ");
						        opcaoContinuar = entrada.nextLine();
						    } while(opcaoContinuar.equalsIgnoreCase("s"));
						    
						    produto.atualizarInsumo(indice, insumo);
						    break;
						}
						
						case 11: {
							System.out.println("==== Deletar Produto ==== ");
							System.out.print("Digite a posição do produto para excluir o produto: ");
							int deleteProduto = entrada.nextInt();
							produtoDao.removerProduto(deleteProduto);
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