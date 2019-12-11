package com.roland.movietheater_jdbc.repository.TicketRepository;

public interface ITicketRepositoryDAO {
    int createTicket(int userID, double ticketPrice);
}
