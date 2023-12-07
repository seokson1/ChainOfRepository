package org.example;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        MessageSenderChain smsSenderChain = new SmsSenderChain();




        /*smsSenderChain.setNext(pushSenderChain);
        pushSenderChain.setNext(emailSenderChain);*/

        //요약
        //smsSenderChain.next(pushSenderChain).next(emailSenderChain);
        smsSenderChain.next(new PushSenderChain()).next(new EmailSenderChain()); // 이 방법으로 바로 선언

        smsSenderChain.send(user, new MessageDetail());
    }
}