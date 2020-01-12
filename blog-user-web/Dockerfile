# 环境
FROM  openjdk:8-jre
# 作者信息
MAINTAINER dunkluo "DunkLuo@163.com"
# 将本地文件tmp挂载到容器
VOLUME /tmp
# 拷贝jar
ADD ./blog-user-web/target/user-web.jar /user-web.jar
# 设置暴露的端口号
EXPOSE 80
# 执行命令
ENTRYPOINT ["java","-jar","/user-web.jar"]