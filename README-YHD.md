# UniSensorsAnalyticsModule 怡合达改版

<p align="center" >
  <img src="https://yhd-fe-monitor.oss-cn-shenzhen.aliyuncs.com/static/images/code.png" title="logo" float=left>
</p>

### IOS开发流程

1. 引入SensorsAnalyticsSDK工程到uniapp原生插件离线工程
2. 引入UniSensorsAnalyticsModule工程到uniapp原生插件离线工程
3. 构建framework

```bash
# 进入产出目录
cd .build/Products
# 构建UniSensorsAnalyticsModule.xcframework
xcodebuild -create-xcframework -framework Release-iphoneos/UniSensorsAnalyticsModule.framework -framework Release-iphonesimulator/UniSensorsAnalyticsModule.framework -output ../../Sensorsdata-UniPlugin-App/ios/UniSensorsAnalyticsModule.xcframework
# 构建SensorsAnalyticsSDK.xcframework
xcodebuild -create-xcframework -framework Release-iphoneos/SensorsAnalyticsSDK.framework -framework Release-iphonesimulator/SensorsAnalyticsSDK.framework -output ../../Sensorsdata-UniPlugin-App/ios/SensorsAnalyticsSDK.xcframework
```

### Android开发流程

### 版本更新记录

请参见 [release 发版记录](https://github.com/dgyiheda/uni-app-native-plugin/releases)

