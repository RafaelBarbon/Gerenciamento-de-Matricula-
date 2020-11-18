//Henrique Sartori Siqueira 					19240472
//Rafael Silva Barbon 							19243633

import java.util.*;

public class menu{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int optionprincipal = 0,optionsecundaria = 0, codigo = 0, carga_horaria = 0, i = 0, procurar = 0, aux_att = 0;
		String nome = "\0";
		boolean subfound = false, proffound = false, studentfound = false, check = false, cursofound = false, error = false;
		LinkedList <disciplina> disciplinas = new LinkedList<disciplina>();
		LinkedList <curso_professor> professores = new LinkedList<curso_professor>();
		LinkedList <curso_professor> cursos = new LinkedList<curso_professor>();
		LinkedList <aluno> alunos = new LinkedList<aluno>();
		
		aluno aux_aluno = null;
		curso_professor aux_professor = null, aux_curso = null;
		disciplina aux_disc = null;

		do{
			do{ // Menu principal
				try{
					error = false;
					System.out.println("\n1. Gerenciar Professor;");
					System.out.println("\n2. Gerenciar Aluno;");
					System.out.println("\n3. Gerenciar Curso;");
					System.out.println("\n4. Gerenciar Disciplina;");
					System.out.println("\n5. Sair.");
					System.out.print("\n-> ");
					optionprincipal = input.nextInt();
				}
				catch(InputMismatchException InputMismatchException){
					System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
					input.nextLine();
					error = true;
				}
			}while(error || optionprincipal > 5 || optionprincipal < 1);
			switch (optionprincipal){
				case 1: // Submenu Professor
					do{
						do{
							try{
								error = false;
								submenu("Professor");
								optionsecundaria = input.nextInt();
							}
							catch(InputMismatchException InputMismatchException){
								System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
								input.nextLine();
								error = true;
							}
						}while(error || optionsecundaria > 5 || optionsecundaria < 1);
						switch (optionsecundaria){
							case 1: // Cadastro professor
								System.out.print("\n\tInsira o nome do professor:");
								nome = input.nextLine();
								nome = input.nextLine();
								nome = nome.toUpperCase();
								System.out.println();
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o carga horária do professor:");
										carga_horaria = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								System.out.println();
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do professor:");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								do{
									proffound = false;
									for(curso_professor prof : professores){
										if(codigo == prof.get_codigo()){
											do{
												try{
													error = false;
													System.out.print("\n\tCódigo existente! Insira um novo código do professor:");
													codigo = input.nextInt();
												}
												catch(InputMismatchException InputMismatchException){
													System.out.println("\n\tInsira um número inteiro para prosseguir.");
													input.nextLine();
													error = true;
												}
											}while(error);
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
									printa(disciplinas); // Lista as disciplinas existentes na lista de disciplinas 
									do{
										try{
											error = false;
											System.out.print("\n\tInsira o código de uma disciplina (Digite \"0\" para sair):");
											codigo = input.nextInt();
										}
										catch(InputMismatchException InputMismatchException){
											System.out.println("\n\tInsira um número inteiro para prosseguir.");
											input.nextLine();
											error = true;
										}
									}while(error);
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
								printa(professores);// Exibe todos os professores cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do professor a ser buscado: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
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
								printa(professores);// Exibe todos os professores cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do professor a ser removido: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
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
								printa(professores);// Exibe todos os professores cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do professor a ser atualizado: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								proffound = false;
								for(curso_professor prof : professores){// Verifica a existência do professor na lista de professores
									if(prof.get_codigo() == codigo){ 
										proffound = true;
										do{
											do{
												try{
													error = false;
													prof.exibe(false);
													System.out.println("\n\t Atualizar:");
													System.out.println("\t1. Nome;\n\t2. Carga Horária;\n\t3. Código;\n\t4. Remover Disciplinas;");
													System.out.println("\t5. Adicionar Disciplinas;\n\t 6. Voltar;");
													System.out.print("->");
													aux_att = input.nextInt();
												}
												catch(InputMismatchException InputMismatchException){
													System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
													input.nextLine();
													error = true;
												}
											}while(error || aux_att < 1 || aux_att > 6);
											switch(aux_att){
												case 1: // Atualiza nome
													System.out.print("\n\tInsira o novo nome:\n\t->");
													nome = input.nextLine();
													nome = input.nextLine();
													nome = nome.toUpperCase();
													prof.set_nome(nome);
													System.out.println("\n\tNome atualizado com sucesso!");
													break;
												case 2: // Atualiza carga horário
													do{
														try{
															error = false;
															System.out.print("\n\tInsira a nova carga horária:\n\t->");
															carga_horaria = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													prof.set_carga_horaria(carga_horaria);
													System.out.println("\n\tCarga Horária atualizado com sucesso!");
													break;
												case 3: // Atualiza código
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o novo código:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													do{ // Confere se já não existe algum professor o novo código inserido;
														check = false;
														for(curso_professor pro : professores){
															if(codigo == pro.get_codigo()){
																do{
																	try{
																		error = false;
																		System.out.print("\n\tCódigo existente! Insira um novo código do professor:");
																		codigo = input.nextInt();
																	}
																	catch(InputMismatchException InputMismatchException){
																		System.out.println("\n\tInsira um número inteiro para prosseguir.");
																		input.nextLine();
																		error = true;
																	}
																}while(error);
																check = true;
																break;
															}
														}
													}while(check);
													prof.set_codigo(codigo);
													System.out.println("\n\tCódigo atualizado com sucesso!");
													break;
												case 4: // Remove Discipĺina da lista interna do professor
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o código da disciplina a ser removida:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
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
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o código da disciplina a ser adicionada:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
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
										break;
									}
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
							try{
								error = false;
								submenu("Aluno");
								optionsecundaria = input.nextInt();
							}
							catch(InputMismatchException InputMismatchException){
								System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
								input.nextLine();
								error = true;
							}
						}while(error || optionsecundaria > 5 || optionsecundaria < 1);
						switch (optionsecundaria){
							case 1: // Cadastro aluno
								if(cursos.size() != 0){
									System.out.print("\n\tInsira o nome do aluno:");
									nome = input.nextLine();
									nome = input.nextLine();
									nome = nome.toUpperCase();
									System.out.println();
									do{
										try{
											error = false;
											System.out.print("\n\tInsira o carga horária do aluno:");
											carga_horaria = input.nextInt();
										}
										catch(InputMismatchException InputMismatchException){
											System.out.println("\n\tInsira um número inteiro para prosseguir.");
											input.nextLine();
											error = true;
										}
									}while(error);
									System.out.println();
									do{
										try{
											error = false;
											System.out.print("\n\tInsira o código do aluno:");
											codigo = input.nextInt();
										}
										catch(InputMismatchException InputMismatchException){
											System.out.println("\n\tInsira um número inteiro para prosseguir.");
											input.nextLine();
											error = true;
										}
									}while(error);
									do{
										studentfound = false;
										for(aluno stud : alunos){
											if(codigo == stud.get_codigo()){
												do{
													try{
														error = false;
														System.out.print("\n\tCódigo existente! Insira um novo código do aluno:");
														codigo = input.nextInt();
													}
													catch(InputMismatchException InputMismatchException){
														System.out.println("\n\tInsira um número inteiro para prosseguir.");
														input.nextLine();
														error = true;
													}
												}while(error);
												studentfound = true;
												break;
											}
										}
									}while(studentfound);
									System.out.println();

									printa(cursos);// Exibe todos os cursos cadastrados
									do{
										try{
											error = false;
											System.out.print("\n\tInsira o código do curso do aluno:");
											procurar = input.nextInt();
										}
										catch(InputMismatchException InputMismatchException){
											System.out.println("\n\tInsira um número inteiro para prosseguir.");
											input.nextLine();
											error = true;
										}
									}while(error);
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
											aux_curso.lista_disc();
											do{
												try{
													error = false;
													System.out.print("\n\tInsira uma Disciplina (Digite \"0\" para sair):");
													codigo = input.nextInt();
												}
												catch(InputMismatchException InputMismatchException){
													System.out.println("\n\tInsira um número inteiro para prosseguir.");
													input.nextLine();
													error = true;
												}
											}while(error);
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
								printa(alunos);// Exibe todos os alunos cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do aluno a ser buscado: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
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
								printa(alunos);// Exibe todos os alunos cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do aluno a ser removido: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
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
								printa(alunos);// Exibe todos os aluno cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do aluno a ser atualizado: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								studentfound = false;
								for(aluno stud : alunos){// Verifica a existência do aluno na lista de alunos
									if(stud.get_codigo() == codigo){ 
										studentfound = true;
										do{
											do{
												try{
													error = false;
													stud.exibe();
													System.out.println("\n\t Atualizar:");
													System.out.println("\t1. Nome;\n\t2. Carga Horária;\n\t3. Código;\n\t4. Remover Disciplinas;");
													System.out.println("\t5. Adicionar Disciplinas;\n\t6. Atualizar Curso;\n\t7. Voltar;");
													System.out.print("->");
													aux_att = input.nextInt();
												}
												catch(InputMismatchException InputMismatchException){
													System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
													input.nextLine();
													error = true;
												}
											}while(error || aux_att < 1 || aux_att > 7);
											switch(aux_att){
												case 1:
													System.out.print("\n\tInsira o novo nome:\n\t->");
													nome = input.nextLine();
													nome = input.nextLine();
													nome = nome.toUpperCase();
													stud.set_nome(nome);
													System.out.println("\n\tNome atualizado com sucesso!");
													break;
												case 2:
													do{
														try{
															error = false;
															System.out.print("\n\tInsira a nova carga horária:\n\t->");
															carga_horaria = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													stud.set_carga_horaria(carga_horaria);
													System.out.println("\n\tCarga Horária atualizado com sucesso!");
													break;
												case 3:
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o novo código:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													do{//Confere se já não existe algum aluno com o novo código inserido;
														check = false;
														for(aluno st : alunos){
															if(codigo == st.get_codigo()){
																do{
																	try{
																		error = false;
																		System.out.print("\n\tCódigo existente! Insira um novo código do aluno:");
																		codigo = input.nextInt();
																	}
																	catch(InputMismatchException InputMismatchException){
																		System.out.println("\n\tInsira um número inteiro para prosseguir.");
																		input.nextLine();
																		error = true;
																	}
																}while(error);
																check = true;
																break;
															}
														}
													}while(check);
													stud.set_codigo(codigo);
													System.out.println("\n\tCódigo atualizado com sucesso!");
													break;
												case 4://Remove Discipĺina 
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o código da disciplina a ser removida:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													for(disciplina d : disciplinas){
														if(d.get_codigo() == codigo){	
															stud.remove_disc(d);
															break;
														}
													}
													System.out.println("\n\tDisciplina Removida com sucesso!");
													break;
												case 5://Adiciona Disciplina
													printa(disciplinas);
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o código da disciplina a ser adicionada:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													for(disciplina d: disciplinas){
														if(d.get_codigo() == codigo){	
															stud.adiciona_disc(d);
															break;
														}
													}
													System.out.print("\n\tDisciplina adicionada com sucesso!");
													break;
												case 6://Atualiza Curso 
													printa(cursos);
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o código do curso:");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													for(curso_professor c: cursos){
														if(c.get_codigo() == codigo){	
															stud.set_curso(c);
															break;
														}
													}
											}
										}while(aux_att != 7);
										break;
									}
								}
								if(!studentfound){
									System.out.println("\n\tAluno não encontrado.");
								}
								break;
						}
					}while(optionsecundaria < 5 && optionsecundaria > 0);
					break;
				case 3: // Submenu Curso
					do{
						do{
							try{
								error = false;
								submenu("Curso");
								optionsecundaria = input.nextInt();
							}
							catch(InputMismatchException InputMismatchException){
								System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
								input.nextLine();
								error = true;
							}
						}while(error || optionsecundaria > 5 || optionsecundaria < 1);
						switch (optionsecundaria){
							case 1: // Cadastro curso
								System.out.print("\n\tInsira o nome do curso:");
								nome = input.nextLine();
								nome = input.nextLine();
								nome = nome.toUpperCase();
								System.out.println();
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o carga horária do curso:");
										carga_horaria = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								System.out.println();
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do curso:");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								do{
									cursofound = false;
									for(curso_professor curso : cursos){
										if(codigo == curso.get_codigo()){
											do{
												try{
													error = false;
													System.out.print("\n\tCódigo existente! Insira um novo código do curso:");
													codigo = input.nextInt();
												}
												catch(InputMismatchException InputMismatchException){
													System.out.println("\n\tInsira um número inteiro para prosseguir.");
													input.nextLine();
													error = true;
												}
											}while(error);
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
									printa(disciplinas);// Lista as disciplinas existentes na lista de disciplinas 
									do{
										try{
											error = false;
											System.out.print("\n\tInsira o código de uma disciplina (Digite \"0\" para sair):");
											codigo = input.nextInt();
										}
										catch(InputMismatchException InputMismatchException){
											System.out.println("\n\tInsira um número inteiro para prosseguir.");
											input.nextLine();
											error = true;
										}
									}while(error);
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
								printa(cursos);// Exibe todos os cursos cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do curso a ser removido: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
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
								printa(cursos);// Exibe todos os cursos cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código do curso a ser atualizado: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								cursofound = false;
								for(curso_professor curso : cursos){// Verifica a existência do curso na lista de cursos
									if(curso.get_codigo() == codigo){
										procurar = curso.get_codigo();
										cursofound = true;
										do{
											do{
												try{
													error = false;
													curso.exibe(false);
													System.out.println("\n\t Atualizar:");
													System.out.println("\t1. Nome;\n\t2. Carga Horária;\n\t3. Código;\n\t4. Remover Disciplinas;");
													System.out.println("\t5. Adicionar Disciplinas;\n\t 6. Voltar;");
													System.out.print("->");
													aux_att = input.nextInt();
												}
												catch(InputMismatchException InputMismatchException){
													System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
													input.nextLine();
													error = true;
												}
											}while(error || aux_att < 1 || aux_att > 6);
											switch(aux_att){
												case 1: // Atualiza nome
													System.out.print("\n\tInsira o novo nome:\n\t->");
													nome = input.nextLine();
													nome = input.nextLine();
													nome = nome.toUpperCase();
													curso.set_nome(nome);
													System.out.println("\n\tNome atualizado com sucesso!");
													break;
												case 2: // Atualiza carga horário
													do{
														try{
															error = false;
															System.out.print("\n\tInsira a nova carga horária:\n\t->");
															carga_horaria = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													curso.set_carga_horaria(carga_horaria);
													System.out.println("\n\tCarga Horária atualizado com sucesso!");
													break;
												case 3: // Atualiza código
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o novo código:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													do{ // Confere se já não existe algum curso com o novo código inserido;
														check = false;
														for(curso_professor c : cursos){
															if(codigo == c.get_codigo()){
																do{
																	try{
																		error = false;
																		System.out.print("\n\tCódigo existente! Insira um novo código do curso:");
																		codigo = input.nextInt();
																	}
																	catch(InputMismatchException InputMismatchException){
																		System.out.println("\n\tInsira um número inteiro para prosseguir.");
																		input.nextLine();
																		error = true;
																	}
																}while(error);
																check = true;
																break;
															}
														}
													}while(check);
													curso.set_codigo(codigo);
													System.out.println("\n\tCódigo atualizado com sucesso!");
													break;
												case 4: // Remove Discipĺina da lista interna do curso
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o código da disciplina a ser removida:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													for(disciplina d : disciplinas){
														if(d.get_codigo() == codigo){	
															curso.remove_disc(d);
															break;
														}
													}
													System.out.println("\n\tDisciplina Removida com sucesso!");
													break;
												case 5: // Adiciona Disciplina
													printa(disciplinas);
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o código da disciplina a ser adicionada:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													for(disciplina d : disciplinas){
														if(d.get_codigo() == codigo){	
															curso.adiciona_disc(d);
															break;
														}
													}
													System.out.print("\n\tDisciplina adicionada com sucesso!");
													break;
											}
										}while(aux_att != 6);
										aux_curso = curso;
										break;
									}
								}
								if(!cursofound){
									System.out.println("\n\tCurso não encontrado.");
								}
								else{
									for(aluno st : alunos){
										st.att_curso(aux_curso, procurar);
									}
								}
								break;
						}
					}while(optionsecundaria < 5 && optionsecundaria > 0);
					break;
				case 4: // Submenu Disciplina
					do{
						do{
							try{
								error = false;
								submenu("Disciplina");
								optionsecundaria = input.nextInt();
							}
							catch(InputMismatchException InputMismatchException){
								System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
								input.nextLine();
								error = true;
							}
						}while(error || optionsecundaria > 5 || optionsecundaria < 1);
						switch (optionsecundaria){
							case 1: // Cadastro disciplina
								System.out.print("\n\tInsira o nome da disciplina:");
								nome = input.nextLine();
								nome = input.nextLine();
								nome = nome.toUpperCase();
								System.out.println();
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o carga horária da disciplina:");
										carga_horaria = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								System.out.println();
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código da disciplina:");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								do{
									subfound = false;
									for(disciplina disc : disciplinas){
										if(codigo == disc.get_codigo()){
											do{
												try{
													error = false;
													System.out.print("\n\tCódigo existente! Insira um novo código do disciplina:");
													codigo = input.nextInt();
												}
												catch(InputMismatchException InputMismatchException){
													System.out.println("\n\tInsira um número inteiro para prosseguir.");
													input.nextLine();
													error = true;
												}
											}while(error);
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
								printa(disciplinas);// Exibe todos os cursos cadastrados
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código da disciplina a ser buscada: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
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
								printa(disciplinas);// Exibe todos as disciplinas cadastradas
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código da disciplina a ser removida: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
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
								printa(disciplinas);// Exibe todas as disciplinas cadastradas
								do{
									try{
										error = false;
										System.out.print("\n\tInsira o código da disciplina a ser atualizado: ");
										codigo = input.nextInt();
									}
									catch(InputMismatchException InputMismatchException){
										System.out.println("\n\tInsira um número inteiro para prosseguir.");
										input.nextLine();
										error = true;
									}
								}while(error);
								subfound = false;
								for(disciplina disc : disciplinas){// Verifica a existência da disciplina na lista de disciplinas
									if(disc.get_codigo() == codigo){ 
										subfound = true;
										procurar = disc.get_codigo();
										do{
											do{
												try{
													error = false;
													disc.exibe();
													System.out.println("\n\t Atualizar:");
													System.out.println("\t1. Nome;\n\t2. Carga Horária;\n\t3. Código;\n\t4. Voltar;");
													System.out.print("->");
													aux_att = input.nextInt();
												}
												catch(InputMismatchException InputMismatchException){
													System.out.println("\n\tInsira um número inteiro dentro do intervalo para prosseguir.");
													input.nextLine();
													error = true;
												}
											}while(error || aux_att < 1 || aux_att > 4);
											switch(aux_att){
												case 1: // Atualiza nome
													System.out.print("\n\tInsira o novo nome:\n\t->");
													nome = input.nextLine();
													nome = input.nextLine();
													nome = nome.toUpperCase();
													disc.set_nome(nome);
													System.out.println("\n\tNome atualizado com sucesso!");
													break;
												case 2: // Atualiza carga horário
													do{
														try{
															error = false;
															System.out.print("\n\tInsira a nova carga horária:\n\t->");
															carga_horaria = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													disc.set_carga_horaria(carga_horaria);
													System.out.println("\n\tCarga Horária atualizado com sucesso!");
													break;
												case 3: // Atualiza código
													do{
														try{
															error = false;
															System.out.print("\n\tInsira o novo código:\n\t->");
															codigo = input.nextInt();
														}
														catch(InputMismatchException InputMismatchException){
															System.out.println("\n\tInsira um número inteiro para prosseguir.");
															input.nextLine();
															error = true;
														}
													}while(error);
													do{ // Confere se já não existe alguma disciplina com o novo código inserido;
														check = false;
														for(disciplina d : disciplinas){
															if(codigo == d.get_codigo()){
																do{
																	try{
																		error = false;
																		System.out.print("\n\tCódigo existente! Insira um novo código da disciplina:");
																		codigo = input.nextInt();
																	}
																	catch(InputMismatchException InputMismatchException){
																		System.out.println("\n\tInsira um número inteiro para prosseguir.");
																		input.nextLine();
																		error = true;
																	}
																}while(error);
																check = true;
																break;
															}
														}
													}while(check);
													disc.set_codigo(codigo);
													System.out.println("\n\tCódigo atualizado com sucesso!");
													break;
											}
										}while(aux_att != 4);
										aux_disc = disc;
										break;
									}
								}
								if(!subfound){
									System.out.println("\n\tDisciplina não encontrada.");
								}
								else{
									for(aluno st : alunos){
										st.att_disc(aux_disc, procurar);
									}
									for(curso_professor prof : professores){
										prof.att_disc(aux_disc, procurar);
									}
									for(curso_professor curso : cursos){
										curso.att_disc(aux_disc, procurar);
									}
								}
								break;
						}
					}while(optionsecundaria < 5 && optionsecundaria > 0);
					break;
			}
		}while(optionprincipal < 5 && optionprincipal > 0);
	}

	public static <T> void printa(LinkedList <T> lista){
		for(T li : lista){
			System.out.printf("\t%s", li);
		}
	}

	public static void submenu(String tipo){
		System.out.printf("\n1. Cadastrar %s;\n",tipo);
		System.out.printf("\n2. Consultar %s;\n",tipo);
		System.out.printf("\n3. Remover %s;\n",tipo);
		System.out.printf("\n4. Atualizar %s;\n",tipo);
		System.out.printf("\n5. MENUPrincipal.\n",tipo);
		System.out.print("\n-> ");
	}

}
