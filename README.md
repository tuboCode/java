# java
day1

java 中的基本数据类型却不是面向对象的，不能定义基本类型的对象

 java 为每个基本类型都提供了包装类
 
 Java的源代码文件以.java结尾，源代码文件默认是不能被机器执行的。进行编译，把它编译成字节码文件，字节码文件是以.class结尾
 
 **equals() 方法,该方法的作用是判断两个字符串对象的内容是否相同**
 
 *用"=="比较的是两个对象在内存中存储的地址是否一样*
 
 charAt()方法的作用是按照索引值(规定字符串中第一个字符的索引值是0，第二个字符的索引值是1，依次类推)，获得字符串中的指定字符
 ```     
 String s = "abc";
 char c = s.charAt(1);
 
 ```
 
 substring(int beginindex, int endindex)	String	提取beginindex和endindex之间的字符串部分
 
 String 类的字符串创建后是不能够改变的
 
 StringBuffer 类是可变的。它是 String 的对等类，它可以增加和编写字符的可变序列，并且能够将字符插入到字符串中间或附加到字符串末尾
 
 Class 类的实例表示正在运行的 Java 应用程序中的类或接口。
 
 Date()	构造一个 Date 对象并对其进行初始化以反映当前时间
 
 substring() 方法用于提取字符串中介于两个指定下标之间的字符
 
 List 是一个接口，不能实例化，需要一个具体类来实现实例化
 
 List 集合中的对象按照一定的顺序排放，里面的内容可以重复
 
 addAll(int index, Collection<? extends E> c)	boolean	将指定 collection 中的所有元素都插入到列表中的指定位置（可选操作）
 
 -ArrayList：它擅长于随机访问元素，但是插入和移除元素时较慢。
 
 -LinkedList：它通过代价较低的在 List 中进行插入和删除操作，提供了优化的顺序访问，它在随机访问方面相对较慢，但是它的特性集较 ArrayList 更大。
 
 Set 是元素无序并且不包含重复元素的 collection（List 可以重复），被称为集。

字节流主要操作byte类型数据，以byte数组为准，java 中每一种字节流的基本功能依赖于基本类 InputStream 和 Outputstream，他们是抽象类，不能直接使用。

FileInputStream 类用于打开一个输入文件，若要打开的文件不存在，则会产生异常 FileNotFoundException，这是一个非运行时异常，必须捕获或声明抛弃；

FileOutputStream 类用来打开一个输出文件，若要打开的文件不存在，则会创建一个新的文件，否则原文件的内容会被新写入的内容所覆盖；

//文件如果已经存在，则在该输出上输出的内容被接到原有内容之后
```
FileOutputStream(String name, boolean append)·
```

类 BufferedInputStream 和 BufferedOutputStream 实现了带缓冲的过滤流，它提供了缓冲机制，把任意的 I/O 流“捆绑”到缓冲流上，可以提高 I/O 流的读取效率。

一般缓冲区的大小为内存页或磁盘块等的整数倍。

对于 BufferedOutputStream，只有缓冲区满时，才会将数据真正送到输出流，但可以使用 flush() 方法人为地将尚未填满的缓冲区中的数据送出
