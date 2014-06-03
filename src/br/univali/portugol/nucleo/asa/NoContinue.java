package br.univali.portugol.nucleo.asa;

/**
 * @see NoContinue
 */
public final class NoContinue extends NoBloco
{
    
    private TrechoCodigoFonte trechoCodigoFonte = null;

    public void setTrechoCodigoFonte(TrechoCodigoFonte trechoCodigoFonte)
    {
        this.trechoCodigoFonte = trechoCodigoFonte;
    }

    public TrechoCodigoFonte getTrechoCodigoFonte()
    {
        return trechoCodigoFonte;
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
