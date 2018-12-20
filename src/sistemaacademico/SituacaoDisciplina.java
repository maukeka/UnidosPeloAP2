package sistemaacademico;

import java.util.ArrayList;


/**
 * 
 * @author 	Eduardo César Freitas da Silva Filho
 * @author	Laís Ribeiro Torres 
 * @author	Marcos Paulo da Carvalho Araújo
 * @author 	Mauricio Kenichi Kanashiro
 * @author 	Rodolfo Pereira Lemos
 * @author 	Samuel dos Santos Nogueira
 * 
 * Nome.......: SituacaoDisciplina
 * Objetivo...: Representar a situação atual da disciplina.
 * Observacoes: Não foi usado todos os métos, sendo feitas adaptações para a exibição da situação da disciplina
 * 
 */

public class SituacaoDisciplina{
	private ArrayList <ElementoDescritivo>      situacaoDisciplina;

	/**
	 * Método para passagem de parâmetros conforme o dado inserido pelo usuário
	 */
	public SituacaoDisciplina() {
		ElementoDescritivo elementoDescritivo;

		this.situacaoDisciplina = new ArrayList();
		elementoDescritivo = new ElementoDescritivo();
		elementoDescritivo.setElementoDescritivo(00, "DS", "Desconhecida");
		this.situacaoDisciplina.add(elementoDescritivo);
		elementoDescritivo = new ElementoDescritivo();
		elementoDescritivo.setElementoDescritivo(01, "ABR", "Aberta");
		this.situacaoDisciplina.add(elementoDescritivo);
		elementoDescritivo = new ElementoDescritivo();
		elementoDescritivo.setElementoDescritivo(02, "ATV", "Ativa");
		this.situacaoDisciplina.add(elementoDescritivo);
		elementoDescritivo = new ElementoDescritivo();
		elementoDescritivo.setElementoDescritivo(03, "INT", "Inativa");
		this.situacaoDisciplina.add(elementoDescritivo);
		elementoDescritivo = new ElementoDescritivo();
		elementoDescritivo.setElementoDescritivo(04, "CON", "Concluída");
		this.situacaoDisciplina.add(elementoDescritivo);
		elementoDescritivo = new ElementoDescritivo();
		elementoDescritivo.setElementoDescritivo(05, "OUT", "Outra");
	}

	/**
	 * Método para criar lista de situações de disciplina
	 * @return
	 */
	public ArrayList<ElementoDescritivo> getSituacaoDisciplina() {
		return (this.situacaoDisciplina);
	}


	public ElementoDescritivo getsituacaoDisciplina(int index) {
		if ((index >= 0) && (index < situacaoDisciplina.size())) {
			return (this.situacaoDisciplina.get(index));
		}
		else {
			return (new ElementoDescritivo());
		}
	}


	public int indexOf(String str) {
		int i;
		for (i = 0; (i < this.situacaoDisciplina.size()); i++) {
			if (this.situacaoDisciplina.get(i).getDescricaoAbreviada().equalsIgnoreCase(str)) {
				return (i);
			}
		}
		return (-1);
	}


	public int size() {
		return(this.situacaoDisciplina.size());
	}
	public void show(int index) {
		System.out.println(".__________________________________________________________________________.");
		System.out.println("|                                                                          ");
		System.out.println("|       SISTEMA DE GERENCIAMENTO ACADÊMICO                                 ");
		System.out.println("|       Código: " + this.getsituacaoDisciplina(index).getCodigo());
		System.out.println("|       Descrição Abreviada: " + this.getsituacaoDisciplina(index).getDescricaoAbreviada());
		System.out.println("|       Descrição Completa: " + this.getsituacaoDisciplina(index).getDescricaoCompleta());
		System.out.println("|__________________________________________________________________________.");
	}


}
