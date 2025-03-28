package com.rodalm.interfaceWeb4Linux.modelo;

public class ResultadoComandos {
    private final String saida;
    private final String erro;
    private final int retornoStatus;

    public ResultadoComandos(String saida, String erro, int retornoStatus){
        this.saida = saida;
        this.erro = erro;
        this.retornoStatus = retornoStatus;
    }

    public String getSaida() {
        return saida;
    }

    public String getErro() {
        return erro;
    }

    public int getRetornoStatus() {
        return retornoStatus;
    }
    public boolean isSucesso(){
        return retornoStatus == 0;
    }
}
