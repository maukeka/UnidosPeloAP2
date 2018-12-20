package sistemaacademico;

/**
 * 
 * @author 	Eduardo C�sar Freitas da Silva Filho
 * @author	La�s Ribeiro Torres 
 * @author	Marcos Paulo da Carvalho Ara�jo
 * @author 	Mauricio Kenichi Kanashiro
 * @author 	Rodolfo Pereira Lemos
 * @author 	Samuel dos Santos Nogueira
 * 
 * Nome.......: TecnicioAdministrativo
 * Objetivo...: Representar um(a) empregado(a) que exerce fun��o de t�cnico-administrativo(a).
 * Observacoes: Os demais m�todos n�o foram ultilizados pois n�o se trata de nosso trabalho.
 * 
 */
public class TecnicoAdministrativo extends Empregado {

	String nome;

	/**
	 * Pega o nome do "TecnicoAdministrativo" passado pelo usu�rio.
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Implementa o nome do "TecnicoAdministrativo" passado pelo usu�rio.
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
