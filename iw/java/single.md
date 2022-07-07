# 单例

## 应用场景

* 对象频繁实例化然后又销毁

- 网站计数器
- 日志统计
- 配置对象读取

* 对象经常使用但实例化时慢或者资源多，可以提高性能，降低资源损坏
    * 数据库连接池

---
六种单例
---

### **延迟加载**：指调用时才实例化而非类加载时，意义不大，不必在意

* 枚举（安全、防反射、防序列化、立即加载）

```java
/**
 * 枚举（线程安全、防反射、防反序列化）
 */
public enum Single {
    A
}
```

* 懒汉（不安全）

```java
/**
 * 不安全懒汉（延迟加载）
 */
public class Single {
    private static Single s;

    public static Single get() {
        return s == null ? new Single() : s;
    }
}
```

* 懒汉（安全）

```java
/**
 * 安全懒汉（延迟加载）
 */
public class Single {
    private static Single s;

    public synchronized static Single get() {
        return s == null ? new Single() : s;
    }
}
```

* 饿汉

```java
/**
 * 饿汉（安全、立即加载）
 */
public class Single {
    private static Single s = new Single();

    public static Single get() {
        return s;
    }
}
```

* 双锁（安全）

```java
/**
 * 双锁（安全、延迟加载）
 */
public class Single {
    private static volatile Single s;

    public static Single get() {
        if (s != null) return s;
        synchronized (Single.class) {
            return s == null ? new Single() : s;
        }
    }
}
```

* 静态内部类（安全、延迟加载）

```java
/**
 * 静态内部类（安全、延迟加载）
 */
public class Single {
    private static class Holder {
        private static final Single s = new Single();
    }

    public static Single get() {
        return Holder.s;
    }
}
```



