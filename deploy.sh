#!/bin/bash

echo "MedShare Deploying ...."
asadmin --user=admin --passwordfile=/tmp/glassfishpwd deploy /medshare.ear
echo "MedShare Deployed ....":