/*
 * Sistema de GestÃ£o AcadÃªmica 
 */
package sistemaacademico;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Wanderley de Souza Alencar
 */
public class SistemaAcademico {

        private static ArrayList <Disciplina>              disciplinas;


        
        
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        int i;
        int leitura;
        Scanner ler = new Scanner(System.in);
        disciplinas             = new ArrayList<>();

        System.out.println("Digite um dos seguintes números para acessar: "
        		+ "\n1 - Cadastrar informações sobre a disciplina."
        		+ "\n2 - Alterar informações sobre a disciplina."
        		+ "\n3 - Excluir a disciplina."
        		+ "\n4 - Consultar uma disciplina.");
        leitura = ler.nextInt();
        switch (leitura) {
        case 1:	    	

        	break;
        }
        
        
        
        
        
        
        
        
        ///for (i = 0; (i < unidadesFederativas.size()); i++) {
       //     unidadesFederativas.show(i);
       // }
       // System.out.println("Fim");
    }
    
}
