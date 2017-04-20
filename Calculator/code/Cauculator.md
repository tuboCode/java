我们可以在 JFrame 对象中添加 AWT 或者 Swing 组件。
但是，虽然它有 add 方法，却不能直接用于添加组件，否则会抛出异常。造成这个现象的原因：JFrame 不是一个容器，它只是一个框架

getContentPane()方法获得JFrame的内容面板

建立一个Jpanel或JDesktopPane之类的中间容器，把组件添加到容器中，用setContentPane()方法把该容器置为JFrame的内容面板
