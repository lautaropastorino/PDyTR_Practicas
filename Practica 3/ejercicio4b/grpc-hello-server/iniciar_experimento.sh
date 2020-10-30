#!/bin/bash

mvn -DskipTests exec:java -Dexec.mainClass=pdytr.example.grpc.Client -q &
mvn -DskipTests exec:java -Dexec.mainClass=pdytr.example.grpc.Client -q &