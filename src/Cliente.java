import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Mensagem inicial do cliente
            System.out.println("=================================");
            System.out.println("   INICIANDO CLIENTE...");
            System.out.println("=================================");

            // Cria o socket e conecta ao servidor na porta 12345
            Socket socket = new Socket("localhost", 12345);

            // Informa que a conexão foi estabelecida
            System.out.println("Conectado ao servidor!");
            System.out.println("Digite mensagens (ou 'sair' para encerrar)");
            System.out.println("---------------------------------");

            // Leitura de dados digitados pelo usuário
            BufferedReader teclado = new BufferedReader(
                    new InputStreamReader(System.in));

            // Canal de saída para enviar dados ao servidor
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

            // Canal de entrada para receber dados do servidor
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String mensagem;

            // Loop principal de envio e recebimento de mensagens
            while (true) {
                // Solicita entrada do usuário
                System.out.print("[Cliente] > ");
                mensagem = teclado.readLine();

                // Verifica se a mensagem é nula ou vazia
                if (mensagem == null || mensagem.trim().isEmpty()) {
                    System.out.println("Mensagem vazia! Tente novamente.");
                    continue;
                }

                // Envia a mensagem para o servidor
                saida.println(mensagem);

                // Verifica se o usuário deseja encerrar a comunicação
                if (mensagem.equalsIgnoreCase("sair")) {
                    System.out.println("Encerrando conexão com o servidor...");
                    break;
                }

                // Aguarda resposta do servidor
                String resposta = entrada.readLine();

                // Verifica se houve resposta
                if (resposta != null) {
                    System.out.println("[Servidor] > " + resposta);
                } else {
                    // Caso o servidor não responda, encerra a conexão
                    System.out.println("Servidor não respondeu.");
                    break;
                }

                System.out.println("---------------------------------");
            }

            // Fecha a conexão com o servidor
            socket.close();
            System.out.println("Conexão finalizada com sucesso.");

        } catch (UnknownHostException e) {
            // Erro quando o servidor não é encontrado
            System.out.println("Erro: Servidor não encontrado.");
        } catch (IOException e) {
            // Erro geral de comunicação
            System.out.println("Erro na comunicação com o servidor.");
        }
    }
}