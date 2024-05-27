package Model;

public interface Autenticacao {
    void cadastrarUsuario(String nomeUsuario, String senha);
    boolean autenticarUsuario(String nomeUsuario, String senha);
}
