/*
 * Sistema de Gestão Acadêmica 
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
        
        int leitura;
        do {
        	do {
        		try {
        			leitura = menu();
        		}
        		catch(Exception e) {// trocar exception?
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
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Cadastrar informações sobre a disciplina                       |");
    	System.out.println("|       2 - Alterar informações sobre a disciplina                         |");
    	System.out.println("|       3 - Excluir a disciplina                                           |");
    	System.out.println("|       4 - Consultar uma disciplina                                       |");
    	System.out.println("|       5 - Sair do sistema                                                |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" \tDigite um dos seguintes números para acessar: ");
    	leitura = Integer.parseInt(ler.nextLine());
    	System.out.println("\n\n");
    	return leitura;
	}
	
	private static void cadastrar() {
		String dado;	
		do {
			System.out.println("\nDigite o código da disciplina: "
					+ "\nOBS: Deve ser formado apenas por quatro números.");
			dado = ler.nextLine();
			if(validarCodigo(dado)) {
				disciplina.setCodigo(Integer.parseInt(dado));
			} else {
				System.out.println("\n\n\tDado inválido!");
			}
		}while(validarCodigo(dado)==false);
		System.out.println("Digite o nome completo da disciplina: "); 
		dado = ler.nextLine();
		if(validarNome(dado)==true) {
			disciplina.setNomeCompleto(dado);
		} 
		else {
			do {
			System.out.println("Dado inválido!");
			System.out.println("Digite o nome completo da disciplina: "); 
			dado = ler.nextLine();
			validarNome(dado);
			}while(validarNome(dado)==false);
			disciplina.setNomeCompleto(dado);
		}
		System.out.println("Digite o nome abreviado da disciplina: "
				+ "\nOBS: Deve possuir no máximo três caracteres, onde pelo menos um caracter seja uma letra."); 
		dado = ler.nextLine();
		if(validarAbreviacao(dado)==true) {
			disciplina.setNomeAbreviado(dado);
		} else {
			do {
				System.out.println("Dado inválido!");
				System.out.println("Digite o nome abreviado da disciplina: "
						+ "\nOBS: Deve possuir no máximo três caracteres.");
						dado = ler.nextLine();
						validarAbreviacao(dado);
			}while(validarAbreviacao(dado)==false);
			disciplina.setNomeAbreviado(dado);
		}
		System.out.println("Digite o nome do curso ao qual a disciplina está vinculada"
				+ "\nOBS: Deve possuir somente letras.");  //Somente Letras
		dado = ler.nextLine();
		if(validarCurso(dado)) {
			disciplina.setCurso(dado);
		} else {
			System.out.println("Dado inválido!");
		}
			System.out.println("Digite o nome do docente responsável pela disciplina: "
					+ "\nOBS: Deve possuir somente letras."); //Somente Letras
		dado = ler.nextLine();
		if(validarDocenteR(dado)) {
			Docente docente = new Docente();
			docente.setNome(dado);
			disciplina.setDocenteResponsavel(docente);
		} else {
			System.out.println("Dado inválido!");
		}
				System.out.println("Digite o nome do docente auxiliar da disciplina: "
						+ "\nOBS: Deve possuir somente letras."); //Somente Letras e colocar menu para selecionar o desejo
		dado = ler.nextLine();
		if(validarDocenteR(dado)) {
			Docente docente = new Docente();
			docente.setNome(dado);
			disciplina.setDocenteAuxiliar(docente);
		} else {
			System.out.println("Dado inválido!");
		}
					System.out.println("Digite o nome do técnico administrativo auxiliar da disciplina: "
							+ "\nOBS: Deve possuir somente letras."); //Somente Letras e colocar menu para selecionar o desejo
		dado = ler.nextLine();
		if(validarTecnico(dado)) {
			TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
			tecnico.setNome(dado);
			disciplina.setTecnicoAminAdministrativoAuxiliar(tecnico);
		} else {
			System.out.println("Dado inválido!");
		}
		System.out.println(".__________________________________________________________________________.");		
        System.out.println("|                                                                          |");
        System.out.println("|                                                                          |");
        System.out.println("|       SISTEMA DE GERENCIAMENTO ACADÊMICO                                 |");
    	System.out.println("|       0 - Desconhecida                                                   |");
    	System.out.println("|       1 - Aberta                                                         |");
    	System.out.println("|       2 - Ativa                                                          |");
    	System.out.println("|       3 - Inativa                                                        |");
    	System.out.println("|       4 - Concluída                                                      | ");
    	System.out.println("|       5 - Outra                                                          |        ");
        System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
        System.out.printf("\tDigite a situação da disciplina:                               ");
		dado = ler.nextLine();
		if(validarSituacao(dado)) {
			disciplina.setSituacao(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!"); // Repetir o menu de novo caso não exista nenhuma das opções 
		}
				System.out.println("Digite a carga horária prática: ");
		dado = ler.nextLine();
		if(validarCargaHorariaPratica(dado)) {
			disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
				System.out.println("Digite a carga horária teórica: ");
		dado = ler.nextLine();
		if(validarCargaHorariaTeorica(dado)) {
			disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
				System.out.println("Digite a carga horária semanal: "); //Deve ser Opcional e somente números
		dado = ler.nextLine();
		if(validarCargaHorariaSemanal(dado)) {
			disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
				System.out.println("Digite a carga horária mensal: "); //Deve ser Opcional e somente números
		dado = ler.nextLine();
		if(validarCargaHorariaMensal(dado)) {
			disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
					System.out.println("Digite a carga horária total: "); //Não pode ser igual a zero (fazer a somatória)
		dado = ler.nextLine();
		if(validarCargaHorariaTotal(dado)) {
			disciplina.setCargaHorariaTotal(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
					System.out.println("Digite o número de créditos:"
							+ "OBS: Deve ser somente números."); // Somente números e ser opcional
		dado = ler.nextLine();
		if(validarNumCreditos(dado)) {
			disciplina.setNumeroCreditos(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
					System.out.println("Digite o custo prática: "
							+ "OBS: Deve ser somente números."); // Opcional e só número
		dado = ler.nextLine();
		if(validarCustoPratica(dado)) {
			disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
				System.out.println("Digite o custo teórica: "
						+ "OBS: Deve ser somente números."); //Opcional e só número

		dado = ler.nextLine();
		if(validarCustoTeorica(dado)) {
			disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
					System.out.println("Digite o custo fixo: "
							+ "OBS: Deve ser somente números."); //Opcional e só número
		dado = ler.nextLine();
		if(validarCustoFixo(dado)) {
			disciplina.setCustoFixo(Integer.parseInt(dado));
		} else {
			System.out.println("Dado inválido!");
		}
					System.out.println("Digite o nome do técnico administrativo responsável da disciplina:"
							+ "OBS: Deve ser somente letras."); //Somente Letras
		dado = ler.nextLine();
		if(validarTecnico(dado)) {
			TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
			tecnico.setNome(dado);
			disciplina.setTecnicoAdministrativoResponsavel(tecnico);
		} else {
			System.out.println("Dado inválido!");
		}
		disciplinaDAO.cadastrar(disciplina);
	}
	
	private static boolean validarCodigo(String dado) {
		
			boolean apoio = true;
			
			if(dado.length()==4) {
				try{
					int dado2 = Integer.parseInt(dado);
					apoio = true;
				}catch(NumberFormatException erro) {
					System.out.println("\n\n\tNão insira letras apenas números!");
					apoio = false;
				}
			}
			else {
				System.out.println("\n\n\tQuantidade Incorreta!");
				apoio = false;
				}
		return apoio;
		
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
			System.out.println("Digite o código da disciplina a ser alterada: "); //Somente números
			chave = ler.nextLine();
			for(Disciplina disciplina : disciplinas) {
				if(disciplina.getCodigo() == Integer.parseInt(chave)) {
					Disciplina disciplinaAlterada = alterarDados(disciplina);
					disciplinaDAO.alterar(disciplinaAlterada);	
				}
			}
			
			break;
		case 2:
			System.out.println("Digite o código da disciplina a ser alterada: "); //Somente números
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
			System.out.println("Digite o código da disciplina a ser excluída: "); // Somente número
			chave = Integer.parseInt(ler.nextLine());
			disciplinaDAO.excluir(chave);
			break;
		case 2:
			System.out.println("Digite o código da disciplina a ser excluída: "); // Somente número
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
    	System.out.printf(" Digite um dos seguintes números para acessar: ");
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
    		System.out.printf("Digite o código da disciplina: "); //Somente número
    		chave = ler.nextLine();
    		System.out.println();
    		disciplinas = disciplinaDAO.consultar("codigo", chave);
    		exibirDados(disciplinas);
    		break;
    	case 3:
    		System.out.printf("Digite o nome completo da disciplina: "); //Somente Letras
    		chave = ler.nextLine();
    		System.out.println();
    		disciplinas = disciplinaDAO.consultar("nome completo", chave);
    		exibirDados(disciplinas);
    		break;
    	case 4:
    		System.out.printf("Digite o nome abreviado da disciplina: "); // 3 Dígitos no max e pelo menos uma letra
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
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|       1 - Consultar todas                                                |");
    	System.out.println("|       2 - Consultar disciplina através do código                         |");
    	System.out.println("|       3 - Consultar disciplina pelo nome completo                        |");
    	System.out.println("|       4 - Consultar disciplina pelo nome abreviado                       |");
    	System.out.println("|       5 - Sair                                                           |");
    	System.out.println("|                                                                          |");
    	System.out.println("|__________________________________________________________________________|");
    	System.out.printf(" Digite um dos seguintes números para acessar: ");
	}
	
	private static void exibirDados(List<Disciplina> disciplinas) {
		if(!disciplinas.equals(null)) {
			for(Disciplina disciplina : disciplinas) {
				System.out.println(".__________________________________________________________________________.");
		    	System.out.println("|                                                                          ");
				System.out.println("|" + "Nome Completo.........................: " + disciplina.getNomeCompleto());
				System.out.println("|" + "Nome Abreviado........................: " + "" + disciplina.getNomeAbreviado());
				System.out.println("|" + "Código................................: " + disciplina.getCodigo());
				System.out.println("|" + "Curso.................................: " + disciplina.getCurso());
				System.out.println("|" + "Docente Responsável...................: " + disciplina.getDocenteResponsavel().getNome());
				System.out.println("|" + "Docente Auxiliar......................: " + disciplina.getDocenteAuxiliar().getNome());
				System.out.println("|" + "Técnico Administrativo Responsável....: " + disciplina.getTecnicoAdministrativoResponsavel().getNome());
				System.out.println("|" + "Técnico AminAdministrativo Auxiliar...: " + disciplina.getTecnicoAminAdministrativoAuxiliar().getNome());
				System.out.println("|" + "Situação..............................: " + disciplina.getSituacao());
				System.out.println("|" + "Carga Horária Prática.................: " + disciplina.getCargaHorariaPratica());
				System.out.println("|" + "Carga Horária Teórica.................: " + disciplina.getCargaHorariaTeorica());
				System.out.println("|" + "Carga Horária Semanal.................: " + disciplina.getCargaHorariaSemanal());
				System.out.println("|" + "Carga Horária Mensal..................: " + disciplina.getCargaHorariaMensal());
				System.out.println("|" + "Carga Horária Total...................: " + disciplina.getCargaHorariaTotal());
				System.out.println("|" + "Número de Créditos....................: " + disciplina.getNumeroCreditos());
				System.out.println("|" + "Custo Básico Prática..................: " + disciplina.getCustoBasicoPratica());
				System.out.println("|" + "Custo Básico Teórica..................: " + disciplina.getCustoBasicoTeorica());
				System.out.println("|" + "Custo Fixo............................: " + disciplina.getCustoFixo());
		    	System.out.println("|_____________________________________________________________________________.");
			}
		} else {
			System.out.println("Nenhuma disciplina foi encontrada com os parâmetros informados");
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
    	System.out.printf(" Digite um dos seguintes números para acessar: ");
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
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 2 :
			System.out.println("Digite o nome abreviado da disciplina: "); //No max 3 dígitos e no mínimo 1 letra
			dado = ler.nextLine();
			if(validarAbreviacao(dado)) {
				disciplina.setNomeAbreviado(dado);
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 3 :
			System.out.println("Digite o nome do curso que a disciplina está vinculada"); //Somente letras
			dado = ler.nextLine();
			if(validarCurso(dado)) {
				disciplina.setCurso(dado);
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 4 :
			System.out.println("Digite o nome do docente responsável pela disciplina: "); //Somente letras
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteResponsavel(docente);
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 5 :
			System.out.println("Digite o nome do docente auxiliar da disciplina: "); //Somente letras
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteAuxiliar(docente);
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 6 :
			System.out.println("Digite o nome do técnico administrativo auxiliar da disciplina: "); //Somente letras
			dado = ler.nextLine();
			if(validarTecnico(dado)) {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAminAdministrativoAuxiliar(tecnico);
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 7 :
			System.out.println(".__________________________________________________________________________.");		
	        System.out.println("|                                                                          |");
	        System.out.println("|                                                                          |");
	        System.out.println("|       SISTEMA DE GERENCIAMENTO ACADÊMICO                                 |");
	    	System.out.println("|       0 - Desconhecida                                                   |");
	    	System.out.println("|       1 - Aberta                                                         |");
	    	System.out.println("|       2 - Ativa                                                          |");
	    	System.out.println("|       3 - Inativa                                                        |");
	    	System.out.println("|       4 - Concluída                                                      | ");
	    	System.out.println("|       5 - Outra                                                          |        ");
	        System.out.println("|                                                                          |");
	    	System.out.println("|__________________________________________________________________________|");
	        System.out.printf("\tDigite a situação da disciplina:                               ");
			dado = ler.nextLine();
			if(validarSituacao(dado)) {
				disciplina.setSituacao(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 8 :
			System.out.println("Digite a carga horária prática: "); // somente número
			dado = ler.nextLine();
			if(validarCargaHorariaPratica(dado)) {
				disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 9 :
			System.out.println("Digite a carga horária teórica: "); // somente número
			dado = ler.nextLine();
			if(validarCargaHorariaTeorica(dado)) {
				disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 10 :
			System.out.println("Digite a carga horária semanal: "); // somente número
			dado = ler.nextLine();
			if(validarCargaHorariaSemanal(dado)) {
				disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 11 :
			System.out.println("Digite a carga horária mensal: ");// somente número
			dado = ler.nextLine();
			if(validarCargaHorariaMensal(dado)) {
				disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 12 :
			System.out.println("Digite a carga horária total: ");// somente número
			dado = ler.nextLine();
			if(validarCargaHorariaTotal(dado)) {
				disciplina.setCargaHorariaTotal(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 13 :
			System.out.println("Digite o número de créditos:");// somente número
			dado = ler.nextLine();
			if(validarNumCreditos(dado)) {
				disciplina.setNumeroCreditos(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 14 :
			System.out.println("Digite o custo prática: ");// somente número
			dado = ler.nextLine();
			if(validarCustoPratica(dado)) {
				disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 15 :
			System.out.println("Digite o custo teórica: ");// somente número
			dado = ler.nextLine();
			if(validarCustoTeorica(dado)) {
				disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 16 :
			System.out.println("Digite o custo fixo: ");// somente número
			dado = ler.nextLine();
			if(validarCustoFixo(dado)) {
				disciplina.setCustoFixo(Integer.parseInt(dado));
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 17 :
			System.out.println("Digite o nome do técnico administrativo responsável da disciplina:");//Somente Letras
			dado = ler.nextLine();
			if(validarTecnico(dado)) {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAdministrativoResponsavel(tecnico);
			} else {
				System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
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
		int testeTamanho = dado.length();
		boolean confirmacao;
		boolean validaçao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			validaçao = false;
		}
		catch(NumberFormatException erro) {
			validaçao = true;
		}
		if(testeTamanho>0 && testeTamanho<4 && validaçao == true) {
			confirmacao = true;
		}
		else {
			confirmacao = false;
		}
		return confirmacao;
	}

	private static boolean validarNome(String dado) {
		boolean confirmaçao;
		int testeTamanho;
		testeTamanho = dado.length();
		if(testeTamanho>0) {
			confirmaçao = true;
		}
		else {
			confirmaçao = false;
		}
		return confirmaçao;
	}

	private static void menuOpcaoAlterar() {
		System.out.println(".__________________________________________________________________________.");
		System.out.println("|                                                                          |");
		System.out.println("|                                                                          |");
    	System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
    	System.out.println("|        1 - Alterar Nome Completo                                         |");
    	System.out.println("|        2 - Alterar Nome Abreviado                                        |");
    	System.out.println("|        3 - Alterar Curso                                                 |"); //Alterar o resto
    	System.out.println("|        4 - Alterar Docente Responsável                                   |");
    	System.out.println("|        5 - Alterar Docente Auxiliar                                      |");
    	System.out.println("|        6 - Alterar Técnico Administrativo Auxiliar                       |");
    	System.out.println("|        7 - Alterar Situação                                              |");
    	System.out.println("|        8 - Alterar Carga Horária Prática                                 |");
    	System.out.println("|        9 - Alterar Carga Horária Teórica                                 |");
    	System.out.println("|       10 - Alterar Carga Horária Semanal                                 |");
    	System.out.println("|       11 - Alterar Carga Horária Mensal                                  |");
    	System.out.println("|       12 - Alterar Carga Horária Total                                   |");
    	System.out.println("|       13 - Alterar Número de Créditos                                    |");
    	System.out.println("|       14 - Alterar Custo Basico Prática                                  |");
    	System.out.println("|       15 - Alterar Custo Basico Teórica                                  |");
    	System.out.println("|       16 - Alterar Custo Fixo                                            |");
		System.out.println("|                                                                          |");
		System.out.println("|__________________________________________________________________________|");
		System.out.println("Dado não alterado, pois o paramêtro passado é inválido!");
    	System.out.printf(" Digite um dos seguintes números para acessar: ");
	}
	
}
