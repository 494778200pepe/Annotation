@PkgAnnotation
package com.hopechart.sq.annotation;
/**
 * 首先，它不能随便被创建。在Eclipse中， package-info文件不能随便被创建，会报“Type name is notvalid”错误，类名无效.
 * Java变量定义规范是：字母、数字、下划线，还有那个不怎么常用的$符号（顺带说下，Java是支持中文名称的变量.
 * 习惯挑战的同学可以尝试下，分享一下这方面的经验），这个中划线可不再之列，那怎么创建这个文件呢？
 * 很简单，用记事本创建一个，然后拷贝进去再改一下就成了，更直接的办法就是从别的项目中拷贝过来一个，这更方便。
 *
 * 其次，服务的对象很特殊。
 *  一个类是一类或一组事物的描述，比如Dog这个类，就是描述旺财的，那package-info这个类是描述啥的呢？它总要有一个被描述或被陈述的对象，它是描述和记录本包信息。
 *
 * 最后，类不能带有public、private访问权限。
 * package-info.java再怎么特殊，也是一个类文件，也会被编译成package-info.class，但是在package-info.java中只能声明默认访问权限的类，也就是友好类。
 *
 * 其实还有几个特殊的地方，比如不可以继承，没有接口，没有类间关系（关联、组合、聚合等等）等。
 * 这个文件的特殊性说完了，那再说说它有什么作用，它有三个作用：
 * 1、为标注在包上Annotation提供便利；
 * 2、声明友好类和包常量；
 * 3、提供包的整体注释说明。
 *
 * 注意：
 * 1、package-info.java里不能声明public class(或 interface)
 * 2、刚开始p.isAnnotationPresent(JyzTargetPackage.class)返回false，后来找到原因JyzTargetPackage没有加上@Retention(RetentionPolicy.RUNTIME)。
 **/

class PackageInfo{
    public void common(){
        System.out.println("测试友好类");
    }
}

class PackageInfoGeneric<T extends Throwable>{
    private T obj;
    public void set(T obj){
        this.obj = obj;
    }
    public void common(){
        System.out.println(obj + "测试泛型");
    }
}

interface packageInfoInteger{
    void test();
}

class PackageConstants{
    public static final String ERROE_CODE = "测试常量";
}

