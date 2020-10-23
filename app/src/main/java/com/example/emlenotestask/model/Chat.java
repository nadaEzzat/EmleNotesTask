package com.example.emlenotestask.model;

import java.util.List;

public class Chat {
    private String Name;
    private String Pic;
    private List<Messages> Messages;

    public String getName() {
        return Name;
    }


    public String getPic() {
        return Pic;
    }


    public List<com.example.emlenotestask.model.Messages> getMessages() {
        return Messages;
    }

}
