package com.train20210423.linklist;


import org.junit.Test;

/**
 * @author songyi
 * @date 2021-04-23 10:23
 * @Description:
 */
public class LinkListOperateTest {


    //0���߷�������
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Node node = LinkListOperate.geneLinkList(nums);
        LinkListOperate linkListOperate = new LinkListOperate();
        //Node reverse = linkListOperate.reverse(node);
        //Node reverse = linkListOperate.reverseIterate(node);
        //Node reverse = linkListOperate.reverseList(node);
        Node reverse = linkListOperate.reverseM2N(node, 2, 4);
        LinkListOperate.printNode(reverse);

    }
    //1.����ת  �ݹ飬�ǵݹ�
    @Test
    public void reverse(){

    }
    //2.�����Ƿ��л�
    //3.������������ϲ�
    //4. ��ת���� (m��n)
    //5.
    //6.
}
