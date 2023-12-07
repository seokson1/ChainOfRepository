package org.example;

public class EmailSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("Email 전송!");
    }
}
