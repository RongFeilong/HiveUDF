

import org.apache.hadoop.hive.ql.exec.UDF;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Demo: 从18位身份证号码中获取生日
public class get_birthday extends UDF{
    public String evaluate(String ID, String format){
        // input parameter validate
        if(null == ID){
            return null ;
        }
        String str = ID.substring(6, 14);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate dt = LocalDate.parse(str, ft);
        return dt.format(formatter);
    }

    public static void main(String[] args) {
        System.out.println(new get_birthday().evaluate("45123419900609202X", "yyyy-MM-dd"));
        System.out.println(new get_birthday().evaluate("45123419900609202X", "yyyy-MM"));
        System.out.println(new get_birthday().evaluate("45123419900609202X", "yyyyMMdd"));
        System.out.println(new get_birthday().evaluate("45123419900609202X", "yyyyMM"));
    }
}