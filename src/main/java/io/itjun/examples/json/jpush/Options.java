package io.itjun.examples.json.jpush;

/**
 * Created by iCrazyTeam on 2017/5/15.
 */
public class Options {
    private int time_to_live;
    private boolean apns_production;

    public int getTime_to_live() {
        return time_to_live;
    }

    public Options setTime_to_live(int time_to_live) {
        this.time_to_live = time_to_live;
        return this;
    }

    public boolean isApns_production() {
        return apns_production;
    }

    public Options setApns_production(boolean apns_production) {
        this.apns_production = apns_production;
        return this;
    }
}
