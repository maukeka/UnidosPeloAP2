package sistemaacademico;

/**
 * 
 * @author 	Eduardo César Freitas da Silva Filho
 * @author	Laís Ribeiro Torres 
 * @author	Marcos Paulo da Carvalho Araújo
 * @author 	Mauricio Kenichi Kanashiro
 * @author 	Rodolfo Pereira Lemos
 * @author 	Samuel dos Santos Nogueira
 * 
 * Nome.......: TecnicioAdministrativo
 * Objetivo...: Representar um(a) empregado(a) que exerce função de técnico-administrativo(a).
 * Observacoes: Os demais métodos não foram ultilizados pois não se trata de nosso trabalho.
 * 
 */
public class TecnicoAdministrativo extends Empregado {

	String nome;

	/**
	 * Pega o nome do "TecnicoAdministrativo" passado pelo usuário.
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Implementa o nome do "TecnicoAdministrativo" passado pelo usuário.
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	
	public void cadastrar() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	
	public void alterar(DocumentoIdentificacao documento) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	
	public void excluir(DocumentoIdentificacao documento) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	
	public Pessoa consultar(DocumentoIdentificacao documento) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
