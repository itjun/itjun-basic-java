package io.itjun.basic.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MongoConfig {

    private static volatile MongoClient client;
    private static final String hosts = "127.0.0.1:27017";
    private static final String username = "root";
    private static final String password = "root";
    private static final String maxPoolSize = "100";// 单客户端默认最大100个连接
    private static final String databaseName = "mongodb";

    /**
     * 不同数据库的客户端
     */
    private static MongoClient getClient() {
        if (client != null)
            return client;

        synchronized (MongoConfig.class) {
            if (client == null) {
                StringBuilder builder = new StringBuilder();
                builder.append("mongodb://")
                        .append(username)
                        .append(":")
                        .append(password)
                        .append("@")
                        .append(hosts)
                        .append("/");

                // 是否启用集群模式
                builder.append("?").append("maxPoolSize=").append(maxPoolSize);
                builder.append("&").append("connectTimeoutMS=").append("3000");
                builder.append("&").append("serverSelectionTimeoutMS=").append("3000");
                log.info("Connect to the MongoDB sharded cluster {}", builder);

                ConnectionString connection = new ConnectionString(builder.toString());
                client = MongoClients.create(connection);
            }
        }
        return client;
    }

    /**
     * 获取默认的数据库名称 databaseName
     */
    public static MongoDatabase getDatabase() {
        return MongoConfig.getClient().getDatabase(databaseName);
    }

}