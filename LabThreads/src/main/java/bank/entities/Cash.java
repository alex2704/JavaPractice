package bank.entities;

public class Cash {
    private int cash;
    private boolean access;

    public Cash(int cash) {
        this.cash = cash;
        this.access = true;
    }

    public void increase(int sum){
        this.cash += sum;
        System.out.println("Касса пополнена на: " + sum);
    }

    public boolean withdraw(int sum){
        if(this.cash >= sum){
            this.cash -= sum;
            System.out.println("Из кассы взято" + sum);
            return true;
        }
        else {
            System.out.println("В кассе недостаточно средств для сниятия: " + sum);
            return false;
        }
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
