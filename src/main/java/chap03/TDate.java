package chap03;

/**
 * Created by iCrazyTeam on 2016/4/17 0017.
 */
public class TDate extends TDateTime {

    private static final long serialVersionUID = 1L;

    public TDate(java.util.Date date) {
        this.setData(date);
    }

    public TDate(String date) {
        TDateTime val = TDateTime.fromDate(date);
        if (val == null)
            throw new RuntimeException(String.format("%s 不是一个有效的日期格式！", date));
        this.setData(val.getData());
    }

    @Override
    public String toString() {
        return this.getDate();
    }

}
