//Henrique Sartori Siqueira 					19240472
//Rafael Silva Barbon 							19243633

public class aluno extends curso_professor{//Herança

    private curso_professor curso;

	// Contrutores
	// Caso exista um curso
    public aluno(String nome, int carga_horaria, int codigo, curso_professor curso){
        super(nome, carga_horaria, codigo);
        this.curso = curso;
    }

	// Caso exista cursos, mas o código inserido não corresponde a nenhum deles
	public aluno(String nome, int carga_horaria, int codigo){
        super(nome, carga_horaria, codigo);
	}

	// Caso não exista cursos
    public aluno(){
        super();
    }

    public void set_curso(curso_professor curso){
        this.curso = curso;
    }

    public curso_professor get_curso(){
		return this.curso;
	}

	// Método que atualiza o curso do aluno
	public void att_curso(curso_professor curso, int codigo){
		if(this.curso.get_codigo() == codigo){
			set_curso(curso);
		}
	}


    // Exibição das informações na tela
    public void exibe(){
        System.out.printf("\n\n\tNome: %s.", get_nome());
        System.out.printf("\n\tCódigo: %d.", get_codigo());
		System.out.printf("\n\tCarga Horária: %d horas.", get_carga_horaria());
		System.out.printf("\n\tCurso:");
		if(curso != null){
			curso.exibe(true);
		}
		else{
			System.out.println(" Inexistente.");
		}
		System.out.print("\n\tDisciplinas:");
		if(get_size_disc() == 0){
			System.out.println(" Inexistentes.");
		}
		else{
			exibe_disc();
		}
    }
}