package com.skxd.util;

import com.skxd.vo.Cloumn;
import com.skxd.vo.Table;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/12.
 */
public class Genterator {

    public static String template_path = "D:\\sai\\shangzezhong.skxd\\trunk\\skxd-parent\\template";

    public static String save_path = "D:\\sai\\shangzezhong.skxd\\trunk\\skxd-parent\\generator";

    public static void main(String args[]) throws Exception {
        List<Table> tables = queryTables();
        for (Table table : tables) {
            Map result = new HashMap();
            result.put("table", table);
            result.put("package", "skxd");
            genteratorHtml("page", table, result, "jsp");
            genteratorHtml("controller", table, result, "java");
            genteratorHtml("service", table, result, "java");
            genteratorHtml("IService",table,result,"java");
            genteratorHtml("edit",table,result,"jsp");
            genteratorHtml("mapper",table,result,"xml");
        }
    }


    public static void genteratorHtml(String templateFile, Table table, Map result, String type) throws Exception {
        try {
            //创建一个合适的Configration对象
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(template_path));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Template template = configuration.getTemplate(templateFile + ".ftl");
            String fileName = "";
            if (templateFile.equals("service")) {
                fileName = table.getClassName() + "Service";
                fileName=save_path + "\\" + templateFile + "\\" + fileName + "." + type;
            } else if (templateFile.equals("IService")) {
                fileName = "I" + table.getClassName() + "Service";
                fileName=save_path + "\\" + templateFile + "\\" + fileName + "." + type;
            } else if (templateFile.equals("controller")) {
                fileName = table.getClassName() + "Controller";
                fileName=save_path + "\\" + templateFile + "\\" + fileName + "." + type;
            } else if (templateFile.equals("edit")) {
                fileName = table.getLowerClassName()+"//"+"to_edit_" + table.getTableName();
                File file=new File(save_path + "\\" +table.getLowerClassName()+"\\");
                if(!file.exists()){
                    file.mkdirs();
                }
                fileName=save_path + "\\" +fileName + "." + type;
            } else if (templateFile.equals("page")) {
                fileName = table.getLowerClassName()+"//"+table.getTableName() + "_page";
                File file=new File(save_path + "\\" +table.getLowerClassName()+"\\");
                if(!file.exists()){
                    file.mkdirs();
                }
                fileName=save_path + "\\" +fileName + "." + type;
            }else if (templateFile.equals("mapper")) {
                fileName = table.getLowerClassName();
                fileName=save_path + "\\" + templateFile + "\\" + fileName + "." + type;
            }
            Writer writer = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8");
            template.process(result, writer);
            System.out.println("恭喜，生成成功~~");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public static List<Table> queryTables() {
        final String DBDRIVER = "com.mysql.jdbc.Driver";
        //连接地址是由各个数据库生产商单独提供的，所以需要单独记住
        final String DBURL = "jdbc:mysql://210.16.190.9:3306/sq_skxd";
        //连接数据库的用户名
        final String DBUSER = "sq_skxd";
        //连接数据库的密码
        final String DBPASS = "fanlixia520";
        DatabaseMetaData dmd = null;
        Connection conn = null; //表示数据库的连接对象
        //列名
        List<Table> tables = new ArrayList<Table>();
        try {
            Class.forName(DBDRIVER); //1、使用CLASS 类加载驱动程序
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); //2、连接数据库
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
            while (resultSet.next()) {
                Table table = new Table();
                table.setCloumns(new ArrayList<Cloumn>());
                String tableName = resultSet.getString("TABLE_NAME");
                table.setTableName(tableName);
                table.setLowerClassName(lowerName(getCloumnName(tableName)));
                table.setClassName(captureName(getCloumnName(tableName)));

                ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
                System.out.println("表名：" + tableName + "\t\n表字段信息：");
                while (rs.next()) {
                    Cloumn cloumn = new Cloumn();
                    cloumn.setCloumn_Name(rs.getString("COLUMN_NAME"));
                    cloumn.setCloumnName(getCloumnName(rs.getString("COLUMN_NAME")));
                    cloumn.setRemark(rs.getString("REMARKS"));
                    cloumn.setType(rs.getString("TYPE_NAME"));
                    table.getCloumns().add(cloumn);
                }
                tables.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tables;
    }

    public static String getCloumnName(String strFieldName) {
        int indx = strFieldName.indexOf("_");
        int count = 0;
        while (indx != -1) {
            count++;
            strFieldName = captureName(strFieldName, indx + 1);
            indx = strFieldName.indexOf("_", indx + count);
        }
        return strFieldName.replaceAll("_", "");
    }

    /**
     * 某位置字母大写
     *
     * @param name
     * @param indx
     * @return
     */
    public static String captureName(String name, int indx) {
        name = name.substring(0, indx) + name.substring(indx, indx + 1).toUpperCase() + name.substring(indx + 1);
        return name;
    }

    /**
     * 首字母大写
     *
     * @param name
     * @return
     */
    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }

    public static String lowerName(String name) {
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
        return name;
    }


}