package org.example;

import java.util.Objects;

import static java.util.Objects.nonNull;

public abstract class MessageSenderChain { //abstract 만들어야하는 이유 -> R1 처리 -> R2처리 뒤에 누가 있는지 알아야 처리.
    //chain 내가 자체를 들고 있음. 링크드 리스트 생각
    private MessageSenderChain next;

    public MessageSenderChain next(MessageSenderChain next) {
        this.next = next; //pushSendChain
        return next;
    }

    public void send(User user, MessageDetail messageDetail) {
        // TODO
        execute(user, messageDetail);

        //next
        if(nonNull(next)) { // 마지막은 비워 있을 수 있기 때문에 null 처리 해야됨.
            next.send(user, messageDetail); // 마지막 chain 끝날때 까지 실행됨. 이어짐
        }
    }

    protected abstract void execute(User user, MessageDetail messageDetail);
}
