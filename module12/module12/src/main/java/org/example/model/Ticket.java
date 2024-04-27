package org.example.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JoinColumn(name = "client_id", nullable = false)
    @ManyToOne
    private Client client;

    @JoinColumn(name = "from_planet_id", nullable = false)
    @ManyToOne
    private Planet fromPlanet;

    @JoinColumn(name = "to_planet_id", nullable = false)
    @ManyToOne
    private Planet toPlanet;
}