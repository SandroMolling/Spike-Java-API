public class Cliente extends Pessoa {
    private String email;
    private String endereco;

    public Cliente(String nome, String cpf, String email, String endereco) {
        super(nome, cpf);
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}