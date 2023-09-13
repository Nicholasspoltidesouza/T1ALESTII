import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList dna = new DoubleLinkedList();
        String inputFile = "ct_1000000.txt"; // Nome do arquivo de entrada
        String outputFile = "resultado.txt"; // Nome do arquivo de saída

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String linha;
            while ((linha = reader.readLine()) != null) {
                // Insira os caracteres da linha na DoubleLinkedList
                for (char c : linha.toCharArray()) {
                    dna.add(c);
                }

                // Realize o processamento necessário com a lista
                dna.mutacoes();

                // Escreva o resultado no arquivo de saída
                int tamanhoMinimo = dna.size();
                writer.write("Menor cadeia: " + dna.toString() + "\n" + "Tamanho: " + tamanhoMinimo + "\n");
            }

            reader.close();
            writer.close();

            System.out.println("Processamento concluído. Resultados gravados em " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}