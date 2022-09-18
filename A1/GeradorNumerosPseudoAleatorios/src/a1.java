package src;
import java.util.HashMap;

public class a1 {
    public static void main(String[] args) {
        /*
         * Para rodar o Gerador corretamente, voce precisa inserir o path (caminho) 
         * da file de configuração que voce desejar, tente por o caminho relativo,
         * obtido pelo vs code ou copie o padrão escrito abaixo.
         * Se voce abriu apenas a pasta do código, deixe o nome como esta abaixo,
         * se voce abriu varias pastas com o vs code ao mesmo tempo, coloque o caminho relativo
         * da file "configFile.txt"
         */
        HashMap<String, String> configArgs = File.readFile("configFile.txt");
        Integer xo = Integer.parseInt(configArgs.get("Xo"));
        Integer m = Integer.parseInt(configArgs.get("m"));;
        Integer a = Integer.parseInt(configArgs.get("a"));;
        Integer c = Integer.parseInt(configArgs.get("c"));;
        Integer qtyNumbers = 1000;

        System.out.println("----------- Configuracao carregada:");
        for (String i : configArgs.keySet()) {
            System.out.println("key: " + i + " value: " + configArgs.get(i));
        }
        System.out.println("-------------------------------------------- ");

        int[] randonNumbers = NumberGenerator.methodCongruentialLinear(xo, m, a, c, qtyNumbers);

        /*
         * Voce precisa fazer a mesma coisa que voce fez para o arquivo de configuracao, porém agora
         * voce precisa fazer isso para determinar o nome do arquivo de output e onde ele vai ser salvo
         */
        File.writeFile("outputRandomNumbers.txt", randonNumbers);
    }
}
