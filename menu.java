//Henrique Sartori Siqueira 					19240472
//Rafael Silva Barbon 							19243633

import java.util.*;

public class menu{
	public static <T> void printa(LinkedList <T> lista){
		for(T li : lista){
			System.out.printf("\t%s", li);
		}
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int optionprincipal,optionsecundaria, codigo, carga_horaria, i, procurar, aux_att;
		String nome;
		boolean subfound, proffound, studentfound, check, cursofound;
		LinkedList <disciplina> disciplinas = new LinkedList<disciplina>();
		LinkedList <curso_professor> professores = new LinkedList<curso_professor>();
		LinkedList <curso_professor> cursos = new LinkedList<curso_professor>();
		LinkedList <aluno> alunos = new LinkedList<aluno>();
		
		aluno aux_aluno = null;
		curso_professor aux_professor = null, aux_curso = null;
		disciplina aux_disc = null;

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
								nome = input.nextLine();
								nome = input.nextLine();
								nome = nome.toUpperCase();
								System.out.println();
								System.out.print("\n\tInsira o carga horária do professor:");
								carga_horaria = input.nextInt();
								System.out.println();
								System.out.print("\n\tInsira o código do professor:");
								codigo = input.nextInt();
								do{
									proffound = false;
									for(curso_professor prof : professores){
										if(codigo == prof.get_codigo()){
											System.out.print("\n\tCódigo existente! Insira um novo código do professor:");
											codigo = input.nextInt();
											proffound = true;
											break;
										}
									}
								}while(proffound);
								System.out.println();

								aux_professor = new curso_professor(nome,carga_horaria,codigo);

								codigo = -1;
								while(codigo != 0 && disciplinas.size() != 0){
									System.out.println();
									for(disciplina aux : disciplinas){// Lista as disciplinas existentes na lista de disciplinas 
										aux.exibe_codigo_nome();
									}
									System.out.print("\n\tInsira o código de uma disciplina (Digite \"0\" para sair):");
									codigo = input.nextInt();
									if(codigo != 0){
										subfound = false;
										for(disciplina discip : disciplinas){// Verifica a existência da disciplina na lista de disciplinas
											if(discip.get_codigo() == codigo){ 
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
								for(curso_professor professor : professores){// Exibe todos os professores cadastrados
									professor.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código do professor a ser buscado: ");
								codigo = input.nextInt();
								proffound = false;
								for(curso_professor prof : professores){// Verifica a existência do professor na lista de professores
									if(prof.get_codigo() == codigo){ 
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
								for(curso_professor professor : professores){// Exibe todos os professores cadastrados
									professor.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código do professor a ser removido: ");
								codigo = input.nextInt();
								check = false;
								for(curso_professor prof : professores){
									if(codigo == prof.get_codigo()){
										professores.remove(prof);// Removendo o professor da lista
										check = true;
										break;
									}
								}
								if(!check){// Se não achar printa
									System.out.println("\n\tProfessor não encontrado.");
								}
								break;
							case 4: // Atualizar professor
								for(curso_professor professor : professores){// Exibe todos os professores cadastrados
									professor.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código do professor a ser atualizado: ");
								codigo = input.nextInt();
								proffound = false;
								for(curso_professor prof : professores){// Verifica a existência do professor na lista de professores
									if(prof.get_codigo() == codigo){ 
										proffound = true;
										do{
												do{
													prof.exibe(false);
													System.out.println("\n\t Atualizar:");
													System.out.println("\t1. Nome;\n\t2. Carga Horária;\n\t3. Código;\n\t4. Remover Disciplinas;");
													System.out.println("\t5. Adicionar Disciplinas; 6. Voltar;");
													System.out.print("->");
													aux_att = input.nextInt();
												}while(aux_att < 1 || aux_att > 6);
											switch(aux_att){
												case 1:
													System.out.print("\n\tInsira o novo nome:\n\t->");
													nome = input.nextLine();
													nome = input.nextLine();
													nome = nome.toUpperCase();
													prof.set_nome(nome);
													System.out.println("\n\tNome atualizado com sucesso!");
													break;
												case 2:
													System.out.print("\n\tInsira a nova carga horária:\n\t->");
													carga_horaria = input.nextInt();
													prof.set_carga_horaria(carga_horaria);
													System.out.println("\n\tCarga Horária atualizado com sucesso!");
													break;
												case 3:
													System.out.print("\n\tInsira o novo código:\n\t->");
													codigo = input.nextInt();
													do{//Confere se já não existe algum professor o novo código inserido;
														check = false;
														for(curso_professor pro : professores){
															if(codigo == pro.get_codigo()){
																System.out.print("\n\tCódigo existente! Insira um novo código do professor:");
																codigo = input.nextInt();
																check = true;
																break;
															}
														}
													}while(check);
													prof.set_codigo(codigo);
													System.out.println("\n\tCódigo atualizado com sucesso!");
													break;
												case 4://Remove Disciĺina 
													System.out.print("\n\tInsira o código da disciplina a ser removida:\n\t->");
													codigo = input.nextInt();
													for(disciplina d : disciplinas){
														if(d.get_codigo() == codigo){	
															prof.remove_disc(d);
															break;
														}
													}
													System.out.println("\n\tDisciplina Removida com sucesso!");
													break;
												case 5://Adiciona Disciplina
													System.out.print("\n\tInsira o código da disciplina a ser adicionada:\n\t->");
													codigo = input.nextInt();
													for(disciplina d: disciplinas){
														if(d.get_codigo() == codigo){	
															prof.adiciona_disc(d);
															break;
														}
													}
													System.out.print("\n\tDisciplina adicionada com sucesso!");
													break;
											}
										}while(aux_att != 6);
									}
										break;
								}
								if(!proffound){
									System.out.println("\n\tProfessor não encontrado.");
								}
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
									nome = input.nextLine();
									nome = input.nextLine();
									nome = nome.toUpperCase();
									System.out.println();
									System.out.print("\n\tInsira o carga horária do aluno:");
									carga_horaria = input.nextInt();
									System.out.println();
									System.out.print("\n\tInsira o código do aluno:");
									codigo = input.nextInt();
									do{
										studentfound = false;
										for(aluno stud : alunos){
											if(codigo == stud.get_codigo()){
												System.out.print("\n\tCódigo existente! Insira um novo código do aluno:");
												codigo = input.nextInt();
												studentfound = true;
												break;
											}
										}
									}while(studentfound);
									System.out.println();

									for(curso_professor curso : cursos){// Exibe todos os cursos cadastrados
										curso.exibe_codigo_nome();
									}

									System.out.print("\n\tInsira o código do curso do aluno:");
									procurar = input.nextInt();
									System.out.println();

									for(check = false, i = 0; i < cursos.size(); i++){ // Procura na lista de cursos, se o curso existe
										aux_curso = cursos.get(i);
										if(procurar == aux_curso.get_codigo()){
											check = true;
											break;
										}
									}
									if(check){ // Encontrou o curso na lista
										aux_aluno = new aluno(nome,carga_horaria,codigo,aux_curso);
										codigo = -1;
										System.out.println();
										while(codigo != 0 && disciplinas.size() != 0){
											aux_curso.lista_disc_curso();
											System.out.print("\n\tInsira uma Disciplina (Digite \"0\" para sair):");
											codigo = input.nextInt();
											if(codigo != 0){
												aux_disc = aux_curso.procura_discp_curso(codigo);// Procura se a disciplina existe no curso(Retorna o obj. ou null se não existe); 
												if(aux_disc == null){
													System.out.print("\n\tDisciplina não encontrada no curso!");
												}
												else{
													aux_aluno.adiciona_disc(aux_disc); 
												}
											}
										}
									}
									else{ // Não encontrou o curso na lista
										aux_aluno = new aluno(nome,carga_horaria,codigo);
										System.out.print("\n\t Aluno cadastrado sem curso!");
									}
								}
								else{ // Não existe cursos na lista
									System.out.println("\n\tCadastre um curso para atualizar o cadastro do aluno (aluno cadastrado sem informações).");
									aux_aluno = new aluno();
								}
								alunos.add(aux_aluno);
								break;
							case 2: // Consulta aluno
								for(aluno stud : alunos){// Exibe todos os alunos cadastrados
									stud.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código do aluno a ser buscado: ");
								codigo = input.nextInt();
								studentfound = false;
								for(aluno stud : alunos){// Verifica a existência do aluno na lista de alunos
									if(stud.get_codigo() == codigo){ 
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
								for(aluno stud : alunos){// Exibe todos os alunos cadastrados
									stud.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código do aluno a ser removido: ");
								codigo = input.nextInt();
								check = false;
								for(aluno stud : alunos){
									if(codigo == stud.get_codigo()){
										alunos.remove(stud);// Removendo o aluno da lista
										check = true;
										break;
									}
								}
								if(!check){//Se não achar printa
									System.out.println("\n\tAluno não encontrado.");
								}
								break;
							case 4: // Aualizar aluno
								for(curso_professor professor : professores){// Exibe todos os professores cadastrados
									professor.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código do professor a ser atualizado: ");
								codigo = input.nextInt();
								proffound = false;
								for(curso_professor prof : professores){// Verifica a existência do professor na lista de professores
									if(prof.get_codigo() == codigo){ 
										proffound = true;
										do{
											do{
												prof.exibe(false);
												System.out.println("\n\t Atualizar:");
												System.out.println("\t1. Nome;\n\t2. Carga Horária;\n\t3. Código;\n\t4. Remover Disciplinas;");
												System.out.println("\t5. Adicionar Disciplinas;\n\t6. Atualizar Curso;\n\t7. Voltar;");
												System.out.print("->");
												aux_att = input.nextInt();
											}while(aux_att < 1 || aux_att > 6);
											switch(aux_att){
												case 1:
													System.out.print("\n\tInsira o novo nome:\n\t->");
													nome = input.nextLine();
													nome = input.nextLine();
													nome = nome.toUpperCase();
													prof.set_nome(nome);
													System.out.println("\n\tNome atualizado com sucesso!");
													break;
												case 2:
													System.out.print("\n\tInsira a nova carga horária:\n\t->");
													carga_horaria = input.nextInt();
													prof.set_carga_horaria(carga_horaria);
													System.out.println("\n\tCarga Horária atualizado com sucesso!");
													break;
												case 3:
													System.out.print("\n\tInsira o novo código:\n\t->");
													codigo = input.nextInt();
													do{//Confere se já não existe algum professor o novo código inserido;
														check = false;
														for(curso_professor pro : professores){
															if(codigo == pro.get_codigo()){
																System.out.print("\n\tCódigo existente! Insira um novo código do professor:");
																codigo = input.nextInt();
																check = true;
																break;
															}
														}
													}while(check);
													prof.set_codigo(codigo);
													System.out.println("\n\tCódigo atualizado com sucesso!");
													break;
												case 4://Remove Disciĺina 
													System.out.print("\n\tInsira o código da disciplina a ser removida:\n\t->");
													codigo = input.nextInt();
													for(disciplina d : disciplinas){
														if(d.get_codigo() == codigo){	
															prof.remove_disc(d);
															break;
														}
													}
													System.out.println("\n\tDisciplina Removida com sucesso!");
													break;
												case 5://Adiciona Disciplina
													printa(disciplinas);
													System.out.print("\n\tInsira o código da disciplina a ser adicionada:\n\t->");
													codigo = input.nextInt();
													for(disciplina d: disciplinas){
														if(d.get_codigo() == codigo){	
															.adiciona_disc(d);
															break;
														}
													}
													System.out.print("\n\tDisciplina adicionada com sucesso!");
													break;
												case 6://Atualiza Curso 
													System.out.print("\n\tInsira o código do curso:");
											}
										}while(aux_att != 7);
									}
									break;
								}
								if(!proffound){
									System.out.println("\n\tProfessor não encontrado.");
								}
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
								nome = input.nextLine();
								nome = input.nextLine();
								nome = nome.toUpperCase();
								System.out.println();
								System.out.print("\n\tInsira o carga horária do curso:");
								carga_horaria = input.nextInt();
								System.out.println();
								System.out.print("\n\tInsira o código do curso:");
								codigo = input.nextInt();
								do{
									cursofound = false;
									for(curso_professor curso : cursos){
										if(codigo == curso.get_codigo()){
											System.out.print("\n\tCódigo existente! Insira um novo código do curso:");
											codigo = input.nextInt();
											cursofound = true;
											break;
										}
									}
								}while(cursofound);
								System.out.println();

								aux_curso = new curso_professor(nome,carga_horaria,codigo);

								codigo = -1;
								while(codigo != 0 && disciplinas.size() != 0){
									System.out.println();
									for(disciplina aux : disciplinas){// Lista as disciplinas existentes na lista de disciplinas 
										aux.exibe_codigo_nome();
									}
									System.out.print("\n\tInsira o código de uma disciplina (Digite \"0\" para sair):");
									codigo = input.nextInt();									
									if(codigo != 0){
										subfound = false;
										for(disciplina discip : disciplinas){// Verifica a existência da disciplina na lista de disciplinas
											if(discip.get_codigo() == codigo){ 
												aux_curso.adiciona_disc(discip);
												subfound = true;
												break;
											}
										}
										if(!subfound){
											System.out.print("\n\tDisciplina não encontrada.");
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
								for(curso_professor curso : cursos){// Exibe todos os cursos cadastrados
									curso.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código do curso a ser removido: ");
								codigo = input.nextInt();
								check = false;
								for(i = 0; i < cursos.size(); i++){
									aux_curso = cursos.get(i);
									if(codigo == aux_curso.get_codigo()){
										cursos.remove(i);// Removendo o curso da lista
										check = true;
										break;
									}
								}
								if(!check){// Se não achar printa
									System.out.println("\n\tCurso não encontrado.");
								}
								else{
									for(aluno stud : alunos){
										if(stud.get_curso() == aux_curso)
											stud.set_curso(null);
									}
								}
								break;
							case 4: // Atualizar curso
								
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
								nome = input.nextLine();
								nome = input.nextLine();
								nome = nome.toUpperCase();
								System.out.println();
								System.out.print("\n\tInsira o carga horária da disciplina:");
								carga_horaria = input.nextInt();
								System.out.println();
								System.out.print("\n\tInsira o código da disciplina:");
								codigo = input.nextInt();
								do{
									subfound = false;
									for(disciplina disc : disciplinas){
										if(codigo == disc.get_codigo()){
											System.out.print("\n\tCódigo existente! Insira um novo código do disciplina:");
											codigo = input.nextInt();
											subfound = true;
											break;
										}
									}
								}while(subfound);
								System.out.println();

								aux_disc = new disciplina(nome,carga_horaria,codigo);

								disciplinas.add(aux_disc);
								break;
							case 2: // Consulta disciplina
								for(disciplina disc : disciplinas){// Exibe todos os cursos cadastrados
									disc.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código da disciplina a ser buscada: ");
								codigo = input.nextInt();
								subfound = false;
								for(disciplina disc : disciplinas){// Verifica a existência da disciplina na lista de disciplinas
									if(disc.get_codigo() == codigo){ 
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
								for(disciplina disc : disciplinas){// Exibe todos as disciplinas cadastradas
									disc.exibe_codigo_nome();
									System.out.println();
								}
								System.out.print("\n\tInsira o código da disciplina a ser removida: ");
								codigo = input.nextInt();
								check = false;
								for(i = 0; i < disciplinas.size(); i++){
									aux_disc = disciplinas.get(i);
									if(codigo == aux_disc.get_codigo()){
										disciplinas.remove(i);// Removendo a displina da lista
										check = true;
										break;
									}
								}
								if(!check){// Se não achar printa
									System.out.println("\n\tDisciplina não encontrada.");
								}
								else{
									for(aluno stud : alunos){
										stud.remove_disc(aux_disc);
									}
									for(curso_professor prof : professores){
										prof.remove_disc(aux_disc);
									}
									for(curso_professor curso : cursos){
										curso.remove_disc(aux_disc);
									}
								}
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
