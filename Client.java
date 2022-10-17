package edu.sdccd.cisc191;

import java.io.*;
import java.net.Socket;

public class Client{
    public static void main(String[] args) throws Exception {
        new Client();
    }

    Client() throws Exception {
        Socket socket = new Socket("localhost", Server.PORT);

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        VehicleRequest vehicleRequest = new VehicleRequest(2019, "Ford", "Mustang");
        outputStream.writeObject(vehicleRequest);
        outputStream.flush();

        VehicleResponse receiveResponse = (VehicleResponse) inputStream.readObject();
        System.out.println("Vehicle response received.");
        System.out.println(receiveResponse.message);

        outputStream.close();
        socket.close();
    }
}
