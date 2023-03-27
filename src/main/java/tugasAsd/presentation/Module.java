package tugasAsd.presentation;

public interface Module {
    public void start();

    public String getName();
    public void setName(String name);

    public int getChoose();
    public void setChoose(int choose);

    public Module getParent();
    public void setParent(Module parent);
}
