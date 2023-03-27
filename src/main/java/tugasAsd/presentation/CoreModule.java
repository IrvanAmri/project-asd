package tugasAsd.presentation;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoreModule implements Module{

    private List<? extends Module> modules;
    private String name;
    private int choose;
    private Scanner scanner;
    private CoreModule parent;

    public CoreModule(String name, int choose, Scanner scanner) throws InvalidParameterException{
        this.name = name;
        if(choose == 0) throw new InvalidParameterException("The choose parameter cannot be zero. Please enter a different value.");
        this.choose = choose;
        this.scanner = scanner;
        this.modules = new ArrayList<>();
        this.parent = null;
    }

    @Override
    public void start() {
        System.out.println("=====================================");
        if(this.parent == null) System.out.println("Selamat datang di "+ this.name);
        else System.out.println("Module: "+this.name);
        System.out.println("-------------------------------------");
        if(modules.size() == 0){
            System.out.println("module "+this.name+" belum diisi");
        }
        for (Module module : modules) {
            System.out.println(module.getChoose()+". "+module.getName());
        }
        System.out.println(0+". Keluar");
        System.out.println("pilih module: ");
        int choosen = scanner.nextInt();
        if(choosen == 0){
            if(this.parent != null) this.parent.start();
            else{
                System.out.println("Terima kasih telah menggunakan "+this.name);
                return;
            } 
        }
        else{
            for (Module module : modules) {
                if (module.getChoose() == choosen) {
                    module.start();
                }
            }
        }
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
    public void setChoose(int choose) {
        this.choose = choose;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Module getParent() {
        return this.parent;
    }

    @Override
    public void setParent(Module parent) {
        this.parent = (CoreModule) parent;
    }

    public List<? extends Module> getModules() {
        return modules;
    }

    public void setModules(List<? extends Module> modules) {
        this.modules = modules;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
