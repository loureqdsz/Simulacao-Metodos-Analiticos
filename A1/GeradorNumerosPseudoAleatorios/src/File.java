package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class File{

    public static HashMap<String, String> readFile(String path) {
        HashMap<String, String> configFile = new HashMap<>();
        Path path1 = Paths.get(path);

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] dados = line.split("=");
                configFile.put(dados[0], dados[1]);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }

        return configFile;
    }

    public static void writeFile (String outputFileName, int[] randomNumbers) {
        String fileName = outputFileName;
        String msg = "" + randomNumbers[0];
        for (int i = 1; i < randomNumbers.length; i++) {
            msg = msg + "\n" + randomNumbers[i];
        }

        try {
            Writer writer = new BufferedWriter(
                                new OutputStreamWriter(
                                    new FileOutputStream(fileName), "utf-8"));

            writer.write(msg);
            writer.close();
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }

        System.out.println("Seu arquivo de numeros aleatorios esta pronto, ele foi salvo em: " + fileName);
        System.out.println("-----------------------------------------------------------------------");
    }
}
