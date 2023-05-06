package com.cy.soul.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    public static <T> void JSONWriteUtil(String filePath, T t)  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // 将 Java 对象转换为 JSON 格式的字符串
            String json = mapper.writeValueAsString(t);
            Files.write(Paths.get(filePath), json.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static <T> T JSONReadUtil(String filePath, T cls) throws Exception {
        // 读取文件中的 JSON 数据
        byte[] fileData = Files.readAllBytes(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        Object o = objectMapper.readValue(fileData, cls.getClass());
        return (T) o;
    }
}
