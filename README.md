Hive UDF 开发Demo

步骤：
1. pom.xml 添加依赖；
2. 继承UDF类，实现evaluate()方法；
3. 打包jar，mvn package
4. 将jar上传至HDFS；
5. Hive中创建方法：
```sql
-- 永久创建则删除 TEMPORARY。<函数名称> AS <Java package.类名>
CREATE TEMPORARY FUNCTION get_birthday AS 'get_birthday' 
USING jar 'hdfs:///user/home/rongfeilong/tmp/hiveudf-test.jar';
```
6. 使用。

