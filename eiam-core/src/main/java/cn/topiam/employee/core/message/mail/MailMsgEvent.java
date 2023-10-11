/*
 * eiam-core - Employee Identity and Access Management
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
package cn.topiam.employee.core.message.mail;

import java.util.Map;

import org.springframework.context.ApplicationEvent;

import cn.topiam.employee.common.enums.MailType;

import lombok.Getter;

/**
 * 消息事件
 *
 * @author TopIAM
 * Created by support@topiam.cn on  2021/9/25 21:07
 */
@Getter
public class MailMsgEvent extends ApplicationEvent {
    /**
     * 消息类型
     */
    private final MailType            type;
    /**
     * 接收人
     */
    private final String              receiver;
    /**
     * 参数
     */
    private final Map<String, Object> parameter;

    public MailMsgEvent(MailType type, String receiver, Map<String, Object> parameter) {
        super(type);
        this.type = type;
        this.receiver = receiver;
        this.parameter = parameter;
    }
}
