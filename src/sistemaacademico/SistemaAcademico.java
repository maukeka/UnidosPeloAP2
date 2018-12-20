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
 * @author Wanderley de Souza Alencar                
 */
public class SistemaAcademico {

	private static Scanner ler = new Scanner(System.in);
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
		System.out.printf("\n\tDigite um dos seguintes números para acessar: ");
		leitura = Integer.parseInt(ler.nextLine());
		System.out.println("\n");
		return leitura;
	}

	private static void cadastrar() {
		String dado;Disciplina disciplina = new Disciplina();	
		do {
			System.out.printf("\t1- Digite o código da disciplina: \n\tOBS: deve ser formado por quatro números.\n\t");
			dado = ler.nextLine();
			if(validarCodigo(dado)) {
				disciplina.setCodigo(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado inválido!\n");	
			}
		}while(validarCodigo(dado)==false);
		System.out.printf("\n");
		System.out.printf("\n\t2- Digite o nome completo da disciplina: \n\tOBS: deve possuir pelo menos uma letra. \n\t"); 
		dado = ler.nextLine();
		if(validarNome(dado)==true) {
			disciplina.setNomeCompleto(dado);
		} 
		else {
			do {
				System.out.println("\tDado inválido!\n");
				System.out.printf("\t2- Digite o nome completo da disciplina: \n\tOBS: deve possuir pelo menos uma letra.\n\t"); 
				dado = ler.nextLine();
				validarNome(dado);
			}while(validarNome(dado)==false);
			disciplina.setNomeCompleto(dado);
		}
		System.out.println("");
		System.out.printf("\n\t3- Digite o nome abreviado da disciplina: \n\tOBS: deve possuir pelo menos uma letra.\n\t"); 
		dado = ler.nextLine();
		if(validarAbreviacao(dado)==true) {
			disciplina.setNomeAbreviado(dado);
		} else {
			do {
				System.out.println("\tDado inválido!\n");
				System.out.printf("\t3- Digite o nome abreviado da disciplina: \n\tOBS: deve possuir pelo menos uma letra.\n\t");
				dado = ler.nextLine();
				validarAbreviacao(dado);
			}while(validarAbreviacao(dado)==false);
			disciplina.setNomeAbreviado(dado);
		}
		
		int auxiliar = 1;
		do {
			System.out.println("\n\n\t\t\t       CURSO\n");
			menuOpcao();
			System.out.printf("\n\t");
			dado = ler.nextLine();
			System.out.printf("\n");
			switch(dado)
			{  
			case "1":
				int help = 1;
				do {
					System.out.printf("\t4- Digite o nome do curso: \n\tOBS: deve possuir apenas letras.\n\t");
					dado = ler.nextLine();
					if(validarCurso(dado)) {
						disciplina.setCurso(dado);
						help = 2;
						break;
					}
					else
						System.out.println("\tDado inválido!\n");
					help = 1;
				}while(help == 1);
				auxiliar = 2;
				break;
			case "2":
				System.out.println("\t4- Disciplina de núcleo livre!");
				disciplina.setCurso("0- NÚCLEO LIVRE");
				auxiliar = 2;
				break;  
			default:
				System.out.println("\tDado inválido!\n");
				break;
			}
		}while( auxiliar == 1);
		System.out.println("\n");


		do{
			System.out.printf("\t5- Digite o nome do docente responsável pela disciplina: \n\tOBS: deve possuir apenas letras.\n\t"); //Somente Letras
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteResponsavel(docente);
				auxiliar = 2;
				break;
			} else {
				System.out.println("\tDado inválido!\n");
				auxiliar = 1;

			}
		}while( auxiliar == 1);



		do {
			System.out.print("\n\n");
			System.out.println("\t\t\t  DOCENTE AUXILIAR");
			menuOpcao();
			System.out.printf("\n\t");
			dado = ler.nextLine();

			switch (dado) {
			case "1": 
				int help = 1;
				do {
					System.out.printf("\n\t6- Digite o nome do docente auxiliar da disciplina: \n\tOBS: deve possuir apenas letras.\n\t");
					dado = ler.nextLine();
					if(validarDocenteR(dado)) {
						Docente docente = new Docente();
						docente.setNome(dado);
						disciplina.setDocenteAuxiliar(docente);
						help = 2;
						break;
					}
					else
						System.out.println("\tDado inválido.\n");
					help = 1;
				}while(help == 1);
				auxiliar = 2;
				break;
			case "2": 
				Docente docente = new Docente();
				docente.setNome("Não há docente auxiliar");
				disciplina.setDocenteAuxiliar(docente);
				auxiliar = 2;
				break;
			default:
				System.out.println("\tDado inválido!\n");
				auxiliar = 1;
			}
		}while(auxiliar == 1);



		do {	
			System.out.print("\n\n");
			System.out.println("\t\t    TÉCNICO ADMINISTRATIVO RESPONSÁVEL");
			menuOpcao();
			System.out.printf("\n\t");
			dado = ler.nextLine();


			switch (dado) {
			case "1": 
				int help = 1;
				do {
					System.out.printf("\n\t7- Digite o nome do técnico administrativo responsável pela disciplina: ");
					dado = ler.nextLine();
					if(validarTecnico(dado)) {
						TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo();
						tecnicoAdministrativo.setNome(dado);
						disciplina.setTecnicoAdministrativoResponsavel(tecnicoAdministrativo);
						help = 2;
						break;
					}
					else
						System.out.println("\tDado inválido. Deve possuir somente letras.");
					help = 1;
				}while(help == 1);
				auxiliar = 2;
				break;
			case "2": 
				TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo();
				tecnicoAdministrativo.setNome("Não há técnico administrativo responsável");
				disciplina.setTecnicoAdministrativoResponsavel(tecnicoAdministrativo);
				auxiliar = 2;
				break;
			default:
				System.out.println("\tDado inválido!\n");
				auxiliar = 1;
			}
		}while(auxiliar == 1);



		do {
			System.out.print("\n\n");
			System.out.println("\t\t    TÉCNICO ADMINISTRATIVO AUXILIAR");
			menuOpcao();
			System.out.printf("\n\t");
			dado = ler.nextLine();

			switch (dado) {
			case "1":
				int help = 1;
				do {
					System.out.printf("\n\t8- Digite o nome do técnico administrativo auxiliar da disciplina: ");
					dado = ler.nextLine();
					if(validarTecnico(dado)) {
						TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo();
						tecnicoAdministrativo.setNome(dado);
						disciplina.setTecnicoAminAdministrativoAuxiliar(tecnicoAdministrativo);
						help = 2;
						break;
					}
					else
						System.out.println("\tDado inválido. Deve possuir somente letras.");
					help = 1;
				}while(help == 1);
				auxiliar = 2;
				break;
			case "2": 
				TecnicoAdministrativo tecnicoAdministrativo = new TecnicoAdministrativo();
				tecnicoAdministrativo.setNome("Não há técnico administrativo auxiliar");
				disciplina.setTecnicoAminAdministrativoAuxiliar(tecnicoAdministrativo);
				auxiliar = 2;
				break;
			default:
				System.out.println("\tDado inválido!\n");
				auxiliar = 1;
			}
		}while(auxiliar == 1);

		System.out.println("\n\n\t\t\tSITUAÇÃO DA DISCIPLINA");
		System.out.println(".__________________________________________________________________________.");		
		System.out.println("|                                                                          |");
		System.out.println("|                                                                          |");
		System.out.println("|       SISTEMA DE GERENCIAMENTO ACADÊMICO                                 |");
		System.out.println("|       0 - Desconhecida                                                   |");
		System.out.println("|       1 - Aberta                                                         |");
		System.out.println("|       2 - Ativa                                                          |");
		System.out.println("|       3 - Inativa                                                        |");
		System.out.println("|       4 - Concluída                                                      |");
		System.out.println("|       5 - Outra                                                          |");
		System.out.println("|                                                                          |");
		System.out.println("|__________________________________________________________________________|");
		System.out.printf("\n\t9- Digite a situação da disciplina: ");
		dado = ler.nextLine();

		if(validarSituacao(dado)==true) {

			int situacaoDisci = Integer.parseInt(dado);

			switch (situacaoDisci) {
			case 0:  
				disciplina.setSituacao("Desconhecida");
				System.out.println("\tSituação da disciplina: desconhecida");
				break;
			case 1: 
				disciplina.setSituacao("Aberta");
				System.out.println("\tSituação da disciplina: aberta");
				break;
			case 2:
				disciplina.setSituacao("Ativa");
				System.out.println("\tSituação da disciplina: ativa");
				break;
			case 3:
				disciplina.setSituacao("Inativa");
				System.out.println("\tSituação da disciplina: inativa");
				break;
			case 4:
				disciplina.setSituacao("Concluída");
				System.out.println("\tSituação da disciplina: concluída");
				break;
			case 5:
				do {
					System.out.println("Digite a siuação da disciplina: "
							+ "OBS: Apenas letras");
					dado = ler.nextLine();
					if(validarSit(dado)) {
						disciplina.setSituacao(dado);
						System.out.println("\tSituação da disciplina:" +dado);
					}
					else
						System.out.println("Dado inválido!");
					
				
				}while(validarCurso(dado) == false);
				break;

			default:
				break;
			}

		} else {
			do {
				System.out.println("\tDado inválido!"); // Repetir o menu de novo caso não exista nenhuma das opções 
				System.out.println("\n\t\t\tSITUAÇÃO DA DISCIPLINA");
				System.out.println(".__________________________________________________________________________.");		
				System.out.println("|                                                                          |");
				System.out.println("|                                                                          |");
				System.out.println("|       SISTEMA DE GERENCIAMENTO ACADÊMICO                                 |");
				System.out.println("|       0 - Desconhecida                                                   |");
				System.out.println("|       1 - Aberta                                                         |");
				System.out.println("|       2 - Ativa                                                          |");
				System.out.println("|       3 - Inativa                                                        |");
				System.out.println("|       4 - Concluída                                                      |");
				System.out.println("|       5 - Outra                                                          |");
				System.out.println("|                                                                          |");
				System.out.println("|__________________________________________________________________________|");
				System.out.printf("\n\t9- Digite a situação da disciplina: ");
				dado = ler.nextLine();
			} while(validarSituacao(dado) == false);

			int situacaoDisci = Integer.parseInt(dado);
			switch (situacaoDisci) {
			case 0:  
				disciplina.setSituacao("Desconhecida");
				System.out.println("\tSituação da disciplina: desconhecida");
				break;
			case 1: 
				disciplina.setSituacao("Aberta");
				System.out.println("\tSituação da disciplina: aberta");
				break;
			case 2:
				disciplina.setSituacao("Ativa");
				System.out.println("\tSituação da disciplina: ativa");
				break;
			case 3:
				disciplina.setSituacao("Inativa");
				System.out.println("\tSituação da disciplina: inativa");
				break;
			case 4:
				disciplina.setSituacao("Concluída");
				System.out.println("\tSituação da disciplina: concluída");
				break;
			case 5:
				do {
					System.out.println("Digite a siuação da disciplina: "
							+ "OBS: Apenas letras");
					dado = ler.nextLine();
					if(validarSit(dado)) {
						disciplina.setSituacao(dado);
						System.out.println("\tSituação da disciplina:" +dado);
					}
					else
						System.out.println("Dado inválido!");
					
				
				}while(validarCurso(dado) == false);
				break;
				
			default:
				break;
			}
		}
		System.out.printf("\n");
		do {
			System.out.printf("\n\t10- Digite a carga horária prática: ");
			dado = ler.nextLine();
			if(validarCargaHorariaPratica(dado)==true) {
				disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
			} else {
				do {
					System.out.println("\tDado inválido! Deve possuir apenas números positivos.");
					System.out.printf("\n\t10- Digite a carga horária prática: ");
					dado = ler.nextLine();
					validarCargaHorariaPratica(dado);
				}while(validarCargaHorariaPratica(dado)==false);
				disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
			}
			System.out.printf("\n\n\t11- Digite a carga horária teórica: ");
			dado = ler.nextLine();
			if(validarCargaHorariaPratica(dado)==true) {
				disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
			} else {
				do {
					System.out.println("\tDado inválido! Deve possuir apenas números positivos.");
					System.out.printf("\n\t11- Digite a carga horária teórica: ");
					dado = ler.nextLine();
					validarCargaHorariaTeorica(dado);
				}while(validarCargaHorariaTeorica(dado)==false);
				disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
			}
			validarCargaHorariaTotal(dado, disciplina);
			double soma=disciplina.getCargaHorariaPratica()+disciplina.getCargaHorariaTeorica();
			if(soma==0) {
				System.out.println("\n\t    A carga horária total não pode ser igual a zero. Tente novamente.\n");
			}
		}while(validarCargaHorariaTotal(dado, disciplina) == false);
		System.out.println("\n\t    Carga horária total: "+ disciplina.getCargaHorariaTotal());
		do {
			do {
				System.out.printf("\n\t CARGA HORÁRIA SEMANAL E MENSAL\n");
				menuOpcao();
				dado = ler.nextLine();
				switch(dado)
				{  
				case "1":
					System.out.printf("\n\n\t12- Digite a carga horária semanal: "); 
					dado = ler.nextLine();
					if(validarCargaHorariaSemanal(dado)==true) {
						disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
					} else {
						do {
							System.out.println("\tDado inválido! Deve possuir apenas números positivos.");
							System.out.printf("\n\t12- Digite a carga horária semanal: ");
							dado = ler.nextLine();
							validarCargaHorariaSemanal(dado);

						}while(validarCargaHorariaSemanal(dado)==false);
						disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
					}
					System.out.printf("\n\n\t13- Digite a carga horária mensal: "
							+ "\n Obs: A carga horária mensal deve ser maior que a carga horária semanal."); 
					dado = ler.nextLine();
					if(validarCargaHorariaMensal(dado, disciplina)==true) {
						disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
					} else {
						do {
							System.out.println("\tDado inválido! Deve possuir apenas números positivos.");
							System.out.printf("\n\t13- Digite a carga horária mensal: "
									+ "\n Obs: A carga horária mensal deve ser maior que a carga horária semanal.");
							dado = ler.nextLine();
							validarCargaHorariaMensal(dado, disciplina);
						}while(validarCargaHorariaMensal(dado, disciplina)==false);
						disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
					}
					if(disciplina.getCargaHorariaMensal() > 5*disciplina.getCargaHorariaSemanal()) {
						System.out.println("\n\t    A carga horária mensal não pode ser superior ao quintuplo da carga horária semanal. Tente novamente.");
					}
					auxiliar = 2;
					break;
				case "2":
					System.out.println("\n\t12-Não Cadastrado!");
					disciplina.setCargaHorariaSemanal(0);
					auxiliar = 2;
					break;  
				default:
					System.out.println("\tDado inválido!\n");
					auxiliar = 1;
				}
			}while( auxiliar == 1);
			
		}while(disciplina.getCargaHorariaMensal() > 5*disciplina.getCargaHorariaSemanal());
		System.out.println("\n\n\t\t     NÚMEROS DE CRÉDITOS"); 
		do {
			auxiliar =1;
			menuOpcao();
			System.out.printf("\n\t");
			dado = ler.nextLine();
			switch(dado){
			case "1": 
				validarNumCreditos(dado, disciplina);
				auxiliar = 2;
				System.out.println("\n\tNúmero de Créditos: "+ disciplina.getNumeroCreditos());
				break;
			case "2":
				
				disciplina.setNumeroCreditos(0);
				auxiliar = 2;
				System.out.println("\n\tNúmero de Créditos: "+ disciplina.getNumeroCreditos());
				break;
			default:
				System.out.println("\tDado inválido!");
			}  
		}while(auxiliar == 1);
		System.out.printf("\n");
		do {
			System.out.println("\n\tCUSTO AULA PRÁTICA");
			menuOpcao();
			System.out.printf("\n\t");
			dado = ler.nextLine();
			switch(dado)
			{  
			case "1":
				int help = 1;
				do {
					System.out.printf("\n\t14- Digite o custo da aula prática: ");
					dado = ler.nextLine();
					if(validarCustoPratica(dado)) {
						disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
						help = 2;
					}
					else {
						System.out.println("\tDado inválido. Apenas números são permitidos!");
						help = 1;
					}
				}while(help == 1);
				auxiliar = 2;
				break;
			case "2":
				System.out.println("\n\t14- Não Cadastrado");
				disciplina.setCustoBasicoPratica(0);
				auxiliar = 2;
				break;  
			default:
				System.out.println("\tDado inválido!\n");
				auxiliar = 1;
			}
		}while( auxiliar == 1);
		do {
			System.out.println("\n\tCUSTO AULA TEÓRICA");
			menuOpcao();
			System.out.printf("\n\t");
			dado = ler.nextLine();
			switch(dado)
			{  
			case "1":
				int help = 1;
				do {
					System.out.printf("\n\t14- Digite o custo da aula teórica: ");
					dado = ler.nextLine();
					if(validarCustoTeorica(dado)) {
						disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
						help = 2;
					}
					else {
						System.out.println("\tDado inválido. Apenas números são permitidos!");
						help = 1;
					}
				}while(help == 1);
				auxiliar = 2;
				break;
			case "2":
				System.out.println("\n\t14- Não Cadastrado");
				disciplina.setCustoBasicoTeorica(0);
				auxiliar = 2;
				break;  
			default:
				System.out.println("\tDado inválido!\n");
				auxiliar = 1;
			}
		}while( auxiliar == 1);


		System.out.printf("\n");

		disciplina.setCustoBasicoFixo(disciplina.getCustoBasicoPratica()+disciplina.getCustoBasicoTeorica());

		System.out.println("\n\tCusto fixo: " + disciplina.getCustoBasicoFixo());

		disciplinaDAO.cadastrar(disciplina);
	}

	private static void alterar() {
		ler = new Scanner(System.in);
		int leitura = -1;
		List<Disciplina> disciplinas;
		String chave = null;
		do {
			try {
				menuAlterar();
				leitura = Integer.parseInt(ler.nextLine());
			} catch(Exception e) {
				System.out.println("Valor Inválido, tente novamente com uma opção do menu.");
			}
		}while(leitura>3 || leitura<1);

		switch(leitura) {
		case 1: 
			disciplinas = disciplinaDAO.consultar("todos", null);
			exibirDados(disciplinas);
			System.out.printf("\tDigite o código da disciplina a ser alterada:\n\t"); //Somente números
			chave = ler.nextLine();
			for(Disciplina disciplina : disciplinas) {
				if(disciplina.getCodigo() == Integer.parseInt(chave)) {
					Disciplina disciplinaAlterada = alterarDados(disciplina);
					disciplinaDAO.alterar(disciplinaAlterada);	
				}
			}

			break;
		case 2: 
			try {
			
			System.out.printf("\tDigite o código da disciplina a ser alterada: \n\t"); //Somente números
			chave = ler.nextLine(); //try...catch
			disciplinas = disciplinaDAO.consultar("codigo", chave);
			
			if(disciplinas.size() == 1) {
				Disciplina disciplinaAlterada = alterarDados(disciplinas.get(0));
				disciplinaDAO.alterar(disciplinaAlterada);
			}
		} catch (NumberFormatException e) {
			System.out.println("Dado inválido! Esta opção só aceita números.");
		} catch (Exception e) {
			System.out.println("Dado inválido! Esta opção só aceita números.");
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
			try {
			System.out.printf("\tDigite o código da disciplina a ser excluída: \n\t"); // Somente número
			chave = Integer.parseInt(ler.nextLine());
			disciplinaDAO.excluir(chave);
			} catch (NumberFormatException e) {
				System.out.println("Dado inválido!");
			}
			break;
		case 2:
			try {
				System.out.printf("\tDigite o código da disciplina a ser excluída: \n\t"); // Somente número
				chave = Integer.parseInt(ler.nextLine());
				disciplinaDAO.excluir(chave);
				} catch (NumberFormatException e) {
					System.out.println("Dado inválido!");
				}
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
		System.out.printf("\tDigite um dos seguintes números para acessar: ");
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
			System.out.printf("\n");
			exibirDados(disciplinas);
			break;
		case 2:
			System.out.printf("\n\n\tDigite o código da disciplina: "); //Somente número
			chave = ler.nextLine();
			System.out.println();
			disciplinas = disciplinaDAO.consultar("codigo", chave);
			exibirDados(disciplinas);
			break;
		case 3:
			System.out.printf("\n\n\tDigite o nome completo da disciplina: "); //Somente Letras
			chave = ler.nextLine();
			System.out.println();
			disciplinas = disciplinaDAO.consultar("nomeCompleto", chave);
			exibirDados(disciplinas);
			break;
		case 4:
			System.out.printf("\n\n\tDigite o nome abreviado da disciplina: "); // 3 Dígitos no max e pelo menos uma letra
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
		System.out.println("|       2 - Consultar disciplina através do código                         |");
		System.out.println("|       3 - Consultar disciplina pelo nome completo                        |");
		System.out.println("|       4 - Consultar disciplina pelo nome abreviado                       |");
		System.out.println("|       5 - Sair                                                           |");
		System.out.println("|                                                                          |");
		System.out.println("|__________________________________________________________________________|");
		System.out.printf("\n\tDigite um dos seguintes números para acessar: ");
	}

	private static void exibirDados(List<Disciplina> disciplinas) {//OK
		if(disciplinas.size()>0) {
			for(Disciplina disciplina : disciplinas) {
				System.out.println(".__________________________________________________________________________.");
				System.out.println("|                                                                          ");
				System.out.println("|" + "Nome Completo.........................: " + disciplina.getNomeCompleto());
				System.out.println("|" + "Nome Abreviado........................: " + disciplina.getNomeAbreviado());
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
				System.out.println("|" + "Custo Básico Prática..................: " + "R$ " + disciplina.getCustoBasicoPratica());
				System.out.println("|" + "Custo Básico Teórica..................: " + "R$ " + disciplina.getCustoBasicoTeorica());
				System.out.println("|" + "Custo Fixo............................: " + "R$ " + disciplina.getCustoBasicoFixo());
				System.out.println("|_____________________________________________________________________________.");
				System.out.printf("\n\n");
			}
		} else {
			System.out.println("\tNenhuma disciplina foi encontrada com os parâmetros informados.\n\n");
		}
	}

	private static void menuAlterar() {//OK
		System.out.println(".__________________________________________________________________________.");
		System.out.println("|                                                                          |");
		System.out.println("|                                                                          |");
		System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
		System.out.println("|       1 - Listar todas as diciplinas antes de alterar                    |");
		System.out.println("|       2 - Alterar                                                        |");
		System.out.println("|       3 - Sair                                                           |");
		System.out.println("|                                                                          |");
		System.out.println("|__________________________________________________________________________|");
		System.out.printf("\tDigite um dos seguintes números para acessar: ");
	}

	private static Disciplina alterarDados(Disciplina disciplina) {//OK
		menuOpcaoAlterar();
		String dado;
		int leitura = Integer.parseInt(ler.nextLine());
		switch(leitura) {
		case 1 :
			System.out.printf("\tDigite o nome completo da disciplina: \n\t"); 
			dado = ler.nextLine();
			if(validarNome(dado)) {
				disciplina.setNomeCompleto(dado);
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 2 :
			System.out.printf("\tDigite o nome abreviado da disciplina: \n\t"); 
			dado = ler.nextLine();
			if(validarAbreviacao(dado)) {
				disciplina.setNomeAbreviado(dado);
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 3 :
			System.out.printf("\tDigite o nome do curso que a disciplina está vinculada:\n\t"); 
			dado = ler.nextLine();
			if(validarCurso(dado)) {
				disciplina.setCurso(dado);
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 4 :
			System.out.printf("\tDigite o nome do docente responsável pela disciplina: \n\t"); 
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteResponsavel(docente);
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 5 :
			System.out.printf("\tDigite o nome do docente auxiliar da disciplina: \n\t"); 
			dado = ler.nextLine();
			if(validarDocenteR(dado)) {
				Docente docente = new Docente();
				docente.setNome(dado);
				disciplina.setDocenteAuxiliar(docente);
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 6 :
			System.out.println("\tDigite o nome do técnico administrativo responsável da disciplina:");
			dado = ler.nextLine();
			if(validarTecnico(dado)) {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAdministrativoResponsavel(tecnico);
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 7 :
			System.out.println("\tDigite o nome do técnico administrativo auxiliar da disciplina: "); 
			dado = ler.nextLine();
			if(validarTecnico(dado)) {
				TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
				tecnico.setNome(dado);
				disciplina.setTecnicoAminAdministrativoAuxiliar(tecnico);
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 8 :
			System.out.println(".__________________________________________________________________________.");		
			System.out.println("|                                                                          |");
			System.out.println("|                                                                          |");
			System.out.println("|       SISTEMA DE GERENCIAMENTO ACADÊMICO                                 |");
			System.out.println("|       0 - Desconhecida                                                   |");
			System.out.println("|       1 - Aberta                                                         |");  
			System.out.println("|       2 - Ativa                                                          |");
			System.out.println("|       3 - Inativa                                                        |");
			System.out.println("|       4 - Concluída                                                      |");
			System.out.println("|       5 - Outra                                                          |");
			System.out.println("|                                                                          |");
			System.out.println("|__________________________________________________________________________|");
			System.out.printf("\tDigite a situação da disciplina:                               ");
			dado = ler.nextLine();
			if(validarSituacao(dado)) {
				int situacaoDisci = Integer.parseInt(dado);
				switch (situacaoDisci) {
				case 0:  
					disciplina.setSituacao("Desconhecida");
					break;
				case 1: 
					disciplina.setSituacao("Aberta");
					break;
				case 2:
					disciplina.setSituacao("Ativa");
					break;
				case 3:
					disciplina.setSituacao("Inativa");
					break;
				case 4:
					disciplina.setSituacao("Concluída");
					break;
				case 5:
					do {
						System.out.println("Digite a siuação da disciplina: "
								+ "OBS: Apenas letras");
						dado = ler.nextLine();
						if(validarSit(dado)) {
							disciplina.setSituacao(dado);
							System.out.println("\tSituação da disciplina:" +dado);
						}
						else
							System.out.println("Dado inválido!");
						
					
					}while(validarCurso(dado) == false);
					break;
				
				default:
					break;
				}
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 9 :
			System.out.println("\tDigite a carga horária prática: "); 
			dado = ler.nextLine();
			if(validarCargaHorariaPratica(dado)) {
				disciplina.setCargaHorariaPratica(Integer.parseInt(dado));
				disciplina.setCargaHorariaTotal(disciplina.getCargaHorariaTeorica() + disciplina.getCargaHorariaPratica());
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 10 :
			System.out.println("\tDigite a carga horária teórica: "); 
			dado = ler.nextLine();
			if(validarCargaHorariaTeorica(dado)) {
				disciplina.setCargaHorariaTeorica(Integer.parseInt(dado));
				disciplina.setCargaHorariaTotal(disciplina.getCargaHorariaTeorica() + disciplina.getCargaHorariaPratica());
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;
		case 11 :
			System.out.println("\tDigite a carga horária semanal: ");  
			dado = ler.nextLine();
			if(validarCargaHorariaSemanal(dado)) {
				disciplina.setCargaHorariaSemanal(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;

		case 12 :
			System.out.println("\tDigite a carga horária mensal: ");// somente número
			dado = ler.nextLine();
			if(validarCargaHorariaMensal(dado, disciplina) ) {
				disciplina.setCargaHorariaMensal(Integer.parseInt(dado));
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;

		case 13 :
			try {
				System.out.println("\tDigite o número de créditos:");// somente número
				dado = ler.nextLine();
				if(validarNumCreditos(dado, disciplina)) {
					disciplina.setNumeroCreditos(Integer.parseInt(dado));
				} else {
					System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Dado inválido! Essa opção aceita apenas números.");
			} catch (Exception e) {
				System.out.println("Dado inválido! Essa opção aceita apenas números.");
			}
			break;

		case 14 :
			System.out.println("\tDigite o custo prática: ");// somente número
			dado = ler.nextLine();
			if(validarCustoPratica(dado)) {
				disciplina.setCustoBasicoPratica(Integer.parseInt(dado));
				disciplina.setCustoBasicoFixo(disciplina.getCustoBasicoPratica() + disciplina.getCustoBasicoTeorica());
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;

		case 15 :
			System.out.println("\tDigite o custo teórica: ");// somente número
			dado = ler.nextLine();
			if(validarCustoTeorica(dado)) {
				disciplina.setCustoBasicoTeorica(Integer.parseInt(dado));
				disciplina.setCustoBasicoFixo(disciplina.getCustoBasicoPratica() + disciplina.getCustoBasicoTeorica());
			} else {
				System.out.println("\tDado não alterado, pois o paramêtro passado é inválido!");
			}
			break;

		}
		return disciplina;
	}

	private static boolean validarCustoTeorica(String dado) {//OK
		int testeDeLetras;
		boolean validaçao;
		try {
			testeDeLetras = Integer.parseInt(dado);
			if(testeDeLetras >= 0) {
				validaçao = true;
			}
			else {
				validaçao = false;
			}				
		}
		catch(NumberFormatException erro) {
			validaçao = false;
		}
		return validaçao;
	}

	private static boolean validarCustoPratica(String dado) {//OK
		int testeDeLetras;
		boolean validaçao;
		try {
			testeDeLetras = Integer.parseInt(dado);
			if(testeDeLetras >= 0) {
				validaçao = true;
			}
			else {
				validaçao = false;
			}				
		}
		catch(NumberFormatException erro) {
			validaçao = false;
		}
		return validaçao;
	}

	private static boolean validarNumCreditos(String dado, Disciplina disciplina) {//OK
		double resultado;
		double resto;
		int unicoCredito = 16;
		resto = disciplina.getCargaHorariaTotal() % unicoCredito;
		resultado = (disciplina.getCargaHorariaTotal() - resto) / unicoCredito;
		disciplina.setNumeroCreditos(resultado);
		return true;
	}

	private static boolean validarCargaHorariaTotal(String dado, Disciplina disciplina) {//OK
		double cargaPratica = disciplina.getCargaHorariaPratica();
		double cargaTeorica = disciplina.getCargaHorariaTeorica();
		double cargaTotal = cargaPratica + cargaTeorica;
		disciplina.setCargaHorariaTotal(cargaTotal);
		boolean confirmaçao;
		if(cargaTotal != 0) {
			confirmaçao = true;
		}
		else {
			confirmaçao = false;
		}
		return confirmaçao;
	}

	private static boolean validarCargaHorariaMensal(String dado, Disciplina disciplina) {//OK
		int testeTamanho = dado.length();
		boolean confirmaçao;
		boolean validaçao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			if(testeDeLetras > disciplina.getCargaHorariaSemanal()) {
				validaçao = true;
			}
			else {
				validaçao = false;
			}				
		}
		catch(NumberFormatException erro) {
			validaçao = false;
		}
		if(testeTamanho>0 && validaçao == true) {
			confirmaçao = true;
		}
		else {
			confirmaçao = false;
		}
		return confirmaçao;
	}

	private static boolean validarCargaHorariaSemanal(String dado) {//OK
		int testeTamanho = dado.length();
		boolean confirmaçao;
		boolean validaçao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			if(testeDeLetras > 0) {
				validaçao = true;
			}
			else {
				validaçao = false;
			}				
		}
		catch(NumberFormatException erro) {
			validaçao = false;
		}
		if(testeTamanho>0 && validaçao == true ) {
			confirmaçao = true;
		}
		else {
			confirmaçao = false;
		}
		return confirmaçao;
	}

	private static boolean validarCargaHorariaTeorica(String dado) {//OK
		int testeTamanho = dado.length();
		boolean confirmaçao;
		boolean validaçao;
		int testeDeLetras;
		double soma;
		try {
			testeDeLetras = Integer.parseInt(dado);
			if(testeDeLetras >= 0) {
				validaçao = true;
			}
			else {
				validaçao = false;
			}				
		}
		catch(NumberFormatException erro) {
			validaçao = false;
		}
		if(testeTamanho>0 && validaçao == true) {
			confirmaçao = true;
		}
		else {
			confirmaçao = false;
		}
		return confirmaçao;
	}

	private static boolean validarCargaHorariaPratica(String dado) {//OK
		int testeTamanho = dado.length();
		boolean confirmaçao;
		boolean validaçao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			if(testeDeLetras >= 0) {
				validaçao = true;
			}
			else {
				validaçao = false;
			}				
		}
		catch(NumberFormatException erro) {
			validaçao = false;
		}
		if(testeTamanho>0 && validaçao == true) {
			confirmaçao = true;
		}
		else {
			confirmaçao = false;
		}
		return confirmaçao;
	}

	private static boolean validarSituacao(String dado) {//OK
		boolean validaçao;
		try {
			if(Integer.parseInt(dado)>=0 && Integer.parseInt(dado)<6) {
				validaçao = true;
			}
			else {
				validaçao = false;
			}				
		}
		catch(NumberFormatException erro) {
			validaçao = false;
		}
		return validaçao;
	}

	private static boolean validarTecnico(String dado) {//OK
		return dado.matches("[a-zA-Z\\u0020\u00e1\u00e0\u00e2\u00e3\u00e4\u00c1\u00c0\u00c2\u00c3\u00c4"
				+ "\u00e9\u00e8\u00ea\u00ea\u00c9\u00c8\u00ca\u00cb\u00ed\u00ec\u00ee\u00ef\u00cd\u00cc\u00ce"
				+ "\u00cf\u00f3\u00f2\u00f4\u00f5\u00f6\u00d3\u00d2\u00d4\u00d5\u00d6\u00fa\u00f9\u00fb\u00fc"
				+ "\u00da\u00d9\u00db\u00e7\u00c7]+") && !dado.equals(null) && !dado.equals(" ");
	}

	private static boolean validarDocenteR(String dado) {//OK
		return dado.matches("[a-zA-Z\\u0020\u00e1\u00e0\u00e2\u00e3\u00e4\u00c1\u00c0\u00c2\u00c3\u00c4"
				+ "\u00e9\u00e8\u00ea\u00ea\u00c9\u00c8\u00ca\u00cb\u00ed\u00ec\u00ee\u00ef\u00cd\u00cc\u00ce"
				+ "\u00cf\u00f3\u00f2\u00f4\u00f5\u00f6\u00d3\u00d2\u00d4\u00d5\u00d6\u00fa\u00f9\u00fb\u00fc"
				+ "\u00da\u00d9\u00db\u00e7\u00c7]+") && !dado.equals(null) && !dado.equals(" ");
	}

	private static boolean validarCurso(String dado) {//OK
		return dado.matches("[a-zA-Z\\u0020\u00e1\u00e0\u00e2\u00e3\u00e4\u00c1\u00c0\u00c2\u00c3\u00c4"
				+ "\u00e9\u00e8\u00ea\u00ea\u00c9\u00c8\u00ca\u00cb\u00ed\u00ec\u00ee\u00ef\u00cd\u00cc\u00ce"
				+ "\u00cf\u00f3\u00f2\u00f4\u00f5\u00f6\u00d3\u00d2\u00d4\u00d5\u00d6\u00fa\u00f9\u00fb\u00fc"
				+ "\u00da\u00d9\u00db\u00e7\u00c7]+") && !dado.equals(null) && !dado.equals(" ");
	}
	
	private static boolean validarSit(String dado) {//OK
		return dado.matches("[a-zA-Z\\u0020\u00e1\u00e0\u00e2\u00e3\u00e4\u00c1\u00c0\u00c2\u00c3\u00c4"
				+ "\u00e9\u00e8\u00ea\u00ea\u00c9\u00c8\u00ca\u00cb\u00ed\u00ec\u00ee\u00ef\u00cd\u00cc\u00ce"
				+ "\u00cf\u00f3\u00f2\u00f4\u00f5\u00f6\u00d3\u00d2\u00d4\u00d5\u00d6\u00fa\u00f9\u00fb\u00fc"
				+ "\u00da\u00d9\u00db\u00e7\u00c7]+") && !dado.equals(null) && !dado.equals(" ");
	}

	private static boolean validarAbreviacao(String dado) {//OK
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

	private static boolean validarNome(String dado) {//OK
		boolean confirmaçao;
		int testeTamanho;
		testeTamanho = dado.length();
		boolean validaçao;
		int testeDeLetras;
		try {
			testeDeLetras = Integer.parseInt(dado);
			validaçao = false;
		}
		catch(NumberFormatException erro) {
			validaçao = true;
		}
		if(testeTamanho>0 && validaçao == true) {
			confirmaçao = true;
		}
		else {
			confirmaçao = false;
		}
		return confirmaçao;
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

	private static void menuOpcaoAlterar() {//OK
		System.out.println(".__________________________________________________________________________.");
		System.out.println("|                                                                          |");
		System.out.println("|                                                                          |");
		System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
		System.out.println("|        1 - Alterar Nome Completo                                         |");
		System.out.println("|        2 - Alterar Nome Abreviado                                        |");
		System.out.println("|        3 - Alterar Curso                                                 |"); 
		System.out.println("|        4 - Alterar Docente Responsável                                   |");
		System.out.println("|        5 - Alterar Docente Auxiliar                                      |");
		System.out.println("|        6 - Alterar Técnico Administrativo Responsável                    |");
		System.out.println("|        7 - Alterar Técnico Administrativo Auxiliar                       |");
		System.out.println("|        8 - Alterar Situação                                              |");
		System.out.println("|        9 - Alterar Carga Horária Prática                                 |");
		System.out.println("|       10 - Alterar Carga Horária Teórica                                 |");
		System.out.println("|       11 - Alterar Carga Horária Semanal                                 |");
		System.out.println("|       12 - Alterar Carga Horária Mensal                                  |");
		System.out.println("|       13 - Alterar Número de Créditos                                    |");
		System.out.println("|       14 - Alterar Custo Basico Prática                                  |");
		System.out.println("|       15 - Alterar Custo Basico Teórica                                  |");
		System.out.println("|                                                                          |");
		System.out.println("|__________________________________________________________________________|");
		System.out.printf("\tDigite um dos seguintes números para acessar: ");
	}

	private static void menuOpcao() {//OK

		System.out.println(".__________________________________________________________________________.");
		System.out.println("|                                                                          |");
		System.out.println("|                                                                          |");
		System.out.println("|       SISTEMA DE GERENCIAMENTO ACADEMICO                                 |");
		System.out.println("|       Deseja adicionar alguma informação neste campo?                    |");
		System.out.println("|        1 - Sim                                                           |");
		System.out.println("|        2 - Não                                                           |");
		System.out.println("|                                                                          |");
		System.out.println("|__________________________________________________________________________|");	

	}

	public static boolean checkLetters(String str) //OK
	{
		return str.matches("[a-zA-Z\\u0020]+");
	}

}
