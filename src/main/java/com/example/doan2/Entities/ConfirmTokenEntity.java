package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="confirm_token",schema = "doan2")
public class ConfirmTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Integer tokenId;
    @Column(name = "confirm_token")
    private String confirmToken;
    @Column(name = "confirm_date")
    private Date confirmDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;
    public ConfirmTokenEntity() {
    }

    public ConfirmTokenEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        confirmDate = new Date();
        confirmToken = UUID.randomUUID().toString();
    }

}
