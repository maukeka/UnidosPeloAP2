package sistemaacademico;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.InputMismatchException;
import java.util.Iterator;
/**
 * 
 * @author 	Eduardo César Freitas da Silva Filho
 * @author	Laís Ribeiro Torres 
 * @author	Marcos Paulo da Carvalho Araújo
 * @author 	Mauricio Kenichi Kanashiro
 * @author 	Rodolfo Pereira Lemos
 * @author 	Samuel dos Santos Nogueira
 * 
 * Nome.......: Disciplina
 * Descrição..: Classe que armazena informações de disciplinas passadas pelo usuário a partir de um array
 * Observações: O objeto não é criado nessa classe
 * 
 * 
 */
public class Disciplina {

	int 							codigo;
	int 							vinculado;
	int 							remover;
	int 							auxiliar =1;


	Scanner 						seEhVinculado = new Scanner(System.in);
	Scanner 						lerCurso = new Scanner(System.in);
	Scanner 						lerExclusao = new Scanner(System.in);
	Scanner 						lerId = new Scanner(System.in);

	String                          situacao;
	String 							nomeCompleto;
	String 							nomeAbreviado;
	String                          curso;                  

	Docente                         docenteResponsavel;    
	Docente	                        docenteAuxiliar;        
	TecnicoAdministrativo           tecnicoAdministrativoResponsavel; 
	TecnicoAdministrativo           tecnicoAminAdministrativoAuxiliar; 

	double                          numeroCreditos;        
	double                          cargaHorariaTotal;      
	double                          cargaHorariaTeorica;
	double                          cargaHorariaPratica;
	double                          cargaHorariaSemanal;    
	double                          cargaHorariaMensal;      
	double                          custoBasicoFixo;        
	double                          custoBasicoTeorica;     
	double                          custoBasicoPratica;     


	/**
	 * 
	 */
	public Disciplina() {
		this.docenteResponsavel = new Docente();
		this.docenteAuxiliar= new Docente();
		this.tecnicoAdministrativoResponsavel = new TecnicoAdministrativo();
		this.tecnicoAminAdministrativoAuxiliar = new TecnicoAdministrativo();
	}

	/**
	 * Método que pega um código contido no array de disciplina
	 * 
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}


	/**
	 * Método que implementa o código passado pelo usuário
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	/**
	 * Método que pega o nome completo da disciplina contido no array de disciplina.
	 * 
	 * @return
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}


	/**
	 * Método que implementa o nome completo da disciplina passado pelo usuário.
	 * 
	 * @param nomeCompleto
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	/**
	 * Método que pega o nome abreviado da disciplina contido no array de disciplina.
	 * 
	 * @return
	 */
	public String getNomeAbreviado() {
		return nomeAbreviado;
	}


