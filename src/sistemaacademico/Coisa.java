package sistemaacademico;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 
 * @author 	Eduardo César Freitas da Silva Filho
 * @author	Laís Ribeiro Torres 
 * @author	Marcos Paulo da Carvalho Araújo
 * @author 	Mauricio Kenichi Kanashiro
 * @author 	Rodolfo Pereira Lemos
 * @author 	Samuel dos Santos Nogueira
 * 
 * Nome.......: Coisa
 * Descrição..: Classe que define os métodos obrigatórios das classes que herdar dela
 * 
 * 
 */
public abstract class Coisa {
    int                             codigo;
    String                          nomeAbreviado;
    String                          nomeCompleto;
    
    /**
     * Nome........: Cadastrar
     * Descrição...: Método abstrato destinado a cadastrar as infromações da disciplina 
     * 
     * @param disciplina
     */
    public abstract void cadastrar(Disciplina disciplina);
    
    /**
     * Nome........: Alterar
     * Descrição...: Método abstrato destinado a alterar os dados de uma disciplina 
     * 
     * @param disciplina
     */
    public abstract void alterar (Disciplina disciplina);
    
    /**
     * Nome........: Consultar
     * Descrição...: Método abstrato destinado a consultar informações da disciplina
     * 
     * @param paramentro
     * @param chave
     * @return
     */
    public abstract List<Disciplina> consultar (String paramentro, String chave);
    
    /**
     * Nome........: Excluir
     * Descrição...: Método abstrato destinado a excluir uma disciplina por completo
     * 
     * @param codigo
     */
    public abstract void excluir (int codigo);
}
