package hw14.factoryMeth.patterns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProxyPrivateBank implements Pattern, Bank {
    private Bank bank;

    @Override
    public void setMoney(double money) {
        //some doing...
        System.out.println("I am Kolomoisky");
        bank.setMoney(money);
    }

    @Override
    public void gatMoney(double money) {
        System.out.println("I am Kolomoiskiy");
        bank.gatMoney(money);
    }
}
