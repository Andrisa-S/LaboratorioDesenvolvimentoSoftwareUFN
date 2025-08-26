/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author parks
 */
public class Aluno {
    public String nomeCompleto;
    public String dataNascimento;
    public String sexo;
    public String matricula;
    public String curso;
    public String cpf;
    public String enderecoCompleto;
    public String estado;
    public String telefoneContato;

    public Aluno(String nomeCompleto, String dataNascimento, String sexo, String matricula, String curso, String cpf, String enderecoCompleto, String estado, String telefoneContato) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.enderecoCompleto = enderecoCompleto;
        this.estado = estado;
        this.telefoneContato = telefoneContato;
    }
    
    public Object[] obterDados(){
        return new Object[] {nomeCompleto, dataNascimento, sexo, matricula, curso, cpf, enderecoCompleto, estado, telefoneContato};
    }
    
    // Método para converter os dados em formato de string para salvar no arquivo
    public String toFileString() {
        return nomeCompleto + ";" + dataNascimento + ";" + sexo + ";" + matricula + ";" + 
               curso + ";" + cpf + ";" + enderecoCompleto + ";" + estado + ";" + telefoneContato;
    }
    
    // Método estático para criar um Aluno a partir de uma string do arquivo
    public static Aluno fromFileString(String fileString) {
        String[] dados = fileString.split(";");
        if (dados.length == 9) {
            return new Aluno(dados[0], dados[1], dados[2], dados[3], dados[4], 
                           dados[5], dados[6], dados[7], dados[8]);
        }
        return null;
    }
}
