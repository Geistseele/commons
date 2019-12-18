package com.kcmpts.commons;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;


/**
 * @author klauszong
 */
@SuppressWarnings("unused")
public class Common {


    /**获取异常堆栈信息
     * @param throwable 异常
     * @return 字符串
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }

    /**
     * 生产uuid
     *
     * @return 返回UUID字符串
     */
    public static String generateUuid() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "").toLowerCase();
    }

}
