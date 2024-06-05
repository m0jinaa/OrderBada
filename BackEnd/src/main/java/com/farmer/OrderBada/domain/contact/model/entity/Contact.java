package com.farmer.OrderBada.domain.contact.model.entity;

import com.farmer.OrderBada.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
    @GeneratedValue
    @Id
    private Long contactId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String nickname;

    private String name;

    private String phoneNumber1;

    private String phoneNumber2;

    private String address;

    private String addressDetail;

}
