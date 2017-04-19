泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的，能够提高代码的重用率。

图形用户界面（GUI）

![1](https://dn-anything-about-doc.qbox.me/document-uid85931labid1099timestamp1436497022095.png?watermark/1/image/aHR0cDovL3N5bC1zdGF0aWMucWluaXVkbi5jb20vaW1nL3dhdGVybWFyay5wbmc=/dissolve/60/gravity/SouthEast/dx/0/dy/10)

JFrame 类就是一个容器，允许你把其他组件添加到它里面，把它们组织起来，并把它们呈现给用户

对于 Swing 应用程序，我们如果要将组件放在 JFrame 上，则需要继承JFrame 类

JLabel 可以用作文本描述和图片描述

使用setBounds()方法设置尺寸四个参数的分别是x,y,width,height 代表了横向、纵向的位置，以及标签自身的宽和高

          myLabel.setBounds(5, 10, 250, 30);

        myLabel.setBounds(5, 10, 250, 30);
        使用setBounds()方法设置尺寸
        四个参数的分别是x,y,width,height
add()方法可以将指定组件添加到此容器的给定位置上
第一个参数为待添加的组件，这里的组件来自我们的返回值
第二个参数为描述组件的布局限制的对象，我们不加限制，所以填nul

为线程提供run方法

- 继承Thread类并重写它的run()方法，然后用这个子类来创建对象并调用start()方法。
- 通过定义一个类，实现Runnable接口，实现run()方法

Vector vec = new Vector(10,2); 该方法创建了一个长度为10的Vector,并且当向量需要增加时，每次增加为2

vector(向量): C++中的一种数据结构,确切的说是一个类.它相当于一个动态的数组,当程序员无法知道自己需要的数组的规模多大时,用其来解决问题可以达到最大节约空间的目的

JFrame是一个顶层的框架类，好比一个窗户的框子。也是一个容器类。这个框子可以嵌入几个玻璃窗。
 
JPanel是一个容器类，相当于一大玻璃窗。
 
JLabel等是一些基础组件，它必须置于某个容器里，类似于窗花、剪纸，必须置于窗户的表面。

一、单行文本输入框（JTextField）

　　在许多情况下，用户可能还需要输入一些文字，这时就需要用到文本输入框。单行文本输入框是由 JTextField 类实现的。它的构造函数如下:

　　(1) JTextField() 构造一个新的单行文本输入框。

　　(2) JTextField(int length) 构造一个指定长度的单行文本输入框。

　　(3) JtextField(String text) 构造一个指定初始内容的单行文本输入框。

　　(4) JTextField(String text,int length) 构造一个指定长度，指定初始内容的单行文本输入框。

　　(5) JTextField(Document docu,String text,int length) 指定文件存储模式构造一个指定长度，指定初始内容的单行文本输入框。

二、多行文本输入框（JTextArea）

　　多行文本输入框的功能与单行文本输入框的功能相同，只是它能显示更多的文字。因为单行文本输入框只能输入一行的文字，所以需要输入和显示较多的文字时，就要用到多行文本输入框。多行文本输入框是由 JTextArea 类实现的。JTextArea类的构造方法有4种:

　　(1) JTextArea() 构造一个新的多行文本输入框。

　　(2) JTextArea(int row,int column) 构造一个指定长度和宽度的多行文本输入框。

　　(3) JTextArea(String text) 构造一个显示指定文字的多行文本输入框。

　　(4) JTextArea(String text,int row,int column) 构造一个指定长度，指定宽度，并显示指定文字的多行文本输入框。

　　(5) JTextArea(Document doc) 构造一个指定文件存储模式的多行文本输入框。

　　(6) JTextArea(Document doc,String text,int row,int column) 构造一个指定文件存储模式，指定长度和指定宽度，并显示指定文字的多行文本输入框。

getSource( ) 获取产生事件组件的组件名 getActionCommand( ) 获取与组件有关的文本
