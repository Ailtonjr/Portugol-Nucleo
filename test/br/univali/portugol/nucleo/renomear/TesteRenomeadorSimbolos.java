package br.univali.portugol.nucleo.renomear;

import br.univali.portugol.nucleo.FileHandle;
import br.univali.portugol.nucleo.Portugol;
import java.io.InputStream;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Luiz Fernando
 */
public class TesteRenomeadorSimbolos
{
    @Test
    public void testRenomearVariavelGlobal1() throws Exception
    {
        testPrograma1(4, 10);
    }

    @Test
    public void testRenomearVariavelGlobal2() throws Exception
    {
        testPrograma1(8, 3);
    }

    @Test
    public void testRenomearVariavelGlobal3() throws Exception
    {
        testPrograma1(10, 31);
    }

    @Test
    public void testRenomearVariavelGlobal4() throws Exception
    {
        testPrograma1(12, 23);
    }

    @Test
    public void testRenomearVariavelGlobal5() throws Exception
    {
        testPrograma2(3, 10);
    }

    @Test
    public void testRenomearVariavelGlobal6() throws Exception
    {
        testPrograma2(8, 11);
    }

    @Test
    public void testRenomearParametroFuncao1() throws Exception
    {
        testPrograma3(15, 37);
    }

    @Test
    public void testRenomearParametroFuncao2() throws Exception
    {
        testPrograma3(17, 7);
    }

    @Test
    public void testRenomearParametroFuncao3() throws Exception
    {
        testPrograma3(21, 13);
    }

    private void testPrograma1(int linha, int coluna) throws Exception
    {
        String renomeado;
        String programa = carregarPrograma("programa1", "programa.por");
        String esperado = carregarPrograma("programa1", "esperado.por");

        renomeado = Portugol.renomearSimbolo(programa, linha, coluna, "funcionou");
        Assert.assertEquals("O símbolo não foi renomeado corretamente em todos os locais do código", esperado, renomeado);
    }

    private void testPrograma2(int linha, int coluna) throws Exception
    {
        String renomeado;
        String programa = carregarPrograma("programa2", "programa.por");
        String esperado = carregarPrograma("programa2", "esperado.por");

        renomeado = Portugol.renomearSimbolo(programa, linha, coluna, "funcionou");
        Assert.assertEquals("O símbolo não foi renomeado corretamente em todos os locais do código", esperado, renomeado);
    }

    private void testPrograma3(int linha, int coluna) throws Exception
    {
        String renomeado;
        String programa = carregarPrograma("programa3", "programa.por");
        String esperado = carregarPrograma("programa3", "esperado.por");

        renomeado = Portugol.renomearSimbolo(programa, linha, coluna, "funcionou");
        Assert.assertEquals("O símbolo não foi renomeado corretamente em todos os locais do código", esperado, renomeado);
    }

    private String carregarPrograma(String pacote, String arquivo) throws Exception
    {
        String pacoteBase = "br/univali/portugol/nucleo/renomear";

        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(pacoteBase + "/" + pacote + "/" + arquivo);

        return removerInformacoesPortugolStudio(FileHandle.read(stream));
    }

    private String removerInformacoesPortugolStudio(String codigoFonte)
    {
        int inicio = codigoFonte.lastIndexOf("/* $$$ Portugol Studio $$$");

        if (inicio >= 0)
        {
            // Quando as informações do Portugol Studio são inseridas no arquivo, é adicionada uma quebra de linha
            // antes do bloco de informações. Ao carregar o arquivo é necessário remover esta quebra para evitar
            // que o arquivo cresça indefinidamente a cada salvamento. Esta remoção é feita retrocedendo 1 caracter,
            // que corresponde ao '\n'

            inicio = inicio - 1;
            StringBuilder sb = new StringBuilder(codigoFonte);

            sb.delete(inicio, codigoFonte.length());
            codigoFonte = sb.toString();
        }

        // Remove a tag de cursor que foi incluída nas versões anteriores do Portugol Studio
        codigoFonte = codigoFonte.replace("/*${cursor}*/", "");

        return codigoFonte;
    }
}
