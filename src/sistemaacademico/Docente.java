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
* Nome.......: Docente
* Objetivo...: Representar um(a) empregado(a) que exerce funçãoo de docente.
* Observacoes: Os demais métodos não foram ultilizados pois não se trata de nosso trabalho.
 * 
 */

public class Docente extends Empregado {
	
	/**
	 * 
	 * @author 	Eduardo César Freitas da Silva Filho
	 * @author	Laís Ribeiro Torres 
	 * @author	Marcos Paulo da Carvalho Araújo
	 * @author 	Mauricio Kenichi Kanashiro
	 * @author 	Rodolfo Pereira Lemos
	 * @author 	Samuel dos Santos Nogueira
	 * 
	* Nome.......: getNome
	* Objetivo...: Pega o nome do "Docente" passado pelo usuário.
	* Observacoes:
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @author 	Eduardo César Freitas da Silva Filho
	 * @author	Laís Ribeiro Torres 
	 * @author	Marcos Paulo da Carvalho Araújo
	 * @author 	Mauricio Kenichi Kanashiro
	 * @author 	Rodolfo Pereira Lemos
	 * @author 	Samuel dos Santos Nogueira
	 * 
	* Nome.......: setNome
	* Objetivo...: Implementa o nome do "Docente" passado pelo usuário.
	* Observacoes:
	 * 
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
    

    
}
