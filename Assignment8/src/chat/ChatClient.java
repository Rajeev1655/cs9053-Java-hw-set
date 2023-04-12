package chat;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


public class ChatClient extends JFrame implements Runnable {

	JMenuBar menuBar;
	JMenuItem Connect;
	JMenuItem Exit;
	JMenu File;
	JTextField inputField;
	JTextArea chatArea;

	private static int WIDTH = 400;
	private static int HEIGHT = 300;

	int port = 8000;
	String host = "localhost";
	DataInputStream inputStream;
	DataOutputStream outputStream;
	Socket socket;
	
	public ChatClient() {
		super("Chat Client");
		menuBar = new JMenuBar();
		Connect = new JMenuItem("Connect");
		Exit = new JMenuItem("Exit");
		File = new JMenu("File");
		inputField = new JTextField();
		chatArea = new JTextArea(10, 30);
		JScrollPane scrollPane = new JScrollPane(chatArea);

		Connect.addActionListener((e)-> {
			try {
				this.connect();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		Exit.addActionListener((e) -> System.exit(0));
		chatArea.setEditable(true);
		chatArea.append("Welcome to the chat room, pls connect a server to start\n");
		inputField.setSize(400, 50);
		inputField.setColumns(30);
		inputField.setEditable(true);
		inputField.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
					String message = inputField.getText();
					chatArea.append("You: " + message + "\n");
					inputField.setText("");
					send(message);
				}
			}
		});
		File.add(Connect);
		File.add(Exit);
		menuBar.add(File);

		this.add(scrollPane);
		this.add(inputField, BorderLayout.SOUTH);
		this.setJMenuBar(menuBar);

		this.setSize(ChatClient.WIDTH, ChatClient.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void connect() throws IOException {
		if (socket != null && socket.isConnected()) {
			chatArea.append("Already connected to server.\n");
			return;
		}
		chatArea.append("Connecting to server...\n");
		socket = new Socket(host, port);
		inputStream = new DataInputStream(socket.getInputStream());
		outputStream = new DataOutputStream(socket.getOutputStream());
		if (socket.isConnected()) {
			chatArea.append("Connected.\n");
		}
	}

	public void send(String message) {
		try {
			outputStream.writeUTF(message);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void run() {
		while (true) {
			if (socket == null || !socket.isConnected()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				continue;
			}
			try {
				String message = inputStream.readUTF();
				chatArea.append(message + "\n");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
		chatClient.run();
	}
}
