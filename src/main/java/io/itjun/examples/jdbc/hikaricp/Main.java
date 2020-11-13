package io.itjun.examples.jdbc.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 HikariCP 连接池
 * <p>
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1321748528103458
 */
public class Main {

    static final String jdbcUrl = "jdbc:mysql://127.0.0.1/learnjdbc?useSSL=false&characterEncoding=utf8";
    static final String jdbcUsername = "root";
    static final String jdbcPassword = "root";

    public static void main(String[] args) throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(jdbcUsername);
        config.setPassword(jdbcPassword);
        config.addDataSourceProperty("cachePrepStmts", "true");
        // 连接池大小默认25，官方推荐250-500
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        // 最大连接数
        config.addDataSourceProperty("maximumPoolSize", "25");
        DataSource dataSource = new HikariDataSource(config);

        List<Student> students = queryStudents(dataSource);
        students.forEach(System.out::println);
    }

    static List<Student> queryStudents(DataSource dataSource) throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) { // 在此获取连接
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                ps.setInt(1, 3); // 第一个参数grade=?
                ps.setInt(2, 90); // 第二个参数score=?
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        } // 在此“释放”连接
        return students;
    }

    static Student extractRow(ResultSet rs) throws SQLException {
        var std = new Student();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getBoolean("gender"));
        std.setGrade(rs.getInt("grade"));
        std.setScore(rs.getInt("score"));
        return std;
    }
}
