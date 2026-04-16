plugins {
    id("java")
    // Spring Boot 核心插件
    id("org.springframework.boot") version "3.5.13"
    // 自动管理依赖版本，确保兼容性
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.apple"
version = "1.0-SNAPSHOT"

java {
    // 明确指定使用 Java 17
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // --- Web 核心 ---
    implementation("org.springframework.boot:spring-boot-starter-web")

    // --- 常用增强 ---
    // 参数校验 (JSR-303)
    implementation("org.springframework.boot:spring-boot-starter-validation")
    // 监控检查与指标公开
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // --- 工具类 ---
    // Lombok (减少冗余代码)
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    // --- 数据库核心 ---
    // MySQL 驱动
    runtimeOnly("com.mysql:mysql-connector-j")
    // 数据源连接池 (Spring Boot 3 默认推荐使用 HikariCP，已内置在 starter-jdbc 中)
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    // --- MyBatis-Plus (适配 Spring Boot 3 的最新版本) ---
    implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.10.1")

    // --- 开发与测试 ---
    // 开发者工具（代码修改后自动重启）
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    // 测试套件（自带 JUnit 5, Mockito, AssertJ）
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// 确保生成的 Jar 文件名固定，方便部署脚本编写
tasks.bootJar {
    archiveFileName.set("app.jar")
}