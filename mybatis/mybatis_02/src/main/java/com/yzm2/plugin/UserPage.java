package com.yzm2.plugin;

import com.yzm2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserPage implements Serializable {
    private static final long serialVersionUID = 2062504472352642553L;

    private Integer id;
    private String username;
    private String realName;
    private String password;
    private String gender;
    private String remark;
    private Boolean state;
    private Boolean deleted;
    private Date updateDate;
    private String createDate;

    private Page<User> page = new Page<>();
}
