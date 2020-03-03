package bank.entities;

import bank.enums.ClientActions;

import java.util.PriorityQueue;

public class OperationOfficer extends Thread {
    private Client client;
    private final Cash cash;
    private final PriorityQueue<Client> clients;

    public OperationOfficer(Cash cash) {
        super();
        this.cash = cash;
        this.clients = new PriorityQueue<Client>();
        this.client = null;
    }

    @Override
    public void run(){
        while(true) {
            startService();
        }
    }

    public synchronized void addToQueue(Client c){
        clients.add(c);
        if(client == null)
            notify();
        System.out.println(clients.size());
    }

    private synchronized void startService(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service();
    }

    private void service(){
        synchronized (cash) {
            client = clients.peek();
            System.out.println("Начато обслуживание клиента: " + client.hashCode());
            if (client.getTarget() == ClientActions.INCREASE) {
                increase();
                System.out.println("Внесение у клиента" + client.hashCode());
                System.out.println("Баланс кассы: " + cash.getCash());
            } else {
                withdraw();
                System.out.println("Списание у клиента" + client.hashCode());
                System.out.println("Баланс кассы: " + cash.getCash());
            }
        }
            try {
                sleep(client.getDurationService());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client = null;
    }

    private void increase(){
        cash.increase(client.getSum());
    }

    private void withdraw(){
        while(!cash.withdraw(client.getSum())) {
            clients.poll();
        }

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PriorityQueue<Client> getClients() {
        return clients;
    }
}
