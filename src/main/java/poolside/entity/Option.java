package poolside.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ps_option")
public class Option extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;
    private String description; //옵션 설명
    private String price; // 옵션 가격

    @Builder
    public Option(String description, String price) {
        this.description = description;
        this.price = price;
    }

    public void update(String description, String price) {
        this.description = description;
        this.price = price;
    }

}
