programa
{
	inteiro inicial = 10
	inteiro idade = 0
	
	funcao inicio()
	{
		idade = inicial + 5
		
		escreva("\nSua idade �: " + idade)

		verificarMaioridade(idade)
	}

	funcao verificarMaioridade(inteiro funcionou)
	{
		se (funcionou >= 18)
		{
			escreva("\n\nVoc� � maior de idade!")
		}
		senao se (funcionou < 18)
		{
			escreva("\n\nVoc� � menor de idade!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 32; 
 */