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
        int vinculado = 0;
        int auxiliar = 1;
       
        Scanner ler = new Scanner(System.in);
        
        Disciplina disciplina = new Disciplina();
        
        Docente docResponsavel = new Docente();
        Docente docAuxiliar = new Docente();
        
        disciplinas = new ArrayList<>();

        System.out.println("Digite um dos seguintes n�meros para acessar: " //try catch ***TIPO DE ENTRADA SER V�LIDA (INT) E CASO FOR DIFERENTE DE 1,2,3 E 4***
        		+ "\n1 - Cadastrar informa��es sobre a disciplina."
        		+ "\n2 - Alterar informa��es sobre a disciplina."
        		+ "\n3 - Excluir a disciplina."
        		+ "\n4 - Consultar uma disciplina.");
        int leitura = ler.nextInt();
		
        switch (leitura) {
        	
        	case 1:	System.out.println("\n\tBEM VINDO AO SISTEMA DE CADASTRAMENTO DE DISCIPLINAS! <3 ");
               		String nomeCompleto = ler.nextLine();
               		disciplina.setNomeCompleto(nomeCompleto);
               		if(checkLetters(nomeCompleto)==false) {
               			do {
               				System.out.println("\n Digite o nome completo da disciplina que deseja cadastrar: \n Obs: Neste campo n�o � v�lido o uso de n�meros. ");
               				nomeCompleto = ler.nextLine();
                       		disciplina.setNomeCompleto(nomeCompleto);
                       		if(checkLetters(nomeCompleto)==false) {
                       			System.out.println("Nome inv�lido.");
                       		}
               			}
               			while(checkLetters(nomeCompleto)==false);
               		}

               		do {
               			System.out.println("\n Digite a sigla de abrevia��o da disciplina com no m�ximo tr�s letras:\n Obs: Neste campo � v�lido o uso de n�meros");
               			String nomeAbreviado = ler.nextLine();
               			if(nomeAbreviado.length()>0&nomeAbreviado.length()<4) {
               				disciplina.setNomeAbreviado(nomeAbreviado);
               				break;
               			}
               			else
               				System.out.println("Abrevia��o Inv�lida");
               		}while(auxiliar==1);
               		
               		System.out.println("\n Adicione o c�digo da disciplina (m�ximo de 4 d�gitos): ");
               		int codigo = Integer.parseInt(ler.nextLine());
               		disciplina.setCodigo(codigo); //try catch  *****S� ACEITAR N�MEROS E QUANDO EST� VAZIO*****
		
               		do {
    	    		
               			try {
               				System.out.println("\nCADASTRO DE CURSO VINCULADO A DISCIPLINA:"
        	    						+ "\n0 - Disciplina de n�cleo livre;"
        	    						+ "\n1 - Adicionar um curso vinculado a disciplina;"
        	        					+ "\nOutro dado - Sair do cadastro do curso.");
               				vinculado = ler.nextInt(); // resolver quando � dado uma letra*** 	    		
               				break;
    	    		
               			}catch(NumberFormatException erro) {// mudar exception **TIPO DE ENTRADA SER V�LIDA (INT)***
    	    			System.out.println("Valor invalido. Digite um n�mero inteiro.");
               			}
               		}while(auxiliar==1);
    	        	
			
               		switch (vinculado) {
               			case 0: 
               				disciplina.setCurso("N�cleo livre"); 	   		
               				break;
               			case 1:
               				System.out.println("Digite o curso ao qual essa disciplina est� vinculada: ");
               				String curso = ler.nextLine();
               				disciplina.setCurso(curso); //try catch *****TIPO DE ENTRADA SER V�LIDA********
               				break;
               			default: 	
               				break;
               		}
               		
               		System.out.println("DOCENTES ASSOCIADOS");
               		System.out.println("Insira o nome no docente respons�vel: ");
               		String nome = ler.nextLine();
               		docResponsavel.setNome(nome);
               		disciplina.setDocenteResponsavel(docResponsavel);
               		
               		
               		System.out.println("H� docentes auxiliares?"
               				+ "\n1-SIM"

               				+ "\n12-N�O");
               		int doc = Integer.parseInt(ler.nextLine()); //**********DEIXAR PASSAR S� 1 OU 2***
               		
               		do {
               		
               			switch(doc){
               				case 1:
               					System.out.println("Insira o nome do docente auxiliar");
               					String nomeA = ler.nextLine();
               					docAuxiliar.setNome(nomeA);
               					disciplina.setDocenteAuxiliar(docAuxiliar);
               					break;
               				case 2:
               					break; 
               				
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
