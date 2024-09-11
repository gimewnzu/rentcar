package rentcar.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentcar.ReservationApplication;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Date reserveDt;

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }
}
//>>> DDD / Aggregate Root
