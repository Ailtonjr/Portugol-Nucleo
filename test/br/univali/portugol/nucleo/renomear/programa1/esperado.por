programa
{
	inteiro inicial = 10
	inteiro funcionou = 0
	
	funcao inicio()
	{
		funcionou = inicial + 5
		
		escreva("\nSua idade �: " + funcionou)

		verificarMaioridade(funcionou)
	}

	funcao verificarMaioridade(inteiro idade)
	{
		se (idade >= 18)
		{
			escreva("\n\nVoc� � maior de idade!")
		}
		senao se (idade < 18)
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