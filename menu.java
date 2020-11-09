//Henrique Sartori Siqueira 					19240472
//Rafael Silva Barbon 							19243633

import java.util.*;

public class menu{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int optionprincipal,optionsecundaria;


		do{
			do{ // Menu principal
				System.out.println("\n1. Gerenciar Professor;");
				System.out.println("\n2. Gerenciar Aluno;");
				System.out.println("\n3. Gerenciar Curso;");
				System.out.println("\n4. Gerenciar Disciplina;");
				System.out.println("\n5. Sair.");
				System.out.print("\n-> ");
				optionprincipal = input.nextInt();
			}while(optionprincipal > 5 || optionprincipal < 1);
			switch (optionprincipal){
				case 1: // Submenu Professor
					do{
						do{
							System.out.println("\n1. Cadastrar Professor;");
							System.out.println("\n2. Consultar Professor;");
							System.out.println("\n3. Remover Professor;");
							System.out.println("\n4. Atualizar Professor;");
							System.out.println("\n5. MENUPrincipal.");
							System.out.print("\n-> ");
							optionsecundaria = input.nextInt();
						}while(optionsecundaria > 5 || optionsecundaria < 1);
						switch (optionsecundaria){
							case 1: // Cadastro professor
								break;
							case 2: // Consulta professor
								break;
							case 3: // Remove professor
								break;
							case 4: // Aualizar professor
								break;
						}
					}while(optionsecundaria < 5 && optionsecundaria > 0);
					break;
				case 2: // Submenu Aluno
					do{
						do{
							System.out.println("\n1. Cadastrar Aluno;");
							System.out.println("\n2. Consultar Aluno;");
							System.out.println("\n3. Remover Aluno;");
							System.out.println("\n4. Atualizar Aluno;");
							System.out.println("\n5. MENUPrincipal.");
							System.out.print("\n-> ");
							optionsecundaria = input.nextInt();
						}while(optionsecundaria > 5 || optionsecundaria < 1);
						switch (optionsecundaria){
							case 1: // Cadastro aluno
								break;
							case 2: // Consulta aluno
								break;
							case 3: // Remove aluno
								break;
							case 4: // Aualizar aluno
								break;
						}
					}while(optionsecundaria < 5 && optionsecundaria > 0);
					break;
				case 3: // Submenu Curso
					do{
						do{
							System.out.println("\n1. Cadastrar Curso;");
							System.out.println("\n2. Consultar Curso;");
							System.out.println("\n3. Remover Curso;");
							System.out.println("\n4. Atualizar Curso;");
							System.out.println("\n5. MENUPrincipal.");
							System.out.print("\n-> ");
							optionsecundaria = input.nextInt();
						}while(optionsecundaria > 5 || optionsecundaria < 1);
						switch (optionsecundaria){
							case 1: // Cadastro curso
								break;
							case 2: // Consulta curso
								break;
							case 3: // Remove curso
								break;
							case 4: // Aualizar curso
								break;
						}
					}while(optionsecundaria < 5 && optionsecundaria > 0);
					break;
				case 4: // Submenu Disciplina
					do{
						do{
							System.out.println("\n1. Cadastrar Disciplina;");
							System.out.println("\n2. Consultar Disciplina;");
							System.out.println("\n3. Remover Disciplina;");
							System.out.println("\n4. Atualizar Disciplina;");
							System.out.println("\n5. MENUPrincipal.");
							System.out.print("\n-> ");
							optionsecundaria = input.nextInt();
						}while(optionsecundaria > 5 || optionsecundaria < 1);
						switch (optionsecundaria){
							case 1: // Cadastro disciplina
								break;
							case 2: // Consulta disciplina
								break;
							case 3: // Remove disciplina
								break;
							case 4: // Aualizar disciplina
								break;
						}
					}while(optionsecundaria < 5 && optionsecundaria > 0);
					break;
			}
		}while(optionprincipal < 5 && optionprincipal > 0);
	}
}
