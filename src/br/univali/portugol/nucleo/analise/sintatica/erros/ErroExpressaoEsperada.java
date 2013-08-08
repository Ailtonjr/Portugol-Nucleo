package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import static br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico.estaNoContexto;
import static br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico.estaEmUmComando;
import static br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico.extrairComando;

/**
 * Erro gerado pelo analisador sintático quando uma construção espera uma expressão
 * mas esta expressão não é informada.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      funcao exemploErroExpressao()
 *      {
 *           se ()
 *           {
 *                escreva("A construção 'se' espera uma expressão entre o parêntesis...")
 *                escreva("...se não for informada uma expressão, o analisador sintático gerará este erro!")
 *           }
 * 
 *           enquanto ()
 *           {
 *                escreva("O mesmo se aplica à construção 'enquanto'!")
 *           }
 *      }
 * 
 * </pre></code>
 * 
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSintatico
 */
public final class ErroExpressaoEsperada extends ErroSintatico
{
    private Stack<String> pilhaContexto;    
    /**
     * 
     * @param linha      a linha ond eo erro ocorreu.
     * @param coluna     a coluna onde o erro ocorreu.
     * @since 1.0
     */
    public ErroExpressaoEsperada(int linha, int coluna, Stack<String> pilhaContexto)
    {
        super(linha, coluna);
        this.pilhaContexto = pilhaContexto;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        if (estaNoContexto("listaListaExpressoes", pilhaContexto))
        {
            return "A linha da matriz não foi informada ou a expressão informada não é uma linha de matriz";
        }
        else if (estaNoContexto("vetor", pilhaContexto))
        {
            return "O elemento do vetor não foi informado, insira um valor ou uma expressão para corrigir o problema";
        }
        else if (estaNoContexto("matriz", pilhaContexto))
        {
            return "O elemento não foi informado na linha da matriz, insira um valor ou uma expressão para corrigir o problema";
        }
        else if (estaEmUmComando(pilhaContexto))
        {   
            String comando = extrairComando(pilhaContexto);

            switch (comando)
            {
                case "se": return "O comando \"se\" espera uma expressão do tipo lógico entre os parêntesis";
                case "enquanto": return "O comando \"enquanto\" espera uma expressão do tipo lógico entre os parêntesis";
                case "facaEnquanto": return "O comando \"faca-enquanto\" espera uma expressão do tipo lógico entre os parêntesis";
                case "escolha": return "O comando \"escolha\" espera um valor ou uma expressão";
            }
        }
        
        return "Era esperada uma expressão";
    }
}
