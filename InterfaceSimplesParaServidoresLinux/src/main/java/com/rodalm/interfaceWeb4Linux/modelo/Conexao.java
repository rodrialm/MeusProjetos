package com.rodalm.InterfaceSimplesParaServidoresLinux.modelo;

import java.util.Scanner;

public class Conexao {

    public Conexao() {
        pegarUsuario();
    }


    String servidor;
    String usuario;
    String senha;

    private void pegarUsuario(){
    Scanner entrada = new Scanner(System.in);
    System.out.print("Insira o Servidor: ");
    servidor = entrada.nextLine();

    System.out.print("Insira usuario: ");
    usuario = entrada.nextLine();

    System.out.print("senha: ");
    senha = entrada.nextLine();

    entrada.close();
    }

    @Override
    public String toString() {
        return servidor + "|" + usuario + "|" + senha ;
    }
}
