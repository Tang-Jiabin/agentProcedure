package cn.xykoo.agent.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "yiku_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;

    private String photo;

    private String phone;

    private String nickname;

    private Integer gender;

    private String token;

    private Integer isShare;

    private Date creatTime;

    private Date updateTime;

    private String pushId;

    private int newUser;

    private String wxUnionid;

    private String wxOpenid;

    private String qqOpenid;

    private String channel;

    private Integer schoolId;
}