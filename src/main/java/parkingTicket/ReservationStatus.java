package parkingTicket;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ReservationStatus_table")
public class ReservationStatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long ticketReservationId;
        private Long memberId;
        private Date reservationDate;
        private String status;
        private Long parkingLotId;
        private Long ticketDeliveryId;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getTicketReservationId() {
            return ticketReservationId;
        }

        public void setTicketReservationId(Long ticketReservationId) {
            this.ticketReservationId = ticketReservationId;
        }
        public Long getMemberId() {
            return memberId;
        }

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }
        public Date getReservationDate() {
            return reservationDate;
        }

        public void setReservationDate(Date reservationDate) {
            this.reservationDate = reservationDate;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public Long getParkingLotId() {
            return parkingLotId;
        }

        public void setParkingLotId(Long parkingLotId) {
            this.parkingLotId = parkingLotId;
        }
        public Long getTicketDeliveryId() {
            return ticketDeliveryId;
        }

        public void setTicketDeliveryId(Long ticketDeliveryId) {
            this.ticketDeliveryId = ticketDeliveryId;
        }

        @Override
        public String toString() {
            return "ReservationStatus{" +
                    "id=" + id +
                    ", ticketReservationId=" + ticketReservationId +
                    ", memberId=" + memberId +
                    ", reservationDate=" + reservationDate +
                    ", status='" + status + '\'' +
                    ", parkingLotId=" + parkingLotId +
                    ", ticketDeliveryId=" + ticketDeliveryId +
                    '}';
        }        

}
