import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Mensagem inicial do servidor
            System.out.println("=================================");
            System.out.println("   INICIANDO SERVIDOR...");
            System.out.println("=================================");

            // Cria o servidor na porta 12345
            ServerSocket servidor = new ServerSocket(12345);

            // Aguarda conexão de um cliente
            System.out.println("Aguardando conexão de cliente...");
            System.out.println("---------------------------------");

            Socket cliente = servidor.accept();

            // Confirma que um cliente se conectou
            System.out.println("Cliente conectado!");
            System.out.println("---------------------------------");

            // Canal de entrada para receber dados do cliente
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));

            // Canal de saída para enviar dados ao cliente
            PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);

            String mensagem;

            // Loop principal de comunicação
            while (true) {
                // Lê mensagem enviada pelo cliente
                mensagem = entrada.readLine();

                // Verifica se a conexão foi encerrada inesperadamente
                if (mensagem == null) {
                    System.out.println("Conexão encerrada inesperadamente.");
                    break;
                }

                // Verifica se a mensagem está vazia
                if (mensagem.trim().isEmpty()) {
                    System.out.println("Cliente enviou mensagem vazia.");
                    continue;
                }

                // Exibe mensagem recebida
                System.out.println("[Cliente] > " + mensagem);

                // Verifica se o cliente deseja encerrar
                if (mensagem.equalsIgnoreCase("sair")) {
                    System.out.println("Cliente solicitou encerramento.");
                    break;
                }

                // Define resposta padrão do servidor
                String resposta = "Mensagem recebida com sucesso!";

                // Envia resposta ao cliente
                saida.println(resposta);

                System.out.println("---------------------------------");
            }

            // Fecha conexões
            cliente.close();
            servidor.close();

            System.out.println("Servidor finalizado.");

        } catch (BindException e) {
            // Erro quando a porta já está sendo utilizada
            System.out.println("Erro: Porta já está em uso.");
        } catch (IOException e) {
            // Erro geral de comunicação
            System.out.println("Erro na comunicação com o cliente.");
        }
    }
}