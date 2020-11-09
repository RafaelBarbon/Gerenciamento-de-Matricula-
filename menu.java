//Henrique Sartori Siqueira 					19240472
//Rafael Silva Barbon 							19243633

import java.util.*;

public class menu{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int optionprincipal,optionsecundaria, codigo, carga_horaria, i;
		String nome,procurar;
		boolean check;
		boolean subfound, proffound, studentfound;
		LinkedList <disciplina> disciplinas = new LinkedList<disciplina>();
		LinkedList <curso_professor> professores = new LinkedList<curso_professor>();
		LinkedList <curso_professor> cursos = new LinkedList<curso_professor>();
		LinkedList <aluno> alunos = new LinkedList<aluno>();
		
		aluno aux_aluno;
		curso_professor aux_professor;
		curso_professor aux_curso;
		disciplina aux_disc;

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
								System.out.print("\n\tInsira o nome do professor:");
								nome = input.next();
								System.out.println();
								System.out.print("\n\tInsira o carga horária do professor:");
								carga_horaria = input.nextInt();
								System.out.println();
								System.out.print("\n\tInsira o código do professor:");
								codigo = input.nextInt();
								System.out.println();

								aux_professor = new curso_professor(nome,carga_horaria,codigo);

								nome = "\0";
								while(!(nome.equals("menu")) && disciplinas.size() != 0){
									System.out.print("\n\tInsira uma Disciplina (Digite \"menu\" para sair):");
									nome = input.next();
									if(!(nome.equals("menu"))){
										subfound = false;
										for(disciplina discip : disciplinas){// Verifica a existencia da discplina na lista de disciplinas
											if(discip.get_nome().equals(nome)){ 
												aux_professor.adiciona_disc(discip);
												subfound = true;
												break;
											}
										}
										if(!subfound){
											System.out.print("\n\tDisciplina não encontrada");
										}
									}
								}

								professores.add(aux_professor);
								break;
							case 2: // Consulta professor
								System.out.print("\n\tInsira o nome do professor a ser buscado: ");
								nome = input.next();
								proffound = false;
								for(curso_professor prof : professores){// Verifica a existencia do professor na lista de professores
									if(prof.get_nome().equals(nome)){ 
										prof.exibe(false);
										proffound = true;
										break;
									}
								}
								if(!proffound){
									System.out.println("\n\tProfessor não encontrado.");
								}
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
								if(cursos.size() != 0){
									System.out.print("\n\tInsira o nome do aluno:");
									nome = input.next();
									System.out.println();
									System.out.print("\n\tInsira o carga horária do aluno:");
									carga_horaria = input.nextInt();
									System.out.println();
									System.out.print("\n\tInsira o código do aluno:");
									codigo = input.nextInt();
									System.out.println();

									System.out.print("\n\tInsira o nome do curso do aluno:");
									procurar = input.next();
									System.out.println();

									for(check = false, i = 0; i < cursos.size(); i++){ // procura na lista de cursos, se o curso existe
										aux_curso = cursos.get(i);
										if(procurar.equals(aux_curso.get_nome())){
											check = true;
											break;
										}
									}
									if(check){ // encontrou o curso na lista
										aux_aluno = new aluno(nome,carga_horaria,codigo,aux_curso);
									}
									else{ // não encontrou o curso na lista
										aux_aluno = new aluno(nome,carga_horaria,codigo);
									}
									/*
									fazer a coleta das disciplinas -> conferir se existem disciplinas (senão ja cadastra sem disciplinas), coletar do usuário, verificar se existe, adicionar
									*/
								}
								else{ // não existe cursos na lista
									System.out.println("\n\tCadastre um curso para atualizar o cadastro do aluno (aluno cadastrado sem informações).");
									aux_aluno = new aluno();
								}
								alunos.add(aux_aluno);
								break;
							case 2: // Consulta aluno
								System.out.print("\n\tInsira o nome do aluno a ser buscado: ");
								nome = input.next();
								studentfound = false;
								for(aluno stud : alunos){// Verifica a existencia do aluno na lista de alunos
									if(stud.get_nome().equals(nome)){ 
										stud.exibe();
										studentfound = true;
										break;
									}
								}
								if(!studentfound){
									System.out.println("\n\tAluno não encontrado.");
								}
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
								System.out.print("\n\tInsira o nome do curso:");
								nome = input.next();
								System.out.println();
								System.out.print("\n\tInsira o carga horária do curso:");
								carga_horaria = input.nextInt();
								System.out.println();
								System.out.print("\n\tInsira o código do curso:");
								codigo = input.nextInt();
								System.out.println();

								aux_curso = new curso_professor(nome,carga_horaria,codigo);

								nome = "\0";
								while(!(nome.equals("menu")) && disciplinas.size() != 0){
									System.out.print("\n\tInsira uma Disciplina (Digite \"menu\" para sair):");
									nome = input.next();
									if(!(nome.equals("menu"))){
										subfound = false;
										for(disciplina discip : disciplinas){// Verifica a existencia da discplina na lista de disciplinas
											if(discip.get_nome().equals(nome)){ 
												aux_curso.adiciona_disc(discip);
												subfound = true;
												break;
											}
										}
										if(!subfound){
											System.out.print("\n\tDisciplina não encontrada");
										}
									}
								}
								cursos.add(aux_curso);
								break;
							case 2: // Consulta curso
								for(curso_professor curso : cursos){// Exibe todos os cursos cadastrados
									curso.exibe(false);
									System.out.println();
								}
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
								System.out.print("\n\tInsira o nome da disciplina:");
								nome = input.next();
								System.out.println();
								System.out.print("\n\tInsira o carga horária da disciplina:");
								carga_horaria = input.nextInt();
								System.out.println();
								System.out.print("\n\tInsira o código da disciplina:");
								codigo = input.nextInt();
								System.out.println();

								aux_disc = new disciplina(nome,carga_horaria,codigo);

								disciplinas.add(aux_disc);
								break;
							case 2: // Consulta disciplina
								System.out.print("\n\tInsira o nome da disciplina a ser buscada: ");
								nome = input.next();
								subfound = false;
								for(disciplina disc : disciplinas){// Verifica a existencia da disciplina na lista de disciplinas
									if(disc.get_nome().equals(nome)){ 
										disc.exibe();
										subfound = true;
										break;
									}
								}
								if(!subfound){
									System.out.println("\n\tDisciplina não encontrada.");
								}
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
