package com.rodalm.interfaceWeb4Linux.controlador;

import com.jcraft.jsch.*;
import com.rodalm.interfaceWeb4Linux.modelo.Acesso;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

@Service
public class ConexaoSSH {

    Acesso acesso = new Acesso();
    private JSch jsch = new JSch();
    public Session sessao = null;
    ChannelSftp channel = null;
    String filePath = "/home/rodrigo/site_callcenter.txt";
    StringBuilder content = new StringBuilder();

    public ConexaoSSH(JSch jsch) {
        this.jsch = jsch;
    }

    public Session conectar(Acesso acesso) throws JSchException {

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");

        sessao = jsch.getSession(acesso.getUsuario(), acesso.getServidor(), acesso.getPorta());
        sessao.setPassword(acesso.getSenha());
        sessao.setConfig(config);
        sessao.connect(5000);
        System.out.println("Conexão SSH estabelecida com sucesso!");
        abrirConexaoSFTP();
        return sessao;
    }

    public void abrirConexaoSFTP(){
        try {
            channel = (ChannelSftp) sessao.openChannel("sftp");
            channel.connect();
            InputStream inputStream = channel.get(filePath);

            try(Scanner entrada = new Scanner(inputStream)){
                while (entrada.hasNextLine()) {
                    content.append(entrada.nextLine()).append("\n");
                }
            }
            System.out.println(content);
        } catch (JSchException | SftpException e) {
            System.out.println("Erro SFTP: " + e.getMessage());
        }
    }
}
