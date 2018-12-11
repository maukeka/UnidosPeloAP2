package sistemaacademico;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.InputMismatchException;
import java.util.Iterator;
/**
 *
 * @author Wanderley de Souza Alencar
 */
/*
* Nome.......: Disciplina
* Objetivo...: Representar uma disciplina na instituiÃ§Ã£o de ensino
* Observacoes:
*/
public class Disciplina extends Coisa {
		
		public Disciplina() {
			super();
			// TODO Auto-generated constructor stub
		}
		int 							codigo;
		int                             situacao;
		int 							vinculado;
	
	
		int 							remover;
		int 							auxiliar =1;
		
		
		Scanner 						seEhVinculado = new Scanner(System.in);
	    Scanner 						lerCurso = new Scanner(System.in);
	    Scanner 						lerExclusao = new Scanner(System.in);
	    Scanner 						lerId = new Scanner(System.in);
	    String 							nomeCompleto;
	    String 							nomeAbreviado;
	    String                          curso;                  // 0 (zero) para disciplina sem curso vinculado
	    Docente                         docenteResponsavel;     // Informação obrigatória
	    Docente                         docenteAuxiliar;        // Null = docente inexistente
	    TecnicoAdministrativo           tecnicoAdministrativoResponsavel; // Null = TA inexistente
	    TecnicoAdministrativo           tecnicoAminAdministrativoAuxiliar; // Null = TA inexistente
	    
	    double                          numeroCreditos;        // 0 - Não informada (Ã© opcional informar)
	    double                          cargaHorariaTotal;      
	    double                          cargaHorariaTeorica;
	    double                          cargaHorariaPratica;
	    double                          cargaHorariaSemanal;    // Opcional informar
	    double                          cargaHorariaMensal;     // Opcional informar
	    
	    double                          custoFixo;              // Todos são opcionais...
	    double                          custoBasicoTeorica;     // Valores em Reais (R$)
	    double                          custoBasicoPratica;     //

	   
	     ArrayList<Disciplina> listaDeDisciplina = new ArrayList<Disciplina>();
	   
	    
	    	
