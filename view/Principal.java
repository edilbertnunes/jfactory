package jfactory.view;

import java.util.Scanner;

import jfactory.fabrica.Login;
import jfactory.fabrica.LoginBO;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		LoginBO bo = new LoginBO();
		Login l = new Login();

		do {
			System.out.print("Digite o usuário: ");
			String usuario = entrada.nextLine();
			l.setUsuario(usuario);

			System.out.print("Digite a senha: ");
			String senha = entrada.nextLine();
			l.setSenha(senha);
			if (bo.validaSenha(l)) {
				System.out.println("Seja bem vindo ao JFactory");
				break;
			} else if (bo.qtdTentativas < 3) {
				System.out.println("Tente novamente " + (bo.limiteTentativa - bo.qtdTentativas));
				continue;
			}
			if (bo.qtdTentativas == 3) {
				System.out.println("Senha bloqueada");
			}

		} while (bo.qtdTentativas < bo.limiteTentativa);

		entrada.close();
 
	}
}