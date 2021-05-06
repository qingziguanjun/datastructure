package com.refactor.ch10;

/**
 * @author songyi
 * @date 2021-02-07 19:44
 * @Description:
 */
public class RenameMethod {

    // 10.1 重命名方法
    // 10.2 添加参数
    // 10.3 删除参数
    // 10.4 Separate Query from Modifier
    // 某个函数既返回对象状态值，又修改对象状态

    String foundMiscreant(String[] people){
        for(int i = 0 ; i < people.length; i++){
            if(people[i].equals("Don")){
                sendAlert();
                return "Don";
            }
            if(people[i].equals("John")){
                sendAlert();
                return "John";
            }
        }
        return "";
    }
    void checkSecurity(String[] people){
        String found = foundMiscreant(people);
        someLaterCode(found);
    }

    private void someLaterCode(String found) {

    }

    private void sendAlert() {
    }

    //重构

    String foundPerson(String[] people){
        for(int i = 0 ; i < people.length; i++){
            if(people[i].equals("Don")){
                return "Don";
            }
            if(people[i].equals("John")){
                return "John";
            }
        }
        return "";
    }
    void sendAlert(String[] people){
     if(!foundPerson(people).equals("")){
         sendAlert();
     }
    }
}
