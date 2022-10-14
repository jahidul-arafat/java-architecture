package support;

import message.Message;
import render.SimpleRender;
import type.Type;

public class RenderSupport {
    Message msg = new Message();

    // method will be called by client
    public void render(String msg){
        this.msg.setMsg(msg);
        this.msg.setType(Type.STRING);

        new SimpleRender().renderAsString(this.msg);
    }

    // getter and setter

    public Message getCurrentMsg() {
        return this.msg;
    }
}
