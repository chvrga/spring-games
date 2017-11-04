#!/bin/sh
cd $(dirname $0)

cd ../reactive-league
echo "Building `pwd`"

sh build.sh
