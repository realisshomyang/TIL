package com.myang.websocketstudy.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Message {
    private String type;
    private String sender;
    private String channelId;
    private Long userId;
    private Object data;

    public void setSender(String sender){this.sender = sender;}
    public void newConnect(){
        this.type = "new";
    }
    public void closeConnect() {
        this.type = "close";}

}
