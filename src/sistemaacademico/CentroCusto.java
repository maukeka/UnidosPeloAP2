package sistemaacademico;

import java.util.ArrayList;

/**
 *
 * @author Wanderley de Souza Alencar
 */
/*
* Nome.......: CentroCusto
* Objetivo...: Representa o Centro de Custo ao qual um empregado pode estar vinculado.
* Observacoes: Se for desconhecido, utilize o tipo 0 - DS - Desconhecido.
*/
public class CentroCusto {
	
    private ArrayList <ElementoDescritivo>  centroCusto;
    
    public CentroCusto() {
    	ElementoDescritivo elementoDescritivo;
    	
    	this.centroCusto = new ArrayList();
    	elementoDescritivo = new ElementoDescritivo();
    	elementoDescritivo.setElementoDescritivo(00, "DS", "Desconhecido");
    	this.centroCusto.add(elementoDescritivo);
    	elementoDescritivo = new ElementoDescritivo();
    	elementoDescritivo.setElementoDescritivo(01, "UFG - I", "UFG - Goiânia (Câmpus I)");
    	this.centroCusto.add(elementoDescritivo);
    	elementoDescritivo = new ElementoDescritivo();
    	elementoDescritivo.setElementoDescritivo(02, "UFG - II", "UFG - Goiânia (Câmpus II)");
    	this.centroCusto.add(elementoDescritivo);
    	elementoDescritivo = new ElementoDescritivo();
    	elementoDescritivo.setElementoDescritivo(03, "UFG - CAT", "UFG - Catalão");
    	this.centroCusto.add(elementoDescritivo);
    	elementoDescritivo = new ElementoDescritivo();
    	elementoDescritivo.setElementoDescritivo(04, "UFG - JAT", "UFG - Jataí");
    	this.centroCusto.add(elementoDescritivo);
    	elementoDescritivo = new ElementoDescritivo();
    	elementoDescritivo.setElementoDescritivo(05, "OUT", "Outro");
    }
    public ArrayList<ElementoDescritivo> getCentroCusto() {
        return (this.centroCusto);
    }
    public ElementoDescritivo getcentroCusto(int index) {
        if ((index >= 0) && (index < centroCusto.size())) {
            return (this.centroCusto.get(index));
        }
        else {
            return (new ElementoDescritivo());
        }
    }
    public int indexOf(String str) {
        int i;
        for (i = 0; (i < this.centroCusto.size()); i++) {
            if (this.centroCusto.get(i).getDescricaoAbreviada().equalsIgnoreCase(str)) {
                return (i);
            }
        }
        return (-1);
    }
    public int size() {
        return(this.centroCusto.size());
    }
    public void show(int index) {
        System.out.println();
        System.out.println("------------------");
        System.out.println("Centro de Custo");
        System.out.println("------------------");
        System.out.println("Código..........: " + this.getcentroCusto(index).getCodigo());
        System.out.println("Descr. Abreviada: " + this.getcentroCusto(index).getDescricaoAbreviada());
        System.out.println("Descr. Completa.: " + this.getcentroCusto(index).getDescricaoCompleta());
        System.out.println("------------------");
    }
    
}
