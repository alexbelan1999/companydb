package ru.chat.client;

import ru.chat.network.TCPConnection;
import ru.chat.network.TCPConnectionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientWindow extends JFrame implements ActionListener, TCPConnectionListener {
    private static final String IP_ADDR = "192.168.1.2";
    private static final int PORT = 8000;
    private static final int WIDTH = 600;
    private static final int HEIGHT=400;

    public static void main(String[]args){
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                new ClientWindow();
            }
        });
    }
    private final JTextArea log = new JTextArea();
    private final JTextField fieldNickname = new JTextField("ALEX");
    private final JTextField fieldInput = new JTextField();

    private TCPConnection connection;
    private ClientWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        log.setEditable(false);
        log.setLineWrap(true);
        add(log, BorderLayout.CENTER);

        fieldInput.addActionListener(this);
        add(fieldInput, BorderLayout.SOUTH);
        add(fieldNickname,BorderLayout.NORTH);




        setVisible(true);
        try {
            connection = new TCPConnection(this,IP_ADDR,PORT);
        } catch (IOException e) {
            printMeg("Connection exception " + e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String meg = fieldInput.getText();
        if (meg.equals(""))return;
        fieldInput.setText(null);
        connection.sendString(fieldNickname.getText() + ": " + meg);
    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMeg("Connection ready....");
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printMeg(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMeg("Connection close...");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
      printMeg("Connection exception " + e);
    }
    private synchronized void printMeg (String meg ){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(meg + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }
}
