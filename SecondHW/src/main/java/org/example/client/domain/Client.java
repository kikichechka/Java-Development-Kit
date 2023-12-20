package org.example.client.domain;


import org.example.client.ui.ClientView;
import org.example.server.domain.Server;

public class Client {
    private boolean connected;
    private String name;
    private final ClientView clientView;
    private final Server server;

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            showOnWindow("Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null){
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Подключение не удалось");
            return false;
        }
    }

    public void answerFromServer(String text) {
        showOnWindow(text);
    }

    public void disconnectFromServer() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            showOnWindow("Вы были отключены от сервера!");
        }
    }

    public void message(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                server.message(name + ": " + text);
            }
        } else {
            showOnWindow("Нет подключения к серверу");
        }
    }

    public String getName() {
        return name;
    }

    private void showOnWindow(String text) {
        clientView.showMessage(text + "\n");
    }
}
