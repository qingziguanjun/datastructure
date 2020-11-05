package com.rpc.serial;

import java.io.*;

//https://juejin.im/post/6844904070101090311
public class serializeTest {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("fufu");
        user.setAge("18");
        serialize(user);
        System.out.println("Java���л�ǰ�Ľ��: " + user);

        User duser = deserialize();
        System.out.println("Java�����л��Ľ��: " +  duser);
    }
    /**
     * @author xzf
     * @description ���л�
     * @date 2020/2/22 19:34
     */
    private static void serialize(User user) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("11.txt")));
        oos.writeObject(user);
        oos.close();
    }
    /**
     * @author xzf
     * @description �����л�
     * @date 2020/2/22 19:34
     */
    private static User deserialize() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\111.txt")));
        return (User) ois.readObject();
    }
}