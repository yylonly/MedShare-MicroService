# Glassfish 5 and Java EE 8
FROM store/oracle/serverjre:8 

# Maintainer
MAINTAINER YilongYang <yylonly@gmail.com>

# Set environment variables and default password for user 'admin'
ENV GLASSFISH_PKG=glassfish-5.0.zip \
    GLASSFISH_URL=http://download.oracle.com/glassfish/5.0/release/glassfish-5.0.zip \
    GLASSFISH_HOME=/glassfish5 \
    MD5=c87ad9b589db15973f5c80773171b5b4 \
    PATH=$PATH:/glassfish5/bin:/apache-maven-3.5.2/bin \
    ADMIN_PASSWORD=glassfish \
    JDBCDRIVER=http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.30/mysql-connector-java-5.1.30.jar
#    MAVEN_PKG=apache-maven-3.5.2-bin.tar.gz \
#    MAVEN_URL=http://www-us.apache.org/dist/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.tar.gz 

#RUN curl -O $MAVEN_URL && \
#    tar -zxvf $MAVEN_PKG && \
#    rm -f $MAVEN_PKG

#ARG PACKAGE_URL=https://repo.mysql.com/yum/mysql-5.7-community/docker/x86_64/mysql-community-server-minimal-5.7.21-1.el7.x86_64.rpm
#ARG PACKAGE_URL_SHELL=https://repo.mysql.com/yum/mysql-tools-community/el/7/x86_64/mysql-shell-1.0.11-1.el7.x86_64.rpm

# Install packages, download and extract GlassFish
RUN yum -y install wget net-tools unzip vim && \
    curl -O $GLASSFISH_URL && \
    echo "$MD5 *$GLASSFISH_PKG" | md5sum -c - && \
    unzip -o $GLASSFISH_PKG && \
    rm -f $GLASSFISH_PKG && \ 
    wget $JDBCDRIVER && \
    cp mysql-connector-java-5.1.30.jar $GLASSFISH_HOME/glassfish/lib

# Install Mysql
#RUN yum install -y $PACKAGE_URL $PACKAGE_URL_SHELL libpwquality
#RUN rm -rf /var/lib/mysql
#RUN mysqld --initialize --explicit_defaults_for_timestamp

# copy target file
COPY MicroMedShare-ear/target/MicroMedShare-ear-1.0-SNAPSHOT.ear /medshare.ear
COPY wait-for-it.sh /wait-for-it.sh
COPY deploy.sh /deploy.sh

RUN chmod +x /wait-for-it.sh
RUN chmod +x /deploy.sh

# setup glassfish, and then deploy
RUN echo "AS_ADMIN_PASSWORD=" > /tmp/glassfishpwd && \
    echo "AS_ADMIN_NEWPASSWORD=${ADMIN_PASSWORD}" >> /tmp/glassfishpwd && \
    asadmin --user=admin --passwordfile=/tmp/glassfishpwd change-admin-password --domain_name domain1 && \
    asadmin start-domain && \
    echo "AS_ADMIN_PASSWORD=${ADMIN_PASSWORD}" > /tmp/glassfishpwd && \
    asadmin --user=admin --passwordfile=/tmp/glassfishpwd enable-secure-admin && \ 
    asadmin --user=admin restart-domain && \
    asadmin --user=admin --passwordfile=/tmp/glassfishpwd create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --property user=ehr:password=ehr:serverName=mysql:portNumber=3306:databaseName=ehr mysqlpool && \ 
    asadmin --user=admin --passwordfile=/tmp/glassfishpwd create-jdbc-resource --connectionpoolid mysqlpool jdbc/mysql && \ 
#    asadmin --user=admin --passwordfile=/tmp/glassfishpwd deploy /medshare.ear && \
    asadmin --user=admin stop-domain
 
#docker-entrypoint.sh /entrypoint.sh
#RUN chmod +x /entrypoint.sh
#ENTRYPOINT ["/entrypoint.sh"]

# Ports being exposed
EXPOSE 4848 8080 8181

# Start asadmin console and the domain
CMD ["asadmin", "start-domain", "-v"]
ENTRYPOINT ["/deploy.sh"]
