package com.train20210423.composite;

/**
 * @author songyi
 * @date 2021-04-28 17:50
 * @Description:
 */
public class ClientTest {
    public static void main(String[] args) {
        Component window = new Component("����");
        Component button = new Component("��ť1");
        Component button1 = new Component("��ť2");
        Component frame = new Component("С��");
        window.addCentont(button);
        window.addCentont(button1);
        window.addCentont(frame);
        Component label = new Component("��ǩ1");
        Component textbox = new Component("�ı�");
        Component label2 = new Component("��ǩ2");
        Component passwordbox = new Component("�����");
        Component checkbox = new Component("��ѡ��");
        Component label3 = new Component("��ǩ");
        Component link = new Component("������");
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
