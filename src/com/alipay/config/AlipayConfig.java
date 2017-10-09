package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016080500175406";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQD04ltMJ/xo5KfyZ0bvadnoRYcXLtF8IAapD6Q2t9v8vDCZvVcc0YaoYYYx/jw1zjOA4z0+iJ+5Cb5nYNoSguoyzxzyxo+GRUCGB6MsTklDCMBVpZVYsK04fGsTRSQOR9SGx6ihZ1Go2466CA/AURwAm+BP6sXCS8FdOBUPotf5TLUBpEkfDvuKTwGcjbZ/2uiMHNSX6cWFxRPoDNJgbKI7oTK3vJmO6GKGbKTazIiTjreWOigBshgXK40a5sKaYvAajnhz3tMIwIuF5+o/DWvMW2xFPndKgX4QTzuqGIhwN9Vb0nZckljEcNsmqOPE/iKmKc87e/GOaikprM8Sf62tAgMBAAECggEBAJXz4hoRRjPpCJqb+UjzlXbw1Fcy2R5b8hgmNtU24uOxTUVnNuezufRzu5vzZWVBPjKHc+JOARhqygg9u2uodMbmIoDba9m5oFgyZw3jZmNBAZ2whnJHxdqX/W1QYlLIU3Cw5CbpwIxY3d42v4ZxZGdPDB2D0tM2VlLB28u2WPATgQHPCrYHaT7zkkPwInK8HTAaPdKD5amk6Pel+Re4VHzLWjRemXxbtBRzWbLpQsGUd6TZN9jsICH2OPESNdXa0GiS6OBJ83nBycWlg8mZNAwL9ysBja9vUXaUeKjdTpzOtMtLyd1C7RytbioSXo6Lre4V46kZtgWQ50SNcIU7XLUCgYEA++XMJ+rKjslXzrHspp074Hq85qdK/pOMtuM2P3tpL8nRf4GIUhxnhvC1nf9KuBTsgkPO7intqvvYYxQkvsOtCe/vGcp9a1U1Tx/1/LdMar0xpgWKtExd7hX4QxepV1ZzqVWnexp54NxdqsEafCyCXF3pbnCUxeEfCbs7fczAincCgYEA+N9Rp5/RelhoJWB2JBUTjYR2v30id2BIGmRVdLeL/zYpS2zoBIzCMJXgyJH2bTlXopTQQPrsN/5ksc9rCva5IA+RE+QOf0/x99Ux4cxjBeL5mrlvvkQREe1nP7qUCnYvTiVbpy5kUEg0ZLB+oAg7MH1QZczdizPKgh0CQbjnLfsCgYBONKM0xW2L9TDgyFa7x9c+M30Qc2ISNccbROGjxfH7V0JGvvWO4Ki3uWX5nrgY/M4NB3ZodPYH/tbItAlQfLnteuOV80sLFtJNNZQOmO4NuZ1/ePr+TTNgZsvEMMVvizSvnxs3Whn62Q/vorJRWRREDxgZJLTb1q/nOo0W2onwswKBgQCsTvobA6UmfxVEY6AIZWtPPRp2hC4b1ta1JyifkgFk5tv6c+HEXKyKtQqX869Zei05zKzPgKuSLRkMnx5uzdno375Dtk9vSCuwurQ5sKgSyE6nGKLMahYjgmpNDmI3SBKCmYz2mEEt8IAOAsD5Dhnk/a5vfUMagPZB1dHdLScqhwKBgAlKNPyHrg9Hv16Y3iiVo+ijpGbjb0TMr8Nr4V/bjxA1NL/4TzVA3rP/8gOFyXdTHSbDjZSUudMZj4rYpfXjcMnuYNOj7a6A1XwPpVe0IsjOWKc2wj7slNcEduJlmEQd2+CXo91H3k0AvTejBeUrGIBlfSbcUmhXPtdZ9Lro769W";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2sVI1d0hhtxh0ei2U8QKUPOA3phhHQtSCiR5+yhCwxEqaPisxk6vAaYnAt5ZkxhekzFuy2RaHpL9BwYQwBk+RZrTXQ5ByU2D1c+4y6AGizwzDwxiQyQFoY4TfDVDgfANnFDHVElnTsUIfdJ9xm+V9G+scI25uzijoW/EaB1ohqyG/qtqgCSmKFgJ/PL5Hk7hMkXieTywE/pIRNdLZnkxcr+CMbtBqMr6FfHMGqWZStW3zLp1EP5JC+Y8XzTh/61JxnT9uQmb/CsBV0/OJcGQcPLP/FsX8GOBrDMbME508i7cRplOENFYZnQML9AL2CyPk9gNjQ/wFnkro2+WY93npwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://6074f190.ngrok.io/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://6074f190.ngrok.io/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/home/amzing/template/alipay/";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


