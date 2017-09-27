/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlzw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Ahmed Hassan
 */
public class MainLZW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Expreetion : ");
        String str = input.next();
        LZW lzw = new LZW();
        //  lzw.Compress(str);
        try (PrintWriter obj = new PrintWriter("out.txt")) {
            obj.write(lzw.Compress(str));
            System.out.print("\n");
            obj.write(lzw.DeCompress());
        }
        //   String hh1 = new Scanner(new File("out.txt")).useDelimiter("\\z").next();
        // lzw.DeCompress();
    }

}
