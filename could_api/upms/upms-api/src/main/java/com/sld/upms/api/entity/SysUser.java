package com.sld.upms.api.entity;


//import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author admin
 * @Title: SysUser
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/1910:06
 */
@Data
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
    private  static final Long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "com.sld.commoncore.uid.UidGenerator")
    private String userId;
    private String userNo;
    private String userName;
//    @JsonIgnore
    private String password;
//    @JsonIgnore
    private String salt;
    private String phone;
    private String avatar;
    private String orgId;
    private String email;
    private String description;
    private String sex;
    private LocalDateTime birthday;
    private String idcard;
    private LocalDateTime authStartDate;
    private LocalDateTime authEndDate;
    private String addressCurrent;
    private String addressHome;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String lockFlag;
    private String delFlag;
}
