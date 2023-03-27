package tugasAsd.service;

import java.util.ArrayList;
import java.util.List;

import tugasAsd.models.Account;

//create graph class
public class GraphCustom {
    
    //create variable
    private List<Account> accounts;
    private List<List<Integer>> adjacencyMatrix;

    //create constructor
    public GraphCustom() {
        this.accounts = new ArrayList<>();
        this.adjacencyMatrix = new ArrayList<>();
    }
    
    //create getter and setter
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<List<Integer>> getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(List<List<Integer>> adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void addAccount(Account account){
        //add to accounts list
        this.accounts.add(account);

        //reorganize adjacency matrix
        for (List<Integer> row : adjacencyMatrix) {
            row.add(0);
        }

        //add new row
        List<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < this.accounts.size(); i++) {
            newRow.add(0);
        }
        this.adjacencyMatrix.add(newRow);
    }

    //source memfollow destination
    public void addEdge(Account source, Account destination){
        //get index of source and destination
        int sourceIndex = this.accounts.indexOf(source);
        int destinationIndex = this.accounts.indexOf(destination);

        //add edge
        this.adjacencyMatrix.get(sourceIndex).set(destinationIndex, 1);
    }

    public List<Account> getFollowers(Account account){
        //get index of account
        int accountIndex = this.accounts.indexOf(account);

        //get followers
        List<Account> followers = new ArrayList<>();
        for (int i = 0; i < this.adjacencyMatrix.size(); i++) {
            if (this.adjacencyMatrix.get(i).get(accountIndex) == 1){
                followers.add(this.accounts.get(i));
            }
        }

        return followers;
    }

    public Account getAccount(String username){
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public void printAllAccount(){
        for (Account account : accounts) {
            account.printAccount();
        }
    }
}
