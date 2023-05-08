package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Moscow", "London", 1000, 7, 12);
    Ticket ticket2 = new Ticket("Moscow", "London", 9000, 10, 13);
    Ticket ticket3 = new Ticket("Almaty", "Dubai", 3000, 13, 16);
    Ticket ticket4 = new Ticket("London", "Tokio", 4000, 3, 14);
    Ticket ticket5 = new Ticket("Tokio", "London", 5000, 15, 20);
    Ticket ticket6 = new Ticket("Moscow", "London", 6000, 20, 23);

    @Test
    public void shouldSortByPrice() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket1, ticket6, ticket2};
        Ticket[] actual = manager.search("Moscow", "London");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOne() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("London", "Tokio");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNull() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {};
        Ticket[] actual = manager.search("Moscow", "Almaty");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestTicketComparator() {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket2, ticket6, ticket1};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "London", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneByComparator() {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchAndSortBy("Almaty", "Dubai", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNullByComparator() {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Almaty", "Moscow", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
