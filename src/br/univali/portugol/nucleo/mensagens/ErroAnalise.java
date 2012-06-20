package br.univali.portugol.nucleo.mensagens;

/**
 * Classe base para todos os tipos de erros ocorridos durante a análise de código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 */
public abstract class ErroAnalise extends Erro
{
    private int linha;
    private int coluna;

    /**
     * 
     * @param linha      a linha onde o erro ocorreu.
     * @param coluna     a coluna onde o erro ocorreu
     * @since 1.0
     */
    public ErroAnalise(int linha, int coluna)
    {
        this.linha = linha;
        this.coluna = coluna;
    }

    /**
     * Obtém a linha onde o erro ocorreu.
     * 
     * @return     a linha onde o erro ocorreu.
     * @since 1.0
     */    
    
    public final int getLinha()
    {
        return linha;
    }

    /**
     * Obtém a coluna onde o erro ocorreu.
     * 
     * @return     a coluna onde o erro ocorreu.
     * @since 1.0
     */        
    public final int getColuna()
    {
        return coluna;
    }
}
