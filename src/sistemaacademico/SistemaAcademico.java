/*
 * Sistema de Gest�o Acad�mica 
 */
package sistemaacademico; // hey brother
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Wanderley de Souza Alencar
 */
public class SistemaAcademico {
	
	private static Scanner ler;
	private static Disciplina disciplina;
	private static Docente docResponsavel;
	private static Docente docAuxiliar; 
	private static TecnicoAdministrativo tecnicoAdministrativoResponsavel;
	private static TecnicoAdministrativo tecnicoAminAdministrativoAuxiliar;
	private static Disciplinas disciplinaDAO = new Disciplinas();
          
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
        

        int leitura;
        do {
        	do {
        		try {
        			menu();
        			leitura = Integer.parseInt(ler.nextLine());
        		} catch(NumberFormatException e) {
        			menu();
        			leitura = Integer.parseInt(ler.nextLine());
        		}
        		catch(Exception e) {
        			menu();
        			leitura = Integer.parseInt(ler.nextLine());
        		}
        	}while(leitura>5 || leitura<1);

        	switch (leitura) {
        	case 1:
        		cadastrar();
        		break;
        	case 2:
        		alterar();
        		break;
        	case 3:
        		excluir();
        		break;
        	case 4:
        		consultar();
        		break;
        	case 5:
        		System.out.println("Obrigado por usar nosso software.");
        		break;
        	}
        }while(leitura != 5);
        System.exit(0);
    }

	private static void menu() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Cadastrar informa��es sobre a disciplina                       |");
    	System.out.println("|       2 - Alterar informa��es sobre a disciplina                         |");
    	System.out.println("|       3 - Excluir a disciplina                                           |");
    	System.out.println("|       4 - Consultar uma disciplina                                       |");
    	System.out.println("|       5 - Sair do sistema                                                |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" Digite um dos seguintes n�meros para acessar: ");
	}
	
	private static void cadastrar() {
		
	}
	
	private static void alterar() {
		ler = new Scanner(System.in);
		int leitura;
		List<Disciplina> disciplinas;
		String chave = null;
		do {
    		try {
    			menuAlterar();
    			leitura = Integer.parseInt(ler.nextLine());
    		} catch(NumberFormatException e) {
    			menuAlterar();
    			leitura = Integer.parseInt(ler.nextLine());
    		}
    		catch(Exception e) {
    			menuAlterar();
    			leitura = Integer.parseInt(ler.nextLine());
    		}
    	}while(leitura>3 || leitura<1);
		
		switch(leitura) {
		case 1: 
			disciplinas = disciplinaDAO.consultar("todos", null);
			exibirDados(disciplinas);
			System.out.println("Digite o c�digo da disciplina a ser alterado: ");
			chave = ler.nextLine();
			for(Disciplina disciplina : disciplinas) {
				if(disciplina.getCodigo() == Integer.parseInt(chave)) {
					Disciplina disciplinaAlterada = alterarDados(disciplina);
					disciplinaDAO.alterar(disciplinaAlterada);	
				}
			}
			
			break;
		case 2:
			System.out.println("Digite o c�digo da disciplina a ser alterado: ");
			chave = ler.nextLine(); //try...catch
			disciplinas = disciplinaDAO.consultar(chave, null);
			if(disciplinas.size() == 1) {
				Disciplina disciplinaAlterada = alterarDados(disciplinas.get(0));
				disciplinaDAO.alterar(disciplinaAlterada);
			}
			
			break;
		}
	}
	
	private static void excluir() {
		ler = new Scanner(System.in);
		int leitura;
		List<Disciplina> disciplinas;
		int chave;
		do {
    		try {
    			menuExcluir();
    			leitura = Integer.parseInt(ler.nextLine());
    		} catch(NumberFormatException e) {
    			menuExcluir();
    			leitura = Integer.parseInt(ler.nextLine());
    		}
    		catch(Exception e) {
    			menuExcluir();
    			leitura = Integer.parseInt(ler.nextLine());
    		}
    	}while(leitura>3 || leitura<1);
		
		switch(leitura) {
		case 1: 
			disciplinas = disciplinaDAO.consultar("todos", null);
			exibirDados(disciplinas);
			System.out.println("Digite o c�digo da disciplina a ser exclu�da: ");
			chave = Integer.parseInt(ler.nextLine());
			disciplinaDAO.excluir(chave);
			break;
		case 2:
			System.out.println("Digite o c�digo da disciplina a ser exclu�da: ");
			chave = Integer.parseInt(ler.nextLine()); //try...catch
			disciplinaDAO.excluir(chave);
			break;
		}
	}
	
	private static void menuExcluir() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Listar todas as diciplinas antes de excluir                    |");
    	System.out.println("|       2 - Excluir                                                        |");
    	System.out.println("|       3 - Sair                                                           |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" Digite um dos seguintes n�meros para acessar: ");
	}
	
	private static void consultar() {
		ler = new Scanner(System.in);
		int leitura;
		List<Disciplina> disciplinas;
		String chave;
		
		do {
    		try {
    			menuConsultar();
    			leitura = Integer.parseInt(ler.nextLine());
    		} catch(NumberFormatException e) {
    			menuConsultar();
    			leitura = Integer.parseInt(ler.nextLine());
    		}
    		catch(Exception e) {
    			menuConsultar();
    			leitura = Integer.parseInt(ler.nextLine());
    		}
    	}while(leitura>5 || leitura<1);

    	switch (leitura) {
    	case 1:
    		disciplinas = disciplinaDAO.consultar("todos", null);
    		exibirDados(disciplinas);
    		break;
    	case 2:
    		System.out.printf("Digite o c�digo da disciplina: ");
    		chave = ler.nextLine();
    		System.out.println();
    		disciplinas = disciplinaDAO.consultar("codigo", chave);
    		exibirDados(disciplinas);
    		break;
    	case 3:
    		System.out.printf("Digite o nome completo da disciplina: ");
    		chave = ler.nextLine();
    		System.out.println();
    		disciplinas = disciplinaDAO.consultar("nome completo", chave);
    		exibirDados(disciplinas);
    		break;
    	case 4:
    		System.out.printf("Digite o nome abreviado da disciplina: ");
    		chave = ler.nextLine();
    		System.out.println();
    		disciplinas = disciplinaDAO.consultar("nome abreviado", chave);
    		exibirDados(disciplinas);
    		break;
    	case 5:
    		System.out.println("");
    		break;
    	}
	}
    
	private static void menuConsultar() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Consultar todas                                                |");
    	System.out.println("|       2 - Consultar disciplina atrav�s do c�digo                         |");
    	System.out.println("|       3 - Consultar disciplina pelo nome completo                        |");
    	System.out.println("|       4 - Consultar disciplina pelo nome abreviado                       |");
    	System.out.println("|       5 - Sair                                                           |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" Digite um dos seguintes n�meros para acessar: ");
	}
	
	private static void exibirDados(List<Disciplina> disciplinas) {
		if(!disciplinas.equals(null)) {
			for(Disciplina disciplina : disciplinas) {
				System.out.println(".__________________________________________________________________________.");
				System.out.println("|" + "Nome Completo.........................: " + disciplina.getNomeCompleto());
				System.out.println("|" + "Nome Abreviado........................: " + "" + disciplina.getNomeAbreviado());
				System.out.println("|" + "C�digo................................: " + disciplina.getCodigo());
				System.out.println("|" + "Curso.................................: " + disciplina.getCurso());
				System.out.println("|" + "Docente Respons�vel...................: " + disciplina.getDocenteResponsavel());
				System.out.println("|" + "Docente Auxiliar......................: " + disciplina.getDocenteAuxiliar());
				System.out.println("|" + "T�cnico Administrativo Respons�vel....: " + disciplina.getTecnicoAdministrativoResponsavel());
				System.out.println("|" + "T�cnico AminAdministrativo Auxiliar...: " + disciplina.getTecnicoAminAdministrativoAuxiliar());
				System.out.println("|" + "Situa��o..............................: " + disciplina.getSituacao());
				System.out.println("|" + "Carga Hor�ria Pr�tica.................: " + disciplina.getCargaHorariaPratica());
				System.out.println("|" + "Carga Hor�ria Te�rica.................: " + disciplina.getCargaHorariaTeorica());
				System.out.println("|" + "Carga Horaria Semanal.................: " + disciplina.getCargaHorariaSemanal());
				System.out.println("|" + "Carga Horaria Mensal" + disciplina.getCargaHorariaMensal());
				System.out.println("|" + "CargaHorariaTotal" + disciplina.getCargaHorariaTotal());
				System.out.println("|" + "NumeroCreditos" + disciplina.getNumeroCreditos());
				System.out.println("|" + "CustoBasicoPratica" + disciplina.getCustoBasicoPratica());
				System.out.println("|" + "CustoBasicoTeorica" + disciplina.getCustoBasicoTeorica());
				System.out.println("|" + "CustoFixo" + disciplina.getCustoFixo());
				System.out.println("");
			}
		} else {
			System.out.println("Nenhuma disciplina cencontrada com os par�metros informados");
		}
	}
	
	private static void menuAlterar() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Listar todas as diciplinas antes de alterar                    |");
    	System.out.println("|       2 - Alterar                                                        |");
    	System.out.println("|       3 - Sair                                                           |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" Digite um dos seguintes n�meros para acessar: ");
	}
	
	private static Disciplina alterarDados(Disciplina disciplina) {
		menuOpcaoAlterar();
		String dado;
		int leitura = Integer.parseInt(ler.nextLine());
		switch(leitura) {
		case 1 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setNomeCompleto(dado);
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 2 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setNomeAbreviado(dado);
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 3 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCurso(dado);
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 4 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteResponsavel(docente);
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 5 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteAuxiliar(docente);
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 6 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAminAdministrativoAuxiliar(tecnico);
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 7 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setSituacao(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 8 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 9 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 10 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 11 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 12 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCargaHorariaTotal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 13 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setNumeroCreditos(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 14 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 15 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 16 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				disciplina.setCustoFixo(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		case 17 :
			System.out.println("");
			dado = ler.nextLine();
			if() {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAdministrativoResponsavel(tecnico);
			} else {
				System.out.println("Dado n�o alterado, pois o paramentro passado � invalido!");
			}
			break;
		}
		return disciplina;
	}
	
	private static void menuOpcaoAlterar() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|        1 - Alterar nome completo                                         |");
    	System.out.println("|        2 - Alterar nome abreviado                                        |");
    	System.out.println("|        3 - Alterar Curso                                                 |"); //Alterar o resto
    	System.out.println("|        4 - Alterar Docente Respons�vel                                   |");
    	System.out.println("|        5 - Alterar Docente Auxiliar                                      |");
    	System.out.println("|        6 - Alterar T�cnico AminAdministrativo Auxiliar                   |");
    	System.out.println("|        7 - Alterar Situa��o                                              |");
    	System.out.println("|        8 - Alterar Carga Hor�ria Pr�tica                                 |");
    	System.out.println("|        9 - Alterar Carga Hor�ria Te�rica                                 |");
    	System.out.println("|       10 - Alterar Carga Horaria Semanal                                 |");
    	System.out.println("|       11 - Alterar Carga Horaria Mensal                                  |");
    	System.out.println("|       12 - Alterar Carga Horaria Total                                   |");
    	System.out.println("|       13 - Alterar Numero Creditos                                       |");
    	System.out.println("|       14 - Alterar Custo Basico Pratica                                  |");
    	System.out.println("|       15 - Alterar Custo Basico Teorica                                  |");
    	System.out.println("|       16 - Alterar Custo Fixo                                            |");
    	System.out.println("|       17 - Alterar T�cnico Administrativo Respons�vel                    |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" Digite um dos seguintes n�meros para acessar: ");
	}
	
}
