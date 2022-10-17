package edu.sdccd.cisc191;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static final int PORT = 5055;

    public static void main(String[] args) throws Exception {

        new Server();
    }
    Server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();

        System.out.println("Client connected");

        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

        VehicleRequest receiveRequest = (VehicleRequest)inputStream.readObject();
        System.out.println("The vehicle request has been received.");
        System.out.println(receiveRequest.message);

        VehicleResponse vehicleResponse = new VehicleResponse(receiveRequest, 10000, 17000, 4, 2,
                new String[]{"Manual" , "Automatic"});
        outputStream.writeObject(vehicleResponse);
        outputStream.flush();

        serverSocket.close();
    }
}