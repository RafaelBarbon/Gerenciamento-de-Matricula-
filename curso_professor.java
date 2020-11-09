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

    //Adiciona Disciplina
    public void adiciona_disc(disciplina disc){
        disciplinas.add(disc);
    }

    //Remoção da Disciplina
    public void remove_disc(String nome){
        disciplina aux;
        boolean check = false;
        for(int i = 0; i < disciplinas.size(); i++){
            aux = disciplinas.get(i);
            if(nome.equals(aux.get_nome())){
                disciplinas.remove(i);//Removendo a displina da lista
                check = true;
                break;
            }
        }
        if(!check){//Se não achar printa
            System.out.println("\n\tDisciplina não encotrada");
        }
    }

    public void exibe_disc(){
        for(disciplina aux : disciplinas){ 
            aux.exibe();
        }
    }

    //Exibição das informações na tela  
    public void exibe(boolean aluno){
        System.out.printf("\n\n\tNome: %s", get_nome());
        System.out.printf("\n\tCódigo: %d", get_codigo());
        System.out.printf("\n\tCarga Horária: %d horas", get_carga_horaria());
        if(!aluno){
            System.out.println("\n\tDisciplinas:");
            exibe_disc();
        }
    }
}