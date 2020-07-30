# xxl-job-sql
本项目包含了XXL-JOB数据自动导入任务的相关代码。要开发一个XXL-JOB的数据自动导入任务，只需在官方给出的Spring Boot样例的基础上，用本项目代码替换或更改`pom.xml`、`application.properties`、`XxlJobConfig.java`，并在`jobhandler`中增加`SqlJobHandler.java`、`PrepareSqlJobHandler.java`、`ExecuteSqlJobHandler.java`。`DemoDB.sql`创建样例数据库，`example.json`是样例的任务参数，用于测试。

`pom.xml`: 增加了JSON以及数据库相关的共3个依赖。

`application.properties`: Spring Boot执行器样例的配置文件。增加了数据库相关的配置。

`XxlJobConfig.java`: 配置执行器的代码。增加了将`sqlJobHandler`、`prepareSqlJobHandler`、`executeSqlJobHandler`注入到执行器容器的代码。

`SqlJobHandler.java`: 基于BEAN模式（类形式）开发的数据自动导入任务。执行`prepareSql`和`executeSql`。需加到`com.xxl.job.executor.service.jobhandler`中。

`PrepareSqlJobHandler.java`: 基于BEAN模式（类形式）开发的任务。执行`prepareSql`。`ExecuteSqlJobHandler.java`中的分片任务是其子任务。需加到`com.xxl.job.executor.service.jobhandler`中。

`ExecuteSqlJobHandler.java`: 基于BEAN模式（类形式）开发的分片任务。执行`executeSql`。需加到`com.xxl.job.executor.service.jobhandler`中。

`DemoDB.sql`: 创建样例数据库用的SQL脚本。

`example.json`: 任务参数样例，用于测试。包含`businessDate`，`prepareSql`和`executeSql`。

说明：`SqlJobHandler.java`不支持分片任务，作为参数的JSON需包含`businessDate`，`prepareSql`和`executeSql`。`PrepareSqlJobHandler.java`只执行`prepareSql`，作为参数的JSON需包含`businessDate`和`prepareSql`。`ExecuteSqlJobHandler.java`支持分片任务，只执行`executeSql`，作为参数的JSON需包含`businessDate`和`executeSql`，分片处理时`executeSql`中应有分片参数`${index}`和`${total}`。
