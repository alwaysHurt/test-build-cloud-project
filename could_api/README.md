**盈格PLM系统BS端**   
   
- 基于 Spring Cloud Greenwich 、Spring Security OAuth2 + JWT 权限认证  

核心依赖及版本 
 Spring Boot2.1.5.RELEASE
 Spring CloudGreenwich.RELEASE
 (Hystrix、Ribbon、Feign、Security、Gateway)
 Nacos                https://nacos.io/zh-cn/docs/quick-start.html
 Spring Security OAuth2
 Spring Data Jpa
 hutool 4.5.10(工具包)   https://www.hutool.cn/docs/#/
 Guava 27.0 (工具包)    http://tool.oschina.net/apidocs/apidoc?api=guava

#### 模块说明
```lua
nacos
└── 配置中心、服务注册与发现[8848]
plm
├── plm-ui -- 前端工程[8080]
├── plm-auth -- 授权服务提供[8081]
└── plm-common -- 系统公共模块 
     ├── plm-common-core -- 公共工具类核心包
     ├── plm-common-log -- 日志服务
     └── plm-common-security -- 安全工具类
├── plm-gateway -- Spring Cloud Gateway网关[8080]
└── plm-upms -- 通用用户权限管理模块[8083]

#### 启动说明
1. 去nacos官网把 nacos项目git clone下来，安装官网教程启动；
2. 启动各模块(目前权限认证未完全集成，可以启动任意服务)


### 开发说明
1. 能用java8 语法尽量用java8的语法，如: Lambda表达式，Stream等
2. 可以用工具尽量用工具，避免重复造轮子
3. 参考《阿里巴巴Java开发手册》


编码风格规范：
一. controller层
   1、  URL请求采用小写字母，数字，部分特殊符号（非制表符）组成。
   2、  URL请求中不采用大小写混合的驼峰命名方式，尽量采用全小写单词，如果需要连接多个单词，则采用连接符“_”连接单词
   3、  增删查改、前端页面分页查询统一命名；
   4、 不使用RequestMapping，全部采用PostMapping， 除了特殊业务要求需采用GetMapping之外
   
二、 注释： 
   1、 类名都需要有注释； 实体类字段注释； 接口注释、接口实现类注释、controller层方法注释。(除了增删查改和前端分页查询不做要求)
   
三、命名：
   1. 属性、方法名一律采用驼峰式命名规则；
   2. 不要使用 “is” 开头的作为属性名；实体类都是用包装类
   3   Service/DAO 层方法命名规约
      1） 获取单个对象的方法用 get/find 做前缀。
      2） 获取多个对象的方法用 list/find 做前缀。
      3） 获取统计值的方法用 count 做前缀。
      4） 插入的方法用 save/insert 做前缀。 不使用add
      5） 删除的方法用 remove/delete 做前缀。 
      6） 修改的方法用 update 做前缀。 不使用edit 
   4. controller 层方法命名规约 
      1)  新增add、 编辑 edit、 删除 delete 、查看 view、 分页查询 query
      2） 新增add 的创建人creator、创建时间createTime; 编辑 edit 的修改人 updateBy，修改时间updateTime 统一在controller层处理；
          时间统一用LocalDateTime.now()；创建人和修改人从请求头获取
            创建人和修改用户名称和编号 request.getHeader("userNameAndNo")  
            用户编号 request.getHeader("userNo") 
            用户名称 request.getHeader("userName") 
      
   
四、 异常
    1. 捕获后一定要抛出；或者直接抛出异常；
       
五、 空格规范
    1. 任何二目、三目运算符的左右两边都需要加一个空格
    2. // 注释内容，注意在//和注释内容之间有一个空格
    
六、 Service/Dao 层
    1. 查询数据如果返回类型为 集合类时，如没查询到数据或者 size = 0；不要返回null， 返回如 new ArrayList<>() 
    2. 涉及到事务操作的，一定要加事务注解  @Transactional(rollbackFor = {Exception.class})  
    
七、 其他
    1. 功能模块开发完成后，一定要把controller 层的url 加入到 SYS_MODULE 数据表里，各类按钮可在前台页面手动加；
    2. 有菜单和叶子节点需要 i18n 国际化加到前台 zh-CN 文件   
     