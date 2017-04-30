# 反射相关api

## ==java.lang.Class==

 返回值 | 方法  | 描述 |属性
---|---|---|---
 Class |forName(String className) | 返回描述类名为classNme的Class对象| static
 Object|newInstatce()|返回这个类的一个新实例|
 Field[]|getFields()|返回一个包含Field对象的数组，包括自身与超类所有的公有域
 Field|getFiled(String name)|返回包含指定名称的公有域|
 Filed[]|getDeclaredFields()|返回对象全部的域(不含超类)，如果没有域或描述的是基本类型或数组类型，返回长度为0的数组
 Filed[]|getDeclaredFiled(String name)|返回制定名称的域
 Methods[]|getMethods()|返回所有公用的方法，包括从超类继承的公有方法|
 Methods[]|getDeclareMethods()|返回这个类或者接口的全部方法，但不包括由超类继承了的方法
 Constructor[]|getConstructor()|返回包含Constructor对象的数组,包含所有公有构造器
 Constructor[]|getDeclaredConstructors()|包含全部构造器
 
## ==java.lang.Constructor==
 返回值 | 方法  | 描述 
---|---|---|---
 Object|newInstatce(Object[] args) | 构造一个这个构造器所属类的新实例  
 
## ==java.lang.reflect.Field==
 返回值 | 方法  | 描述 
---|---|---|---
 Object|get(Object obj)|返回obj对象中Field对象表示的域值
 Object|set(Object obj,Object newValue)|用一个新的值设置obj对象中Field对象表示的域
## ==java.lang.reflect.Method==
 返回值 | 方法  | 描述 
---|---|---|---
Object|invoke(Object implictParameter,Object[] explicitParamenters)|调用这个对象所描述的方法，传递给定参数，并返回方法的返回值。对于静态方法，把null作为隐式参数传递。在使用包装器传递基本类型时，基本类型的返回值必须是未包装的
## ==java.lang.reflect.Modifier==
 返回值 | 方法  | 描述 | 
---|---|---|---
String|toString(int modifiers)|static
boolean|isAbstract(int modifiers)|static
boolean|isFinal(int modifiers)|static
boolean|isInterface(int modifiers)|static
boolean|isNative(int modifiers)|static
boolean|isPrivate(int modifiers)|static
boolean|isProtected(int modifiers)|static
boolean|isPublic(int modifiers)|static
boolean|isStatic(int modifiers)|static
boolean|isStrict(int modifiers)|static
boolean| isStrict(int modifiers)|static
boolean|isSynchronized(int modifiers)|static
boolean|isVolatile(int modifiers)|static
 
## ==java.lang.reflect.Array== 
  返回值 | 方法  | 描述|属性
---|---|---|---
Object|get(Object array,int index)|返回存储在指定位置上的给定数组的内容
XXX|getXXX(Object array,int index)|同上，xxx是boolean,byte,char,double,float,int,long,short之一
void|set(Object array,int index,Object new Value)|将一个新值存储到给定位置上的给定数组
void|setXXX(Object array,int index,XXX newValue)|同上，xxx是boolean,byte,char,double,float,int,long,short之一
int|getLength(Object array)|返回数组的长度
Object|newInstance(Class componentType,int length)|返回具有给定类型的一维数组
Object|newInstance(Class componetType,int[]lengths)|返回具有给定类型的多维数组
## ==Constructor、Filed、Constructor==
 返回值 | 方法  | 描述
---|---|---|---
 Class|getDeclaringClass()| 返回一个用于描述类中定义的构造器、方法或域的Class对象 
 Class[]|getExceptionTypes()（在Constructor和Method中）| 用于描述方法抛出的异常类型的Class数组
 int|getModifiers()|返回一个用于描述构造器、方法或域的修饰符的整型数值。使用Modifier类中的这个方法可以分析这个返回值
 String|getName()|返回一个用于描述构造器、方法、域名的字符串
 Class[]|getParameterTypes()(在Constructor和Method类中)|返回一个用于描述参数类型的Class对象数组
