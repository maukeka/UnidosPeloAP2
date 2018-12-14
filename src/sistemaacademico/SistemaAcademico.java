/*
 * Sistema de Gest�o Acad�mica 
 */
package sistemaacademico;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Wanderley de Souza Alencar
 */
public class SistemaAcademico {
	
	private static Scanner ler = new Scanner(System.in);
	private static Disciplina disciplina = new Disciplina();
	private static Docente docResponsavel = new Docente();
	private static Docente docAuxiliar = new Docente(); 
	private static TecnicoAdministrativo tecnicoAdministrativoResponsavel = new TecnicoAdministrativo();
	private static TecnicoAdministrativo tecnicoAminAdministrativoAuxiliar = new TecnicoAdministrativo();
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
        			leitura = menu();
        		}
        		catch(Exception e) {// trocar excepion?
        			leitura = menu();
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

	private static int menu() {
		int leitura;
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|                                                                          |");
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACAD�MICO                                 |");
    	System.out.println("|       1 - Cadastrar informa��es sobre a disciplina                       |");
    	System.out.println("|       2 - Alterar informa��es sobre a disciplina                         |");
    	System.out.println("|       3 - Excluir a disciplina                                           |");
    	System.out.println("|       4 - Consultar uma disciplina                                       |");
    	System.out.println("|       5 - Sair do sistema                                                |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" Digite um dos seguintes n�meros para acessar: ");
    	leitura = Integer.parseInt(ler.nextLine());
    	System.out.println("\n\n");
    	return leitura;
	}
	
	private static void cadastrar() {
		String dado;
		System.out.println("Digite o c�digo da disciplina: ");
		dado = ler.nextLine();
		if(validarCodigo(dado)) {
			disciplina.setCodigo(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
		
		System.out.println("Digite o nome completo da disciplina: ");
		dado = ler.nextLine();
		if(validarNome(dado)) {
			disciplina.setNomeCompleto(dado);
		} else {
			System.out.println("Dado inv�lido!");
		}
		System.out.println("Digite o nome abreviado da disciplina: ");
		dado = ler.nextLine();
		if(validarAbreviacao(dado)) {
			disciplina.setNomeAbreviado(dado);
		} else {
			System.out.println("Dado inv�lido!");
		}

		System.out.println("Digite o nome do curso ao qual a disciplina est� vinculada");
		dado = ler.nextLine();
		if(validarCurso(dado)) {
			disciplina.setCurso(dado);
		} else {
			System.out.println("Dado inv�lido!");
		}
			System.out.println("Digite o nome do docente respons�vel pela disciplina: ");
		dado = ler.nextLine();
		if(validarDocenteR(dado)) {
			Docente docente = new Docente();
			docente.setNome(dado);
			disciplina.setDocenteResponsavel(docente);
		} else {
			System.out.println("Dado inv�lido!");
		}
				System.out.println("Digite o nome do docente auxiliar da disciplina: ");
		dado = ler.nextLine();
		if(validarDocenteR(dado)) {
			Docente docente = new Docente();
			docente.setNome(dado);
			disciplina.setDocenteAuxiliar(docente);
		} else {
			System.out.println("Dado inv�lido!");
		}
					System.out.println("Digite o nome do t�cnico administrativo auxiliar da disciplina: ");
		dado = ler.nextLine();
		if(validarTecnico(dado)) {
			TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
			tecnico.setNome(dado);
			disciplina.setTecnicoAminAdministrativoAuxiliar(tecnico);
		} else {
			System.out.println("Dado inv�lido!");
		}
				System.out.println("Digite a situa��o da disciplina: " +// arrumar
								"\n 0 - Desconhecida" +
								"\n 1 - Aberta" +
								"\n 2 - Ativa" +
								"\n 3 - Inativa" +
								"\n 4 - Conclu�da" +
								"\n 5 - Outra");
		dado = ler.nextLine();
		if(validarSituacao(dado)) {
			disciplina.setSituacao(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
				System.out.println("Digite a carga hor�ria pr�tica: ");
		dado = ler.nextLine();
		if(validarCargaHorariaPratica(dado)) {
			disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
				System.out.println("Digite a carga hor�ria te�rica: ");
		dado = ler.nextLine();
		if(validarCargaHorariaTeorica(dado)) {
			disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
				System.out.println("Digite a carga hor�ria semanal: ");
		dado = ler.nextLine();
		if(validarCargaHorariaSemanal(dado)) {
			disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
				System.out.println("Digite a carga hor�ria mensal: ");
		dado = ler.nextLine();
		if(validarCargaHorariaMensal(dado)) {
			disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
					System.out.println("Digite a carga hor�ria total: ");
		dado = ler.nextLine();
		if(validarCargaHorariaTotal(dado)) {
			disciplina.setCargaHorariaTotal(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
					System.out.println("Digite o n�mero de cr�ditos:");
		dado = ler.nextLine();
		if(validarNumCreditos(dado)) {
			disciplina.setNumeroCreditos(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
					System.out.println("Digite o custo pr�tico: ");
		dado = ler.nextLine();
		if(validarCustoPratica(dado)) {
			disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
				System.out.println("Digite o custo te�rico: ");
		dado = ler.nextLine();
		if(validarCustoTeorica(dado)) {
			disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
					System.out.println("Digite o custo fixo: ");
		dado = ler.nextLine();
		if(validarCustoFixo(dado)) {
			disciplina.setCustoFixo(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inv�lido!");
		}
					System.out.println("Digite o nome do t�cnico administrativo respons�vel da disciplina:");
		dado = ler.nextLine();
		if(validarTecnico(dado)) {
			TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
			tecnico.setNome(dado);
			disciplina.setTecnicoAdministrativoResponsavel(tecnico);
		} else {
			System.out.println("Dado inv�lido!");
		}
		disciplinaDAO.cadastrar(disciplina);
	}
	
	private static boolean validarCodigo(String dado) {
		return true;
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
			System.out.println("Digite o c�digo da disciplina a ser alterada: ");
			chave = ler.nextLine();
			for(Disciplina disciplina : disciplinas) {
				if(disciplina.getCodigo() == Integer.parseInt(chave)) {
					Disciplina disciplinaAlterada = alterarDados(disciplina);
					disciplinaDAO.alterar(disciplinaAlterada);	
				}
			}
			
			break;
		case 2:
			System.out.println("Digite o c�digo da disciplina a ser alterada: ");
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
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACAD�MICO                                 |");
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
    	System.out.println("|                                                                          |");
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACAD�MICO                                 |");
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
				System.out.println("|                                                                          ");
				System.out.println("|" + "Nome Completo.........................: " + disciplina.getNomeCompleto());
				System.out.println("|" + "Nome Abreviado........................: " + disciplina.getNomeAbreviado());
				System.out.println("|" + "C�digo................................: " + disciplina.getCodigo());
				System.out.println("|" + "Curso.................................: " + disciplina.getCurso());
				System.out.println("|" + "Docente Respons�vel...................: " + disciplina.getDocenteResponsavel().getNome());
				System.out.println("|" + "Docente Auxiliar......................: " + disciplina.getDocenteAuxiliar().getNome());
				System.out.println("|" + "T�cnico Administrativo Respons�vel....: " + disciplina.getTecnicoAdministrativoResponsavel().getNome());
				System.out.println("|" + "T�cnico AminAdministrativo Auxiliar...: " + disciplina.getTecnicoAminAdministrativoAuxiliar().getNome());
				System.out.println("|" + "Situa��o..............................: " + disciplina.getSituacao());
				System.out.println("|" + "Carga Hor�ria Pr�tica.................: " + disciplina.getCargaHorariaPratica());
				System.out.println("|" + "Carga Hor�ria Te�rica.................: " + disciplina.getCargaHorariaTeorica());
				System.out.println("|" + "Carga Hor�ria Semanal.................: " + disciplina.getCargaHorariaSemanal());
				System.out.println("|" + "Carga Hor�ria Mensal..................: " + disciplina.getCargaHorariaMensal());
				System.out.println("|" + "Carga Hor�ria Total...................: " + disciplina.getCargaHorariaTotal());
				System.out.println("|" + "N�mero de Cr�ditos....................: " + disciplina.getNumeroCreditos());
				System.out.println("|" + "Custo B�sico Pr�tica..................: " + disciplina.getCustoBasicoPratica());
				System.out.println("|" + "Custo B�sico Te�rica..................: " + disciplina.getCustoBasicoTeorica());
				System.out.println("|" + "Custo Fixo............................: " + disciplina.getCustoFixo());
				System.out.println("|__________________________________________________________________________.");
			}
		} else {
			System.out.println("Nenhuma disciplina foi encontrada com os par�metros informados");
		}
	}
	
	private static void menuAlterar() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACAD�MICO                                 |");
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
			System.out.println("Digite o nome completo da disciplina: ");
			dado = ler.nextLine();
			if(validarNome(dado)) {
				disciplina.setNomeCompleto(dado);
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 2 :
			System.out.println("Digite o nome abreviado da disciplina: ");
			dado = ler.nextLine();
			if(validarAbreviacao(dado)) {
				disciplina.setNomeAbreviado(dado);
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 3 :
			System.out.println("Digite o nome do curso que a disciplina est� vinculada");
			dado = ler.nextLine();
			if(validarCurso(dado)) {
				disciplina.setCurso(dado);
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 4 :
			System.out.println("Digite o nome do docente respons�vel pela disciplina: ");
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteResponsavel(docente);
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 5 :
			System.out.println("Digite o nome do docente auxiliar da disciplina: ");
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteAuxiliar(docente);
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 6 :
			System.out.println("Digite o nome do t�cnico administrativo auxiliar da disciplina: ");
			dado = ler.nextLine();
			if(validarTecnico(dado)) {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAminAdministrativoAuxiliar(tecnico);
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 7 :
			System.out.println("Digite a situa��o da disciplina: " +
									"\n 0 - Desconhecida" +
									"\n 1 - Aberta" +
									"\n 2 - Ativa" +
									"\n 3 - Inativa" +
									"\n 4 - Conclu�da" +
									"\n 5 - Outra");
			dado = ler.nextLine();
			if(validarSituacao(dado)) {
				disciplina.setSituacao(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 8 :
			System.out.println("Digite a carga hor�ria pr�tica: ");
			dado = ler.nextLine();
			if(validarCargaHorariaPratica(dado)) {
				disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 9 :
			System.out.println("Digite a carga hor�ria te�rica: ");
			dado = ler.nextLine();
			if(validarCargaHorariaTeorica(dado)) {
				disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 10 :
			System.out.println("Digite a carga hor�ria semanal: ");
			dado = ler.nextLine();
			if(validarCargaHorariaSemanal(dado)) {
				disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 11 :
			System.out.println("Digite a carga hor�ria mensal: ");
			dado = ler.nextLine();
			if(validarCargaHorariaMensal(dado)) {
				disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 12 :
			System.out.println("Digite a carga hor�ria total: ");
			dado = ler.nextLine();
			if(validarCargaHorariaTotal(dado)) {
				disciplina.setCargaHorariaTotal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 13 :
			System.out.println("Digite o n�mero de cr�ditos:");
			dado = ler.nextLine();
			if(validarNumCreditos(dado)) {
				disciplina.setNumeroCreditos(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 14 :
			System.out.println("Digite o custo pr�tico: ");
			dado = ler.nextLine();
			if(validarCustoPratica(dado)) {
				disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 15 :
			System.out.println("Digite o custo te�rico: ");
			dado = ler.nextLine();
			if(validarCustoTeorica(dado)) {
				disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 16 :
			System.out.println("Digite o custo fixo: ");
			dado = ler.nextLine();
			if(validarCustoFixo(dado)) {
				disciplina.setCustoFixo(Integer.parseInt(dado));
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		case 17 :
			System.out.println("Digite o nome do t�cnico administrativo respons�vel da disciplina:");
			dado = ler.nextLine();
			if(validarTecnico(dado)) {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAdministrativoResponsavel(tecnico);
			} else {
				System.out.println("Dado n�o alterado, pois o par�metro passado � inv�lido!");
			}
			break;
		}
		return disciplina;
	}
	
	private static boolean validarCustoFixo(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarCustoTeorica(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarCustoPratica(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarNumCreditos(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarCargaHorariaTotal(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarCargaHorariaMensal(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarCargaHorariaSemanal(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarCargaHorariaTeorica(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarCargaHorariaPratica(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarSituacao(String dado) {
		return Integer.parseInt(dado)>0 && Integer.parseInt(dado)<6;
	}

	private static boolean validarTecnico(String dado) {
		return dado.matches("[a-zA-Z\\u0020]+") && !dado.equals(null) && !dado.equals(" ");
	}

	private static boolean validarDocenteR(String dado) {
		return dado.matches("[a-zA-Z\\u0020]+") && !dado.equals(null) && !dado.equals(" ");
	}

	private static boolean validarCurso(String dado) {
		return dado.matches("[a-zA-Z\\u0020]+") && !dado.equals(null) && !dado.equals(" ");
	}

	private static boolean validarAbreviacao(String dado) {
		return dado.matches("[a-zA-Z\\u0020]+") && !dado.equals(null) && !dado.equals(" ") && dado.length()<4;
	}

	private static boolean validarNome(String dado) {
		return dado.matches("[a-zA-Z\\u0020]+") && !dado.equals(null) && !dado.equals(" ");
	}

	private static void menuOpcaoAlterar() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACAD�MICO                                 |");
    	System.out.println("|        1 - Alterar Nome Completo                                         |");
    	System.out.println("|        2 - Alterar Nome Abreviado                                        |");
    	System.out.println("|        3 - Alterar Curso                                                 |"); //Alterar o resto
    	System.out.println("|        4 - Alterar Docente Respons�vel                                   |");
    	System.out.println("|        5 - Alterar Docente Auxiliar                                      |");
    	System.out.println("|        6 - Alterar T�cnico Administrativo Auxiliar                       |");
    	System.out.println("|        7 - Alterar Situa��o                                              |");
    	System.out.println("|        8 - Alterar Carga Hor�ria Pr�tica                                 |");
    	System.out.println("|        9 - Alterar Carga Hor�ria Te�rica                                 |");
    	System.out.println("|       10 - Alterar Carga Hor�ria Semanal                                 |");
    	System.out.println("|       11 - Alterar Carga Hor�ria Mensal                                  |");
    	System.out.println("|       12 - Alterar Carga Hor�ria Total                                   |");
    	System.out.println("|       13 - Alterar N�mero de Cr�ditos                                    |");
    	System.out.println("|       14 - Alterar Custo B�sico Pr�tica                                  |");
    	System.out.println("|       15 - Alterar Custo B�sico Te�rica                                  |");
    	System.out.println("|       16 - Alterar Custo Fixo                                            |");
    	System.out.println("|       17 - Alterar T�cnico Administrativo Respons�vel                    |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" Digite um dos seguintes n�meros para acessar: ");
	}
	
}
