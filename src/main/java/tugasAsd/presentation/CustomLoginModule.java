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

    public CustomLoginModule(String name, int choose, GraphCustom graph) {
        this.name = name;
        if(choose == 0) throw new InvalidParameterException("The choose parameter cannot be zero. Please enter a different value.");
        this.choose = choose;
        this.parent = null;
        this.currentAccount = null;
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

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        this.currentAccount = null;
        System.out.println("=====================================");
        System.out.println("Module: "+this.name);
        System.out.println("-------------------------------------");
        System.out.println("Masukkan username:");
        String username = scanner.nextLine();
        if(graph.getAccount(username) != null){
            this.currentAccount = graph.getAccount(username);
            System.out.println("=====================================");
            for(Module module : modules){
                System.out.println(module.getChoose()+". "+module.getName());
            }
            System.out.println("0. logout");
            System.out.println("Pilih operasi: ");
            int choosen = Integer.parseInt(scanner.nextLine());
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
            System.out.println("Username tidak ditemukan");
            System.out.println("Coba lagi? (y/n)");
            String answer = scanner.nextLine();
            if(answer.equals("y")) this.start();
            else this.parent.start();
        }
    }

    public void partialStart(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        for(Module module : modules){
            System.out.println(module.getChoose()+". "+module.getName());
        }
        System.out.println("0. logout");
        System.out.println("Pilih operasi: ");
        int choosen = Integer.parseInt(scanner.nextLine());
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
