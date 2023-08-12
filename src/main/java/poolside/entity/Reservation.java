package poolside.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "ps_reservation")
public class Reservation extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;
    private String reserveStcd;//00:입금대기, 01:예약완료, 02:취소대기, 03: 취소완료
    @Column(name = "resr_stcd")
    private String reserveStartDate;
    @Column(name = "resr_endt")
    private String reserveEndDate;
    private Integer maxCnt; //최대인원
    private String totPrice; //예약금액
    @Column(name = "pcnt")
    private Integer reserveNumber; //예약인원
    @Column(name = "cust_name")
    private String customerName;
    @Column(name = "cust_psno")
    private String customerPhoneNum;

}
