# Privilege-System
Java Web 实现的 权限系统，对后台进行友好的管理操作。

---

## 核心
权限系统的核心就是DAO层的开发，表与表之间的复杂关系的处理。
本项目并没有采用在一张表中操作用户的权限以及角色，而是以面向对象的角度着手，
分别设计了用户-角色-权限三个独立的对象，来实现之间的多对多的关系的处理。

## 过滤器

本例用到了两个过滤器，一个是解决中文乱码的全局性质的过滤器，里一个就是模拟实现了网站中资源访问需要权限的过滤。

## 架构

典型的MVC模型开发，而且分层比较明显。业务逻辑清晰，处理分明。













补充一点，那就是web.filter包下面的CheckPrivilegeFilter.java 的web.xml配置忘记了。现添加如下：
```
···
<filter>
<filter-name>CheckPrivilegeFilter</filter-name>
<filter-class>web.filter.CheckPrivilegeFilter<filter-class>
</filter>
<filter-mapping>
<filter-name>CheckPrivilegeFilter</filter-name>
<url-pattern>/moudlename/*</url-pattern>
</filter-mapping>


···

```
这样我们就能愉快的构建我们的后台系统。管理我们的业务！
