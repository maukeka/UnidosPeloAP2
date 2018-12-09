package sistemaacademico;
/**
 *
 * @author Wanderley de Souza Alencar
 */
/*
* Nome.......: Disciplina
* Objetivo...: Representar uma disciplina na instituição de ensino
* Observacoes:
*/
public class Disciplina extends Coisa {
    
	
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	int                             situacao;
    
	//System.out.println("lalala");
    
    int                             curso;                  // 0 (zero) para disciplina sem curso vinculado
    Docente                         docenteResponsavel;     // Informação obrigatória
    Docente                         docenteAuxiliar;        // Null = docente inexistente
    TecnicoAdministrativo           tecnicoAdministrativoResponsavel; // Null = TA inexistente
    TecnicoAdministrativo           tecnicoAminAdministrativoAuxiliar; // Null = TA inexistente
    
    double                          numeroCreditos;        // 0 - Não informada (é opcional informar)
    double                          cargaHorariaTotal;      
    double                          cargaHorariaTeorica;
    double                          cargaHorariaPratica;
    double                          cargaHorariaSemanal;    // Opcional informar
    double                          cargaHorariaMensal;     // Opcional informar
    
    double                          custoFixo;              // Todos são opcionais...
    double                          custoBasicoTeorica;     // Valores em Reais (R$)
    double                          custoBasicoPratica;     //

    //
    // A equipe responsável deverá verificar se há necessidade de outros
    // atributos e métodos para inseri-los.
    // 
    
    @Override
    public void cadastrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
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


