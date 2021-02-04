package com.sy.study;

import com.rpc.serial.User;
import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author songyi
 * @date 2020-11-02 11:16
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {




            List<User> userList = new ArrayList<>();
            userList.add(new User("1L", "aaa"));
            userList.add(new User("2L", "bbb"));
            userList.add(new User("3L", "ccc"));
            userList.add(new User("3L", "ddd"));
            userList.add(new User("3L", "eee"));
            Map<String, User> map = userList.stream()
                .collect(Collectors.toMap(User::getAge, r->r, (a, b) -> b));
        List<User> collect = userList.stream().filter(user -> user.getAge() == "2").collect(Collectors.toList());
        System.out.println(map);

        Map<String , Set<String>>  a = new HashMap<>();
        Map<String , Set<String>>  b = new HashMap<>();
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> s3 = new HashSet<>();
        Set<String> s4 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        s2.add("3");
        s2.add("4");
        s3.add("5");
        s3.add("6");
        s4.add("7");
        a.put("a", s1);
        a.put("b", s2);
        b.put("c", s3);
        b.put("a", s4);
        System.out.println(a);
        System.out.println(b);
        merge(a,b );
        System.out.println(a);

    }

    private  static  void merge(Map<String, Set<String>> blackMap, Map<String, Set<String>> blackActionUser){
        if(blackActionUser == null){
            return;
        }
        for(String code : blackActionUser.keySet()){
            Set<String> blackSet = blackMap.get(code);
            if(blackSet == null){
                blackActionUser.get(code);
                blackMap.put(code, blackActionUser.get(code));
            }else {
                blackSet.addAll(blackActionUser.get(code));
            }
        }
    }

}
