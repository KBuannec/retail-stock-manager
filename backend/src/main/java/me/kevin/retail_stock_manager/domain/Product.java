package me.kevin.retail_stock_manager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le SKU (référence) est obligatoire")
    @Column(unique = true)
    private String sku;

    @NotBlank(message = "Le nom du produit est obligatoire")
    private String name;

    private String description;

    @Min(value = 0, message = "Le stock ne peut pas être négatif")
    private Integer quantity;

    @Min(value = 0, message = "Le prix ne peut pas être négatif")
    private Double price;
}
