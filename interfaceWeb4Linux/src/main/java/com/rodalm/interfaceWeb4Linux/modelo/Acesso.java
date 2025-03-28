package com.rodalm.interfaceWeb4Linux.modelo;

import org.springframework.context.annotation.Bean;

import java.util.Scanner;

public class Acesso {

    private String servidor;
    private String usuario;
    private String senha;
    private int porta;

    public Acesso() {

    }

    public Acesso(String servidor, int porta, String usuario, String senha) {
        this.porta = porta;
        this.senha = senha;
        this.usuario = usuario;
        this.servidor = servidor;
    }

    public void pegarUsuario() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Insira o Servidor: ");
        servidor = entrada.nextLine();

        System.out.print("Insira usuario: ");
        usuario = entrada.nextLine();

        System.out.print("senha: ");
        senha = entrada.nextLine();

        System.out.print("Porta (22 padrão): ");
        String portaConexao = entrada.nextLine();
        porta = portaConexao.isEmpty() ? 22 : Integer.parseInt(portaConexao);
        entrada.close();
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
}
