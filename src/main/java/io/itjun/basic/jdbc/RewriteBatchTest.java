package io.itjun.basic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 生成测试数据表：
 * CREATE TABLE test_batch (
 *     id INT AUTO_INCREMENT PRIMARY KEY,
 *     col1 VARCHAR(100),
 *     col2 INT
 * );
 */
public class RewriteBatchTest {

    public static void main(String[] args) throws SQLException {
        // 测试对比：切换这个参数 true/false
        boolean enableRewrite = false;

        String host = "localhost:3306/test"; // 修改为你的主机和数据库名
        String timezone = "Asia/Shanghai";

        String jdbcUrl = String.format(
                "jdbc:mysql://%s?useSSL=false&autoReconnect=true&autoCommit=false&useUnicode=true&characterEncoding=utf8&serverTimezone=%s&zeroDateTimeBehavior=CONVERT_TO_NULL%s",
                host, timezone, enableRewrite ? "&rewriteBatchedStatements=true" : "");

        String username = "root";
        String password = "root";

        int totalRows = 50_0000;
        int batchSize = 1000;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO test_batch (col1, col2) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                long start = System.currentTimeMillis();

                for (int i = 1; i <= totalRows; i++) {
                    ps.setString(1, "value_" + i);
                    ps.setInt(2, i);
                    ps.addBatch();

                    if (i % batchSize == 0) {
                        ps.executeBatch();
                        conn.commit();
                        ps.clearBatch();
                    }
                }

                // 剩余未满的批
                ps.executeBatch();
                conn.commit();

                long end = System.currentTimeMillis();
                System.out.printf("插入 %d 条数据，rewriteBatchedStatements=%s，耗时：%d ms%n", totalRows, enableRewrite,
                        (end - start));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
