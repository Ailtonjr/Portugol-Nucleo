/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import br.univali.portugol.nucleo.execucao.Interpretador;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca
(
    descricao = "Esta biblioteca contém diversas funções de Thread",
    versao = "1.1"
)
public final class Threads extends Biblioteca
{
    private static ExecutorService service = Executors.newCachedThreadPool();
    private Interpretador interpretador;
    @Override
    protected void inicializar(Programa programa, Interpretador interpretador, List<Biblioteca> bibliotecasReservadas) throws ErroExecucaoBiblioteca
    {
        this.interpretador = interpretador;
    }
    
    
    @DocumentacaoFuncao
    (
        descricao = "Executa a função em outra thread",
        parametros = 
        {
            @DocumentacaoParametro(nome = "funcao", descricao = "a funçao a ser executada")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }            
    )
    public void executar_thread(String funcao) throws ErroExecucaoBiblioteca{
        
        final NoChamadaFuncao noChamadaFuncao = new NoChamadaFuncao(null, funcao);
        noChamadaFuncao.setParametros(new ArrayList<NoExpressao>());
        try
        {
            
            service.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        noChamadaFuncao.aceitar(interpretador);
                        
                    }
                    catch (ExcecaoVisitaASA ex)
                    {
                        throw new RuntimeException(ex);
                    }
                }
            });
            
        }
        catch (RuntimeException e)
        {
            throw new ErroExecucaoBiblioteca(e.getCause());
        }
    }
}
