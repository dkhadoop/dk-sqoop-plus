# dk-sqoop-plus
本项目在原生sqoop 的基础上进行更多实用功能的扩展。

项目编译及sqoopo使用参见原生sqoop。

下面列举其扩展功能的使用：

1. RDBMS  to  Elasticsearch
  在其安装目录下执行 ：  bin/sqoop import --connect jdbc:oracle:thin:@192.168.1.35:1521:orcl --username system --password dkss --table DK10 -m 1 --target-dir 192.168.1.99:9200@dkes@dksqoop2/oracle  
  执行命令说明：
    sqoop import  #固定，默认
    --connect jdbc:oracle:thin:@192.168.1.35:1521:orcl  #为RDBMS数据库的连接信息  (如oracle , mysql , sqlserver)
    --username system  #RDBMS数据库用户名
    --password dkss    #RDBMS数据库密码
    --table DK10       #RDBMS要导入到elasticsearch的数据库表
    -m 1               #指定导入时产生的线程的数量。注意：如果RDBMS数据库表中没有主键，则-m的值只能是1
    --target-dir 192.168.1.99:9200@dkes@dksqoop2/oracle  #--target-dir的值包含三部分由“@”分隔，“@”前一部分192.168.1.99:9200为指定elasticsearch的主机地址和端口号，“@”中间一部分dkes为elasticsearch的集群名称,“@”后一部分dksqoop2/oracle包含两部分，由“/”分隔，“/”前一部分dksqoop2为elasticsearch的索引名称，“/”后一部分oracle为elasticsearch的类型名称。

2. HDFS to  Elasticsearch
  在其安装目录下执行 ：  bin/sqoop export --connect "es@192.168.1.126:9200@elasticsearch@hdfs/sqoop"  --export-dir aaa --fields-terminated-by '@' -m 1
    执行命令说明：
      sqoop export  #固定，默认
      --connect "es@192.168.1.126:9200@kes@hdfs/sqoop"   #--connect的值包含四部分由“@”分隔,第一部分es为固定默认值，第二部分192.168.1.126:9200为       连接elasticsearch的主机地址和端口，第三部分dkes为elasticsearch的集群名称，第四部分hdfs/sqoop为elasticsearch的索引名/类型名。
      --export-dir aaa            #指的是要导出的hdfs文件所在的目录。
      --fields-terminated-by '@'  #--fields-terminated-by指的是hdfs文件内容各字段间的字段分隔符，如果不指定则默认为','分隔。
      -m 1               #指定导入时产生的线程的数量。线程数不能小于文件内容的记录条数。




