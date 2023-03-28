package tugasAsd.presentation.leaf;

import java.security.InvalidParameterException;
import java.util.Scanner;

import tugasAsd.models.Account;
import tugasAsd.presentation.CoreModule;
import tugasAsd.presentation.Module;
import tugasAsd.service.GraphCustom;

public class CreateAccountModule implements Module {

    private int choose;
    private String name;
    private CoreModule parent;
    private GraphCustom graph;
    

    public CreateAccountModule( String name, int choose, GraphCustom graph) {
        if(choose == 0) throw new InvalidParameterException("The choose parameter cannot be zero. Please enter a different value.");
        this.choose = choose;
        this.name = name;
        this.parent = null;
        this.graph = graph;
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
        this.parent = (CoreModule) parent;
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan username: ");
        String username = scanner.nextLine();
        Account account = this.graph.getAccount(username);
        if(account == null){
            Account in = new Account(username);
            graph.addAccount(in);
            System.out.println("Akun berhasil dibuat");
        }
        else{
            System.out.println("Username sudah ada");
        }
        this.parent.start();
    }
    
}
