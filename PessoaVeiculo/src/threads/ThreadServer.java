/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author laboratorio
 */
import beans.Pessoa;
import dao.PessoaDAO;
import java.io.IOException;
public class ThreadServer extends Thread{
    private Socket clienteSocket;

    public ThreadServer(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }
    
    @Override
    public void run(){
        try(ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream())){
            
            int id = in.readInt();
            System.out.println("ID recebido: " + id);
            
            //Simule a obtenção de uma Pessoa a partir do ID
            PessoaDAO pDAO = new PessoaDAO();
            Pessoa p = pDAO.getPessoa(id);
            
            out.writeObject(p);
            
        } catch (IOException ex){
            System.out.println("Erro ao lidar com o cliente");
        }
    }
}
