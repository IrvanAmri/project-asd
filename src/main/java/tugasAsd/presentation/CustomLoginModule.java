package tugasAsd.presentation;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Scanner;

import tugasAsd.models.Account;
import tugasAsd.service.GraphCustom;

public class CustomLoginModule implements Module {

    private int choose;
    private String name;
    private CoreModule parent;
    private Account currentAccount;
    private GraphCustom graph;
    private List<? extends Module> modules;
    private Scanner scanner;

    public CustomLoginModule(String name, int choose, GraphCustom graph, Scanner scanner) {
        this.name = name;
        if(choose == 0) throw new InvalidParameterException("The choose parameter cannot be zero. Please enter a different value.");
        this.choose = choose;
        this.parent = null;
        this.currentAccount = null;
        this.graph = graph;
        this.scanner = scanner;
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

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public List<? extends Module> getModules() {
        return modules;
    }

    public void setModules(List<? extends Module> modules) {
        this.modules = modules;
    }

    public GraphCustom getGraph() {
        return graph;
    }

    public void setGraph(GraphCustom graph) {
        this.graph = graph;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void start() {
        this.currentAccount = null;
        System.out.println("=====================================");
        System.out.println("Module: "+this.name);
        System.out.println("-------------------------------------");
        System.out.println("masukkan username:");
        String username = this.scanner.nextLine();
        if(graph.getAccount(username) != null){
            this.currentAccount = graph.getAccount(username);
            System.out.println("=====================================");
            for(Module module : modules){
                System.out.println(module.getChoose()+". "+module.getName());
            }
            System.out.println("0. logout");
            System.out.println("pilih operasi: ");
            int choosen = this.scanner.nextInt();
            if(choosen==0) this.parent.start();
            else{
                for(Module module : modules){
                    if(module.getChoose() == choosen){
                        module.start();
                    }
                }
            }
        }
        else{
            System.out.println("username tidak ditemukan");
            System.out.println("coba lagi? (y/n)");
            String answer = this.scanner.nextLine();
            if(answer.equals("y")) this.start();
            else this.parent.start();
        }
    }

    public void partialStart(){
        System.out.println("=====================================");
        for(Module module : modules){
            System.out.println(module.getChoose()+". "+module.getName());
        }
        System.out.println("0. logout");
        System.out.println("pilih operasi: ");
        int choosen = scanner.nextInt();
        if(choosen==0) this.parent.start();
        else{
            for(Module module : modules){
                if(module.getChoose() == choosen){
                    module.start();
                }
            }
        }
    }
    
}
