package sistemaacademico;

import java.util.ArrayList;

/**
 *
 * @author Wanderley de Souza Alencar
 */

public class SituacaoDisciplina{
    private ArrayList <ElementoDescritivo>      situacaoDisciplina;
    
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
    	elementoDescritivo.setElementoDescritivo(04, "CON", "Conclu�da");
    	this.situacaoDisciplina.add(elementoDescritivo);
    	elementoDescritivo = new ElementoDescritivo();
    	elementoDescritivo.setElementoDescritivo(05, "OUT", "Outra");
    }
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
        System.out.println("|       SISTEMA DE GERENCIAMENTO ACAD�MICO                                 ");
    	System.out.println("|       C�digo: " + this.getsituacaoDisciplina(index).getCodigo());
    	System.out.println("|       Descri��o Abreviada: " + this.getsituacaoDisciplina(index).getDescricaoAbreviada());
    	System.out.println("|       Descri��o Completa: " + this.getsituacaoDisciplina(index).getDescricaoCompleta());
    	System.out.println("|__________________________________________________________________________.");
    }
    
    
}
    