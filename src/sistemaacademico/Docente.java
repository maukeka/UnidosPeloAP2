package sistemaacademico;
/**
 * @author Laís Ribeiro Torres, Maurício Kenichi Kanashiro, Marcos Paulo de Carvalho Araújo, Rodolfo Pereira Lemos, Samuel dos Santos Nogueira, Eduardo Cesar Freitas da Silva Filho
 */
/*
* Nome.......: Docente
* Objetivo...: Representar um(a) empregado(a) que exerce funÃ§Ã£o docente.
* Observacoes:
*/
public class Docente extends Empregado {
	
	/**
	 * @author Laís Ribeiro Torres, Maurício Kenichi Kanashiro, Marcos Paulo de Carvalho Araújo, Rodolfo Pereira Lemos, Samuel dos Santos Nogueira, Eduardo Cesar Freitas da Silva Filho
	 */
	/*
	* Nome.......: getNome
	* Objetivo...: capturar o nome
	* Observacoes:
	*/
	public String getNome() {
		return nome;
	}

	/**
	 * @author Laís Ribeiro Torres, Maurício Kenichi Kanashiro, Marcos Paulo de Carvalho Araújo, Rodolfo Pereira Lemos, Samuel dos Santos Nogueira, Eduardo Cesar Freitas da Silva Filho
	 */
	/*
	* Nome.......: setNome
	* Objetivo...: Definir o nome
	* Observacoes:
	*/
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	String nome;
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
    
   //
    // A equipe responsÃ¡vel deverÃ¡ verificar se hÃ¡ necessidade de outros
    // atributos e mÃ©todos para inseri-los.
    // 
    
}
