package com.example.acer.vithelp.Model;

public class FeedbackWord {

    public String id;
    public String prob;
    public String date;
    public String time;
    private String type;
    public String blocktype;
    public String block;
    public String desp;
    public String progress;

    public FeedbackWord(String mid, String mprob, String mdate, String mTime,String mtype, String mbt, String mblock, String mdesp, String pr) {
        id = mid;
        prob = mprob;
        date = mdate;
        time = mTime;
        blocktype = mbt;
        block = mblock;
        desp = mdesp;
        progress = pr;
        type = mtype;
    }

    public String getId() {
        return id;
    }

    public String getProb() {
        return prob;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getBlocktype() {
        return blocktype;
    }

    public String getBlock() {
        return block;
    }


    public String getDesp() {
        return desp;
    }

    public String getProgress() {
        return progress;
    }

    public String getType() {
        return type;
    }
}
