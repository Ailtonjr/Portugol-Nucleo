package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ErroPassagemParametroInvalida extends ErroSemantico
{
    private NoExpressao valor;
    private String nomeParametro;
    private String nomeFuncao;
    private int posicaoParametro;
    
    public ErroPassagemParametroInvalida(NoExpressao valor, String nomeParametro, String nomeFuncao, int posicaoParametro)
    {
        super(valor.getTrechoCodigoFonte(), "ErroSemantico.ErroPassagemParametroInvalida");

        this.valor = valor;
        this.nomeParametro = nomeParametro;
        this.nomeFuncao = nomeFuncao;
        this.posicaoParametro = posicaoParametro;
    }

    public NoExpressao getValor()
    {
        return valor;
    }

    public String getNomeParametro()
    {
        return nomeParametro;
    }

    public String getNomeFuncao()
    {
        return nomeFuncao;
    }

    public int getPosicaoParametro()
    {
        return posicaoParametro;
    }
    
    
    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        //return new ErroPassagemParametroInvalida.ConstrutorMensagem().construirMensagem();

        StringBuilder construtorTexto = new StringBuilder();

        if (nomeFuncao.equals(AnalisadorSemantico.FUNCAO_LEIA))
        {
            construtorTexto.append("Não é possível passar um valor literal, constante ou expressão para o parâmetro na posição \"");
            construtorTexto.append(posicaoParametro+1);
            construtorTexto.append("\"da função \"");
            construtorTexto.append(AnalisadorSemantico.FUNCAO_LEIA);
            construtorTexto.append("\", pois este parâmetro espera uma referência. Tente passar uma variável, vetor ou matriz para a função sem ser constante");
        }
        else
        {
            construtorTexto.append("Não é possível passar uma expressão constante para o parâmetro \"");
            construtorTexto.append(nomeParametro);
            construtorTexto.append("\" da função \"");
            construtorTexto.append(nomeFuncao);
            construtorTexto.append("\", pois este parâmetro espera uma referência");
        }

        return construtorTexto.toString();
    }
}
