package banking;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<String> transactions;

    public Transaction() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    public void printTransactions() {
        System.out.println("Transactions:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
