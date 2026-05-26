package school.sorokin.javacore.OOP.SOLID;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer, Ticket> ticketMap = new HashMap<>();
    int count = 0;

    public void save(Ticket ticket) {
        ticketMap.put(count, ticket);
        count++;
    }
}
