package message;

import type.Type;

public class Message {
    private String msg;
    private Type type;

    // default null argument constructor

    // getter and setter
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // Print the object

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                ", type=" + type +
                '}';
    }
}
