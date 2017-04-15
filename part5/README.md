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
