package school.sorokin.javacore.SOLID;

import school.sorokin.javacore.SOLID.Noti.PushNoti;
import school.sorokin.javacore.SOLID.Noti.SendMessage;

import java.util.HashMap;
import java.util.Map;

public class TicketService {
    private final TicketRepository ticketRepository = new TicketRepository();
    private PushNoti pushNoti;

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        pushNoti.send();
    }
}
