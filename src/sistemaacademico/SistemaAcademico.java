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
       
    	int 			i;
        int 			vinculado = 0;
        int 			auxiliar = 1;
    	int				cargaHorariaMensal;
    	int 			cargaHorariaSemanal;
    	
        Scanner 		ler = new Scanner(System.in);
        
        Disciplina 		disciplina = new Disciplina();
        
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

               		do {
               			System.out.println("\n Digite a sigla de abreviação da disciplina com no máximo três letras:");
               			String nomeAbreviado = ler.nextLine();
               			if(nomeAbreviado.length()>0&nomeAbreviado.length()<4) {
               				disciplina.setNomeAbreviado(nomeAbreviado);
               				break;
               			}
               			else
               				System.out.println("Abreviação Inválida");
               		}while(auxiliar==1);
               		
               		System.out.println("\n Adicione o código da disciplina (máximo de 6 dígitos): ");
               		int codigo = Integer.parseInt(ler.nextLine());
               		disciplina.setCodigo(codigo); //try catch  *****TIPO DE ENTRADA SER VÁLIDA (STRING)*******
		
               		do {
    	    		
               			try {

               				System.out.println("\nCADASTRO DE CURSO VINCULADO A DISCIPLINA:"
        	    						+ "\n0 disciplina de núcleo livre;"
        	    						+ "\n1 adicionar um curso vinculado a disciplina;"
        	        					+ "\nQualquer outro número para sair do cadastro de CURSO.");
               				vinculado = ler.nextInt();
    	    		
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
               				String curso = ler.nextLine();
               				disciplina.setCurso(curso); //try catch *****TIPO DE ENTRADA SER VÁLIDA********
               				break;
               			default: 	
               				break;
               		}
               		
               		System.out.println("DOCENTES ASSOCIADOS");
               		System.out.println("Insira o nome no docente responsável: ");
               		Docente docResponsavel;
               		
               		System.out.println("Há docentes auxiliares?"
               				+ "\n1-SIM"

               				+ "\n2-NÃO");
               		int doc = Integer.parseInt(ler.nextLine()); //**********DEIXAR PASSAR SÓ 1 OU 2***
               		
               		do {
               		
               			switch(doc){
               				case 1:
               					System.out.println("Insira o nome do docente auxiliar");
               					
               					Docente docAuxiliar;
               					break;
               				case 2:
               					break; 
               				
               			}
               		}while(auxiliar==1);
               		
               		System.out.println ("Deseja definir a carga horária mensal ou semanal do curso? "
               				+ "0 para não "
               				+ "1 para carga horária mensal"
               				+ "2 para carga horária semanal" );
               	        int aux = ler.nextInt(); //try... catch para somente inteiros.
               	        
               	        switch (aux) {
               				case 1:	
               					System.out.println("Digite a carga horária mensal para o curso escolhido: ");
               					disciplina.setCargaHorariaMensal(ler.nextInt());
               					break;
               				case 2: 
               					System.out.println("Digite a carga horária semanal para o curso escolhido: ");
               					disciplina.setCargaHorariaSemanal(ler.nextInt());
               					disciplina.setCargaHorariaMensal(disciplina.cargaHorariaSemanal*4);
               					break;
               				case 0:
               					break;
               					}
               	        //adicionar cargaHorariaPratica e cargaHorariaTeorica 
               	        disciplina.cadastrar();
        }		
        
        
  int aleatoria;      

    }




	private static void swicth(int doc) {
		// TODO Auto-generated method stub
		
	}
    
}
