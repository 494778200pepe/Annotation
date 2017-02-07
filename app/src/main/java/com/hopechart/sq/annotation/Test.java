package com.hopechart.sq.annotation;

import com.hopechart.sq.annotation.Demo1.AnnatDemo;
import com.hopechart.sq.annotation.Demo1.IClientProtocolEx;
import com.hopechart.sq.annotation.Demo2.Age;
import com.hopechart.sq.annotation.Demo2.Gender;
import com.hopechart.sq.annotation.Demo2.Name;
import com.hopechart.sq.annotation.Demo2.Person;
import com.hopechart.sq.annotation.Demo2.Profile;
import com.hopechart.sq.annotation.Demo3.HelloWorld;
import com.hopechart.sq.annotation.Demo3.SayHello;
import com.hopechart.sq.annotation.Demo3.Yts;
import com.hopechart.sq.annotation.Demo4.Child;
import com.hopechart.sq.annotation.Demo4.InheritedTest;
import com.hopechart.sq.annotation.Demo4.NoneInheritedTest;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wang on 2017/2/6.
 */

public class Test {
    public static void main(String arg[]) {
        //获取 方法的注解
        testDemo1();
        System.out.println("----------------------------分隔线---------------------------------");
        //获取 属性的注解 和 数组作为元数据
        testDemo2();
        System.out.println("----------------------------分隔线---------------------------------");
        //获取 类的注解 和 通过反射调用方法
        testDemo3();
        System.out.println("----------------------------分隔线---------------------------------");
        //测试 Inherited 和 Documented
        testDemo4();
        System.out.println("----------------------------分隔线---------------------------------");
        //测试 package-info.java的使用
        testDemo5();
    }

    private static void testDemo1() {
        Class ipt = IClientProtocolEx.class;
        Method[] mts = ipt.getMethods();
        for (Method mt : mts) {
            // 当前只有一个方法
            AnnatDemo ad = mt.getAnnotation(AnnatDemo.class);//如果方法上  没有该注解  则返回null
            int value = ad.value();
            System.out.println("value:" + value);
        }
    }

