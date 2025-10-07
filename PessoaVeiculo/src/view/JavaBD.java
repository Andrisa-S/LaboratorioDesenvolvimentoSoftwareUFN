/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import beans.Pessoa;
import dao.PessoaDAO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import threads.ThreadServer;

/**
 *
 * @author laboratorio
 */
public class JavaBD {
    public static void main(String[] args) {
        int porta = 12345; //Constante para a porta
        
        try (ServerSocket servidorSocket = new ServerSocket(porta)){
            System.out.println("Servidor aguardando conexões na porta " + porta);
            
            while(true){
                try{
                    Socket clienteSocket = servidorSocket.accept();
                    System.out.println("Conexão aceita de " + clienteSocket.getInetAddress());

                    //Criar uma nova thread para lidar com o cliente
                    Thread threadCliente = new ThreadServer(clienteSocket);
                    threadCliente.start();
                    
                } catch (IOException ex){
                    System.out.println("Erro ao aceitar conexão do cliente");
                }
                
            }
        } catch (IOException ex){
            System.out.println("Erro ao criar o ServerSocket");
        }
    }
}
