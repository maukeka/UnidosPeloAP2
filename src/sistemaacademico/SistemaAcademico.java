/*
 * Sistema de Gest�o Acad�mica 
 */
package sistemaacademico; // hey brother
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
        int doc = 0;
        int tec = 0;
        int tecA = 0;
        Scanner ler = new Scanner(System.in);
        
        Disciplina disciplina = new Disciplina();
        
        Docente docResponsavel = new Docente();
        Docente docAuxiliar = new Docente();
        
        TecnicoAdministrativo tecnicoAdministrativoResponsavel = new TecnicoAdministrativo();
        TecnicoAdministrativo tecnicoAminAdministrativoAuxiliar = new TecnicoAdministrativo();
        
        disciplinas = new ArrayList<>();
        int leitura;
        do {
        System.out.println("Digite um dos seguintes n�meros para acessar: " //try catch ***SOMENTE N�MERO***Tonim***
        		+ "\n1 - Cadastrar informa��es sobre a disciplina."
        		+ "\n2 - Alterar informa��es sobre a disciplina."
        		+ "\n3 - Excluir a disciplina."
        		+ "\n4 - Consultar uma disciplina.");
        leitura = ler.nextInt();
        }while(leitura>4 || leitura<1);
		
        switch (leitura) {
        	
        	case 1:	System.out.println("\n\tBEM VINDO AO SISTEMA DE CADASTRAMENTO DE DISCIPLINAS! <3 ");
               		String nomeCompleto = ler.nextLine();
               		disciplina.setNomeCompleto(nomeCompleto.toUpperCase());
               		if(checkLetters(nomeCompleto)==false) {
               			do {
               				System.out.println("\n Digite o nome completo da disciplina que deseja cadastrar: \n Obs: Neste campo n�o � v�lido o uso de n�meros.");
               				nomeCompleto = ler.nextLine();
                       		disciplina.setNomeCompleto(nomeCompleto.toUpperCase());
                       		if(checkLetters(nomeCompleto)==false) {
                       			System.out.println("Nome inv�lido. ");
                       		}
               			}
               			while(checkLetters(nomeCompleto)==false);
               		}

               		do {
               			System.out.println("\n Digite a sigla de abrevia��o da disciplina com no m�ximo tr�s letras:\n Obs: Neste campo � v�lido o uso de n�meros");
               			String nomeAbreviado = ler.nextLine();
               			if(nomeAbreviado.length()>0&nomeAbreviado.length()<4) {
               				disciplina.setNomeAbreviado(nomeAbreviado.toUpperCase());
               				break;
               			}
               			else
               				System.out.println("Abrevia��o Inv�lida");
               		}while(auxiliar==1);
               		
               		do{
               			System.out.println("\n Adicione o c�digo da disciplina (4 d�gitos): ");
               			String codigo = ler.nextLine();
               			
               			if(codigo.length()==4) {
               				try{
               					int codigo2 = Integer.parseInt(codigo);
               					disciplina.setCodigo(codigo2);
               					break;
               				}catch(NumberFormatException erro) {
               					System.out.println("\tN�o insira letras apenas n�meros!");
               				}
               				
               			}
               			else
               				System.out.println("\tQuantidade Incorreta!");
               			
               		}while(auxiliar==1);
               				
               		do {
    	    		               			
               				System.out.println("\nCADASTRO DE CURSO VINCULADO A DISCIPLINA:"
        	    						+ "\n0 - Disciplina de n�cleo livre;"
        	    						+ "\n1 - Adicionar um curso vinculado a disciplina;"
        	        					+ "\nOutro n�mero - Sair do cadastro do curso.");
               				try {
               					
               					 vinculado = Integer.parseInt(ler.nextLine()); //     		
               					 break;
    	    		
               			}catch(NumberFormatException erro) {
    	    			System.out.println("Valor inv�lido. Digite um n�mero inteiro.");
               			}
               		}while(auxiliar==1);
    	        	
			
               		switch (vinculado) {
               			case 0: 
               				disciplina.setCurso("N�CLEO LIVRE"); 	   		
               				break;
               			case 1:
               				System.out.println("Digite o curso ao qual essa disciplina est� vinculada: ");
               				String curso = ler.nextLine();
               				disciplina.setCurso(curso.toUpperCase()); //try catch *****SOMENTE LETRAS********
               				break;
               			default: 	
               				break;
               		}
               		
               		System.out.println("DOCENTES ASSOCIADOS");
               		System.out.println("Insira o nome no docente respons�vel: "); //N�O ACEITAR O VAZIO E COLOCAR SOMENTE LETRAS
               		String nome = ler.nextLine();
               		docResponsavel.setNome(nome.toUpperCase());
               		disciplina.setDocenteResponsavel(docResponsavel);
               		
               		do {
               		System.out.println("H� docentes auxiliares?"
               				+ "\n1-SIM"

               				+ "\n2-N�O");
               		try {
               			 doc = Integer.parseInt(ler.nextLine()); 
               			 
               		}catch(NumberFormatException erro) {
       					System.out.println("\nN�o insira letras apenas n�meros!");
       				}
               		}while(doc<1||doc>2);
               		
               		do {
               		
               			switch(doc){
               				case 1:
               					System.out.println("Insira o nome do docente auxiliar");
               					String nomeA = ler.nextLine();
               					docAuxiliar.setNome(nomeA.toUpperCase());
               					disciplina.setDocenteAuxiliar(docAuxiliar);
               					auxiliar=2;
               					break;
               				case 2:
               					auxiliar=2;
               					break; 
               				
               			}
               		              		       	
               		}while(auxiliar==1);
               		
               		System.out.println("T�CNICOS ADMINISTRATIVOS");
               		
               		do {
               		System.out.println("H� um t�cnico respons�vel?"
               				+ "\n1-SIM"

               				+ "\n2-N�O");
               		try {
               				tec = Integer.parseInt(ler.nextLine());}catch(NumberFormatException erro) {
               					System.out.println("\nN�o insira letras apenas n�meros!");}
               		}while(tec<1||tec>2);
               		do {
               		
               			switch(tec){
               				case 1:
               					System.out.println("Insira o nome do t�cnico respons�vel");
               					String nomeT = ler.nextLine();
               					tecnicoAdministrativoResponsavel.setNome(nomeT.toUpperCase());
               					disciplina.setTecnicoAdministrativoResponsavel(tecnicoAdministrativoResponsavel);
               					auxiliar=2;
               					break;
               				case 2:
               					break; 
               					}
               		}while(auxiliar==1);
               		
               		do {
               		System.out.println("H� um t�cnico auxiliar?"
               				+ "\n1-SIM"

               				+ "\n2-N�O");

               		try {
               		 tecA = Integer.parseInt(ler.nextLine());
               		 }catch(NumberFormatException erro) {
        					System.out.println("\nN�o insira letras apenas n�meros!");}
               		
               		

               		//******SOMENTE N�MEROS****
               		}while(tecA<1||tecA>2);

               		do {
               		
               			switch(tecA){
               				case 1:
               					System.out.println("Insira o nome do t�cnico auxiliar");
               					String nomeTA = ler.nextLine();
               					tecnicoAdministrativoResponsavel.setNome(nomeTA.toUpperCase());
               					disciplina.setTecnicoAminAdministrativoAuxiliar(tecnicoAminAdministrativoAuxiliar);
               					auxiliar=2;
               					break;
               				case 2:
               					break; 
               					}
               		}while(auxiliar==1);
               		
               		System.out.println("N�MERO DE CR�DITOS");
               		
               		
               		do{
               			System.out.println("Insira o n�mero de cr�ditos associado � disciplina variando de 0 � 9");
               				
               			String creditos = ler.nextLine();
               			
               			if(creditos.length()==1) {
               				try{
               					int creditos2 = Integer.parseInt(creditos);
               					disciplina.setNumeroCreditos(creditos2);
               					break;
               				}catch(NumberFormatException erro) {
               					System.out.println("\tN�o insira letras apenas n�meros!");
               				}
               				
               			}
               			else
               				System.out.println("\tQuantidade Incorreta!");
               			
               		}while(auxiliar==1);
               		
               	}
        }
               		        
        SituacaoDisciplina situacaoDisciplina = new SituacaoDisciplina();
        for (int x=0; x < situacaoDisciplina.size(); x++) {
        	situacaoDisciplina.show(x);
        }
        
      
        
        
        
        
        
        ///for (i = 0; (i < unidadesFederativas.size()); i++) {
       //     unidadesFederativas.show(i);
       // }
       // System.out.println("Fim");
    }




	private static void swicth(int doc) {
		// TODO Auto-generated method 
		
	}
    
}
