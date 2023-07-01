package com.hls.internalcommon.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String userPhone;

    private String userName;

    private byte userGender;

    private byte state;

    private String profilePhoto;
}
