package chap08.override;

/**
 * Created by iCrazyTeam on 2016/6/1 0001.
 */
public class Son extends Father {
    private String overright;

    public Son() {
        super();
    }

    public Son(String overright) {
        super(overright);
        this.setOverright(overright);
    }

    public String getOverright() {
        return overright;
    }

    public void setOverright(String overright) {
        this.overright = overright;
    }
}
