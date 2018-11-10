### spring-boot-demo
这是一个springboot的学习过程中做的一些小demo

##### 使用到的spring基础
SpringMVC

Spring-Data-Validation
业务逻辑的数据校验有很多优缺点，spring提供的数据校验也一样。校验不应该被关联到web层，同时应该易于本地化
同时应该能在任何地方使用。居于这些考虑，spring提出Validator接口适用于应用每一层。
和校验另一个关联的技术是数据表绑定（data-bingding），是把用户的输入动态的绑定到应用的领域模型。
Validation和data-binding是数据校验包的两个核心，使spring的数据校验不局限于web层
Spring-JPA-Data

Dsl

## shiro
是Java的一个安全框架,Shiro可以帮助我们完成：认证、授权、加密、会话管理、与Web集成、缓存等.
Authentication：身份认证/登录，验证用户是不是拥有相应的身份；
Authorization：授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限；
Session Manager：会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；会话可以是普通JavaSE环境的，也可以是如Web环境的；
Cryptography：加密，保护数据的安全性，如密码加密存储到数据库，而不是明文存储；
Web Support：Web支持，可以非常容易的集成到Web环境；
Caching：缓存，比如用户登录后，其用户信息、拥有的角色/权限不必每次去查，这样可以提高效率；
Concurrency：shiro支持多线程应用的并发验证，即如在一个线程中开启另一个线程，能把权限自动传播过去；
Testing：提供测试支持；
Run As：允许一个用户假装为另一个用户（如果他们允许）的身份进行访问；
Remember Me：记住我，这个是非常常见的功能，即一次登录后，下次再来的话不用登录了。

身份验证，即在应用中谁能证明他就是他本人。一般提供如他们的身份ID一些标识信息来表明他就是他本人，如提供身份证，用户名/密码来证明。
在shiro中，用户需要提供principals （身份）和credentials（证明）给shiro，从而应用能验证用户身份：
principals：身份，即主体的标识属性，可以是任何东西，如用户名、邮箱等，唯一即可。一个主体可以有多个principals，但只有一个Primary principals，一般是用户名/密码/手机号。
credentials：证明/凭证，即只有主体知道的安全值，如密码/数字证书等。