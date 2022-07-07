# Java

* [单例](java/single.md)
* [基本数据类型？大小？默认值](java/ds/ds.md#基本数据类型)
* [String如何实现不可变？](java/ds/ds.md#不可变？)
* [String在JDK8之后底层有哪些变化？](java/ds/ds.md#在JDK9新增的底层变化)
* [为甚循环拼接字符串不用String？](java/ds/ds.md#为甚循环拼接字符串不用String？)
* [`equals()`和`hashcode()`要同时重写？](java/ds/ds.md#重写equals和hashcode)

---

## 数据结构

* [树的种类？优缺点？复杂度？应用场景？](java/ds/ds.md#tree)
* ***Collection***
    * [List实现类？底层？线程安全？初始容量及扩容？使用场景、方法时间复杂度？](java/ds/ds.md#list)
    * [Set实现类？底层？线程安全？有序？null值？](java/ds/ds.md#set)
    * [Queue与Deque的主要方法？区别？](java/ds/ds.md#queue与Deque)
    * [线程安全的List？适用场景？](java/ds/ds.md#并发安全List)
* ***Map***
    * [Map实现类有哪些？区别（底层、线程安全、有序、null值、初始容量）？](java/ds/ds.md#map)
    * ***HashMap***
        * [7和8的链表插入方法？](java/ds/ds.md#尾插法)
        * [扩容时机？扩容过程？参数为什么是这些？为什么不直接复制？为什么不用链表了？为什么不用其他树？转树和转链表的时机？](java/ds/ds.md#扩容)
        * [`put()`过程？](java/ds/ds.md#put)
        * [7和8中为什么不安全？](java/ds/ds.md#不安全)
        * [几种遍历方法？为什么遍历EntrySet比遍历KeySet快？哪种安全？并发修改异常？](java/ds/ds.md#遍历)
    * ***ConcurrentHashMap***
        * [7和8中的结构？](java/ds/ds.md#结构)
        * [7和8中如何实现PUT线程安全？](java/ds/ds.md#线程安全put)
        * [7和8中如何实现GET线程安全？](java/ds/ds.md#线程安全get)

---

## JVM

* [不同版本中的构成？](java/jvm/jvm.md#构成)
* [对象结构？](java/jvm/jvm.md#对象)
* ***类加载***
    * [什么是类加载？](java/jvm/jvm.md#类加载)
    * [类加载器种类？各自加载范围？](java/jvm/jvm.md#种类)
    * [双亲委派的目的？如何绕过？](java/jvm/jvm.md#双亲委派)
    * [类生命周期？](java/jvm/jvm.md#类生命周期)
* ***GC***
    * [分类？](java/jvm/jvm.md#分类)
    * [发生在哪里？](java/jvm/jvm.md#发生区域)
    * [如何确定要回收的对象（标记算法有哪些）？各自优劣？](java/jvm/jvm.md#标记算法)
    * [GC-Roots都有哪些？](java/jvm/jvm.md#gc-roots)
    * [引用分类？所有不可达对象都会被回收吗？](java/jvm/jvm.md#引用)
    * [GC基础算法有？优缺点和使用场景？](java/jvm/jvm.md#GC算法)
    * [分哪几代？回收的流程？比例？GC类型？](java/jvm/jvm.md#分代)
    * ***GC收集器***
        * [各个收集器间比较？](java/jvm/jvm.md#比较)
        * [CMS场景？缺点？过程？？](java/jvm/jvm.md#cms)
        * [G1场景？缺点？过程？](java/jvm/jvm.md#g1)
        * [zGC场景？缺点？过程？](java/jvm/jvm.md#zgc)
* ***调优***
    * [为什么要调优？](java/jvm/jvm.md#目的)
    * [参数及其含义？工具？](java/jvm/jvm.md#参数与工具)
    * [思路？](java/jvm/jvm.md#思路)
    * [实战？](java/jvm/jvm.md#实战)

---

## 线程

* [线程有几种状态？每种状态间如何转换？](java/thread/thread.md#线程状态)
* [实现多线程有几种方式？推荐哪种？Runnable和Callable的区别](java/thread/thread.md#实现多线程的4种方式)
* [yield()、sleep()与wait()的区别？](java/thread/thread.md#方法区别)
* [execute()与submit()的区别？](java/thread/thread.md#线程池提交任务的两种方法)
* [保证线程执行顺序？](java/thread/thread.md#保证线程执行顺序)
* ***synchronized***
    * [原理？](java/thread/thread.md#实现机制)
    * [与Lock的区别？](java/thread/thread.md#lock与synchronized)
* ***ThreadLocal***
    * [原理？](java/thread/thread.md#原理)
    * [内存泄漏？为什么K弱引用而V不是？](java/thread/thread.md#内存泄漏)
    * [应用？](java/thread/thread.md#应用场景)
* ***volatile***
    * [如何实现？](java/thread/thread.md#实现原理)
    * [Java内存模型？缓存一致性协议？](java/thread/thread.md#内存模型)
    * [应用？](java/thread/thread.md#应用)
* ***锁***
    * [锁的类型和区别？](java/thread/thread.md#锁类型)
    * [死锁的4个条件？](java/thread/thread.md#死锁的4个条件)
    * [锁消除？](java/thread/thread.md#锁消除)
    * [锁粗化](java/thread/thread.md#锁粗化)
    * [自适应？](java/thread/thread.md#自适应)
    * [锁升级？](java/thread/thread.md#锁升级)
    * [CAS？一定安全吗？](java/thread/thread.md#cas)
* ***线程池***
    * [主要参数？饱和策略？](java/thread/thread.md#主要参数)
    * [工作流程？](java/thread/thread.md#工作流程)
    * [2种停止方式？区别？](java/thread/thread.md#停止)
    * [Executors中的4种线程池的区别？适用场景？](java/thread/thread.md#executors中的线程池)
    * [核心线程数的确定？](java/thread/thread.md#核心线程数的确定)
* ***AQS***
    * [释义](java/thread/thread.md#核心思想)
    * [资源共享方式？Semaphore、CountDownLatch、CyclicBarrier的主要方法是什么？](java/thread/thread.md#资源共享方式)
    * [CountDownLatch和CyclicBarrier](java/thread/thread.md#countDownLatch和CyclicBarrier)
    * [公平锁？ReentrantLock是公平锁吗？](java/thread/thread.md#公平锁)

---

# Spring

* [有哪些设计模式的体现？](java/spring/spring.md#设计模式)
* [`@Component`和`@Bean`？](java/spring/spring.md#componentbean)
* [`@Resource`和`@Autowired`区别？各自的默认注入方式？](java/spring/spring.md#resourceautowired)
* [过滤器和拦截器？](java/spring/spring.md#过滤器和拦截器)
* [IOC启动流程？](java/spring/spring.md#ioc)
* ***Bean***
    * [作用域？](java/spring/spring.md#Bean作用域)
    * [生命周期？](java/spring/spring.md#Bean生命周期)
* ***AOP***
    * [动态代理的区别和限制？](java/spring/spring.md#动态代理)
    * [切点？连接点？通知有几种？](java/spring/spring.md#概念)
* ***事务***
    * [实现原理？](java/spring/spring.md#实现原理)
    * [7种事务传播行为？默认？](java/spring/spring.md#传播行为)
    * [隔离级别？与DB不一致怎么办？](java/spring/spring.md#隔离级别)
* ***循环依赖***
    * [Spring可处理的情况？](java/spring/spring.md#Spring可处理的情况)
    * [三级缓存？](java/spring/spring.md#三级缓存)
    * [处理过程？](java/spring/spring.md#处理过程)
    * [为什么二级缓存不能解决？](java/spring/spring.md#二级缓存不能解决)
* ***SpringMVC***
    * [与Struts区别？](java/spring/spring.md#与Struts)
    * [工作流程？](java/spring/spring.md#DispatcherServlet)
    * [@ResponseBody和@RequestBody？](java/spring/spring.md#@ResponseBody和@RequestBody)
* ***SpringBoot***
    * [`@SpringBootConfiguration`功能？](java/spring/springboot.md#springbootconfiguration)
    * [自动装配原理？](java/spring/springboot.md#自动装配)
    * [启动流程？](java/spring/springboot.md#启动流程)
    * [如何读取配置？](java/spring/springboot.md#读取配置)
    * [配置加载顺序？](java/spring/springboot.md#配置加载顺序)
    * [2.0新特性？](java/spring/springboot.md#2.0新特性)
    * [自定义starter？](java/spring/springboot.md#自定义starter)
    * [启动时向控制台打印毫秒值？](java/spring/springboot.md#启动时向控制台打印毫秒值)

---

# 数据库

## MySQL

* [三大范式是什么？](database/mysql.md#范式)
* ***索引***
    * [哪些优缺点？](database/mysql.md#优缺点)
    * [类型？](database/mysql.md#类型)
    * [底层是什么？为什么使用这种结构？](database/mysql.md#数据结构)
        * [为什么不用其他结构？](database/mysql.md#为什么不用其他结构)
    * [为什么对于非常小的表，大部分情况下简单的全表扫描比建立索引更高效？](database/mysql.md#小表不建索引)
    * [无法命中索引的情况？是否会用到索引的根本依据？](database/mysql.md#无法命中)
        * [最左前缀匹配？](database/mysql.md#最左前缀匹配)
        * [是否会用到索引的原则？](database/mysql.md#是否会用到索引的原则)
    * [索引创建原则是什么？](database/mysql.md#创建原则)
    * [最左前缀匹配？](database/mysql.md#最左前缀匹配)
* [引擎的特性和使用场景？](database/mysql.md#引擎)
* ***锁***
    * [锁的类型？](database/mysql.md#类型)
    * [介绍锁的粒度？](database/mysql.md#粒度)
* ***事务***
    * [介绍事务特性？](database/mysql.md#特性)
    * [隔离级别？](database/mysql.md#隔离级别)
    * [快照读？当前读？](database/mysql.md#快照读、当前读)
    * [InnoDB的MVCC是什么？](database/mysql.md#mvcc)
* [触发器是什么，有哪几种？](database/mysql.md#触发器)
* [存储过程?优缺点？](database/mysql.md#存储过程)
* ***调优***
    * [优化方向？具体？](database/mysql.md#调优)
    * [发现慢SQL？优化？优化的本质？](database/mysql.md#语句优化)
    * [介绍explain命令？](database/mysql.md#explain)
* ***Mybatis***
    * [#{}和${}的区别？预编译的区别？](database/mysql.md#${}和#{})
    * [Mapper接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗？](database/mysql.md#mapper)
    * [缓存是什么？](database/mysql.md#缓存)
* [分库分表后分页查询？](database/mysql.md#分表分页)
* [SQL练习入门版](database/practise.md)
* [SQL练习进阶版](database/practice.md)

---

## Redis

* ***数据类型***
    * [String底层？优缺点？应用？](database/redis.md#string)
    * [List不同版本的底层及其优缺点？应用？](database/redis.md#list)
    * [Set底层？应用？](database/redis.md#set)
    * [Hash底层？应用？](database/redis.md#hash)
    * [zSet底层？应用？](database/redis.md#zset)
    * [布隆过滤器原理？优缺点？应用场景？](database/redis.md#bloomfilter)
    * [GeoHash底层？使用场景？](database/redis.md#geohash)
    * [Stream使用场景？](database/redis.md#stream)
    * [HyperLogLog使用场景？原理？](database/redis.md#hyperloglog)
* [哪几种持久化方式？优缺点是什么？数据恢复方案？](database/redis.md#持久化)
* [事务命令？它的事务可靠吗？](database/redis.md#事务)
* [K删除策略？如何删除？淘汰策略？默认是？未被设置有效期的K会被删除吗？](database/redis.md#清除K)
* [穿透、击穿、雪崩的定义和解决方案分别是什么？](database/redis.md#缓存风险)
* [分布式锁的实现方案有几种？如何保证整个流程原子性？](database/redis.md#分布式锁)
* [缓存与DB一致性方案？](database/redis.md#缓存与DB一致性)
* [单线程为什么快？redis有多线程吗？](database/redis.md#性能)
* ***集群***
    * [为什么使用哈希槽？](database/redis.md#哈希槽)
    * [主从同步机制？](database/redis.md#同步)
    * [集群数据倾斜？](database/redis.md#倾斜)
    * [主从复制注意事项？](database/redis.md#主从复制)

---

## ES

---

# rpc

* ***Dubbo***
    * [组成？启动？](rpc/rpc.md#启动)
    * [结构？](rpc/rpc.md#结构)
    * [各部分间连接？](rpc/rpc.md#各部分间连接)
    * [SPI？](rpc/rpc.md#SPI)
    * [服务暴露？](rpc/rpc.md#服务暴露)
    * [服务调用？](rpc/rpc.md#服务调用)
    * [服务引用？](rpc/rpc.md#服务引用)
    * [负载均衡模式？](rpc/rpc.md#负载均衡模式)
    * [容错策略？](rpc/rpc.md#容错策略)
* [SpringCloud](rpc/rpc.md#springCloud)
    * [Eureka？](rpc/rpc.md#eureka)
    * [Eureka与zk的区别？](rpc/rpc.md#eureka和ZooKeeper的区别)
    * [Hystrix断路器的作用？](rpc/rpc.md#hystrix)
* [thrift](rpc/rpc.md#springCloud)
* ****注册中心****
    * [zk、nacos、eureka的区别？](rpc/rpc.md#注册中心)
    * [zk应用场景？](rpc/rpc.md#用途)
    * [zk节点类型？](rpc/rpc.md#节点类型)
    * [zk选主流程？](rpc/rpc.md#选主流程)
    * [nacos？](rpc/rpc.md#nacos)

---

# MQ

* [使用场景？](mq/mq.md#用途)
* [丢失？](mq/mq.md#丢失)
* [有序？](mq/mq.md#有序)
* [重复？](mq/mq.md#重复)
* [RocketMQ和kafka的对比？](mq/mq.md#对比)
* [分布式事务？](mq/mq.md#分布式事务)

* ***kafka***
    * [kafka为什么快？](mq/mq.md#高性能)
    * [kafka的三种消费模式？如何配置？](mq/mq.md#三种消费模式)

---

# 网络

* [网络模型？](network/network.md#网络模型)
* [Netty？](network/network.md#Netty)
* ***TCP与UDP***
    * [TCP与UDP区别？](network/network.md#TCP与UDP)
    * [为什么三次握手？](network/network.md#三次握手)
        * [SYN攻击？避免？](network/network.md#SYN超时和风险)
    * [为什么四次挥手？](network/network.md#四次挥手)
* ***Http与Https***
    * [Http与Https区别？](network/network.md#TCP与UDP)
    * [`GET`和`POST`的区别？](network/network.md#getpost)
    * [`Forward`和`Redirect`的区别？](network/network.md#forwardredirect)
    * [`cookie`和`session`的区别？`cookie`被禁用如何识别请求？](network/network.md#cookiesession)
    * [1.0、1.1、2.0的区别？](network/network.md#版本)
    * [Https工作流程？](network/network.md#Https工作流程)
    * [从网址到页面都发生了什么？](network/network.md#从输入网址到页面加载)

---

# [Linux](linux.md)

* [进程间通信方式？](linux.md#进程间通信方式)
* [进程调度算法？](linux.md#进程调度算法)
* [线程间同步方式？](linux.md#线程间同步方式)
* [BIO、NIO、AIO？](linux.md#bionioaio)

---

# [设计模式](设计模式.md)

* [原则？](设计模式.md#原则)
* [创建型有哪些？](设计模式.md#创建型)
* [结构型有哪些？](设计模式.md#结构型)
* [行为型有哪些？](设计模式.md#行为型)
* [J2EE型有哪些？](设计模式.md#j2EE型)