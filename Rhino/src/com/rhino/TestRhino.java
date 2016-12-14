package com.rhino;

import java.io.FileReader;
import java.net.URL;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestRhino {
	
	public static void main(String[] args) throws Exception {
		
		ScriptEngineManager sem = new ScriptEngineManager();
		
		ScriptEngine engine = sem.getEngineByName("JavaScript");
		//或者ScriptEngine engine = sem.getEngineByName("js");
		
		System.out.println(engine.getClass());
		
		engine.put("msg", "hello");
		
		engine.eval("var a={name:'youth'}; print(a.name);");
		//脚本定义的变量会存在engine的上下文中
		engine.eval("msg = 'world';");
		
		System.out.println(engine.get("msg"));
		
		System.out.println(engine.get("a").getClass());
		
		engine.eval("function add(a, b) {return a + b;}");
		
		Invocable invoke = (Invocable)engine;
		
		Object result = invoke.invokeFunction("add", 1, 2);
		
		System.out.println(result);
		
		//String jsCode = "importPackage(java.util);var list = Arrays.asList(\"a\", \"b\",\"c\");";
		
		//engine.eval(jsCode);
		//加载js文件
		URL url = TestRhino.class.getClassLoader().getResource("a.js");
		
		FileReader reader = new FileReader(url.getPath());
		
		engine.eval(reader);
		
	}

}
