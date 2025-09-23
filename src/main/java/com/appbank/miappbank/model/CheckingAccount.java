package com.appbank.miappbank.model;

public class CheckingAccount extends Account {
    private double overdraftlimit;

    public CheckingAccount(String id, Customer owner, Money balance, double overdraftlimit){
        super(id,owner, balance);
    }

    @Override
    public void applyInterest(){}


    public boolean withdraw(Money amount){
        double available = getBalance().getAmount() + overdraftlimit;
        if (available >= amount.getAmount()) {
            getBalance().setAmount(getBalance().getAmount() - amount.getAmount());
            getTransactions().add(new Transaction("WDR", amount, getId(), java.time.LocalDateTime.now()));
            return true;
        }
        return false;
    }

    public double getOverdraftLimit(){return overdraftlimit;}
    public void setOverdraftLimit(double overdraftlimit){this.overdraftlimit = overdraftlimit;}

}
