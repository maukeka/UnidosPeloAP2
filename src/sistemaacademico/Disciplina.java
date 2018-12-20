package sistemaacademico;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.InputMismatchException;
import java.util.Iterator;
/**
 * 
 * @author 	Eduardo C�sar Freitas da Silva Filho
 * @author	La�s Ribeiro Torres 
 * @author	Marcos Paulo da Carvalho Ara�jo
 * @author 	Mauricio Kenichi Kanashiro
 * @author 	Rodolfo Pereira Lemos
 * @author 	Samuel dos Santos Nogueira
 * 
 * Nome.......: Disciplina
 * Descri��o..: Classe que armazena informa��es de disciplinas passadas pelo usu�rio a partir de um array
 * Observa��es: O objeto n�o � criado nessa classe
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
	 * M�todo que pega um c�digo contido no array de disciplina
	 * 
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}


	/**
	 * M�todo que implementa o c�digo passado pelo usu�rio
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	/**
	 * M�todo que pega o nome completo da disciplina contido no array de disciplina.
	 * 
	 * @return
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}


	/**
	 * M�todo que implementa o nome completo da disciplina passado pelo usu�rio.
	 * 
	 * @param nomeCompleto
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	/**
	 * M�todo que pega o nome abreviado da disciplina contido no array de disciplina.
	 * 
	 * @return
	 */
	public String getNomeAbreviado() {
		return nomeAbreviado;
	}


	/**
	 * M�todo que pega implementa o nome abreviado da disciplina passado pelo usu�rio.
	 * 
	 * @param nomeAbreviado
	 */
	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;	
	}
	
	/**
	 * M�todo que pega a situa��o da disciplina contida no array de disciplina.
	 * 
	 * @return
	 */
	public String getSituacao() {
		return situacao;
	}
	
	/**
	 * M�todo que implementa a situa��o da disciplina passado pelo usu�rio.
	 * 
	 * @param situacao
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	/**
	 * M�todo que pega o curso da disciplina contido no array de disciplina.
	 * 
	 * @return
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 * M�todo que implementa o curso da disciplina passado pelo usu�rio.
	 * 
	 * @param curso
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * M�todo que pega o docente respons�vel no array de disciplina.
	 * 	
	 * @return
	 */
	public Docente getDocenteResponsavel() {
		return docenteResponsavel;
	}

	/**
	 * M�todo que implementa o docente respons�vel passado pelo usu�rio.
	 * 
	 */
	public void setDocenteResponsavel(Docente docenteResponsavel) {
		this.docenteResponsavel = docenteResponsavel;
	}
	
	/**
	 * M�todo que pega o docente auxiliar contido array de disciplina.
	 * 
	 * @return
	 */
	public Docente getDocenteAuxiliar() {
		return docenteAuxiliar;
	}
	
	/**
	 * M�todo que implementa o docente auxiliar passado pelo usu�rio.
	 * 
	 * @param docenteAuxiliar
	 */
	public void setDocenteAuxiliar(Docente docenteAuxiliar) {
		this.docenteAuxiliar = docenteAuxiliar;
	}
	
	/**
	 * M�todo que pega o t�cnico administrativo contido no array de disciplina.
	 * 
	 * @return
	 */
	public TecnicoAdministrativo getTecnicoAdministrativoResponsavel() {
		return tecnicoAdministrativoResponsavel;
	}
	
	/**
	 * M�todo que implementa o t�cnico administrativo passado pelo usu�rio.
	 * 
	 * @param tecnicoAdministrativoResponsavel
	 */
	public void setTecnicoAdministrativoResponsavel(TecnicoAdministrativo tecnicoAdministrativoResponsavel) {
		this.tecnicoAdministrativoResponsavel = tecnicoAdministrativoResponsavel;
	}
	
	/**
	 * M�todo que pega o t�cnico administrativo auxiliar contido no array de disciplina.
	 * 
	 * @return
	 */
	public TecnicoAdministrativo getTecnicoAminAdministrativoAuxiliar() {
		return tecnicoAminAdministrativoAuxiliar;
	}
	
	/**
	 * M�todo que implementa o t�cnico administrativo auxiliar passado pelo usu�rio.
	 * 
	 * @param tecnicoAminAdministrativoAuxiliar
	 */
	public void setTecnicoAminAdministrativoAuxiliar(TecnicoAdministrativo tecnicoAminAdministrativoAuxiliar) {
		this.tecnicoAminAdministrativoAuxiliar = tecnicoAminAdministrativoAuxiliar;
	}
	
	/**
	 * M�todo que pega o n�mero de cr�ditos contido no array de disciplina.
	 * 
	 * @return
	 */
	public double getNumeroCreditos() {
		return numeroCreditos;
	}
	
	/**
	 * M�todo que implementa o n�mero de cr�ditos passado pelo usu�rio.
	 * 
	 * @param numeroCreditos
	 */
	public void setNumeroCreditos(double numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	
	/**
	 * M�todo que pega a carga hor�ria total contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}
	
	/**
	 * M�todo que implementa a carga hor�ria total passada pelo usu�rio.
	 * 
	 * @param cargaHorariaTotal
	 */
	public void setCargaHorariaTotal(double cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}
	
	/**
	 * M�todo que pega a carga hor�ria te�rica contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaTeorica() {
		return cargaHorariaTeorica;
	}
	
	/**
	 * M�todo que implementa a carga hor�ria te�rica passada pelo usu�rio.
	 * 
	 * @param cargaHorariaTeorica
	 */
	public void setCargaHorariaTeorica(double cargaHorariaTeorica) {
		this.cargaHorariaTeorica = cargaHorariaTeorica;
	}
	
	/**
	 * M�todo que pega a carga hor�ria pr�tica contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaPratica() {
		return cargaHorariaPratica;
	}
	
	/**
	 * M�todo que implementa a carga hor�ria passada pelo usu�rio.
	 * 
	 * @param cargaHorariaPratica
	 */
	public void setCargaHorariaPratica(double cargaHorariaPratica) {
		this.cargaHorariaPratica = cargaHorariaPratica;
	}
	
	/**
	 * M�todo que pega a carga hor�ria semanal contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}
	
	/**
	 * M�todo que implementa a carga hor�ria semanal passada pelo usu�rio.
	 * 
	 * @param cargaHorariaSemanal
	 */
	public void setCargaHorariaSemanal(double cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}
	
	/**
	 * M�todo que pega a carga hor�ria mensal contida no array de disciplina.
	 * 
	 * @return
	 */
	public double getCargaHorariaMensal() {
		return cargaHorariaMensal;
	}
	
	/**
	 * M�todo que implementa a carga hor�ria mensal passada pelo usu�rio.
	 * 
	 * @param cargaHorariaMensal
	 */
	public void setCargaHorariaMensal(double cargaHorariaMensal) {
		this.cargaHorariaMensal = cargaHorariaMensal;
	}
	
	/**
	 * M�todo que pega o custo fixo determinado no main.
	 * 
	 * @return
	 */
	public double getCustoBasicoFixo() {
		return custoBasicoFixo;
	}
	
	/**
	 * M�todo que implementa o custo fixo determinado no main.
	 * 
	 */
	public void setCustoBasicoFixo(double custoBasicoFixo) {
		this.custoBasicoFixo = custoBasicoFixo;
	}
	
	/**
	 * M�todo que pega o custo te�rica contido no array de disciplina.
	 * 
	 * @return
	 */
	public double getCustoBasicoTeorica() {
		return custoBasicoTeorica;
	}
	
	/**
	 * M�todo que implementa o custo te�rica passado pelo usu�rio.
	 * 
	 * @param custoBasicoTeorica
	 */
	public void setCustoBasicoTeorica(double custoBasicoTeorica) {
		this.custoBasicoTeorica = custoBasicoTeorica;
	}
	
	/**
	 * M�todo que pega o custo pr�tica contido no array de disciplina.
	 * 
	 * @return
	 */
	public double getCustoBasicoPratica() {
		return custoBasicoPratica;
	}
	
	/**
	 * M�todo que implementa o custo pr�tica passado pelo usu�rio
	 * 
	 * @param custoBasicoPratica
	 */
	public void setCustoBasicoPratica(double custoBasicoPratica) {
		this.custoBasicoPratica = custoBasicoPratica;
	}

}


