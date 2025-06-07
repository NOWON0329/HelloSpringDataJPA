package kr.ac.hansung.cse.report22.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="이름을 입력해주세요")
    private String name;

    @NotEmpty(message="브랜드를 입력해주세요")
    private String brand;

    @Pattern(
            regexp = "Korea|China|Japan|Europe|USA",
            message = "제조사는 Korea|China|Japan|Europe|USA 중 하나만 가능합니다."
    )
    @Column(name="made_in")
    private String madeIn;

    @Min(value = 100, message = "100원 미만은 등록이 불가능합니다.")
    @Max(value = 10000000, message = "1000만원 이상은 등록이 불가능합니다.")
    private double price;


    public Product(String name, String brand, String madeIn, double price) {
        this.name = name;
        this.brand = brand;
        this.madeIn = madeIn;
        this.price = price;
    }
}