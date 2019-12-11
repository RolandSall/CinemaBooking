package com.roland.movietheater_jdbc.repository.TicketRepository;

import com.roland.movietheater_jdbc.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepositoryDAO   implements  ITicketRepositoryDAO{

    private static final String SQL_STATEMENT_TO_CREATE_A_TICKET ="INSERT INTO ticket (customer_id, price) VALUES (?,?)";

    private static final String SQL_STATEMENT_TO_RETURN_THE_TICKET_ID_OF_LAST_RESERVATION
            ="select max(ticket_id) from ticket";


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int createTicket(int userID, double ticketPrice) {
        jdbcTemplate.update(SQL_STATEMENT_TO_CREATE_A_TICKET,userID,ticketPrice);

      /*  Ticket lastTickedIdGenerated = jdbcTemplate.queryForObject(SQL_STATEMENT_TO_RETURN_THE_TICKET_ID_OF_LAST_RESERVATION
                ,new LatestTicketGeneratedMapper());

        return lastTickedIdGenerated.getTickedId();*/
      return 0;
    }
}
