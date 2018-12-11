package sistemaacademico;


/**
 *
 * @author Wanderley de Souza Alencar
 */
/*
* Nome.......: Curso
* Objetivo...: Representar um curso na instituição de ensino
* Observacoes:
*/
public class Curso extends Coisa {
 
    int                             situacao;  
    double                          cargaHorariaTotal;      
    double                          cargaHorariaTeoria;
    double                          cargaHorariaPratica;
    double							cargaHorariaMensal;
    double							cargaHorariaSemanal;
 
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

	@Override
	public void atualizar(int codigo) {
		// TODO Auto-generated method stub
		
	}
	public void definirCargaHorariaMensal()	{
		System.out.println("Digite a carga hor�ria mensal para o curso escolhido: ");
		this.cargaHorariaMensal = ler.nextDouble();
	}
	public void definirCargaHorariaSemanal() {
		System.out.println("Digite a carga hor�ria semanal para o curso escolhido: ");
		this.cargaHorariaSemanal = ler.nextDouble();
		this.cargaHorariaMensal = cargaHorariaSemanal * 4;
	}
}
