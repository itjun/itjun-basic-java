package io.itjun.basic.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SqlMetaDataExample {

    /**
     * 元数据集合
     **/
    DatabaseMetaData databaseMetaData;
    /**
     * 数据库连接
     **/
    private Connection conn;

    public SqlMetaDataExample() {
        try {
            String url = "io.itjun.examples.jdbc:mysql://host?:port?/database?";
            String user = "user?";
            String pass = "password?";
            Class.forName("com.mysql.io.itjun.examples.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            databaseMetaData = conn.getMetaData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        SqlMetaDataExample obj = new SqlMetaDataExample();
        obj.showTables();
    }

    /**
     * 获取所有的数据库表信息
     *
     * @throws SQLException
     */
    public void showTables() throws SQLException {
        String[] types = {"TABLE"};
        ResultSet resultSet = databaseMetaData.getTables(null, null, null, types);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("TABLE_NAME"));
        }
    }

    /**
     * 获取数据表列的元数据
     *
     * @throws SQLException
     */
    public void showgetColumns() throws SQLException {
        ResultSet resultSet = databaseMetaData.getColumns(null, "%", "supinfo", "%");
        while (resultSet.next()) {
            /** 列名 **/
            System.out.println(resultSet.getString("COLUMN_NAME"));

            /** 数据类型 **/
            System.out.println(resultSet.getString("TYPE_NAME"));

            /** 数据范围 **/
            System.out.println(resultSet.getString("COLUMN_SIZE"));

            /** 是否为空 **/
            System.out.println(resultSet.getString("NULLABLE"));

            /** 列备注 **/
            System.out.println(resultSet.getString("REMARKS"));

            System.out.println("-----------------------------");
        }
    }

    /**
     * 获取列的详细信息
     *
     * @throws SQLException
     */
    public void showColumnCount() throws SQLException {
        String sql = "select * from cusinfo limit 1";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        // 获得所有列的数目及实际列数
        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println(columnCount);

        while (resultSet.next()) {
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                // 获得指定列的列名
                String columnName = resultSetMetaData.getColumnName(i);
                System.out.println(String.format("第 %d 列 %s", i, columnName));
                System.out.println("字段名称:" + columnName);

                // 获得指定列的列值
                String columnValue = resultSet.getString(i);
                System.out.println("字段值:" + columnValue);

                // 获得指定列的数据类型
                int columnType = resultSetMetaData.getColumnType(i);
                System.out.println("类型,返回SqlType中的编号:" + columnType);

                // 获得指定列的数据类型名
                String columnTypeName = resultSetMetaData.getColumnTypeName(i);
                System.out.println("数据类型名:" + columnTypeName);

                // 所在的Catalog名字
                String catalogName = resultSetMetaData.getCatalogName(i);
                System.out.println("所在的Catalog名字:" + catalogName);

                // 对应数据类型的类
                String columnClassName = resultSetMetaData.getColumnClassName(i);
                System.out.println("对应数据类型的类:" + columnClassName);

                // 在数据库中类型的最大字符个数
                int columnDisplaySize = resultSetMetaData.getColumnDisplaySize(i);
                System.out.println("在数据库中类型的最大字符个数:" + columnDisplaySize);

                // 默认的列的标题
                String columnLabel = resultSetMetaData.getColumnLabel(i);
                System.out.println("默认的列的标题:" + columnLabel);

                // 获得列的模式
                String schemaName = resultSetMetaData.getSchemaName(i);
                System.out.println("模式:" + schemaName);

                // 某列类型的精确度(类型的长度)
                int precision = resultSetMetaData.getPrecision(i);
                System.out.println("类型的精确度(类型的长度):" + precision);

                // 小数点后的位数
                int scale = resultSetMetaData.getScale(i);
                System.out.println("小数点后的位数:" + scale);

                // 获取某列对应的表名
                String tableName = resultSetMetaData.getTableName(i);
                System.out.println("对应的表名:" + tableName);

                // 是否自动递增
                boolean isAutoInctement = resultSetMetaData.isAutoIncrement(i);
                System.out.println("是否自动递增:" + isAutoInctement);

                // 在数据库中是否为货币型
                boolean isCurrency = resultSetMetaData.isCurrency(i);
                System.out.println("在数据库中是否为货币型:" + isCurrency);

                // 是否为空
                int isNullable = resultSetMetaData.isNullable(i);
                System.out.println("是否为空:" + isNullable);

                // 是否为只读
                boolean isReadOnly = resultSetMetaData.isReadOnly(i);
                System.out.println("是否为只读:" + isReadOnly);

                // 能否出现在where中
                boolean isSearchable = resultSetMetaData.isSearchable(i);
                System.out.println("能否出现在where中:" + isSearchable);

                System.out.println("-----------------------------");
            }
        }
    }

    /**
     * 获取数据库索引信息
     *
     * @throws SQLException
     */
    public void showIndexInfo() throws SQLException {
        ResultSet resultSet = databaseMetaData.getIndexInfo(null, null, "workplan", false, true);
        while (resultSet.next()) {
            // 获取索引类型
            short type = resultSet.getShort("TYPE");
            String type_name = "tableIndexOther";
            switch (type) {
                case DatabaseMetaData.tableIndexStatistic:
                    type_name = "Statistic";
                    break;
                case DatabaseMetaData.tableIndexClustered:
                    type_name = "Clustered";
                    break;
                case DatabaseMetaData.tableIndexHashed:
                    type_name = "Hashed";
                    break;
                default:
                    type_name = "Other";
                    break;
            }

            // 获取索引名
            String index_name = resultSet.getString("INDEX_NAME");

            String strn = "index_name:" + index_name + " " + "type:" + type_name;
            System.out.println(strn);

            System.out.println("列名称：" + resultSet.getString("COLUMN_NAME"));

            /** “A”=>升序，“D”=>降序 **/
            System.out.println("排序：" + resultSet.getString("ASC_OR_DESC"));

            System.out.println("-----------------------------");
        }
    }

    /**
     * 获取表导入的外键
     *
     * @throws SQLException
     */
    public void showImportedKeys() throws SQLException {
        ResultSet resultSet = databaseMetaData.getImportedKeys(null, null, "supinfo");
        while (resultSet.next()) {
            /** 外键约束名称 **/
            System.out.println(resultSet.getString("FK_NAME"));

            /** 引用列名 **/
            System.out.println(resultSet.getString("FKCOLUMN_NAME"));

            /** 引用表名 **/
            System.out.println(resultSet.getString("FKTABLE_NAME"));

            /** 主键数据库 **/
            System.out.println(resultSet.getString("PKTABLE_CAT"));

            /** 主键表名称 **/
            System.out.println(resultSet.getString("PKTABLE_NAME"));

            /** 主键列名称 **/
            System.out.println(resultSet.getString("PKCOLUMN_NAME"));

            /** 更新规则 **/
            short update = resultSet.getShort("UPDATE_RULE");
            String update_action = "SetDefault";
            switch (update) {
                case DatabaseMetaData.importedKeyCascade:
                    update_action = "Cascade";
                    break;
                case DatabaseMetaData.importedKeyRestrict:
                    update_action = "Restrict";
                    break;
                case DatabaseMetaData.importedKeySetNull:
                    update_action = "SetNull";
                    break;
                case DatabaseMetaData.importedKeyNoAction:
                    update_action = "NoAction";
                    break;
                default:
                    update_action = "SetDefault";
                    break;
            }
            System.out.println(update_action);

            /** 删除规则 **/
            short delete = resultSet.getShort("DELETE_RULE");
            String delete_action = "SetDefault";
            switch (delete) {
                case DatabaseMetaData.importedKeyCascade:
                    delete_action = "Cascade";
                    break;
                case DatabaseMetaData.importedKeyRestrict:
                    delete_action = "Restrict";
                    break;
                case DatabaseMetaData.importedKeySetNull:
                    delete_action = "SetNull";
                    break;
                case DatabaseMetaData.importedKeyNoAction:
                    delete_action = "NoAction";
                    break;
                default:
                    delete_action = "SetDefault";
                    break;
            }
            System.out.println(delete_action);

            System.out.println("-----------------------------");
        }
    }

    /**
     * 获取数据表主键信息
     *
     * @throws SQLException
     */
    public void showPrimaryKeys() throws SQLException {
        ResultSet resultSet = databaseMetaData.getPrimaryKeys(null, null, "supinfo");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("COLUMN_NAME"));
            System.out.println(resultSet.getString("KEY_SEQ"));
            System.out.println(resultSet.getString("PK_NAME"));
            System.out.println("-----------------------------");
        }
    }

}