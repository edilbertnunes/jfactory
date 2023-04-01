package jfactory.autenticacao;

public class LoginBO {
	public int qtdTentativas = 0;
	public int limiteTentativa = 3;
	Boolean senhaBloqueada = false;

	public Boolean validaSenha(Login login) {

		if (senhaBloqueada) {
			return false;
		}

		if (login.getUsuario().equalsIgnoreCase("java") && (login.getSenha().equalsIgnoreCase("123"))) {
			return true;
		} else {
			qtdTentativas++;
			if (qtdTentativas >= limiteTentativa) {
				senhaBloqueada = true;
				return false;
			} else {
				return false;
			}
		}
	}
}

