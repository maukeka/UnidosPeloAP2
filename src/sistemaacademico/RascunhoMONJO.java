package sistemaacademico;
import java.util.Scanner;
public class RascunhoMONJO {
	//nao est� organizado do modo em que vai pro programa principal , � apenas um RASCUNHO
	// primeiro deve-se implementar a fun�ao Scanner ( ler )
	//T� TUDO ERRADO PORQUE TEM QUE JOGAR NO MAIN E ARRUMAR L�
	public static void main(String[] args) {
		
	Scanner ler = new Scanner(System.in);
	int cargaHorariaMensal;
	int cargaHorariaSemanal;
	
	System.out.println ("Deseja definir a carga hor�ria mensal ou semanal do curso? "
			+ "0 para n�o "
			+ "1 para carga hor�ria mensal"
			+ "2 para carga hor�ria semanal" );
        int aux = ler.nextInt();
        
        switch (aux) {
			case 1:	
				System.out.println("Digite a carga hor�ria mensal para o curso escolhido: ");
				cargaHorariaMensal = ler.nextInt();
				break;
			case 2: 
				System.out.println("Digite a carga hor�ria semanal para o curso escolhido: ");
				cargaHorariaSemanal = ler.nextInt();
				cargaHorariaMensal = cargaHorariaSemanal * 4;
				break;
			default:
				System.out.println();
				}
				

        private static void swicth(int doc) {
		// TODO Auto-generated method stub
		
        }

		private Scanner ler;
    
        public void definirCargaHorariaMensal()	{
        	int cargaHorariaMensal;
        	System.out.println("Digite a carga hor�ria mensal para o curso escolhido: ");
        	cargaHorariaMensal = ler.nextInt();
        }
	
        public void definirCargaHorariaSemanal() {
        	int cargaHorariaMensal;
			int cargaHorariaSemanal;
			System.out.println("Digite a carga hor�ria semanal para o curso escolhido: ");
			cargaHorariaSemanal = (int) ler.nextDouble();
			cargaHorariaMensal = cargaHorariaSemanal * 4;
        }
	
        public void definirCargasHorariasMensalESemanal() {
		
        	int cargaHorariaMensal;
        	int cargaHorariaSemanal;
		
        	System.out.println("Digite a carga hor�ria mensal para o curso escolhido: ");
        	Scanner ler;
			cargaHorariaMensal = ler.nextInt();
		
        	System.out.println("Digite a carga hor�ria semanal para o curso escolhido: ");
        	cargaHorariaSemanal = ler.nextInt();
        	if ( cargaHorariaMensal > 4 * cargaHorariaSemanal) {
        		do {
        			System.out.println("O valor da carga hor�ria semanal ou mensal foi inv�lido. Digite:"
						+ "1 para redefinir a carga hor�ria mensal para um valor v�lido"
						+ "2 para redefinir a carga semanal para um valor v�lido");
        			int aux = ler.nextInt();
        			
        			if ( aux != 1 && aux != 2) {
        				do {
						System.out.println("O valor digitado foi inv�lido, por favor tente novamente:"
						+ "1 para redefinir a carga hor�ria mensal para um valor v�lido"
						+ "2 para redefinir a carga semanal para um valor v�lido");
        				} while ( aux != 1 && aux != 2);
        			}else {
				if (aux = 1) {	//Algu�m sabe como mudar esse erro no aux?
						System.out.println("Por favor, digite novamente a carga hor�ria mensal do curso escolhido: ");
						cargaHorariaMensal = ler.nextInt();
				}
				if (aux = 2) {
						System.out.println("Por favor, digite novamente a carga hor�ria semanal do curso escolhido: ");
						cargaHorariaSemanal = ler.nextInt();
				}
			}
        		}
			while ( cargaHorariaMensal > 4 * cargaHorariaSemanal );
			}
        	
        	
        	
        	break;
        }
//ler.close
/* DEPOIS EM ALGUMA PARTE DO MAIN COLOCAR: 
System.out.println ("Deseja definir a carga hor�ria mensal ou semanal do curso? "
		+ "0 para n�o "
		+ "1 para carga hor�ria mensal"
		+ "2 para carga hor�ria semanal" );
int aux = ler.nextLine();
switch (aux) {
	case 0: 
		break;
	case 1:	Curso.definirCargaHorariaMensal()
		break;
	case 2: Curso.definirCargaHorariaSemanal()
		break;
}
*/


/*Na parte de alterar do programa , colocar a fun�ao de redefinir a carga horaria
 * semanal ou mensal e incluir nas fun�oes:
 *
if ( this.cargaHorariaMensal > 4 * this.cargaHorariaSemanal) {
do {
	System.out.println("O valor da carga hor�ria semanal ou mensal foi inv�lido. Digite:"
			+ "1 para redefinir a carga hor�ria mensal para um valor v�lido"
			+ "2 para redefinir a carga semanal para um valor v�lido");
			int aux = ler.nextLine();
			if ( aux != 1 && aux != 2) {
				do {
					System.out.println("O valor digitado foi inv�lido, por favor tente novamente:"
							+ "1 para redefinir a carga hor�ria mensal para um valor v�lido"
							+ "2 para redefinir a carga semanal para um valor v�lido");
				}
				while ( aux != 1 && aux != 2);
			}
			if (aux = 1) {	
				System.out.println("Por favor, digite novamente a carga hor�ria mensal do curso escolhido: ");
				this.cargaHorariaMensal = ler.nextLine();
			}
			if ( aux = 2 ) {
				System.out.println("Por favor, digite novamente a carga hor�ria semanal do curso escolhido: ");
				this.cargaHorariaSemanal = ler.nextLine();
			}
}
while ( this.cargaHorariaMensal > 4 * this.cargaHorariaSemanal );
}
*/
}
