package fja.com.br.projetomobileammamentar.models;

public class Pessoa {


    private Integer idCadastroPessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String senha;
    private String endereco;

    public Pessoa(Integer idCadastroPessoa, String nome, String cpf, String rg, String telefone, String email, String senha, String endereco) {
        this.idCadastroPessoa = idCadastroPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Pessoa() {

    }

    public Integer getIdCadastroPessoa() {
        return idCadastroPessoa;
    }

    public void setIdCadastroPessoa(Integer idCadastroPessoa) {
        this.idCadastroPessoa = idCadastroPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
