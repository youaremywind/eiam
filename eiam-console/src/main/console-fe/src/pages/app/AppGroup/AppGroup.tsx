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
import { PlusOutlined, QuestionCircleOutlined } from '@ant-design/icons';
import type { ActionType, ProColumns } from '@ant-design/pro-components';
import { PageContainer, ProTable } from '@ant-design/pro-components';
import { App, Button, Popconfirm, Tag } from 'antd';
import { useRef, useState } from 'react';
import CreateModal from './components/CreateModal';
import UpdateModal from './components/UpdateModal';
import { createAppGroup, removeAppGroup, updateAppGroup } from './service';
import { useIntl } from '@@/exports';
import { getAppGroupList } from '@/services/app';

export default () => {
  const intl = useIntl();
  const actionRef = useRef<ActionType>();
  const [createModalOpen, setCreateModalOpen] = useState<boolean>(false);
  const [updateModalOpen, setUpdateModalOpen] = useState<boolean>(false);
  const [id, setId] = useState<string>();
  const { message } = App.useApp();
  const columns: ProColumns<AppAPI.AppGroupList>[] = [
    {
      title: intl.formatMessage({ id: 'pages.app_group.list.column.name' }),
      dataIndex: 'name',
      fixed: 'left',
    },
    {
      title: intl.formatMessage({ id: 'pages.app_group.list.column.code' }),
      dataIndex: 'code',
    },
    {
      title: intl.formatMessage({ id: 'pages.app_group.list.column.app_count' }),
      dataIndex: 'appCount',
      search: false,
    },
    {
      title: intl.formatMessage({ id: 'pages.app_group.list.column.type' }),
      dataIndex: 'type',
      valueEnum: {
        default: {
          text: intl.formatMessage({
            id: 'pages.app_group.list.column.type.default',
          }),
        },
        custom: {
          text: intl.formatMessage({
            id: 'pages.app_group.list.column.type.custom',
          }),
        },
      },
      render: (_, record) => (
        <>
          {record.type === 'custom' && (
            <Tag color={'#108ee9'} key={'custom'}>
              {intl.formatMessage({
                id: 'pages.app_group.list.column.type.custom',
              })}
            </Tag>
          )}
          {record.type === 'default' && (
            <Tag color={'#2db7f5'} key={'default'}>
              {intl.formatMessage({
                id: 'pages.app_group.list.column.type.default',
              })}
            </Tag>
          )}
        </>
      ),
    },
    {
      title: intl.formatMessage({ id: 'pages.app_group.list.column.create_time' }),
      dataIndex: 'createTime',
      search: false,
      align: 'center',
      ellipsis: true,
    },
    {
      title: intl.formatMessage({ id: 'pages.app_group.list.column.remark' }),
      dataIndex: 'remark',
      search: false,
      ellipsis: true,
    },
    {
      title: intl.formatMessage({ id: 'pages.app_group.list.column.option' }),
      valueType: 'option',
      key: 'option',
      width: 100,
      align: 'center',
      render: (text, record) => [
        <a
          key="editable"
          onClick={() => {
            setId(record.id);
            setUpdateModalOpen(true);
          }}
        >
          {intl.formatMessage({ id: 'app.update' })}
        </a>,
        <Popconfirm
          title={intl.formatMessage({
            id: 'pages.app_group.list.actions.popconfirm.delete',
          })}
          placement="bottomRight"
          icon={
            <QuestionCircleOutlined
              style={{
                color: 'red',
              }}
            />
          }
          onConfirm={async () => {
            const { success } = await removeAppGroup(record.id);
            if (success) {
              message.success(intl.formatMessage({ id: 'app.operation_success' }));
              actionRef.current?.reload();
              return;
            }
          }}
          okText={intl.formatMessage({ id: 'app.yes' })}
          cancelText={intl.formatMessage({ id: 'app.no' })}
          key="delete"
        >
          <a target="_blank" key="remove" style={{ color: 'red' }}>
            {intl.formatMessage({ id: 'app.delete' })}
          </a>
        </Popconfirm>,
      ],
    },
  ];

  return (
    <PageContainer>
      <ProTable<AppAPI.AppGroupList>
        columns={columns}
        actionRef={actionRef}
        request={getAppGroupList}
        rowKey="id"
        search={{
          labelWidth: 'auto',
        }}
        scroll={{ x: 900 }}
        form={{
          syncToUrl: (values, type) => {
            if (type === 'get') {
              return {
                ...values,
              };
            }
            return values;
          },
        }}
        pagination={{
          pageSize: 5,
        }}
        dateFormatter="string"
        toolBarRender={() => [
          <Button
            key="button"
            icon={<PlusOutlined />}
            onClick={() => {
              setCreateModalOpen(true);
            }}
            type="primary"
          >
            {intl.formatMessage({ id: 'pages.app_group.list.create' })}
          </Button>,
        ]}
      />
      <CreateModal
        open={createModalOpen}
        onCancel={() => {
          setCreateModalOpen(false);
        }}
        onFinish={async (values) => {
          const { result, success } = await createAppGroup(values);
          if (success && result) {
            message.success(intl.formatMessage({ id: 'app.create_success' }));
            actionRef.current?.reload();
          }
          actionRef.current?.reload();
          setCreateModalOpen(false);
          return true;
        }}
      />
      {id && (
        <UpdateModal
          open={updateModalOpen}
          id={id}
          onCancel={() => {
            setUpdateModalOpen(false);
          }}
          onFinish={async (values) => {
            const { result, success } = await updateAppGroup(values);
            if (success && result) {
              message.success(intl.formatMessage({ id: 'app.create_success' }));
              actionRef.current?.reload();
            }
            actionRef.current?.reload();
            setUpdateModalOpen(false);
            return true;
          }}
        />
      )}
    </PageContainer>
  );
};
