package TOYUXTEAM.BOOKSTORE.domain.diary.model;


import TOYUXTEAM.BOOKSTORE.domain.user.model.User;

import javax.persistence.*;

@Entity
public class Diary {

    @Id
    @GeneratedValue
    private Long Diary_id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String month;

    @Column
    private String day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
