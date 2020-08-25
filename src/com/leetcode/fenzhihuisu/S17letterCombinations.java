package com.leetcode.fenzhihuisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songyi
 * @date 2020-08-12 19:34
 * @Description:
 */
public class S17letterCombinations {
    /**
     * ���ߣ�LeetCode
     *     ���ӣ�https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode/
     *     ��Դ�����ۣ�LeetCode��
     *     ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     */
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public static void main(String[] args) {
        S17letterCombinations s17letterCombinations = new S17letterCombinations();
        List<String> result = s17letterCombinations.letterCombinations2("23");
        System.out.println(result);
    }


    /**
     *
     ���ߣ�wang_ni_ma
     ���ӣ�https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
     ��Դ�����ۣ�LeetCode��
     ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     */
    //һ��ӳ����ڶ���λ����"abc��,������λ����"def"������
    //����Ҳ������map����������Ը���ʡ���ڴ�
    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations2(String digits) {
        //ע��߽�����
        if(digits==null || digits.length()==0) {
            return new ArrayList<>();
        }
        iterStr(digits, "", 0);
        return res;
    }
    //������������list
    List<String> res = new ArrayList<>();

    //�ݹ麯��
    void iterStr(String str, String letter, int index) {
        //�ݹ����ֹ������ע���������ֹ��������ȥ����̬��ʾͼ��Щ��ͬ����Ҫ�����˵��Ż�
        //��̬ͼ����ÿ�ν�ȡ�ַ�����һ���֣�"234"�����"23"���ٱ��"3"�������""���������ܲ���
        //����index��¼ÿ�α������ַ�����λ�ã��������ܸ���
        if(index == str.length()) {
            res.add(letter);
            return;
        }
        //��ȡindexλ�õ��ַ�������������ַ���"234"
        //��һ�εݹ�ʱindexΪ0����c=2���ڶ���indexΪ1����c=3��������c=4
        //subStringÿ�ζ��������µ��ַ�������index����ȡ��ǰ��һ���ַ�������Ч�ʸ���һ��
        char c = str.charAt(index);
        //map_string���±��Ǵ�0��ʼһֱ��9�� c-'0'�Ϳ���ȡ����Ե������±�λ��
        //����c=2ʱ��2-'0'����ȡ�±�Ϊ2,letter_map[2]����"abc"
        int pos = c - '0';
        String map_string = letter_map[pos];
        //�����ַ����������һ�εõ�����2��ҳ���Ǳ���"abc"
        for(int i=0;i<map_string.length();i++) {
            //������һ��ݹ飬�����ֺ�������������϶�̬ͼ���
            iterStr(str, letter+map_string.charAt(i), index+1);
        }
    }

}
