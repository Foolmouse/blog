cd ../
mvn clean package
echo -e "package finish..."
cd blog-user-web
docker build -t user-web:1.0 .

#启动容器
#docker run --name my-user-web -d  --network  my-net user-web:1.0