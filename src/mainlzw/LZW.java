/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlzw;

import java.util.ArrayList;

/**
 *
 * @author Ahmed Hassan
 */
public class LZW {  //abaababbaabaabaaaababbbbbbbb
    public ArrayList<String> Dictionary = new ArrayList();
    public ArrayList<String> Dictionary1 = new ArrayList();
    public ArrayList<Integer> ListCompress = new ArrayList();

    public String Compress(String str1) {
        for (int i = 0; i < 128; i++) {
            String str = null;
            char ch;
            ch = (char) i;
            str = str.valueOf(ch);
            Dictionary.add(str);
        }
        char ch;
        int store = 0;
        String str = "";
        for (int i = 0; i < str1.length(); i++) {
            ch = str1.charAt(i);
            str += ch;
            int index = Dictionary.indexOf(str);
            if (index >= 0) {
                store = index;
                if (i == str1.length() - 1) {
                    ListCompress.add(store);
                }
            } else {
                Dictionary.add(str);
                ListCompress.add(store);
                str = "";
                i--;
            }
        }
        String as = "";
        for (int ss : ListCompress) {
            System.out.println(ss);
            as += ss + "   ";
        }
        return as;
    }

    public String DeCompress() { //abaababbaabaabaaaababbbbbbbb
        String str = "", ch = "", show = "";
        int counter = 0, x = 0;
        for (int i = 0; i < 128; i++) {
            String str1 = null;
            char c;
            c = (char) i;
            str1 = str1.valueOf(c);
            Dictionary1.add(str1);
        }
        int count = 0;
        for (int j : ListCompress) {
            if (j < Dictionary1.size()) {
                ch = Dictionary1.get(j);
                show += ch;
            } else {
                String d = "";
                x = ListCompress.get(--count);
                d = Dictionary1.get(x);
                show+=d;
                char c;
                c = d.charAt(0);
                d += c;
                Dictionary1.add(d);
                str = "";
                ch = d;
            }
            counter = 0;
            while (true) {
                if (counter == ch.length()) {
                    break;
                } else {
                    str += ch.charAt(counter);
                    int check = Dictionary1.indexOf(str);
                    if (check >= 0) {
                        counter++;
                        continue;
                    } else {
                        Dictionary1.add(str);
                        str = "";
                    }
                }
            }
            count++;
        }
        for (String s : Dictionary1) {
            System.out.print(s + "\n");
        }
        return show;
    }
}
