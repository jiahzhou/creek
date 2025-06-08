package org.example.creek.controller.sync;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

import org.example.creek.common.constants.Constants;
import org.example.creek.common.util.DateUtil;
import org.example.creek.model.SyncIpRequest;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
public class SyncIpService {

    @SneakyThrows
    public String syncIp(SyncIpRequest request) {

        Path filePath = Paths.get(System.getProperty("user.home"), "Web", "app_data_creek", "ip_record.txt");

        Files.createDirectories(filePath.getParent());

        File file = filePath.toFile();

        if (!file.exists() && !file.createNewFile()) {
            return "create file failed";
        }

        try (PrintWriter writer =
            new PrintWriter(Files.newBufferedWriter(filePath, StandardOpenOption.WRITE, StandardOpenOption.APPEND))) {
            writer.println(buildRecord(request)); // 自动添加换行符
        }

        return "done";
    }

    private String buildRecord(SyncIpRequest request) {
        return new StringJoiner(Constants.COMMA).add(request.getIp())
            .add(request.getName())
            .add(formatDataTime(request.getTimestamp()))
            .toString();
    }

    private String formatDataTime(Long timestamp) {
        if (timestamp == null)
            return Constants.EMPTY;
        return Instant.ofEpochMilli(timestamp)
            .atZone(ZoneId.of(Constants.ZONE_ID_SHANGHAI))
            .toLocalDateTime()
            .format(DateTimeFormatter.ofPattern(DateUtil.YYYY_MM_DD_HH_MM));
    }
}
