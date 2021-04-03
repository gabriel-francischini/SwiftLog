package br.com.ies.padrõesdeprojeto;

import br.com.ies.padrõesdeprojeto.Observável1;

public interface Observador1<ArgType> {
    public void notificar(ArgType argumento);
}