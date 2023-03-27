package tugasAsd.presentation.leaf;

import java.util.List;

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
        System.out.println("accounts list");
        List<Account> accounts = this.parent.getGraph().getAccounts();
        for (Account account : accounts) {
            if(account == this.parent.getCurrentAccount()) continue;
            account.printAccount();
        }
        System.out.println("type the username of the account you want to follow, or type 'back' to go back");
        String input = this.parent.getScanner().nextLine();
        if(input.equals("back")) {
            System.out.println("operation canceled");
        }
        else{
            GraphCustom graph = this.parent.getGraph();
            Account accountToFollow = graph.getAccount(input);
            if(accountToFollow != null){
                Account currentAccount = this.parent.getCurrentAccount();
                graph.addEdge(currentAccount, accountToFollow);
                System.out.println("you are now following " + accountToFollow.getUsername());
            }
            else{
                System.out.println("account not found");
            }
        }
        this.parent.partialStart();
    }
    
}
