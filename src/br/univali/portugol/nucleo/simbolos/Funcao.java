package br.univali.portugol.nucleo.simbolos;

import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.Quantificador;
import java.util.List;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoParametro;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class Funcao extends Simbolo
{	
	private List<NoBloco> blocos;
	private Quantificador quantificador;
	private List<NoParametro> parametros;
	
	public Funcao(String nome, TipoDado tipoDado, Quantificador quantificador, List<NoParametro> parametros, List<NoBloco> blocos)
	{
		super(nome, tipoDado);
		
		this.blocos = blocos;
		this.parametros = parametros;
		this.quantificador = quantificador;		
	}

	public List<NoBloco> getBlocos()
	{
		return blocos;
	}
	
	public Quantificador getQuantificador()
	{
		return quantificador;
	}

	public List<NoParametro> getParametros()
	{
		return parametros;
	}	
	
	@Override
	public Funcao copiar(String novoNome) 
	{ 
		return null;
	}
}