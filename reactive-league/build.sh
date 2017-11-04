#!/bin/sh

./gradlew build

mvn clean install -Pqulice

./gradlew compileJava
