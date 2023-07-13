# UniSensorsAnalyticsModule 怡合达改版

<p align="center" >
  <img src="https://yhd-fe-monitor.oss-cn-shenzhen.aliyuncs.com/static/images/code.png" title="logo" float=left>
</p>

### IOS 开发流程

1. 引入 SensorsAnalyticsSDK 工程到 uniapp 原生插件离线工程
2. 引入 UniSensorsAnalyticsModule 工程到 uniapp 原生插件离线工程
3. 构建 framework

```bash
# 进入产出目录
cd .build/Products
# 构建UniSensorsAnalyticsModule.xcframework
xcodebuild -create-xcframework -framework Release-iphoneos/UniSensorsAnalyticsModule.framework -framework Release-iphonesimulator/UniSensorsAnalyticsModule.framework -output ../../Sensorsdata-UniPlugin-App/ios/UniSensorsAnalyticsModule.xcframework
# 构建SensorsAnalyticsSDK.xcframework
xcodebuild -create-xcframework -framework Release-iphoneos/SensorsAnalyticsSDK.framework -framework Release-iphonesimulator/SensorsAnalyticsSDK.framework -output ../../Sensorsdata-UniPlugin-App/ios/SensorsAnalyticsSDK.xcframework
```

### Android 开发流程

1. 导入插件源码到 Android Studio [仓库地址](https://github.com/dgyiheda/uni-app-native-plugin/tree/master/android)
2. windows 构建命令：uni-app-native-plugin\android>`gradlew assembleRelease`
3. mac、linux 构建命令：uni-app-native-plugin\android>`./gradlew assembleRelease`

```bash
# 进入产出目录
cd uni-app-native-plugin\build\outputs\aar

### 版本更新记录

请参见 [release 发版记录](https://github.com/dgyiheda/uni-app-native-plugin/releases)
```
