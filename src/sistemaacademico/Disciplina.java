package sistemaacademico;
import java.util.Scanner;
import java.io.Serializable;
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
public class Disciplina implements Serializable {
		
		int 							codigo;
		String                             situacao;
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
	    Docente	                        docenteAuxiliar;        // Null = docente inexistente
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

	    
	    	
	    public Disciplina() {
	    	this.docenteResponsavel = new Docente();
	    	this.docenteAuxiliar= new Docente();
	    	this.tecnicoAdministrativoResponsavel = new TecnicoAdministrativo();
	    	this.tecnicoAminAdministrativoAuxiliar = new TecnicoAdministrativo();
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
		
		public String getSituacao() {
			return situacao;
		}

		public void setSituacao(String situacao) {
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
		
}


