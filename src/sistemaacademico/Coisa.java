package sistemaacademico;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 
 * @author 	Eduardo C�sar Freitas da Silva Filho
 * @author	La�s Ribeiro Torres 
 * @author	Marcos Paulo da Carvalho Ara�jo
 * @author 	Mauricio Kenichi Kanashiro
 * @author 	Rodolfo Pereira Lemos
 * @author 	Samuel dos Santos Nogueira
 * 
 * Nome.......: Coisa
 * Descri��o..: Classe que define os m�todos obrigat�rios das classes que herdar dela
 * 
 * 
 */
public abstract class Coisa {
    int                             codigo;
    String                          nomeAbreviado;
    String                          nomeCompleto;
    
    /**
     * Nome........: Cadastrar
     * Descri��o...: M�todo abstrato destinado a cadastrar as infroma��es da disciplina 
     * 
     * @param disciplina
     */
    public abstract void cadastrar(Disciplina disciplina);
    
    /**
     * Nome........: Alterar
     * Descri��o...: M�todo abstrato destinado a alterar os dados de uma disciplina 
     * 
     * @param disciplina
     */
    public abstract void alterar (Disciplina disciplina);
    
    /**
     * Nome........: Consultar
     * Descri��o...: M�todo abstrato destinado a consultar informa��es da disciplina
     * 
     * @param paramentro
     * @param chave
     * @return
     */
    public abstract List<Disciplina> consultar (String paramentro, String chave);
    
    /**
     * Nome........: Excluir
     * Descri��o...: M�todo abstrato destinado a excluir uma disciplina por completo
     * 
     * @param codigo
     */
    public abstract void excluir (int codigo);
}
