/*
 * Sistema de GestÃ£o AcadÃªmica 
 */
package sistemaacademico;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * @author Wanderley de Souza Alencar
 */
public class SistemaAcademico {

        private static ArrayList <Disciplina>              disciplinas;

        public static boolean checkLetters(String str) 
        {
            return str.matches("[a-zA-Z]+");
        }
              
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        int i;
       
        Scanner ler = new Scanner(System.in);
        Scanner seEhVinculado = new Scanner(System.in);
        int vinculado = 0;
        int auxiliar = 1;
        String curso;
       
        
        Disciplina disciplina = new Disciplina();
        
        disciplinas = new ArrayList<>();

        System.out.println("Digite um dos seguintes números para acessar: " //try catch ***TIPO DE ENTRADA SER VÁLIDA (INT) E CASO FOR DIFERENTE DE 1,2,3 E 4***
        		+ "\n1 - Cadastrar informações sobre a disciplina."
        		+ "\n2 - Alterar informações sobre a disciplina."
        		+ "\n3 - Excluir a disciplina."
        		+ "\n4 - Consultar uma disciplina.");
        int leitura = ler.nextInt();
		
        switch (leitura) {
        	
        	case 1:	System.out.println("\n\n\nBEM VINDO AO SISTEMA DE CADASTRAMENTO DE DISCIPLINAS! <3 ");
               		String nomeCompleto = ler.nextLine();
               		disciplina.setNomeCompleto(nomeCompleto);
               		if(checkLetters(nomeCompleto)==false) {
               			do {
               				System.out.println("\n Digite o nome completo da disciplina que deseja cadastrar (Neste campo não é válido o uso de números.): ");
               				nomeCompleto = ler.nextLine();
                       		disciplina.setNomeCompleto(nomeCompleto);
               			}
               			while(checkLetters(nomeCompleto)==false);
               		}

               		System.out.println("\n Digite a sigla de abreviação da disciplina com no máximo três letras:");
               		String nomeAbreviado = ler.nextLine();
               		disciplina.setNomeAbreviado(nomeAbreviado); //try catch  *****TIPO DE ENTRADA SER VÁLIDA (STRING)*******
               		System.out.println("\n Adicione o código da disciplina (máximo de 6 dígitos): ");
               		int codigo = Integer.parseInt(ler.nextLine());
               		disciplina.setCodigo(codigo); //try catch  *****TIPO DE ENTRADA SER VÁLIDA (STRING)*******
		
               		do {
    	    		
               			try {

               				System.out.println("\nCADASTRO DE CURSO VINCULADO A DISCIPLINA:"
        	    						+ "\n0 disciplina de núcleo livre;"
        	    						+ "\n1 adicionar um curso vinculado a disciplina;"
        	        					+ "\nQualquer outro número para sair.");
               				vinculado = seEhVinculado.nextInt();
    	    		
               				break;
    	    		
               			}catch(InputMismatchException e) {// mudar exception **TIPO DE ENTRADA SER VÁLIDA (INT)***
    	    			System.out.println("Número invalido");
               			}
               		}while(auxiliar==1);
    	        	
			
               		switch (vinculado) {
               			case 0: 
               				disciplina.setCurso("Núcleo livre"); 	   		
               				break;
               			case 1:
               				System.out.println("Digite o curso ao qual essa disciplina está vinculada: ");
               				disciplina.setCurso(ler.nextLine()); //try catch *****TIPO DE ENTRADA SER VÁLIDA********
               				break;
               			default: 	
               				break;
               		}
               		
               		System.out.println("DOCENTES ASSOCIADOS");
               		System.out.println("Insira o nome no docente responsável: ");
               		disciplina.setDocenteResponsavel(ler.nextLine());
               		System.out.println("Há docentes auxiliares?"
               				+ "\n1-SIM"
               				+ "\n2-NÃO");
               		int doc = ler.nextInt();
               		
               		do {
               		
               			switch(doc){
               				case 1:
               					System.out.println("Insira o nome do docente auxiliar");
               					disciplina.setDocenteAuxiliar(ler.nextLine());
               					break;
               				case 2:
               					break;
               				default:
               					System.out.println("Entrada inválida.");
               			}
               		
               		
        	
               		}while(auxiliar==1);
        }		
        
        
        
        
        
        
        
        
        ///for (i = 0; (i < unidadesFederativas.size()); i++) {
       //     unidadesFederativas.show(i);
       // }
       // System.out.println("Fim");
    }




	private static void swicth(int doc) {
		// TODO Auto-generated method stub
		
	}
    
}