	    public Disciplina(ArrayList<Disciplina> listaDeDisciplina) {
			super();
			
			this.listaDeDisciplina = listaDeDisciplina;
		}

	    
		public int getCodigo() {
			return codigo;
		}



		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}



		public String getNomeCompleto() {
			return nomeCompleto;
		}



		public void setNomeCompleto(String nomeCompleto) {
			this.nomeCompleto = nomeCompleto;
		}



		public String getNomeAbreviado() {
			return nomeAbreviado;
		}



		public void setNomeAbreviado(String nomeAbreviado) {
			this.nomeAbreviado = nomeAbreviado;	
		}
		
	    @Override
	    public void cadastrar() {
	    	listaDeDisciplina.add(this);
	    	
	    	
	    	
	    	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public void alterar(int codigo) {
	    
	    	System.out.println("Digite o curso que deseja colocar no lugar: ");
	    	curso = lerCurso.next();
	    	
	    	
	    	System.out.println(Arrays.toString( listaDeDisciplina.toArray() ));	
	    	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    
	    }

	    @Override
	    public void consultar(int codigo) {
	    	
	    	try {
	            
	            System.out.println(listaDeDisciplina.get(codigo));
	            
	          } catch (IndexOutOfBoundsException e) {
	          	
	              System.out.printf("\nErro: posição inválida.",
	                e.getMessage());
	              
	          }
	    	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    	System.out.println(Arrays.toString( listaDeDisciplina.toArray() ));
	    }

	   
	    @Override
		public void excluir(int codigo) {
	    	while(codigo != -1) {
	    		
	    		System.out.println(Arrays.toString( listaDeDisciplina.toArray() ));
	         
	            try {
	              
	              listaDeDisciplina.remove(codigo);
	              
	            } catch (IndexOutOfBoundsException e) {
	            	
	                System.out.printf("\nErro: posição inválida.",
	                  e.getMessage());
	                
	            }
	            
	        	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	            System.out.println(Arrays.toString( listaDeDisciplina.toArray() ));
	    	}
			
		}
		public int getSituacao() {
			return situacao;
		}

		public void setSituacao(int situacao) {
			this.situacao = situacao;
		}

		public String getCurso() {
			return curso;
		}

		public void setCurso(String curso) {
			this.curso = curso;
		}

		public Docente getDocenteResponsavel() {
			return docenteResponsavel;
		}

		public void setDocenteResponsavel(Docente docenteResponsavel) {
			this.docenteResponsavel = docenteResponsavel;
		}

		public Docente getDocenteAuxiliar() {
			return docenteAuxiliar;
		}

		public void setDocenteAuxiliar(Docente docenteAuxiliar) {
			this.docenteAuxiliar = docenteAuxiliar;
		}

		public TecnicoAdministrativo getTecnicoAdministrativoResponsavel() {
			return tecnicoAdministrativoResponsavel;
		}

		public void setTecnicoAdministrativoResponsavel(TecnicoAdministrativo tecnicoAdministrativoResponsavel) {
			this.tecnicoAdministrativoResponsavel = tecnicoAdministrativoResponsavel;
		}

		public TecnicoAdministrativo getTecnicoAminAdministrativoAuxiliar() {
			return tecnicoAminAdministrativoAuxiliar;
		}

		public void setTecnicoAminAdministrativoAuxiliar(TecnicoAdministrativo tecnicoAminAdministrativoAuxiliar) {
			this.tecnicoAminAdministrativoAuxiliar = tecnicoAminAdministrativoAuxiliar;
		}

		public double getNumeroCreditos() {
			return numeroCreditos;
		}

		public void setNumeroCreditos(double numeroCreditos) {
			this.numeroCreditos = numeroCreditos;
		}

		public double getCargaHorariaTotal() {
			return cargaHorariaTotal;
		}

		public void setCargaHorariaTotal(double cargaHorariaTotal) {
			this.cargaHorariaTotal = cargaHorariaTotal;
		}

		public double getCargaHorariaTeorica() {
			return cargaHorariaTeorica;
		}

		public void setCargaHorariaTeorica(double cargaHorariaTeorica) {
			this.cargaHorariaTeorica = cargaHorariaTeorica;
		}

		public double getCargaHorariaPratica() {
			return cargaHorariaPratica;
		}

		public void setCargaHorariaPratica(double cargaHorariaPratica) {
			this.cargaHorariaPratica = cargaHorariaPratica;
		}

		public double getCargaHorariaSemanal() {
			return cargaHorariaSemanal;
		}

		public void setCargaHorariaSemanal(double cargaHorariaSemanal) {
			this.cargaHorariaSemanal = cargaHorariaSemanal;
		}

		public double getCargaHorariaMensal() {
			return cargaHorariaMensal;
		}

		public void setCargaHorariaMensal(double cargaHorariaMensal) {
			this.cargaHorariaMensal = cargaHorariaMensal;
		}

		public double getCustoFixo() {
			return custoFixo;
		}

		public void setCustoFixo(double custoFixo) {
			this.custoFixo = custoFixo;
		}

		public double getCustoBasicoTeorica() {
			return custoBasicoTeorica;
		}

		public void setCustoBasicoTeorica(double custoBasicoTeorica) {
			this.custoBasicoTeorica = custoBasicoTeorica;
		}

		public double getCustoBasicoPratica() {
			return custoBasicoPratica;
		}

		public void setCustoBasicoPratica(double custoBasicoPratica) {
			this.custoBasicoPratica = custoBasicoPratica;
		}

		@Override
		public String toString() {
			return "Disciplina [situacao=" + situacao + ", curso=" + curso + ", docenteResponsavel=" + docenteResponsavel
					+ ", docenteAuxiliar=" + docenteAuxiliar + ", tecnicoAdministrativoResponsavel="
					+ tecnicoAdministrativoResponsavel + ", tecnicoAminAdministrativoAuxiliar="
					+ tecnicoAminAdministrativoAuxiliar + ", numeroCreditos=" + numeroCreditos + ", cargaHorariaTotal="
					+ cargaHorariaTotal + ", cargaHorariaTeorica=" + cargaHorariaTeorica + ", cargaHorariaPratica="
					+ cargaHorariaPratica + ", cargaHorariaSemanal=" + cargaHorariaSemanal + ", cargaHorariaMensal="
					+ cargaHorariaMensal + ", custoFixo=" + custoFixo + ", custoBasicoTeorica=" + custoBasicoTeorica
					+ ", custoBasicoPratica=" + custoBasicoPratica + "]";
		}
}


