package com.rodalm.interfaceWeb4Linux.controlador;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.rodalm.interfaceWeb4Linux.modelo.Acesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ConexaoSSH {

    Acesso acesso = new Acesso();
    private JSch jsch = new JSch();

    @Autowired
    public ConexaoSSH(JSch jsch) {
        this.jsch = jsch;
    }

    public Session conectar(Acesso acesso) throws JSchException {

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");

        Session sessao = jsch.getSession(acesso.getUsuario(), acesso.getServidor(), acesso.getPorta());
        sessao.setPassword(acesso.getSenha());
        sessao.setConfig(config);
        sessao.connect(5000);
        System.out.println("Conexão SSH estabelecida com sucesso!");
        return sessao;

    }
}
