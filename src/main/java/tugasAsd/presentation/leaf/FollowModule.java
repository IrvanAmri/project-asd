package tugasAsd.presentation.leaf;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Scanner;

import tugasAsd.models.Account;
import tugasAsd.presentation.CustomLoginModule;
import tugasAsd.presentation.Module;
import tugasAsd.service.GraphCustom;

public class FollowModule implements Module {

    private int choose;
    private String name;
    private CustomLoginModule parent;

    public FollowModule(String name, int choose) {
        this.name = name;
        if(choose == 0) throw new InvalidParameterException("The choose parameter cannot be zero. Please enter a different value.");
        this.choose = choose;
    }

    @Override
    public int getChoose() {
        return this.choose;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Module getParent() {
        return this.parent;
    }

    @Override
    public void setChoose(int choose) {
        this.choose = choose;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setParent(Module parent) {
        this.parent = (CustomLoginModule) parent;
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("List Akun yang ada: ");
        List<Account> accounts = this.parent.getGraph().getAccounts();
        for (Account account : accounts) {
            if(account == this.parent.getCurrentAccount()) continue;
            account.printAccount();
        }
        System.out.println("Masukkan username yang ingin anda follow (jika batal, ketik 'back'): ");
        String input = scanner.nextLine();
        if(input.equals("back")) {
            System.out.println("operation canceled");
        }
        else{
            GraphCustom graph = this.parent.getGraph();
            Account accountToFollow = graph.getAccount(input);
            if(accountToFollow != null){
                Account currentAccount = this.parent.getCurrentAccount();
                graph.addEdge(currentAccount, accountToFollow);
                System.out.println("Anda sekarang mem-follow " + accountToFollow.getUsername());
            }
            else{
                System.out.println("Akun tidak ditemukan");
            }
        }
        this.parent.partialStart();
    }
    
}
