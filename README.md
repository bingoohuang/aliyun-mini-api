[![Build Status](https://travis-ci.org/bingoohuang/aliyun-mini-api.svg?branch=master)](https://travis-ci.org/bingoohuang/aliyun-mini-api)
[![Coverage Status](https://coveralls.io/repos/github/bingoohuang/aliyun-mini-api/badge.svg?branch=master)](https://coveralls.io/github/bingoohuang/aliyun-mini-api?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.bingoohuang/aliyun-mini-api/badge.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/com.github.bingoohuang/aliyun-mini-api/)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)


# aliyun-mini-api
aliyun minimalism java rest api

## RDS APIs

Full api document avaiable at: [RDS API](http://imgs-storage.cdn.aliyuncs.com/help/rds/RDS-API-Reference.pdf)

```JAVA
RdsInstance rds = new RdsInstance(new AccessToken("accessKeyId", "accessKeySecret"), "dbInstanceId");

// Create Database
rds.createDatabase("bingooDb");

// Delete Database
rds.deleteDatabase("bingooDb");

// Describe attribute of the instance
rds.describeInstanceAttribute();

// Describe single Database in the instance
rds.describeDatabase("bingooDb");

// Describe all Databases in the instance
rds.describeAllDatabases();

// Create Account
rds.createAccount("accountName", ApiUtil.randomRdsString(16));

// Grant Account Privilege to a database
rds.grantAccountReadWritePrivilege("accountName", "bingooDb");

```
