//Henrique Sartori Siqueira 					19240472
//Rafael Silva Barbon 							19243633

import java.util.*;

public class curso_professor extends disciplina{//Herança

    //Lista de objetos do tipo D
    private LinkedList <disciplina> disciplinas = new LinkedList<disciplina>(); //Lista ligada de disciplinas

    //Contrutores
    public curso_professor(String nome, int carga_horaria, int codigo){
        super(nome, carga_horaria, codigo);
    }


    public curso_professor(){
        super();
    }

    // Adiciona Disciplina
    public void adiciona_disc(disciplina disc){
        boolean exist = false;
		for(disciplina discip : this.disciplinas){//Verifica se o professor já possui a discplina cadastrada
			if(discip.get_codigo() == disc.get_codigo()){
				exist = true;
				break;
			}
		}
		if(!exist){
            disciplinas.add(disc);
            System.out.println("\n\tDisciplina cadastrada com sucesso.");
        }
        else{
		    System.out.println("\n\tDisciplina já cadastrada!");
        }
    }

    // Remoção da Disciplina na lista
    public void remove_disc(disciplina disc){
        /*disciplina aux;
        for(int i = 0; i < disciplinas.size(); i++){
            aux = disciplinas.get(i);
            if(codigo == aux.get_codigo()){
                disciplinas.remove(i);// Removendo a displina da lista
                break;
            }
		}**/
		/*for(disciplina stud : disciplinas){
			if(stud == disc){

			}
		}*/
		disciplinas.remove(disc);
	}

	// Coleta o tamanho da lista de disciplinas
	protected int get_size_disc(){
		return this.disciplinas.size();
	}

	// Atualização de um objeto da lista de disciplinas
	public void att_disc(disciplina disc, int codigo){
		for(disciplina d : disciplinas){
			if(d.get_codigo() == codigo){
				disciplinas.remove(d);
				disciplinas.add(disc);
				break;
			}
		}
	}

	// Exibição das informações da lista de disciplinas
    protected void exibe_disc(){
        for(disciplina aux : disciplinas){
            aux.exibe();
        }
    }

    // Exibição das informações de um curso
    public void exibe(boolean aluno){
        System.out.printf("\n\tNome: %s.", get_nome());
        System.out.printf("\n\tCódigo: %d.", get_codigo());
        System.out.printf("\n\tCarga Horária: %d horas.", get_carga_horaria());
        if(!aluno){
			System.out.print("\n\tDisciplinas:");
			if(get_size_disc() == 0){
				System.out.println(" Inexistentes.");
			}
			else{
				exibe_disc();
			}
		}
		else{
			System.out.println();
		}
	}

	// Exibição das informações de um professor
	public void exibe(){
        System.out.printf("\n\tNome: %s.", get_nome());
        System.out.printf("\n\tCódigo: %d.", get_codigo());
		System.out.printf("\n\tCarga Horária: %d horas.", get_carga_horaria());
		System.out.print("\n\tDisciplinas:");
		if(get_size_disc() == 0){
			System.out.println(" Inexistentes.");
		}
		else{
			exibe_disc();
		}
	}

	// Método que procura se a disciplina selecionada existe no curso
    public disciplina procura_discp_curso(int codigo){// Procura se a disciplina existe no curso
        for(disciplina disc : this.disciplinas){
            if(disc.get_codigo() == codigo){
                return disc;
            }
        }
        return null;
    }

	// Método que retorna todos os nomes e códigos de disciplinas
    public void lista_disc(){
        for(disciplina aux : this.disciplinas){
            System.out.printf("\t%s",aux);
        }
	}

}