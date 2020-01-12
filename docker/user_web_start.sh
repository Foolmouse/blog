cd ../
mvn clean package
echo -e "package finish..."
cd blog-user-web
docker build -t my-user-web:1.0 .