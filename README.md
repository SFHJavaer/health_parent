# 🏥 医院健康服务后台管理系统

[![Java](https://img.shields.io/badge/Java-8+-blue.svg)](https://java.oracle.com/)
[![Spring](https://img.shields.io/badge/Spring-5.0.5-green.svg)](https://spring.io/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-orange.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 项目简介

该项目是一款专为健康管理机构设计的综合业务系统，基于现代分布式架构开发。系统涵盖会员服务、预约管理、体检报告、健康评估、工作量分析、短信业务对接等多个核心模块，致力于实现健康管理机构工作流程的全面数字化转型。

### ✨ 核心特性

- 🔐 **安全可靠**：基于Spring Security的权限控制和登录验证体系
- 📊 **数据可视化**：集成ECharts实现用户数据和工作量数据的可视化展示
- 📱 **多端适配**：支持PC端管理后台和移动端应用
- 📈 **业务完整**：涵盖体检预约、报告管理、健康评估等完整业务流程
- 🏗️ **架构优良**：采用分布式微服务架构，支持高并发和高可用
- 📋 **报表丰富**：支持Excel报表导出，满足各类统计分析需求

## 🛠️ 技术架构

### 后端技术栈

- **核心框架**：Spring 5.0.5 + SpringMVC + MyBatis 3.4.5
- **分布式服务**：Zookeeper 3.4.7 + Dubbo 2.6.0
- **安全框架**：Spring Security 5.0.5
- **数据库**：MySQL 8.0.11 + Redis (缓存)
- **消息队列**：Spring JMS
- **定时任务**：Quartz 2.2.1
- **文件处理**：Apache POI 3.14 (Excel报表)
- **对象存储**：七牛云OSS
- **短信服务**：第三方SMS集成
- **模板引擎**：FreeMarker

### 前端技术栈

- **基础技术**：HTML5 + CSS3 + JavaScript
- **UI框架**：Bootstrap + ElementUI
- **前端框架**：Vue.js
- **异步请求**：Axios + Ajax
- **图表库**：ECharts

## 🏗️ 系统架构

```
health_parent/
├── health_common/           # 通用模块
├── health_interface/        # 接口定义
├── health_service_provider/ # 服务提供者
├── health_backend/          # 管理后台
├── health_mobile/           # 移动端应用
├── freemarkertest/          # FreeMarker测试
└── quartzdemo/              # Quartz演示
```

### 架构特点

- **分布式设计**：基于Dubbo的微服务架构
- **服务治理**：Zookeeper作为服务注册中心
- **模块化开发**：按功能划分独立模块
- **前后端分离**：RESTful API设计
- **缓存策略**：Redis缓存热点数据
- **安全认证**：统一的安全认证体系

## 🚀 主要功能

### 👥 用户管理
- 用户注册登录
- 权限角色管理
- 用户信息维护

### 📅 预约管理
- 体检套餐管理
- 预约时间设置
- 预约状态跟踪

### 🏥 体检管理
- 检查项目管理
- 检查组管理
- 套餐组合配置

### 📋 报告管理
- 体检报告生成
- 报告模板管理
- 报告导出功能

### 📊 统计分析
- 用户数据统计
- 工作量分析
- 图表可视化展示

### 📱 移动端服务
- 移动端页面生成
- 在线预约功能
- 报告查询服务

## 📋 环境要求

| 组件 | 版本要求 | 说明 |
|------|----------|------|
| JDK | 1.8+ | Java开发环境 |
| Maven | 3.6+ | 项目构建工具 |
| MySQL | 8.0+ | 数据库 |
| Redis | 3.0+ | 缓存服务 |
| Zookeeper | 3.4+ | 服务注册中心 |
| Tomcat | 8.0+ | 应用服务器 |

## 🏃‍♂️ 快速开始

### 1. 环境准备

```bash
# 克隆项目
git clone https://github.com/your-username/health_parent.git
cd health_parent

# 配置数据库
# 创建数据库health_db
# 导入项目中的SQL脚本
```

### 2. 配置修改

```bash
# 修改数据库配置
# 文件: health_parent/health_service_provider/src/main/resources/spring-dao.xml

# 修改Redis配置
# 文件: health_parent/health_service_provider/src/main/resources/spring-redis.xml

# 修改Zookeeper配置
# 文件: health_parent/health_service_provider/src/main/resources/spring-service.xml
```

### 3. 项目构建

```bash
# 编译项目
mvn clean compile

# 打包项目
mvn clean package

# 跳过测试打包
mvn clean package -DskipTests
```

### 4. 部署运行

```bash
# 启动Zookeeper服务
# 启动Redis服务
# 启动MySQL服务

# 部署服务提供者
# 部署管理后台
# 部署移动端应用
```

## 📁 项目结构说明

```
health_parent/                    # 父项目
├── health_common/               # 通用模块
│   ├── src/main/java/com/       # 通用工具类
│   └── pom.xml
├── health_interface/            # 接口定义
│   ├── src/main/java/com/       # 服务接口
│   └── pom.xml
├── health_service_provider/     # 服务提供者
│   ├── src/main/java/com/       # 服务实现
│   ├── src/main/resources/      # 配置文件
│   └── pom.xml
├── health_backend/              # 管理后台
│   ├── src/main/java/com/       # 控制器层
│   ├── src/main/resources/      # 配置文件
│   └── src/main/webapp/         # 前端资源
├── health_mobile/               # 移动端应用
│   ├── src/main/java/com/       # 移动端接口
│   └── src/main/webapp/         # 移动端页面
├── freemarkertest/              # FreeMarker测试
└── quartzdemo/                  # Quartz演示
```

## 🔧 开发指南

### 开发流程

1. **服务开发**：在`health_interface`中定义接口
2. **服务实现**：在`health_service_provider`中实现服务
3. **Web开发**：在`health_backend`或`health_mobile`中开发控制器
4. **前端开发**：在相应模块的webapp目录中开发页面

### 代码规范

- 遵循阿里巴巴Java开发规范
- 使用Maven进行依赖管理
- 统一UTF-8编码
- 模块间通过Dubbo进行通信

## 📈 性能优化

- **缓存策略**：使用Redis缓存热点数据
- **数据库优化**：使用Druid连接池
- **静态化处理**：使用FreeMarker生成静态页面
- **异步处理**：使用消息队列处理耗时任务
- **定时任务**：使用Quartz处理定时清理任务

## 🤝 贡献指南

1. Fork 本仓库
2. 创建特性分支：`git checkout -b feature/AmazingFeature`
3. 提交更改：`git commit -m 'Add some AmazingFeature'`
4. 推送分支：`git push origin feature/AmazingFeature`
5. 提交 Pull Request

## 📄 开源协议

本项目采用 [MIT License](LICENSE) 开源协议。

## 📞 联系我们

如有问题或建议，请通过以下方式联系：

- 📧 邮箱：your-email@example.com
- 🐛 提交 Issue
- 📖 查阅文档

---

**注意**：本项目仅供学习和研究使用，请勿用于商业用途。
