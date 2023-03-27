package tugasAsd.presentation.leaf;

import tugasAsd.models.Account;
import tugasAsd.models.Posting;
import tugasAsd.presentation.CustomLoginModule;
import tugasAsd.presentation.Module;
import tugasAsd.service.GraphCustom;

public class PostingModule implements Module {
    private int choose;
    private String name;
    private CustomLoginModule parent;

    public PostingModule(String name, int choose) {
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
        Account currentAccount = this.parent.getCurrentAccount();
        GraphCustom graphCustom = this.parent.getGraph();
        System.out.println("masukkan judul postingan: ");
        String judul = this.parent.getScanner().nextLine();
        System.out.println("masukkan isi postingan: ");
        String isi = this.parent.getScanner().nextLine();
        Posting newPosting = new Posting(currentAccount.getUsername(), judul, isi);
        newPosting.printPosting();
        System.out.println("apakah anda yakin ingin memposting? (y/n)");
        String input = this.parent.getScanner().nextLine();
        if(input.equals("y")) {
            graphCustom.getFollowers(currentAccount).forEach(follower -> {
                follower.getPostingQueue().addPosting(newPosting);
            });
            System.out.println("postingan berhasil dibuat");
        }
        else{
            System.out.println("postingan dibatalkan");
        }
        this.parent.partialStart();
    }
}
