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
 * @author Wanderley de Souza Alencar                // DON'T LET ME DOWN
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
        
        int leitura = -1;
        do {
        	do {
        		try {
        			leitura = menu();
        		}
        		catch(Exception e) {// trocar exception?
        			
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
        		System.out.println("\tObrigado por usar nosso software.");
        		break;
        	}
        }while(leitura != 5);
        System.exit(0);
    }

	private static int menu() {
		int leitura;
		System.out.println("\n.__________________________________________________________________________.");
    	System.out.println("|                                                                          |");
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Cadastrar informa��es sobre a disciplina                       |");
    	System.out.println("|       2 - Alterar informa��es sobre a disciplina                         |");
    	System.out.println("|       3 - Excluir a disciplina                                           |");
    	System.out.println("|       4 - Consultar uma disciplina                                       |");
    	System.out.println("|       5 - Sair do sistema                                                |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf("\n\tDigite um dos seguintes n�meros para acessar: ");
    	leitura = Integer.parseInt(ler.nextLine());
    	System.out.println("\n");
    	return leitura;
	}
	
	private static void cadastrar() {
		String dado;	
		do {
			System.out.println("\t1- Digite o c�digo da disciplina: "
					+ "\n\t  OBS: Deve ser formado apenas por quatro n�meros.");
			dado = ler.nextLine();
			if(validarCodigo(dado)) {
				disciplina.setCodigo(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado inv�lido!\n");	
			}
		}while(validarCodigo(dado)==false);
		System.out.println("\n\t2- Digite o nome completo da disciplina: "); 
		dado = ler.nextLine();
		if(validarNome(dado)==true) {
			disciplina.setNomeCompleto(dado);
		} 
		else {
			do {
			System.out.println("\tDado inv�lido!\n");
			System.out.println("\t2- Digite o nome completo da disciplina: "); 
			dado = ler.nextLine();
			validarNome(dado);
			}while(validarNome(dado)==false);
			disciplina.setNomeCompleto(dado);
		}
		System.out.println("\n\t3- Digite o nome abreviado da disciplina: "
				+ "\n\t  OBS: Deve possuir no m�ximo tr�s caracteres com pelo menos um caracter seja uma letra."); 
		dado = ler.nextLine();
		if(validarAbreviacao(dado)==true) {
			disciplina.setNomeAbreviado(dado);
		} else {
			do {
				System.out.println("\tDado inv�lido!\n");
				System.out.println("\t3- Digite o nome abreviado da disciplina: "
						+ "\n\t  OBS: Deve possuir no m�ximo tr�s caracteres com pelo menos um caracter seja uma letra.");
						dado = ler.nextLine();
						validarAbreviacao(dado);
			}while(validarAbreviacao(dado)==false);
			disciplina.setNomeAbreviado(dado);
		}
		System.out.println("");
		
		int auxiliar = 1;
		do {
			menuCurso();
			dado = ler.nextLine();
			
			switch(dado)
			{
				case "1":
					System.out.println("\n\n\t4- Curso de n�cleo livre!\n");
					disciplina.setCurso("\tN�CLEO LIVRE");
					auxiliar = 2;
					break;
				case "2":
					int help = 1;
					do {
						System.out.println("\n\t4- Insira o nome do curso:");
							dado = ler.nextLine();
						if(validarCurso(dado)) {
							disciplina.setCurso(dado);
							help = 2;
							break;
						}
						else
							System.out.println("\tDado inv�lido. N�meros n�o s�o permitidos!");
							help = 1;
					}while(help == 1);
					
					
				case "3":
					disciplina.setCurso("\tN�O H�");
					auxiliar = 2;
					break;
				default:
					System.out.println("\tDado inv�lido!\n");
					break;
			}
		}while( auxiliar  == 1);
		System.out.println("");
		
		do{
			System.out.println("\t5- Digite o nome do docente respons�vel pela disciplina: "

					+ "\n\t  OBS: Deve possuir somente letras."); //Somente Letras
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteResponsavel(docente);
				auxiliar = 2;
				break;
			} else {
				System.out.println("\tDado inv�lido!\n");
				auxiliar = 1;

			}
		}while( auxiliar == 1);
		
		System.out.print("\n");
		System.out.print("\t\t DOCENTE AUXILIAR");
		System.out.print("\n\n");
		
		do {
			menuOpcao();
			dado = ler.nextLine();
			
			switch (dado) {
			case "1": 
				int help = 1;
				do {
					System.out.println("\n\t6- Digite o nome do docente auxiliar da disciplina: "
							+ "\n\t  OBS: Deve possuir somente letras.");
						dado = ler.nextLine();
					if(validarDocenteR(dado)) {
						Docente docente = new Docente();
						docente.setNome(dado);
						disciplina.setDocenteAuxiliar(docente);
						help = 2;
						break;
					}
					else
						System.out.println("\tDado inv�lido. N�meros n�o s�o permitidos!\n");
						help = 1;
				}while(help == 1);
				 //Somente Letras e colocar menu para selecionar o desejo
				break;
			case "2": 
				Docente docente = new Docente();
				docente.setNome("\tN�o h� docente auxiliar");
				disciplina.setDocenteAuxiliar(docente);
				auxiliar = 2;
				break;
			default:
				System.out.println("\tDado inv�lido!\n");
				auxiliar = 1;
			}
		}while(auxiliar == 1);
		
		System.out.print("\n");
		System.out.println("\t\t T�CNICO ADMINISTRATIVO RESPONS�VEL");
		System.out.print("\n\n");
		
		do {	
				menuOpcao();
				dado = ler.nextLine();
			

			switch (dado) {
			case "1": 
				int help = 1;
				do {
					System.out.println("\n\t7- Digite o nome do t�cnico administrativo  respons�vel pela disciplina: "
							+ "\n\t  OBS: Deve possuir somente letras.");
						dado = ler.nextLine();
					if(validarTecnico(dado)) {
						TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo();
						tecnicoAdministrativo.setNome(dado);
						disciplina.setTecnicoAdministrativoResponsavel(tecnicoAdministrativo);
						help = 2;
						break;
					}
					else
						System.out.println("\tDado inv�lido. N�meros n�o s�o permitidos!\n");
						help = 1;
				}while(help == 1);
				break;
			case "2": 
				TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo();
				tecnicoAdministrativo.setNome("\tN�o h� t�cnico administrativo auxiliar");
				disciplina.setTecnicoAdministrativoResponsavel(tecnicoAdministrativo);
				auxiliar = 2;
				break;
			default:
				System.out.println("\tDado inv�lido!\n");
				auxiliar = 1;
			}
		}while(auxiliar == 1);
		
		System.out.print("\n");
		System.out.println("\t\t T�CNICO ADMINISTRATIVO AUXILIAR");
		System.out.print("\n\n");
		
		menuOpcao();
		do {
			
			dado = ler.nextLine();

			switch (dado) {
			case "1":
				int help = 1;
			do {
				System.out.println("\n\t8- Digite o nome do t�cnico administrativo auxiliar da disciplina: "
						+ "\n\t  OBS: Deve possuir somente letras.");
					dado = ler.nextLine();
				if(validarTecnico(dado)) {
					TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo();
					tecnicoAdministrativo.setNome(dado);
					disciplina.setTecnicoAminAdministrativoAuxiliar(tecnicoAdministrativo);
					help = 2;
					break;
				}
				else
					System.out.println("\tDado inv�lido. N�meros n�o s�o permitidos!\n");
					help = 1;
			}while(help == 1);
			break;
			case "2": 
				TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo();
				tecnicoAdministrativo.setNome("\tN�o h� t�cnico administrativo auxiliar");
				disciplina.setTecnicoAminAdministrativoAuxiliar(tecnicoAdministrativo);
				auxiliar = 2;
				break;
			default:
				System.out.println("\tDado inv�lido!\n");
				auxiliar = 1;
			}
		}while(auxiliar == 1);
		
		System.out.println("\n.__________________________________________________________________________.");		
        System.out.println("|                                                                          |");
        System.out.println("|                                                                          |");
        System.out.println("|       SISTEMA DE GERENCIAMENTO ACAD�MICO                                 |");
    	System.out.println("|       0 - Desconhecida                                                   |");
    	System.out.println("|       1 - Aberta                                                         |");
    	System.out.println("|       2 - Ativa                                                          |");
    	System.out.println("|       3 - Inativa                                                        |");
    	System.out.println("|       4 - Conclu�da                                                      |");
    	System.out.println("|       5 - Outra                                                          |");
        System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
        System.out.println("\n\t9- Digite a situa��o da disciplina:    ");
		dado = ler.nextLine();
		if(validarSituacao(dado)) {
			disciplina.setSituacao(Integer.parseInt(dado));
		} else {
			System.out.println("\tDado inv�lido!\n"); // Repetir o menu de novo caso n�o exista nenhuma das op��es 
		}
		do {
		System.out.println("\n\t10- Digite a carga hor�ria pr�tica: "
				+ "\n\t  OBS: Deve possuir somente n�meros.");
		dado = ler.nextLine();
		if(validarCargaHorariaPratica(dado)) {
			disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
		} else {
			do {
				System.out.println("\tDado inv�lido!\n");
				System.out.println("\n\t10- Digite a carga hor�ria pr�tica: "
						+ "\n\t  OBS: Deve possuir somente n�meros.");
						dado = ler.nextLine();
						validarCargaHorariaPratica(dado);
			}while(validarCargaHorariaPratica(dado)==false);
			disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
		}
		System.out.println("\n\t11- Digite a carga hor�ria te�rica: "
				+ "\n\tOBS: Deve possuir somente n�meros.");
		dado = ler.nextLine();
		if(validarCargaHorariaPratica(dado)==true) {
			disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
		} else {
			do {
				System.out.println("\tDado inv�lido!\n");
				System.out.println("\n\t11- Digite a carga hor�ria te�rica: "
						+ "\n\t  OBS: Deve possuir somente n�meros.");
						dado = ler.nextLine();
						validarCargaHorariaTeorica(dado);
						if(validarCargaHorariaTeorica(dado)==false) {
							System.out.println("\tA somatoria da carga hor�ria te�rica com a carga hor�ria pr�tica n�o pode ser zero. Tente novamente :) ");
						}
			}while(validarCargaHorariaTeorica(dado)==false);
			disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
		}
		validarCargaHorariaTotal(dado);
		}while(validarCargaHorariaTotal(dado) == false);
		System.out.println("\n\t12- Digite a carga hor�ria semanal: "
				+ "\n\t  OBS: Deve possuir somente n�meros."); //Deve ser Opcional e somente n�meros
		dado = ler.nextLine();
		if(validarCargaHorariaSemanal(dado)==true) {
			disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
		} else {
			do {
				System.out.println("\tDado inv�lido!\n");
				System.out.println("\n\t12- Digite a carga hor�ria semanal: "
						+ "\n\t  OBS: Deve possuir somente n�meros.");
						dado = ler.nextLine();
						validarCargaHorariaSemanal(dado);
			}while(validarCargaHorariaSemanal(dado)==false);
			disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
		}
		System.out.println("\n\t13- Digite a carga hor�ria mensal: " // RODOLFO MEXA NISSO A�
				+ "\n\t  OBS: Deve possuir somente n�meros."); //Deve ser Opcional e somente n�meros
		dado = ler.nextLine();
		if(validarCargaHorariaMensal(dado)) {
			disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
		} else {
			do {
				System.out.println("\tDado inv�lido!\n");
				System.out.println("\n\t13- Digite a carga hor�ria mensal: "
						+ "\n\t  OBS: Deve possuir somente n�meros.");
						dado = ler.nextLine();
						validarCargaHorariaMensal(dado);
			}while(validarCargaHorariaMensal(dado)==false);
			disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
		}
		System.out.println("\n\t14- Digite o n�mero de cr�ditos:"
				+ "\n\t  OBS: Deve ser somente n�meros."); // Somente n�meros e ser opcional
		dado = ler.nextLine();
		if(validarNumCreditos(dado)) {
			disciplina.setNumeroCreditos(Integer.parseInt(dado));
		} else {
			System.out.println("\tDado inv�lido!\n");
		}
		System.out.println("\n\t15- Digite o custo pr�tica: "
				+ "\n\t  OBS: Deve ser somente n�meros."); // Opcional e s� n�mero
		dado = ler.nextLine();
		if(validarCustoPratica(dado)) {
			disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
		} else {
			System.out.println("\tDado inv�lido!\n");
		}
		System.out.println("\n\t16- Digite o custo te�rica: "
				+ "\n\t  OBS: Deve ser somente n�meros."); //Opcional e s� n�mero

		dado = ler.nextLine();
		if(validarCustoTeorica(dado)) {
			disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
		} else {
			System.out.println("\tDado inv�lido!\n");
		}
		System.out.println("\n\t17- Digite o custo fixo: "
				+ "\n\t  OBS: Deve ser somente n�meros."); //Opcional e s� n�mero
		dado = ler.nextLine();
		if(validarCustoFixo(dado)) {
			disciplina.setCustoFixo(Integer.parseInt(dado));
		} else {
			System.out.println("\tDado inv�lido!\n");
		}
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
			System.out.println("\tDigite o c�digo da disciplina a ser alterada: "); //Somente n�meros
			chave = ler.nextLine();
			for(Disciplina disciplina : disciplinas) {
				if(disciplina.getCodigo() == Integer.parseInt(chave)) {
					Disciplina disciplinaAlterada = alterarDados(disciplina);
					disciplinaDAO.alterar(disciplinaAlterada);	
				}
			}
			
			break;
		case 2:
			System.out.println("\tDigite o c�digo da disciplina a ser alterada: "); //Somente n�meros
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
			System.out.println("\tDigite o c�digo da disciplina a ser exclu�da: "); // Somente n�mero
			chave = Integer.parseInt(ler.nextLine());
			disciplinaDAO.excluir(chave);
			break;
		case 2:
			System.out.println("\tDigite o c�digo da disciplina a ser exclu�da: "); // Somente n�mero
			chave = Integer.parseInt(ler.nextLine()); //try...catch
			disciplinaDAO.excluir(chave);
			break;
		}
	}
	
	private static void menuExcluir() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|                                                                          |");
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Listar todas as diciplinas antes de excluir                    |");
    	System.out.println("|       2 - Excluir                                                        |");
    	System.out.println("|       3 - Sair                                                           |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf("\tDigite um dos seguintes n�meros para acessar: ");
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
    		System.out.printf("\tDigite o c�digo da disciplina: "); //Somente n�mero
    		chave = ler.nextLine();
    		System.out.println();
    		disciplinas = disciplinaDAO.consultar("codigo", chave);
    		exibirDados(disciplinas);
    		break;
    	case 3:
    		System.out.printf("\tDigite o nome completo da disciplina: "); //Somente Letras
    		chave = ler.nextLine();
    		System.out.println();
    		disciplinas = disciplinaDAO.consultar("nomeCompleto", chave);
    		exibirDados(disciplinas);
    		break;
    	case 4:
    		System.out.printf("\tDigite o nome abreviado da disciplina: "); // 3 D�gitos no max e pelo menos uma letra
    		chave = ler.nextLine();
    		System.out.println();
    		disciplinas = disciplinaDAO.consultar("nomeAbreviado", chave);
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
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Consultar todas                                                |");
    	System.out.println("|       2 - Consultar disciplina atrav�s do c�digo                         |");
    	System.out.println("|       3 - Consultar disciplina pelo nome completo                        |");
    	System.out.println("|       4 - Consultar disciplina pelo nome abreviado                       |");
    	System.out.println("|       5 - Sair                                                           |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf("\tDigite um dos seguintes n�meros para acessar: ");
	}
	
	private static void exibirDados(List<Disciplina> disciplinas) {
		if(!disciplinas.equals(null)) {
			for(Disciplina disciplina : disciplinas) {
				System.out.println(".__________________________________________________________________________.");
		    	System.out.println("|                                                                          ");
				System.out.println("|" + "Nome Completo.........................: " + disciplina.getNomeCompleto());
				System.out.println("|" + "Nome Abreviado........................: " + "" + disciplina.getNomeAbreviado());
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
		    	System.out.println("|_____________________________________________________________________________.");
			}
		} else {
			System.out.println("\tNenhuma disciplina foi encontrada com os par�metros informados");
		}
	}
	
	private static void menuAlterar() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|                                                                          |");
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Listar todas as diciplinas antes de alterar                    |");
    	System.out.println("|       2 - Alterar                                                        |");
    	System.out.println("|       3 - Sair                                                           |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf("\tDigite um dos seguintes n�meros para acessar: ");
	}
	
	private static Disciplina alterarDados(Disciplina disciplina) {
		menuOpcaoAlterar();
		String dado;
		int leitura = Integer.parseInt(ler.nextLine());
		switch(leitura) {
		case 1 :
			System.out.println("\tDigite o nome completo da disciplina: "); 
			dado = ler.nextLine();
			if(validarNome(dado)) {
				disciplina.setNomeCompleto(dado);
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 2 :
			System.out.println("\tDigite o nome abreviado da disciplina: "); //No max 3 d�gitos e no m�nimo 1 letra
			dado = ler.nextLine();
			if(validarAbreviacao(dado)) {
				disciplina.setNomeAbreviado(dado);
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 3 :
			System.out.println("\tDigite o nome do curso que a disciplina est� vinculada"); //Somente letras
			dado = ler.nextLine();
			if(validarCurso(dado)) {
				disciplina.setCurso(dado);
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 4 :
			System.out.println("\tDigite o nome do docente respons�vel pela disciplina: "); //Somente letras
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteResponsavel(docente);
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 5 :
			System.out.println("\t\t DOCENTE AUXILIAR");
			menuOpcao();
			
			System.out.println("\tDigite o nome do docente auxiliar da disciplina: "); //Somente letras
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteAuxiliar(docente);
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 6 :
			System.out.println("\tDigite o nome do t�cnico administrativo respons�vel da disciplina:");//Somente Letras
			dado = ler.nextLine();
			if(validarTecnico(dado)) {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAdministrativoResponsavel(tecnico);
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 7 :
			System.out.println("\tDigite o nome do t�cnico administrativo auxiliar da disciplina: "); //Somente letras
			dado = ler.nextLine();
			if(validarTecnico(dado)) {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAminAdministrativoAuxiliar(tecnico);
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 8 :
			System.out.println(".__________________________________________________________________________.");		
	        System.out.println("|                                                                          |");
	        System.out.println("|                                                                          |");
	        System.out.println("|       SISTEMA DE GERENCIAMENTO ACAD�MICO                                 |");
	    	System.out.println("|       0 - Desconhecida                                                   |");
	    	System.out.println("|       1 - Aberta                                                         |"); // adicionar 
	    	System.out.println("|       2 - Ativa                                                          |");
	    	System.out.println("|       3 - Inativa                                                        |");
	    	System.out.println("|       4 - Conclu�da                                                      |");
	    	System.out.println("|       5 - Outra                                                          |");
	        System.out.println("|                                                                          |");
	    	System.out.println("|__________________________________________________________________________|");
	        System.out.printf("\tDigite a situa��o da disciplina:                               ");
			dado = ler.nextLine();
			if(validarSituacao(dado)) {
				disciplina.setSituacao(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 9 :
			System.out.println("\tDigite a carga hor�ria pr�tica: "); // somente n�mero
			dado = ler.nextLine();
			if(validarCargaHorariaPratica(dado)) {
				disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 10 :
			System.out.println("\tDigite a carga hor�ria te�rica: "); // somente n�mero
			dado = ler.nextLine();
			if(validarCargaHorariaTeorica(dado)) {
				disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 11 :
			System.out.println("\tDigite a carga hor�ria semanal: "); // somente n�mero
			dado = ler.nextLine();
			if(validarCargaHorariaSemanal(dado)) {
				disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 12 :
			System.out.println("\tDigite a carga hor�ria mensal: ");// somente n�mero
			dado = ler.nextLine();
			if(validarCargaHorariaMensal(dado)) {
				disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 13 :
			System.out.println("\tDigite a carga hor�ria total: ");// somente n�mero
			dado = ler.nextLine();
			if(validarCargaHorariaTotal(dado)) {
				disciplina.setCargaHorariaTotal(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 14 :
			System.out.println("\tDigite o n�mero de cr�ditos:");// somente n�mero
			dado = ler.nextLine();
			if(validarNumCreditos(dado)) {
				disciplina.setNumeroCreditos(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 15 :
			System.out.println("\tDigite o custo pr�tica: ");// somente n�mero
			dado = ler.nextLine();
			if(validarCustoPratica(dado)) {
				disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 16 :
			System.out.println("\tDigite o custo te�rica: ");// somente n�mero
			dado = ler.nextLine();
			if(validarCustoTeorica(dado)) {
				disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
			}
			break;
		case 17 :
			System.out.println("\tDigite o custo fixo: ");// somente n�mero
			dado = ler.nextLine();
			if(validarCustoFixo(dado)) {
				disciplina.setCustoFixo(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
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
		
		return true;
	}

	private static boolean validarNumCreditos(String dado) {
		// TODO Auto-generated method stub
		return true;
	}

	private static boolean validarCargaHorariaTotal(String dado) {//OK
		double cargaPratica = disciplina.getCargaHorariaPratica();
		double cargaTeorica = disciplina.getCargaHorariaTeorica();
		double cargaTotal = cargaPratica + cargaTeorica;
		disciplina.setCargaHorariaTotal(cargaTotal);
		boolean confirma�ao;
		if(cargaTotal != 0) {
			confirma�ao = true;
		}
		else {
			confirma�ao = false;
		}
		return confirma�ao;
	}

	private static boolean validarCargaHorariaMensal(String dado) {//OK
		int testeTamanho = dado.length();
		boolean confirma�ao;
		boolean valida�ao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			valida�ao = true;
		}
		catch(NumberFormatException erro) {
			valida�ao = false;
		}
		if(testeTamanho>0 && valida�ao == true) {
			confirma�ao = true;
		}
		else {
			confirma�ao = false;
		}
		return confirma�ao;
	}

	private static boolean validarCargaHorariaSemanal(String dado) {//OK
		int testeTamanho = dado.length();
		boolean confirma�ao;
		boolean valida�ao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			valida�ao = true;
		}
		catch(NumberFormatException erro) {
			valida�ao = false;
		}
		if(testeTamanho>0 && valida�ao == true) {
			confirma�ao = true;
		}
		else {
			confirma�ao = false;
		}
		return confirma�ao;
	}

	private static boolean validarCargaHorariaTeorica(String dado) {//OK
		int testeTamanho = dado.length();
		boolean confirma�ao;
		boolean valida�ao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			valida�ao = true;
		}
		catch(NumberFormatException erro) {
			valida�ao = false;
		}
		if(testeTamanho>0 && valida�ao == true) {
			confirma�ao = true;
		}
		else {
			confirma�ao = false;
		}
		return confirma�ao;
	}

	private static boolean validarCargaHorariaPratica(String dado) {//OK
		int testeTamanho = dado.length();
		boolean confirma�ao;
		boolean valida�ao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			valida�ao = true;
		}
		catch(NumberFormatException erro) {
			valida�ao = false;
		}
		if(testeTamanho>0 && valida�ao == true) {
			confirma�ao = true;
		}
		else {
			confirma�ao = false;
		}
		return confirma�ao;
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

	private static boolean validarAbreviacao(String dado) {//OK
		int testeTamanho = dado.length();
		boolean confirmacao;
		boolean valida�ao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			valida�ao = false;
		}
		catch(NumberFormatException erro) {
			valida�ao = true;
		}
		if(testeTamanho>0 && testeTamanho<4 && valida�ao == true) {
			confirmacao = true;
		}
		else {
			confirmacao = false;
		}
		return confirmacao;
	}

	private static boolean validarNome(String dado) {//OK
		boolean confirma�ao;
		int testeTamanho;
		testeTamanho = dado.length();
		boolean valida�ao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			valida�ao = false;
		}
		catch(NumberFormatException erro) {
			valida�ao = true;
		}
		if(testeTamanho>0 && valida�ao == true) {
			confirma�ao = true;
		}
		else {
			confirma�ao = false;
		}
		return confirma�ao;
	}

	private static boolean validarCodigo(String dado) {//OK
		
		boolean apoio = true;
		
		if(dado.length()==4) {
			try{
				int dado2 = Integer.parseInt(dado);
				apoio = true;
			}catch(NumberFormatException erro) {
				
				apoio = false;
			}
		}
		else {
			
			apoio = false;
			}
	return apoio;		
}
	private static void menuOpcaoAlterar() {
		System.out.println(".__________________________________________________________________________.");
		System.out.println("|                                                                          |");
		System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|        1 - Alterar Nome Completo                                         |");
    	System.out.println("|        2 - Alterar Nome Abreviado                                        |");
    	System.out.println("|        3 - Alterar Curso                                                 |"); 
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
    	System.out.println("|       14 - Alterar Custo Basico Pr�tica                                  |");
    	System.out.println("|       15 - Alterar Custo Basico Te�rica                                  |");
    	System.out.println("|       16 - Alterar Custo Fixo                                            |");
		System.out.println("|                                                                          |");
		System.out.println("|__________________________________________________________________________|");
		System.out.println("\tDado n�o alterado, pois o param�tro passado � inv�lido!");
    	System.out.printf("\tDigite um dos seguintes n�meros para acessar: ");
	}
	private static void menuOpcao() {
		
		System.out.println("\n.__________________________________________________________________________.");
		System.out.println("|                                                                          |");
		System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       Deseja adicionar alguma informa��o neste campo?                    |");
    	System.out.println("|        1 - Sim                                                           |");
    	System.out.println("|        2 - N�o                                                           |");
		System.out.println("|                                                                          |");
		System.out.println("|__________________________________________________________________________|");
		
    	System.out.println("\n");
    	
	}
	
	public static boolean checkLetters(String str) 
	{
		return str.matches("[a-zA-Z\\u0020]+");
	}
	private static void menuCurso() {
		System.out.println(".__________________________________________________________________________.");
    	System.out.println("|                                                                          |");
    	System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO DE CURSOS                                 |");
    	System.out.println("|       1 - Curso de n�cleo livre 						                   |");
    	System.out.println("|       2 - Adicionar curso                                                |");
    	System.out.println("|       3 - Sair                                                           |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf("\n\tDigite um dos seguintes n�meros para acessar: ");
	}

}
