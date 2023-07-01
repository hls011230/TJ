package com.hls.internalcommon.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Rider implements Serializable {
    private Long id;

    /**
     * 骑手注册地行政区划代码
     */
    private String address;

    /**
     * 骑手姓名
     */
    private String riderName;

    /**
     * 骑手电话
     */
    private String riderPhone;

    /**
     * 1:男，2：女
     */
    private Integer riderGender;

    private LocalDate riderBirthday;

    /**
     * 报备日期
     */
    private LocalDate registerDate;

    /**
     * 骑手状态：0：有效，1：失效
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

}
