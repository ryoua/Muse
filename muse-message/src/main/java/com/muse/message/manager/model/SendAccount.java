package com.muse.message.manager.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "c_send_account")
public class SendAccount extends Base {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long sendAccountId;

    @Column(length = 128)
    private String name;


}