    private static void testDemo2() {
        String[] name;
        String gender = "";
        String profile = "";
        int age = 10;
        Field fields[] = Person.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Name.class)) {
                Name arg0 = field.getAnnotation(Name.class);
                name = arg0.value();
                System.out.println("name=" + name[0] + "、" + name[1] + "、" + name[2]);
            }
            if (field.isAnnotationPresent(Age.class)) {
                Age arg0 = field.getAnnotation(Age.class);
                age = arg0.value();
                System.out.println("age=" + age);
            }
            if (field.isAnnotationPresent(Gender.class)) {
                Gender arg0 = field.getAnnotation(Gender.class);
                gender = gender + arg0.gender().toString();
                System.out.println("gender=" + gender);
            }
            if (field.isAnnotationPresent(Profile.class)) {
                Profile arg0 = field.getAnnotation(Profile.class);
                profile = "[id=" + arg0.id() + ",height=" + arg0.height() + ",nativePlace=" + arg0.nativePlace() + "]";
                System.out.println("profile=" + profile);
            }
        }
    }

    private static void testDemo3() {
        try {
            //解析方法
            Object obj = SayHello.class.getConstructor(new Class[]{}).newInstance(new Object[]{});
            for (Method method : SayHello.class.getDeclaredMethods()) {
                HelloWorld say = method.getAnnotation(HelloWorld.class);
                String name;
                if (say != null) {
                    name = say.name();
                    method.invoke(obj, name);
                }
                Yts yts = method.getAnnotation(Yts.class);
                //有默认值  YtsType.util
                if (yts != null) {
                    if (Yts.YtsType.util.equals(yts.classType())) {
                        System.out.println("this is a util method");
                    } else {
                        System.out.println("this is a other method");
                    }
                }
            }
            //解析类
//        Yts yts = (Yts) clazz.getAnnotation(Yts.class);
//        if (yts != null) {
//            if (Yts.YtsType.util.equals(yts.classType())) {
//                System.out.println("this is a util class");
//            } else {
//                System.out.println("this is a other class");
//            }
//        }
            if (SayHello.class.isAnnotationPresent(Yts.class)) {
                Yts yts = (Yts) SayHello.class.getAnnotation(Yts.class);
                if (Yts.YtsType.util.equals(yts.classType())) {
                    System.out.println("this is a util class");
                } else {
                    System.out.println("this is a other class");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testDemo4() {
        try {
            Class<Child> clazz = Child.class;
            //对类进行测试
            System.out.println("对类进行测试");
            if (clazz.isAnnotationPresent(InheritedTest.class)) {
                System.out.println(clazz.getAnnotation(InheritedTest.class).value());
            }
            if (clazz.isAnnotationPresent(NoneInheritedTest.class)) {
                System.out.println(clazz.getAnnotation(NoneInheritedTest.class).value());
            }
            System.out.println();
            //对方法 进行测试
            System.out.println("对方法进行测试");
            Method method = clazz.getMethod("childMethod", null);
            if (method.isAnnotationPresent(InheritedTest.class)) {
                System.out.println(method.getAnnotation(InheritedTest.class).value());
            }
            if (method.isAnnotationPresent(NoneInheritedTest.class)) {
                System.out.println(method.getAnnotation(NoneInheritedTest.class).value());
            }
            System.out.println();
            //对方法2 进行测试
            System.out.println("对方法2进行测试");
            Method method2 = clazz.getMethod("parentMethod", null);
            if (method2.isAnnotationPresent(InheritedTest.class)) {
                System.out.println(method2.getAnnotation(InheritedTest.class).value());
            }
            if (method2.isAnnotationPresent(NoneInheritedTest.class)) {
                System.out.println(method2.getAnnotation(NoneInheritedTest.class).value());
            }
            System.out.println();
            //对属性测试
            System.out.println("对属性a进行测试");
            Field fieldA = clazz.getField("a");
            if (fieldA.isAnnotationPresent(InheritedTest.class)) {
                System.out.println(fieldA.getAnnotation(InheritedTest.class).value());
            }
            if (fieldA.isAnnotationPresent(NoneInheritedTest.class)) {
                System.out.println(fieldA.getAnnotation(NoneInheritedTest.class).value());
            }

            System.out.println();
            //对属性测试
            System.out.println("对属性b进行测试");
            Field fieldB = clazz.getField("b");
            if (fieldB.isAnnotationPresent(InheritedTest.class)) {
                System.out.println(fieldB.getAnnotation(InheritedTest.class).value());
            }
            if (fieldB.isAnnotationPresent(NoneInheritedTest.class)) {
                System.out.println(fieldB.getAnnotation(NoneInheritedTest.class).value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testDemo5() {
        //1、包注解的获取
        //可以通过I/O操作或配置项获得包名
        String pkgName = "com.hopechart.sq.annotation";
        Package pkg = Package.getPackage(pkgName);
        if (pkg != null && pkg.isAnnotationPresent(PkgAnnotation.class)) {
            //获得包上的注解
            Annotation[] annotations = pkg.getAnnotations();
            //遍历注解数组
            for (Annotation an : annotations) {
                if (an instanceof PkgAnnotation) {
                    System.out.println("Hi,I'm the PkgAnnotation ,which is be placed on package!");
                /*
                 * 注解操作
                 * MyAnnotation myAnn = (PkgAnnotation)an;
                 * 还可以操作该注解包下的所有类，比如初始化，检查等等
                 * 类似Struts的@Namespace，可以放到包名上，标明一个包的namespace路径
                 */
                }
            }
        }

        //2、测试友好类
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.common();

        //3、测试泛型
        //泛型也能很好的工作，在pakcage-info.java里定义的类和普通类没什么区别
        PackageInfoGeneric<Exception> packageInfoGeneric = new PackageInfoGeneric<Exception>();
        packageInfoGeneric.set(new IOException("device io"));
        packageInfoGeneric.common();

        //4、测试接口
        Sub sub = new Sub();
        sub.test();

        //5、测试常量
        System.out.println(PackageConstants.ERROE_CODE);

    }

}

class Sub implements packageInfoInteger {

    @Override
    public void test() {
        System.out.println("测试接口");
    }

}
