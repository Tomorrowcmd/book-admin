# 1. 使用轻量级 JDK 17 环境（根据你 jar 包的 JDK 版本调整，如 openjdk:8-jdk-alpine）
FROM openjdk:17-jdk-alpine

# 2. 设置容器内的工作目录
WORKDIR /app

# 3. 将当前目录下的 app.jar 复制到容器内
COPY app.jar app.jar

# 4. 暴露后端端口
EXPOSE 9080

# 5. 启动 Java 程序
ENTRYPOINT ["java", "-jar", "app.jar"]