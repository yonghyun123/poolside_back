package poolside.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "ps_reserve_option")
public class ReserveOption extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_option_id")
    private Long id;

    private Long reservationId;
    private Long optionId;
    private Integer optionCnt;
    private String optionPrice;
    private String totPrice;

}
