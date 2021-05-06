package com.train20210423.composite;

/**
 * @author songyi
 * @date 2021-04-28 17:50
 * @Description:
 */
public class ClientTest {
    public static void main(String[] args) {
        Component window = new Component("´°¿Ú");
        Component button = new Component("°´Å¥1");
        Component button1 = new Component("°´Å¥2");
        Component frame = new Component("Ð¡´°");
        window.addCentont(button);
        window.addCentont(button1);
        window.addCentont(frame);
        Component label = new Component("±êÇ©1");
        Component textbox = new Component("ÎÄ±¾");
        Component label2 = new Component("±êÇ©2");
        Component passwordbox = new Component("ÃÜÂë¿ò");
        Component checkbox = new Component("¹´Ñ¡¿ò");
        Component label3 = new Component("±êÇ©");
        Component link = new Component("³¬Á´½Ó");
        frame.addCentont(label);
        frame.addCentont(textbox);
        frame.addCentont(label2);
        frame.addCentont(passwordbox);
        frame.addCentont(checkbox);
        frame.addCentont(label3);
        frame.addCentont(link);
        window.print("");
        /**
         * window
         *
         * ?		picture
         *
         * ?		button
         *
         * ?		button
         *
         * ?		frame
         *
         * ?			label textbox label passordbox
         *
         * ?			checkbox  label linklable
         */
    }
}
