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
import { request } from '@@/exports';
import {
  GetApp,
} from './data.d';

/**
 * Get Application
 */
export async function getApp(id: string): Promise<API.ApiResult<GetApp>> {
  return request<API.ApiResult<GetApp>>(`/api/v1/app/get/${id}`, {
    method: 'GET',
  });
}

