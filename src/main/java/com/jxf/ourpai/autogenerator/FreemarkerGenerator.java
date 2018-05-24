package com.jxf.ourpai.autogenerator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerGenerator {

    public static void main(String[] args) {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/freemarker_templates"));
            cfg.setDefaultEncoding("utf-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template temp = cfg.getTemplate("test.ftl");

            /* Create a data-model */
            Map root = new HashMap();
            root.put("user", "Big Joe");
            Map latest = new HashMap();
            root.put("latestProduct", latest);
            latest.put("url", "products/greenmouse.html");
            latest.put("name", "green mouse");

            /* Merge data-model with template */
//        Writer out = new OutputStreamWriter(System.out);
//        File outFile = new File("src/main/resources/freemarker_templates/text111.txt");
            File outFile = new File("src/main/java/com/jxf/codegenerator/fff/text111.txt");
            outFile.createNewFile();
            FileWriter fw = new FileWriter(outFile);
            temp.process(root, fw);
            // Note: Depending on what `out` is, you may need to call `out.close()`.
            // This is usually the case for file output, but not for servlet output.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
