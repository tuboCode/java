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
