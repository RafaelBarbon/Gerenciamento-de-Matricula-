//Henrique Sartori Siqueira 					19240472
//Rafael Silva Barbon 							19243633

public class aluno extends curso_professor{//Herança 
    
    curso_professor curso;

    //Contrutores 
    public aluno(String nome, int carga_horaria, int codigo, curso_professor curso){
        super(nome, carga_horaria, codigo);
        this.curso = curso;
    }


    public aluno(){
        super();
    }

    public void set_curso(curso_professor curso){
        this.curso = curso;
    }

    //###VERFICAR
    public void get_curso(){
        curso.exibe(true);
    }

    //Exibição das informações na tela 
    @Override 
    public void exibe(){
        System.out.printf("\n\n\tNome: %s", get_nome());
        System.out.printf("\n\tCódigo: %d", get_codigo());
        System.out.printf("\n\tCarga Horária: %d horas", get_carga_horaria());
        System.out.printf("\n\tCurso:");
        get_curso();
        System.out.println("\n\tDisciplinas:");
        exibe_disc();
    }
}