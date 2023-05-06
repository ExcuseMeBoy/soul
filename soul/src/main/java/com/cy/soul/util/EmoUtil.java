package com.cy.soul.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class EmoUtil {

    public static void emoStartUtil() {
        // 随机生成一个点
        BigDecimal x = BigDecimal.valueOf(Math.random()); // x坐标范围为[0, 1)
        BigDecimal y = BigDecimal.valueOf(Math.random()); // y坐标范围为[0, 1)

        // 根据随机数生成点的坐标
        BigDecimal pointX = BigDecimal.valueOf(Math.sqrt(x.doubleValue()));
        BigDecimal pointY = BigDecimal.valueOf(Math.sqrt(y.doubleValue()));

        // 计算该点到正方形四个顶点的距离
        BigDecimal topLeftX = BigDecimal.ZERO;
        BigDecimal topLeftY = BigDecimal.ZERO;
        BigDecimal topRightX = BigDecimal.ONE;
        BigDecimal topRightY = BigDecimal.ZERO;
        BigDecimal bottomLeftX = BigDecimal.ZERO;
        BigDecimal bottomLeftY = BigDecimal.ONE;
        BigDecimal bottomRightX = BigDecimal.ONE;
        BigDecimal bottomRightY = BigDecimal.ONE;

        BigDecimal distanceToTopLeft = distance(pointX, pointY, topLeftX, topLeftY);
        BigDecimal distanceToTopRight = distance(pointX, pointY, topRightX, topRightY);
        BigDecimal distanceToBottomLeft = distance(pointX, pointY, bottomLeftX, bottomLeftY);
        BigDecimal distanceToBottomRight = distance(pointX, pointY, bottomRightX, bottomRightY);

        // 检查距离是否大于1
        if (distanceToTopLeft.compareTo(BigDecimal.ONE) <= 0 && distanceToTopRight.compareTo(BigDecimal.ONE) <= 0
                && distanceToBottomLeft.compareTo(BigDecimal.ONE) <= 0 && distanceToBottomRight.compareTo(BigDecimal.ONE) <= 0) {
            // 输出结果
            System.out.println("随机点坐标为 (" + pointX.setScale(2, BigDecimal.ROUND_HALF_UP) + ", "
                    + pointY.setScale(2, BigDecimal.ROUND_HALF_UP) + ")");
            System.out.println("到正方形四个顶点的距离分别为:");
            System.out.println("左上角: " + distanceToTopLeft.setScale(2, BigDecimal.ROUND_HALF_UP));
            System.out.println("右上角: " + distanceToTopRight.setScale(2, BigDecimal.ROUND_HALF_UP));
            System.out.println("左下角: " + distanceToBottomLeft.setScale(2, BigDecimal.ROUND_HALF_UP));
            System.out.println("右下角: " + distanceToBottomRight.setScale(2, BigDecimal.ROUND_HALF_UP));
        } else {
            emoStartUtil();
        }
    }

    // 计算两点之间的距离
    public static BigDecimal distance(BigDecimal x1, BigDecimal y1, BigDecimal x2, BigDecimal y2) {
        BigDecimal deltaX = x1.subtract(x2);
        BigDecimal deltaY = y1.subtract(y2);
        return BigDecimal.valueOf(Math.sqrt(deltaX.doubleValue() * deltaX.doubleValue()
                + deltaY.doubleValue() * deltaY.doubleValue()));
    }


    public static <T> void JSONWriteUtil(String filePath, T t) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // 将 Java 对象转换为 JSON 格式的字符串
        String json = mapper.writeValueAsString(t);
        Files.write(Paths.get(filePath), json.getBytes());


    }


    public static <T> T JSONReadUtil(String filePath, T cls) throws Exception {
        // 读取文件中的 JSON 数据
        byte[] fileData = Files.readAllBytes(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        Object o = objectMapper.readValue(fileData, cls.getClass());
        return (T) o;
    }

    public static void main(String[] args) throws Exception {

        random();
    }


    /**
     * 0.1-1随机保留2位小数
     *
     * @return
     */
    public static BigDecimal random() {
        Random random = new Random();
        BigDecimal randNum = new BigDecimal(random.nextDouble() * 0.9 + 0.1)
                .setScale(2, RoundingMode.HALF_UP);
        return randNum;
    }




    /**
     * @param x
     * @param y
     * @param arg
     */
    public static void changeEmo(BigDecimal x, BigDecimal y, String arg) {
        switch (arg) {
            case "top-left":
                moveToPoint(x, y, new BigDecimal("0"), new BigDecimal("1"), new BigDecimal("0.1"));
                break;
            case "top-right":
                moveToPoint(x, y, new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("0.1"));
                break;
            case "bottom-left":
                moveToPoint(x, y, new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0.1"));
                break;
            case "bottom-right":
                moveToPoint(x, y, new BigDecimal("1"), new BigDecimal("0"), new BigDecimal("0.1"));
                break;
            case "center":
                moveToPoint(x, y, new BigDecimal("0.5"), new BigDecimal("0.5"), new BigDecimal("0.1"));
                break;
            default:
                break;
        }
    }

    public static void moveToPoint(BigDecimal x, BigDecimal y, BigDecimal targetX, BigDecimal targetY, BigDecimal step) {
        while (x.compareTo(targetX) != 0 || y.compareTo(targetY) != 0) {
            if (x.compareTo(targetX) < 0) {
                x = x.add(step).min(targetX);
            } else if (x.compareTo(targetX) > 0) {
                x = x.subtract(step).max(targetX);
            }
            if (y.compareTo(targetY) < 0) {
                y = y.add(step).min(targetY);
            } else if (y.compareTo(targetY) > 0) {
                y = y.subtract(step).max(targetY);
            }
            System.out.println("点的坐标为：" + x.setScale(2, BigDecimal.ROUND_HALF_UP) + ", " + y.setScale(2, BigDecimal.ROUND_HALF_UP));
        }
    }


    public void calculateEmo(BigDecimal x, BigDecimal y) {
        // 计算到各个顶点的距离
        BigDecimal d1 = distance(x, y, BigDecimal.ZERO, BigDecimal.ZERO);
        BigDecimal d2 = distance(x, y, BigDecimal.ONE, BigDecimal.ZERO);
        BigDecimal d3 = distance(x, y, BigDecimal.ZERO, BigDecimal.ONE);
        BigDecimal d4 = distance(x, y, BigDecimal.ONE, BigDecimal.ONE);

        // 找到距离最小的顶点
        BigDecimal minDistance = BigDecimal.ZERO;
        String nearestVertex = "";
        if (d1.compareTo(minDistance) <= 0 || minDistance.compareTo(BigDecimal.ZERO) == 0) {
            if (d1.compareTo(minDistance) < 0 || nearestVertex.isEmpty()) {
                minDistance = d1;
                nearestVertex = "a";
            } else if (Math.random() < 0.5) {
                nearestVertex = "a";
            }
        }
        if (d2.compareTo(minDistance) <= 0 || minDistance.compareTo(BigDecimal.ZERO) == 0) {
            if (d2.compareTo(minDistance) < 0 || nearestVertex.isEmpty()) {
                minDistance = d2;
                nearestVertex = "b";
            } else if (Math.random() < 0.5) {
                nearestVertex = "b";
            }
        }
        if (d3.compareTo(minDistance) <= 0 || minDistance.compareTo(BigDecimal.ZERO) == 0) {
            if (d3.compareTo(minDistance) < 0 || nearestVertex.isEmpty()) {
                minDistance = d3;
                nearestVertex = "c";
            } else if (Math.random() < 0.5) {
                nearestVertex = "c";
            }
        }
        if (d4.compareTo(minDistance) <= 0 || minDistance.compareTo(BigDecimal.ZERO) == 0) {
            if (d4.compareTo(minDistance) < 0 || nearestVertex.isEmpty()) {
                minDistance = d4;
                nearestVertex = "d";
            } else if (Math.random() < 0.5) {
                nearestVertex = "d";
            }
        }

        // 输出结果
        System.out.println("随机点坐标为：(" + x.setScale(2, RoundingMode.HALF_UP) + ", " + y.setScale(2, RoundingMode.HALF_UP) + ")");
        System.out.println("距离最近的顶点为：" + nearestVertex);
        System.out.println("到中心点的距离为：" + distance(x, y, BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.5)).setScale(2, RoundingMode.HALF_UP));


    }
}
