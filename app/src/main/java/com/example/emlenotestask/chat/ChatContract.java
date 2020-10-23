package com.example.emlenotestask.chat;

import com.example.emlenotestask.model.Chat;

public interface ChatContract {
    interface viewInterface{
        void showMessages(Chat body);
        void displayError(String msg);
    }

    interface  presenterInterface{
        void getChatMessages();
    }
}
