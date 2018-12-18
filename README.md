# Algoritmos e Programação 2

**Docentes:**
  * [Otávio Calaça Xavier](http://inf.ufg.br/node/564)
  * [Rafael Tomaz Parreira](http://inf.ufg.br/node/1180)

**Discentes:**
  * [Eduardo Cesar Freitas da Silva Filho]()
  * [Lais Ribeiro Torres](https://github.com/laisrtorres)
  * [Marcos Paulo de Carvalho Araujo](https://github.com/2marco1paulo)
  * [Mauricio Kenichi Kanashiro](https://github.com/maukeka)
  * [Rodolfo Pereira Lemos](https://github.com/DolphinPL)
  * [Samuel dos Santos Nogueira](https://github.com/SanHeacles)
  
  **Curso:** Engenharia Elétrica
  
  ## Projeto
Descrição do projeto: 

**Disciplinas** - A classe Disciplina  que estende a classe Coisa  deve atender, dentre outras,
às seguintes exigências:
	1. Uma disciplina, por ser um exemplar da classe Coisa, tem que ter um código único, como também deve ter um nomeAbreviado e um nomeCompleto não vazios;
	2. O valor do atributo situacao deve estar dentre um dos previstos na classe
SituacaoDisciplina;
	3. Uma disciplina pode, ou não, estar vinculada a um curso e, por consequência, deve ser possível que o atributo curso seja deixado com o valor 0 (zero) para indicar que aquela disciplina não se vincula a nenhum curso de maneira especíca. Por exemplo, pode ser uma disciplina eletiva (ou dita de núcleo livre);
	4. Uma disciplina deve ter, obrigatoriamente, um docente responsável por ela e, opcionalmente, um docente auxiliar  isto acontece em alguns cursos, onde mais de um professor é necessária para conduzir uma aula;
	5. Uma disciplina pode ter até dois empregados técnico-administrativos também vinculados a ela, um é o responsável e outro o auxiliar. Ambos são opcionais;
	6. O atributo numeroCreditos é opcional. Ele está presente porque em algumas instituições as disciplinas têm associado a elas um número de créditos;
	7. A cargaHorariaTotal deve corresponder à cargaHorariaTeorica adicionada à
cargaHorariaPratica, sendo que uma delas pode ser igual a 0(zero) mas, obviamente,
não ambas simultaneamente;
	8. Deve ser possível denir uma cargaHorariaSemanal ou uma cargaHorariaMensal
para a disciplina, apesar de ambos atributos serem opcionais. Se ambos forem fornecidos, então deve-se vericar para que a cargaHorariaMensal não seja superior a CINCO VEZES a cargaHorariaSemanal, pois a maior quantidade de semanas que um mês pode ter é CINCO;
	9. Todos os atributos sobre custos são opcionais e, portanto, não há nenhuma restrição a ser aplicada sobre eles;
	10. Há, obviamente, atributos e métodos adicionais que serão necessários, mas que não foram inseridos pelo professor  cabe à equipe identicar quais são estes atributos (e métodos), impondo-lhes as restrições necessárias.
