package tugasAsd.presentation.leaf;

import tugasAsd.presentation.CustomLoginModule;
import tugasAsd.presentation.Module;

public class BerandaModule implements Module{

    private int choose;
    private String name;
    private CustomLoginModule parent;

    public BerandaModule(String name, int choose) {
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
        this.parent.getCurrentAccount().getPostingQueue().getAllPosting().forEach(posting -> {
            posting.printPosting();
        });
        this.parent.partialStart();
    }
    
}
