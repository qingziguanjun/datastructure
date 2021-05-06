package com.refactor.ch10;

/**
 * @author songyi
 * @date 2021-02-07 19:44
 * @Description:
 */
public class RenameMethod {

    // 10.1 ����������
    // 10.2 ��Ӳ���
    // 10.3 ɾ������
    // 10.4 Separate Query from Modifier
    // ĳ�������ȷ��ض���״ֵ̬�����޸Ķ���״̬

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

    //�ع�

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
