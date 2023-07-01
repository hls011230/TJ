package com.hls.internalcommon.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class RiderWorkStatus implements Serializable {
    private Long id;

    private Long riderId;

    /**
     * 休息：0；接单：1，暂停：2
     */
    private Integer workStatus;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;
}
