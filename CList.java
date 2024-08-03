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
public class CList {
    Node cursor;
    int size;

    public CList() {
        cursor = null;
        size = 0;
    }

    public void insert(Node N) {
    if (cursor == null) {
        cursor = N;
        N.next = N;
        N.prev = N;
    } else {
        int dayCursor = cursor.vDate / 1000000;
        int monthCursor = (cursor.vDate / 10000) % 100;
        int yearCursor = cursor.vDate % 10000;

        int dayN = N.vDate / 1000000;
        int monthN = (N.vDate / 10000) % 100;
        int yearN = N.vDate % 10000;

        int formattedCursorVDate = dayCursor + (monthCursor * 100) + (yearCursor * 10000);
        int formattedNVDate = dayN + (monthN * 100) + (yearN * 10000);

        Node current = cursor;
        if (formattedNVDate < formattedCursorVDate) { 
            N.next = cursor;
            N.prev = cursor.prev;
            cursor.prev.next = N;
            cursor.prev = N;
            cursor = N; 
        } else {
            do {
                int dayCurrent = current.next.vDate / 1000000;
                int monthCurrent = (current.next.vDate / 10000) % 100;
                int yearCurrent = current.next.vDate % 10000;
                int formattedCurrentVDate = dayCurrent + (monthCurrent * 100) + (yearCurrent * 10000);

                if (formattedNVDate < formattedCurrentVDate || current.next == cursor) {  
                    N.next = current.next;
                    N.prev = current;
                    current.next.prev = N;
                    current.next = N;
                    break;
                }
                current = current.next;
            } while (current != cursor);
        }
    }
    size++;
}


    public void remove(int vID) {
        if (cursor == null) {
            return;
        }

        Node current = cursor;
        do {
            if (current.vID == vID) {
                if (current.next == current) {
                    cursor = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;

                    if (current == cursor) {
                        cursor = current.next;
                    }
                }

                size--;
                return;
            }
            current = current.next;
        } while (current != cursor);
    }

public int earning(int pID) {
    int totalEarning = 0;
    Node tmp = cursor;
    if (tmp == null) return 0;
    do {
        if (tmp.pID == pID) {
            int day = tmp.vDate / 1000000;
            int month = (tmp.vDate / 10000) % 100;
            int year = tmp.vDate % 10000;

            boolean isWeekend = day == 6 || day == 7 || day == 13 || day == 14 || day == 20 || day == 21 || day == 27 ||             day == 28;
            boolean isSpecialHoliday = (day == 22 && month == 2) || (day == 23 && month == 9);

            int weekendRate = 0, weekdayRate = 0, specialHolidayRate = 0;
            switch (pID) {
                case 1:
                    weekendRate = 1000;
                    weekdayRate = 700;
                    specialHolidayRate = 500;
                    break;
                case 2:
                    weekendRate = 100;
                    weekdayRate = 50;
                    specialHolidayRate = 0;
                    break;
                case 3:
                    weekendRate = 50;
                    weekdayRate = 20;
                    specialHolidayRate = 0;
                    break;
                case 4:
                    weekendRate = 800;
                    weekdayRate = 500;
                    specialHolidayRate = 500;
                    break;
                case 5:
                    weekendRate = 100;
                    weekdayRate = 50;
                    specialHolidayRate = 50;
                    break;
                case 6:
                    weekendRate = 100;
                    weekdayRate = 50;
                    specialHolidayRate = 100;
                    break;
                case 7:
                    weekendRate = 100;
                    weekdayRate = 50;
                    specialHolidayRate = 50;
                    break;
                default:
                    break;
            }

            if (isSpecialHoliday) {
                totalEarning += specialHolidayRate;
            } else if (isWeekend) {
                totalEarning += weekendRate;
            } else {
                totalEarning += weekdayRate;
            }
        }
        tmp = tmp.next;
    } while (tmp != cursor);
    return totalEarning;
}

    public void print1(int vDate) {
        Node tmp = cursor;
        if (tmp == null) {
            System.out.println(0);
            return;
        }
        do {
            if (tmp.vDate == vDate) {
                System.out.println(tmp.toString());
            }
            tmp = tmp.next;
        } while (tmp != cursor);
    }

    public void print2(int pID) {
    Node tmp = cursor;
    boolean found = false;
    if (tmp == null) {
        System.out.println(0);
        return;
    }
    do {
        if (tmp.pID == pID) {
            System.out.println(tmp.toString());
            found = true;
        }
        tmp = tmp.next;
    } while (tmp != cursor);

    if (!found) {
        System.out.println(0);
    }
}


    public void print3(int bookingID) {
        Node tmp = cursor;
        if (tmp == null) {
            System.out.println(0);
            return;
        }
        do {
            if (tmp.bookingID == bookingID) {
                System.out.println(tmp.toString());
                return;
            }
            tmp = tmp.next;
        } while (tmp != cursor);
        System.out.println(0);
    }
}