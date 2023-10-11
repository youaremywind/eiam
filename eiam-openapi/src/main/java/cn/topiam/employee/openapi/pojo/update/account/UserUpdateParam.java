/*
 * eiam-openapi - Employee Identity and Access Management
 * Copyright © 2022-Present Jinan Yuanchuang Network Technology Co., Ltd. (support@topiam.cn)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cn.topiam.employee.openapi.pojo.update.account;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import cn.topiam.employee.common.enums.UserStatus;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * 编辑用户入参
 *
 * @author TopIAM
 * Created by support@topiam.cn on 2020/8/11 23:16
 */
@Data
@Schema(description = "修改用户入参")
public class UserUpdateParam implements Serializable {
    @Serial
    private static final long serialVersionUID = -6616249172773611157L;
    /**
     * ID
     */
    @Schema(description = "用户ID")
    @NotBlank(message = "用户ID不能为空")
    private String            id;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String            email;

    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String            phone;

    /**
     * 头像URL
     */
    @Schema(description = "头像URL")
    private String            avatar;

    /**
     * 姓名
     */
    @Schema(description = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String            fullName;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String            nickName;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号")
    private String            idCard;

    /**
     * 地址
     */
    @Schema(description = "地址")
    private String            address;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String            remark;

    /**
     * 过期日期
     */
    @Schema(description = "过期日期")
    private LocalDate         expireDate;

    /**
     * status
     */
    @Schema(description = "状态")
    private UserStatus        status;
}
