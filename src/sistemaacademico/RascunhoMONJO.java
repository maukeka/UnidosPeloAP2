package sistemaacademico;
import java.util.Scanner;
public class RascunhoMONJO {
	//nao está organizado do modo em que vai pro programa principal , é apenas um RASCUNHO
	// primeiro deve-se implementar a funçao Scanner ( ler )
	//TÁ TUDO ERRADO PORQUE TEM QUE JOGAR NO MAIN E ARRUMAR LÁ
	public static void main(String[] args) {
		
	Scanner ler = new Scanner(System.in);
	int cargaHorariaMensal;
	int cargaHorariaSemanal;
	
	System.out.println ("Deseja definir a carga horária mensal ou semanal do curso? "
			+ "0 para não "
			+ "1 para carga horária mensal"
			+ "2 para carga horária semanal" );
        int aux = ler.nextInt();
        
        switch (aux) {
			case 1:	
				System.out.println("Digite a carga horária mensal para o curso escolhido: ");
				cargaHorariaMensal = ler.nextInt();
				break;
			case 2: 
				System.out.println("Digite a carga horária semanal para o curso escolhido: ");
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
        	System.out.println("Digite a carga horária mensal para o curso escolhido: ");
        	cargaHorariaMensal = ler.nextInt();
        }
	
        public void definirCargaHorariaSemanal() {
        	int cargaHorariaMensal;
			int cargaHorariaSemanal;
			System.out.println("Digite a carga horária semanal para o curso escolhido: ");
			cargaHorariaSemanal = (int) ler.nextDouble();
			cargaHorariaMensal = cargaHorariaSemanal * 4;
        }
	
        public void definirCargasHorariasMensalESemanal() {
		
        	int cargaHorariaMensal;
        	int cargaHorariaSemanal;
		
        	System.out.println("Digite a carga horária mensal para o curso escolhido: ");
        	Scanner ler;
			cargaHorariaMensal = ler.nextInt();
		
        	System.out.println("Digite a carga horária semanal para o curso escolhido: ");
        	cargaHorariaSemanal = ler.nextInt();
        	if ( cargaHorariaMensal > 4 * cargaHorariaSemanal) {
        		do {
        			System.out.println("O valor da carga horária semanal ou mensal foi inválido. Digite:"
						+ "1 para redefinir a carga horária mensal para um valor válido"
						+ "2 para redefinir a carga semanal para um valor válido");
        			int aux = ler.nextInt();
        			
        			if ( aux != 1 && aux != 2) {
        				do {
						System.out.println("O valor digitado foi inválido, por favor tente novamente:"
						+ "1 para redefinir a carga horária mensal para um valor válido"
						+ "2 para redefinir a carga semanal para um valor válido");
        				} while ( aux != 1 && aux != 2);
        			}else {
				if (aux = 1) {	//Alguém sabe como mudar esse erro no aux?
						System.out.println("Por favor, digite novamente a carga horária mensal do curso escolhido: ");
						cargaHorariaMensal = ler.nextInt();
				}
				if (aux = 2) {
						System.out.println("Por favor, digite novamente a carga horária semanal do curso escolhido: ");
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
System.out.println ("Deseja definir a carga horária mensal ou semanal do curso? "
		+ "0 para não "
		+ "1 para carga horária mensal"
		+ "2 para carga horária semanal" );
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


/*Na parte de alterar do programa , colocar a funçao de redefinir a carga horaria
 * semanal ou mensal e incluir nas funçoes:
 *
if ( this.cargaHorariaMensal > 4 * this.cargaHorariaSemanal) {
do {
	System.out.println("O valor da carga horária semanal ou mensal foi inválido. Digite:"
			+ "1 para redefinir a carga horária mensal para um valor válido"
			+ "2 para redefinir a carga semanal para um valor válido");
			int aux = ler.nextLine();
			if ( aux != 1 && aux != 2) {
				do {
					System.out.println("O valor digitado foi inválido, por favor tente novamente:"
							+ "1 para redefinir a carga horária mensal para um valor válido"
							+ "2 para redefinir a carga semanal para um valor válido");
				}
				while ( aux != 1 && aux != 2);
			}
			if (aux = 1) {	
				System.out.println("Por favor, digite novamente a carga horária mensal do curso escolhido: ");
				this.cargaHorariaMensal = ler.nextLine();
			}
			if ( aux = 2 ) {
				System.out.println("Por favor, digite novamente a carga horária semanal do curso escolhido: ");
				this.cargaHorariaSemanal = ler.nextLine();
			}
}
while ( this.cargaHorariaMensal > 4 * this.cargaHorariaSemanal );
}
*/
}
