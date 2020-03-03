package bank.entities;

import bank.enums.ClientActions;

import java.util.Random;

public class Client implements Comparable<Client>{
    private ClientActions target;
    private int sum;
    private int durationService;

    public Client(){
        Random random = new Random();
        this.target = random.nextBoolean() ? ClientActions.INCREASE : ClientActions.WITHDRAW;
        this.sum = random.nextInt(5000) + 1;
        this.durationService = random.nextInt(5000);
    }

    @Override
    public int compareTo(Client client) {
        return 0;
    }

    public ClientActions getTarget() {
        return target;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getDurationService() {
        return durationService;
    }

    public void setDurationService(int durationService) {
        this.durationService = durationService;
    }
}
