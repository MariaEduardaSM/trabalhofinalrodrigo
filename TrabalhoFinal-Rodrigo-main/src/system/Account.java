package system;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Account {

    private String person, CPF, historic = "", password;
    private double balance;
    private int id;
    private LocalDate date;

    public Account(String person, String CPF, String password) {
        this.person = person;
        this.CPF = CPF;
        this.password = password;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getHistoric() {
        return historic;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    

    public boolean Withdraw(double withdraw) {
        if (withdraw > this.balance) {
            JOptionPane.showMessageDialog(null, "Saque execedeu o valor máxim Saldo: R$" + this.getBalance() + " Saque: R$" + withdraw, "Alerta!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.balance -= withdraw;
        this.historic += "\nSaque realizado com sucesso! R$" + withdraw + " foram retirados";
        return true;
    }

    public boolean Deposit(double deposit) {
        if (deposit < 0) {
            JOptionPane.showMessageDialog(null, "O depósito não pode conter valores negativos!", "Alerta!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.balance += deposit;
        this.historic += "\nDeposito realizado realizado com sucesso! R$" + deposit + " foram atribuídos";
        return true;
    }

    public void transfer(Account a, double deposit) {
        this.Withdraw(deposit);
        a.Deposit(deposit);
        this.historic += "\nTransferencia realizada com sucesso! R$" + deposit + " foram transferidos para " + a.getPerson();
        a.historic += "Transferência feita com sucesso! R$" + deposit + " foram recebidos de " + this.getPerson();
    }

    @Override
    public String toString() {
        return "[Titular da conta:" + this.getPerson() + "\nId:" + this.getId() + "\nCpf:" + this.getCPF() + "\nSaldo: R$" + this.getBalance() + "\nData de cadastro: " + this.getDate() + "]\n\n";
    }
}
