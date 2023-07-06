Spring Boot stater for [tomlj](https://github.com/tomlj/tomlj)

## tomlj-spring-boot-srtarter 

本项目是 Spring Boot 项目toml的起步依赖使用[tomlj](https://github.com/tomlj/tomlj)作为toml文件的解析库。


## 已知问题
本项目编写了较多的测试用例发现有一些不支持的tomlj的语法

[配置文件](./src/test/resources/application.toml)

[测试案例](./src/test/java/com/github/whp98/springframework/boot/env)

1. 不支持混合类型数组,如下类型的数组无法通过spring 注入到字段中
    ```toml
    # 混合类型的数组
    contributors = [
        "Foo Bar <foo@example.com>",
        { name = "Baz Qux", email = "bazqux@example.com", url = "https://example.com/bazqux" }
    ]
    ```
2. 不支持表数组注入
    ```toml
    # 表数组
    [[products]]
    name = "Hammer"
    sku = 738594937
    [[products]]  # 数组里的空表
    [[products]]
    name = "Nail"
    sku = 284758393
    color = "gray"
    ```