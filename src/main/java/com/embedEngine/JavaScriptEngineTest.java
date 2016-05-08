package com.embedEngine;

import org.springframework.core.io.ClassPathResource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.InputStreamReader;

/**
 * <p>description</p>
 * Created by chenweichao on 15-11-6.
 */
public class JavaScriptEngineTest {
//    public static void main(String[] args) {
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("javascript");
//        try{
//
//            engine.eval("var a=3; var b=4;print (a+b);");
//
//            // engine.eval("alert(\"js alert\");");    // 不能调用浏览器中定义的js函数 // 错误，会抛出alert引用不存在的异常
//        }catch(ScriptException e){
//
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");


        ClassPathResource res = new ClassPathResource("script/expression.js");
        System.out.println(res.getPath());
        InputStreamReader reader = new InputStreamReader(res.getInputStream());   // 执行指定脚本

        engine.eval(reader);

        if(engine instanceof Invocable) {
            Invocable invoke = (Invocable)engine;    // 调用merge方法，并传入两个参数

            Double c = (Double)invoke.invokeFunction("merge", 2, 3);
            String  d = (String)invoke.invokeFunction("say", 3, 3);

            System.out.println("c = " + c);
            System.out.println("d = " + d);
        }

        reader.close();

    }
}
