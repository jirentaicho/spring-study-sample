package com.volkruss.misaka.domain.model.user;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @Column(name = "name")
    private String username;

    @Column(name = "password")
    private String password;

}
