# UFunJump

Android 应用（Kotlin + Jetpack Compose），基于官方 `android create` 的 Empty Activity 模板（AGP 9）。

- applicationId / namespace：`com.ufun.jump`
- minSdk 24 · targetSdk / compileSdk 37（Android 17）

## 工具链

| 组件 | 版本 | 说明 |
| --- | --- | --- |
| Gradle（wrapper） | 9.9.0 | `./gradlew` 自动下载，无需单独安装 |
| Android Gradle Plugin | 9.5.1 | 内置 Kotlin 支持，不再需要 `kotlin-android` 插件 |
| Kotlin / Compose 编译器插件 | 2.4.21 | |
| Compose BOM | 2026.09.00 | |
| 构建用 JDK | 21 | 由 `gradle/gradle-daemon-jvm.properties` 锁定，与 shell 里的 `JAVA_HOME` 无关；本机找不到 JDK 21 时经 foojay 自动下载 |
| 字节码目标 | Java 17 | `compileOptions` + Kotlin `jvmTarget` |
| Android SDK | `~/Library/Android/sdk` | platforms `android-37.0`、build-tools 37.0.0、platform-tools 37.0.1、emulator 37.2 |

## 常用命令

```bash
./gradlew assembleDebug            # 编译 debug APK -> app/build/outputs/apk/debug/app-debug.apk
./gradlew testDebugUnitTest        # 本地单元测试
./gradlew installDebug             # 安装到已连接的设备 / 模拟器

emulator -avd UFunJump_API37       # 启动本机模拟器（Pixel 8 外形，API 37 + Google Play）
adb shell am start -n com.ufun.jump/.MainActivity
```

命令行构建需要 `ANDROID_HOME` 指向 SDK（`~/.zshrc` 已配置）；用 Android Studio 打开时会自动生成 `local.properties`。

## 本机环境备注

- SDK 管理：cmdline-tools 23 起 `sdkmanager` 已被新的 `android` CLI 取代，例如 `android sdk list`、`android sdk install platforms/android-37.0`。
- Android Studio 2026.2 自带的 JBR 是 25；项目的 Gradle daemon 仍然会按配置使用 JDK 21，不需要在 IDE 里手动切换 Gradle JDK。
