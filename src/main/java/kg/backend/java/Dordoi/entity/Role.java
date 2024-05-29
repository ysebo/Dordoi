package kg.backend.java.Dordoi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String name;
}
