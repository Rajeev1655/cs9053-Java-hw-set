package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class ClientHandler extends Thread {
    private static int clientCount = 1;
    int myCount;
    Socket socket;
    HashMap<Integer, Socket> clients;

    public ClientHandler(Socket socket, HashMap<Integer, Socket> clients) throws IOException {
        super();
        this.socket = socket;
        this.myCount = clientCount++;
        this.clients = clients;
    }

    public int getMyCount() {
        return myCount;
    }

    public void run() {
        while (true) {
            try {
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                String message = inputStream.readUTF();
                if (!message.isEmpty()) {
                    for (Socket other : clients.values()) {
                        if (other == socket) continue; // Don't send to self
                        DataOutputStream outputStream = new DataOutputStream(other.getOutputStream());
                        outputStream.writeUTF(myCount + ": " + message);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
