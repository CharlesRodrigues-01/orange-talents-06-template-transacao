package br.com.zupacademy.charles.transacao.exception;

public class ValidationMessage {

    private final String campo;
    private final String mensagem;

    public ValidationMessage(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
