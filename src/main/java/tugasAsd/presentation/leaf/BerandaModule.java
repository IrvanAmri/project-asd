package tugasAsd.presentation.leaf;

import java.security.InvalidParameterException;

import tugasAsd.presentation.CustomLoginModule;
import tugasAsd.presentation.Module;
import tugasAsd.service.QueueCustom;

public class BerandaModule implements Module{

    private int choose;
    private String name;
    private CustomLoginModule parent;

    public BerandaModule(String name, int choose) {
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
        System.out.println("===============================");
        System.out.println("Beranda");
        System.out.println("-------------------------------");
        QueueCustom postingQueue = this.parent.getCurrentAccount().getPostingQueue();
        if(postingQueue.getSize()>0){
            postingQueue.getAllPosting().forEach(posting -> {
                posting.printPosting();
            });
        }
        else{
            System.out.println("tidak ada postingan yang ditemukan");
        }
        this.parent.partialStart();

        // this.parent.getCurrentAccount()
        //     .getPostingQueue()
        //     .getAllPosting()
        //     .forEach(posting -> {
        //         posting.printPosting();
        //     });
    }
    
}
