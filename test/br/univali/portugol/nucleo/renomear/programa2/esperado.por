programa
{
	inteiro funcionou = 10
	inteiro idade = 0
	
	funcao inicio()
	{
		idade = funcionou + 5
		
		escreva("\nSua idade �: " + idade)

		verificarMaioridade(idade)
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
 * @POSICAO-CURSOR = 34; 
 */