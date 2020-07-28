# xxl-job-sql
本项目包含了XXL-JOB数据自动导入任务的相关代码。要开发一个XXL-JOB的数据自动导入任务，只需在官方给出的Spring Boot样例的基础上，用本项目代码替换或更改`pom.xml`、`application.properties`、`XxlJobConfig.java`，并在`jobhandler`中增加`SqlJobHandler.java`。`DemoDB.sql`创建样例数据库，`example.json`是样例的任务参数，用于测试。

`DemoDB.sql`: 创建样例数据库用的SQL脚本。

`SqlJobHandler.java`: 基于BEAN模式（类形式）开发的数据自动导入任务。需加到`com.xxl.job.executor.service.jobhandler`中。

`XxlJobConfig.java`: 配置执行器的代码。增加了将`sqlJobHandler`注入到执行器容器的代码。

`application.properties`: Spring Boot执行器样例的配置文件。增加了数据库相关的配置。

`example.json`: 任务参数样例，用于测试。包含`businessDate`，`executeSql`和`prepareSql`。

`pom.xml`: 增加了JSON以及数据库相关的共3个依赖。
