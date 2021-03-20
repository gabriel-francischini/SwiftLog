package br.com.ies.padrõesdeprojeto;

import br.com.ies.padrõesdeprojeto.Observável1;

interface Observador1<ArgType> {
    public void notificar(ArgType argumento);
}