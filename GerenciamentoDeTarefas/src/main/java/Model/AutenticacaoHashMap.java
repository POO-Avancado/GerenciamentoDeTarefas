package Model;

import java.util.HashMap;

public class AutenticacaoHashMap implements Autenticacao {
    private HashMap<String, String> usuarios;

    public AutenticacaoHashMap() {
        usuarios = new HashMap<>();
    }

    @Override
    public void cadastrarUsuario(String nomeUsuario, String senha) {
        if (usuarios.containsKey(nomeUsuario)) {
            System.out.println("Este nome de usuário já está em uso.");
            return;
        }

        usuarios.put(nomeUsuario, senha);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    @Override
    public boolean autenticarUsuario(String nomeUsuario, String senha) {
        return usuarios.containsKey(nomeUsuario) && usuarios.get(nomeUsuario).equals(senha);
    }
}
