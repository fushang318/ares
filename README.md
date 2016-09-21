# 运行方法

## windows + android 4.x 或 mac + android 4.x
```
git clone https://github.com/fushang318/ares.git
cd ares
npm install
react-native run-android

# 需要确保手机和电脑在同一个局域网
# 手机进入 app,晃动手机选择 dev setting -> Debug server host & port for device 设置本机IP+8081
# 比如本机IP是 192.168.2.233 那么就需要填写 192.168.2.233:8081
```

## windows + android 5.x(国产手机)
```
git clone https://github.com/fushang318/ares.git
cd ares
npm install
run_android.bat

# 需要确保手机和电脑在同一个局域网
```

## mac + android 5.x(国产手机)
```
git clone https://github.com/fushang318/ares.git
cd ares
npm install
./run_android

# 需要确保手机和电脑在同一个局域网
```

## mac + iphone虚拟机
```
git clone https://github.com/fushang318/ares.git
cd ares
npm install
react-native run-ios
```