# Algoritmos e Programa��o 2

**Docentes:**
  * [Ot�vio Cala�a Xavier](http://inf.ufg.br/node/564)
  * [Rafael Tomaz Parreira](http://inf.ufg.br/node/1180)

**Discentes:**
  * [Eduardo Cesar Freitas da Silva Filho]()
  * [Lais Ribeiro Torres](https://github.com/laisrtorres)
  * [Marcos Paulo de Carvalho Araujo](https://github.com/2marco1paulo)
  * [Mauricio Kenichi Kanashiro](https://github.com/maukeka)
  * [Rodolfo Pereira Lemos](https://github.com/DolphinPL)
  * [Samuel dos Santos Nogueira](https://github.com/SanHeacles)
  
  **Curso:** Engenharia El�trica
  
  ## Projeto
Descri��o do projeto: 

**Disciplinas** - A classe Disciplina  que estende a classe Coisa  deve atender, dentre outras,
�s seguintes exig�ncias:
	1. Uma disciplina, por ser um exemplar da classe Coisa, tem que ter um c�digo �nico, como tamb�m deve ter um nomeAbreviado e um nomeCompleto n�o vazios;
	2. O valor do atributo situacao deve estar dentre um dos previstos na classe
SituacaoDisciplina;
	3. Uma disciplina pode, ou n�o, estar vinculada a um curso e, por consequ�ncia, deve ser poss�vel que o atributo curso seja deixado com o valor 0 (zero) para indicar que aquela disciplina n�o se vincula a nenhum curso de maneira espec�ca. Por exemplo, pode ser uma disciplina eletiva (ou dita de n�cleo livre);
	4. Uma disciplina deve ter, obrigatoriamente, um docente respons�vel por ela e, opcionalmente, um docente auxiliar  isto acontece em alguns cursos, onde mais de um professor � necess�ria para conduzir uma aula;
	5. Uma disciplina pode ter at� dois empregados t�cnico-administrativos tamb�m vinculados a ela, um � o respons�vel e outro o auxiliar. Ambos s�o opcionais;
	6. O atributo numeroCreditos � opcional. Ele est� presente porque em algumas institui��es as disciplinas t�m associado a elas um n�mero de cr�ditos;
	7. A cargaHorariaTotal deve corresponder � cargaHorariaTeorica adicionada �
cargaHorariaPratica, sendo que uma delas pode ser igual a 0(zero) mas, obviamente,
n�o ambas simultaneamente;
	8. Deve ser poss�vel denir uma cargaHorariaSemanal ou uma cargaHorariaMensal
para a disciplina, apesar de ambos atributos serem opcionais. Se ambos forem fornecidos, ent�o deve-se vericar para que a cargaHorariaMensal n�o seja superior a CINCO VEZES a cargaHorariaSemanal, pois a maior quantidade de semanas que um m�s pode ter � CINCO;
	9. Todos os atributos sobre custos s�o opcionais e, portanto, n�o h� nenhuma restri��o a ser aplicada sobre eles;
	10. H�, obviamente, atributos e m�todos adicionais que ser�o necess�rios, mas que n�o foram inseridos pelo professor  cabe � equipe identicar quais s�o estes atributos (e m�todos), impondo-lhes as restri��es necess�rias.
