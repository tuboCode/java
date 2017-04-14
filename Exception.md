空指针异常（NullPointerException）

    当应用程序试图在需要对象的地方使用 null 时，抛出该异常。这种情况包括：

        调用 null 对象的实例方法。
        访问或修改 null 对象的字段。
        将 null 作为一个数组，获得其长度。
        将 null 作为一个数组，访问或修改其时间片。
        将 null 作为 Throwable 值抛出。
        
应用程序应该抛出该类的实例，指示其他对 null 对象的非法使用。

自定义一个异常类非常简单，只需要让它继承Exception或其子类就行

printStackTrace()的意义在于在命令行打印异常信息在程序中出错的位置及原因
