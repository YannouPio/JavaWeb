# javaweb-basic
Java Web实验课作业基础版

## 项目结构

```
javaweb-basic
    -- code 代码
        -- src 后端代码
        -- web 前端代码
    -- resource 资源
        -- apache-tomcat-8.5.90 tomcat服务器
        -- jar 项目依赖的jar包
        -- img 图片
        -- sql sql文件
        -- nginx-1.23.1 nginx服务器
    -- .gitignore gitignore文件
    -- README.md 文档
```

### 第1周作业

![第1周作业](https://github.com/zhanglingxi777/javaweb-basic/blob/main/resource/img/1.1.png)
1. 打开cmd，进入resource -> nginx-1.23.1，执行`start nginx`命令
![第1周作业](resource\img\1.1.png)
2. 打开浏览器，在地址栏输入`http://localhost/`
![第1周作业](resource\img\1.2.png)

### 第2周作业

![第2周作业](resource\img\2.png)
1. 在idea中配置tomcat并启动
![第2周作业](resource\img\2.1.png)
![第2周作业](resource\img\2.2.png)
2. 打开浏览器，在地址栏中输入`http://localhost:8080/api/resume`
![第2周作业](resource\img\2.3.png)

### 第3周作业

![第3周作业](resource\img\3.png)
1. 打开cmd，进入resource -> nginx-1.23.1，执行`start nginx`命令
![第3周作业](resource\img\1.1.png)
2. 打开浏览器
   1. html页面：在地址栏中输入`http://localhost/`
    ![第3周作业](resource\img\1.2.png)
   2. servlet页面：在地址栏中输入`http://localhost/api/resume`
    ![第3周作业](resource\img\3.1.png)
   3. jsp页面：在地址栏中输入`http://localhost/resume.jsp`
    ![第3周作业](resource\img\3.2.png)

### 第4周作业

![第4周作业](resource\img\4.png)
1. 新建数据库`javaweb`，在`javaweb`数据库中执行resource -> sql -> javaweb-dump.sql
2. 启动tomcat服务器，在浏览器中输入`http://localhost:8080/user/list`
![第4周作业](resource\img\4.1.png)
