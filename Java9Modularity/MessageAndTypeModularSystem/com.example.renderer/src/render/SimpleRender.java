package render;

import message.Message;

public class SimpleRender {
    public void renderAsString(Message msg){
        System.out.format("%n{Message=%s, Type=%s}%n",
                msg.getMsg(),
                msg.getType());
    }
}
