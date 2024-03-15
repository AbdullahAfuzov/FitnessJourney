package org.example.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false, unique = false)
    private String firstName;

    @Column(length = 15, nullable = false, unique = false)
    private String secondName;

    @Column(length = 15, nullable = false, unique = false)
    private String lastName;

    @Column(length = 30, nullable = false, unique = false)
    private String email;

    @Column(length = 15, nullable = false, unique = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_info_id")
    private UserInfoModel userInfoModel;
}
