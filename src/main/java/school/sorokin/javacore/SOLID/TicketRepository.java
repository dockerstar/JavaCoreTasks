package school.sorokin.javacore.SOLID;

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
