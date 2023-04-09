package chat;


import javax.swing.*;
import java.awt.*;


public class ChatServer extends JFrame implements Runnable {

	JTextArea TextField;
	JMenuItem Exit;
	JMenu File;
	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	
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
	}

	@Override
	public void run() {
		
	}
}


