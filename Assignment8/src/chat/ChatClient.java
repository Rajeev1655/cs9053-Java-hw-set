package chat;

import javax.swing.*;
import java.awt.*;


public class ChatClient extends JFrame implements Runnable {

	JMenuBar menuBar;
	JMenuItem Connect;
	JMenuItem Exit;
	JMenu File;
	JTextField inputField;
	JTextArea chatArea;

	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	
	public ChatClient() {
		super("Chat Client");
		menuBar = new JMenuBar();
		Connect = new JMenuItem("Connect");
		Exit = new JMenuItem("Exit");
		File = new JMenu("File");
		inputField = new JTextField();
		chatArea = new JTextArea(10, 30);
		JScrollPane scrollPane = new JScrollPane(chatArea);

		Connect.addActionListener((e)-> this.connect());
		Exit.addActionListener((e) -> System.exit(0));
		chatArea.setEditable(true);
		chatArea.append("Welcome to the chat room");
		inputField.setSize(400, 50);
		inputField.setColumns(30);
		inputField.setEditable(true);
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

	public void connect() {

	}
	
	public void run() {

	}
	
	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
	}
}
