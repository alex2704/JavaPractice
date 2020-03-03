package bank.entities;

import bank.services.ClientGenerator;

public class Bank {

    public void startWork() {
        System.out.println("Банк открылся");

        int min;

        OperationOfficer[] ops = new OperationOfficer[4];

        Cash cash = new Cash(50000);

        ClientGenerator generator = new ClientGenerator();
        generator.start();

        for(int i=0; i<ops.length; i++){
            ops[i] = new OperationOfficer(cash);
            ops[i].start();
        }

        while(true) {
            if (!generator.getClients().isEmpty()) {
                min = 0;
                for (int i = 1; i < ops.length; i++) {
                    if (ops[i].getClients().size() < ops[min].getClients().size())
                        min = i;
                        System.out.println(ops[i].getClients().size());
                }
                ops[min].addToQueue(generator.getClients().peek());
                generator.getClients().poll();
//                if (ops[min].getClient() == null) {
////                }
            }
        }
    }
}
