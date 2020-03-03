package bank.services;

import bank.entities.Client;

import java.util.PriorityQueue;
import java.util.Random;

public class ClientGenerator extends Thread {
    private final PriorityQueue<Client> clients;

    public ClientGenerator() {
        this.clients  = new PriorityQueue<Client>();
    }

    @Override
    public void run(){
        Random rnd = new Random();
        while(true){
            try {
                sleep(rnd.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (clients){
                generateClient();
        }
        }
    }

    public PriorityQueue<Client> getClients() {
        synchronized (clients){
        return clients;
        }
    }

    private void generateClient(){
        Client client = new Client();
        clients.add(client);
        System.out.println("Пришел новый клиент: " + client.hashCode());
    }
}
