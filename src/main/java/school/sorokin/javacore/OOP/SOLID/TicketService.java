package school.sorokin.javacore.OOP.SOLID;

import school.sorokin.javacore.OOP.SOLID.Noti.PushNoti;

public class TicketService {
    private final TicketRepository ticketRepository = new TicketRepository();
    private PushNoti pushNoti;

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        pushNoti.send();
    }
}
