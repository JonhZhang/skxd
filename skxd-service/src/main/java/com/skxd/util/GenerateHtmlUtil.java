package com.skxd.util;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: skyline{http://my.oschina.net/skyline520}
 * Date: 13-1-9
 * To change this template use File | Settings | File Templates.
 */
public class GenerateHtmlUtil{

    public static String generate(String template,Map inputs) throws Exception {
        String html="";
        Configuration cfg = new Configuration();
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate("myTemplate",template);
        cfg.setTemplateLoader(stringLoader);
        Template temp = cfg.getTemplate("myTemplate","utf-8");
        Writer out = new StringWriter(2048);
        temp.process(inputs, out);
        html=out.toString();
        out.flush();
        out.close();
        return html;
    }
}