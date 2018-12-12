/*
 * Sistema de Gestão Acadêmica 
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

        System.out.println("Digite um dos seguintes n�meros para acessar: " //try catch ***TIPO DE ENTRADA SER V�LIDA (INT) E CASO FOR DIFERENTE DE 1,2,3 E 4***
        		+ "\n1 - Cadastrar informa��es sobre a disciplina."
        		+ "\n2 - Alterar informa��es sobre a disciplina."
        		+ "\n3 - Excluir a disciplina."
        		+ "\n4 - Consultar uma disciplina.");
        int leitura = ler.nextInt();
		
        switch (leitura) {
        	
        	case 1:	System.out.println("\n\n\nBEM VINDO AO SISTEMA DE CADASTRAMENTO DE DISCIPLINAS! <3 ");
               		String nomeCompleto = ler.nextLine();
               		disciplina.setNomeCompleto(nomeCompleto);
               		if(checkLetters(nomeCompleto)==false) {
               			do {
               				System.out.println("\n Digite o nome completo da disciplina que deseja cadastrar (Neste campo n�o � v�lido o uso de n�meros.): ");
               				nomeCompleto = ler.nextLine();
                       		disciplina.setNomeCompleto(nomeCompleto);
               			}
               			while(checkLetters(nomeCompleto)==false);
               		}

               		System.out.println("\n Digite a sigla de abrevia��o da disciplina com no m�ximo tr�s letras:");
               		String nomeAbreviado = ler.nextLine();
               		disciplina.setNomeAbreviado(nomeAbreviado); //try catch  *****TIPO DE ENTRADA SER V�LIDA (STRING)*******
               		System.out.println("\n Adicione o c�digo da disciplina (m�ximo de 6 d�gitos): ");
               		int codigo = Integer.parseInt(ler.nextLine());
               		disciplina.setCodigo(codigo); //try catch  *****TIPO DE ENTRADA SER V�LIDA (STRING)*******
		
               		do {
    	    		
               			try {

               				System.out.println("\nCADASTRO DE CURSO VINCULADO A DISCIPLINA:"
        	    						+ "\n0 disciplina de n�cleo livre;"
        	    						+ "\n1 adicionar um curso vinculado a disciplina;"
        	        					+ "\nQualquer outro n�mero para sair.");
               				vinculado = seEhVinculado.nextInt();
    	    		
               				break;
    	    		
               			}catch(InputMismatchException e) {// mudar exception **TIPO DE ENTRADA SER V�LIDA (INT)***
    	    			System.out.println("N�mero invalido");
               			}
               		}while(auxiliar==1);
    	        	
			
               		switch (vinculado) {
               			case 0: 
               				disciplina.setCurso("N�cleo livre"); 	   		
               				break;
               			case 1:
               				System.out.println("Digite o curso ao qual essa disciplina est� vinculada: ");
               				disciplina.setCurso(ler.nextLine()); //try catch *****TIPO DE ENTRADA SER V�LIDA********
               				break;
               			default: 	
               				break;
               		}
               		
               		System.out.println("DOCENTES ASSOCIADOS");
               		System.out.println("Insira o nome no docente respons�vel: ");
               		disciplina.setDocenteResponsavel(ler.nextLine());
               		System.out.println("H� docentes auxiliares?"
               				+ "\n1-SIM"
               				+ "\n2-N�O");
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
               					System.out.println("Entrada inv�lida.");
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
