package chat;


import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class ChatServer extends JFrame implements Runnable {

	JTextArea TextField;
	private static int WIDTH = 400;
	private static int HEIGHT = 300;

	int port = 8000;
	String host = "serverHost";
	ServerSocket serverSocket;
	Socket socket;
	HashMap<Integer, Socket> clients;
	
	public ChatServer() {
		super("Chat Server");
		TextField = new JTextArea(10, 30);
		TextField.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(TextField);

		this.add(scrollPane);

		this.setSize(ChatServer.WIDTH, ChatServer.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		this.setVisible(true);
		
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((e) -> System.exit(0));
		menu.add(exitItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		chatServer.run();
	}

	@Override
	public void run() throws RuntimeException {
		clients = new HashMap<>();
		int clientCount;
		try {
			serverSocket = new ServerSocket(port);
			TextField.append("Server started at " + new java.util.Date() + "\n");
			while (true) {
				// Listen for a new connection request
				socket = serverSocket.accept();
				ClientHandler thread = new ClientHandler(socket, clients);
				thread.start();
				clientCount = thread.getMyCount();
				clients.put(clientCount, socket);
				InetAddress inetAddress = socket.getInetAddress();
				int port = socket.getPort();
				TextField.append("Starting thread for client " + clientCount + " at " + new java.util.Date() + "\n");
				TextField.append("Client " + clientCount + "'s host name is " + inetAddress.getHostName() + "\n");
				TextField.append("Client " + clientCount + "'s IP Address and port is " + inetAddress.getHostAddress() + ":" + port + "\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}


