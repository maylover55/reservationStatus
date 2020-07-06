package parkingTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ReservationStatusController {
    @Autowired
    ReservationStatusRepository reservationStatusRepo;

    // reservationID로 ReservationStatus 조회하는 API 제공
    @RequestMapping(method= RequestMethod.GET, path="/reservationStatuses/reservationID")
    public String getStatusByReservationID (@RequestParam("id") Long reservationID){
        System.out.println("##### getStatusByReservationID Start reservationID: " + reservationID);

        List<ReservationStatus> searchReservationStatus = reservationStatusRepo.findByTicketReservationId(reservationID);

        return searchReservationStatus.get(0).toString();
    }
}
