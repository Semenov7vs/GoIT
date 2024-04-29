package org.example.module14.model;

import lombok.Data;
import javax.persistence.*;
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
}