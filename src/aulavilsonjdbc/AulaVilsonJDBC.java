package aulavilsonjdbc;

import aulavilsonjdbc.dao.DaoLivro;
import aulavilsonjdbc.entidades.Livro;
import aulavilsonjdbc.utilidades.Conexao;

public class AulaVilsonJDBC {
	public static void main(String[] args) {
		/*if(Conexao.conectar() != null) {
			System.out.println("Conectado");
		}
		 else {
			System.out.println("Erro ao conectar");
		}*/
		
		Livro l1 = new Livro("Orgulho e Preconceito", "400", "romance");
		DaoLivro dl = new DaoLivro();
		if(dl.salvar(l1)) {
			System.out.println("Livro cadastrado com sucesso");
		}
	}
}
