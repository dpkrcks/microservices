package com.dpkrcks.user.service.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="user_id")
    private String userId;
    private String name;
    private String email;
    private String about;


    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
