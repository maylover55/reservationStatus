package parkingTicket;

import parkingTicket.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationStatusViewHandler {

    @Autowired
    private ReservationStatusRepository reservationStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTicketReserved_then_CREATE_1 (@Payload TicketReserved ticketReserved) {
        try {
            if (ticketReserved.isMe()) {
                // view 객체 생성
                ReservationStatus reservationStatus = new ReservationStatus();
                // view 객체에 이벤트의 Value 를 set 함
                reservationStatus.setTicketReservationId(ticketReserved.getId());
                reservationStatus.setMemberId(ticketReserved.getMemberId());
                reservationStatus.setReservationDate(ticketReserved.getReservationDate());
                // view 레파지 토리에 save
                reservationStatusRepository.save(reservationStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFullyOccupied_then_UPDATE_1(@Payload FullyOccupied fullyOccupied) {
        try {
            if (fullyOccupied.isMe()) {
                // view 객체 조회
                List<ReservationStatus> reservationStatusList = reservationStatusRepository.findByTicketReservationId(fullyOccupied.getTicketReservationId());
                for(ReservationStatus reservationStatus : reservationStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationStatus.setParkingLotId(fullyOccupied.getId());
                    reservationStatus.setStatus(fullyOccupied.getStatus());
                    // view 레파지 토리에 save
                    reservationStatusRepository.save(reservationStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOccupied_then_UPDATE_2(@Payload Occupied occupied) {
        try {
            if (occupied.isMe()) {
                // view 객체 조회
                List<ReservationStatus> reservationStatusList = reservationStatusRepository.findByTicketReservationId(occupied.getTicketReservationId());
                for(ReservationStatus reservationStatus : reservationStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationStatus.setParkingLotId(occupied.getId());
                    reservationStatus.setStatus(occupied.getStatus());
                    // view 레파지 토리에 save
                    reservationStatusRepository.save(reservationStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenShipped_then_UPDATE_3(@Payload Shipped shipped) {
        try {
            if (shipped.isMe()) {
                // view 객체 조회
                List<ReservationStatus> reservationStatusList = reservationStatusRepository.findByTicketReservationId(shipped.getTicketReservationId());
                for(ReservationStatus reservationStatus : reservationStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationStatus.setTicketDeliveryId(shipped.getId());
                    reservationStatus.setStatus(shipped.getStatus());
                    // view 레파지 토리에 save
                    reservationStatusRepository.save(reservationStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCancelled_then_UPDATE_4(@Payload DeliveryCancelled deliveryCancelled) {
        try {
            if (deliveryCancelled.isMe()) {
                // view 객체 조회
                List<ReservationStatus> reservationStatusList = reservationStatusRepository.findByTicketReservationId(deliveryCancelled.getTicketReservationId());
                for(ReservationStatus reservationStatus : reservationStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationStatus.setStatus(deliveryCancelled.getStatus());
                    // view 레파지 토리에 save
                    reservationStatusRepository.save(reservationStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenVacated_then_UPDATE_5(@Payload Vacated vacated) {
        try {
            if (vacated.isMe()) {
                // view 객체 조회
                List<ReservationStatus> reservationStatusList = reservationStatusRepository.findByTicketReservationId(vacated.getTicketReservationId());
                for(ReservationStatus reservationStatus : reservationStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationStatus.setStatus(vacated.getStatus());
                    // view 레파지 토리에 save
                    reservationStatusRepository.save(reservationStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

/*
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_DELETE_1(@Payload DeliveryCancelled deliveryCancelled) {
        try {
            if (deliveryCancelled.isMe()) {
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
*/
}