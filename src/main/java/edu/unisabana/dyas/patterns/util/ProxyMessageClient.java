package edu.unisabana.dyas.patterns.util;

public class ProxyMessageClient implements MessageSender {
    private MessagingClient messagingClient;

    public ProxyMessageClient(MessagingClient messagingClient) {
        this.messagingClient = messagingClient;
    }

    @Override
    public void sendMessage(String message) {
        if (message.contains("##{./exec(")) {
            System.out.println("Mensaje bloqueado debido a contenido peligroso");
        } else {
            messagingClient.sendMessage(message);
        }
    }
}
