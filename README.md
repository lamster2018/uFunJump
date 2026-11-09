# uFunJump

iOS / Android 双端应用，基于 **Kotlin Multiplatform + Compose Multiplatform**：界面和业务逻辑写一次，两端共用。
项目骨架由 JetBrains 官方 KMP 向导（kmp.jetbrains.com）生成。

- Android applicationId / iOS Bundle ID：`com.ufun.jump`
- Android：minSdk 24 · targetSdk / compileSdk 37
- iOS：最低 iOS 18.2（`iosApp/iosApp.xcodeproj` 中的 `IPHONEOS_DEPLOYMENT_TARGET`）

## 目录结构

| 目录 | 作用 |
| --- | --- |
| `shared/src/commonMain` | 两端共用的 Compose 界面与业务逻辑（主要代码写在这里） |
| `shared/src/androidMain` / `shared/src/iosMain` | 只在某一端生效的平台代码（`expect`/`actual`） |
| `shared/src/commonTest` 等 | 共享代码的测试 |
| `androidApp` | Android 应用外壳（`MainActivity` 调用共享的 `App()`） |
| `iosApp` | iOS 应用外壳（Xcode 工程，SwiftUI 承载共享的 Compose 界面） |

## 工具链

| 组件 | 版本 |
| --- | --- |
| Kotlin | 2.4.21 |
| Compose Multiplatform | 1.12.2（material3 1.12.0-alpha03，沿用官方向导的选择） |
| Android Gradle Plugin | 9.5.1 |
| Gradle（wrapper） | 9.9.0 |
| 构建用 JDK | 21（由 `gradle/gradle-daemon-jvm.properties` 锁定，与 shell 的 `JAVA_HOME` 无关） |

## 常用命令

```bash
./gradlew :androidApp:assembleDebug     # 编译 Android debug APK
./gradlew :androidApp:installDebug      # 安装到已连接的设备 / 模拟器
./gradlew :shared:testAndroidHostTest   # 共享代码测试（JVM）
./gradlew :shared:iosSimulatorArm64Test # 共享代码测试（iOS 模拟器，需要 Xcode）
```

iOS：用 Xcode 打开 `iosApp/iosApp.xcodeproj` 运行。Xcode 的构建阶段会自动调用 Gradle 编译 `shared` 模块。

## iOS 发布前需要补的配置

- 安装完整版 Xcode（仅有 Command Line Tools 无法编译 iOS）。
- 在 `iosApp/Configuration/Config.xcconfig` 填写 Apple 开发者账号的 `TEAM_ID`。
- 在 Apple Developer 后台注册 Bundle ID `com.ufun.jump`。
