package main;

import support.RenderSupport;

public class Client {
    public static void main(String[] args) {
        RenderSupport rs = new RenderSupport();
        rs.render("Hello From Main Client");

        // now check whether Module<Client> can access Module<data::Message>
        /*
        * Error:
        * java: message.Message.getMsg() in package message is not accessible
  (package message is declared in module com.example.data, which does not export it to module com.example.client)
        * */
        System.out.println(rs.getCurrentMsg().getMsg());
        System.out.println(rs.getCurrentMsg().getType());

    }
}
