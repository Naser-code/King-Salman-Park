/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingsalmanpark;

/**
 *
 * @author Naser AlShunaifi <your.name at your.org>
 */
public class Node {
    int bookingID;
    int vID;
    int vDate;
    int pID;
    String vName;
    Node next;
    Node prev;

    public Node() {}

    public Node(int bookingID, int vID, int vDate, int pID, String vName) {
        this.bookingID = bookingID;
        this.vID = vID;
        this.vDate = vDate;
        this.pID = pID;
        this.vName = vName;
    }

    public String toString() {
        return bookingID + " " + vID + " " + String.format("%08d", vDate) + " " + pID + " " + vName;
    }
}
