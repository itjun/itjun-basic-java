package json.jpush;

/**
 * Created by iCrazyTeam on 2017/5/15.
 */
public class Sms_message {
    private String content;
    private int delay_time;

    public String getContent() {
        return content;
    }

    public Sms_message setContent(String content) {
        this.content = content;
        return this;
    }

    public int getDelay_time() {
        return delay_time;
    }

    public Sms_message setDelay_time(int delay_time) {
        this.delay_time = delay_time;
        return this;
    }

}
