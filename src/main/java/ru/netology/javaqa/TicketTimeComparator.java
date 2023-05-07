package ru.netology.javaqa;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        int arrivingTime1 = t1.getTimeTo() - t1.getTimeFrom();
        int arrivingTime2 = t2.getTimeTo() - t2.getTimeFrom();
        return arrivingTime1 - arrivingTime2;
    }
}

