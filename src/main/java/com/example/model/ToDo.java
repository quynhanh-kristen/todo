package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Timestamp;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDo {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = true)
    Long id;
    @Column
    String title;
    @Column
    String description;
    @Column
    TodoStatus todoStatus;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;
    @UpdateTimestamp
    Timestamp lastModified;
}
