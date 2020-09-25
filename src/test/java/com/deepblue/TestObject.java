package com.deepblue;

import lombok.*;

public class TestObject {

    public static void main(String[] args) {
        UserLoginInfoResultDTO result = UserLoginInfoResultDTO.builder().build();
    }



    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserLoginInfoResultDTO {

        /** 用户Yid */
        private Long userYid;

        /** 用户Ytid */
        private Long userYtid;

        /** 用户昵称 */
        private String nickName;

        /** 用户性别 0:男 1:女 */
        private Integer gender;

        /**生日 例如 2020-09-18 */
        private String birthday;

        /** 头像链接 必填 */
        private String faceUrl;

        /** 邀请码 非必填 */
        private String invitationCode;

        /** 是否渲染 */
        private Boolean flag;

    }

}
