import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            System.out.println("=================================");
            System.out.println("   INICIANDO CLIENTE...");
            System.out.println("=================================");

            Socket socket = new Socket("localhost", 12345);

            System.out.println("Conectado ao servidor!");
            System.out.println("Digite mensagens (ou 'sair' para encerrar)");
            System.out.println("---------------------------------");

            BufferedReader teclado = new BufferedReader(
                    new InputStreamReader(System.in));

            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String mensagem;

            while (true) {
                System.out.print("[Cliente] > ");
                mensagem = teclado.readLine();

                if (mensagem == null || mensagem.trim().isEmpty()) {
                    System.out.println("Mensagem vazia! Tente novamente.");
                    continue;
                }

                saida.println(mensagem);

                if (mensagem.equalsIgnoreCase("sair")) {
                    System.out.println("Encerrando conexão com o servidor...");
                    break;
                }

                String resposta = entrada.readLine();

                if (resposta != null) {
                    System.out.println("[Servidor] > " + resposta);
                } else {
                    System.out.println("Servidor não respondeu.");
                    break;
                }

                System.out.println("---------------------------------");
            }

            socket.close();
            System.out.println("Conexão finalizada com sucesso.");

        } catch (UnknownHostException e) {
            System.out.println("Erro: Servidor não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro na comunicação com o servidor.");
        }
    }
}