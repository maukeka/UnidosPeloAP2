package sistemaacademico;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 
 * @author 	Eduardo C�sar Freitas da Silva Filho
 * @author	La�s Ribeiro Torres 
 * @author	Marcos Paulo da Carvalho Ara�jo
 * @author 	Mauricio Kenichi Kanashiro
 * @author 	Rodolfo Pereira Lemos
 * @author 	Samuel dos Santos Nogueira
 * 
 * Nome.......: Disciplinas.
 * Descri��o..: Armazena as disciplinas criadas a partir de "Discipina" e as exibe com o uso de um array. 
 * Observa��es: O objeto n�o � criado nessa classe.
 * 
 */

public class Disciplinas extends Coisa{

	private List<Disciplina> disciplinas;


	/**
	 * M�todo que cria um array para conter as disciplinas 
	 */
	public Disciplinas() {
		this.disciplinas = new ArrayList<>();
	}



	@Override
	/**
	 * M�todo que adiciona uma nova "Disciplina" no array.
	 */
	public void cadastrar(Disciplina disciplina) {
		disciplinas.add(disciplina);			
	}



	@Override
	/**
	 * M�todo que altera uma "Disciplina" j� cadastrada.
	 */
	public void alterar(Disciplina disciplina) {
		for (int posicao = 0; posicao < this.disciplinas.size(); posicao++) {
			if(this.disciplinas.get(posicao).getCodigo() == disciplina.getCodigo()) {
				disciplinas.remove(posicao);
				disciplinas.add(disciplina);
			}
		}
	}



	@Override
	/**
	 * M�todo que consulta uma "Disciplina" j� cadastrada.
	 */
	public List<Disciplina> consultar(String parametro, String chave) {
		List<Disciplina> retorno = new ArrayList<>();
		switch (parametro) {
		case "codigo":
			for (Disciplina disciplina : this.disciplinas) {
				if (disciplina.getCodigo() == Integer.parseInt(chave)) {
					retorno.add(disciplina);
				} else {
					System.out.println("\tN�o foi encontrada nenhuma disciplina com esse c�digo");
				}
			}
			break;
		case "todos":
			retorno = this.disciplinas;
			break;
		case "nomeCompleto":
			for (Disciplina disciplina : this.disciplinas) {
				String nome = disciplina.getNomeCompleto();
				if(VerificaNome(nome, chave) > chave.length()/2) {
					retorno.add(disciplina);
				} else {
					System.out.println("\tN�o foi encontrada nenhuma disciplina com esse nome");
				}
			}
			break;
		case "nomeAbreviado":
			for (Disciplina disciplina : this.disciplinas) {
				String nome = disciplina.getNomeAbreviado();
				if(VerificaNome(nome, chave) > chave.length()/2) {
					retorno.add(disciplina);
				} else {
					System.out.println("\tN�o foi encontrada nenhuma disciplina com essa abrevia��o");
				}
			}
			break;
		}
		return retorno;

	}



	@Override
	/**
	 * M�todo que exclui uma "Disciplina" j� cadastrada.
	 */
	public void excluir(int codigo) {
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getCodigo() == codigo) {
				this.disciplinas.remove(i);
				System.out.println("Disciplina removida");
				break;
			} else {
				System.out.println("\tN�o foi encontrada nenhuma disciplina com esse c�digo");
			}
		}
	}

	private int VerificaNome(String nome, String chave) {
		int porcento = 0;
		for (int i = 0; i < nome.length() && i < chave.length(); i++) {
			if (nome.charAt(i) == chave.charAt(i)) {
				porcento ++;
			}
		}
		return porcento;
	}


}
