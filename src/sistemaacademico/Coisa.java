package sistemaacademico;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

/**
 *
 * @author Wanderley de Souza Alencar
 */
/*
* Nome.......: Coisa
* Objetivo...: Representa um objeto inanimado ("coisa") 
* Observacoes: 
*              
*/
public abstract class Coisa {
    int                             codigo;
    String                          nomeAbreviado;
    String                          nomeCompleto;
    
    public abstract void cadastrar(Disciplina disciplina);
    public abstract void alterar (Disciplina disciplina);
    public abstract List<Disciplina> consultar (String paramentro, String chave);
    public abstract void excluir (int codigo);
}
