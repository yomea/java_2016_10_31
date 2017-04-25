package rhino;

import java.io.FileReader;
import java.net.URL;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * class jdk.nashorn.api.scripting.NashornScriptEngine
 * youth
 * world
 * class jdk.nashorn.api.scripting.ScriptObjectMirror
 * 3.0
 * 计算后的值为：30

 * @author Administrator
 *
 */
public class TestRhino {
	
	public static void main(String[] args) throws Exception {
		
		ScriptEngineManager sem = new ScriptEngineManager();
		
		ScriptEngine engine = sem.getEngineByName("JavaScript");
		//或者ScriptEngine engine = sem.getEngineByName("js");
		
		System.out.println(engine.getClass());// class jdk.nashorn.api.scripting.NashornScriptEngine
		//这个对象中持有一个继承了Map的Binding类，这个类用来储存键值对
		engine.put("msg", "hello");//hello
		
		System.out.println(engine.get("msg"));
		
		//这个方法类似与javascript中的eval方法
		engine.eval("var a={name:'youth'}; print(a.name);");//youth
		//脚本定义的变量会存在engine的上下文中,执行赋值运算后，msg的值发生了改变
		engine.eval("msg = 'world';");
		
		engine.eval("test = 'neihou';");
		
		System.out.println(engine.get("test"));// world
		
		System.out.println(engine.get("msg"));// world
		
		System.out.println(engine.get("a").getClass());//class jdk.nashorn.api.scripting.ScriptObjectMirror
		
		engine.eval("function add(a, b) {return a + b;}");
		
		Invocable invoke = (Invocable)engine;
		
		Object result = invoke.invokeFunction("add", 1, 2);
		
		System.out.println(result);//3.0
		
		//String jsCode = "importPackage(java.util);var list = Arrays.asList(\"a\", \"b\",\"c\");";
		
		//engine.eval(jsCode);
		//加载js文件
		URL url = TestRhino.class.getClassLoader().getResource("a.js");
		
		FileReader reader = new FileReader(url.getPath());
		//运行一个js文件
		engine.eval(reader);//计算后的值为：30
		
	}

}
