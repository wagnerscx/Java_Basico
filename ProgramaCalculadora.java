import java.util.Scanner;

public class ProgramaCalculadora {
    public static void main(String[] args) {
		
		 
		System.out.println ("------ Calculadora ------\n\n"+
                                "1-Somar\n"+
                                "2-Subtrair\n"+
                                "3-Multiplicar\n"+
                                "4-Dividir\n"+
                                "5-Potência\n"+
                                "6-Raiz Quadrada\n"+
                                "7-Finalizar\n\n"+
							"---------------------------");
          double num1, num2,res;
		  
	    System.out.println("SELECIONE UMA OPERACAO: ");
		  Scanner in = new Scanner(System.in);
		  int opcao = in.nextInt();
              
               switch (opcao)
               {
                     case 1:  
                         System.out.println("Insira um número: ");
                         num1 = in.nextInt();
                         System.out.println("Insira outro número: ");
                         num2 = in.nextInt();
						 res = num1 + num2;
                         System.out.println("O resultado da soma é: "+res);
                         break;
 
                     case 2: 
                         System.out.println("Insira um número: ");
                         num1 = in.nextInt();
                         System.out.println("Insira outro número: ");
                         num2 = in.nextInt();
						 res = num1 - num2;
                         System.out.println("O resultado da soma é: "+res);
						 break;	
						 
                     case 3: 
					     System.out.println("Insira um número: ");
                         num1 = in.nextInt();
                         System.out.println("Insira outro número: ");
                         num2 = in.nextInt();
						 res = num1 * num2;
                         System.out.println("O resultado da soma é: "+res);
						 break;	
					     
 
                     case 4: 
                         System.out.println("Insira um número: ");
                         num1 = in.nextInt();
                         System.out.println("Insira outro número: ");
                         num2 = in.nextInt();
						 res = num1 / num2;
                         System.out.println("O resultado da soma é: "+res);
						 break;	
 
                     case 5: 
                         System.out.println("Insira um número: ");
                         num1 = in.nextInt();
                         System.out.println("Insira outro número: ");
                         num2 = in.nextInt();
						 res = Math.pow(num1 , num2);
                         System.out.println("O resultado da soma é: "+res);
						 break;	
 
                     case 6:  
                         System.out.println("Insira um número: ");
                         num1 = in.nextInt();
						 res = Math.sqrt(num1);
                         System.out.println("O resultado da soma é: "+res);
						 break;	
					case 7:
                         System.out.println(" OPERACAO FINALIZADA ");
						 break;
					default:
					     System.out.println("O número escolhido é inválido! Digite um número entre 1 a 7.");
               }
		 
        }
                    
   }
		
		
		
       


    
