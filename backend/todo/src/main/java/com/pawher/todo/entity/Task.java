package com.pawher.todo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Pawcio on 2019-01-09.
 */

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;
}
