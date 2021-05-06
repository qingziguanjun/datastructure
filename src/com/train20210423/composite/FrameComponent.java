package com.train20210423.composite;

/**
 * @author songyi
 * @date 2021-04-30 14:57
 * @Description:
 */
public class FrameComponent extends Container{
    public FrameComponent(String name) {
        super(name);
    }

    @Override
    public void print(){
        System.out.println("�ҵ�����" + this.name);
        super.print();
    }
}
