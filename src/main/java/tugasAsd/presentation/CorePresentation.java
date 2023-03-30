package tugasAsd.presentation;

import java.util.ArrayList;
import java.util.List;

import tugasAsd.presentation.leaf.BerandaModule;
import tugasAsd.presentation.leaf.CreateAccountModule;
import tugasAsd.presentation.leaf.FollowModule;
import tugasAsd.presentation.leaf.PostingModule;
import tugasAsd.service.GraphCustom;

public final class CorePresentation {
    
    public static void begin(){
        // resource
        GraphCustom graph = new GraphCustom();

        // main module
        CoreModule core = new CoreModule("Aplikasi Medsos CLI", 1);

        // sub module
        CustomLoginModule login = new CustomLoginModule("Login", 1, graph);
        login.setParent(core);

        CreateAccountModule createAccount = new CreateAccountModule("Create Account", 2, graph);
        createAccount.setParent(core);

        // login leaf module
        BerandaModule beranda = new BerandaModule("Beranda", 1);
        beranda.setParent(login);
        PostingModule posting = new PostingModule("Posting", 2);
        posting.setParent(login);
        FollowModule follow = new FollowModule("Follow", 3);
        follow.setParent(login);

        // login arangements
        login.setModules(new ArrayList<>(List.of(beranda, posting, follow)));


        // main arangements
        core.setModules(new ArrayList<>(List.of(login, createAccount)));


        core.start();
    }
}
