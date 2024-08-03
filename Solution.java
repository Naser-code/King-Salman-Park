/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingsalmanpark;

import java.util.Scanner;

/**
 *
 * @author Naser AlShunaifi <your.name at your.org>
 */
public class Solution {
    public static void main(String[] args) {
        CList list = new CList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!scanner.hasNextLine()) {
                break;
            }

            String inputLine = scanner.nextLine().trim();

            if (inputLine.isEmpty()) {
                break;
            }

            String[] parts = inputLine.split(" ");
            int command = Integer.parseInt(parts[0]);

            switch (command) {
                case 1: 
                    int bookingID = Integer.parseInt(parts[1]);
                    int vID = Integer.parseInt(parts[2]);
                    int vDate = Integer.parseInt(parts[3]);
                    int pID = Integer.parseInt(parts[4]);


                    StringBuilder sb = new StringBuilder();
                    for (int i = 5; i < parts.length; i++) {
                        sb.append(parts[i]);
                        if (i < parts.length - 1) {
                            sb.append(" ");
                        }
                    }
                    String vName = sb.toString();

                    Node newNode = new Node(bookingID, vID, vDate, pID, vName);
                    list.insert(newNode);
                    break;

                case 2: 
                    int removeVID = Integer.parseInt(parts[1]);
                    list.remove(removeVID);
                    break;

                case 3: 
                    int earningPID = Integer.parseInt(parts[1]);
                    System.out.println(list.earning(earningPID));
                    break;

                case 4: 
                    int printDate = Integer.parseInt(parts[1]);
                    list.print1(printDate);
                    break;

                case 5: 
                    int printPID = Integer.parseInt(parts[1]);
                    list.print2(printPID);
                    break;

                case 6: 
                    int printBookingID = Integer.parseInt(parts[1]);
                    list.print3(printBookingID);
                    break;

                default:
                    System.out.println("0");
                    break;
            }
        }
    }
}
