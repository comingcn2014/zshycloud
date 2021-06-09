该项目仅供XXX科技有限公司内部参考学习使用，如有疑问请留言或者群内讨论
### 🔧 功能特点
- 主体框架：采用最新的Spring Cloud 2020.0.2, Spring Boot 2.4.5, Spring Cloud Alibaba 2021.1版本进行系统设计；

- 统一注册：支持Nacos作为注册中心，实现多配置、分群组、分命名空间、多业务模块的注册和发现功能；

- 统一认证：统一Oauth2认证协议，采用jwt的方式，实现统一认证，并支持自定义grant_type实现手机号码登录，第三方登录正在开发中；

- 业务监控：利用Spring Boot Admin 来监控各个独立Service的运行状态；利用Hystrix Dashboard来实时查看接口的运行状态和调用频率等。

- 内部调用：集成了Feign和Dubbo两种模式支持内部调用，并且可以实现无缝切换，适合新老程序员，快速熟悉项目；

- 业务熔断：采用Sentinel实现业务熔断处理，避免服务之间出现雪崩;

- 身份注入：通过注解的方式，实现用户登录信息的快速注入；

- 在线文档：通过接入Knife4j，实现在线API文档的查看与调试;

- 代码生成：基于Mybatis-plus-generator自动生成代码，提升开发效率，生成模式不断优化中，暂不支持前端代码生成；

- 消息中心：集成消息中间件RocketMQ，对业务进行异步处理;

- 业务分离：采用前后端分离的框架设计，前端采用vue-element-admin
  3
  
- 链路追踪：自定义traceId的方式，实现简单的链路追踪功能

- 多租户功能：集成Mybatis Plus,实现saas多租户功能

### 🗿 文件结构
```lua
zshycloud -- 父项目,各模块分离，方便集成和微服务
│  ├─zshy-core -- 核心通用模块，主模块
│  │  ├─zshy-starter-common -- 封装通用模块
│  │  ├─zshy-starter-cloud -- 封装微服务模块
│  │  ├─zshy-starter-auth -- 封装token认证模块
│  │  ├─zshy-starter-security -- 封装OAuth2基础模块
│  │  ├─zshy-starter-web -- 封装WEB服务基础模块
│  │  ├─zshy-starter-database -- 封装Mybatis及数据库基础模块
│  │  ├─zshy-starter-dependencies -- 封装所有依赖模块，可作为父项目独立引用
│  │  ├─zshy-starter-dubbo -- 封装dubbo基础模块
│  │  ├─zshy-starter-feign -- 封装feign基础模块
│  │  ├─zshy-starter-jetcache -- 封装JetCache阿里缓存基础模块
│  │  ├─zshy-starter-rocketmq -- 封装RocketMQ基础模块
│  │  ├─zshy-starter-gray -- 封装灰度发布基础模块
│  │  ├─zshy-starter-elasticsearch -- 封装ElasticSearch模块
│  │  ├─zshy-starter-oss -- 封装oss存储基础模块,支持阿里云、七牛云、minio等
│  │  ├─zshy-starter-log -- 封装日志基础模块
│  │  ├─zshy-starter-sharding -- 封装多数据库基础模块
│  │  ├─zshy-starter-sms -- 封装短信基础模块
│  │  ├─zshy-starter-mail -- 封装邮件模块
│  │  ├─zshy-starter-kafka -- 封装kafka基础模块
│  │  ├─zshy-starter-rule -- 封装黑名单基础模块
│  │  ├─zshy-starter-idempotent -- 封装幂等基础模块
│  │  ├─zshy-starter-lock -- 封装分布式锁基础模块
│  │  ├─zshy-starter-encrypt -- 封装报文加密模块，支持AES和RSA
│  │  ├─zshy-starter-mongodb -- 封装mongodb数据库模块
│  │  ├─zshy-starter-strategy -- 封装策略模块
│  │  ├─zshy-starter-job -- 封装定时任务基础模块
│  │─zshy-gateway -- 统一网关模块 [10001]
│  │─zshy-uaa -- 统一认证中心模块 [20001]
│  │─zshy-platform -- 平台模块项目，目前包含系统子模块
│  │  ├─zshy-system-api -- 系统模块的通用模块，供其他模块引用
│  │  ├─zshy-system -- 系统模块核心功能 [20002]
│  │  ├─zshy-component-api -- 组件模块核心功能，供其他模块引用
│  │  ├─zshy-component -- 组件模块核心功能 [20003]
│  │─zshy-support -- 支持中心项目，目前包括代码生成、admin模块
│  │  ├─zshy-code -- 封装代码生成逻辑 [30002]
│  │  ├─zshy-admin -- 封装spring-boot-admin逻辑 [30001]
│  │  ├─zshy-job -- xxl-jog定时任务模块
│  │  ├─zshy-job-admin -- 定时任务管理平台模块
│  │─zshy-mq -- 消息中心项目，支持kafka、RocketMQ等多种消息中间件
│  │  ├─zshy-log-producer -- 日志消息生产者，集成kafka [40001]
│  │  ├─zshy-message-consumer -- 消息服务消费者 [40002]
│  │  ├─zshy-message-producer -- 消息服务生产者 [40003] 
```
### 🎨 核心模块提交至中央仓库
如何引入依赖
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.zshy</groupId>
            <artifactId>zshy-starter-dependencies</artifactId>
            <version>3.1.8</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
``

