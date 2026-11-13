/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdfall23_is1804.IOT1801;

import java.util.Scanner;

/**
 * if (scanner.hasNextLine()) scanner.nextLine(); }
 *
 * @author thangnv75
 */
public class Main {

    public static void main(String[] args) {

        Linkedlist lt = new Linkedlist();
        lt.addHead(70);
        lt.addHead(4);
        lt.addHead(1);
        lt.addHead(8);
        lt.addHead(1);
        lt.addHead(1);
        lt.addHead(1);
lt.addHead(1);
lt.addHead(10);
        lt.addTail(6);
        lt.addTail(70);
        System.out.println("\nDS la");
        lt.display();
        int x = 1;
        int pos;
        pos = lt.findnth(1, 4);
        lt.removeAt(pos);
        System.out.println("After remove");
        lt.display();
        
    }
}