	/**
	 * Método que pega implementa o nome abreviado da disciplina passado pelo usuário.
	 * 
	 * @param nomeAbreviado
	 */
	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;	
	}
	
	/**
	 * Método que pega a situação da disciplina contida no array de disciplina.
	 * 
	 * @return
	 */
	public String getSituacao() {
		return situacao;
	}
	
	/**
	 * Método que implementa a situação da disciplina passado pelo usuário.
	 * 
	 * @param situacao
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	/**
	 * Método que pega o curso da disciplina contido no array de disciplina.
	 * 
	 * @return
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 * Método que implementa o curso da disciplina passado pelo usuário.
	 * 
	 * @param curso
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * Método que pega o docente responsável no array de disciplina.
	 * 	
	 * @return
	 */
	public Docente getDocenteResponsavel() {
		return docenteResponsavel;
	}

	/**
	 * Método que implementa o docente responsável passado pelo usuário.
	 * 
	 */
	public void setDocenteResponsavel(Docente docenteResponsavel) {
		this.docenteResponsavel = docenteResponsavel;
	}
	
	/**
	 * Método que pega o docente auxiliar contido array de disciplina.
	 * 
	 * @return
	 */
	public Docente getDocenteAuxiliar() {
		return docenteAuxiliar;
	}
	
	/**
	 * Método que implementa o docente auxiliar passado pelo usuário.
	 * 
	 * @param docenteAuxiliar
	 */
	public void setDocenteAuxiliar(Docente docenteAuxiliar) {
		this.docenteAuxiliar = docenteAuxiliar;
	}
	
	/**
	 * Método que pega o técnico administrativo contido no array de disciplina.
	 * 
	 * @return
	 */
	public TecnicoAdministrativo getTecnicoAdministrativoResponsavel() {
		return tecnicoAdministrativoResponsavel;
	}
	
	/**
	 * Método que implementa o técnico administrativo passado pelo usuário.
	 * 
	 * @param tecnicoAdministrativoResponsavel
	 */
	public void setTecnicoAdministrativoResponsavel(TecnicoAdministrativo tecnicoAdministrativoResponsavel) {
		this.tecnicoAdministrativoResponsavel = tecnicoAdministrativoResponsavel;
	}
	
	/**
	 * Método que pega o técnico administrativo auxiliar contido no array de disciplina.
	 * 
	 * @return
	 */
	public TecnicoAdministrativo getTecnicoAminAdministrativoAuxiliar() {
		return tecnicoAminAdministrativoAuxiliar;
	}
	
	/**
	 * Método que implementa o técnico administrativo auxiliar passado pelo usuário.
	 * 
	 * @param tecnicoAminAdministrativoAuxiliar
	 */
	public void setTecnicoAminAdministrativoAuxiliar(TecnicoAdministrativo tecnicoAminAdministrativoAuxiliar) {
		this.tecnicoAminAdministrativoAuxiliar = tecnicoAminAdministrativoAuxiliar;
	}
	
	/**
	 * Método que pega o número de créditos contido no array de disciplina.
	 * 
	 * @return
	 */
	public double getNumeroCreditos() {
		return numeroCreditos;
	}
	
	/**
	 * Método que implementa o número de créditos passado pelo usuário.
	 * 
	 * @param numeroCreditos
	 */
	public void setNumeroCreditos(double numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	
	/**
	 * Método que pega a carga horária total contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}
	
	/**
	 * Método que implementa a carga horária total passada pelo usuário.
	 * 
	 * @param cargaHorariaTotal
	 */
	public void setCargaHorariaTotal(double cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}
	
	/**
	 * Método que pega a carga horária teórica contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaTeorica() {
		return cargaHorariaTeorica;
	}
	
	/**
	 * Método que implementa a carga horária teórica passada pelo usuário.
	 * 
	 * @param cargaHorariaTeorica
	 */
	public void setCargaHorariaTeorica(double cargaHorariaTeorica) {
		this.cargaHorariaTeorica = cargaHorariaTeorica;
	}
	
	/**
	 * Método que pega a carga horária prática contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaPratica() {
		return cargaHorariaPratica;
	}
	
	/**
	 * Método que implementa a carga horária passada pelo usuário.
	 * 
	 * @param cargaHorariaPratica
	 */
	public void setCargaHorariaPratica(double cargaHorariaPratica) {
		this.cargaHorariaPratica = cargaHorariaPratica;
	}
	
	/**
	 * Método que pega a carga horária semanal contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}
	
	/**
	 * Método que implementa a carga horária semanal passada pelo usuário.
	 * 
	 * @param cargaHorariaSemanal
	 */
	public void setCargaHorariaSemanal(double cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}
	
	/**
	 * Método que pega a carga horária mensal contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaMensal() {
		return cargaHorariaMensal;
	}
	
	/**
	 * Método que implementa a carga horária mensal passada pelo usuário.
	 * 
	 * @param cargaHorariaMensal
	 */
	public void setCargaHorariaMensal(double cargaHorariaMensal) {
		this.cargaHorariaMensal = cargaHorariaMensal;
	}
	
	/**
	 * Método que pega o custo fixo determinado no main.
	 * 
	 * @return
	 */
	public double getCustoBasicoFixo() {
		return custoBasicoFixo;
	}
	
	/**
	 * Método que implementa o custo fixo determinado no main.
	 * 
	 */
	public void setCustoBasicoFixo(double custoBasicoFixo) {
		this.custoBasicoFixo = custoBasicoFixo;
	}
	
	/**
	 * Método que pega o custo teórica contido no array de disciplina.
	 * 
	 * @return
	 */
	public double getCustoBasicoTeorica() {
		return custoBasicoTeorica;
	}
	
	/**
	 * Método que implementa o custo teórica passado pelo usuário.
	 * 
	 * @param custoBasicoTeorica
	 */
	public void setCustoBasicoTeorica(double custoBasicoTeorica) {
		this.custoBasicoTeorica = custoBasicoTeorica;
	}
	
	/**
	 * Método que pega o custo prática contido no array de disciplina.
	 * 
	 * @return
	 */
	public double getCustoBasicoPratica() {
		return custoBasicoPratica;
	}
	
	/**
	 * Método que implementa o custo prática passado pelo usuário
	 * 
	 * @param custoBasicoPratica
	 */
	public void setCustoBasicoPratica(double custoBasicoPratica) {
		this.custoBasicoPratica = custoBasicoPratica;
	}

}


