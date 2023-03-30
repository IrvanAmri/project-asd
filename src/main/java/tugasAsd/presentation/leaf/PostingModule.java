package tugasAsd.presentation.leaf;

import java.security.InvalidParameterException;
import java.util.Scanner;

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
        System.out.println("===============================");
        System.out.println("Posting");
        System.out.println("-------------------------------");
        Account currentAccount = this.parent.getCurrentAccount();
        GraphCustom graphCustom = this.parent.getGraph();
        System.out.println("Masukkan judul postingan: ");
        String judul = scanner.nextLine();
        System.out.println("Masukkan isi postingan: ");
        String isi = scanner.nextLine();
        Posting newPosting = new Posting(currentAccount.getUsername(), judul, isi);
        newPosting.printPosting();
        System.out.println("Apakah anda yakin ingin di-post? (y/n)");
        String input = scanner.nextLine();
        if(input.equals("y")) {
            graphCustom.getFollowers(currentAccount).forEach(follower -> {
                follower.getPostingQueue().addPosting(newPosting);
            });
            System.out.println("Postingan berhasil dibuat");
        }
        else{
            System.out.println("Postingan dibatalkan");
        }
        this.parent.partialStart();
    }
}
