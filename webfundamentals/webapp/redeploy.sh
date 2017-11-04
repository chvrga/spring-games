#!/bin/bash

# build taglib
cd ../taglib/
mvn clean install

# buuld webapp
cd ../webapp/
mvn clean install

# redeploy
catalina stop ;

cd /usr/local/Cellar/tomcat/8.0.33/libexec/; rm -rf temp work; cd - ;

cp target/webfundamentals.war /usr/local/Cellar/tomcat/8.0.33/libexec/webapps/ ;

catalina start

