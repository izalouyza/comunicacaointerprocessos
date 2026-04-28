import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            System.out.println("=================================");
            System.out.println("   INICIANDO SERVIDOR...");
            System.out.println("=================================");

            ServerSocket servidor = new ServerSocket(12345);

            System.out.println("Aguardando conexão de cliente...");
            System.out.println("---------------------------------");

            Socket cliente = servidor.accept();

            System.out.println("Cliente conectado!");
            System.out.println("---------------------------------");

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));

            PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);

            String mensagem;

            while (true) {
                mensagem = entrada.readLine();

                if (mensagem == null) {
                    System.out.println("Conexão encerrada inesperadamente.");
                    break;
                }

                if (mensagem.trim().isEmpty()) {
                    System.out.println("Cliente enviou mensagem vazia.");
                    continue;
                }

                System.out.println("[Cliente] > " + mensagem);

                if (mensagem.equalsIgnoreCase("sair")) {
                    System.out.println("Cliente solicitou encerramento.");
                    break;
                }

                String resposta = "Mensagem recebida com sucesso!";
                saida.println(resposta);

                System.out.println("---------------------------------");
            }

            cliente.close();
            servidor.close();

            System.out.println("Servidor finalizado.");

        } catch (BindException e) {
            System.out.println("Erro: Porta já está em uso.");
        } catch (IOException e) {
            System.out.println("Erro na comunicação com o cliente.");
        }
    }
}