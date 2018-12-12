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
        int vinculado = 0;
        int auxiliar = 1;
       
        Scanner ler = new Scanner(System.in);
        
        Disciplina disciplina = new Disciplina();
        
        Docente docResponsavel = new Docente();
        Docente docAuxiliar = new Docente();
        
        disciplinas = new ArrayList<>();

        System.out.println("Digite um dos seguintes números para acessar: " //try catch ***TIPO DE ENTRADA SER VÁLIDA (INT) E CASO FOR DIFERENTE DE 1,2,3 E 4***
        		+ "\n1 - Cadastrar informações sobre a disciplina."
        		+ "\n2 - Alterar informações sobre a disciplina."
        		+ "\n3 - Excluir a disciplina."
        		+ "\n4 - Consultar uma disciplina.");
        int leitura = ler.nextInt();
		
        switch (leitura) {
        	
        	case 1:	System.out.println("\n\tBEM VINDO AO SISTEMA DE CADASTRAMENTO DE DISCIPLINAS! <3 ");
               		String nomeCompleto = ler.nextLine();
               		disciplina.setNomeCompleto(nomeCompleto);
               		if(checkLetters(nomeCompleto)==false) {
               			do {
               				System.out.println("\n Digite o nome completo da disciplina que deseja cadastrar: \n Obs: Neste campo não é válido o uso de números. ");
               				nomeCompleto = ler.nextLine();
                       		disciplina.setNomeCompleto(nomeCompleto);
                       		if(checkLetters(nomeCompleto)==false) {
                       			System.out.println("Nome inválido.");
                       		}
               			}
               			while(checkLetters(nomeCompleto)==false);
               		}

               		do {
               			System.out.println("\n Digite a sigla de abreviação da disciplina com no máximo três letras:\n Obs: Neste campo é válido o uso de números");
               			String nomeAbreviado = ler.nextLine();
               			if(nomeAbreviado.length()>0&nomeAbreviado.length()<4) {
               				disciplina.setNomeAbreviado(nomeAbreviado);
               				break;
               			}
               			else
               				System.out.println("Abreviação Inválida");
               		}while(auxiliar==1);
               		
               		System.out.println("\n Adicione o código da disciplina (máximo de 4 dígitos): ");
               		int codigo = Integer.parseInt(ler.nextLine());
               		disciplina.setCodigo(codigo); //try catch  *****SÓ ACEITAR NÚMEROS E QUANDO ESTÁ VAZIO*****
		
               		do {
    	    		
               			try {
               				System.out.println("\nCADASTRO DE CURSO VINCULADO A DISCIPLINA:"
        	    						+ "\n0 - Disciplina de núcleo livre;"
        	    						+ "\n1 - Adicionar um curso vinculado a disciplina;"
        	        					+ "\nOutro dado - Sair do cadastro do curso.");
               				vinculado = ler.nextInt(); // resolver quando é dado uma letra*** 	    		
               				break;
    	    		
               			}catch(NumberFormatException erro) {// mudar exception **TIPO DE ENTRADA SER VÁLIDA (INT)***
    	    			System.out.println("Valor invalido. Digite um número inteiro.");
               			}
               		}while(auxiliar==1);
    	        	
			
               		switch (vinculado) {
               			case 0: 
               				disciplina.setCurso("Núcleo livre"); 	   		
               				break;
               			case 1:
               				System.out.println("Digite o curso ao qual essa disciplina está vinculada: ");
               				String curso = ler.nextLine();
               				disciplina.setCurso(curso); //try catch *****TIPO DE ENTRADA SER VÁLIDA********
               				break;
               			default: 	
               				break;
               		}
               		
               		System.out.println("DOCENTES ASSOCIADOS");
               		System.out.println("Insira o nome no docente responsável: ");
               		String nome = ler.nextLine();
               		docResponsavel.setNome(nome);
               		disciplina.setDocenteResponsavel(docResponsavel);
               		
               		
               		System.out.println("Há docentes auxiliares?"
               				+ "\n1-SIM"

               				+ "\n12-NÃO");
               		int doc = Integer.parseInt(ler.nextLine()); //**********DEIXAR PASSAR SÓ 1 OU 2***
               		
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
