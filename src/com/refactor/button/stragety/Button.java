package com.refactor.button.stragety;

/**
 * @author songyi
 * @date 2021-02-08 10:56
 * @Description:
 */
public class Button {
    private ButtonServer buttonServer;
    private  int token;

    public ButtonServer getButtonServer() {
        return buttonServer;
    }

    public void setButtonServer(ButtonServer buttonServer) {
        this.buttonServer = buttonServer;
    }

    public void press(){
        buttonServer.buttonPressed(token);
    }

    public static void main(String[] args) {
        Button button = new Button();
        //button.setButtonServer();
        //ButtonServer buttonServer =

    }
}
