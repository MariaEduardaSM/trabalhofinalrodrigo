package system;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Database {

    private static List<Account> accounts = new LinkedList<>();
    private static int id = 1;

    public static List<Account> accounts() {
        return accounts;
    }

    public static void moneytop() {
        accounts.sort((c1, c2) -> Double.compare(c2.getBalance(), c1.getBalance()));
    }
    
    public static void add(Account a) {
        a.setId(id++);
        a.setDate(LocalDate.now());
        accounts.add(a);
    }

    public static void remove(Account a) {
        accounts.remove(a);
    }

    public static Account search(int id) {
        for (Account a : accounts) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public static Account search(String CPF) {
        for (Account a : accounts) {
            if (a.getCPF().equals(CPF)) {
                return a;
            }
        }
        return null;
    }
}
