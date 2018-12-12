package sistemaacademico;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public class Disciplinas extends Coisa{
	
	private List<Disciplina> disciplinas;
	
	

	public Disciplinas() {
			this.disciplinas = new ArrayList<>();
	}



	@Override
	public void cadastrar(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}



	@Override
	public void alterar(Disciplina disciplina) {
		for (int posicao = 0; posicao < this.disciplinas.size(); posicao++) {
			if(this.disciplinas.get(posicao).getCodigo() == disciplina.getCodigo()) {
				disciplinas.remove(posicao);
				disciplinas.add(disciplina);
			}
		}
		
	}



	@Override
	public List<Disciplina> consultar(String parametro, String chave) {
		List<Disciplina> retorno = new ArrayList<>();
		switch (parametro) {
		case "codigo":
			for (Disciplina disciplina : this.disciplinas) {
				if (disciplina.getCodigo() == Integer.parseInt(chave)) {
					retorno.add(disciplina);
				}
			}
			break;
		case "todos":
			retorno = this.disciplinas;
			break;
		case "nome completo":
			for (Disciplina disciplina : this.disciplinas) {
				String nome = disciplina.getNomeCompleto();
				if(VerificaNome(nome, chave) < chave.length()/2) {
					retorno.add(disciplina);
				}
			}
			break;
		case "nome abreviado":
			for (Disciplina disciplina : this.disciplinas) {
				String nome = disciplina.getNomeAbreviado();
				if(VerificaNome(nome, chave) < chave.length()/2) {
					retorno.add(disciplina);
				}
			}
			break;
		}
		
		return retorno;
	}



	@Override
	public void excluir(int codigo) {
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getCodigo() == codigo) {
				this.disciplinas.remove(i);
				System.out.println("Disciplina removida");
				break;
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
