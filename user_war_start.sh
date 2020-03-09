
git checkout master
git pull

mvn clean package
echo -e "package finish..."

cp blog-user-web/target/user-web.war /home/apache-tomcat-user/webapps/ROOT.war
echo -e "copy war to webapps finish..."


