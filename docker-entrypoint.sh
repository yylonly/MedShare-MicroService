#!/bin/bash

export ADMIN_PASSWORD=glassfish

echo "AS_ADMIN_PASSWORD=" > /tmp/glassfishpwd
echo "AS_ADMIN_NEWPASSWORD=${ADMIN_PASSWORD}" >> /tmp/glassfishpwd

#change the password
asadmin --user=admin --passwordfile=/tmp/glassfishpwd change-admin-password --domain_name domain1
#enable secure admin
asadmin start-domain

#set new password as password
echo "AS_ADMIN_PASSWORD=${ADMIN_PASSWORD}" > /tmp/glassfishpwd
asadmin --user=admin --passwordfile=/tmp/glassfishpwd enable-secure-admin
asadmin --user=admin stop-domain

