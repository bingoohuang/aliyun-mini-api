[![Build Status](https://travis-ci.org/bingoohuang/aliyun-mini-api.svg?branch=master)](https://travis-ci.org/bingoohuang/aliyun-mini-api)
[![Coverage Status](https://coveralls.io/repos/github/bingoohuang/aliyun-mini-api/badge.svg?branch=master)](https://coveralls.io/github/bingoohuang/aliyun-mini-api?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.bingoohuang/aliyun-mini-api/badge.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/com.github.bingoohuang/aliyun-mini-api/)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)


# aliyun-mini-api
aliyun minimalism java rest api

## RDS APIs

```JAVA
Rds rds = new Rds(new AccessToken("accessKeyId", "accessKeySecret"));
String dbInstanceId = "dbInstanceId";

// Create Database
rds.invoke(new CreateDatabaseReq(dbInstanceId, "bingooDb"));

// Delete Database
rds.invoke(new DeleteDatabaseReq(dbInstanceId, "bingooDb"));

// Describe attribute of an instance
rds.invoke(new DescribeDBInstanceAttributeReq(dbInstanceId));

// Describe single Database in an instance
rds.invoke(new DescribeDatabaseReq(dbInstanceId, "bingooDb"));

// Describe all Databases in an instance
rds.invoke(new DescribeDatabasesReq(dbInstanceId));


// Create Account
rds.invoke(new CreateAccountReq(dbInstanceId, "accountName", ApiUtil.randomRdsString(16)));

// Grant Account Privilege to a database
rds.invoke(new GrantAccountPrivilegeReq(dbInstanceId, "accountName", "bingooDb"));


```
