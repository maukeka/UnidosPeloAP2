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
* Nome.......: Docente
* Objetivo...: Representar um(a) empregado(a) que exerce fun��oo de docente.
* Observacoes: Os demais m�todos n�o foram ultilizados pois n�o se trata de nosso trabalho.
 * 
 */

public class Docente extends Empregado {
	
	/**
	 * 
	 * @author 	Eduardo C�sar Freitas da Silva Filho
	 * @author	La�s Ribeiro Torres 
	 * @author	Marcos Paulo da Carvalho Ara�jo
	 * @author 	Mauricio Kenichi Kanashiro
	 * @author 	Rodolfo Pereira Lemos
	 * @author 	Samuel dos Santos Nogueira
	 * 
	* Nome.......: getNome
	* Objetivo...: Pega o nome do "Docente" passado pelo usu�rio.
	* Observacoes:
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @author 	Eduardo C�sar Freitas da Silva Filho
	 * @author	La�s Ribeiro Torres 
	 * @author	Marcos Paulo da Carvalho Ara�jo
	 * @author 	Mauricio Kenichi Kanashiro
	 * @author 	Rodolfo Pereira Lemos
	 * @author 	Samuel dos Santos Nogueira
	 * 
	* Nome.......: setNome
	* Objetivo...: Implementa o nome do "Docente" passado pelo usu�rio.
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
