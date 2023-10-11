/*
 * eiam-console - Employee Identity and Access Management
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
package cn.topiam.employee.console.pojo.result.account;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import static cn.topiam.employee.support.constant.EiamConstants.DEFAULT_DATE_TIME_FORMATTER_PATTERN;

/**
 * 用户分页查询结果
 *
 * @author TopIAM
 * Created by support@topiam.cn on 2020/8/11 23:08
 */
@Data
@Accessors(chain = true)
@Schema(description = "分页查询用户响应")
public class UserListResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 3320953184046791392L;
    /**
     * 用户ID
     */
    @Parameter(description = "用户ID")
    private String            id;

    /**
     * 用户名
     */
    @Parameter(description = "用户名")
    private String            username;

    /**
     * 姓名
     */
    @Parameter(description = "姓名")
    private String            fullName;

    /**
     * 邮箱
     */
    @Parameter(description = "邮箱")
    private String            email;

    /**
     * 手机号
     */
    @Parameter(description = "手机号")
    private String            phone;

    /**
     * 头像URL
     */
    @Parameter(description = "头像URL")
    private String            avatar;

    /**
     * 状态
     */
    @Parameter(description = "状态")
    private String            status;

    /**
     * 邮箱验证有效
     */
    @Parameter(description = "邮箱验证")
    private Boolean           emailVerified;

    /**
     * 手机验证
     */
    @Parameter(description = "手机验证")
    private Boolean           phoneVerified;

    /**
     * 认证次数
     */
    @Parameter(description = "认证次数")
    private Long              authTotal;
    /**
     * 数据来源
     */

    @Parameter(description = "数据来源")
    private String            dataOrigin;

    /**
     * 上次认证时间
     */
    @JsonFormat(pattern = DEFAULT_DATE_TIME_FORMATTER_PATTERN)
    @Parameter(description = "上次认证时间")
    private LocalDateTime     lastAuthTime;

    /**
     * 从组织机构目录
     */
    @Parameter(description = "从组织机构目录")
    private String            orgDisplayPath;

    /**
     * 主组织目录
     */
    @Parameter(description = "主组织机构目录")
    private String            primaryOrgDisplayPath;

    /**
     * 最后修改密码时间
     */
    @Parameter(description = "最后修改密码时间")
    private LocalDateTime     lastUpdatePasswordTime;
}
