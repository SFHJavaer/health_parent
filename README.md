### 医院健康服务后台管理系统
##### 该项目是一款应用于健康管理机构的业务系统，基于SSM框架进行开发，包括会员服务、预约管理、体检报告、健康评估、工作量分析、短信业务对接等多个模块，实现了健康管理机构工作内容可视化、患者管理专业化、健康评估数字化、 健康干预流程化、知识库集成化。

###### 技术栈及所应用的位置：

> 前端： ● HTML5 ● bootstrpt ● vue ● elementUI ● ajax
> <br>
> 后台：● Zk+Dubbo ● Spring+SpringMVC+Mybatis ● Spring security ● Mysql+Redis ● POI ● OSS ● SMS ● Git ● Echarts

##### 开发流程：
###### 采用Zookeeper+Dubbo的分布式高可靠性集群的服务注册中心方案<br>
###### 利用Maven构建项目，基于SSM三层架构实现后端的业务开发与数据库交互<br>
###### 前端使用axios发送异步请求，同时通过Spring整合Freemarker来生成移动端的静态页面，从而降低服务器动态的请求负载<br>
###### Apache POI框架实现Excel报表，利用第三方所提供的SMS和OSS服务来完成短信调用和图片对象存储<br>
###### 利用Quartz调度框架实现上传图片数据的定时清理任务，使用Mysql作为后台数据库，Redis作为短信缓存<br>
###### 基于Spring Security实现权限控制和登陆验证，利用Echarts显示用户数据与工作量数据的可视化。<br>
