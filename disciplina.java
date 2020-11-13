//Henrique Sartori Siqueira 					19240472
//Rafael Silva Barbon 							19243633

public class disciplina {
    
    private String nome;
    private int carga_horaria, codigo;
    
    public disciplina(String nome, int carga_horaria, int codigo){
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.codigo = codigo;
    }

    public disciplina(){
        this.nome = "Sem Nome";
        this.carga_horaria = 0;
        this.codigo = 0;
    }

    //Métodos de coleta das informações
    public String get_nome(){
        return this.nome;
    }

    public int get_carga_horaria(){
        return this.carga_horaria;
    }

    public int get_codigo(){
        return this.codigo;
    }

    //Métodos para atualização das informações
    public void set_nome(String nome){
        this.nome = nome;
    }


    public void set_carga_horaria(int carga_horaria){
        this.carga_horaria = carga_horaria;
    }


    public void set_codigo(int codigo){
        this.codigo = codigo;
    }

    public void exibe(){
        System.out.printf("\n\tNome: %s.", get_nome());
        System.out.printf("\n\tCódigo: %d.", get_codigo());
        System.out.printf("\n\tCarga Horária: %d horas.", get_carga_horaria());
	}
	
	public void exibe_codigo_nome(){
		System.out.printf("\t%s - %d", this.get_nome(), this.get_codigo());
	}
}
