## 一、SpringCloud:

### 1、微服务概述

#### 1）**为什么要使用微服务架构？**

如今微服务架构越来越流行，被广泛应用在各行各业中，作为一线的开发人员其实也能深切感受到微服务热点，各大技术社区都会出现有关微服务架构的探讨。但究竟什么是微服务架构，使用微服务架构会给我们带来什么样的改变，本节专栏为大家揭开谜底。

说起微服务架构，我们先从它的发展由来、历史背景开始了解。



**微服务诞生的历史背景**

微服务的诞生并非偶然，它是在互联网高速发展、技术变化日新月异以及传统架构无法适应快速变化等多重因素共同推动下诞生的产物。

大约从 2009 年开始，Netflix 完全重新定义了它的应用程序开发和操作模型，拉开了微服务探索的第一步。直到 2014 年 3 月，Martin Fowler 写的一篇文章 《Microservices》以更加通俗易懂的形式为大家定义了什么是微服务架构。

互联网时代的产品通常有两类特点：需求变化快和用户群体庞大。在这种情况下，如何从系统架构的角度出发，构建灵活、易扩展的系统，快速应对需求的变化；同时，随着用户的增加，如何保证系统的可伸缩性、高可用性，成为系统架构面临的新挑战。

如果还按照以前传统开发模式，开发一个大而全的系统已经很难满足市场对技术的需求。这时候分而治之的思想被提了出来，于是我们从单体架构发展到分布式架构，又从分布式架构发展到 SOA 架构，服务不断地被拆分和分解，粒度也越来越小，直到微服务架构的诞生。

当服务越来越小的时候，必然会面临其它很多问题，比如服务之间的调用更加频繁，服务的偶尔不可用变成常态。面对这些挑战，我们必须需要重新来构建一套技术来支持微服务架构。这套技术需要具备高可用、请求重试、熔断、容错、调用过程可监控等特性，当解决了这些问题后，微服务应运而生。



**什么是微服务**

简单来说，微服务架构是一种将一个单一应用程序开发为一组小型服务的方法。每个服务运行在其独立的进程中，服务与服务间采用轻量级的通信机制互相沟通（通常是基于 HTTP 的 RESTful API）。

每个服务都围绕着具体业务进行构建，并且能够被独立地部署到生产环境、类生产环境等。另外，应尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据业务上下文，选择合适的语言、工具对其进行构建。

微服务架构是一种架构模式，它提倡将单一应用程序划分成一组小的服务，服务之间互相协调、互相配合，为用户提供最终价值，一个大型复杂软件应用由一个或多个微服务组成。系统中的各个微服务可被独立部署，各个微服务之间是松耦合的。每个微服务仅专注于完成一件任务并很好地完成该任务。在所有情况下，每个任务代表着一个小的业务能力。

微服务架构是 SOA 架构的传承，但一个最本质的区别就在于微服务是真正分布式的、去中心化的。把所有的 “思考” 逻辑包括路由、消息解析等放在服务内部，去掉一个大一统的 ESB，服务间轻通信，是比 SOA 更彻底地拆分。微服务架构强调的重点是业务系统需要彻底的组件化和服务化，原有的单个业务系统会拆分为多个可以独立开发、设计、运行和运维的小应用，这些小应用之间通过服务完成交互和集成。
![图片描述](https://img1.sycdn.imooc.com/5d00b45f00014b5908500520.png)
传统架构和微服务架构对比，图片来自文章《 Microservices》。



**微服务架构的优势**

相比传统架构模式，微服务架构具有以下几方面的优势：

- 复杂度可控：在将应用分解的同时，规避了原本复杂度无止境的积累。每一个微服务专注于单一功能，并通过定义良好的接口清晰表述服务边界。由于体积小、复杂度低，每个微服务可由一个小规模开发团队完全掌控，易于保持高可维护性和开发效率；
- 独立部署：由于微服务具备独立的运行进程，所以每个微服务也可以独立部署。当某个微服务发生变更时，无需编译、部署整个应用。由微服务组成的应用相当于具备一系列可并行的发布流程，使得发布更加高效，同时降低对生产环境所造成的风险，最终缩短应用交付周期；
- 技术选型灵活：微服务架构下，技术选型是去中心化的。每个团队可以根据自身服务的需求和行业发展的现状，自由选择最适合的技术栈。由于每个微服务相对简单，故需要对技术栈进行升级时所面临的风险就较低，甚至完全重构一个微服务也是可行的；
- 容错：当某一组件发生故障时，在单一进程的传统架构下，故障很有可能在进程内扩散，形成应用全局性的不可用。在微服务架构下，故障会被隔离在单个服务中。若设计良好，其他服务可通过重试、平稳退化等机制实现应用层面的容错；
- 扩展：单块架构应用也可以实现横向扩展，就是将整个应用完整复制到不同的节点。当应用的不同组件在扩展需求上存在差异时，微服务架构便体现出其灵活性，因为每个服务可以根据实际需求独立进行扩展。



**使用 Spring Cloud 开发微服务的优势**

Spring Cloud 诞生时，正处于微服务概念在慢慢酝酿中。Spring Cloud 的研发融合了微服务架构的理念，实现了在 Java 领域内微服务架构落地的技术支撑，结合着 Spring Boot 相关特性，提供了基础组件一键式启动和部署能力，极大地简化了微服务架构的技术落地。

Spring Cloud 从设计之初就考虑了分布式架构演化所需的功能，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等。这些功能都是以插拔的形式提供出来，方便我们在系统架构演进的过程中，可以合理选择需要的组件进行集成，从而在架构演进的过程中会更加平滑、顺利。

Spring Cloud 提供的功能，完美地解决了微服务实施过中可能会遇到的困难。对比业内相关框架，在微服务领域 Spring Cloud 目前还没有真正的对手，从某种程度来讲 Spring Cloud 已经成为了微服务落地的技术标准。

微服务是为了解决项目快速变化、快速迭代的痛点，以及架构自然演进所诞生的一种架构解决方案。Spring Cloud 是微服务解决方案的技术落地。可以预见的是，未来微服务架构将会被越来越多的公司所采纳，同时 Spring Cloud 的应用范围也会越来越广泛，因此越早学习受益越大。

微服务架构的诞生有着历史的必然性。随着互联网的不断迅速发展，原有的系统架构不断在接受着新的挑战，并发数超过几万、项目参与人数超过千人的项目也越来越多。如果在大规模系统协作下，如何保持系统的稳定性、可快速迭代性就变得非常紧迫。微服务架构便是在这样的历史背景下诞生，提供了一套大型项目开发的解决方案。

随着越来越多的公司采用微服务架构，可以预见的是，在未来微服务架构必将会成为 IT 行业最流行的系统架构。

#### 2）Spring Cloud 介绍

这些年 Spring Cloud 作为 Spring 官网重点推荐的产品，在社区内使用度越来越广泛。18 年伴随着几次子框架停更事件，引发了技术社区的担心和大讨论，但其实 Spring Cloud 并没有受到这件事情的影响，反而发展越来越好，这是为什么呢？本节专栏为大家介绍这些有关 Spring Cloud 的趣事。



**Spring Cloud 是什么？**

Spring Cloud 是一系列框架的有序集合。Spring Cloud 内部包含了众多框架，这些框架相互协调构建分布式系统。Spring Cloud 构建在 Spring Boot 的基础上，利用了 Spring Boot 诸多特性简化了分布式系统基础设施的开发，让基础框架都可以做到一键启动和部署，使开发人员能够很容易地开始工作，并快速提高生产效率。

Spring Cloud 提供了快速构建分布式系统中一些常见模式的工具，例如配置管理、服务发现、断路器、智能路由、微代理、控制总线。利用好 Spring Cloud 相关工具，开发人员可以快速实现这些模式的服务和应用程序。Spring Cloud 为最常见的分布式系统模式提供了一个简单、可访问的编程模型，帮助开发人员构建弹性、可靠和协调的应用程序，让开发人员使用 Spring Cloud 部署分布式系统简单而又不容易出错。

**Spring Cloud 特性**

Spring Cloud 致力于为典型用例提供良好的开箱即用体验，并提供覆盖其他用例的可扩展性机制，下面为它的核心特性：

- 分布式 / 版本化配置
- 服务注册和发现
- 路由
- 服务与服务之间的调用
- 负载均衡
- 断路器
- 分布式消息

我们用一张 Spring 官网的图，来展示这些核心组件之间是如何相互配合运行的：

![图片描述](https://img1.sycdn.imooc.com/5d00b63d00011a5a06960332.png)

1、外部物联网设备、手机或者浏览器统一通过服务网关来访问内部服务，服务网关负责分发到具体服务

2、服务运行过程中通过分布式配置中心获取相关配置信息

3、多次调用失败服务会进入断路器

4、服务与服务之间通过注册中心来相互调用

5、通过分布式链路跟踪来查看调用链

6、服务通过 Message Broker 来传递消息

7、服务运行过程中的数据保存在数据库中

8、通过页面可以监控服务熔断、配置信息、服务调用和链路跟踪等信息



**Spring Cloud 命名故事**

我们知道 Spring Cloud 本身并不是一个框架，是一系列框架的有序集合，每个子项目有不同的发行节奏，都维护着自己的发布版本号。如果 Spring Cloud 也按照传统的方式命名，就难免与子项目的发布号混淆，所以没有采用版本号的方式，而是使用了另外一种命名方式。

这些版本名称的命名方式采用了伦敦地铁站的名称，同时根据字母表的顺序来对应版本时间顺序，比如：最早的 Release 版本：Angel，第二个 Release 版本：Brixton，然后是 Camden、Dalston、Edgware、Finchley，目前最新的是 Greenwich 版本。平时为了方便会以首字母来简称 Spring Cloud 的版本，比如 Angel 就是 A 版本，最新的 Greenwich 简称它为 G 版本。

> 注意: Angel 和 Brixton 两个版本已于 2017 年 7 月终止不再进行维护。

同时在这些大版本命名之后，我们还会经常看到 M、RC、SR 等小版本，在此也给大家解释一下：

- M 是 milestone（里程碑）的缩写，代表了项目开发到达一个关键的里程碑，一般在开发过程中会经历很多个里程碑，所以会有 M1、M2 这样的命名；
- RC 是 Release Candidate（候选人）的缩写，代表了项目处于候选版本的状态，大多用在正式版本发布之前的一个阶段，因此也会有 RC1、RC2 这样的命名；
- SR 是 Service Release 的缩写，代表了项目发布正式稳定的版本，一般等同于 GA 版本：(GenerallyAvailable)。SR1 表示第 1 个正式版本，后面依次累加数字，会有 SR2、SR3 这样的命名；
- SNAPSHOT 快照版本，可以稳定使用，且仍在继续改进版本。

在一般的版本发布过程中会先发布 M 版本，再发布 RC 版本，最后发布 SR 版本。目前 Spring Cloud 的最新版本是 Greenwich.SR1，也就是 G 版本发布的第一个稳定版本，这也是我们本专栏课程采用的版本。



**Spring Cloud 停更风波**

Spring Cloud 并没有重复制造轮子。早期为了快速上线充分发挥了开源社区的力量，集成了业内诸多成熟的开源框架，其中就包含了 Netflix 开源的诸多产品，其中就有 Eureka、Hystrix、Zuul、Ribbon 等。

2018 年 6 月突然传来消息，Eureka 2.0 停止开发，如果将 Eureka 2.0 用于生产，将后果自负。这个消息传开之后一度引发了大家对使用 Eureka 的恐慌，但其实真正使用 Eureka 2.0 的公司几乎没有，大家使用的都是 Eureka 1.X 系列，并不受到影响。另外 Spring Cloud 还有很多其它子框架来替代 Eureka 的使用，比如比较流行的 Consul、Zookeeper 等。

到了 2018 年的 11 月，Netflix 团队突然宣布 Hystrix 停止开发新版本，但仍然会维护后期可能出现的 Bug；其实除了 Hystrix 外， Spring Cloud 体系内同样存在几款替代框架，比如 Resilience4J、Sentinel 等。

到目前为止 Netflix 已经有多款都处于维护状态。在今年 1 月 Greenwich 版本发布时，以下 Netflix 产品都处于维护状态。

- spring-cloud-netflix-archaius
- spring-cloud-netflix-hystrix-contract
- spring-cloud-netflix-hystrix-dashboard
- spring-cloud-netflix-hystrix-stream
- spring-cloud-netflix-hystrix
- spring-cloud-netflix-ribbon
- spring-cloud-netflix-turbine-stream
- spring-cloud-netflix-turbine
- spring-cloud-netflix-zuul

并不包含 Eureka 和并发限制相关模块。

但一系列停更事件，也间接地反应了 Netflix 公司对开源软件的支持面临着不确定性，因此 Spring Cloud 在最新发布的 Greenwich 版本中，建议替换掉 Netflix 的几款相关组件：

| 现在的                      | 替换的                                            |
| :-------------------------- | :------------------------------------------------ |
| Hystrix                     | Resilience4j                                      |
| Hystrix Dashboard / Turbine | Micrometer + Monitoring System                    |
| Ribbon                      | Spring Cloud Loadbalancer                         |
| Zuul 1                      | Spring Cloud Gateway                              |
| Archaius 1                  | Spring Boot external config + Spring Cloud Config |

本系列专栏会一一介绍上述建议替换的框架使用。



**Spring Cloud 发展前景**

2015 年 6 月 Spring Cloud 发布了第一个正式版本 Angel.SR1，到现在已经过去了快四年。在这四年时间中 Spring Cloud 从一个新生的框架，慢慢成长为微服务领域事实上的标准，在开源社区的知名度也越来越高，我们从 Spring Cloud 的百度指数也可以看出这个趋势。
![图片描述](https://img1.sycdn.imooc.com/5d00b6540001dba123560978.png)

上图为 2015 年到现在的 Spring Cloud 百度指数，其中掉下来的点是中国的春节。也可以明显地看出， 2019 年，社区对 Spring Cloud 的关注度更一步地提高。

随着 Spring Cloud 的不断发展，去年 2018 年 10 月，国内巨头阿里巴巴宣布正式入驻 Spring Cloud 官方孵化器。并且在加入不久后就贡献了几个重量级的框架，其中就有大名鼎鼎的 Sentinel、Nacos 以及阿里本身几款和微服务相关的中间件产品，关于阿里巴巴和 Spring Cloud 的相关内容本期专栏在后期也会详细介绍。

Spring 官方也非常重视 Spring Cloud 的后续发展，已经将它作为公司最顶级的项目来推广，放到了官网上最核心的位置。从近几期 Spring Cloud 大版本的发布频率，也能感受到 Spring 官方对 Spring Cloud 的重视， 相信未来 Spring 官方会继续投入更多的力量来发展 Spring Cloud 。

![图片描述](https://img1.sycdn.imooc.com/5d00b6840001da4a19621096.png)
从上述来看，不论是官方的重视程度、社区内的关注度，还是各大巨头对 Spring Cloud 的参与度来讲，Spring Cloud 的未来发展必定会越来越好。

Spring Cloud 对于中小型互联网公司来说是一种福音，因为这类公司往往没有实力或者没有足够的资金投入去开发自己的分布式系统基础设施，使用 Spring Cloud 一站式解决方案能在从容应对业务发展的同时大大减少开发成本。

同时，随着近几年微服务架构和 Docker 容器概念的火爆，也会让 Spring Cloud 在未来越来越 “云” 化的软件开发风格中立有一席之地，尤其是在目前五花八门的分布式解决方案中提供了标准化的、全站式的技术方案，意义可能会堪比微服务规范的诞生，有效推进服务端软件系统技术水平的进步。

#### 3）Spring Boot 的设计理念

Spring Boot 设计之初就是为了以最少的配置、最快的速度来启动和运行 Spring 项目。Spring Boot 使用特定的配置来构建生产就绪型的项目。 Spring Boot 默认配置了很多框架的使用方式，就像 Maven 整合了所有的 Jar 包，Spring Boot 整合了所有的框架。

Spring Boot 的核心设计思想是：**约定优于配置**。

**约定优于配置**（convention over configuration），也称作按约定编程，是一种软件设计范式，旨在减少软件开发人员需做决定的数量，获得简单的好处，而又不失灵活性。

下图展示出 Spring Boot 在 Spring 生态中的位置：

![图片描述](https://img1.sycdn.imooc.com/5d00c0b80001be0b03790369.png)

该项目主要的目的是：

- 让 Spring 的开发更快更广泛地上手
- 使用默认方式实现快速开发
- 提供大多数项目所需的非功能特性，诸如：嵌入式服务器、安全、心跳检查、外部配置等

**Spring Boot 特性**

- 使用 Spring 项目引导页面可以在几秒构建一个项目
- 方便对外输出各种形式的服务，如 REST API、WebSocket、Web、Streaming、Tasks
- 非常简洁的安全策略集成
- 支持关系数据库和非关系数据库
- 支持运行期内嵌容器，如 Tomcat、Jetty
- 强大的开发包，支持热启动
- 自动管理依赖
- 自带应用监控
- 支持各种 IDE，如 IntelliJ IDEA 、NetBeans

项目结构如下：

![图片描述](https://img1.sycdn.imooc.com/5d00c0d700015c4908800487.png)

如上图所示，Spring Boot 的基础结构共三个文件:

- `src/main/java` 项目启动类和主要代码
- `src/main/resources` 配置信息目录
- `src/test/java` 测试程序

resources 目录下：

- static 目录存放 Web 访问的静态资源，如：js、css、图片等
- templates 目录存放页面模板
- `application.properties` 项目配置信息
- `pom.xml` 用于配置项目依赖包以及其它配置
- mvnw 文件 ，mvnw 全名是 Maven Wrapper。作用是当运行环境中找不到正确的 Maven 版本时，会自动下载 Maven 信息，之后再运行项目

使用 Spring Boot 开发项目的优势，又不仅仅局限于我们上面所看到的这些，它对研发的整个流程都进行了重构，在开发、部署、测试、运维方面均有优化，我们可以简单地提炼出几个核心优势：

- Spring Boot 使开发变简单，Spring Boot 提供了丰富的解决方案，快速集成各种解决方案提升开发效率；
- Spring Boot 使配置变简单，Spring Boot 提供了丰富的 Starters，集成主流开源产品往往只需要简单的配置即可；
- Spring Boot 使部署变简单，Spring Boot 本身内嵌启动容器，仅仅需要一个命令即可启动项目，结合 Jenkins 、Docker 自动化运维非常容易实现；
- Spring Boot 使监控变简单，Spring Boot 自带监控组件，使用 Actuator 轻松监控服务各项状态。

#### 4）Spring Cloud 和 Spring Boot 之间的密切关系

**Spring Boot Starter**

Spring Boot Starter 是 Spirng Boot **约定优于配置**理念的最佳实现。Spring Boot Starter 有两个核心组件：自动配置代码和提供自动配置模块及其它有用的依赖。也就意味着，当项目中引入某个组件的 Starter ，项目启动时就会针对此组件进行默认配置，从而达到“开箱即用”，一般情况下仅需要少量的配置或者不配置即可使用组件对应的功能。

Spring Boot 由众多 Starter 组成，随着版本的推移 Starter 家族成员也与日俱增。在传统 Maven 项目中通常将一些层、组件拆分为模块来管理，以便相互依赖复用，在 Spring Boot 项目中我们则可以创建自定义 Spring Boot Starter 来达成该目的。

因此 Spring Cloud 在构建自己的组件产品时，也充分地吸收了 Spring Boot Starter 的设计理念，每一个 Spring Cloud 组件都包装成 Starter ，在项目需要使用 Spring Cloud 相关组件时，只需要引入对应的 Spring Cloud Starter 即可。

也就是说 Spring Cloud 在构建注册中心时，将 Eureka 、Consul 等框架用 Spring Boot 技术包装成对应的 Starter 组件，微服务体系中的其它产品也是这个思路。 这样 Spring Cloud 就完全将整个体系构建在了 Spring Boot 之上，充分利用了 Spring Boot 约定优于配置的理念，重构了生态内的产品，让我们使用 Spring Cloud 产品更加快速便捷。

**Spring Cloud 体系介绍**

按照 Starter 的设计理念，Spring Cloud 共集成了 25 个子项目，每个项目包含一个或者多个第三方的组件或者框架：

1、Spring Cloud Config 配置中心，利用 Git 集中管理程序的配置
2、Spring Cloud Netflix 集成众多 Netflix 的开源软件
3、Spring Cloud Bus 消息总线，利用分布式消息将服务和服务实例连接在一起，用于在一个集群中传播状态的变化
4、Spring Cloud Cloudfoundry 利用 Pivotal Cloudfoundry 集成你的应用程序
5、Spring Cloud Open Service Broker 为建立管理云托管服务的服务代理提供了一个起点
6、Spring Cloud Cluster 基于 Zookeeper， Redis， Hazelcast， Consul 实现的领导选举和平民状态模式的抽象和实现
7、Spring Cloud Consul 基于 Hashicorp Consul 实现的服务发现和配置管理
8、Spring Cloud Security 在 Zuul 代理中为 OAuth2 rest 客户端和认证头转发提供负载均衡
9、Spring Cloud Sleuth SpringCloud应用的分布式追踪系统，和 Zipkin，HTrace，ELK 兼容
10、Spring Cloud Data Flow 一个云本地程序和操作模型，组成数据微服务在一个结构化的平台上
11、Spring Cloud Stream 基于 Redis，Rabbit，Kafka 实现的消息微服务，简单声明模型用以在 Spring Cloud 应用中收发消息
12、Spring Cloud Stream App Starters 基于 Spring Boot 为外部系统提供 Spring 的集成
13、Spring Cloud Task 短生命周期的微服务，为 Spring Booot 应用简单声明添加功能和非功能特性
14、Spring Cloud Task App Starters
15、Spring Cloud Zookeeper 服务发现和配置管理基于 Apache Zookeeper
16、Spring Cloud AWS 快速和亚马逊网络服务集成
17、Spring Cloud Connectors 便于 PaaS 应用在各种平台上连接到后端像数据库和消息经纪服务
18、Spring Cloud Starters （项目已经终止并且在 Angel.SR2 后的版本和其他项目合并）
19、Spring Cloud CLI 插件用 Groovy 快速创建 Spring Cloud 组件应用
20、Spring Cloud Contract，一个消费者驱动的、面向 Java 的契约框架
21、Spring Cloud Gateway，Spring Cloud 官方推出的网关服务
22、Spring Cloud OpenFeign，提供 OpenFeign 集成到 Spring Boot 应用中的方式，为微服务架构下服务之间的调用提供解决方案
23、Spring Cloud Pipelines，实现了一个基于 Spring Cloud 架构的研发自动化流程
24、Spring Cloud Function，促进函数作为主要的开发单元。该项目提供了一个通用的模型，用于在各种平台上部署基于函数的软件，包括像 Amazon AWS Lambda 这样的 FaaS（函数即服务，function as a service）平台
25、Spring Cloud Kubernetes，Spring Cloud 提供对 Kubernetes 的支持

25 个框架中有一部分（主要是 Netflix 相关）都已经处于维护状态，有些刚刚加入 Spring Cloud 生态中。

**Spring Cloud 和 Spring Boot 版本对应关系**

参考官网

**Spring 、Spring Boot 和 Spring Cloud 的关系**

我们再来重新梳理一下 Spring 、Spring Boot 和 Spring Cloud 三者之间的关系。

Spring 最初的两大核心功能 Spring Ioc 和 Spring Aop 成就了 Spring，Spring 在这两大核心功能上不断地发展，才有了 Spring 事务、Spring MVC 等一系列伟大的产品，最终成就了 Spring 帝国，到了后期 Spring 几乎可以解决企业开发中的所有问题。

Spring Boot 是在强大的 Spring 帝国生态基础上面发展而来，发明 Spring Boot 不是为了取代 Spring ，是为了让人们更容易地使用 Spring 。所以说没有 Spring 强大的功能和生态，就不会有后期的 Spring Boot 火热。 Spring Boot 使用约定优于配置的理念，重新重构了 Spring 的使用，让 Spring 后续的发展更有生命力。

Spring 并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过 Spring Boot 风格进行再封装，屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。

Spring Cloud 是一系列框架的有序集合。它利用 Spring Boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 Spring Boot 的开发风格做到一键启动和部署。

Spring Cloud 是为了解决微服务架构中服务治理而提供的一系列功能的开发框架，并且 Spring Cloud 是完全基于 Spring Boot 而开发。Spring Cloud 利用 Spring Boot 特性整合了开源行业中优秀的组件，整体对外提供了一套在微服务架构中服务治理的解决方案。

综上我们可以这样来理解，正是由于 Spring Ioc 和 Spring Aop 两个强大的功能才有了 Spring ，Spring 生态不断的发展才有了 Spring Boot ，使用 Spring Boot 让 Spring 更易用更有生命力，Spring Cloud 是基于 Spring Boot 开发的一套微服务架构下的服务治理方案。

以下为它们之间的关系。
![图片描述](https://img1.sycdn.imooc.com/5d00c2be00014beb04410458.png)

**Spring Boot 和 Spring Cloud 的区别**

Spring Boot 专注于快速方便地开发单个个体微服务。Spring Cloud 关注全局的微服务协调整理治理框架，它将 Spring Boot 开发的一个个单体微服务整合并管理起来， 为各个服务之间提供配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、精选决策、分布式会话等集成服务。

Spring Boot 可以离开 Spring Cloud 独立开发项目，但是 Spring Cloud 离不开 Spring Boot，属于依赖关系。Spring Boot 专注于快速、方便地开发单个微服务个体，Spring Cloud 关注全局的服务治理框架。

### 2、服务注册与发现 Eureka和Consul

#### 1）Eureka 服务注册中心的搭建

Eureka 由两个组件组成：Eureka 服务端和 Eureka 客户端。Eureka 服务端就是注册中心。Eureka 客户端是一个 java 客户端，用来简化与服务端的交互、作为轮询负载均衡器，并提供服务的故障切换支持。

通过下图了解一下 Eureka 的使用场景：

![图片描述](https://img1.sycdn.imooc.com/5d00c3d10001d0e205270258.png)

从上图我们可以看出有三个角色：

- Eureka Server，担任注册中心的角色，提供了服务的注册和发现功能
- Service Provider，服务提供者，将自身服务注册到 Eureka Server，同时通过心跳来检查服务的运行状态
- Service Consumer，服务调用者，从 Eureka 获取注册服务列表，找到对应的服务地址再进行调用

#### 2）搭建 Eureka Server

**添加依赖**

将 pom 包中比较关键的几个点给大家截取出来解释一下。项目使用 Spring Boot 2.1.3 版本，以及 Spring Boot 体系内对应的依赖组件。

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.3.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

添加 Spring Cloud 的依赖版本信息。

```xml
<properties>
    <java.version>1.8</java.version>
    <spring-cloud.version>Greenwich.SR1</spring-cloud.version>
</properties>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

properties 中定义了一些常用的变量，比如默认使用 Jdk 1.8 版本，Spring Cloud 的版本使用 Greenwich.SR1。dependencyManagement 设置项目使用 Spring Cloud SR1 版本。

Spring Cloud 体系内维护了各个组件之间的版本依赖关系，我们只需要在 pom 包中指明使用的具体 Spring Cloud 大版本即可。

接下来是比较重要的一块，添加 Eureka 依赖包，dependencies 模块中添加 `spring-cloud-starter-netflix-eureka-server`，项目即拥有了注册中心的功能。

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
</dependencies>
```

在后面的项目中，其它内容不变化，只需要增删 dependencies 中的依赖组件即可。

**启动类**

我们需要在启动类中添加注解，开启 Eureka Server 功能。

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
```

添加 `@EnableEurekaServer` 注解，开启注册中心服务发现功能。

**配置文件**

我们需要添加一些 Eureka 的基础配置：

```
spring.application.name=eureka server
server.port=8000

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

- `spring.application.name` 项目名称
- `server.port` 项目启动的端口号
- `eureka.client.register-with-eureka` 表示是否将自己注册到 Eureka Server，默认为 true
- `eureka.client.fetch-registry` 表示是否从 Eureka Server 获取注册信息，默认为 true

**测试**

上述信息配置完成之后，Eureka 的服务端就搭建好了，在启动类上右键选择 run 启动项目。等待启动完成之后，在浏览器中访问地址 ：`http://localhost:8000/`，我们就可以看到 Eureka 的可视化界面，如下图：
![图片描述](https://img1.sycdn.imooc.com/5d00c3e800012b1813430625.png)

可以发现后台页面被分为了五大块：

- System Status，主要展示系统状态，比如启动时间等
- DS Replicas，该服务从哪里同步数据
- Instances currently registered with Eureka，注册在 Eureka 的实例列表
- General Info，系统运行环境，比如内存、cpu 等
- Instance Info，本服务的基础信息，比如 ip 地址，状态等

**注册中心高可用**

理论上来讲，服务消费者本地缓存了服务提供者的地址。即使 Eureka Server 宕机，也不会影响服务之间的调用，但是一旦涉及到服务的上下线，本地的缓存信息将会出现偏差，从而影响到了整个微服务架构的稳定性，因此搭建 Eureka Server 集群来提高整个架构的高可用性，是非常有必要的。

下面我们进行高可用搭建。

**搭建 Eureka 集群**

开启 Eureka 集群配置后，服务启动时 Eureka Server 会将注册信息向其它 Eureka Server 进行同步，因此搭建高可用架构只需要将 Eureke Server 配置指向其它可用的 serviceUrl 即可。

我们在上面 Eureka 单个示例的基础上，复制出三份来分别命名为：eureka-a、eureka-b、eureka-c 三个示例项目，使用这三个示例项目搭建 Eureka Server 的集群。

接下来需要分别修改 eureka-a、eureka-b、eureka-c 的配置信息。

eureka-a 的配置信息如下：

```
spring.application.name=eureka server
server.port=8001

eureka.instance.hostname=eurekaA
eureka.client.serviceUrl.defaultZone=http://eurekaB:8002/eureka/,http://eurekaC:8003/eureka/

eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
```

- 项目端口改为 8001
- 增加 `eureka.instance.hostname` 配置，相当于给服务起个别名注册到注册中心
- `eureka.client.register-with-eureka` 和 `eureka.client.fetch-registry` 配置为 true ，表示将自己注册到注册中心，并且从注册中心获取注册信息
- `eureka.client.serviceUrl.defaultZone`，指向其它两个注册中心，重点配置内容，带有/eureka 的地址是默认的注册地址，不是管理页面的地址，不需要通过 context-path 来配置哈

eureka-b 和 eureka-c 项目的配置信息和 eureka-a 的配置内容大同小异，这里只贴出差异的部分，完整配置信息请查看课程示例代码：

```
eureka-b 
--------------
spring.application.name=eureka server
server.port=8002

eureka.instance.hostname=eurekaB
eureka.client.serviceUrl.defaultZone=http://eurekaA:8001/eureka/,http://eurekaC:8003/eureka/

eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true


eureka-c
--------------
spring.application.name=eureka server
server.port=8003

eureka.instance.hostname=eurekaC
eureka.client.serviceUrl.defaultZone=http://eurekaA:8001/eureka/,http://eurekaB:8002/eureka/

eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
```

以上项目配置完成。

**测试**

本机直接访问 eurekaA/B/C 网络是不通的，需要本地配置 host 信息。在 Windows 的 `C:\Windows\System32\drivers\etc\hosts` 或者 Linux 的 `/etc/hosts` 文件末添加以下信息：

```
127.0.0.1 eurekaA eurekaB eurekaC
```

添加完成之后，依次启动 eureka-a、eureka-b、eureka-c 项目，等待全部启动完成之后，浏览器访问地址：`http://localhost:8001/`，即可看到页面的集群相关信息。

在 DS Replicas 模块中可以看到另外两台注册中心的别名；在 Instances currently registered with Eureka 模块中可以看到三个注册中心都以实例的形式注册到了注册中心。
![图片描述](https://img1.sycdn.imooc.com/5d00c3fe0001606f13420647.png)

在 General Info 模块中，可以看到 registered-replicas（已经注册到的副本）和 available-replicas（有效副本）都可以看到其它两个注册中心的信息。

![图片描述](https://img1.sycdn.imooc.com/5d00c41700018c3409180507.png)

证明 Eureka Server 高可用集群搭建成功。

**常见问题**

**Eureka 的 UNKNOWN 问题**

注册中心 (Eureka Server) 中的服务状态，常见的有 UP、DOWN，但有时会出现另外一种 UNKNOWN 状态，或者 UNKNOWN 服务名。

- UNKNOWN 服务名，是因为在项目中没有配置应用实例的名称导致，配置参数为 `spring.application.name` 或者 `eureka.instance.appname` ，如果这两个参数都不配置，则将会出现 UNKNOWN 服务名
- UNKNOWN 状态，出现的机率比较少，这是 Eureka Server 没有获取到客户端的心跳数据导致，如果将 `eureka.client.healthcheck.enabled=true` 配置到 bootstrap.yml 也会导致此问题，应该配置到 application.yml 中

**注册中心副本不可用（unavailable-replicas）**

有些同学在搭建 Eureka 集群时会出现，注册中心服务不可用的情况，其它 Eureka Server 的地址进入了 unavailable-replicas 中，此情况可能时由多种原因导致。
![图片描述](https://img1.sycdn.imooc.com/5d00c4240001709816760300.png)

1、`eureka.client.serviceUrl.defaultZone` 配置地址不以 localhost 地址来配置，应该按照文中示例配置。

2、没有开启相互注册

```
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
```

3、没有配置 host 信息。

出现类似问题一般都是配置信息错误或者少配置导致，根据课程内容多检查即可避免。

#### 3）Eureka 工作原理

**Eureka 核心概念**

回到上节的服务注册调用示意图，服务提供者和服务的消费者，本质上也是 Eureka Client 角色。整体上可以分为两个主体：Eureka Server 和 Eureka Client。

![图片描述](https://img1.sycdn.imooc.com/5d00d8e900012c0609450403.png)

**Eureka Server：注册中心服务端**

注册中心服务端主要对外提供了三个功能：

*服务注册*：服务提供者启动时，会通过 Eureka Client 向 Eureka Server 注册信息，Eureka Server 会存储该服务的信息，Eureka Server 内部有二层缓存机制来维护整个注册表；

*提供注册表*：服务消费者在调用服务时，如果 Eureka Client 没有缓存注册表的话，会从 Eureka Server 获取最新的注册表；

*同步状态*： Eureka Client 通过注册、心跳机制和 Eureka Server 同步当前客户端的状态。

**Eureka Client：注册中心客户端**

Eureka Client 是一个 Java 客户端，用于简化与 Eureka Server 的交互。Eureka Client 会拉取、更新和缓存 Eureka Server 中的信息。因此当所有的 Eureka Server 节点都宕掉，服务消费者依然可以使用缓存中的信息找到服务提供者，但是当服务有更改的时候会出现信息不一致。

**Register：服务注册**

服务的提供者，将自身注册到注册中心，服务提供者也是一个 Eureka Client。当 Eureka Client 向 Eureka Server 注册时，它提供自身的元数据，比如 IP 地址、端口，运行状况指示符 URL，主页等。

**Renew：服务续约**

Eureka Client 会每隔 30 秒发送一次心跳来续约。 通过续约来告知 Eureka Server 该 Eureka Client 运行正常，没有出现问题。 默认情况下，如果 Eureka Server 在 90 秒内没有收到 Eureka Client 的续约，Server 端会将实例从其注册表中删除，此时间可配置，一般情况不建议更改。

服务续约的两个重要属性：

```
服务续约任务的调用间隔时间，默认为30秒
eureka.instance.lease-renewal-interval-in-seconds=30

服务失效的时间，默认为90秒。
eureka.instance.lease-expiration-duration-in-seconds=90
```

*Eviction 服务剔除*

当 Eureka Client 和 Eureka Server 不再有心跳时，Eureka Server 会将该服务实例从服务注册列表中删除，即服务剔除。

**Cancel：服务下线**

Eureka Client 在程序关闭时向 Eureka Server 发送取消请求。 发送请求后，该客户端实例信息将从 Eureka Server 的实例注册表中删除。该下线请求不会自动完成，它需要调用以下内容：

```
DiscoveryManager.getInstance().shutdownComponent()；
```

**Get Registry：获取注册列表信息**

Eureka Client 从服务器获取注册表信息，并将其缓存在本地。客户端会使用该信息查找其他服务，从而进行远程调用。该注册列表信息定期（每30秒钟）更新一次。每次返回注册列表信息可能与 Eureka Client 的缓存信息不同，Eureka Client 自动处理。

如果由于某种原因导致注册列表信息不能及时匹配，Eureka Client 则会重新获取整个注册表信息。 Eureka Server 缓存注册列表信息，整个注册表以及每个应用程序的信息进行了压缩，压缩内容和没有压缩的内容完全相同。Eureka Client 和 Eureka Server 可以使用 JSON/XML 格式进行通讯。在默认情况下 Eureka Client 使用压缩 JSON 格式来获取注册列表的信息。

获取服务是服务消费者的基础，所以必有两个重要参数需要注意：

```
# 启用服务消费者从注册中心拉取服务列表的功能
eureka.client.fetch-registry=true

# 设置服务消费者从注册中心拉取服务列表的间隔
eureka.client.registry-fetch-interval-seconds=30
```

**Remote Call：远程调用**

当 Eureka Client 从注册中心获取到服务提供者信息后，就可以通过 Http 请求调用对应的服务；服务提供者有多个时，Eureka Client 客户端会通过 Ribbon 自动进行负载均衡。

**自我保护机制**

默认情况下，如果 Eureka Server 在一定的 90s 内没有接收到某个微服务实例的心跳，会注销该实例。但是在微服务架构下服务之间通常都是跨进程调用，网络通信往往会面临着各种问题，比如微服务状态正常，网络分区故障，导致此实例被注销。

固定时间内大量实例被注销，可能会严重威胁整个微服务架构的可用性。为了解决这个问题，Eureka 开发了自我保护机制，那么什么是自我保护机制呢？

Eureka Server 在运行期间会去统计心跳失败比例在 15 分钟之内是否低于 85%，如果低于 85%，Eureka Server 即会进入自我保护机制。

Eureka Server 触发自我保护机制后，页面会出现提示：
![图片描述](https://img1.sycdn.imooc.com/5d00d9060001896f13410584.png)

Eureka Server 进入自我保护机制，会出现以下几种情况：

- Eureka 不再从注册列表中移除因为长时间没收到心跳而应该过期的服务
- Eureka 仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上(即保证当前节点依然可用)
- 当网络稳定时，当前实例新的注册信息会被同步到其它节点中

Eureka 自我保护机制是为了防止误杀服务而提供的一个机制。当个别客户端出现心跳失联时，则认为是客户端的问题，剔除掉客户端；当 Eureka 捕获到大量的心跳失败时，则认为可能是网络问题，进入自我保护机制；当客户端心跳恢复时，Eureka 会自动退出自我保护机制。

如果在保护期内刚好这个服务提供者非正常下线了，此时服务消费者就会拿到一个无效的服务实例，即会调用失败。对于这个问题需要服务消费者端要有一些容错机制，如重试，断路器等。

通过在 Eureka Server 配置如下参数，开启或者关闭保护机制，生产环境建议打开：

```
eureka.server.enable-self-preservation=true
```



**Eureka 集群原理**

再来看看 Eureka 集群的工作原理。我们假设有三台 Eureka Server 组成的集群，第一台 Eureka Server 在北京机房，另外两台 Eureka Server 在深圳和西安机房。这样三台 Eureka Server 就组建成了一个跨区域的高可用集群，只要三个地方的任意一个机房不出现问题，都不会影响整个架构的稳定性。
![图片描述](https://img1.sycdn.imooc.com/5d00d9110001d41807130385.png)

图片来自 Eureka 官方 wiki 的架构图，地址：https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance，有修改。

从图中可以看出 Eureka Server 集群相互之间通过 Replicate 来同步数据，相互之间不区分主节点和从节点，所有的节点都是平等的。在这种架构中，节点通过彼此互相注册来提高可用性，每个节点需要添加一个或多个有效的 serviceUrl 指向其他节点。

如果某台 Eureka Server 宕机，Eureka Client 的请求会自动切换到新的 Eureka Server 节点。当宕机的服务器重新恢复后，Eureka 会再次将其纳入到服务器集群管理之中。当节点开始接受客户端请求时，所有的操作都会进行节点间复制，将请求复制到其它 Eureka Server 当前所知的所有节点中。

另外 Eureka Server 的同步遵循着一个非常简单的原则：只要有一条边将节点连接，就可以进行信息传播与同步。所以，如果存在多个节点，只需要将节点之间两两连接起来形成通路，那么其它注册中心都可以共享信息。每个 Eureka Server 同时也是 Eureka Client，多个 Eureka Server 之间通过 P2P 的方式完成服务注册表的同步。

Eureka Server 集群之间的状态是采用异步方式同步的，所以不保证节点间的状态一定是一致的，不过基本能保证最终状态是一致的。

**Eureka 分区**

Eureka 提供了 Region 和 Zone 两个概念来进行分区，这两个概念均来自于亚马逊的 AWS：

- region：可以理解为地理上的不同区域，比如亚洲地区，中国区或者深圳等等。没有具体大小的限制。根据项目具体的情况，可以自行合理划分 region。
- zone：可以简单理解为 region 内的具体机房，比如说 region 划分为深圳，然后深圳有两个机房，就可以在此 region 之下划分出 zone1、zone2 两个 zone。

上图中的 us-east-1c、us-east-1d、us-east-1e 就代表了不同的 Zone。Zone 内的 Eureka Client 优先和 Zone 内的 Eureka Server 进行心跳同步，同样调用端优先在 Zone 内的 Eureka Server 获取服务列表，当 Zone 内的 Eureka Server 挂掉之后，才会从别的 Zone 中获取信息。

**Eureka 保证 AP**
Eureka Server 各个节点都是平等的，几个节点挂掉不会影响正常节点的工作，剩余的节点依然可以提供注册和查询服务。而 Eureka Client 在向某个 Eureka 注册时，如果发现连接失败，则会自动切换至其它节点。只要有一台 Eureka Server 还在，就能保证注册服务可用(保证可用性)，只不过查到的信息可能不是最新的(不保证强一致性)。



**Eureka 工作流程**

了解完 Eureka 核心概念，自我保护机制，以及集群内的工作原理后，我们来整体梳理一下 Eureka 的工作流程：

1、Eureka Server 启动成功，等待服务端注册。在启动过程中如果配置了集群，集群之间定时通过 Replicate 同步注册表，每个 Eureka Server 都存在独立完整的服务注册表信息；

2、Eureka Client 启动时根据配置的 Eureka Server 地址去注册中心注册服务；

3、Eureka Client 会每 30s 向 Eureka Server 发送一次心跳请求，证明客户端服务正常；

4、当 Eureka Server 90s 内没有收到 Eureka Client 的心跳，注册中心则认为该节点失效，会注销该实例；

5、单位时间内 Eureka Server 统计到有大量的 Eureka Client 没有上送心跳，则认为可能为网络异常，进入自我保护机制，不再剔除没有上送心跳的客户端；

6、当 Eureka Client 心跳请求恢复正常之后，Eureka Server 自动退出自我保护模式；

7、Eureka Client 定时全量或者增量从注册中心获取服务注册表，并且将获取到的信息缓存到本地；

8、服务调用时，Eureka Client 会先从本地缓存找寻调取的服务。如果获取不到，先从注册中心刷新注册表，再同步到本地缓存；

9、Eureka Client 获取到目标服务器信息，发起服务调用；

10、Eureka Client 程序关闭时向 Eureka Server 发送取消请求，Eureka Server 将实例从注册表中删除。

这就是 Eureka 的整体工作流程。

**小结**

本节为大家讲解了 Eureka 核心概念、Eureka 自我保护机制和 Eureka 集群原理。通过分析 Eureka 工作原理，我可以明显地感觉到 Eureka 的设计之巧妙，通过一些列的机制，完美地解决了注册中心的稳定性和高可用性。

Eureka 为了保障注册中心的高可用性，容忍了数据的非强一致性，服务节点间的数据可能不一致， Client-Server 间的数据可能不一致。比较适合跨越多机房、对注册中心服务可用性要求较高的使用场景。

#### 4）Eureka 缓存机制详细配置

Eureka Server 的数据存储分了两层：数据存储层和缓存层。数据存储层记录注册到 Eureka Server 上的服务信息，缓存层是经过包装后的数据，可以直接在 Eureka Client 调用时返回。我们先来看看数据存储层的数据结构。

Eureka Server 的数据存储层是双层的 ConcurrentHashMap，我们知道 ConcurrentHashMap 是线程安全高效的 Map 集合。

```
private final ConcurrentHashMap<String, Map<String, Lease<InstanceInfo>>> registry= new ConcurrentHashMap<String, Map<String, Lease<InstanceInfo>>>();
```

第一层的 ConcurrentHashMap 的 `key=spring.application.name`，也就是客户端实例注册的应用名；value 为嵌套的 ConcurrentHashMap。

第二层嵌套的 ConcurrentHashMap 的 `key=instanceId`，也就是服务的唯一实例 ID，value 为 Lease 对象，Lease 对象存储着这个实例的所有注册信息，包括 ip 、端口、属性等。

根据这个存储结构我们可以发现，Eureka Server 第一层都是存储着所有的服务名，以及服务名对应的实例信息，也就是说第一层都是按照服务应用名这个维度来切分存储：

```
应用名1：应用1实例 Map
应该名2：应用2实例 Map
...
```

第二层是根据实例的唯一 ID 来存储的，那么按照这个结构最终的存储数据格式为：

```
                ：  应用1实例A：实例A的注册信息 
应用名1：应用1实例：  应用1实例B：实例B的注册信息 
                ：  应用1实例C：实例C的注册信息
                ：  ....
-----------------              
                ：  应用2实例F：实例F的注册信息 
应该名2：应用2实例：  应用2实例G：实例G的注册信息 
                ：  ... 

...
```

数据存储层数据结构如下图所示：
![图片描述](https://img1.sycdn.imooc.com/5d00d94e0001611f07020407.png)

当如服务的状态发生变更时，会同步 Eureka Server 中的 registry 数据信息，比如服务注册、剔除服务时。

**Eureka Server 缓存机制**

Eureka Server 为了提供响应效率，提供了两层的缓存结构，将 Eureka Client 所需要的注册信息，直接存储在缓存结构中。

第一层缓存：readOnlyCacheMap，本质上是 ConcurrentHashMap，依赖定时从 readWriteCacheMap 同步数据，默认时间为 30 秒。

readOnlyCacheMap ： 是一个 CurrentHashMap 只读缓存，这个主要是为了供客户端获取注册信息时使用，其缓存更新，依赖于定时器的更新，通过和 readWriteCacheMap 的值做对比，如果数据不一致，则以 readWriteCacheMap 的数据为准。

第二层缓存：readWriteCacheMap，本质上是 Guava 缓存。

readWriteCacheMap：readWriteCacheMap 的数据主要同步于存储层。当获取缓存时判断缓存中是否没有数据，如果不存在此数据，则通过 CacheLoader 的 load 方法去加载，加载成功之后将数据放入缓存，同时返回数据。

readWriteCacheMap 缓存过期时间，默认为 180 秒，当服务下线、过期、注册、状态变更，都会来清除此缓存中的数据。

Eureka Client 获取全量或者增量的数据时，会先从一级缓存中获取；如果一级缓存中不存在，再从二级缓存中获取；如果二级缓存也不存在，这时候先将存储层的数据同步到缓存中，再从缓存中获取。

通过 Eureka Server 的二层缓存机制，可以非常有效地提升 Eureka Server 的响应时间，通过数据存储层和缓存层的数据切割，根据使用场景来提供不同的数据支持。

**其它缓存设计**

除过 Eureka Server 端存在缓存外，Eureka Client 也同样存在着缓存机制，Eureka Client 启动时会全量拉取服务列表，启动后每隔 30 秒从 Eureka Server 量获取服务列表信息，并保持在本地缓存中。

Eureka Client 增量拉取失败，或者增量拉取之后对比 hashcode 发现不一致，就会执行全量拉取，这样避免了网络某时段分片带来的问题，同样会更新到本地缓存。

同时对于服务调用，如果涉及到 ribbon 负载均衡，那么 ribbon 对于这个实例列表也有自己的缓存，这个缓存定时(默认30秒)从 Eureka Client 的缓存更新。

这么多的缓存机制可能就会造成一些问题，一个服务启动后可能最长需要 90s 才能被其它服务感知到：

1、首先，Eureka Server 维护每 30s 更新的响应缓存

2、Eureka Client 对已经获取到的注册信息也做了 30s 缓存

3、负载均衡组件 Ribbon 也有 30s 缓存

这三个缓存加起来，就有可能导致服务注册最长延迟 90s ，这个需要我们在特殊业务场景中注意其产生的影响。

**Eureka 常用配置**

在 Spring Cloud 官网查看 [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html) 的介绍时，会出现以下几个名字，在这里给大家一一介绍：

- Eureka Server，Eureka 作为注册中心的角色，称之为 Eureka Server。
- Eureka Client，这个比较好理解，前面的文章介绍过注册到 Eureka 的客户端。
- Eureka Instance，可以称之为 Eureka 实例，注册到服务中心的每一个单独的示例，比如 ip 为 192.168.0.1 、端口为 8080 的一个实例。
- Eureka service，Eureka service 其实是 Eureka Instance 的一个抽象，比如是订单服务，有可能订单服务是由多个订单实例（Eureka Instance）组成，具体表现为配置应用名相同的一组实例。

接下来我们就来了解上面这几个概念的常用配置项，Eureka service 作为抽象的概念没有具体的配置项，其它三个均可配置。

**Eureka Server 常用配置**

```
#服务端开启自我保护模式，前面章节有介绍
eureka.server.enable-self-preservation=true
#扫描失效服务的间隔时间（单位毫秒，默认是60*1000）即60秒
eureka.server.eviction-interval-timer-in-ms= 60000
#间隔多长时间，清除过期的 delta 数据
eureka.server.delta-retention-timer-interval-in-ms=0
#请求频率限制器
eureka.server.rate-limiter-burst-size=10
#是否开启请求频率限制器
eureka.server.rate-limiter-enabled=false
#请求频率的平均值
eureka.server.rate-limiter-full-fetch-average-rate=100
#是否对标准的client进行频率请求限制。如果是false，则只对非标准client进行限制
eureka.server.rate-limiter-throttle-standard-clients=false
#注册服务、拉去服务列表数据的请求频率的平均值
eureka.server.rate-limiter-registry-fetch-average-rate=500
#设置信任的client list
eureka.server.rate-limiter-privileged-clients=
#在设置的时间范围类，期望与client续约的百分比。
eureka.server.renewal-percent-threshold=0.85
#多长时间更新续约的阈值
eureka.server.renewal-threshold-update-interval-ms=0
#对于缓存的注册数据，多长时间过期
eureka.server.response-cache-auto-expiration-in-seconds=180
#多长时间更新一次缓存中的服务注册数据
eureka.server.response-cache-update-interval-ms=0
#缓存增量数据的时间，以便在检索的时候不丢失信息
eureka.server.retention-time-in-m-s-in-delta-queue=0
#当时间戳不一致的时候，是否进行同步
eureka.server.sync-when-timestamp-differs=true
#是否采用只读缓存策略，只读策略对于缓存的数据不会过期。
eureka.server.use-read-only-response-cache=true


################server node 与 node 之间关联的配置#####################33
#发送复制数据是否在request中，总是压缩
eureka.server.enable-replicated-request-compression=false
#指示群集节点之间的复制是否应批处理以提高网络效率。
eureka.server.batch-replication=false
#允许备份到备份池的最大复制事件数量。而这个备份池负责除状态更新的其他事件。可以根据内存大小，超时和复制流量，来设置此值得大小
eureka.server.max-elements-in-peer-replication-pool=10000
#允许备份到状态备份池的最大复制事件数量
eureka.server.max-elements-in-status-replication-pool=10000
#多个服务中心相互同步信息线程的最大空闲时间
eureka.server.max-idle-thread-age-in-minutes-for-peer-replication=15
#状态同步线程的最大空闲时间
eureka.server.max-idle-thread-in-minutes-age-for-status-replication=15
#服务注册中心各个instance相互复制数据的最大线程数量
eureka.server.max-threads-for-peer-replication=20
#服务注册中心各个instance相互复制状态数据的最大线程数量
eureka.server.max-threads-for-status-replication=1
#instance之间复制数据的通信时长
eureka.server.max-time-for-replication=30000
#正常的对等服务instance最小数量。-1表示服务中心为单节点。
eureka.server.min-available-instances-for-peer-replication=-1
#instance之间相互复制开启的最小线程数量
eureka.server.min-threads-for-peer-replication=5
#instance之间用于状态复制，开启的最小线程数量
eureka.server.min-threads-for-status-replication=1
#instance之间复制数据时可以重试的次数
eureka.server.number-of-replication-retries=5
#eureka节点间间隔多长时间更新一次数据。默认10分钟。
eureka.server.peer-eureka-nodes-update-interval-ms=600000
#eureka服务状态的相互更新的时间间隔。
eureka.server.peer-eureka-status-refresh-time-interval-ms=0
#eureka对等节点间连接超时时间
eureka.server.peer-node-connect-timeout-ms=200
#eureka对等节点连接后的空闲时间
eureka.server.peer-node-connection-idle-timeout-seconds=30
#节点间的读数据连接超时时间
eureka.server.peer-node-read-timeout-ms=200
#eureka server 节点间连接的总共最大数量
eureka.server.peer-node-total-connections=1000
#eureka server 节点间连接的单机最大数量
eureka.server.peer-node-total-connections-per-host=10
#在服务节点启动时，eureka尝试获取注册信息的次数
eureka.server.registry-sync-retries=
#在服务节点启动时，eureka多次尝试获取注册信息的间隔时间
eureka.server.registry-sync-retry-wait-ms=
#当eureka server启动的时候，不能从对等节点获取instance注册信息的情况，应等待多长时间。
eureka.server.wait-time-in-ms-when-sync-empty=0
预览
```

**Eureka Client 常用配置**

```
#该客户端是否可用
eureka.client.enabled=true
#实例是否在eureka服务器上注册自己的信息以供其他服务发现，默认为true
eureka.client.register-with-eureka=false
#此客户端是否获取eureka服务器注册表上的注册信息，默认为true
eureka.client.fetch-registry=false
#是否过滤掉，非UP的实例。默认为true
eureka.client.filter-only-up-instances=true
#与Eureka注册服务中心的通信zone和url地址
eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/

#client连接Eureka服务端后的空闲等待时间，默认为30 秒
eureka.client.eureka-connection-idle-timeout-seconds=30
#client连接eureka服务端的连接超时时间，默认为5秒
eureka.client.eureka-server-connect-timeout-seconds=5
#client对服务端的读超时时长
eureka.client.eureka-server-read-timeout-seconds=8
#client连接all eureka服务端的总连接数，默认200
eureka.client.eureka-server-total-connections=200
#client连接eureka服务端的单机连接数量，默认50
eureka.client.eureka-server-total-connections-per-host=50
#执行程序指数回退刷新的相关属性，是重试延迟的最大倍数值，默认为10
eureka.client.cache-refresh-executor-exponential-back-off-bound=10
#执行程序缓存刷新线程池的大小，默认为5
eureka.client.cache-refresh-executor-thread-pool-size=2
#心跳执行程序回退相关的属性，是重试延迟的最大倍数值，默认为10
eureka.client.heartbeat-executor-exponential-back-off-bound=10
#心跳执行程序线程池的大小,默认为5
eureka.client.heartbeat-executor-thread-pool-size=5
# 询问Eureka服务url信息变化的频率（s），默认为300秒
eureka.client.eureka-service-url-poll-interval-seconds=300
#最初复制实例信息到eureka服务器所需的时间（s），默认为40秒
eureka.client.initial-instance-info-replication-interval-seconds=40
#间隔多长时间再次复制实例信息到eureka服务器，默认为30秒
eureka.client.instance-info-replication-interval-seconds=30
#从eureka服务器注册表中获取注册信息的时间间隔（s），默认为30秒
eureka.client.registry-fetch-interval-seconds=30

# 获取实例所在的地区。默认为us-east-1
eureka.client.region=us-east-1
#实例是否使用同一zone里的eureka服务器，默认为true，理想状态下，eureka客户端与服务端是在同一zone下
eureka.client.prefer-same-zone-eureka=true
# 获取实例所在的地区下可用性的区域列表，用逗号隔开。（AWS）
eureka.client.availability-zones.china=defaultZone,defaultZone1,defaultZone2
#eureka服务注册表信息里的以逗号隔开的地区名单，如果不这样返回这些地区名单，则客户端启动将会出错。默认为null
eureka.client.fetch-remote-regions-registry=
#服务器是否能够重定向客户端请求到备份服务器。 如果设置为false，服务器将直接处理请求，如果设置为true，它可能发送HTTP重定向到客户端。默认为false
eureka.client.allow-redirects=false
#客户端数据接收
eureka.client.client-data-accept=
#增量信息是否可以提供给客户端看，默认为false
eureka.client.disable-delta=false
#eureka服务器序列化/反序列化的信息中获取“_”符号的的替换字符串。默认为“__“
eureka.client.escape-char-replacement=__
#eureka服务器序列化/反序列化的信息中获取“$”符号的替换字符串。默认为“_-”
eureka.client.dollar-replacement="_-"
#当服务端支持压缩的情况下，是否支持从服务端获取的信息进行压缩。默认为true
eureka.client.g-zip-content=true
#是否记录eureka服务器和客户端之间在注册表的信息方面的差异，默认为false
eureka.client.log-delta-diff=false
# 如果设置为true,客户端的状态更新将会点播更新到远程服务器上，默认为true
eureka.client.on-demand-update-status-change=true
#此客户端只对一个单一的VIP注册表的信息感兴趣。默认为null
eureka.client.registry-refresh-single-vip-address=
#client是否在初始化阶段强行注册到服务中心，默认为false
eureka.client.should-enforce-registration-at-init=false
#client在shutdown的时候是否显示的注销服务从服务中心，默认为true
eureka.client.should-unregister-on-shutdown=true
```

**Eureka Instance 常用配置**

```
#服务注册中心实例的主机名
eureka.instance.hostname=localhost
#注册在Eureka服务中的应用组名
eureka.instance.app-group-name=
#注册在的Eureka服务中的应用名称
eureka.instance.appname=
#该实例注册到服务中心的唯一ID
eureka.instance.instance-id=
#该实例的IP地址
eureka.instance.ip-address=
#该实例，相较于hostname是否优先使用IP
eureka.instance.prefer-ip-address=false
```

**小结**

本节课给大家介绍了 Eureka 数据的存储原理，以及内部巧妙的二级缓存机制，在我们学习 Eureka 的内部存储原理时，同时了解到 Eureka 内部的精妙设计，后期我们在项目中也可借鉴它的实现机制。

#### 5）Consul 注册中心介绍

在 Spring Cloud 体系中，几乎每个角色都会有两个以上的产品提供选择，比如在注册中心有：Eureka、Consul、zookeeper、etcd 等；网关的产品有 Zuul、Spring Cloud Gateway 等。在注册中心产品中，最常使用的是 Eureka 和 Consul，两者各有特点，企业可以根据自述项目情况来选择。

**什么是 Consul**

Consul 是 HashiCorp 公司推出的开源产品，用于实现分布式系统的服务发现、服务隔离、服务配置，这些功能中的每一个都可以根据需要单独使用，也可以同时使用所有功能。Consul 官网目前主要推 Consul 在服务网格中的使用。

与其它分布式服务注册与发现的方案相比，Consul 的方案更“一站式”——内置了服务注册与发现框架、分布一致性协议实现、健康检查、Key/Value 存储、多数据中心方案，不再需要依赖其它工具。Consul 本身使用 go 语言开发，具有跨平台、运行高效等特点，也非常方便和 Docker 配合使用。

Consul 的主要特点有：

- **Service Discovery**: 服务注册与发现，Consul 的客户端可以做为一个服务注册到 Consul，也可以通过 Consul 来查找特定的服务提供者，并且根据提供的信息进行调用。
- **Health Checking**: Consul 客户端会定期发送一些健康检查数据和服务端进行通讯，判断客户端的状态、内存使用情况是否正常，用来监控整个集群的状态，防止服务转发到故障的服务上面。
- **KV Store**: Consul 还提供了一个容易使用的键值存储。这可以用来保持动态配置，协助服务协调、建立 Leader 选举，以及开发者想构造的其它一些事务。
- **Secure Service Communication**: Consul 可以为服务生成分布式的 TLS 证书，以建立相互的 TLS 连接。 可以使用 intentions 定义允许哪些服务进行通信。 可以使用 intentions 轻松管理服务隔离，而不是使用复杂的网络拓扑和静态防火墙规则。
- **Multi Datacenter**: Consul 支持开箱即用的多数据中心，这意味着用户不需要担心需要建立额外的抽象层让业务扩展到多个区域。

**Consul 角色**

- Server: 服务端, 保存配置信息, 高可用集群, 在局域网内与本地客户端通讯, 通过广域网与其它数据中心通讯。 每个数据中心的 Server 数量推荐为 3 个或是 5 个。
- Client: 客户端, 无状态, 将 HTTP 和 DNS 接口请求转发给局域网内的服务端集群。

Consul 旨在对 DevOps 社区和应用程序开发人员友好，使其成为现代、弹性基础架构的理想选择。

**使用 Consul 的优势**

- 使用 Raft 算法来保证一致性, 比复杂的 Paxos 算法更直接。相比较而言, zookeeper 采用的是 Paxos, 而 etcd 使用的则是 Raft。
- 支持多数据中心，内外网的服务采用不同的端口进行监听。多数据中心集群可以避免单数据中心的单点故障，而其部署则需要考虑网络延迟, 分片等情况等。 zookeeper 和 etcd 均不提供多数据中心功能的支持。
- 支持健康检查。 etcd 不提供此功能。
- 支持 http 和 dns 协议接口。 zookeeper 的集成较为复杂, etcd 只支持 http 协议。
- 官方提供 Web 管理界面, etcd 无此功能。
- Consul 保持了 CAP 中的 CP，保持了强一致性和分区容错性。
- Consul 支持 Http\gRPC\DNS 多种访问方式。

综合比较, Consul 作为服务注册和配置管理的新星, 比较值得关注和研究。

**Consul 调用过程**

首先我们根据一张图来了解一下 Consul 服务调用过程：

![图片描述](https://img1.sycdn.imooc.com/5d00da5b0001d76c06060492.png)

1、当 Producer 启动的时候，会向 Consul 发送一个 post 请求，告诉 Consul 自己的 IP 和 Port；

2、Consul 接收到 Producer 的注册后，每隔 10s（默认）会向 Producer 发送一个健康检查的请求，检验 Producer 是否健康；

3、当 Consumer 发送 GET 方式请求 /api/address 到 Producer 时，会先从 Consul 中拿到一个存储服务 IP 和 Port 的临时表，从表中拿到 Producer 的 IP 和 Port 后再发送 GET 方式请求 /api/address；

4、该临时表每隔 10s 会更新，只包含有通过了健康检查的 Producer。

Spring Cloud Consul 项目是针对 Consul 的服务治理实现。Consul 是一个分布式高可用的系统，它包含多个组件，但是作为一个整体，在微服务架构中，为我们的基础设施提供服务发现和服务配置的工具。



**Consul 和 Euerka 的对比**

我们先来通过一个表格做简单对比

| Feature              | Euerka                       | Consul                 |
| :------------------- | :--------------------------- | :--------------------- |
| 服务健康检查         | 可配支持                     | 服务状态，内存，硬盘等 |
| 多数据中心           | —                            | 支持                   |
| kv 存储服务          | —                            | 支持                   |
| 一致性               | —                            | raft                   |
| cap                  | ap                           | cp                     |
| 使用接口(多语言能力) | http（sidecar）              | 支持 http 和 dns       |
| watch 支持           | 支持 long polling/大部分增量 | 全量/支持long polling  |
| 自身监控             | metrics                      | metrics                |
| 安全                 | —                            | acl /https             |
| 编程语言             | Java                         | go                     |
| Spring Cloud 集成    | 已支持                       | 已支持                 |

通过对比可以得知， Consul 功能更强大，Euerka 更容易使用。

Consul 强一致性©带来的是：

服务注册相比 Eureka 会稍慢一些。因为 Consul 的 raft 协议要求必须过半数的节点都写入成功才认为注册成功,。Leader 挂掉时，重新选举期间整个 Consul 不可用。保证了强一致性但牺牲了可用性。

Consul 强烈的一致性意味着它可以作为领导选举和集群协调的锁定服务。

Eureka 保证高可用(A)和最终一致性：

服务注册相对要快，因为不需要等注册信息 replicate 到其它节点，也不保证注册信息是否 replicate 成功。当数据出现不一致时，虽然 A, B 上的注册信息不完全相同，但每个 Eureka 节点依然能够正常对外提供服务，这会出现查询服务信息时如果请求 A 查不到，但请求 B 就能查到。如此保证了可用性但牺牲了一致性。

**安装 Consul**

Consul 不同于 Eureka 是由 go 语言开发而成，因此需要我们单独来安装。

打开 [Consul 官网](https://www.consul.io/downloads.html)，根据不同的操作系统选择最新的 Consul 版本，我们这里以 Windows 64 操作系统为例，可以看出 Consul 目前的最新版本为 1.4.4。

![图片描述](https://img1.sycdn.imooc.com/5d00da6d0001a8fa10760816.png)

下载下来是一个 consul_1.4.4_windows_amd64.zip 的压缩包，解压是一个 consul.exe 的执行文件。
![图片描述](https://img1.sycdn.imooc.com/5d00da7b0001376b07350266.png)

cd 到对应的目录下，使用 cmd 启动 Consul：

```
cd D:\Common Files\consul
#cmd启动：
consul agent -dev        # -dev表示开发模式运行，另外还有-server表示服务模式运行
```

为了方便启动，可以在同级目录下创建一个 run.bat 脚本来启动，脚本内容如下：

```
consul agent -dev
pause
```

下次启动的时候直接双击 run.bat 文件即可；当然也可以把 consul 的 exe 文件路径加入到本机的 path 路径下，这样后期只需要在 cmd 命令行下运行 `consul agent -dev` 命令即可。

执行命令后，命令行会输出如下信息：
![图片描述](https://img1.sycdn.imooc.com/5d00da910001a45709750344.png)

启动成功之后访问：[http://localhost:8500](http://localhost:8500/)，可以看到 Consul 的管理界面：
![图片描述](https://img1.sycdn.imooc.com/5d00da9d000114f218900710.png)

Consul 的 Web 管理界面有一些菜单，我们这里做一下简单的介绍：

- Services，管理界面的默认页面，用来展示注册到 Consul 的服务，启动后默认会有一个 consul 服务，也就是它本身。
- Nodes，在 Services 界面双击服务名就会来到 Services 对于的 Nodes 界面，Services 是按照服务的抽象来展示的，Nodes 展示的是此服务的具体节点信息。比如启动了两个订单服务实例，Services 界面会出现一个订单服务，Nodes 界面会展示两个订单服务的节点。
- Key/Value ，如果有用到 Key/Value 存储，可以在界面进行配置、查询。
- ACL，全称 Access Control List，为访问控制列表的展示信息。
- Intentions，可以在页面配置请求权限。

当我们看到这个页面后，也就意味着 Consul 已经安装成功了。

**小结**

本节为大家介绍了注册中心的另外一个产品：Consul。介绍了 Consul 的特点、优势，以及和 Eureka 对比有什么不同的特性，最后为大家展示了如何在 Windows 下安装一个 Consul 服务。下节为大家介绍 Consul 的架构原理和实践。

#### 6）Consul 架构原理和实践

**Consul 核心概念**

我们先来了解一下 Consul 架构中的几个核心概念：

- Agent，Agent 是长期运行在每个 Consul 集群成员节点上守护进程。通过命令 Consul agent 启动。Agent 有 Client 和 Server 两种模式。
- Client，客户端是运行 Client 模式的 Agent，负责转发所有的 RPC 到 Server，Client 是相对无状态的。
- Server，服务的是运行 Server 模式的 Agent，包括参与 Raft 仲裁，维护集群的状态，响应 RPC 查询，与其它数据中心交互 WAN gossip，以及将其它查询转发给 Leader 或远程数据中心。
- Datacenter，一个数据中心代表了 Consul 的一个本地部署集群。
- Consensus - Consensus 协议，负责维护不同节点之间状态的一致性。
- Gossip – Consul 是建立在 Serf 之上，提供了完整的 Gossip 协议，用于成员维护故障检测、事件广播。
- LAN Gossip，指的是 LAN gossip pool，包含位于同一个局域网或者数据中心的节点。
- WAN Gossip，指的是 WAN gossip pool，只包含 Server 节点，这些 Server 主要分布在不同的数据中心或者通信是基于互联网或广域网的。
- RPC，远程过程调用，是允许 Client 请求服务器的请求 / 响应机制。

> Gossip 是一个带冗余的容错算法，更进一步，Gossip 是一个最终一致性算法。虽然无法保证在某个时刻所有节点状态一致，但可以保证在” 最终 “所有节点一致，” 最终 “是一个现实中存在，但理论上无法证明的时间点。



**Consul 基础架构**

每一个 Consul 节点都要运行一个 Consul agent (Consul 代理)。运行一个 Agent 不需要做服务发现或者设置 key/value 数据。这个代理只是负责对当前节点自己还有它上面的服务做健康检查。

Agent 与一个或多个 Consul servers (Consul 服务) 通信。Consul servers 是数据存储和备份的地方。Servers 内部选举一个 Leader。虽然 Consul 可以只有一个 Server，但是为了避免单节点故障造成数据丢失，我们建议最好部署 3-5 个 Server 节点。每个数据中心都需要一个 Consul server 集群。

服务发现组件可以通过 Consul server 或者任意一个 Consul agent 来查询服务或者节点。Agent 可以将这些查询自动转发给 Server。

每个数据中心都要运行一个 Consul server 集群。当一个跨数据中心的服务发现或者配置请求发出时，本地的 Consul Server 会将这些请求转发给远程的数据中心，然后将结果返回。

**Consul 集群**

Consul 客户端、服务端还支持跨中心的使用，更加提高了它的高可用性。

![图片描述](https://img1.sycdn.imooc.com/5d00dad10001702623152400.png)

> 此图来源于 Consul 官网：https://www.consul.io/docs/internals/architecture.html

从上图可以看出，有两个数据中心，分别标记为 DATACENTER 1 和 DATACENTER 2 , 两个数据中心通过 WAN GOSSIP 在 Internet 上交互报文，由此可知 Consul 是支持多数据中心的。

每个数据中心都有两个角色 Server 和 Client，它们之间通过 GRPC 通信。Server 端参与 Raft 仲裁，维护集群的状态，响应 RPC 查询，Client 负责转发 RPC 到 Server 。

Server 和 Client 之间，还有一条 LAN GOSSIP 通信，当 LAN 内部发生了拓扑变化时，存活的节点能够及时感知，比如 Server 节点 Down 掉后，Client 就会触发将对应 Server 节点从可用列表中剥离出去。

官方建议每个 Consul Cluster 有 3 到 5 台 Server，兼顾故障处理和性能的平衡。如果增加越多的机器，则 Consensus 会越来越慢。对 Client 没有限制，可以很容易地扩展到成千上万或数万。

同一个数据中心的所有节点都要加入 Gossip 协议，这意味着 Gossip pool 包含给定数据中心的所有节点。有以下目的：

没有必要为 Client 配置服务器地址参数；发现是自动完成的。

Server 集群之间运行 Raft 协议，通过共识仲裁选举出 Leader。Leader server 负责处理所有的查询和事务，事务也必须通过 Consensus 协议复制到所有的伙伴。当非 Leader Server 接收到一个 RPC 请求，会转发到集群的 Leader。

所有的业务数据都通过 Leader 写入到集群中做持久化，当有半数以上的节点存储了该数据后，Server 集群才会返回 ACK，从而保障了数据的强一致性。

Server 节点和其它数据中心通过 WAN gossip 通讯，WAN gossip 针对互联网传输做了优化，具备更高延迟的网络响应。将一个新的数据中心加入现有的 WAN Gossip 是很容易的，因为相互之间都是通过 WAN gossip 通讯。

当一个 Server 接收到不同数据中心的请求时，它把这个请求转发给对应数据中心随机的一个 Server。然后，接收到请求的 Server 可能会转发给 Leader。

多个数据中心之间是低耦合，但由于故障检测、连接缓存复用、跨数据中心要求快速和可靠的响应。

**快速入手**

接下来我们使用一个简单的示例，来了解 Consul 的服务注册和调用。首先我们构建一个 Consul 的服务提供者，只提供一个简单的 hello 调用方法。



**服务提供者**

**添加依赖**

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-consul-discovery</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

- `spring-boot-starter-actuator` 健康检查依赖于此包
- `spring-cloud-starter-consul-discovery` Spring Cloud Consul 的支持

完整的 pom.xml 文件大家可以参考课程示例源码。

**配置文件**

```
spring.application.name=consul-producer
server.port=8501
# consul 的地址和端口
spring.cloud.consul.host=localhost
spring.cloud.consul.port=8500
#注册到 consul 的服务名称
spring.cloud.consul.discovery.serviceName=service-producer
```

`spring.cloud.consul.discovery.serviceName` 是指注册到 Consul 的服务名称，客户端可根据这个名称进行服务调用。

**启动类**

```java
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderApplication.class, args);
    }
}
```

注解 `@EnableDiscoveryClient` 代表开启了服务发现的功能。

**添加服务接口**

创建一个 Controller 来提供 hello 服务接口，代码如下:

```java
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello consul";
    }
}
```

为了模拟多服务提供调用，复制上述项目重命名为 consul-producer-2 , 修改对应的端口为 8503，修改 hello 方法的返回值为：”hello consul two”，修改完成后依次启动两个项目。

当两个项目都启动完成之后，我们再来访问地址:`http://localhost:8500`，看看服务注册的情况：
![图片描述](https://img1.sycdn.imooc.com/5d00daf50001220b11920571.png)

我们发现页面多了 service-producer 服务，点击进去后页面显示有两个服务提供者：

![图片描述](https://img1.sycdn.imooc.com/5d00db010001fcc010000646.png)

这样服务提供者就准备好了。



**服务调用者**

我们创建项目 consul-consumer 作为服务的调用者，依赖文件和上述项目相同。

调用者配置文件如下：

**配置文件**

```
spring.application.name=consul-consumer
server.port=8601
spring.cloud.consul.host=localhost
spring.cloud.consul.port=8500
#设置不需要注册到 consul
spring.cloud.consul.discovery.register=false
```

客户端可以设置是否注册到 Consul 中，大家根据业务选择配置即可。

**启动类**

```java
@SpringBootApplication
public class ConsulProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderApplication.class, args);
    }
}
```

启动类比较简单，和正常的 Spring Boot 项目相同。

**服务调用**

我们创建一个 CallHelloController ，调用我们上面创建好的 hello 方法。

```java
@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }

}
```

启动 consul-consumer 项目，等待启动完成之后，在浏览器多次访问地址：http://localhost:8601/call ，通过 call () 方法调用服务提供者的 hello 接口，并且打印接口返回信息。

多次调用后，IED 输出栏中会打印如下信息：

```
服务地址：http://LAPTOP-0536HN3V.w.mifi:8501
服务名称：service-producer
hello consul
服务地址：http://LAPTOP-0536HN3V.w.mifi:8503
服务名称：service-producer
hello consul two
...
```

可以看出服务调用者已经成功获得了服务提供者的响应信息，并且两个服务提供者交替返回信息，服务调用自动实现了均衡负载的功能。

### 3、服务注册与消费

#### 1）服务注册与消费

**系统架构**

其实，在微服务出现之前，跨服务调用的需求就有了，只不过以前大多数人可能会采用直连的方式去调用另一个服务。例如有 Server A 和 Server B 两个服务，当 Server A 需要去调用 Server B 的时候，直接在 Server A 中写上 Server B 的地址去调用就行了，像下面这样：

![图片描述](https://img1.sycdn.imooc.com/5d00db80000129c204000190.png)

这种硬编码的方式缺陷很明显，Server B 的地址一旦被写死了，就必须一动不动地呆在一个地方，Server B 如果想要上线新的集群，还得修改 Server A 的代码。在微服务架构下，系统调用将不再是这种方式了，请看下图：

![图片描述](https://img1.sycdn.imooc.com/5d00db8a00011c1504420191.png)

此时的服务调用将分为两个过程：

1. Server A 去服务注册中心拿到 Server B 的地址，如果 Server B 是单机部署，这个地址就只有一个，如果 Server B 是集群化部署，这个地址就有多个；
2. 拿到 Server B 的地址之后，Server A 再去调用 Server B。

这样做，看着比上面的方式更麻烦了，但是却带来了更多的好处 —— 例如服务的之间调用时，互相之间的地址不用写死，需要的时候直接去服务注册中心获取，服务之间也可以方便进行集群化部署、使用负载均衡功能等。

本文我们就先来搭建图二这样一个简单的微服务架构。



**服务注册与消费**



**1. 首先启动 Eureka**

首先我们创建一个名为 ServiceRegistry 的空的 maven 项目，然后创建一个 Eureka 服务注册中心作为子模块并启动，Eureka 的配置和前面文章的一致，这里我们只需要启动一个单机的 Eureka 即可。关于 Eureka 的配置和启动，如果读者有不懂的地方，可以参考本专栏前面的文章，这里我就不再赘述。



**2. 创建 provider**

接下来创建一个 Provider 作为消息提供者，这就是一个普通的 Spring Boot 工程，创建时候注意添加 Web 依赖以及 Eureka Discovery 依赖：

![图片描述](https://img1.sycdn.imooc.com/5d00db990001b18608910569.png)

项目 pom 文件完整依赖如下：

```xml
<properties>
    <spring-cloud.version>Greenwich.SR1</spring-cloud.version>
</properties>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
</dependencies>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

项目创建成功后，在 application.properties 中添加如下配置：

```
spring.application.name=provider
server.port=4001
eureka.client.service-url.defaultZone=http://localhost:1111/eureka
```

三行配置含义分别如下：

- spring.application.name 表示当前服务的名字，这个名字将作为服务的标记存储在 Eureka 上，当其他服务需要调用这个服务的时候，都是通过这个名字来查找服务。
- server.port 当前服务的端口。
- 最后一个地址表示当前服务需要注册到的服务注册中心地址，这里需要注意，如果服务注册中心是一个集群，这里也可以只写集群中的一个节点，Eureka 集群会自动进行服务同步。

在微服务中，只要当前项目的 classpath 下存在 `spring-cloud-starter-netflix-eureka-client` 依赖，并且提供了 eureka 注册中心的地址，该服务就会自动注册到 Eureka Server 上。

然后在 provider 中提供一个 `/hello` 接口，供其他服务调用，如下：

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name + " !";
    }
}
```

至此，我们的服务提供者就算有了。



**3. 创建 consumer**

有了服务提供者，接下来我们再来创建服务消费者 consumer。首先创建一个普通的 Spring Boot 工程，创建时依然记得添加 web 和 eureka discovery 依赖；创建工程后，在 application.properties 中的配置和 provider 基本一致，只是服务端口变了而已，如下：

```
spring.application.name=consumer
server.port=4002
eureka.client.service-url.defaultZone=http://localhost:1111/eureka
```

这段配置的含义参考 provider 配置，不再赘述。

接下来，在 consumer 的启动类中添加一个 RestTemplate 的实例。RestTemplate 是一个 Spring 提供的 HTTP 请求工具，关于这个 RestTemplate 的详细用法下篇文章会给大家详细介绍，这里就先简单了解下，提供 RestTemplate 实例的代码如下：

```java
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

最后，再在 consumer 中添加一个 UseHelloController ，在这里去调用 provider 提供的服务，代码如下：

```java
@RestController
public class UseHelloController {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/hello")
    public String hello(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String s = restTemplate.getForObject("http://" + host + ":" + port + "/hello?name={1}", String.class, name);
        return s;
    }
}
```

这段代码对应的解释如下：

- 首先注入一个 DiscoveryClient，DiscoveryClient 可以用来从 Eureka 或者 Consul 上根据服务名查询一个服务的详细信息，注意 DiscoveryClient 的全路径是 `org.springframework.cloud.client.discovery.DiscoveryClient` ，大家不要导错包。至于这个 DiscoveryClient 从哪里来，下个小节和大家细说。
- 注入一个 RestTemplate 的实例，这个 RestTemplate 将用来发送 HTTP 请求，这个工具发送 HTTP 请求比较省事一些，当然读者在这里也可以选择使用 Java 自带的 HttpUrlConnection 或者其他第三方工具来发送 HTTP 请求。
- 在方法中，首先调用 DiscoveryClient 实例的 getInstances 方法，方法的参数就是要调用的微服务的名字，返回结果是一个 List 集合中放着 ServiceInstance 。之所以是 List 集合，那是因为 provider 可能是单机部署，也可能是集群部署，如果是集群部署的话，provider 实例就会有多个。
- ServiceInstance 中则保存了一个实例的详细信息，例如 host、port、schema、instanceId 等，ServiceInstance 也是一个接口，它有多个实现，这里使用的实现类是 EurekaServiceInstance。
- 由于这里我的 provider 实例只有一个，因此这里使用 list.get (0) 来获取实例。
- 从 ServiceInstance 中提取出微服务的关键地址信息 host 和 port ，然后拼接成一个请求地址。
- RestTemplate 的 getForObject 方法接收三个参数。第一个参数是请求地址，请求地址中的 {1} 表示一个参数占位符，第一个参数 String.class 表示返回的参数类型，第三个参数则是一个第一个占位符的具体值。

好了，经过如上步骤之后，此时我们分别启动 Eureka、provider 以及 consumer，然后在浏览器中访问 consumer 的 hello 接口，结果如下：
![图片描述](https://img1.sycdn.imooc.com/5d00dbaf00019b6c05480117.png)

可以看到，我们已经成功在 consumer 中调用 provider 提供的服务了。



**4. DiscoveryClient 从哪儿来？**

在上面一小节中，我们提到一个东西叫做 DiscoveryClient，那么这个东西到底是怎么来的呢？ 根据注释的描述，这个 DiscoveryClient 可以用来从 Eureka 或者 Consul 中查到一个服务的实例，不过这个 DiscoveryClient 只是一个接口而已，具体的还得一个类去实现，这个具体的实现类就是 CompositeDiscoveryClient , 当我们一个微服务启动时，在 CompositeDiscoveryClientAutoConfiguration 类中会自动配置一个 CompositeDiscoveryClient 的实例，CompositeDiscoveryClientAutoConfiguration 类源码如下：

```java
@Configuration
@AutoConfigureBefore(SimpleDiscoveryClientAutoConfiguration.class)
public class CompositeDiscoveryClientAutoConfiguration {

	@Bean
	@Primary
	public CompositeDiscoveryClient compositeDiscoveryClient(
			List<DiscoveryClient> discoveryClients) {
		return new CompositeDiscoveryClient(discoveryClients);
	}

}
```

当我们满心欢喜地来到 CompositeDiscoveryClient 类中，以为服务查找就是调用 CompositeDiscoveryClient 的 getInstances 方法，却发现事情好像没那么简单！ 真正的调用类是 CompositeDiscoveryClient 类中的 discoveryClients 属性提供的 DiscoveryClient，而 discoveryClients 属性默认集合中只有一条数据， 那就是 EurekaDiscoveryClient ，最终在 EurekaDiscoveryClient 类中，通过它里边的 EurekaClient 来获取了一个微服务的详细信息。

本文通过一个简单的案例，向大家展示了微服务中服务之间的调用过程。大家在学习过程中主要把握两个过程：

1. Server A 先根据 Server B 的名字去 Eureka 上获取 Server B 的地址；
2. Server A 有了 Server B 的地址后，再去调用 Server B。

本质上，调用过程就是一个 HTTP 请求，看着简单，其实并不简单，因为真正的调用过程中涉及到的问题非常多，例如负载均衡、服务容错、服务降级、异常处理、请求合并等等，这些问题，我们在后面的文章中都会向大家一一介绍。

#### 2）RestTemplate 用法详解

**RestTemplate 简介**

RestTemplate 是从 Spring3.0 开始支持的一个 HTTP 请求工具，它提供了常见的REST请求方案的模版，例如 GET 请求、POST 请求、PUT 请求、DELETE 请求以及一些通用的请求执行方法 exchange 以及 execute。RestTemplate 继承自 InterceptingHttpAccessor 并且实现了 RestOperations 接口，其中 RestOperations 接口定义了基本的 RESTful 操作，这些操作在 RestTemplate 中都得到了实现。接下来我们就来看看这些操作方法的使用。



**用法实战**

在开始下面的案例之前，我们需要先创建一个工程，命名为 RestTemplate 。和上篇文章的项目结构一样，在 RestTemplate 中，我们也分别创建子项目 eureka 、provider 以及 consumer ，将 provider 和 consumer 分别注册到 eureka 上面去。这个具体的步骤大家可以参考上篇文章，本文我就不赘述了，这是我们的准备工作。



**GET 请求**

做好了准备工作，先来看使用 RestTemplate 发送 GET 请求。在 RestTemplate 中，和 GET 请求相关的方法有如下几个：

![图片描述](https://img1.sycdn.imooc.com/5d00dbf10001676611540246.png)

这里的方法一共有两类，getForEntity 和 getForObject，每一类有三个重载方法，下面我们分别予以介绍。

**getForEntity**

既然 RestTemplate 发送的是 HTTP 请求，那么在响应的数据中必然也有响应头，如果开发者需要获取响应头的话，那么就需要使用 getForEntity 来发送 HTTP 请求，此时返回的对象是一个 ResponseEntity 的实例。这个实例中包含了响应数据以及响应头。例如，在 provider 中提供一个 HelloController 接口，HelloController 接口中定义一个 sayHello 的方法，如下：

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(String name) {
        return "hello " + name + " !";
    }
}
```

在 consumer 中定义一个 UseHelloController 的类，再定义一个 `/hello` 接口，在接口中调用 provider 提供的服务，如下：

```java
@RestController
public class UseHelloController {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://" + host + ":" + port + "/hello?name={1}";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, name);
        StringBuffer sb = new StringBuffer();
        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        sb.append("statusCode：")
                .append(statusCode)
                .append("</br>")
                .append("body：")
                .append(body)
                .append("</br>");
        HttpHeaders headers = responseEntity.getHeaders();
        Set<String> keySet = headers.keySet();
        for (String s : keySet) {
            sb.append(s)
                    .append(":")
                    .append(headers.get(s))
                    .append("</br>");
        }
        return sb.toString();
    }
}
```

关于 DiscoveryClient 那一段本文先不做讨论，主要来看 getForEntity 方法。第一个参数是 url ，url 中有一个占位符 {1} ,如果有多个占位符分别用 {2} 、 {3} … 去表示，第二个参数是接口返回的数据类型，最后是一个可变长度的参数，用来给占位符填值。在返回的 ResponseEntity 中，可以获取响应头中的信息，其中 getStatusCode 方法用来获取响应状态码， getBody 方法用来获取响应数据， getHeaders 方法用来获取响应头，在浏览器中访问该接口，结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dbfc000166bf09240302.png)

当然，这里参数的传递除了这一种方式之外，还有另外两种方式，也就是 getForEntity 方法的另外两个重载方法。

第一个是占位符不使用数字，而是使用参数的 key，同时将参数放入到一个 map 中。map 中的 key 和占位符的 key 相对应，map 中的 value 就是参数的具体值，例如还是上面的请求，利用 map 来传递参数，请求方式如下：

```java
Map<String, Object> map = new HashMap<>();
String url = "http://" + host + ":" + port + "/hello?name={name}";
map.put("name", name);
ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);
```

这种方式传参可能看起来更直观一些。

第二个是使用 Uri 对象，使用 Uri 对象时，参数可以直接拼接在地址中，例如下面这样：

```java
String url = "http://" + host + ":" + port + "/hello?name="+ URLEncoder.encode(name,"UTF-8");
URI uri = URI.create(url);
ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
```

但需要注意的是，这种传参方式，参数如果是中文的话，需要对参数进行编码，使用 `URLEncoder.encode` 方法来实现。

**getForObject**

getForObject 方法和 getForEntity 方法类似，getForObject 方法也有三个重载的方法，参数和 getForEntity 一样，因此这里我就不重复介绍参数了，这里主要说下 getForObject 和 getForEntity 的差异，这两个的差异主要体现在返回值的差异上， getForObject 的返回值就是服务提供者返回的数据，使用 getForObject 无法获取到响应头。例如，还是上面的请求，利用 getForObject 来发送 HTTP 请求，结果如下：

```java
String url = "http://" + host + ":" + port + "/hello?name=" + URLEncoder.encode(name, "UTF-8");
URI uri = URI.create(url);
String s = restTemplate.getForObject(uri, String.class);
```

注意，这里返回的 s 就是 provider 的返回值，如果开发者只关心 provider 的返回值，并不关系 HTTP 请求的响应头，那么可以使用该方法。



**POST 请求**

和 GET 请求相比，RestTemplate 中的 POST 请求多了一个类型的方法，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dc050001e88012780366.png)

可以看到，post 请求的方法类型除了 postForEntity 和 postForObject 之外，还有一个 postForLocation。这里的方法类型虽然有三种，但是这三种方法重载的参数基本是一样的，因此这里我还是以 postForEntity 方法为例，来剖析三个重载方法的用法，最后再重点说下 postForLocation 方法。

**postForEntity**

在 POST 请求中，参数的传递可以是 key/value 的形式，也可以是 JSON 数据，分别来看：

1. 传递 key/value 形式的参数

首先在 provider 的 HelloController 类中再添加一个 POST 请求的接口，如下：

```java
@PostMapping("/hello2")
public String sayHello2(String name) {
    return "Hello " + name + " !";
}
```

然后在 consumer 中添加相应的方法去访问，如下：

```java
@GetMapping("/hello5")
public String hello5(String name) {
    List<ServiceInstance> list = discoveryClient.getInstances("provider");
    ServiceInstance instance = list.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    String url = "http://" + host + ":" + port + "/hello2";
    MultiValueMap map = new LinkedMultiValueMap();
    map.add("name", name);
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, map, String.class);
    return responseEntity.getBody();
}
```

在这里， postForEntity 方法第一个参数是请求地址，第二个参数 map 对象中存放着请求参数 key/value，第三个参数则是返回的数据类型。当然这里的第一个参数 url 地址也可以换成一个 Uri 对象，效果是一样的。这种方式传递的参数是以 key/value 形式传递的，在 post 请求中，也可以按照 get 请求的方式去传递 key/value 形式的参数，传递方式和 get 请求的传参方式基本一致，例如下面这样：

```java
@GetMapping("/hello6")
public String hello6(String name) {
    List<ServiceInstance> list = discoveryClient.getInstances("provider");
    ServiceInstance instance = list.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    String url = "http://" + host + ":" + port + "/hello2?name={1}";
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, null, String.class,name);
    return responseEntity.getBody();
}
```

此时第二个参数可以直接传一个 null。

1. 传递 JSON 数据

上面介绍的是 post 请求传递 key/value 形式的参数，post 请求也可以直接传递 json 数据，在 post 请求中，可以自动将一个对象转换成 json 进行传输，数据到达 provider 之后，再被转换为一个对象。具体操作步骤如下：

首先在 RestTemplate 项目中创建一个新的maven项目，叫做 commons ，然后在 commons 中创建一个 User 对象，如下：

```java
public class User {
    private String username;
    private String address;
    //省略getter/setter
}
```

然后分别在 provider 和 consumer 的 pom.xml 文件中添加对 commons 模块的依赖，如下：

```xml
<dependency>
    <groupId>com.justdojava</groupId>
    <artifactId>commons</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

这样，在 provider 和 consumer 中就都能使用 User 对象了。首先在 provider 中创建一个添加用户的接口，如下：

```java
@Controller
@ResponseBody
public class UserController {
    @PostMapping("/user")
    public User hello(@RequestBody User user) {
        return user;
    }
}
```

这里的接口很简单，只需要将用户传来的 User 对象再原封不动地返回去就行了，然后在 consumer 中添加一个接口来测试这个接口，如下：

```java
@GetMapping("/hello7")
public User hello7() {
    List<ServiceInstance> list = discoveryClient.getInstances("provider");
    ServiceInstance instance = list.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    String url = "http://" + host + ":" + port + "/user";
    User u1 = new User();
    u1.setUsername("牧码小子");
    u1.setAddress("深圳");
    ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, u1, User.class);
    return responseEntity.getBody();
}
```

看到这段代码有人要问了，这不和前面的一样吗？是的，唯一的区别就是第二个参数的类型不同，这个参数如果是一个 MultiValueMap 的实例，则以 key/value 的形式发送，如果是一个普通对象，则会被转成 json 发送。

**postForObject**

postForObject 和 postForEntity 基本一致，就是返回类型不同而已，这里不再赘述。

**postForLocation**

postForLocation 方法的返回值是一个 Uri 对象，因为 POST 请求一般用来添加数据，有的时候需要将刚刚添加成功的数据的 URL 返回来，此时就可以使用这个方法，一个常见的使用场景如用户注册功能，用户注册成功之后，可能就自动跳转到登录页面了，此时就可以使用该方法。例如在 provider 中提供一个用户注册接口，再提供一个用户登录接口，如下：

```java
@RequestMapping("/register")
public String register(User user) throws UnsupportedEncodingException {
    return "redirect:/loginPage?username=" + URLEncoder.encode(user.getUsername(),"UTF-8") + "&address=" + URLEncoder.encode(user.getAddress(),"UTF-8");
}
@GetMapping("/loginPage")
@ResponseBody
public String loginPage(User user) {
    return "loginPage:" + user.getUsername() + ":" + user.getAddress();
}
```

这里一个注册接口，一个是登录页面，不过这里的登录页面我就简单用一个字符串代替了。然后在 consumer 中来调用注册接口，如下：

```java
@GetMapping("/hello8")
public String hello8() {
    List<ServiceInstance> list = discoveryClient.getInstances("provider");
    ServiceInstance instance = list.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    String url = "http://" + host + ":" + port + "/register";
    MultiValueMap map = new LinkedMultiValueMap();
    map.add("username", "牧码小子");
    map.add("address", "深圳");
    URI uri = restTemplate.postForLocation(url, map);
    String s = restTemplate.getForObject(uri, String.class);
    return s;
}
```

这里首先调用 postForLocation 获取 Uri 地址，然后再利用 getForObject 请求 Uri，结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dc15000104c206720160.png)

**注意：postForLocation 方法返回的 Uri 实际上是指响应头的 Location 字段，所以，provider 中 register 接口的响应头必须要有 Location 字段（即请求的接口实际上是一个重定向的接口），否则 postForLocation 方法的返回值为null，初学者很容易犯这个错误，如果这里出错，大家可以参考下我的源代码。**



**PUT 请求**

只要将 GET 请求和 POST 请求搞定了，接下来 PUT 请求就会容易很多了，PUT 请求本身方法也比较少，只有三个，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dc230001b38e08460122.png)

这三个重载的方法其参数其实和 POST 是一样的，可以用 key/value 的形式传参，也可以用 JSON 的形式传参，无论哪种方式，都是没有返回值的，我这里就举两个例子给大家参考下：

首先在 provider 的 UserController 中添加如下两个数据更新接口：

```java
@PutMapping("/user/name")
@ResponseBody
public void updateUserByUsername(User User) {
    System.out.println(User);
}
@PutMapping("/user/address")
@ResponseBody
public void updateUserByAddress(@RequestBody User User) {
    System.out.println(User);
}
```

这里两个接口，一个接收 key/value 形式的参数，另一个接收 JSON 参数。因为这里没有返回值，我直接把数据打印出来就行了。接下来在 consumer 中添加接口调用这里的服务，如下：

```java
@GetMapping("/hello9")
public void hello9() {
    List<ServiceInstance> list = discoveryClient.getInstances("provider");
    ServiceInstance instance = list.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    String url1 = "http://" + host + ":" + port + "/user/name";
    String url2 = "http://" + host + ":" + port + "/user/address";
    MultiValueMap map = new LinkedMultiValueMap();
    map.add("username", "牧码小子");
    map.add("address", "深圳");
    restTemplate.put(url1, map);
    User u1 = new User();
    u1.setAddress("广州");
    u1.setUsername("江南一点雨");
    restTemplate.put(url2, u1);
}
```

访问 `/hello9` 接口，即可看到 provider 上有日志打印出来，这里比较简单，我就不再演示。



**DELETE 请求**

和 PUT 请求一样，DELETE 请求也是比较简单的，只有三个方法，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dc2f00012a0407820126.png)

不同于 POST 和 PUT ，DELETE 请求的参数只能在地址栏传送，可以是直接放在路径中，也可以用 key/value 的形式传递，当然，这里也是没有返回值的。我也举两个例子：

首先在 provider 的 UserController 中添加两个接口，如下：

```java
@DeleteMapping("/user/{id}")
@ResponseBody
public void deleteUserById(@PathVariable Integer id) {
    System.out.println(id);
}
@DeleteMapping("/user/")
@ResponseBody
public void deleteUserByUsername(String username) {
    System.out.println(username);
}
```

两个接口，一个的参数在路径中，另一个的参数以 key/value 的形式传递，然后在 consumer 中，添加一个方法调用这两个接口，如下：

```java
@GetMapping("/hello10")
public void hello10() {
    List<ServiceInstance> list = discoveryClient.getInstances("provider");
    ServiceInstance instance = list.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    String url1 = "http://" + host + ":" + port + "/user/{1}";
    String url2 = "http://" + host + ":" + port + "/user/?username={username}";
    Map<String,String> map = new HashMap<>();
    map.put("username", "牧码小子");
    restTemplate.delete(url1, 99);
    restTemplate.delete(url2, map);
}
```

这里参数的传递和 GET 请求基本一致，我就不再赘述了。



**其他**

**设置请求头**

有的时候我们会有一些特殊的需求，例如模拟 cookie ，此时就需要我们自定义请求头了。自定义请求头可以通过拦截器的方式来实现（下篇文章我们会详细的说这个拦截器）。定义拦截器、自动修改请求数据、一些身份认证信息等，都可以在拦截器中来统一处理。具体操作步骤如下：

首先在 provider 中定义一个接口，在接口中获取客户端传来的 cookie 数据，如下：

```java
@GetMapping("/customheader")
public String customHeader(HttpServletRequest req) {
    return req.getHeader("cookie");
}
```

这里简单处理，将客户端传来的 cookie 拿出来后再返回给客户端，然后在 consumer 中添加如下接口来测试：

```java
@GetMapping("/hello11")
public void hello11() {
    List<ServiceInstance> list = discoveryClient.getInstances("provider");
    ServiceInstance instance = list.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    String url = "http://" + host + ":" + port + "/customheader";
    restTemplate.setInterceptors(Collections.singletonList(new ClientHttpRequestInterceptor() {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            HttpHeaders headers = request.getHeaders();
            headers.add("cookie","justdojava");
            return execution.execute(request,body);
        }
    }));
    String s = restTemplate.getForObject(url, String.class);
    System.out.println(s);
}
```

这里通过调用 RestTemplate 的 setInterceptors 方法来给它设置拦截器，拦截器也可以有多个，我这里只有一个。在拦截器中，将请求拿出来，给它设置 cookie ，然后调用 execute 方法让请求继续执行。此时，在 `/customheader` 接口中，就能获取到 cookie了。

**通用方法 exchange**

在 RestTemplate 中还有一个通用的方法 exchange。为什么说它通用呢？因为这个方法需要你在调用的时候去指定请求类型，即它既能做 GET 请求，也能做 POST 请求，也能做其它各种类型的请求。如果开发者需要对请求进行封装，使用它再合适不过了，举个简单例子：

```java
@GetMapping("/hello12")
public void hello12() {
    List<ServiceInstance> list = discoveryClient.getInstances("provider");
    ServiceInstance instance = list.get(0);
    String host = instance.getHost();
    int port = instance.getPort();
    String url = "http://" + host + ":" + port + "/customheader";
    HttpHeaders headers = new HttpHeaders();
    headers.add("cookie","justdojava");
    HttpEntity<MultiValueMap<String,String>> request =  new HttpEntity<>(null,headers);
    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
    System.out.println(responseEntity.getBody());
}
```

这里的参数和前面的也都差不多，注意就是多了一个请求类型的参数，然后创建一个 HttpEntity 作为参数来传递。 HttpEntity 在创建时候需要传递两个参数，第一个上文给了一个 null ，这个参数实际上就相当于 POST/PUT 请求中的第二个参数，有需要可以自行定义。HttpEntity 创建时的第二个参数就是请求头了，也就是说，如果使用 exchange 来发送请求，可以直接定义请求头，而不需要使用拦截器。

**小结**

本文主要向大家介绍了 RestTemplate 这样一个 HTTP 请求工具类的常见用法，一些比较冷门的用法本文并未涉及，读者有兴趣可以自行查找资料学习。由于 Spring、SpringMVC、Spring Boot、Spring Cloud 这些家族成员一脉相承，因此在 SpringMVC 中支持良好的 RESTful 风格的接口在后续的各个组件中都继续支持，在微服务接口设计时，大部分接口也都满足 RESTful 风格，使用 RestTemplate 则可以非常方便地发送 RESTful 风格的请求，因此这个工具的使用是我们后面学习的基础，常见的用法一定要熟练掌握。

#### 3）服务请求负载均衡

通过前面文章的学习，大家已经了解到如何搭建服务注册中心，如何将一个 provider 注册到服务注册中心， consumer 又如何从服务注册中心获取到 provider 的地址，在 consumer 获取 provider 地址时，我们一直采用了 DiscoveryClient 来手动获取，这样出现了大量冗余代码，而且负载均衡功能也没能实现。因此，本文我将和大家分享在微服务中如何实现负载均衡，以及负载均衡的实现原理、常见的负载均衡策略等。



**准备工作**

参考前面的文章，我们首先创建一个名为 Loadbalancer 的父工程，然后在父工程中创建一个名为 eureka 的服务注册中心，再创建一个名为 provider 的微服务， provider 中提供一个 `/hello` 接口， provider 中的 `/hello` 接口如下：

```java
@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name + " ; " + port;
    }
}
```

注意这里的 `/hello` 接口和前面我们学习的 `/hello` 接口有一点点不一样，这里我将当前应用运行的端口号注入进来，并且在接口中将端口号返回，这样主要是为了当大家从 consumer 中调用 provider 时，能够知道到底是哪个 provider 提供了服务。最后再在 provider 的 application.properties 文件中添加配置，将 provider 注册到服务注册中心上，如下：

```
spring.application.name=provider
server.port=4001
eureka.client.service-url.defaultZone=http://localhost:1111/eureka
```

完成之后，首先启动 eureka，然后在 IntelliJ IDEA 的右侧找到 Maven Project 选项，再找到 provider 项目，对 provider 项目进行打包，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dc5f0001857803880388.png)

打包成功后，在 provider/target 目录下会生成一个名为 provider-0.0.1-SNAPSHOT.jar 的 jar 包，然后打开两个命令行窗口，定位到 provider/target 目录下，分别执行如下两行命令：

```
java -jar provider-0.0.1-SNAPSHOT.jar --server.port=4001  
java -jar provider-0.0.1-SNAPSHOT.jar --server.port=4002
```

这两个命令各自在一个窗口中执行，执行完成后，将启动两个 provider 实例，两个实例的端口分别是 4001 和 4002 ，此时打开 eureka 控制面板，可以看到两个 provider 实例，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dc6b0001414910540580.png)

如此之后，我们的准备工作就算做完了。



**手动实现负载均衡**

现在，再创建一个 consumer ，并将之注册到 eureka 上，这个具体过程我这里就不再重复，不记得的同学可以参考本章前面两篇文章。

consumer 创建成功后，在 consumer 中创建一个 UseHelloController 的类，里边创建一个 `/hello` 接口，然后利用 DiscoveryClient 。我们先手动实现一个简单的基于轮询策略的负载均衡效果，具体代码如下：

```java
@RestController
public class UseHelloController {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    int count = 0;

    @GetMapping("/hello")
    public String hello(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(count % list.size());
        count++;
        String host = instance.getHost();
        int port = instance.getPort();
        String s = restTemplate.getForObject("http://" + host + ":" + port + "/hello?name={1}", String.class, name);
        return s;
    }
}
```

这里一个简单的轮询策略的负载均衡实现思路如下：

1. 由于 DiscoveryClient 可以从 eureka 上获取到 provider 的所有实例，这些获取到的所有实例保存在一个 List 集合中，因此所谓的轮询，实际上就是从 List 集合中循环取出 ServiceInstance 实例，组装成相关的地址去运行；
2. 基于第一步的分析，我们创建一个全局变量 count ，每次将集合大小与 count 取模，以取模的结果为下标，从 List 集合中取出相关的实例，然后拼接出请求地址。

这个过程其实很简单，轮询的逻辑也很简单，该方法执行结果如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dc79000129fa00730050.gif)

可以看到，服务是由端口为 4001 的 provider 和端口为 4002 的 provider 来轮流提供的。有没有发现负载均衡其实很简单！



**使用 @Loadbalancer 实现负载均衡**

上面是一个自己手动实现的负载均衡，代码量虽然不大，但是如果每次请求都这么写，实际上还是很头大，因为充斥着大量的代码冗余，此时，有人可能会想到上篇文章我们在讲解 RestTemplate 时提到的拦截器，如果能够在拦截器中将请求地址拦截下来，然后自动进行负载均衡计算，进而使用一个合适的地址去发送请求的话，就会方便很多。没错，实际上在 Spring Cloud 中也是这么做的！

在 Spring Cloud 中，要实现负载均衡其实非常容易，只需要在 RestTemplate 的Bean上添加一个 @LoadBalanced 注解即可，如下：

```java
@Bean
@LoadBalanced
RestTemplate loadBalancer() {
    return new RestTemplate();
}
```

此时的 RestTemplate 就是一个具备负载均衡功能的 RestTemplate 了，接下来，在 UseHelloController 中继续添加如下代码：

```java
@Autowired
@Qualifier("loadBalancer")
RestTemplate loadBalancer;
@GetMapping("/hello2")
public String hello2(String name) {
    String s = loadBalancer.getForObject("http://provider/hello?name={1}", String.class, name);
    return s;
}
```

是不是一下清爽了很多？关于这段代码，解释如下：

1. 由于现在项目中存在两个 RestTemplate 的实例，因此这里我加了 @Qualifier(“loadBalancer”) 注解，表示通过名称来查找 RestTemplate 的实例（如果继续根据类型来查找，系统会不知道到底注入哪个实例）；
2. 此时注入进来的 RestTemplate 实例自动就具备了负载均衡功能，但需要注意的是这里的请求地址，原本的 `Host+":"+Port` 被微服务名称所替代，实际上这个很好理解，因为这里如果还继续明确直接指定了服务地址的话，那还怎么负载均衡呀？
3. 这里使用了 provider 来代替 `Host+":"+Port` ，在真正的请求发起时，会通过拦截器将请求拦截下来，然后将 provider 换成一个具体的服务地址。

使用了具备负载均衡功能的 RestTemplate 之后，当我们再次启动 consumer ，发起一个网络访问时，可以在 IntelliJ IDEA 的控制台看到如下日志：
![图片描述](https://img1.sycdn.imooc.com/5d00dc830001769112380272.png)

可以看到， consumer 会自动从 eureka 上根据 provider 获取 provider 所有实例的信息，不仅仅包括实例的地址信息，也包括实例的历史请求数据等信息，根据这些辅助数据，可以实现不同的负载均衡策略。



**请求失败重试**

具备了负载均衡功能的 RestTemplate 也可以开启请求重试功能。有的时候，在微服务调用的过程中，由于网络抖动等原因造成了访问失败，这个时候如果直接就认定访问失败显然是不划算的，可以多尝试几次，多次尝试之后，如果还是请求失败，再判定访问失败。默认情况下，重试功能是没有开启的，开启重试功能很简单，开发者只需要在 consumer 中添加 Spring Retry 依赖即可，如下：

```xml
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
</dependency>
```

只要添加了该依赖，我们的 RestTemplate 此时就自动具备了请求失败重试的功能（注意，加入依赖后请求失败重试功能就会自动开启了），如果开发者加入了该依赖，但是又不想开启请求失败重试功能，可以在application.properties中添加如下配置：

```java
spring.cloud.loadbalancer.retry.enabled=false
```

表示关闭请求失败重试功能。至于请求失败重试的次数以及切换实例的次数，可以通过如下配置实现：

```
# 最大的重试次数，不包括第一次请求
ribbon.MaxAutoRetries=3
# 最大重试server的个数，不包括第一个 server
ribbon.MaxAutoRetriesNextServer=1
```

另外也可以指定是否开启任何异常都重试：

```java
ribbon.OkToRetryOnAllOperations=true
```



**客户端负载均衡**

细心的同学可能发现，这里我们所说的负载均衡和大家平时所了解到的负载均衡不太一样，平时我们所说的负载均衡一般是指 Nginx 或者 F5 之类的工具，其中 Nginx也叫反向代理代理服务器，它的工作流程如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dc8e0001905105240467.png)

所有的请求首先到达负载均衡服务器，再由负载均衡服务器根据提前配置好的负载均衡策略，将请求转发到不同的 Real Server 上，对于客户端来说，它并不知道究竟是哪一个 Real Server 提供的服务，这种负载均衡方式我们一般称之为服务端负载均衡。而上文我们提到的负载均衡则与这种方式不同，上文的负载均衡是先将 provider 的所有地址拿到，然后 consumer 根据本地配置的负载均衡策略，从 provider 地址列表中挑选一个地址去调用，调用过程如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dc960001cba903480472.png)

在这个调用过程中，客户端首先去 Eureka 中获取 provider 地址，获取到 provider 地址列表之后，再根据本地提前配置好的负载均衡策略从地址列表中挑选一个地址去调用，这个过程没有中间代理服务器，到底调用哪一个服务是由 consumer 自己决定的，因此这种负载均衡我们也称之为客户端负载均衡。



**常见负载均衡策略**

通过上面的学习，大家了解到，默认的负载均衡策略实际上是轮询，那么除了这种负载均衡策略之外，还有哪些负载均衡策略呢？又是如何配置的呢？我们继续来看。

要说负载均衡策略，就需要先向大家介绍一个接口叫做 ILoadBalancer ，它的源码如下：

```java
public interface ILoadBalancer {
	public void addServers(List<Server> newServers);  
	public Server chooseServer(Object key);  
	public void markServerDown(Server server);  
	@Deprecated  
	public List<Server> getServerList(boolean availableOnly);  
    public List<Server> getReachableServers();  
	public List<Server> getAllServers();  
}
```

从方法名大致就可以看出，这里有服务的添加、选择、标记服务下线、获取服务列表等功能，这个接口的实现类如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dc9d000168ca04170395.png)

在它的实现类 BaseLoadBalancer 中，去向 Eureka 获取服务列表，并不断地通过心跳消息去检查服务是否可用，有了服务列表之后，再根据具体的 IRule 进行负载均衡，所以，我们再来关注下 IRule ，这也是一个接口，它的实现类如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dca500015b4d10740395.png)

这里一个实现类就代表了一个负载均衡实现策略，例如：

- RandomRule 表示随机策略
- RoundRobinRule 表示轮询策略
- WeightedResponseTimeRule 表示加权策略（即将过期，功能和 ResponseTimeWeightedRule 一致）
- ResponseTimeWeightedRule 也是加权，它是根据每一个 Server 的平均响应时间动态加权，响应时间越长，权重越小，处理请求的机会也越小
- RetryRule 表示一个具备重试功能的负载均衡策略，内部默认使用了 RoundRobinRule 这个内部也可以自己传其他的负载均衡策略进去
- BestAvailableRule 策略表示使用并发数最小的服务

那么这些不同的负载均衡策略要如何去配置呢？很简单，需要哪种负载均衡，就提供哪种负载均衡的 IRule 实例就行了。例如，需要使用随机策略，那么只需要在 consumer 的配置类中提供一个 RandomRule 的实例即可，如下：

```java
@Bean
IRule iRule() {
    return new RandomRule();
}
```

此时，多次访问 provider 接口，就会发现负载均衡策略已经变为随机策略了。



**负载均衡原理**

网上关于负载均衡策略源码分析的文章很多，但是大多数都看得初学者丈二和尚摸不着头脑，因为这里确实涉及到的类比较多，因此本文换一个思路来和大家讲这个原理。关于负载均衡，大家可能会比较感兴趣服务列表到底是什么时候通过什么方式加载的？为什么在 RestTemplate 访问中不需要写服务的具体地址，而只需要给一个服务名就行了？所有的配置又是如何切入到 RestTemplate 中的？接下来，带着这些问题，我来和大家分析负载均衡具体的实现逻辑。



**服务列表加载问题**

首先第一个问题就是服务列表的加载问题。在前面的文章中，我们都是自己通过 DiscoveryClient 手动获取服务地址列表的，自从用了 @LoadBalanced 注解之后，我们不再需要自己手动加载地址了，直接写服务名就可以了，不用看源码我们也知道，服务名最终肯定要被转为一个具体的地址才能使用，那么这个过程到底是在哪里呢？

通过查看 @LoadBalanced 的源码我们发现凡是加了该注解的 RestTemplate 都会被自动配置一个 LoadBalancerClient ，LoadBalancerClient 只是一个接口，这个接口继承自 ServiceInstanceChooser 并且只有一个实现类 RibbonLoadBalancerClient ，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dcaf0001202802410233.png)

其中， ServiceInstanceChooser 里边只定义了一个方法，如下：

```java
public interface ServiceInstanceChooser {
	ServiceInstance choose(String serviceId);
}
```

看名字就知道，这个方法是用来根据 serviceId 获取 ServiceInstance 的， ServiceInstance 中则保存了一个服务的详细信息， LoadBalancerClient 接口在此基础上又增加了三个方法，如下：

```java
public interface LoadBalancerClient extends ServiceInstanceChooser {

	<T> T execute(String serviceId, LoadBalancerRequest<T> request) throws IOException;

	<T> T execute(String serviceId, ServiceInstance serviceInstance,
			LoadBalancerRequest<T> request) throws IOException;

	URI reconstructURI(ServiceInstance instance, URI original);

}
```

这里方法有三个， execute 方法用来做执行操作， reconstructURI 方法则用来重构 Url，也就是把 `http://provider/hello` 这样的地址变为 `http://localhost:4001/hello` 这样的形式。

这里只是一个接口，具体的实现在 RibbonLoadBalancerClient 类中。在该类中，首先来看服务的选择问题， choose 方法经过一系列的跳转最终来到了这里：

```java
public ServiceInstance choose(String serviceId, Object hint) {
	Server server = getServer(getLoadBalancer(serviceId), hint);
	if (server == null) {
		return null;
	}
	return new RibbonServer(serviceId, server, isSecure(server, serviceId),
			serverIntrospector(serviceId).getMetadata(server));
}
```

在这个方法中，首先使用 getServer 方法去获取服务，这个方法最终会来到 ILoadBalancer 接口的 chooseServer 方法中， ILoadBalancer 接口的继承关系如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dcb8000175d606040395.png)

默认情况下，在 RibbonLoadBalancerClient 类中注入的 ILoadBalancer 的实例是 ZoneAwareLoadBalancer ，但是 ZoneAwareLoadBalancer 继承自 DynamicServerListLoadBalancer ，而在 DynamicServerListLoadBalancer 的构造方法中，调用了 `restOfInit(clientConfig);` 方法，该方法源码如下：

```java
void restOfInit(IClientConfig clientConfig) {
    boolean primeConnection = this.isEnablePrimingConnections();
    // turn this off to avoid duplicated asynchronous priming done in BaseLoadBalancer.setServerList()
    this.setEnablePrimingConnections(false);
    enableAndInitLearnNewServersFeature();
    updateListOfServers();
    if (primeConnection && this.getPrimeConnections() != null) {
        this.getPrimeConnections()
                .primeConnections(getReachableServers());
    }
    this.setEnablePrimingConnections(primeConnection);
    LOGGER.info("DynamicServerListLoadBalancer for client {} initialized: {}", clientConfig.getClientName(), this.toString
}
```

在这个方法中，通过 updateListOfServers(); 去加载服务列表，而该方法会调用到 ServerList 接口中的 getUpdatedListOfServers 方法， ServerList 是一个接口，这个接口中定义了获取所有注册微服务信息的方法，它的最终实现类是 DomainExtractingServerList 。在 DomainExtractingServerList 中，我们终于看到了通过 EurekaClient 去获取服务列表的代码了，如下：

```java
    private List<DiscoveryEnabledServer> obtainServersViaDiscovery() {
        EurekaClient eurekaClient = eurekaClientProvider.get();
        if (vipAddresses!=null){
            for (String vipAddress : vipAddresses.split(",")) {
                List<InstanceInfo> listOfInstanceInfo = eurekaClient.getInstancesByVipAddress(vipAddress, isSecure, targetRegion);
                for (InstanceInfo ii : listOfInstanceInfo) {
                    //省略
                }
            }
        }
        return serverList;
    }
```

毫无疑问，这里最终会来到 DiscoveryClient 中获取服务地址列表。至此，大家应该知道了服务列表是在哪里加载了吧！



**请求地址替换问题**

那么请求地址又是怎么样从 `http://provider/hello` 变为 `http://localhost:4001/hello` 呢？上文我们提到了在 LoadBalancerClient 类中有一个方法叫做 reconstructURI ，这个方法就是用来重构 Url ，它的具体实现在 LoadBalancerContext 类的 reconstructURIWithServer 方法中，具体代码如下：

```java
public URI reconstructURIWithServer(Server server, URI original) {
    String host = server.getHost();
    int port = server.getPort();
    String scheme = server.getScheme();
    
    if (host.equals(original.getHost()) 
            && port == original.getPort()
            && scheme == original.getScheme()) {
        return original;
    }
    if (scheme == null) {
        scheme = original.getScheme();
    }
    if (scheme == null) {
        scheme = deriveSchemeAndPortFromPartialUri(original).first();
    }
    try {
        StringBuilder sb = new StringBuilder();
        sb.append(scheme).append("://");
        if (!Strings.isNullOrEmpty(original.getRawUserInfo())) {
            sb.append(original.getRawUserInfo()).append("@");
        }
        sb.append(host);
        if (port >= 0) {
            sb.append(":").append(port);
        }
        sb.append(original.getRawPath());
        if (!Strings.isNullOrEmpty(original.getRawQuery())) {
            sb.append("?").append(original.getRawQuery());
        }
        if (!Strings.isNullOrEmpty(original.getRawFragment())) {
            sb.append("#").append(original.getRawFragment());
        }
        URI newURI = new URI(sb.toString());
        return newURI;            
    } catch (URISyntaxException e) {
        throw new RuntimeException(e);
    }
}
```

方法参数 Server 中包含了服务的基本信息，original 则是待转换的 Url ，这里的逻辑整体比较好理解，就是将 Server 中的数据拿出来重新拼接地址。



**如何切入到 RestTemplate 中**

那么上面这些东西又是如何切入到 RestTemplate 中的呢？这里需要大家回忆一下上篇文章我们在介绍 RestTemplate 时讲过的拦截器，实际上，这里的功能也都是通过拦截器嵌入到 RestTemplate 的执行中的。

当我们的 classpath 下存在 RestTemplate ，并且项目中存在 LoadBalancerClient 的实例时，在 LoadBalancerAutoConfiguration 类中就会启动一个自动配置，部分源码如下：

```java
@Configuration
@ConditionalOnClass(RestTemplate.class)
@ConditionalOnBean(LoadBalancerClient.class)
@EnableConfigurationProperties(LoadBalancerRetryProperties.class)
public class LoadBalancerAutoConfiguration {
	@Configuration
	@ConditionalOnClass(RetryTemplate.class)
	public static class RetryInterceptorAutoConfiguration {

		@Bean
		@ConditionalOnMissingBean
		public RetryLoadBalancerInterceptor ribbonInterceptor(
				LoadBalancerClient loadBalancerClient,
				LoadBalancerRetryProperties properties,
				LoadBalancerRequestFactory requestFactory,
				LoadBalancedRetryFactory loadBalancedRetryFactory) {
			return new RetryLoadBalancerInterceptor(loadBalancerClient, properties,
					requestFactory, loadBalancedRetryFactory);
		}

		@Bean
		@ConditionalOnMissingBean
		public RestTemplateCustomizer restTemplateCustomizer(
				final RetryLoadBalancerInterceptor loadBalancerInterceptor) {
			return restTemplate -> {
				List<ClientHttpRequestInterceptor> list = new ArrayList<>(
						restTemplate.getInterceptors());
				list.add(loadBalancerInterceptor);
				restTemplate.setInterceptors(list);
			};
		}

	}
}
```

可以看到，在这里，自动向 RestTemplate 中加了一个拦截器 RetryLoadBalancerInterceptor ，正是这个拦截器将上面提到的所有功能给集成进来了，有兴趣的读者可以了解下具体的拦截过程，在 RetryLoadBalancerInterceptor 类的 intercept 方法中，通过 LoadBalancerClient 的实例进行了服务获取、负载均衡以及请求 Url 重构，该方法的逻辑就比较简单了，这里就不再赘述。

**小结**

本文首先带领读者手动实现了一个简易的负载均衡功能，然后向读者介绍了 RestTemplate 如何在框架中实现负载均衡以及请求失败重试等配置，并带着读者大致过了一下源码，实际上这里的源码并不复杂，抓住主线，然后通过 Debug 的方式很容易将思路理清。由于集群化部署是微服务一个重要的特点，因此，负载均衡策略以及配置方式大家一定要掌握。

### 4、服务消费OpenFeign

#### 1）声明式服务调用 Feign

在前面几篇文章中，主要和大家介绍了服务的注册与消费。在介绍过程中，我们从最最原始的手动利用 DiscoveryClient 发现服务开始，手动实现负载均衡，再到最后的自动化配置。相信经过前面几篇文章的学习，大家对微服务之间的调用应该有了一个基本的认知。但是我们前面的所有服务调用都是手动写 RestTemplate 来实现的，大家可能已经发现这样写有点麻烦，每次都要写请求 Url 、配置响应数据类型，最后还要组装参数，更重要的是这些都是一些重复的工作，代码高度相似，每个请求只有 Url 不同，请求方法不同、参数不同，其它东西基本都是一样的，既然如此，那有没有办法简化请求呢？有！这就是本文我们要聊的声明式微服务调用 Feign。不对，严格来说，应该叫 OpenFeign，为什么这么说呢？早期我们用的是叫 Netflix Feign，不过这个东西的最近一次更新还停留在 2016 年 7 月，OpenFeign 则是 Spring Cloud 团队在 Netflix Feign 基础上开发出来的声明式服务调用组件，OpenFeign 也一直在维护，具体的迁移工作，大家参考[这个 Issue](https://github.com/OpenFeign/feign/issues/373) 。



**准备工作**

和前面几篇文章的步骤一样，首先我们还是要先搭建一个父工程，然后创建一个服务注册中心。OK，那就开始吧！ 首先创建一个名为 Feign 的 Maven 父工程，然后在父工程中创建一个 eureka 工程充当我们的服务注册中心，具体步骤我这里就不再赘述了，大家如果忘了如何搭建服务注册中心，可以参考前面的文章。

服务注册中心搭建成功后，接下来我们还要再搭建一个 provider 用来提供服务。这个 provider 和前面 provider 的搭建也是基本一致的。 provider 搭建成功后，依然提供一个 HelloController 接口，里边配上一个 `/hello` 接口，像下面这样：

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name + " !";
    }
}
```

然后分别启动服务注册中心 eureka 以及服务提供者 provider ，然后浏览器中看到如下页面，表示我们的准备工作已经 OK 啦：

![图片描述](https://img1.sycdn.imooc.com/5d00dd2400012e7509480564.png)



**基本使用**

准备工作完成后，接下来我们创建一个 feign-consumer 微服务，不同于前面创建的 consumer ，这里的 feign-consumer 要多添加一个依赖，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dd2c0001ca7308910571.png)

项目创建成功后，添加的依赖如下：

```xml
<properties>
    <spring-cloud.version>Greenwich.SR1</spring-cloud.version>
</properties>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>
</dependencies>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

创建完成后，首先在 application.properties 文件上添加配置，将 feign-consumer 注册到 eureka 上，如下：

```
spring.application.name=feign-consumer
server.port=5002
eureka.client.service-url.defaultZone=http://localhost:1111/eureka
```

要使用 Feign , 首先在项目启动类上添加 `@EnableFeignClients` 注解表示开启 Feign 的支持，如下：

```java
@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

}
```

接下来创建一个 HelloService 接口，用来绑定 provider 提供的服务，如下：

```java
@FeignClient("provider")
public interface HelloService {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
```

这里声明了一个接口，然后做了两件事：

1. 使用 @FeignClient (“provider”) 注解将当前接口和 provider 服务绑定， provider 是服务名，大小写不敏感；
2. 然后使用 SpringMVC 的 @GetMapping ("/hello") 注解将 hello 方法和 provider 中的 hello 接口绑定在一起。需要注意的是，在 SpringMVC 中，在需要给参数设置默认值或者要求参数必填的情况下才需要用到 @RequestParam 注解，而在这里，这个注解一定要加。

经过这样的步骤之后，我们就可以在一个 Controller 中注入 HelloService 接口并使用它了，而 HelloService 接口也会去调用相关的服务。我的 Controller 如下：

```java
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.hello(name);
    }
}
```

此时，启动 feign-consumer ，然后在浏览器中访问 `http://localhost:5002/hello?name=纯洁的微笑` ，显示效果如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dd3b0001eb6404510075.png)

这样，我们就成功在 feign-consumer 中调用了 provider 提供的服务了，是不是比之前手写 RestTemplate 调用要方便很多？



**参数传递**

上面和大家展示了 Feign 的基本使用。接下来和大家说说 Feign 中的参数传递问题，相信对于大多数人而言，在开发中，参数传递无非就是 key/value 形式的参数、放在 body 中的参数、放在 Url 路径上的参数以及放在请求头上的参数，这四种是较为常见的四种传参方式，因此，这里就重点和大家分享下这四种不同的传参方式在 Feign 中要如何使用。

首先，在 Feign 工程中再创建一个 Maven 子工程叫做 commons，在 commons 中定义一个 User 类，如下：

```java
public class User {
    private Long id;
    private String username;
    private String address;
    //省略getter/setter
}
```

然后在 provider 和 feign-consumer 的 pom.xml 文件中分别引用该工程，如下：

```xml
<dependency>
    <groupId>com.justdojava</groupId>
    <artifactId>commons</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

接下来，在 provider 中添加 UserController 类，并添加如下接口，各个接口分别使用不同的方式来接收参数：

```java
@RestController
public class UserController {
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        System.out.println(id);
    }
    @GetMapping("/user")
    public User getUserByName(@RequestParam String name) {
        User user = new User();
        user.setUsername(name);
        return user;
    }
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return user;
    }
    @PutMapping("/user")
    public void updateUserById(@RequestHeader String name, @RequestHeader Long id) {
        System.out.println("name:" + name + ";id:" + id);
    }
}
```

关于上面这一段代码，我说如下几点：

1. 简单起见，这里我在 provider 中并未调用数据库，只是将调用的模拟结果打印出来或者返回去，证明接口调通了即可；
2. 在第一个删除方法中，将参数放在 Url 路径中；
3. 在第二个查询方法中，将参数以 key/value 的形式传递；
4. 在第三个添加数据的方法中，参数将以请求体的方式传递；
5. 在第四个更新的方法中，参数以请求头的方式传递，这种传递方式注意不能传递中文，如果是中文参数，在传递之前，可以使用 URLEncoder.encode () 方法对参数进行编码，在接收到参数之后，使用 URLDecoder.decode () 方法对参数进行解码。

provider 定义完成后，接下来重新启动 provider ，然后我们继续在 feign-consumer 中添加调用代码，如下：

```java
@FeignClient("provider")
public interface HelloService {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
    @DeleteMapping("/user/{id}")
    void deleteUserById(@PathVariable("id") Long id);
    @GetMapping("/user")
    User getUserByName(@RequestParam("name") String name);
    @PostMapping("/user")
    User addUser(@RequestBody User user);
    @PutMapping("/user")
    void updateUserById(@RequestHeader("name") String name, @RequestHeader("id") Long id);
}
```

这里的调用，基本也和前面一样，无需赘述，但是有一个地方需要强调，那就是不同于 provider ，这里的参数如果是 key/value 形式的，一定要在 @RequestParam 注解中指明 name 属性，如果是在 header 中传递的，则一定要在 @RequestHeader 注解中添加 name 属性，如果参数放在 Url 路径中，那么一定需要在 @PathVariable 注解中添加 name 属性指明参数名称。

配置完成后，在 feign-consumer 的 HelloController 中添加一个接口用来测试，如下：

```java
@GetMapping("/hello2")
public void hello2() {
    helloService.deleteUserById(99L);
    User u2 = helloService.getUserByName("纯洁的微笑");
    System.out.println(u2);
    u2.setId(98L);
    u2.setAddress("深圳");
    User u3 = helloService.addUser(u2);
    System.out.println(u3);
    helloService.updateUserById("lenve", 99L);
}
```

调用该接口，在 provider 和 feign-consumer 中都会有日志打印出来，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dd4d0001570101990074.png)
![图片描述](https://img1.sycdn.imooc.com/5d00dd62000101c103740061.png)

看到如上两张图，表示我们的接口已经调用成功啦！

本节主要通过两个案例向读者介绍了声明式服务调用的一个基本用法。相信有一部分读者在读完本节后，会很容易想到 MyBatis，很多人在刚开始学习 MyBatis 的时候，并不是一上来就使用 Mapper ，而是先从简单的 SqlSessionFactory 开始，在使用的过程中，发现了大量的模板化代码，于是才有了 Mapper ，使用了动态代理启动生成调用逻辑，开发者只需要生命最最关键的部分。MyBatis 中的这一演变过程和我们这里的演变如出一辙， 直接使用 RestTemplate 也带来了大量的模板化代码，通过 Feign ，我们只需要定义一下方法中最最关键的部分，就能实现调用。那么有人要问了，用了 Feign ，我们在 RestTemplate 中使用的负载均衡还能继续用吗？答案当然是可以继续使用，关于这个问题以及 Feign 的一些高级用法，我将在下篇文章中和大伙儿分享。

#### 2）Feign 中的继承、日志与数据压缩

上篇文章和大家分享了声明式微服务调用组件 Feign 的基本用法，相信大家已经了解到使用 Feign 的好处了，使用 Feign 有效地解决了使用 RestTemplate 时的代码模板化的问题，使服务之间的调用更加简单方便，同时也不易出错。不过，细心的读者可能也发现，上篇文章中我们学的 Feign 还是有一些明显的缺陷，例如，当我们在 provider 中定义接口时，可能是下面这样：

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name + " !";
    }
}
```

然后在 feign-consumer 中定义接口的调用，又是下面这样：

```java
@FeignClient("provider")
public interface HelloService {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
```

这两段代码其实也有部分重复了，例如接口的定义、请求参数绑定、方法返回值等，都是一样的，只是一个有接口的具体实现，一个没有具体实现而已。这些相同的代码如果写错了，还有可能导致调用失败，例如 provider 中写了 `@GetMapping("/hello")` ，而 feign-consumer 中写了 `@GetMapping("/hello2")` ，此时就会调用失败，那么如何避免这些问题呢？这就要使用到我们本文介绍到的 Feign 的继承特性。另外，Feign 中的操作日志可以帮助我们快速定位问题，数据压缩特性又能够提高数据传输效率，这些知识点，我将在本文和大家分享。



**准备工作**

和前面的文章一样，我们需要先做一些准备工作。首先创建一个名为 FeignAdvanced 的父工程，然后在父工程中创建一个子模块 eureka 服务注册中心并启动，具体的操作步骤我这里就不再赘述，大家要是忘记了，可以参考上一章的第一小节。

然后再在 FeignAdvanced 工程中创建一个子模块 commons。注意，这个子模块是一个 Maven 工程，而不是 Spring Boot 工程，因为这个模块我只是用它来提供公共接口。

![图片描述](https://img1.sycdn.imooc.com/5d00dd8d0001a8ce03290167.png)

commons 模块创建成功后，因为要在 commons 模块中使用 SpringMVC 的一整套东西，方便起见，在 commons 模块的 pom.xml 文件中添加如下依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>2.1.3.RELEASE</version>
</dependency>
```

添加成功后，再在 commons 中添加一个 HelloService 接口：

```java
public interface HelloService {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
```

在这个 HelloService 接口中，我们会将前面提到的 provider 和 feign-consumer 中公共的部分抽取出来定义在这里，然后在 provider 中调用这个接口，在 feign-consumer 中实现这个接口。

好了， HelloService 接口定义完成后，我们的准备工作就算是OK啦，接下来我们就来看看具体的继承特性要如何去实现。



**继承特性**

Feign 中继承，我们整体可以分两步来实现：

1. 在 provider 中实现公共接口；
2. 在 feign-consumer 中去调用接口。

我们分别来看。



**在 provider 中实现接口**

首先创建一个 provider 微服务项目，创建成功后，将刚刚创建的 commons 项目的依赖添加进来，完整的 pom.xml 文件如下：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>com.justdojava</groupId>
    <artifactId>commons</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

然后修改 provider 的配置文件，将 provider 微服务注册到 eureka 服务注册中心上，这一步也比较简单，不赘述。

接下来，我们在 provider 中定义一个 HelloController 来实现 commons 模块中的 HelloService 接口，如下：

```java
@RestController
public class HelloController implements HelloService {
    @Override
    public String hello(String name) {
        return "hello " + name + " !";
    }
}
```

做完这一切之后，就可以启动 provider 啦！ provider 启动成功后，我们来继续开发 feign-consumer 。



**在 feign-consumer 中调用接口**

接下来我们在 FeignAdvanced 工程中再创建一个子模块 feign-consumer ，注意创建时候除了选择 Eureka Discovering 依赖之外，还需要选择 Feign 的依赖，具体步骤和上文一致，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dda60001ca7308910571.png)

项目创建成功后，也将 commons 模块加入到 pom.xml 文件中，如下：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<dependency>
    <groupId>com.justdojava</groupId>
    <artifactId>commons</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

然后修改 feign-consumer 的配置文件 application.properties ，将 feign-consumer 注册到 eureka 服务注册中心上，这一步就比较简单，我这里就不再赘述。

接下来，和前面的步骤一样，在项目的启动类上添加 @EnableFeignClients 注解，开启 Feign 的使用：

```java
@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

}
```

再接下来创建的 FeignHelloService 接口继承自 HelloSerivce 接口，如下：

```java
@FeignClient("PROVIDER")
public interface FeignHelloService extends HelloService {
}
```

注意，不同于上篇文章中的 HelloService 接口，这里的 FeignHelloService 接口直接继承自 HelloSerivce ，继承之后， FeignHelloService 自动具备了 HelloService 中的接口，因此可以在使用 @FeignClient(“PROVIDER”) 注解绑定服务之后就可以直接使用了。

最后，我们来创建一个 UseHelloController，在 UseHelloController 中来使用 FeignHelloService，如下：

```java
@RestController
public class UseHelloController {
    @Autowired
    FeignHelloService feignHelloService;
    @GetMapping("/hello")
    public String hello(String name) {
        return feignHelloService.hello(name);
    }
}
```

配置完成后，启动 feign-consumer ，在浏览器中就可以访问 feign-consumer 了，通过 feign-consumer 就能调用 provider 的服务了。
![图片描述](https://img1.sycdn.imooc.com/5d00ddb90001347604680084.png)



**优缺点分析**

通过上面案例的搭建，相信大家对 Feign 的继承特性已经有了一个大致的了解，那么这种写法和上篇文章我们的写法各自有什么优缺点呢？我们来分析下：

1. 使用继承特性，代码简洁明了，不易出错，不必担心接口返回值是否写对，接口地址是否写对。如果接口地址有变化，也不用 provider 和 feign-consumer 大动干戈，只需要修改 commons 模块即可，provider 和 feign-consumer 就自然变了；
2. 前面提到的在 feign-consumer 中绑定接口时，如果是 key/value 形式的参数或者放在 header 中的参数，就必须要使用 @RequestParam 注解或者 @RequestHeader 注解，这个规则在这里一样适用。即在 commons 中定义接口时，如果涉及到相关参数，该加的@RequestParam 注解或者 @RequestHeader 注解一个都不能少；
3. 当然，使用了继承特性也不是没有缺点。继承的方式将 provider 和 feign-consumer 绑定在一起，代码耦合度变高，一变俱变，此时就需要严格的设计规范，否则会牵一发而动全身，增加项目维护的难度。

好了，通过上面这样一个简单的案例，相信大家对 Feign 的继承特性已经有所了解。



**日志配置**

使用了 Feign 之后，如果希望能够查看微服务之间调用的日志，则可以通过开启 Feign 的日志功能实现， Feign 中的日志级别一共分为四种：

1. NONE ，不开启日志记录，默认即此；
2. BASIC ，记录请求方法和请求 URL ，以及响应的状态码以及执行时间；
3. HEADERS ，在第2条的基础上，再增加请求头和响应头；
4. FULL ，在第3条的基础上再增加 body 以及元数据。

那么具体的配置是怎样的呢？很简单，首先在配置类中配置一个日志级别的 Bean ，我这里直接放在系统启动类中，如下：

```java
@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
    
    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }
}
```

然后在 application.properties 中开启日志级别。注意， Feign 中的日志只对 DEBUG 级别的日志输出进行响应：

```
logging.level.com.justdojava.feignconsumer.FeignHelloService=debug
```

这里 logging.level 是指日志级别的前缀，com.justdojava.feignconsumer.FeignHelloService 表示该 class 以 debug 级别输出日志。当然，类路径也可以是一个 package ，这样就表示该 package 下的所有 class 以 debug 级别输出日志。配置完成后，重启 feign-consumer 项目，访问其中任意一个接口，就可以看到请求日志，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00ddc40001840e12470227.png)



**数据压缩**

使用 Feign 执行请求时，也可以对请求数据执行 GZIP 压缩，提高数据传输效率。具体配置如下：

```
feign.compression.request.enabled=true
feign.compression.response.enabled=true
feign.compression.request.mime-types=text/html,application/json
feign.compression.request.min-request-size=2048
```

前两行表示开启请求和响应压缩，第三行表示压缩的数据类型，默认是 `text/html,application/json,application/xml` ，第四行表示压缩数据的下限，即当要传输的数据大于2048时才需要对请求进行压缩。



**请求重试**

Feign 中默认也自带请求重试功能，即这里不需要添加 `spring-retry` 依赖，直接配置即可使用：

```
# 最大的重试次数，不包括第一次请求
ribbon.MaxAutoRetries=3
# 最大重试server的个数，不包括第一个 server
ribbon.MaxAutoRetriesNextServer=1
# 是否开启任何异常都重试
ribbon.OkToRetryOnAllOperations=false
```

这样的配置，请求失败重试适用于所有的请求，也可以配置专门针对某一个微服务的请求失败重试，例如专门配置针对 provider 微服务的请求失败重试，如下：

```
#最大的重试次数
provider.ribbon.MaxAutoRetries=3
#最大重试server的个数
provider.ribbon.MaxAutoRetriesNextServer=1
#是否开启任何异常都重试
provider.ribbon.OkToRetryOnAllOperations=false
```

这样，就可以针对不同的微服务配置不同的请求失败重试策略。

也可以不配置 application.properties ，而是通过提供如下一个 Bean 来实现请求重试：

```java
@Bean
public Retryer feignRetryer() {
    Retryer.Default retryer = new Retryer.Default();
    return retryer;
}
```

**小结**

本文主要向大家介绍了声明式微服务调用工具 Feign 的一些高级特性，例如继承机制、日志配置、请求压缩、请求重试等，并对继承特性的优缺点进行了分析。在实际开发中，灵活地使用这些属性，可以使我们的微服务以一个更高的效率运行。通过对这些特性的学习，相信大家对 Feign 将会有一个更深刻的认识。

### 5、服务容错保护 Resilience4j

#### 1）Resilience4j基本用法详解

和传统架构相比，微服务有一个非常严重的问题常常被人诟病。什么问题呢？就是故障率。在传统架构中，我们可以将故障率降到很低，但是在微服务中，这一点却不太容易做到，因为单个微服务的故障率即使降低了，但假如有1000台机器，那么整个系统正常运行的概率就是 (1-故障率)^1000 ，经过这样一个幂运算之后，你会发现系统正常运行的概率低得吓人，而且如果处理不好的话还会发生服务雪崩(故障蔓延)，什么是服务雪崩呢？看如下一张调用图：

![图片描述](https://img1.sycdn.imooc.com/5d00de09000197ec05130190.png)

假设我们的客户端现在调用订单微服务去执行一个下单操作，在订单微服务中调用了支付微服务，假设现在支付微服务挂了，订单调用支付迟迟没有响应，在高并发环境下，订单微服务上积累的请求越来越多，本来订单微服务没有问题，现在也被拖挂了，这就是服务雪崩，也叫故障蔓延。那么我们能做的就是在某一个服务挂掉的时候，不能发生故障蔓延，同时整个系统还能以某种形式正常运行。这是我们的目标，为了实现这些目标，我们一般有如下几种解决方案。

**Netflix Hystrix**

Netflix Hystrix 断路器是 Spring Cloud 中最早就开始支持的一种服务调用容错解决方案，但是目前的 Hystrix 已经处于维护模式了，虽然这并不影响已经上线的项目，并且在短期内，你甚至也可以继续在项目中使用 Hystrix 。但是长远来看，处于维护状态的 Hystrix 走下历史舞台只是一个时间问题，特别是在 Spring Cloud Greenwich 版中，官方已经给出了 Hystrix 的建议替代方案（参见[Spring Cloud Greenwich.RELEASE is now available](https://spring.io/blog/2019/01/23/spring-cloud-greenwich-release-is-now-available)一文），如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00de1300012e0d06740215.png)

在 Spring Cloud Greenwich 版中，对于 Hystrix 以及 Hystrix Dashboard 官方都给出了替代方案。我们整个教程虽然基于最新的 Spring Cloud Greenwich 版，但是考虑到现实情况，本文中我还是先向大家大致介绍一下 Hystrix 的功能，后面我们会详细介绍 Resilience4j 的用法。

**服务熔断**

Hystrix 提供的第一个功能就是熔断。当然这里说的熔断不是股市的熔断，是指在当 A 服务调用 B 服务时，如果迟迟没有得到响应，就终止当前请求，而不是傻傻地等下去，避免 A 服务上出现大量的请求阻塞导致故障蔓延，这就是熔断，当然一般来说熔断器的功能还不止这些。当系统发生熔断之后，熔断器还要负责监控 B 服务，当发现 B 服务可以使用时，则再次发起调用。

**服务降级**

当服务调用发生熔断之后，接下来要做的就是服务降级了。例如当 A 服务调用 B 服务，没有调用成功，发生了熔断，那么此时 A 服务退而求其次，可能先从一个缓存微服务上先拿一个缓存数据顶着（我这里只是举一个简单的例子），避免给用户响应一个错误页面，这个就是服务降级。

**请求缓存**

通过对请求接口进行缓存，也能有效降低服务提供者的压力，当然请求缓存使用场景是那种数据更新频率较低但是访问又比较频繁的数据。

注意这里说的缓存是指 Hystrix 自带的缓存，在实际开发中，我们可能还需要配合自己的 Redis 缓存来实现更好的数据缓存效果。

**请求合并**

不同于 Dubbo ，Spring Cloud 中微服务之间的调用都是通过 HTTP 来实现的。由于 HTTP 协议本身的特点，在微服务调用时，如果是高并发小数据量的话，效率并不高，此时可以通过请求合并来实现，即将客户端的多个请求合并成一个，发送一个 HTTP 请求，拿到请求结果后，再将请求结果分发到不同的请求中，这样可以高效率传输数据。

当然， Hystrix 提供的功能不止这些，还包括资源隔离、对依赖服务分类等，这里就不再一一细说了。

**Resilience4j**

Resilience4j 是 Spring Cloud Greenwich 版推荐的容错解决方案，它是一个轻量级的容错库，受 Netflix Hystrix 的启发而设计，它专为 Java 8 和函数式编程而设计。Resilience4j 非常轻量级，因为它的库只使用 Vavr （以前称为 Javaslang ），它没有任何其他外部库依赖项。相比之下， Netflix Hystrix 对Archaius 具有编译依赖性，这导致了更多的外部库依赖，例如 Guava 和 Apache Commons 。而如果使用Resilience4j，你无需引用全部依赖，可以根据自己需要的功能引用相关的模块即可。

Resilience4j 也提供了一系列增强微服务可用性的功能，主要功能如下：

1. 断路器
2. 限流
3. 基于信号量的隔离
4. 缓存
5. 限时
6. 请求重试

接下来，我们就先来看看 Resilience4j 中这几个功能的基本用法。

介绍 Resilience4j 的基本用法，我们需要首先搭建一个测试环境。这里我们先来说 Resilience4j 的基本用法，下篇文章再来说在 Spring Boot 中的用法，因此这里我只需要创建一个名为 Resilience4j 的普通的 Maven 项目即可。上面提到的 Resilience4j 中的功能，每一个功能都对应了一个依赖，这些依赖在下面的讲解中，我会分别添加进来，这样大家就能知道到底哪个依赖对应哪个功能。另外，由于我使用单元测试来演示 Resilience4j 的用法，因此创建好 Maven 项目后，再加入单元测试依赖，如下：

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
```

好了，工程创建好了准备工作就算 OK 了。

**断路器**

**断路器初始化**

使用 Resilience4j 提供的断路器功能，需要我们首先加入如下依赖：

```xml
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-circuitbreaker</artifactId>
    <version>0.13.2</version>
</dependency>
```

这个库提供了一个基于 ConcurrentHashMap 的 CircuitBreakerRegistry ，CircuitBreakerRegistry 是线程安全的，并且是原子操作。开发者可以使用 CircuitBreakerRegistry 来创建和检索 CircuitBreaker 的实例 ，开发者可以直接使用默认的全局CircuitBreakerConfig 为所有 CircuitBreaker 实例创建 CircuitBreakerRegistry ，如下所示：

```java
CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.ofDefaults();
```

当然开发者也可以提供自己的 CircuitBreakerConfig ，然后根据自定义的 CircuitBreakerConfig 来创建一个 CircuitBreakerRegistry 实例，进而创建 CircuitBreaker 实例。如果我们使用自定义的 CircuitBreakerConfig ，可以配置如下参数：

- 故障率阈值百分比，超过这个阈值，断路器就会打开
- 断路器保持打开的时间，在到达设置的时间之后，断路器会进入到 half open 状态
- 当断路器处于 half open 状态时，环形缓冲区的大小
- 当断路器关闭时，环形缓冲区的大小
- 自定义断路器中的事件操作
- 自定义 Predicate 以便计算异常是否被记录为失败事件

具体定义如下：

```java
CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
    .failureRateThreshold(50)
    .waitDurationInOpenState(Duration.ofMillis(1000))
    .ringBufferSizeInHalfOpenState(2)
    .ringBufferSizeInClosedState(2)
    .build();
CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);
CircuitBreaker circuitBreaker2 = circuitBreakerRegistry.circuitBreaker("otherName");
CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("uniqueName", circuitBreakerConfig);
```

上面的代码，首先定义了一个 CircuitBreakerConfig 对象。在定义 CircuitBreakerConfig 对象时，设置了故障率阈值为 50% ，断路器保持打开时间为 2 秒。当断路器处于 half open 状态时，环形缓冲区大小为2，当对象处于关闭状态时，环形缓冲区大小也为2，然后根据创建出来的 CircuitBreakerConfig 对象创建一个 CircuitBreakerRegistry ，再根据 CircuitBreakerRegistry 创建两个断路器 CircuitBreaker 。

如果开发者不想使用 CircuitBreakerRegistry 来管理断路器，那么也可以直接创建一个 CircuitBreaker 对象，创建方式如下：

```java
CircuitBreaker defaultCircuitBreaker = CircuitBreaker.ofDefaults("testName");
CircuitBreaker customCircuitBreaker = CircuitBreaker.of("testName", circuitBreakerConfig);
```

**断路器使用案例**

断路器使用了装饰者模式，开发者可以使用 CircuitBreaker.decorateCheckedSupplier(), CircuitBreaker.decorateCheckedRunnable() 或者 CircuitBreaker.decorateCheckedFunction() 来装饰 Supplier / Runnable / Function 或者 CheckedRunnable / CheckedFunction，然后使用 Try.of(…) 或者 Try.run(…) 来进行调用操作，也可以使用 map、flatMap、filter、recover 或者 andThen 进行链式调用，但是调用这些方法断路器必须处于 CLOSED 或者 HALF_OPEN 状态。例如下面一个例子，创建一个断路器出来，首先装饰了一个函数，这个函数返回一段字符串，然后使用 Try.of 去执行，执行完后再进入到 map 中去执行。如果第一个函数正常执行第二个函数才会执行，如果第一个函数执行失败，那么 map 函数将不会执行：

```java
CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("testName");
CheckedFunction0<String> decoratedSupplier = CircuitBreaker
        .decorateCheckedSupplier(circuitBreaker, () -> "This can be any method which returns: 'Hello");
Try<String> result = Try.of(decoratedSupplier)
        .map(value -> value + " world'");
System.out.println(result.isSuccess());
System.out.println(result.get());
```

这里两个函数使用了相同的断路器，你也可以将不同断路器的函数连接起来，如下：

```java
CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("testName");
CircuitBreaker anotherCircuitBreaker = CircuitBreaker.ofDefaults("anotherTestName");
CheckedFunction0<String> decoratedSupplier = CircuitBreaker
        .decorateCheckedSupplier(circuitBreaker, () -> "Hello");
CheckedFunction1<String, String> decoratedFunction = CircuitBreaker
        .decorateCheckedFunction(anotherCircuitBreaker, (input) -> input + " world");
Try<String> result = Try.of(decoratedSupplier)
        .mapTry(decoratedFunction::apply);
System.out.println(result.isSuccess());
System.out.println(result.get());
```

**断路器打开**

这里创建了两个 CircuitBreaker ，装饰了两个函数，第二次使用了 mapTry 方法来连接。前面给大家演示的几种情况，都是执行成功的，即断路器一直处于关闭的状态，接下来给大家再来演示一个断路器打开的例子，如下：

```java
CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
        .ringBufferSizeInClosedState(2)
        .waitDurationInOpenState(Duration.ofMillis(1000))
        .build();
CircuitBreaker circuitBreaker = CircuitBreaker.of("testName", circuitBreakerConfig);
circuitBreaker.onError(0, new RuntimeException());
System.out.println(circuitBreaker.getState());
circuitBreaker.onError(0, new RuntimeException());
System.out.println(circuitBreaker.getState());
Try<String> result = Try.of(CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> "Hello"))
        .map(value -> value + " world");
System.out.println(result.isSuccess());
System.out.println(result.get());
```

这里手动模拟错误，首先设置了断路器关闭状态下的环形缓冲区大小为 2 ，即当有两条数据时就可以去统计故障率了，这里没有设置故障率，默认的故障率是 50% ，当第一次调用 onError 方法后，打印断路器当前状态，发现断路器还是处于关闭状态，并未打开，接下来再次调用 onError 方法，然后再去查看断路器状态，此时发现断路器已经打开了，因为满足了 50% 的故障率了。

**断路器重置**

断路器也支持重置，重置之后数据清空，恢复到初始状态，如下：

```java
circuitBreaker.reset();
```

**服务请求降级**

既然是断路器，当然也支持服务降级，如下：

```java
CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("testName");
CheckedFunction0<String> checkedSupplier = CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> {
    throw new RuntimeException("BAM!");
});
Try<String> result = Try.of(checkedSupplier)
        .recover(throwable -> "Hello Recovery");
System.out.println(result.isSuccess());
System.out.println(result.get());
```

如果需要使用服务降级，可以使用 Try.recover() 链接，当 Try.of() 返回 Failure 时服务降级会被触发。

**状态监听**

状态监听可以获取到熔断器当前的运行数据，例如：

```java
CircuitBreaker.Metrics metrics = circuitBreaker.getMetrics();
// 获取故障率
float failureRate = metrics.getFailureRate();
// 获取调用失败次数
int failedCalls = metrics.getNumberOfFailedCalls();
```

**限流**

RateLimiter 和我们前面提到的断路器实际上非常类似，它也有一个基于内存的 RateLimiterRegistry 和 RateLimiterConfig 可以配置，我们可以配置如下一些参数：

- 限流之后的冷却时间
- 阈值刷新时间
- 阈值刷新频次

使用限流工具，我们当然需要首先引入限流工具的依赖，如下：

```xml
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-ratelimiter</artifactId>
    <version>0.13.2</version>
</dependency>
```

**基本用法**

例如，想限制某个请求的频率为 2QPS（每秒处理两个请求），为什么给一个这样的频率呢？主要是为了大家一会儿测试方便，代码如下：

```java
RateLimiterConfig config = RateLimiterConfig.custom()
        .limitRefreshPeriod(Duration.ofMillis(1000))
        .limitForPeriod(2)
        .timeoutDuration(Duration.ofMillis(1000))
        .build();
RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.of(config);
RateLimiter rateLimiterWithDefaultConfig = rateLimiterRegistry.rateLimiter("backend");
RateLimiter rateLimiterWithCustomConfig = rateLimiterRegistry.rateLimiter("backend#2", config);
RateLimiter rateLimiter = RateLimiter.of("NASDAQ :-)", config);
```

和前面的一样，我们也可以使用 RateLimiterRegistry 来统一管理 RateLimiter ，也可以通过 RateLimiter.of 方法来直接创建一个 RateLimiter。创建好了，就可以直接使用了，代码如下：

```java
CheckedRunnable restrictedCall = RateLimiter
        .decorateCheckedRunnable(rateLimiter,()->{
            System.out.println(new Date());
        });
Try.run(restrictedCall)
        .andThenTry(restrictedCall)
        .andThenTry(restrictedCall)
        .andThenTry(restrictedCall)
        .onFailure(throwable -> System.out.println(throwable.getMessage()));
```

执行结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d00de2400011cad10820214.png)

可以看到，因为限流，一次只执行了两个方法，另外两个方法是 1s 后执行的。限流参数也可以随时修改，修改之后，本次限流周期内不起作用，下次限流时会生效，修改方式如下：

```java
rateLimiter.changeLimitForPeriod(100);
rateLimiter.changeTimeoutDuration(Duration.ofMillis(100));
```

**事件监听**

限流中，我们也可以获取所有允许和拒绝执行的事件信息，获取方式如下：

```java
rateLimiter.getEventPublisher()
        .onSuccess(event -> {
            System.out.println(new Date()+">>>"+event.getEventType()+">>>"+event.getCreationTime());
        })
        .onFailure(event -> {
            System.out.println(new Date()+">>>"+event.getEventType()+">>>"+event.getCreationTime());
        });
```

**请求隔离**

不同于 Hystrix、Resilience4j 中提供的请求隔离，主要是基于信号量的请求隔离，不包含基于线程的请求隔离，具体用法和前面两个类似，不过在使用之前，需要先添加请求隔离相关的依赖，如下：

```xml
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-bulkhead</artifactId>
    <version>0.13.2</version>
</dependency>
```

可以基于默认配置创建一个 BulkheadRegistry：

```java
BulkheadRegistry bulkheadRegistry = BulkheadRegistry.ofDefaults();
```

也可以自定义最大并行数和进入饱和态 Bulkhead 时线程的最大阻塞时间，如下：

```java
BulkheadConfig config = BulkheadConfig.custom()
        .maxConcurrentCalls(150)
        .maxWaitTime(100)
        .build();
BulkheadRegistry registry = BulkheadRegistry.of(config);
Bulkhead bulkhead1 = registry.bulkhead("foo");
BulkheadConfig custom = BulkheadConfig.custom()
        .maxWaitTime(0)
        .build();
Bulkhead bulkhead2 = registry.bulkhead("bar", custom);
```

这里实例的创建方式和前面两个类似，我就不一一解释了。另外，开发者如果不想通过 BulkheadRegistry 来管理 Bulkhead ，也可以直接创建 Bulkhead 的实例，如下：

```java
Bulkhead bulkhead1 = Bulkhead.ofDefaults("foo");
Bulkhead bulkhead2 = Bulkhead.of(
        "bar",
        BulkheadConfig.custom()
                .maxConcurrentCalls(50)
                .build()
);
```

创建好了之后，使用步骤也基本上和断路器一致，举例如下：

```java
BulkheadConfig config = BulkheadConfig.custom()
        .maxConcurrentCalls(1)
        .maxWaitTime(100)
        .build();
Bulkhead bulkhead = Bulkhead.of("testName", config);
CheckedFunction0<String> decoratedSupplier = Bulkhead.decorateCheckedSupplier(bulkhead, () -> "This can be any method which returns: 'Hello");
Try<String> result = Try.of(decoratedSupplier)
        .map(value -> value + " world'");
System.out.println(result.isSuccess());
System.out.println(result.get());
```

**请求重试**

请求失败重试也是一个常见功能，Resilience4j 中对此也提供了支持，首先引入重试相关依赖：

```xml
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-retry</artifactId>
    <version>0.13.2</version>
</dependency>
```

然后通过如下代码我们创建一个重试的实例：

```java
RetryConfig config = RetryConfig.custom()
    .maxAttempts(3)
    .waitDuration(Duration.ofMillis(500))
    .build();
Retry retry = Retry.of("id", config);
```

在上面的配置中，我们配置了重试次数为3，重试间隔 500ms，有了 Retry 实例之后，就可以直接使用了：

```
CheckedFunction0<String> retryableSupplier = Retry.decorateCheckedSupplier(retry, ()->{
    System.out.println(new Date());
    return "hello retry";
});
Try<String> result = Try.of(retryableSupplier).recover((throwable) -> "Hello world from recovery function");
System.out.println(result.isSuccess());
System.out.println(result.get());
```

执行过程和前面的也基本类似，如果执行过程中抛出异常了，那么就会触发重试机制。

**缓存**

Resilience4j 中也提供了基于 JCache 的方法缓存，考虑到实际开发中以 Redis 缓存为主，这里我就不去介绍这里自带的缓存了，有兴趣的读者可以参考[这里](http://resilience4j.github.io/resilience4j/#_cache)。

**限时**

Resilience4j 中的限时器是要结合 Future 一起来使用，开发者需要提前配置过期时间，在过期时间内要是没有获取到value，那么 Future 将会被取消，使用步骤如下：
限时首先也要加入依赖，如下：

```xml
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-timelimiter</artifactId>
    <version>0.13.2</version>
</dependency>
```

示例代码如下：

```java
TimeLimiterConfig config = TimeLimiterConfig.custom()
        .timeoutDuration(Duration.ofSeconds(60))
        .cancelRunningFuture(true)
        .build();
TimeLimiter timeLimiter = TimeLimiter.of(config);
ExecutorService executorService = Executors.newSingleThreadExecutor();
Supplier<Future<Integer>> futureSupplier = () -> executorService.submit(backendService::doSomething);
Callable restrictedCall = TimeLimiter
        .decorateFutureSupplier(timeLimiter, futureSupplier);
Try.of(restrictedCall.call)
        .onFailure(throwable -> System.out.println(throwable.getMessage()));
```

这里首先创建了一个 TimeLimiter，然后将任务放到线程池中，获取到一个 Supplier<Future> 对象，然后使用限时器包装该对象，当调用超时， onFailure 方法就会被触发。

也可以将限时器和断路器结合使用，当调用超时次数过多，直接熔断，如下：

```java
Callable restrictedCall = TimeLimiter
    .decorateFutureSupplier(timeLimiter, futureSupplier);
Callable chainedCallable = CircuitBreaker.decorateCallable(circuitBreaker, restrictedCall);
Try.of(chainedCallable::call)
    .onFailure(throwable -> LOG.info("We might have timed out or the circuit breaker has opened."));
```

**小结**

本文首先向大家介绍了传统的容错方案 Hystrix 的一些大致功能，这个读者作为了解即可；然后向读者介绍了 Resilience4j 的一些基本功能，这些基本功能涵盖了请求熔断、限流、限时、缓存、隔离以及重试，这里我们只是介绍了 Resilience4j 的一些基本用法。上文中所有的案例都是在一个普通的 JavaSE 项目中写的，这里并未涉及到微服务，下篇文章我将和大家分享，这六个功能如何在微服务中使用，进而实现微服务系统的高可用。

#### 2）Resilience4j 在微服务中的应用

篇文章首先和大家大致说了下断路器 Hystrix ，然后详细说了下 Resilience4j 的用法，但是都是 JavaSE 环境下的用法，并没有涉及到在微服务中的使用。Resilience4j 最终我们还是要在微服务中体现它的价值，我们学习它使用它是为了解决微服务中的一些痛点，因此，本文我就来和大家分享下 Resilience4j 在微服务中的具体用法。



**准备工作**

首先我们需要先搭建一个测试环境，我这里创建一个名为 `Resilience4j-SpringBoot` 的父工程，然后在父工程中创建一个名为 eureka 的子项目来搭建服务注册中心，然后再创建一个名为 provider 的服务提供者，将服务提供者注册到 eureka 上，然后再在 provider 中提供一个 `/hello` 接口，内容如下：

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        String s = "hello " + name + " !";
        System.out.println(s+">>>>>"+new Date());
        int i = 1 / 0;
        return s;
    }
}
```

这里接口中，我特意设置了一个异常， consumer 在调用这个接口的时候会调用失败，方便我们去测试请求重试等功能。

接下来再来创建一个 consumer。consumer 在创建的过程中只需要加入两个基本的依赖即可，即 `spring-boot-starter-web` 和 `spring-cloud-starter-netflix-eureka-client` ，其它的依赖我们在下面具体的使用过程中来说，创建完成后，也将 consumer 注册到服务注册中心上。

这就是我们的准备工作，由于准备工作比较简单，大家不清楚的可以参考[服务注册与消费](https://www.imooc.com/read/37/article/447)一文，我这里就不再详细介绍。



**Retry**

首先要和大家介绍的功能就是重试功能，开发环境一般比较稳定。微服务之间的调用，除非是逻辑错误导致调用失败，一般来说可能很少会遇到网络原因导致的调用失败，但是在生产环境中，网络原因导致的调用失败却是一个不能够忽略的问题，由于网络抖动造成的调用失败，我们一定要进行请求重试。

上文介绍的 Resilience4j 中的功能，在微服务中的使用都有两种不同的用法，一种就是借助 Spring AOP ，直接通过一个注解来实现相关的功能；还有一种就是和上文一样，通过编程的方式来实现，这里分别来和大家介绍。

不过无论哪一种，我们都是需要首先添加依赖，不同于上篇文章我们根据 Resilience4j 提供的功能挨个加依赖，在微服务中，我们可以直接引用 `resilience4j-spring-boot2` 依赖，这个依赖中包含了 Resilience4j 中提供的所有功能，也包含了所需要的 Spring AOP 的依赖，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00de54000178af05170254.png)

依赖代码如下：

```xml
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-spring-boot2</artifactId>
    <version>0.14.1</version>
</dependency>
```



**AOP 式**

依赖添加成功后，接下来在 application.yml 文件中配置 Retry 参数，如下：

```yaml
resilience4j.retry:
  retryAspectOrder: 399
  backends:
    retryBackendA:
      maxRetryAttempts: 3
      waitDuration: 600
      eventConsumerBufferSize: 1
      enableExponentialBackoff: true
      exponentialBackoffMultiplier: 2
      enableRandomizedWait: false
      randomizedWaitFactor: 2
      retryExceptionPredicate: com.justdojava.consumer.RecordFailurePredicate
      retryExceptions:
        - java.io.IOException
      ignoreExceptions:
        - com.justdojava.consumer.IgnoredException
```

关于这一段的配置，解释如下：

1. retryAspectOrder 表示 Retry 的一个优先级。默认情况下， Retry 的优先级高于 bulkhead 、 Circuit breaker 以及 rateLimiter ，即 Retry 会先于另外三个执行。 Retry、 bulkhead 、 Circuit breaker 以及 rateLimiter 的优先级数值默认分别是 Integer.MAX_VALUE-3、Integer.MAX_VALUE-2、Integer.MAX_VALUE-1 以及 Integer.MAX_VALUE ，即数值越小，优先级越高；
2. backends 属性中我们可以配置不同的 Retry 策略，给不同的策略分别取一个名字， retryBackendA 就是一个 Retry 策略的名字。在 Java 代码中，我们将直接通过指定 Retry 策略的名字来使用某一种 Retry 方案；
3. maxRetryAttempts 表示最大重试次数；
4. waitDuration 表示下一次重试等待时间，最小为100 ms ；
5. eventConsumerBufferSize 表示重试事件缓冲区大小；
6. enableExponentialBackoff 表示是否开启指数退避抖动算法，当一次调用失败后，如果在相同的时间间隔内发起重试，有可能发生连续的调用失败，因此可以开启指数退避抖动算法；
7. exponentialBackoffMultiplier 表示时间间隔乘数；
8. enableRandomizedWait 表示下次重试的时间间隔是否随机， enableRandomizedWait 和 enableExponentialBackoff 默认为 false ，并且这两个不可以同时开启；
9. retryExceptionPredicate 类似于我们上文所说的什么样的异常会被认定为请求失败，这里的RecordFailurePredicate是一个自定义的类；
10. retryExceptions 表示需要重试的异常；
11. ignoreExceptions 表示忽略的异常。

RecordFailurePredicate 类的定义如下：

```java
public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        return true;
    }
}
```

方便起见，我这里未做判断，直接返回 true 。
还有一个自定义的异常 IgnoredException ，如下：

```java
public class IgnoredException extends Exception {
}
```

配置完成后，接下来再在项目启动类中配置一个 RestTemplate ，如下：

```java
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

然后创建一个 HelloService 来进行远程调用，如下：

```java
@Service
@Retry(name = "retryBackendA")
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hello(String name) {
        return restTemplate.getForObject("http://provider/hello?name={1}", String.class, name);
    }
}
```

HelloService 本身是一个非常常规的类，RestTemplate 相信大家也是再熟悉不过了，唯一和我们前面学过的不同的地方是这里类上多了一个 @Retry(name = “retryBackendA”) 注解，这个注解表示在当前所有类中开启请求失败重试功能，请求失败重试策略就是 retryBackendA ，当然这个注解也可以加在某一个具体的方法上，表示只有该方法开启请求失败重试功能。

做完这些之后，我们就可以分别启动 eureka、provider 以及 consumer 了，然后在浏览器中访问 consumer 接口，观察 provider 的日志输出，就可以看到日志一共打印了三次，这里发生了请求失败重试。



**编程式**

在框架中，通过这种面向切面编程的方式来引用 Resilience4j 中的 Retry 功能固然很方便。不过， Resilience4j 也支持编程式引用，编程式引用的方式就和我们上篇文章介绍的用法差不多了，举例如下：

```java
@RestController
public class UseHelloController {
    @Autowired
    HelloService helloService;
    @GetMapping("/hello2")
    public String hello2(String name) {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(5000))
                .build();
        Retry retry = Retry.of("id", config);
        Try<String> result = Try.ofSupplier(Retry.decorateSupplier(retry, () -> helloService.hello(name)));
        return result.get();
    }
}
```

通过编程式来引用 Resilience4j 中的 Retry 功能，则不再需要 application.properties 中的 Retry 相关配置，也不需要在 HelloService 类上添加 @Retry 注解，所有关于重试的配置都是通过 Java 代码来实现，至于 Java 代码配置中的含义，则和上文介绍的一致，这里不再赘述。



**CircuitBreaker**

Resilience4j 中断路器的用法和上文也是基本一致，分为两种，可以通过 AOP 的方式使用，也可以通过编程式使用，我们分别来看。



**AOP 式**

由于在 Retry 中已经添加了 `resilience4j-spring-boot2` 依赖，这里我就不再重复说添加依赖的事了。在上个案例的基础上，我们继续在 application.yml 文件中添加如下配置：

```yml
resilience4j.circuitbreaker:
    backends:
        backendA:
            ringBufferSizeInClosedState: 5
            ringBufferSizeInHalfOpenState: 3
            waitInterval: 5000
            failureRateThreshold: 50
            eventConsumerBufferSize: 10
            registerHealthIndicator: true
            recordFailurePredicate: com.justdojava.consumer.RecordFailurePredicate
            recordExceptions:
                - org.springframework.web.client.HttpServerErrorException
            ignoreExceptions:
                - org.springframework.web.client.HttpClientErrorException
```

这里配置也很好理解，大部分参数和我们上篇文章介绍的一致：

1. backendA 是断路器策略的命名，和 Retry 类似，一会也是通过注解来引用这个策略；
2. ringBufferSizeInClosedState 表示断路器关闭状态下，环形缓冲区的大小；
3. ringBufferSizeInHalfOpenState 表示断路器处于 HalfOpen 状态下，环形缓冲区的大小；
4. waitInterval 表示断路器从 open 切换到 half closed 状态时，需要保持的时间；
5. failureRateThreshold 表示故障率阈值百分比，超过这个阈值，断路器就会打开；
6. eventConsumerBufferSize 表示事件缓冲区大小；
7. registerHealthIndicator 表示开启健康检测。

和 Retry 类似，在 Circuit Breaker 中，我们也可以通过 circuitBreakerAspectOrder 属性来修改 Circuit Breaker 的执行优先级。

配置完成后，接下来我们来定义一个名为 HelloServiceCircuitBreaker 的类，在这个类中，来定义服务请求方法：

```java
@Service
@CircuitBreaker(name = "backendA")
public class HelloServiceCircuitBreaker {
    @Autowired
    RestTemplate restTemplate;

    public String hello(String name) {
        return restTemplate.getForObject("http://provider/hello?name={1}", String.class, name);
    }
}
```

这里通过 @CircuitBreaker 注解来启用断路器。最后，我们在 UseHelloController 中调用这个方法即可。

但是这种写法有一个问题，就是没法进行服务容错降级，如果希望进行服务容错降级，那么还是需要我们上篇文章提到的通过编程实现断路器功能。



**编程式**

通过编程实现断路器功能，就不再需要 application.yml 中的配置了，也不需要在类上添加 @CircuitBreaker(name = “backendA”) 注解，所有的相关配置都是在 Java 代码中完成，和上篇文章基本一样，如下：

```java
public String hello2(String name) {
    CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(50)
            .waitDurationInOpenState(Duration.ofMillis(1000))
            .ringBufferSizeInHalfOpenState(20)
            .ringBufferSizeInClosedState(20)
            .build();
    io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("backendA", circuitBreakerConfig);
    Try<String> supplier = Try.ofSupplier(io.github.resilience4j.circuitbreaker.CircuitBreaker
            .decorateSupplier(circuitBreaker,
                    () -> restTemplate.getForObject("http://provider/hello?name={1}", String.class, name)))
            .recover(Exception.class, "有异常，访问失败!");
    return supplier.get();
}
```

我来和大家捋一捋上面这段代码的思路：

1. 首先利用 Java 代码创建一个 CircuitBreakerConfig 出来，然后配置一下故障率阈值，等待时间以及环形缓冲区大小等；
2. 根据第一步创建出来的 CircuitBreakerConfig ，再去创建一个 CircuitBreaker 对象；
3. 通过 Try.ofSupplier 方法去发送一个请求，如果请求抛出异常，则在 recover 方法中进行服务降级处理，recover 可以写多个。

最后，在 UseHelloController 中调用这里的 hello2 方法去访问 provider 中的接口。接口调用失败后， consumer 中自动进行服务降级，最终返回字符串为 `有异常，访问失败!` 。



**RateLimiter**

接下来我们再来说一说限流工具 RateLimiter ，限流工具的用法基本上和前两个差不多，可以通过 AOP 的方式使用，也可以通过编程式来使用，下面分别来介绍。



**AOP 式**

通过 AOP 的方式来使用限流工具，首先在 application.yml 配置文件中添加 RateLimiter 相关配置，如下：

```yml
resilience4j.ratelimiter:
    limiters:
        backendA:
            limitForPeriod: 1
            limitRefreshPeriodInMillis: 5000
            timeoutInMillis: 5000
            subscribeForEvents: true
            registerHealthIndicator: true
            eventConsumerBufferSize: 100
```

关于这段配置，我说如下几点：

1. backendA 在这里依然表示配置的名称，在 Java 代码中，我们将通过指定限流工具的名称来使用某一种限流策略；
2. limitForPeriod 表示请求频次的阈值；
3. limitRefreshPeriodInMillis 表示频次刷新的周期；
4. timeoutInMillis 许可期限的等待时间，默认为5秒；
5. subscribeForEvents 表示开启事件订阅；
6. registerHealthIndicator 表示开启健康监控；
7. eventConsumerBufferSize 表示事件缓冲区大小。

配置完成后，创建一个 HelloServiceRateLimiter 类，内容如下：

```java
@Service
@RateLimiter(name = "backendA")
public class HelloServiceRateLimiter {
    @Autowired
    RestTemplate restTemplate;
    public String hello(String name) {
        return restTemplate.getForObject("http://provider/hello?name={1}", String.class, name);
    }
}
```

这里就是一个很常规的服务调用，然后在 UseHelloController 中调用该方法：

```java
@GetMapping("/rl")
public void rateLimiter(String name) {
    for (int i = 0; i < 5; i++) {
        String hello = helloServiceRateLimiter.hello(name);
    }
}
```

为了测试出效果，这里使用了一个 for 循环，循环中连续发送五次请求，我们发现服务端打印日志如下：

![图片描述](https://img1.sycdn.imooc.com/5d00de6c0001add203780109.png)

可以看到，限流已经生效。



**编程式**

当然，这里的效果也可以通过编程来实现。通过编程实现代码和上篇文章介绍的基本一致，同时，这里也不再需要在 application.yml 中添加配置，所有的条件通过 Java 代码来配置即可，如下：

```java
public void hello2(String name) {
    RateLimiterConfig config = RateLimiterConfig.custom()
            .limitRefreshPeriod(Duration.ofMillis(5000))
            .limitForPeriod(1)
            .timeoutDuration(Duration.ofMillis(6000))
            .build();
    RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.of(config);
    RateLimiter rateLimiter = RateLimiter.of("backendB", config);
    Supplier<String> supplier = RateLimiter.decorateSupplier(rateLimiter, () ->
            restTemplate.getForObject("http://provider/hello?name={1}", String.class, name)
    );
    for (int i = 0; i < 5; i++) {
        Try<String> aTry = Try.ofSupplier(supplier);
        System.out.println(aTry.get());
    }
}
```

这里的代码和我们前文所讲的基本一致，创建一个 Supplier 对象，然后使用 Try.of 方法执行调用，且调用多次。然后在 UseHelloController 中调用这个方法：

```java
@GetMapping("/r2")
public void rateLimiter2(String name) {
    helloServiceRateLimiter.hello2(name);
}
```

观察 provider 中的日志输出，我们可以看到，限流已经生效了。

**小结**

本文主要向大家介绍了 Resilience4j 在微服务中的应用。相对于 Hystrix ，Resilience4j 更加轻便简洁，而且到处充满了 JDK8 的元素，确实非常好用，也是未来处理微服务系统稳定性的一个方向。

#### 3）Micrometer实现微服务监控

不同于单体架构的应用，微服务架构由于服务数量众多，出故障的概率更大，这个在前两篇文章中已经和读者分享过了。这种时候不能单纯依靠“人肉”运维，否则当服务数量越来越多时成本将变得不可控。一个好的解决方案是我们需要对服务进行监控，监控服务运行的数据。当有异常情况出现时，服务能够自动报警，方便运维工程师去处理。

Spring Cloud 中对于服务监控这一个话题也是在不断地变化中。早期的版本（ Greenwich 版之前）服务监控主要使用 Hystrix Dashboard 仪表盘，集群数据监控使用 Turbine，这一技术组合在最新的 Greenwich 版中被建议使用 Micrometer 来替换掉。相对于前者， Micrometer 的使用确实要方便很多，而且容易结合配套工具 Prometheus 以及 Grafana 一起使用，具备自动报警功能，数据展示也更加多样化，方便运维工程师去查看，因此本专栏将不再向读者介绍古老的服务监控的用法，主要向读者介绍 Micrometer 的用法。考虑到很多读者也是第一次使用 Micrometer ，因此本文将分为两部分，首先向读者介绍在 Spring Boot 中 Micrometer 要如何使用，然后再向读者介绍微服务中 Micrometer 的用法。



**Micrometer 简介**

Micrometer 为数据测量仪表提供了一个简单的外观，它几乎适用于大部分目前最流行的监控系统，允许开发者检测基于 JVM 的应用程序代码， Micrometer 有点类似于 SLF4J ，只不过是针对测量数据的。Micrometer 主要有如下三方面的功能：

1. Micrometer 提供了度量指标类，例如 timers、gauges 以及 counters等；
2. 一揽子开箱即用的解决方案，例如缓存、类加载器、垃圾收集、处理器利用率以及线程池等；
3. 从 Spring Boot 2.0 开始， 在 Spring Boot Actuator 中使用了 Micrometer 。在早期的 Spring Boot 版本中，也支持通过附加依赖的方式来使用 Micrometer。

Micrometer 支持流行的监控系统，作为一个门面，Micrometer 允许开发者检测代码，并决定是否监控系统。Micrometer 支持 AppOptics、Azure Monitor、Netflix Atlas、CloudWatch、 Datadog、Dynatrace、Elastic、Ganglia、 Graphite、Humio、Influx/Telegraf、 JMX、KairosDB、New Relic、Prometheus、SignalFx、Google Stackdriver、StatsD 以及 Wavefront。



**Micrometer 基本用法**

首先来看看 Micrometer 在 Spring Boot 项目中的用法：

创建一个 Spring Boot 项目，加入 Web 和 Actuator 依赖，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dea000016dea08070570.png)

项目创建成功后，从依赖关系中我们可以看到，新版的 Actuator 中就是使用了 Micrometer 来实现数据监控，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00dead0001eac705810208.png)

默认情况下，出于安全层面的考虑，只有 health 和 info 端点暴露了。其他端点虽然开启了但是未暴露，通过在 application.yaml 中添加如下配置，我们可以暴露所有的端点：

```yml
management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    metrics:
      enabled: true
```

这里的 `*` 表示启用所有端点，由于 `*` 在 yaml 中有特殊含义，因此大家一定要注意给 `*` 加上双引号。

配置完成后，启动 Spring Boot 项目，即可看到各个数据端口均已打开，例如访问 `health` 端点（默认前缀为 `/actuator`），效果如下：

![图片描述](https://img1.sycdn.imooc.com/5d00deb40001523104130076.png)

各数据端口及含义如下表：

| 端点           | 端点描述                                                     | 是否开启 |
| :------------- | :----------------------------------------------------------- | :------- |
| auditevents    | 展示当前应用程序的审计事件信息                               | Yes      |
| beans          | 展示所有SpringBeans信息                                      | Yes      |
| conditions     | 展示一个自动配置类的使用报告，该报告展示所有自动配置类及它们被使用或未被使用的原因 | Yes      |
| configprops    | 展示所有@ConfigurationProperties的列表                       | Yes      |
| env            | 展示系统运行环境信息                                         | Yes      |
| flyway         | 展示数据库迁移路径                                           | Yes      |
| health         | 展示应用程序的健康信息                                       | Yes      |
| httptrace      | 展示trace信息（默认为最新的100条HTTP请求）                   | Yes      |
| info           | 展示应用的定制信息，这些定制信息以info开头                   | Yes      |
| loggers        | 展示并修改应用的日志配置                                     | Yes      |
| liquibase      | 展示任何Liquibase数据库迁移路径                              | Yes      |
| metrics        | 展示应用程序度量信息                                         | Yes      |
| mappings       | 展示所有@RequestMapping路径的集合列表                        | Yes      |
| scheduledtasks | 展示应用的所有定时任务                                       | Yes      |
| shutdown       | 远程关闭应用接口                                             | No       |
| sessions       | 展示并操作SpringSession会话                                  | Yes      |
| threaddump     | 展示线程活动的快照                                           | Yes      |
| heapdump       | 返回一个GZip压缩的hprof堆转储文件                            | Yes      |
| jolokia        | 展示通过HTTP暴露的JMXbeans                                   | Yes      |
| logfile        | 返回日志文件内容                                             | Yes      |
| prometheus     | 展示一个可以被Prometheus服务器抓取的metrics数据              | Yes      |

但是这样的数据查看不够直观，不易分析出问题，结合 Prometheus 可以更好的将数据展示出来，那么什么是 Prometheus 呢？



**Prometheus**

Prometheus 是一个最初在 SoundCloud 上构建的开源系统监视和警报工具包 。自2012年成立以来，许多公司和组织都采用了 Prometheus ，该项目拥有一个非常活跃的开发人员和用户社区。它现在是一个独立的开源项目，可以独立于任何公司进行维护。

**特征**

Prometheus 主要有如下特点：

- 具有由度量名称和 key/value 标识的时间序列数据的多维数据模型
- PromQL，一种灵活的查询语言
- 不依赖分布式存储，单个服务器节点是自治的
- 使用 HTTP 协议，自动拉取数据
- 通过服务发现或静态配置发现目标
- 多种图形和仪表盘支持，数据展示友好
- 可以非常方便地实现扩展

**架构**

通过下面一张图大家可以看到 Prometheus 的一个大致工作原理：
![图片描述](https://img1.sycdn.imooc.com/5d00dec600012ada13510811.png)

由这张图中，我们可以大致分析出 Prometheus 的工作过程：

1. 首先 Prometheus Server 定期从 targets 或者服务注册中心拉取数据；
2. exporters 负责向 Prometheus Server 做数据汇总。不同的数据汇总由不同的 exporters 实现，例如监控主机有 node-exporters，MySQL 有 MySQL Server exporter；
3. 由于 Prometheus 采用数据拉取的模式，实际生产环境可能由于各个服务不在一个子网或者防火墙的原因，导致 Prometheus 无法直接拉取各个 target 数据，此时可以通过 Pushgateway 来推送 metrics 到 Prometheus Server；
4. Alertmanager 则可以通过提前配置好的邮件地址，对收到的警告信息发出报警；
5. Grafana 则可以通过 PromQL 查询监控数据，进行更丰富的展示。

**具体使用**

说了这么多，那么在我们的 Spring Boot 项目中，到底要如何使用 Prometheus 呢？很简单，整体上来说，可以分为两个步骤：

1. 在Spring Boot 项目中引入相关依赖；
2. 安装 Prometheus 软件并配置。

下面分别来看，首先在 Spring Boot 项目中添加如下依赖：

```xml
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

添加成功后，修改配置，开启 Prometheus ，如下:

```yaml
management:
  metrics:
    export:
      prometheus:
        enabled: true
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    prometheus:
      enabled: true
    metrics:
      enabled: true
```

配置完成后，重启 Spring Boot 项目，此时就可以访问 prometheus 端点了，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00ded200013e2e08760695.png)

从这里可以看到系统的各项运行数据，数据已经汇总了，但是还没有可视化，因此，接下来我们需要下载 Prometheus 并安装。

[Prometheus 下载地址](https://github.com/prometheus/prometheus/releases/download/v2.9.1/prometheus-2.9.1.windows-amd64.tar.gz)

下载完成后，将下载文件解压，在解压目录中可以看到 prometheus.yml 配置文件，在 prometheus.yml 文件中配置要查看的数据接口，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00deda0001a52205210206.png)

要配置的地方就三处：

1. scrape_interval 表示每隔 5 秒抓取一次数据；
2. metrics_path 表示数据路径；
3. targets 中配置的则是服务地址。

配置完成后，Windows 环境下，直接双击 prometheus.exe 启动 Prometheus ，如果是 Linux 环境，则执行 `./prometheus --config.file=prometheus.yml` 命令启动 Prometheus 。

启动成功后，在浏览器中输入 `http://localhost:9090` ，看到如下界面，说明服务已经搭建成功了:

![图片描述](https://img1.sycdn.imooc.com/5d00dee00001ad5d09170511.png)

上面的选项卡分别是警告、图表展示、状态以及帮助，默认看到的就是图表，在下拉框中选择要查看的参数，点击 Execute 按钮，即可看到相关数据：

![图片描述](https://img1.sycdn.imooc.com/5d00dee60001f91d13490903.png)



**Grafana**

仅仅做到上面这一步还不够，前面和大家说过 Prometheus 的工作原理，在 Prometheus 工作流程的最后一步我们提到， Prometheus 中的数据可以通过 Grafana 图表更好地展现出来，这里我们就再结合 Grafana 来看下使用。

Grafana 是一个开源的指标量监测和数据可视化工具，常见的使用场景是展示基础设施的时序数据并且对应用程序运行进行分析。 Grafana 的 Dashboard 可以用一个非常炫酷的方式将监控数据展示出来，Grafana 可以展示多种不同的数据源， Prometheus 只是其中一种。

[Grafana下载地址](https://dl.grafana.com/oss/release/grafana-6.1.4.windows-amd64.zip)

下载成功之后，对下载文件进行解压。解压后，双击 bin 目录下的 grafana-server.exe 文件启动 Grafana ，启动之后，在浏览器中输入 `http://localhost:3000` 即可看到非常炫酷的登录界面，默认的用户名密码都是 `admin` ，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00def50001f67f10880624.png)

使用默认，密码进行登录，首次登录需要修改密码，修改之后就算登录成功了，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00deff00016ffb13660628.png)

接下来点击左边的设置配置数据源：

![图片描述](https://img1.sycdn.imooc.com/5d00df0e00010a5212240601.png)

在配置数据源时，选择 Prometheus ，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00df2400018d4310540653.png)

然后对 Prometheus 进行配置：

![图片描述](https://img1.sycdn.imooc.com/5d00df2c0001cd8805430825.png)

可以看到，这里只需要配置一下基本信息即可：

1. name 表示数据源名字，这个自己随意取一个；
2. HTTP 中的 URL 表示数据的地址，配置 Prometheus 的数据地址即可；
3. 配置完成后，点击最下面的 `Save & Test` 按钮。

接下来我们就可以通过 Dashboard 来查看监控数据了，如下:

首先点击左边栏添加 Dashboard ，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00df3300013d4204300406.png)

在新的页面中点击 Add Query 按钮，如下：

![图片描述](https://img1.sycdn.imooc.com/5d03723e00010ba507320457.png)

在新打开的页面中，主要做如下配置：

![图片描述](https://img1.sycdn.imooc.com/5d00df480001131913560663.png)

刚进来，只需要添加两个配置，一个是选择 Queries to 为我们一开始配置的数据源，然后输入要查询的数据，这个数据要是不清楚怎么写的话，可以参考一开始 Prometheus 中的写法。这两个配置完成后，光标移动到其它地方，相关数据就在图表中显示出来了，如上图。当然开发者也可以点击左边的 Setting 按钮，进行关于 Panel 的更详细的配置，例如要修改 Panel 的名字，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00df4f0001ca8d13160369.png)

这里可以配置 Panel 的 Title 属性，Panel 的详细描述以及图表背景是否透明等属性。

当然开发者也可以点击当前面板右上角的设置图标，来进行详细配置，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00df550001acd804010293.png)

![图片描述](https://img1.sycdn.imooc.com/5d00df5d00018e4607690667.png)

这里配置的参数含义分别如下：

1. Name 表示面板的名称
2. Description 表示对面板的描述
3. Tags 表示可以给面板设置一个标签
4. Folder 表示这个面板归属的文件夹，开发者可以创建多个文件夹，对面板分类管理
5. Editable 表示面板是否可编辑的
6. Timezone 表示时区
7. Auto-refresh 表示面板数据自动刷新时间间隔
8. Now delay now- 表示延迟时间
9. Hide time picker 表示是否隐藏时间控件

配置完成后，就可以点击左边的 Save 按钮，将面板保存下来。

保存完成后，效果如下：
![图片描述](https://img1.sycdn.imooc.com/5d00df660001496b07730461.png)

点击 Panel 的 title 属性，可以对面板继续进行编辑，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00df700001735407810478.png)

好了，这是单个面板的创建，如果要创建多个面板，重复上面的步骤即可，不再赘述。



**警报**

让运维工程师一直盯着 Panel 查看服务是否出错，显然不太现实，我们可以开启服务出错警报功能来解决这一难题。

我们在 Prometheus 中可以定义 AlertRule ，Prometheus 会定时对 AlertRule 进行计算，看看是否满足，如果满足条件就会向 Alertmanager 发送告警信息，因此这里的流程实际上是分为两个步骤，接下来分别向大家介绍。

**AlertRule**

AlertRule 是我们在 Prometheus 中定义的告警规则，我这里通过一个服务宕机的例子来给大家演示 AlertRule 的配置方式。

首先我们需要额外定义一个 yaml 配置文件，用来描述所有的 AlertRule，我这里定义了名为 `rules.yml` 的文件，内容如下：

```yml
groups:
- name: server-dwon
  rules:
  - alert: InstanceDown
    expr: up==0
    for: 5s
    labels:
      severity: page
    annotations:
      summary: "Instance {{ $labels.instance }} down"
      description: "{{ $labels.instance }} of job {{ $labels.job }} has been down for more than 5 seconds."
```

各项配置的含义分别如下：

1. name: 表示配置的名称
2. alert：告警规则的名称
3. expr：基于 PromQL 表达式告警触发条件，用于计算是否有时间序列满足该条件，关于 PromQL 读者可以参考 [初识PromQL](https://yunlzheng.gitbook.io/prometheus-book/parti-prometheus-ji-chu/promql/prometheus-query-language)
4. for：评估等待时间，可选参数。用于表示只有当触发条件持续一段时间后才发送告警。在等待期间新产生告警的状态为 pending
5. labels：自定义标签，允许用户指定要附加到告警上的一组附加标签
6. annotations：用于指定一组附加信息，比如用于描述告警详细信息的文字等，annotations的内容在告警产生时会一同作为参数发送到Alertmanager

这个 rules.yml 文件可以定义在任意位置，但是建议大家放在 Prometheus 的安装目录中，这样方便查找， rules.yml 配置完成后，接下来我们需要在 Prometheus 的配置文件中加载这个配置，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00df7900010ba210190425.png)

配置完成后，就可以启动 Prometheus 了（如果已经启动了，则需要重启），启动之后，点击 Prometheus 标题栏的 Alerts ，就可以看到我们定义的 AlertRule 了，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00df830001bb0c07230437.png)

能看到这个页面，表示配置成功，0 表示这个告警规则未被触发。

此时，我们尝试关闭 Spring Boot 项目，关闭之后，最多 5 秒，我们刷新 Prometheus 的 Alerts 页面，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00df8900018d5a13580551.png)

表示规则已经被触发，但是 State 的值是 PENDING，再停留一会我们再次刷新该页面，结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d00df90000179d113610542.png)

此时 State 的值变为 FIRING ，前后三个不同的 State 值，说明了 Prometheus 在这里的工作过程，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00df970001224102150300.png)

- inactive：警报未被触发，一切安好。
- Pending：这个警报必须被触发，但是，警报可以被分组、压抑/抑制或者静默/静音。一旦所有的验证都通过了，告警就转到 Firing。
- Firing：警报发送到 Notification Pipeline ，它将联系警报的所有接收者，警报解除后，又回到 inactive 状态。

这是 AlertRule 的配置，配置完成之后，现在还不能实现自动邮件报警，要实现邮件报警，还需要配置 AlertManager，请继续看下文。

**Alertmanager**

**准备工作**

我们得先做一点邮件发送的准备工作，这里我以网易邮箱为例，来给大家演示一下邮件发送的准备工作：

首先我们需要先登录网易邮箱网页版，点击上方的设置按钮：

![图片描述](https://img1.sycdn.imooc.com/5d00df9f0001c75d03960339.png)

然后勾选开启 POP3/SMTP 服务：

![图片描述](https://img1.sycdn.imooc.com/5d00dfa80001e94b06580363.png)

开启过程需要手机号码验证，按照步骤操作即可，不赘述。开启成功之后，需要自己设置一个客户端登录授权码，将该号码保存好，一会使用。

如此之后，准备工作就算完成了。

**Alertmanger**

配置 Alertmanager 需要我们首先去下载 Alertmanager，这是一个 GitHub 上的开源项目，我们直接下载二进制安装包即可。

[Alertmanager下载地址](https://github.com/prometheus/alertmanager/releases/download/v0.16.2/alertmanager-0.16.2.windows-amd64.tar.gz)

下载之后解压即可。

解压之后，找到 alertmanager.yml 配置文件，在这个文件中添加邮件发送相关的配置，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dfb40001919205370511.png)

global 中配置的是发件账户的信息，这里的密码是指准备工作配置的授权码。receivers 配置的收件人的信息，收件人可以配置多个。

配置完成后，双击 alertmanager.exe 启动 Alertmanager ，启动成功之后，浏览器输入 `http://localhost:9093` ，结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dfe6000195c511510408.png)

这就表示 Alertmanager 启动成功了。

接下来，将 Prometheus 和 Alertmanager 关联起来即可，修改 Prometheus 的配置文件，如下：

![图片描述](https://img1.sycdn.imooc.com/5d00dfeb0001548808010341.png)

配置完成后，重启 Prometheus。启动成功后，此时我们再次尝试关闭 Spring Boot 项目，关闭后，稍等一会，就会收到一封服务下线告警邮件，如下：
![图片描述](https://img1.sycdn.imooc.com/5d00e0050001166807501105.jpg)

**注意，这个邮件可能被判定为垃圾邮件，如果没收到可以去垃圾箱看下有没有。**

好了，至此，我们的邮件告警就算全部配置完成了。

关于自定义告警邮件模板等，大家可以参考[告警模板详解](https://yunlzheng.gitbook.io/prometheus-book/parti-prometheus-ji-chu/alert/alert-template)。

**小结**

本文主要和大家分享了 Micrometer 监控微服务，顺便说了 Prometheus、Grafana以及 Alertmanger 的用法，有了这些工具的配合，可以有效地提高运维工程师的工作效率。本章至此，也就先告一个段落。

### 6、服务网关Gateway

#### 1）服务网关 Zuul 和 Spring Cloud Gateway

从这节课开始我们学习服务网关——学习什么是服务网关，在微服务架构中服务网关会起到什么样的作用，以及 Spring Cloud 体系内都有哪些服务网关技术，分别都有哪些特点？



**什么是服务网关**

在微服务架构中，整个系统是由许多微服务组成，每个微服务负责一块独立的业务，当外部系统需要调用微服务架构中的某些功能时，我们如何对外提供接口。

微服务架构中，服务实例地址经常会发生变化，所以我们无法直接将服务地址外放出来。如果每一个微服务都直接外放接口，会导致一系列的其它问题，比如调用链过于复杂、涉及到账户、权限时不能统一处理等。另外基于高内聚低耦合的设计准则来讲，我们也应该将内部系统和外部系统做切割。

于是在这样的场景下，就需要有一个独立的组件来处理外部的请求，这个组件就是服务网关。服务网关是为了简化前端的调用逻辑，通常情况下也会实现相关的认证逻辑，根据外部不同的请求响应不同的数据，从而简化内外部系统之间调用的复杂度。

总结一下服务网关的作用：

- 简化客户端调用复杂度，统一处理外部请求。
- 数据裁剪以及聚合，根据不同的接口需求，对数据加工后对外。
- 多渠道支持，针对不同的客户端提供不同的网关支持。
- 遗留系统的微服务化改造，可以作为新老系统的中转组件。
- 统一处理调用过程中的安全、权限问题。

下图为服务网关调用示意图：

![图片描述](https://img1.sycdn.imooc.com/5d00e0300001ecfb05280359.png)

服务网关负责服务请求路由、组合及协议转换。客户端的所有请求都首先经过服务网关，然后由它将请求路由到合适的微服务。服务网关经常会通过调用多个微服务并合并结果来处理一个请求，它可以在系统外部与内部响应之间友好的转换。



**Spring Cloud 体系内的网关技术**

Spring Cloud 体系内的网关技术主要有 Zuul 和 Spring Cloud Gateway。Zuul 是 Netflix 公司开源的产品，也是 Spring Cloud 前几个版本默认使用的服务网关组件，但是随着 Netflix 公司一系列的停更事件，在最新的 Spring Cloud Greenwich 版本中已经不建议采用 Zuul 技术，官方建议使用 Spring Cloud Gateway 作为默认的网关技术。

接下来详细介绍:



**Zuul**

Zuul 是 Netflix 开发的一款提供动态路由的网关服务。Zuul 接收所有设备或者网站请求，根据需求将请求转发到对应的后端系统。作为一个前置服务，Zuul 旨在实现动态路由，监控，弹性和安全性。

Zuul 提供了不同类型的 filter 用于处理请求，这些 filter 可以让我们实现以下功能：

- 权限控制和安全性：可以识别认证需要的信息和拒绝不满足条件的请求。
- 监控：与边缘位置追踪有意义的数据和统计结果，从而带来精确的生产视图。
- 动态路由：根据需要动态地路由请求到后台的不同集群。
- 压力测试：逐渐增加指向集群的流量，以了解性能。
- 负载均衡：为每一种负载类型分配对应容量，并弃用超出限定值的请求。
- 静态资源处理：直接在 zuul 处理静态资源的响应，从而避免其转发到内部集群。

Filter 是 Zuul 的核心，用来实现对外服务的控制。Filter 的生命周期有4个，分别是“PRE”、“ROUTING”、“POST”、“ERROR”，整个生命周期可以用下图来表示。

![图片描述](https://img1.sycdn.imooc.com/5d00e0370001684e09600720.png)

> 图片来自 Netflix 博客： https://medium.com/netflix-techblog/announcing-zuul-edge-service-in-the-cloud-ab3af5be08ee

Zuul 大部分功能都是通过过滤器来实现的，这些过滤器类型对应于请求的典型生命周期。

- PRE： 这种过滤器在请求被路由之前调用。可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
- ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用 Apache HttpClient 或 Netfilx Ribbon 请求微服务。
- POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
- ERROR：在其他阶段发生错误时执行该过滤器。 除了默认的过滤器类型，Zuul 还允许我们创建自定义的过滤器类型。例如，我们可以定制一种 STATIC 类型的过滤器，直接在 Zuul 中生成响应，而不将请求转发到后端的微服务。

在实际工作中可以根据业务的使用场景，来选择使用哪种类型的过滤器。

由于 Zuul2 不断推迟发布、以及 Netfilx 内部对开源软件支持的不稳定性，Spring Cloud 自行研发了另外一款服务网关产品 Spring Cloud GateWay，并且在最新版本中推荐使用 Spring Cloud GateWay，本系列课程重点介绍 Spring Cloud GateWay 的使用。



**Spring Cloud Gateway**

Spring Cloud Gateway 是 Spring 体系内的一个全新项目，该项目是基于 Spring 5.0，Spring Boot 2.0 和 Project Reactor 等技术开发，它旨在为微服务架构提供一种简单有效的统一的 API 路由管理方式。

Spring Cloud Gateway 作为 Spring Cloud 生态系统中的网关，目标是替代 Netflix Zuul，其不仅提供统一的路由方式，并且基于 Filter 链的方式提供了网关基本的功能，例如：安全、监控/指标和限流。

**特性**

- 基于 Spring Framework 5，Project Reactor 和 Spring Boot 2.0
- 动态路由
- Predicates 和 Filters 作用于特定路由
- 集成 Hystrix 断路器
- 集成 Spring Cloud DiscoveryClient
- 易于编写的 Predicates 和 Filters
- 限流
- 路径重写

Spring Cloud Gateway 中的相关概念：

- Route（路由）：这是网关的基本构建块。它由一个 ID，一个目标 URI，一组断言和一组过滤器定义。如果断言为真，则路由匹配。
- Predicate（断言）：这是一个 Java 8 的 Predicate。输入类型是一个 ServerWebExchange。我们可以使用它来匹配来自 HTTP 请求的任何内容，例如 headers 或参数。
- Filter（过滤器）：这是`org.springframework.cloud.gateway.filter.GatewayFilter`的实例，我们可以使用它修改请求和响应。

**工作原理**

![图片描述](https://img1.sycdn.imooc.com/5d0373200001292b05630715.jpg)
客户端向 Spring Cloud Gateway 发出请求。如果 Gateway Handler Mapping 中找到与请求相匹配的路由，将其发送到 Gateway Web Handler。Handler 再通过指定的过滤器链来将请求发送到我们实际的服务执行业务逻辑，然后返回。 过滤器之间用虚线分开是因为过滤器可能会在发送代理请求之前（“pre”）或之后（“post”）执行业务逻辑。

虚线左边的是 pre 类型过滤器，虚线右边的是 post 类型过滤器，外部请求进来后先经过 pre 类型的过滤器，再发送到代理服务，代理服务响应请求，再次经过 post 过滤器链，最后传递给前端。



**Spring Cloud Gateway 与 Zuul 对比**

了解完两种网关技术之后，做一个简单的对比：

- Zuul 是 Netflix 开源的产品，Spring Cloud Gateway 是 Spring 体系内的产品，和 Spring 体系融合更好。
- Zuul1 不支持长连接，比如 WebSockets；Spring Cloud Gateway 支持 WebSockets 等协议。
- 作为一个服务网关产品，Spring Cloud Gateway 考虑更全面一些，增加了 Predicate、限流等技术。
- Zuul1 是基于 Servlet 框架构建，采用的是阻塞和多线程方式，即一个线程处理一次连接请求，这种方式在内部延迟严重、设备故障较多情况下会引起存活的连接增多和线程增加的情况发生。
- Spring Cloud Gateway 基于 Spring 5.0、Spring Boot 2.0 和 Project Reactor 开发，采用了 Netty 实现了异步非阻塞模型，占用资源更小，在性能方面更有优势。

综合比较，Spring Cloud Gateway 在使用效率和性能方面更好一些，可以预期未来 Spring Cloud GateWay 的使用率会越来越高。

**小结**

本节为大家介绍了什么是服务网关，以及我们为什么要使用服务网关，同时介绍了 Spring Cloud 体系内的两种网关技术，以及对两种技术做了简单的对比。在最新版本中 Spring Cloud 推荐使用 Spring Cloud GateWay 作为默认的网关技术，在后面两节为大家介绍如何在项目中使用 Spring Cloud GateWay 技术。

#### 2）Spring Cloud Gateway 快速实践

本节内给大家介绍如何在项目中使用 Spring Cloud Gateway ，学习如何使用 Spring Cloud Gateway 转发单个项目的请求，实践 Spring Cloud Gateway 和注册中心的配合使用。



**快速入手**

我们先来快速实现一个 Spring Cloud Gateway 的 hello world，让大家了解一下 Gateway 整体工作流程。

Spring Cloud Gateway 支持两种方式配置路由的使用：

- 编码方式，通过 `@Bean` 自定义 RouteLocator，在启动主类 Application 中配置。
- 配置方式，在配置文件 yml 中配置。

两种方式是等价的，我们先来使用第一种方式：



**编码方式**

首先添加 Spring Cloud Gateway 的依赖包 `spring-cloud-starter-gateway`

**添加依赖**

```
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>
</dependencies>
```

**添加启动类**

```java
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/get")
                        .uri("http://httpbin.org"))
                .build();
    }
}
```

上面这段配置的意思是，配置了一个 id 为 path_route 的路由规则，当访问地址 `http://localhost:8080/get` 时会自动转发到地址：`http://httpbin.org/get`。配置完成启动项目即可在浏览器访问进行测试，当我们访问地址`http://localhost:8080/get`时页面展示如下信息：

```
{
  "args": {}, 
  "headers": {
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3", 
    "Accept-Encoding": "gzip, deflate, br", 
    "Accept-Language": "zh-CN,zh;q=0.9", 
    "Cookie": "Hm_lvt_f0cfcccd7b1393990c78efdeebff3968=1555735735; Hm_lpvt_f0cfcccd7b1393990c78efdeebff3968=1555740301", 
    "Forwarded": "proto=http;host=\"localhost:8080\";for=\"0:0:0:0:0:0:0:1:64367\"", 
    "Host": "httpbin.org", 
    "Upgrade-Insecure-Requests": "1", 
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36", 
    "X-Forwarded-Host": "localhost:8080"
  }, 
  "origin": "0:0:0:0:0:0:0:1, 221.178.127.44, ::1", 
  "url": "https://localhost:8080/get"
}
```

这样访问地址`http://localhost:8080/get`就和访问`http://httpbin.org/get`的效果是一致的，从而验证了路由转发的成功。



**配置方式**

上面给大家演示了使用编码方式实现路由转发。下面介绍使用配置方式实现路由转发。配置文件推荐使用 YML 格式来配置，YML 风格更简洁清晰。

application.yml

```
server:
  port: 8080
spring:
  cloud:
    gateway:
      routes:
      - id: path_route
        uri: http://httpbin.org
        predicates:
          - Path=/get
```

配置中的参数：

- id：我们自定义的路由 ID，保持唯一，代码中就是 `route()` 方法的第一个参数。
- uri：需要转发的目标服务地址，`r -> r.path("/get").uri("http://httpbin.org")` 代码使用了函数时编程简化代码。
- predicates：路由条件，Predicate 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）。
- filters：过滤规则，本示例暂时没用。

配置完成之后我们把上启动类中的`customRouteLocator()`注释掉：

```
/*  @Bean
public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
            .route("path_route", r -> r.path("/get")
                    .uri("http://httpbin.org"))
            .build();
}*/
```

再重新启动项目，再次访问地址 `http://localhost:8080/get` ，返回信息和上述返回的结果一致，这说明了通过配置的方式也可以到达路由转发的功能。在实际项目中为了方便维护，推荐使用配置文件的方式来配置。

两个 hello world 版的示例都体验完之后，基本可以了解 Spring Cloud GateWay 的工作机制，在日常项目中我们可根据不同的需求，配置不同的路由转发策略，大部分使用场景只需要调整不同的配置信息即可实现。



**网关和注册中心**

上面两种转发方式只适合在单一的项目中使用，如果在微服务架构中就会存在一个致命的问题，微服务架构中服务提供者是动态变化的，所以不能直接将目标服务器地址写在配置文件中。那么在微服务架构中如何解决这个问题呢，这个时候就需要和注册中心来配置使用，本文以 Eureka 和 Spring Cloud Gateway 为例给大家讲解。

当网关和注册中心结合起来使用时，把网关当作一个客户端注册到注册中心，然后网关从注册中心获取所有服务，并自动为这些服务提供路由转发功能。Spring Cloud Gateway 提供了此功能，在项目中只需要简单配置即可达到这样的效果，接下来进行演示。

我们将 5-1 课程的示例项目拿过来，复制 provider 为两个项目 provider-1 和 provider-2，将 provider-2 的端口修改为 4002 ，依次启动 eureka、consumer、 provider-1 和 provider-2 项目。

全部启动完毕后，多次访问地址：`http://localhost:4003/hello?name=neo`，页面展示结果如下：

```
hello neo ; 4001
hello neo ; 4002
...
```

说明服务启动成功，并且请求时被均衡地分发到后端的两个服务。

接下来将上一节的项目复制一份，修改项目名称为 gateway ，将网关项目也注册到注册中心的，修改配置文件的内容如下：

application.yml

```
server:
  port: 8888
spring:
  application:
    name: gateway
  cloud:
    gateway:
     discovery:
        locator:
         enabled: true
eureka:
  client:
    service-url:
      defaultZone: http://localhost:1111/eureka/
logging:
  level:
    org.springframework.cloud.gateway: debug
```

配置说明：

- `spring.cloud.gateway.discovery.locator.enabled`：是否开启通过注册中心进行路由转发的功能，通过 serviceId 转发到服务，默认为 false。
- `eureka.client.service-url.defaultZone`设置注册中心的地址，使网关项目注册到注册中心。
- `logging.level.org.springframework.cloud.gateway` 调整 gateway 包的 log 级别，以便排查问题。

修改完成后启动 gateway 项目，访问注册中心地址 `http://localhost:1111/`页面效果如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00e0650001f1bf18670514.png)

将 Gateway 注册到服务中心之后，网关会自动代理所有的在注册中心的服务，访问这些服务的语法为：

```
http://网关地址：端口/服务中心注册 serviceId/具体的 url
```

比如我们的 provider 项目有一个 `/hello` 的服务，访问此服务的时候会返回：hello 参数 name；端口。

按照上面的语法我们通过网关来访问，浏览器输入：`http://localhost:8888/CONSUMER/hello?name=neo`。多次访问后页面依次出现如下结果：

```
hello neo ; 4001
hello neo ; 4002
...
```

说明我们通过路由转发功能调用了 CONSUMER 的 hello 服务，并且我们在配置文件中只是配置了注册中心的地址，并没有配置具体的服务提供者信息。

通过上面的实验说明 Spring Cloud Gateway 和 Eureka 已经深度融合，只需要在 Gateway 中配置好注册中心的地址，即可代理注册中心的所有服务提供者，省掉了中间繁琐的配置。

**小结**

本节课为大家演示了如何使用 Spring Cloud Gateway。Spring Cloud Gateway 默认有两种使用方式，一种是通过编码的方式来实现，一种是通过配置文件的方式来实现，推荐使用配置文件的方式来使用，便于后期修改维护。Spring Cloud Gateway 支持和注册中心结合起来使用，只要将 Spring Cloud Gateway 注册到注册中心，即可自动代理注册中心中的所有服务，简化路由配置和使用方式。

#### 3）Gateway 中 Predicate 和 Filter 的用法

经过前、两节的学习，大家对服务网关和 Spring Cloud Gateway 的使用有了一定的了解，这节课我们继续学习 Spring Cloud Gateway，了解其最关键的两个功能点 Predicate 和 Filter。

Predicate 和 Filter 是 Spring Cloud Gateway 的核心，通过这两个功能点的灵活配置使用，Spring Cloud Gateway 的使用变得高效、简单。Predicate 的核心作用是路由选择，通过一些列的规则配置，让我们知道哪些请求可以被某个规则转发；Filter 是过滤器，在 Predicate 删选出某些请求需要转发时，Filter 负责在这些请求的执行前或者执行后做一些处理，比如安全校验、参数处理等。

用一句话来总结就是：**Predicate 帮助选择哪些请求需要处理，Filter 给选择出来的请求做一些改动**。接下来我们学习这两个功能点的使用。



**Predicate**

Spring Cloud Gateway 是通过 Spring WebFlux 的 HandlerMapping 做为底层支持来匹配到转发路由，Spring Cloud Gateway 内置了很多 Predicates 工厂，这些 Predicates 工厂通过不同的 HTTP 请求参数来匹配，多个 Predicates 工厂可以组合使用。



**Predicate 介绍**

Predicate 来源于 Java 8，是 Java 8 中引入的一个函数，Predicate 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）。可以用于接口请求参数校验、判断新老数据是否有变化需要进行更新操作。

在 Spring Cloud Gateway 中 Spring 利用 Predicate 的特性实现了各种路由匹配规则，有通过 Header、请求参数等不同的条件来进行作为条件匹配到对应的路由。Spring Cloud Gateway 中内置了几种 Predicate 的实现，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d00e0890001885707090661.png)

可以看出 Spring Cloud Gateway 内置的 Predicate 已经非常丰富，足够满足我们日常的绝大部分工作，接下来选择几个有代表性的 Predicate 进行演示：



**通过时间匹配**

Predicate 支持设置一个时间，在请求进行转发的时候，可以通过判断在这个时间之前或者之后进行转发。比如我们现在设置只有在2019年1月1日才会转发到我的网站，在这之前不进行转发，我就可以这样配置：

```
spring:
  cloud:
    gateway:
      routes:
      - id: time_route
        uri: http://www.ityouknow.com/
        predicates:
          - After=2018-04-22T06:06:06+08:00[Asia/Shanghai]
```

Spring 是通过 ZonedDateTime 来对时间进行的对比，ZonedDateTime 是 Java 8 中日期时间功能里，用于表示带时区的日期与时间信息的类，ZonedDateTime 支持通过时区来设置时间，中国的时区是：Asia/Shanghai。

After Route Predicate 是指在这个时间之后的请求都转发到目标地址。上面的示例是指，请求时间在 2018年4月22日6点6分6秒之后的所有请求都转发到地址`https://www.ityouknow.com`。+08:00 是指时间和 UTC 时间相差八个小时，时间地区为`Asia/Shanghai`。

添加完路由规则之后，访问地址`http://localhost:8080`会自动转发到`https://www.ityouknow.com`。

其它的两个时间判断和上面类似，只需要替换对应的 predicates 值即可。

```
predicates:
	- After=2018-04-22T06:06:06+08:00[Asia/Shanghai]
	- Before=2018-04-22T06:06:06+08:00[Asia/Shanghai]
	- Between=2018-04-22T06:06:06+08:00[Asia/Shanghai], 2019-04-22T06:06:06+08:00[Asia/Shanghai]
```



**通过请求方式匹配**

请求方式即使页面表单的请求类型，比如：POST、GET、PUT、DELETE ，Spring Cloud Gateway 内置了 Predicate 可根据不同的请求方式来选择路由。

我们来配置一个 Get 请求方式的转发，注释掉上面的配置，在配置文件添加以下内容：

```
spring:
  cloud:
    gateway:
      routes:
      - id: method_route
        uri: http://www.ityouknow.com/
        predicates:
           - Method=GET
```

修改完成之后重新启动项目，我们在 windows 系统下打开 cmd 命令行，使用 curl 命令来测试。

```
# curl 默认是以 GET 的方式去请求
curl http://localhost:8080
```

测试返回页面代码，证明匹配到路由，我们再以 POST 的方式请求测试。

```
curl -X POST http://localhost:8080
```

返回 404 没有找到，证明没有匹配上路由。



**通过请求路径匹配**

Path Route Predicate 接收一个匹配路径的参数来判断是否走路由。

```
spring:
  cloud:
    gateway:
      routes:
      - id: path_route
        uri: http://ityouknow.com
        predicates:
        - Path=/foo/{segment}
```

如果请求路径符合要求，则此路由将匹配，例如：/foo/1 或者 /foo/bar。

使用 curl 测试，命令行输入:

```
curl http://localhost:8080/foo/1
curl http://localhost:8080/foo/xx
curl http://localhost:8080/boo/xx
```

经过测试第一和第二条命令可以正常获取到页面返回值，最后一个命令报404，证明路由是通过指定路由来匹配。



**通过请求参数匹配**

Query Route Predicate 支持传入两个参数，一个是属性名一个为属性值，属性值可以是正则表达式。

```
spring:
  cloud:
    gateway:
      routes:
      - id: query_route
        uri: http://ityouknow.com
        predicates:
        - Query=smile
```

这样配置，只要请求中包含 smile 属性的参数即可匹配路由。

使用 curl 测试，命令行输入:

```
curl localhost:8080?id=1
curl localhost:8080?smile=x&id=2
```

经过测试发现只要请求汇总带有 smile 参数即会匹配路由，不带 smile 参数则不会匹配。

还可以将 Query 的值以键值对的方式进行配置，这样在请求过来时会对属性值和正则进行匹配，匹配上才会走路由。

```
spring:
  cloud:
    gateway:
      routes:
      - id: query_route
        uri: http://ityouknow.com
        predicates:
        - Query=keep, pu.
```

这样只要当请求中包含 keep 属性并且参数值是以 pu 开头的长度为三位的字符串才会进行匹配和路由。

使用 curl 测试，命令行输入:

```
curl localhost:8080?keep=pub
```

测试可以返回页面代码，将 keep 的属性值改为 pubx 再次访问就会报 404，证明路由需要匹配正则表达式才会进行路由。



**组合使用**

在我们日常工作中，往往会使用多个 Predicate 来进行判断，Spring Cloud Gateway 支持同时配置多个 Predicate 条件，各种 Predicates 同时存在于同一个路由时，请求必须同时满足所有的条件才被这个路由匹配。

我们来测试一个组合使用的案例：

```
spring:
  cloud:
    gateway:
      routes:
       - id: method_path_time
        uri: http://ityouknow.com
        predicates:
        - Method=GET
        - Query=foo, ba.
        - After=2018-01-20T06:06:06+08:00[Asia/Shanghai]
```

我们使用以下命令测试：

```
curl localhost:8080?foo=baa
```

使用 Post 方式提交、修改 foo 的时间或者更新 After 的时间为 2020 年均会返回 404，这说明了三个条件都必须同时满足后才可执行。

其它几个 Predicate 的使用方式和上述基本类似，只需要按照其语法修改对于的 Predicate 条件即可。同时需要注意的是：**一个请求满足多个路由条件时，请求只会被首个成功匹配的路由转发**。



**Filter 介绍**

Spring Cloud Gateway 的 Filter 的生命周期不像 Zuul 的那么丰富，它只有两个：“pre” 和 “post”。

- PRE： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现权限管理、安全校验、记录调试信息等。
- POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。

Spring Cloud Gateway 的 Filter 分为两种：GatewayFilter 与 GlobalFilter。GlobalFilter 会应用到所有的路由上，而 GatewayFilter 将应用到单个路由或者一个分组的路由上。

**Gateway Filter**

Spring Cloud Gateway 内置了 25 种 GatewayFilter 和一个 Default Filters。按照不同作用方式我们将它划分为 12 大类。

![图片描述](https://img1.sycdn.imooc.com/5d00e0960001a8e019160857.png)

**Global Filter**

Spring Cloud Gateway 内置了7种 GlobalFilter，比如 Netty Routing Filter、LoadBalancerClient Filter、Websocket Routing Filter 等，根据名字即可看出这些 Filter 的作用。

多个 Global Filter 可以通过 @Order 或者 getOrder() 方法指定每个 Global Filter 的执行顺序，order 值越小，Global Filter 执行的优先级越高。

![图片描述](https://img1.sycdn.imooc.com/5d00e09d000193c911770759.png)

利用 GatewayFilter 可以修改 Http 的请求或者响应，或者根据请求或者响应做一些特殊的限制，更多时候我们会利用 GatewayFilter 做一些具体的路由配置，接下来我们通过示例来学习。

**AddRequestParameter GatewayFilter**

AddRequestParameter GatewayFilter 是匹配的请求中添加相关参数，可以用在需要在特定请求中添加参数的场景中。

复用上节课的示例项目，在 provider-1 项目中添加 foo() 方法，代码如下：

```java
@RequestMapping("/foo")
public String foo(String foo) {
    return "hello "+foo+"!";
}
```

provider-1 项目中添加 foo() 方法，多添加一个感叹号用于区别。

```java
@RequestMapping("/foo")
public String foo(String foo) {
    return "hello "+foo+"!！";
}
```

在 consumer 项目中，添加对 foo 的调用。

HelloService 中添加以下代码：

```java
@FeignClient("provider")
public interface HelloService {
    @GetMapping("/foo")
    String foo(@RequestParam("foo") String foo);
}
```

HelloController 中添加以下代码：

```java
@GetMapping("/foo")
public String foo(String foo) {
    return helloService.foo(foo);
}
```

gateway 项目中配置文件 application.yml 的内容修改如下：

```
server:
  port: 8888
spring:
  application:
    name: gateway
  cloud:
    gateway:
     discovery:
        locator:
         enabled: true
     routes:
     - id: add_request_parameter_route
       uri: lb://provider
       filters:
        - AddRequestParameter=foo, bar
       predicates:
         - Method=GET
eureka:
  client:
    service-url:
      defaultZone: http://localhost:1111/eureka/
logging:
  level:
    org.springframework.cloud.gateway: debug
```

关键配置解释：

- `spring.cloud.gateway.discovery.locator.enabled`，是否与服务发现组件进行结合，通过 serviceId 转发到具体的服务实例。默认为 false，设为 true 便开启通过服务中心的自动根据 serviceId 创建路由的功能。
- `spring.cloud.gateway.routes.uri=lb://provider`，配置路由转发到名为 provider 的服务提供者。
- `spring.cloud.gateway.routes.filters`，配置需要执行 Filter 的具体实现。
- `spring.cloud.gateway.routes.filters.AddRequestParameter`，配置 AddRequestParameter Filter 给匹配请求添加参数。
- `spring.cloud.gateway.routes.predicates`，请求的删选条件， Filter 需要和 Predicate 配合使用。

以上改造配置完成之后，依次启动 eureka、consumer、 provider-1 、 provider-2 和 gateay 项目。

首先我们直接调用 consumer 中的 foo 方法，访问地址：`http://localhost:5002/foo`查看返回结果：

```
hello null!
```

说明 provider 项目端并没有接受到 foo 参数的值，也就是请求中并没有添加 foo 参数值，接下来我们通过网关来调用 foo 方法。浏览器访问地址：`http://localhost:8888/foo`，页面交替返回信息如下：

```
hello bar!
hello bar!！
```

通过上面实验可以得知，通过路由进行转发时，在请求中添加了 foo 参数和值，也就意味着在请求过程中的 Filter 已经添加生效。

这里默认使用了全局过滤器 LoadBalancerClient ，当路由配置中 uri 所用的协议为 lb 时（以 `uri: lb://provider` 为例），gateway 将使用 LoadBalancerClient 把 provider 通过 eureka 解析为实际的主机和端口，并进行负载均衡。

其它的 GatewayFilter 使用方式和上述方式比较类似，这里不再一一列举，使用时按照要求的语法配置即可。

**小结**

Spring Cloud Gateway 有非常强大的 Predicate 选择机制，内置的 Predicates 实现已经满足了我们绝大部分工作场景。同时 Spring Cloud Gateway 也提供了请求过程中的各种 Filters ，其中 Filter 又区分为 GatewayFilter 和 GlobalFilter，GatewayFilter 作用于特定请求，GlobalFilter 作用于全局，实际工作中我们根据需求来选择使用。

### 7、配置中心Config

#### 1）初识Spring Cloud Config

通过前面的学习，相信大家对于 Spring Cloud 已经有了一个大致的认识了，应该感受到微服务和我们传统架构的项目最大区别在于微服务中要部署的项目数量非常多，每个服务的配置也非常繁杂。如果将这些配置文件都放在各个微服务之中，随着项目不断变大，配置文件会越来越多，越来越复杂，每一次项目上线估计运维工程师都要崩溃了，维护也非常不方便，因为要改的数据太多了。那么有没有一种办法可以让我们对这些配置文件进行统一管理呢？有！那就是我们今天要说的 Spring Cloud Config！

可能有人已经听说过 Spring Cloud Config，但分布式配置解决方案却不止 Spring Cloud Config，还有其它一些框架，例如 360 的 QConf 、淘宝的 diamond 、百度的 disconf 等都可以解决分布式配置中心问题。国外也有很多开源的配置中心例如 Apache Commons Configuration 、owner 、cfg4j 等等，但是 Spring Cloud Config 的功能更为强大，而且可以和 Spring 家族无缝结合，非常方便。



**Spring Cloud Config 简介**

Spring Cloud Config 项目是一个解决分布式系统的配置管理方案。它包含了 Client 和 Server 两个部分，Server 提供配置文件的存储，然后以接口的形式将配置文件的内容提供出去，Client 通过接口获取数据，然后依据此数据初始化自己的应用。Spring cloud 支持使用 Git 或者 Svn 存放配置文件，默认情况下使用 Git，考虑到目前企业开发的实际情况，我们这里主要通过 Git 来向大家演示 Spring Cloud Config 的用法。

那么 Spring Cloud Config 都有哪些功能呢？

- 提供服务端和客户端支持
- 集中管理各环境的配置文件
- 配置文件修改之后，可以快速生效
- 因为配置文件通过 Git 或者 Svn 进行管理，所以配置文件天然具备版本回退等功能
- 支持大的并发查询
- 支持多种开发语言

好了，说了这么多，可能有人已经迫不及待想要试一试 Spring Cloud Config 了，那么接下来我们就来看看这个 Spring Cloud Config 到底要怎么使用！



**准备工作**

学习 Spring Cloud Config 需要大家掌握 Git 的基本操作，因为本专栏以 Spring Cloud Config 为主，因此如果大家对 Git 的操作还不太擅长的话，同学们可以看下 wiki 中的 Git 教程。
接下来的操作默认大家已经掌握了 Git 的基本用法了。

首先我们需要创建一个本地 Git 仓库，这个仓库中存放的就是我们的配置文件，具体操作步骤如下：

- 创建文件

首先创建一个名为 configRepo 的文件夹，文件夹中存放一个名为 client1 的文件夹，client1 中存放三个文件，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d1095dd00011e3e12080154.png)

假设这三个文件就是用户微服务在不同环境下（如图分别表示开发环境、生产环境、测试环境以及默认配置）的配置文件，三个文件的内容分别如下：

client1-dev.properties

```
javaboy=dev
```

client1-test.properties

```
javaboy=test
```

client1-prod.properties

```
javaboy=prod
```

- 仓库初始化

初始化本地仓库，然后在 GitHub 上创建一个名为 configRepo 的仓库，将本地仓库中的数据上传到远程仓库，操作命令如下：

```git
git init
git add .
git commit -m "微服务配置"
git remote add origin git@github.com:lenve/configRepo.git
git push -u origin master
```

**注意：这里我们需要将 client1 目录保存到 GitHub 远程仓库（即上面的命令是在 configRepo 目录下执行的），configRepo 目录下的不同文件夹中保存不同微服务的配置文件（这只是我们暂时的配置文件规划，学习完本文读者也可以自己来规划相关配置文件位置）。**

上传到 GitHub 之后，GitHub 上目录结构如下：
![图片描述](https://img1.sycdn.imooc.com/5d1095ea00011a4920180734.png)

将本地仓库中的数据同步到远程仓库之后，接下来我们需要搭建一个 Spring Cloud Config Server ，通过这个微服务提供的接口来访问存储在 Git 仓库中的配置文件。



**Config Server**

首先我们来看下面一张简单的 Spring Cloud Config 工作流程图：
![图片描述](https://img1.sycdn.imooc.com/5d1095f7000128fb05600437.png)

ConfigServer 从 Git 仓库获取到配置文件，然后 ConfigClient（就是我们前文中和大家分享的一个一个的微服务） 再从 ConfigServer 中获取各自的配置文件，大致就是这样一个工作流程。

接下来我们首先创建一个名为 CloudConfig 的 Maven 父工程，这个父工程是空的，然后在父工程中创建一个名为 confin_server 的 Spring Boot 工程，创建时候添加 Web 依赖和 Config Server 依赖，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d1096020001f58516861156.png)

创建完成后的 pom.xml 文件内容如下（注意，这里暂时不需要服务注册中心）：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
    </dependency>
</dependencies>
```

创建完成后，接下来首先在项目启动类上添加 `@EnableConfigServer` 注解表示开启配置中心服务端，如下：

```java
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
```

然后在 application.properties 中添加仓库相关配置，如下：

```properties
spring.application.name=config-server
server.port=8001
spring.cloud.config.server.git.uri=https://github.com/lenve/configRepo.git
spring.cloud.config.server.git.search-paths=client1
spring.cloud.config.server.git.username=wangsong0210@gmail.com
spring.cloud.config.server.git.password=
```

各项配置含义如下：

1. 前两行表示服务的名称和端口号，这个比较容易，不需多说；
2. 接下来 git.uri 表示配置的 GitHub 仓库地址，数据将从这个地方加载；
3. search-paths 表示仓库中配置文件的地址，由于 ConfigServer 是 Git 仓库和微服务之间的一个桥梁，不同微服务的仓库在 Git 仓库中放在不同的目录下，这里是指具体的目录，有人会说这样把地址写死了没有任何意义，这个问题一会和大家详细分析；
4. 接下来两个配置就是自己的 GitHub 的用户名和密码，但是这两个配置并非必须的，如果你的仓库就是公开的，那么可以不必配置，实际生产环境中，仓库往往是私有的，因此这里就需要配置用户密码来获取仓库的访问权限。

配置完成后，启动 config_server 项目，启动成功之后，我们就可以在浏览器中输入 `http://localhost:8001/client1/dev/master` 来访问配置文件了，访问返回结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d10961200013bb819821086.png)

可以看到，这里返回了配置文件的所有信息，同时，我们观察 config_server 的控制台，可以看到输出了如下一行日志：

```
Adding property source: file:/var/folders/wx/8j_v819j5n5cgdj3_ymf7pjh0000gn/T/config-repo-213035913253471301/client1/client1-dev.properties
```

进入这里提到的目录，发现 config_server 已经将远程 git 仓库中的内容 clone 下来了：

![图片描述](https://img1.sycdn.imooc.com/5d10961e0001847914580282.png)

事实上，仓库中的配置文件会被转换成 web 接口，访问可以参照以下的规则：

- /{application}/{profile}[/{label}]
- /{application}-{profile}.yml
- /{application}-{profile}.properties
- /{label}/{application}-{profile}.yml
- /{label}/{application}-{profile}.properties

这里，各个占位符含义分别如下：

- {application} 表示配置文件的文件名
- {profile} 表示配置文件的 profile ，例如我们上文提到的 test、dev 以及 prod
- {label} 表示配置文件的 git 分支

此时我们尝试修改本地仓库的配置文件，例如修改 client1-dev.properties 文件内容如下：

```properties
javaboy=hello dev
```

然后提交到 Git 仓库，再通过 ConfigServer 进行访问，发现访问到的数据已经发生了变化，说明 ConfigServer 中的数据可以实时更新。

好了，通过上面的配置，我们的 ConfigServer 就算是配置成功了，接下来我们就来看看如何在 ConfigClient 中来访问 ConfigServer 中提供的配置数据。



**Config Client**

首先我们在父工程 CloudConfig 中创建一个子工程，叫做 config_client。创建时，添加 Config Client 依赖，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d10962a0001350c16841152.png)

创建成功后，pom.xml 文件中的依赖如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
</dependencies>
```

创建成功后，添加配置文件，注意配置文件添加在 bootstrap.properties 文件中，这时需要大家手动在 classpath 下添加 bootstrap.properties 配置文件，相对于 application.properties 文件，bootstrap.properties 文件加载时机更早，适合于目前的场景，bootstrap.properties 中的配置内容如下：

```properties
spring.application.name=client1
server.port=8002
spring.cloud.config.profile=dev
spring.cloud.config.label=master
spring.cloud.config.uri=http://localhost:8001/
```

配置含义如下：

1. 前面两行是指服务的名字和端口号，这个比较简单，无需多说；
2. 大家还记得 config_server 中的访问地址问题吧。上文我们提到的访问规则是 `/{application}/{profile}[/{label}]` ，当 Config Client 去访问 Config Server 时，`spring.application.name` 、`spring.cloud.config.profile` 以及 `spring.cloud.config.label` 的值分别对应上面三个占位符，所以这三个地方不能乱写，要根据实际情况来，特别是 `spring.application.name` 不能写错，因为之前我们定义名称时都是可以随意取的，这里不可以；
3. spring.cloud.config.uri 则表示 config_server 的地址。

配置完成后，当我们的 config_client 项目启动时，配置文件会被自动加载到项目中，我们就可以像使用普通配置文件一样来使用仓库中的配置文件，我们写一个简单的 HelloController 来测试下，如下：

```java
@RestController
public class HelloController {
    @Value("${javaboy}")
    String hello;
    @GetMapping("/hello")
    public String hello() {
        return hello;
    }
}
```

配置完成后，启动 config_client ，访问 `/hello` 接口，结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d10963a00016a2512520608.png)

成功访问到我们需要的配置文件，如果想访问 app-prod.properties ，只需要修改 bootstrap.properties 中 `spring.cloud.config.profile` 的值为 prod 即可。



**配置细节**

由于配置细节较多，这里主要和大家说一下关于路径的配置细节，其它的细节将在本章后面的小节中和大家介绍。

前面和大家说过，`spring.application.name` 、`spring.cloud.config.profile` 以及 `spring.cloud.config.label` 的值分别对应 `{application}` 、`{profile}` 以及 `{label}` 三个占位符，即在 config_server 中，我们可以通过 `{application}` 、`{profile}` 以及 `{label}` 分别访问到 config_client 中对应的 `spring.application.name` 、`spring.cloud.config.profile` 以及 `spring.cloud.config.label` 的值。利用这种特性我们就可以实现对 `config_server` 中 search-paths 属性的动态配置，例如我们可以将 search-paths 的值和 `config_client` 的 `spring.application.name` 绑定在一起，这样就可以实现动态修改配置文件的文件夹了。例如我们上文提到的配置方案，我们现在可以直接修改 config_server 的配置文件，如下：

```properties
spring.application.name=config-server
server.port=8001
spring.cloud.config.server.git.uri=https://github.com/lenve/configRepo.git
spring.cloud.config.server.git.search-paths={application}
spring.cloud.config.server.git.username=wangsong0210@gmail.com
spring.cloud.config.server.git.password=
```

这里我们主要是修改了 search-paths 的值，将之用一个 `{application}` 占位符代替，然后重启 config_server ，发现运行效果和前面的一样。

如此之后，我们就可以通过灵活使用 `{application}` 、`{profile}` 以及 `{label}` 三个占位符，来动态地从 client 中控制 server 所访问的仓库了。读者可以根据自己的实际情况，把这三个占位符玩的更加精彩。



**本地配置**

上文我们提到的配置是在 Git 仓库中完成的，Spring Cloud Config 也提供本地存储配置的方式，例如我们可以添加如下将配置，表示让 config_server 在 classpath 下查找配置文件：

```
spring.profiles.active=native
```

也可以添加如下配置，通过绝对路径来定位配置文件位置：

```
spring.cloud.config.server.native.searchLocations=file:E:/properties/
```

这些方式，大家作为一个了解即可，不必深究，项目中，我们一般还是以 Git 仓库中的配置为主。

**小结**

本文主要向读者介绍了 Spring Cloud Config 的一个基本使用，涉及到 Spring Cloud Config Server 和 Spring Cloud Config Client 的搭建，其中 Config Client 就是我们一个一个的微服务，整个过程并不复杂，不过还有很多细节没有讲到，例如 config_server 的安全管理、配置文件的加密等，这些我们将在下篇文章和大家介绍。

#### 2）Spring Cloud Config 中配置文件的加密与解密

上篇文章和大家聊了 Spring Cloud Config 分布式配置中心的基本用法，相信大家对 Spring Cloud Config 已经有了一个基本的认识。可能有读者也发现问题了，原本在非分布式环境下，一些由运维工程师掌握的敏感信息现在不得不写在配置文件中了，这样网传的程序员删库跑路的段子可能就成真了！但是在微服务中，我们又不太可能让运维工程师手动去维护这些信息，因为工作量太大了，那么一个好的办法，就是对这些配置信息进行加密，这也是我们本文要说的重点。



**常见加密方案**

说到加密，需要先和大家来捋一捋一些常见的加密策略，首先，从整体上来说，加密分为两大类：

- 不可逆加密
- 可逆加密

不可逆加密就是大家熟知的在 Spring Security 或者 Shiro 这一类安全管理框架中我们对密码加密经常采取的方案。这种加密算法的特点就是不可逆，即理论上无法使用加密后的密文推算出明文，常见的算法如 MD5 消息摘要算法以及 SHA 安全散列算法， SHA 又分为不同版本，这种不可逆加密相信大家在密码加密中经常见到，就不需要松哥多说了。

可逆算法看名字就知道，这种算法是可以根据密文推断出明文的，可逆算法又分为两大类：

- 对称加密
- 非对称加密

对称加密是指加密的密钥和解密的密钥一致，例如 A 和 B 之间要通信，为了防止别人偷听，两个人提前约定好一个密钥。每次发消息时， A 使用这个密钥对要发送的消息进行加密，B 收到消息后则使用相同的密钥对消息进行解密。这是对称加密，常见的算法有 DES、3DES、AES 等。

对称加密在一些场景下并不适用，特别是在一些一对多的通信场景下，于是又有了非对称加密，非对称加密就是加密的密钥和解密的密钥不是同一个，加密的密钥叫做公钥，这个可以公开告诉任何人，解密的密钥叫做私钥，只有自己知道。非对称加密不仅可以用来做加密，也可以用来做签名，使用场景还是非常多的，常见的加密算法是 RSA 。

配置文件加密肯定是可逆加密，不然给我一个加密后的字符串，我拿着也没用，还是没法使用。可逆算法中的对称加密和非对称加密在 Spring Cloud Config 中都得到支持，下面我们就分别来看。



**对称加密**

Java 中提供了一套用于实现加密、密钥生成等功能的包 JCE(Java Cryptography Extension)，这些包提供了对称、非对称、块和流密码的加密支持，但是默认的 JCE 是一个有限长度的 JCE ，我们需要到 Oracle 官网去下载一个不限长度的 JCE ：

[不限长度JCE下载地址](http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip)

下载完成后，将下载文件解压，解压后的文件包含如下三个文件：
![图片描述](https://img1.sycdn.imooc.com/5d1096ab0001c4ae03480126.png)

将 local_policy.jar 和 US_export_policy.jar 两个文件拷贝到 JDK 的安装目录下，具体位置是 `%JAVA_HOME%\jre\lib\security` ，如果该目录下有同名文件，则直接覆盖即可。

这是我们的一点准备工作。

接下来步骤和上文一样，我们创建一个 CloudConfig 的父工程，在这个工程中创建 config_server 和 config_client ，同时继续使用上文创建的仓库 configRepo ，这一系列操作和上文一模一样，读者也可以不用创建新项目，直接在上文的基础上进行修改，这里我就不赘述了。

当 config_server 和 config_client 都准备好之后，在 config_server 的 bootstrap.properties 文件中，添加如下一行配置：

```properties
encrypt.key=123
```

这就是我们配置的加密密钥了，配置完成后启动 config_server 。如果你使用的是 IntelliJ IDEA ，config_server 启动成功之后，从控制台的 Mappings 中就能看到这里帮我们自动加入了好几个接口：

![图片描述](https://img1.sycdn.imooc.com/5d1096b60001602609050474.png)

这些接口中就有加解密的接口，也有查看加解密接口状态的接口，首先我们来查看接口状态，访问路径是： `http://127.0.0.1:8001/encrypt/status` ，查看其加密模块是否正常运行：

![图片描述](https://img1.sycdn.imooc.com/5d1096c0000194c203790156.png)

看到 status 的值为 ok 表示这个模块正常运行，接下来调用 `http://127.0.0.1:8001/encrypt` 接口发送一个 POST 请求，来给一段文本进行加密：

![图片描述](https://img1.sycdn.imooc.com/5d1096c900014da708340418.png)

注意，请求参数就是要加密的字符串，请求的响应结果则是加密之后的文本。这个是加密接口，也有解密接口，解密接口则是 `/decrypt` ，例如对刚刚加密的这个字符串进行解密：

![图片描述](https://img1.sycdn.imooc.com/5d1096d30001897c08350418.png)

同样是 POST 请求，请求参数是加密之后的文本，响应结果则是解密之后的明文文本。

在确保了这两个接口没问题的情况下，接下来修改本地仓库中的 client1-dev.properties 文件，将加密字符串拷贝进来，如下：

![图片描述](https://img1.sycdn.imooc.com/5d1096e400012a4906930090.png)

注意加密字符串需要添加一个前缀 `{cipher}` ，有了这个前缀，当 config_server 加载到该文本时，就会对这个文本进行解密，再返回给 config_client。修改完 client1-dev.properties 文件后，将之提交到 GitHub 上，然后重启 config_server ，也启动 config_client ，访问 config_client 的 `/hello` 接口，如下：

![图片描述](https://img1.sycdn.imooc.com/5d1096f60001350c16841152.png)

如果 config_client 加载的是其它配置文件的话，其它文件因为没有 `{cipher}` 前缀，所以就不会对相应的文本进行解密。

好了，这个是使用对称加密的方式来加密配置文件。



**非对称加密**

当然我们也可以使用非对称加密的方式来对配置文件进行加密，非对称加密要求我们先有一个密钥，密钥的生成我们可以使用 JDK 中自带的 keytool。keytool 是一个 Java 自带的数字证书管理工具 ，keytool 将密钥（key）和证书 （certificates） 存在一个称为 keystore 的文件中。具体操作步骤如下：

首先打开命令行窗口，输入如下命令：

```
keytool -genkeypair -alias config-server -keyalg RSA -keystore D:\config-server.keystore
```

参数解释：

- -genkeypair 表示生成密钥对
- -alias 表示 keystore 关联的别名
- -keyalg 表示指定密钥生成的算法
- -keystore 指定密钥库的位置和名称

以上命令在执行过程中，还有如下一些参数需要大家设置，如图：

![图片描述](https://img1.sycdn.imooc.com/5d1097000001a32a10560333.png)

执行过程中，密钥库口令需要牢记，这个我们在后面还会用到。其它的信息可以输入也可以直接回车表示 Unknown ，自己做练习无所谓，实际开发中还是建议如实填写。好了，这个命令执行完成后，在 D 盘下就会生成一个名为 config-server.keystore 的文件，将这个文件直接拷贝到 config_server 项目的 classpath 下，如下：

![图片描述](https://img1.sycdn.imooc.com/5d10970e00019d6f02960234.png)

然后在 config_server 的 bootstrap.properties 文件中，添加如下配置（注意注释掉对称加密时的那一行配置）：

```properties
encrypt.key-store.location=config-server.keystore
encrypt.key-store.alias=config-server
encrypt.key-store.password=123456
encrypt.key-store.secret=123456
```

这四行配置根据生成过程的参数来配置即可。

配置完成后，重新启动 config_server 。启动成功后，加密解密的链接地址和对称加密都是一样的，因此，我们可以继续使用 `http://127.0.0.1:8001/encrypt` 对文本进行加密，使用 `http://127.0.0.1:8001/decrypt` 对文本进行解密，如下图：

加密请求：
![图片描述](https://img1.sycdn.imooc.com/5d1097180001bff609950429.png)

解密请求：

![图片描述](https://img1.sycdn.imooc.com/5d10972200015ddf09940418.png)

两个请求接口都没问题，接下来，我们依然是修改 client1-dev.properties 文件，将加密字符串放进去，如下：

![图片描述](https://img1.sycdn.imooc.com/5d10972c00013e1006900226.png)

然后将本地仓库中的数据提交到远程仓库中。提交成功后，重启 config_client ，然后访问相关接口，我们发现数据已经发生变化了。

好了，这是和大伙介绍的两种配置加密方式。



**安全管理**

目前的 config_server 存在很大的安全隐患，因为所有的数据都可以不经过 config_client 直接访问。出于数据安全考虑，我们要给 config_server 中的接口加密。在 Spring Boot 项目中，项目加密方案当然首选 Spring Security ，使用 Spring Security 也很简单，只需要在 config_server 项目中添加如下依赖即可：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

添加完成之后，重启 config_server 项目，然后浏览器中输入 `http://localhost:8001/client1/dev/master` ，访问结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d10973500010dd903260238.png)

可以看到，此时接口已经被保护起来了，必须要登录之后才能访问，默认的登录用户名是 user ，登录密码在 config_server 的启动控制台上，如下：

![图片描述](https://img1.sycdn.imooc.com/5d10973f000119b807520095.png)

这是默认的登录密码，这个登录密码是项目启动时随机生成的，每次启动都不一样，如果想要使用固定的用户名密码，则可以直接在 config_server 的 bootstrap.properties 配置文件中添加如下配置：

```properties
spring.security.user.name=javaboy
spring.security.user.password=123
```

配置完成后，再次启动 config_server ，此时，控制台就不会有默认的随机密码输出了，用户需要使用 `javaboy/123` 来登录系统，登录之后，就可以访问 config_server 中的接口了。

当 config_server 中添加了接口之后，此时如果 config_client 不做任何额外的配置，直接启动，就会抛出如下错误：
![图片描述](https://img1.sycdn.imooc.com/5d10974c0001fb5908100077.png)

解决办法也很简单，直接在 config_client 的 bootstrap.properties 文件中添加如下配置：

```properties
spring.cloud.config.username=javaboy
spring.cloud.config.password=123
```

配置完成后， config_client 就可以像之前一样访问 config_server 了。

**小结**

本文主要和读者聊了两个话题，文件加解密和 config_server 的安全管理。虽然是两个话题，其实是为了解决一个问题，就是配置文件的安全问题，这两个技能点在分布式配置中心 Spring Cloud Config 中也算是刚需了，基本上都会用到，大家一定要掌握。

#### 3）Spring Cloud Config 服务化、动态刷新、重试

上篇文章和大家分享了 Spring Cloud Config 中的配置文件安全问题，一方面是配置文件本身要加密，另一方面是 Spring Cloud Config 这个服务要有相应的安全机制，做好这两点，我们就不必担心数据安全问题了。

到目前为止我们的 Spring Cloud Config 中的所有案例都还是单服务的，没有服务化。另外，当配置文件刷新后， Spring Cloud Config 中的 Client 也不能及时感知到（8-1 小节向大家演示的是当配置文件变化之后，Spring Cloud Config Server 能够及时感知到），另外也没有失败重试功能，那么本文我将带领大家，来把这几个问题搞清楚。



**服务化**

我们在前面的配置中，当 Config Client 需要从 Config Server 上获取配置数据时，我们都是直接在 Config Client 的配置文件中写上 Config Server 的地址，类似下面这种架构：

![图片描述](https://img1.sycdn.imooc.com/5d1097cd000160f403820374.png)

这种写法相当于将 Config Client 和 Config Server 绑定死了，以后 Config Server 的地址不能变，Config Server 也不能挂，否则 Config Client 就获取不到信息了，而且这种方式也破坏了我们微服务的整体架构，即服务之间互相调用，获取对方的信息都是去服务注册中心上获取，所以我们要对这种结构进行改造，改造成下面这种结构：

![图片描述](https://img1.sycdn.imooc.com/5d1097d800011e7605330374.png)

即当 Config Server 启动时，将自己注册到服务注册中心 Eureka 上，所有 Config Client 都从 Eureka 上去获取 Config Server 的信息，这样我们就成功将 Config Server 和 Config Client 解耦了，Eureka 在这里依然扮演了数据中心的角色。

好了，那么接下来我们就来看看如何实现服务化。

本文的案例在 8-2 小节的案例上继续完成，大家可以直接在 8-2 小节的案例上继续完善。

首先我们在 CloudConfig 项目中添加一个名为 eureka 的 module ，这便是我们的注册中心了。注册中心的添加与配置，读者可以参考前面的文章，这里我就不再赘述，注册中心创建成功后，启动注册中心 eureka。

eureka 启动之后，我们要对之前的 Config Server 和 Config Client 进行服务化改造，首先给这两个模块分别加上 eureka client 依赖，如下：

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

添加完成后，再修改配置，在 Config Server 和 Config Client 中分别添加如下配置，表示将这两个服务注册到 eureka 上面：

```properties
eureka.client.service-url.defaultZone=http://localhost:1111/eureka
```

好了，上面这两条是 Config Server 和 Config Client 共同的配置。接下来，我们还需要在 Config Client 中再额外修改一些配置，修改后的 Config Client 的 bootstrap.properties 的配置内容如下：

```properties
spring.application.name=client1
server.port=8002
spring.cloud.config.profile=dev
spring.cloud.config.label=master
#spring.cloud.config.uri=http://localhost:8001/
spring.cloud.config.discovery.service-id=config-server
spring.cloud.config.discovery.enabled=true

spring.cloud.config.username=javaboy
spring.cloud.config.password=123

eureka.client.service-url.defaultZone=http://localhost:1111/eureka
```

这里其实就是使用 `spring.cloud.config.discovery.service-id=config-server` 和 `spring.cloud.config.discovery.enabled=true` 两个配置代替了原来的 `spring.cloud.config.uri=http://localhost:8001/` 。其中 `spring.cloud.config.discovery.service-id=config-server` 表示配置 Config Server 的实例 id ，Config Client 将根据这个 id 去 eureka 上面查找 Config Server 的信息， `spring.cloud.config.discovery.enabled=true` 则表示开启通过 eureka 获取 Config Server 的功能。

配置完成后，我们就可以启动 Config Client 了。启动成功后，我们再次访问 Config Client 中的 `/hello` 接口，获取到的数据和前面的一样，说明配置成功。

配置成功之后，以后我们所有的 Config Client 都按照上面的配置信息来配置，即开启通过注册中心来访问 Config Server 的功能，同时指定 Config Server 的实例 id ，而不用在 Config Client 中硬编码 Config Server 的地址。



**动态刷新**

接下来我们再来看一下配置文件动态刷新的问题，在 8-1 小节中，我们向大家演示过，当 GitHub 仓库中配置文件发生改变后，如果我们刷新 Config Server 中的请求地址，会发现数据也跟着变化了，即 Config Server 是能够及时感知到配置文件的变化的，但是这种感知却不能够传递到 Config Client 中去，即 Config Client 是无法及时感知到配置文件的变化的，默认情况下，只有 Config Client 重启，才能够加载到最新的配置文件数据，如何让 Config Client 也能动态刷新配置数据呢？

想要让 Config Client 动态刷新配置数据，其实很容易，首先我们需要在 Config Client 中引入 actuator 依赖，如下：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

如果是 Spring Cloud Finchley 版（不含）之前的版本，那么直接添加依赖就完事了，不需要做额外配置，但是在 Finchley 版之后，因为采用的 Spring Boot 版本是 2.0.x ，Spring Boot 2 之后，考虑到数据安全，actuator 默认只开放了两个接口 health 和 info 。因此，在 Greenwich 版中，除了添加依赖外，我们还需要手动添加如下配置，表示暴露 refresh 接口：

```properties
management.endpoints.web.exposure.include=refresh
```

另外，我们还需要在 Config Client 中的 HelloController 上添加一个 `@RefreshScope` 注解，表示当调用 `/refresh` 接口时，动态更新容器中的数据，如下：

```java
@RestController
@RefreshScope
public class HelloController {
    @Value("${javaboy}")
    String hello;
    @GetMapping("/hello")
    public String hello() {
        return hello;
    }
}
```

配置完成后，我们再重新启动 Config Client ，启动成功后，我们在 IntelliJ IDEA 控制台的 Endpoints 中就可以看到 `/actuator/refresh` 接口已经暴露出来了，如下：

![图片描述](https://img1.sycdn.imooc.com/5d1097e70001e1c712340612.png)

一会儿，我们将通过调用这个接口实现配置文件的动态刷新。

接下来，我们分别启动 Config Server 和 Config Client ，然后修改本地仓库中的配置文件。修改完成后，提交到远程仓库，此时我们直接访问 Config Client 的 `/hello` 接口，发现数据并未发生变化，别急，我们先调用 Config Client 的 `/actuator/refresh` 接口，注意这个接口的调用是一个 POST 请求，如下：

![图片描述](https://img1.sycdn.imooc.com/5d1097f30001082c14060604.png)

调用成功之后，再去调用 Config Client 的 `/hello` 接口，此时发现配置文件已经发生变化了。

这样，我们在不重启 Config Client 的情况下，就能够动态刷新配置了，可能有人还是觉得这样太麻烦了，因为所有的微服务都要挨个去发送 `/actuator/refresh` 请求，这个工作量也不小，那么这个工作有没有可能做进一步的简化呢？当然是可以的，我们在后面的文章会继续为大家介绍。



**请求失败重试**

请求失败重试这也是一个非常常见的需求，在前面的文章中为大家介绍过微服务调用过程中的请求失败重试问题，那么 Config Client 在调用 Config Server 时，一样也会发生请求失败的问题。我们平时做开发，一般来说公司的网络都是杠杠滴，但是在实际生产环境中，网络问题各种各样，我们必须考虑弱网环境下如何保证服务的高可用性，那么请求失败重试就是策略之一。

要在 Config Client 中实现请求失败重试，其实非常容易，添加如下两个依赖即可：

```xml
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

添加完成后，还需要我们在 Config Client 的配置文件中添加如下配置：

```properties
spring.cloud.config.fail-fast=true
```

这行配置表示开启失败快速响应。什么是失败快速响应呢？默认情况下，当 Config Client 访问 Config Server 失败时，并不会立马报错，而是会等到用这个数据时，才会抛出异常，以我们前面的代码为例，如果 Config Client 访问 Config Server 失败，并不会立马抛出异常，而是等到在 Config Client 中使用注入进来的 javaboy 这个变量时，发现没有这个变量，此时才会抛出异常。这个时候项目已经启动失败了，停止运行了，所以也不会有失败重试什么事了，因此我们要开启失败快速响应。什么是失败快速响应呢？就是当 Config Client 访问 Config Server 失败时，就不再执行后面的流程了，立马做出响应，重试 or 抛异常。

添加完这个配置之后，为了演示执行效果，接下来我们再做一点点修改，由于目前我们的 Config Server 是有安全认证的，Config Client 必须要有用户名密码才能访问到 Config Server 中的数据。我们暂时先注释掉 Config Client 中访问 Config Server 的用户名密码，即如下两行：

```properties
#spring.cloud.config.username=javaboy
#spring.cloud.config.password=1234
```

注释掉之后，我们再去启动 Config Client ，此时就会启动失败，我们来观察效果重试效果：

![图片描述](https://img1.sycdn.imooc.com/5d1098030001fac523060486.png)

可以看到，请求一共发送了6次，第一次失败之后，还重试了5次。这是默认的请求重试策略，开发者也可以自定义请求重试的相关参数，如下：

```properties
spring.cloud.config.retry.initial-interval=1000
spring.cloud.config.retry.multiplier=1.1
spring.cloud.config.retry.max-interval=2000
```

这四个配置含义如下：

1. max-attempts 表示最大请求次数，默认值为 6 ，就是大家在上图看到的情况；
2. initial-interval 表示请求重试的初始时间间隔；
3. multiplier 表示时间的间隔乘数，由于网络抖动一般都是有规律的，为了防止请求重试时连续的冲突，我们需要一个时间间隔乘数，这里我设置了间隔乘数为 1.2 ，表示第一次重试间隔时间为 1 s，第二次间隔时间为 1.2 秒，第三次间隔时间为 1.44 秒…；
4. max-interval 表示重试的最大间隔时间。

开启了请求重试机制之后，即使在弱网环境下，我们也能有效保证服务的可用性。

**小结**

本文主要向大家介绍了分布式配置中心 Spring Cloud Config 中三个常见的问题，服务化、配置数据动态刷新以及请求失败重试。服务化降低了 Config Server 和 Config Client 之间的耦合度，使我们的项目架构更加规范；动态刷新则让我们在不重启 Config Client 的情况下，能够刷新配置数据；最后的请求重试则保证了弱网环境下服务的可用性，在实际生产项目中，这三个基本上也都是必配的，大家需要认真掌握

### 8、消息总线Bus

#### 1）Docker简介与消息中间件安装

本章要用两篇文章来和大家聊一个新的话题，那就是消息中间件。在微服务中， Spring Cloud Bus （消息总线）通过轻量级消息代理连接各个微服务，在很多场景下我们对 Spring Cloud Bus 有非常迫切的需求，最简单的需求就是上篇文章我们提到的希望在配置文件更新时能够变得更加容易些，使用 Spring Cloud Bus 就可以实现这一需求。Spring Cloud Bus 的一个核心思想是通过分布式的启动器对 Spring Boot 应用进行扩展，也可以用来建立多个应用之间的通信频道。目前常见的实现方式是通过 AMQP 消息代理作为通道。

要学习 Spring Cloud Bus ，我们得先安装消息中间件，这里我们将引入目前流行的 Docker 容器，在 Docker 容器中来安装消息中间件。



**Docker 简介**

说起 Docker ，我想很多人可能都用过，即使没有用过也应该听说过。Docker 容器如日中天，这不是单纯的炒概念，而是因为 Docker 确确实实解决了开发与运维的痛点，因此 Docker 在企业开发中得到了非常广泛的使用，特别是在微服务中，由于服务数量增多，项目部署难度加大，因此在微服务架构中， Docker 也算是一个基础组件了。考虑到很多人可能对 Docker 的认识还不够全面，因此这里就先来带领大家学习一下 Docker 中一些常见的基本概念，使大家对于 Docker 有一个基本的认识。那么什么是 Docker 呢？

根据 wikipedia 中的介绍：

```
Docker是一个开放源代码软件项目，让应用程序布署在软件容器下的工作可以自动化进行，借此在Linux操作系统上，提供一个额外的软件抽象层，以及操作系统层虚拟化的自动管理机制。  
Docker利用Linux核心中的资源分脱机制，例如cgroups，以及Linux核心名字空间（name space），来创建独立的软件容器（containers）。这可以在单一Linux实体下运作，避免启动一个虚拟机造成的额外负担。Linux核心对名字空间的支持完全隔离了工作环境中应用程序的视野，包括进程树、网络、用户ID与挂载文件系统，而核心的cgroup提供资源隔离，包括CPU、存储器、block I/O与网络。从0.9版本起，Dockers在使用抽象虚拟是经由libvirt的LXC与systemd - nspawn提供界面的基础上，开始包括libcontainer库做为以自己的方式开始直接使用由Linux核心提供的虚拟化的设施。  
依据行业分析公司“451研究”：“Dockers是有能力打包应用程序及其虚拟容器，可以在任何Linux服务器上运行的依赖性工具，这有助于实现灵活性和便携性，应用程序在任何地方都可以运行，无论是公有云、私有云、单机等。” 。
```

这里的介绍有点绕口，让我们来总结一下 Docker 的特点：

1. 简化环境管理

   传统的软件开发与发布环境复杂，配置繁琐。经常有读者在微信上问：我的代码开发环境可以运行，一旦部署到服务器上就运行不了了。这个问题很常见，也确实很烦人，但是问题总要解决，开发环境、测试环境、生产环境，每个环节都有可能出现这样那样的问题，如果能够在各个环境中实现一键部署，就会方便很多，例如一键安装 Linux 、一键安装 MySQL 、一键安装 Nginx 等，Docker 容器彻底解决了这个问题。

2. 虚拟化更加轻量级

   说到容器，说到虚拟化，很多人总会想到虚拟机，想到 VMware、VirtualBox 等工具。不同于这些虚拟技术， Docker 虚拟化更加轻量级，传统的虚拟机都是先虚拟出一个操作系统，然后在操作系统上完成各种各样的配置，这样并不能充分利用物理机的性能。 Docker 则是一种操作系统级别的虚拟技术，它运行在操作系统之上的用户空间，所有的容器都共用一个系统内核甚至公共库，容器引擎提供了进程级别的隔离，让每个容器都像运行在单独的系统之上，但是又能够共享很多底层资源。因此 Docker 更为轻量、快速和易于管理。

3. 程序可移植

   有了前面介绍的两个特点，程序可移植就是顺理成章的事情了。

**Docker 和虚拟机**

前面介绍了 Docker 与传统虚拟机的差异，通过下表再来详细了解下这种差异：

|              | Docker                                                       | 虚拟机                                                       |
| :----------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| 相同点       | 1. 都可在不同的主机之间迁移 2. 都具备 root 权限 3. 都可以远程控制 4. 都有备份、回滚操作 |                                                              |
| 操作系统     | 在性能上有优势，可以轻易运行多个操作系统                     | 可以安装任何系统，但是性能不及容器                           |
| 原理         | 和宿主机共享内核，所有容器运行在容器引擎之上，容器并非一个完整的操作系统，所有容器共享操作系统，在进程级进行隔离 | 每一个虚拟机都建立在虚拟的硬件之上，提供指令级的虚拟，具备一个完整的操作系统 |
| 优点         | 高效、集中。一个硬件节点可以运行数以百计的容器，非常节省资源，QoS 会尽量满足，但不保证一定满足。内核由提供者升级，服务由服务提供者管理 | 对操作系统具有绝对权限，对系统版本和系统升级具有完全的管理权限。具有一整套的的资源：CPU、RAM 和磁盘。QoS 是有保证的，每一个虚拟机就像一个真实的物理机一样，可以实现不同的操作系统运行在同一物理节点上。】 |
| 资源管理     | 弹性资源分配：资源可以在没有关闭容器的情况下添加，数据卷也无需重新分配大小 | 虚拟机需要重启，虚拟机里边的操作系统需要处理新加入的资源，如磁盘等，都需要重新分区 |
| 远程管理     | 根据操作系统的不同，可以通过 shell 或者远程桌面进行          | 远程控制由虚拟化平台提供，可以在虚拟机启动之前连接           |
| 缺点         | 对内核没有控制权限，只有容器的提供者具备升级权限。只有一个内核运行在物理节点上，几乎不能实现不同的操作系统混合。容器提供者一般仅提供少数的几个操作系统 | 每一台虚拟机都具有更大的负载，耗费更多的资源，用户需要全权维护和管理。一台物理机上能够运行的虚拟机非常有限 |
| 配置         | 快速，基本上是一键配置                                       | 配置时间长                                                   |
| 启动时间     | 秒级                                                         | 分钟级                                                       |
| 硬盘使用     | MB                                                           | GB                                                           |
| 性能         | 接近原生态                                                   | 弱于原生态                                                   |
| 系统支持数量 | 单机支持上千个                                               | 一般不多于几十个                                             |

**Docker 核心组件**

Docker 中有三大核心组件：

1. 镜像

   镜像是一个只读的静态模版，它保存了容器需要的环境和应用的执行代码，可以将镜像看成是容器的代码，当代码运行起来之后，就成了容器，镜像和容器的关系也类似于程序和进程的关系。

2. 容器

   容器是一个运行时环境，是镜像的一个运行状态，它是镜像执行的动态表现。

3. 库

   库是一个特定的用户存储镜像的目录，一个用户可以建立多个库来保存自己的镜像。

通过这样一个介绍，相信大家对于 Docker 会有一个更加全面的认识。



**Docker 安装**

Docker 支持主流操作系统，我们可以在 Windows、MacOS 以及 Linux 中安装 Docker。这里分别给大家来介绍下。



**Windows 安装**

Windows10 下 Docker 的安装还是比较容易的，以前老版本的 Windows 安装并不太容易，考虑到现在大家基本上都上 Windows10 了，我就来说说 Windows10 下 Docker 的安装，这个安装步骤很简单，首先下载 Docker ：

[Windows 版 Docker 下载地址](https://download.docker.com/win/stable/Docker for Windows Installer.exe)

下载完成后，就是一普通的 Windows 可执行程序，双击开始安装，一路 Next 就安装好了，这个过程没有什么需要注意的，就按照普通应用程序来对待就行了。



**MacOS 安装**

MacOS 下的安装也比较容易，当然首先第一步还是下载软件：

[Mac 版 Docker 下载地址](https://download.docker.com/mac/stable/Docker.dmg)

下载后是一个 .dmg 文件，双击安装即可，安装完成之后，会有一个 Docker 图标，需要使用时双击启动即可。



**Linux 安装（推荐）**

上面两种安装方式大家作为一个了解即可，大家以后在工作中，大部分还是在 Linux 下安装 Docker 并使用，这里我以 CentOS7 为例来向大家介绍 Docker 的安装。具体步骤如下：

CentOS7 中安装 Docker 其实也是非常容易的，就两个步骤，如下：

```
yum -y install docker
service docker start
```

安装完成之后，启动 Docker ，执行如下命令查看 Docker 版本，如果能看到，说明就已经安装成功了：

![图片描述](https://img1.sycdn.imooc.com/5d1098700001217a06680100.png)



**安装 RabbitMQ**

Docker 安装成功之后，接下来我们来安装 RabbitMQ，RabbitMQ 是一个实现了 AMQP 的开源消息中间件，使用高性能的 Erlang 编写。RabbitMQ 具有可靠性、支持多种协议、高可用、支持消息集群以及多语言客户端等特点，在分布式系统中存储转发消息具有不错的性能表现。

如果读者不知道容器的安装命令是什么，可以直接去 Docker 镜像站搜索查找，Docker 镜像站是 https://hub.docker.com/ ，多内有网易等提供的镜像站，下载速度会快一些，地址是 https://c.163yun.com/hub ，不过网易这个镜像站必须登录之后才能访问。我这里以官方镜像站为例向读者演示 RabbitMQ 的安装，安装方式其实很容易，首先在官方镜像站上搜索 rabbitmq ，然后找到官方镜像，如下：

![图片描述](https://img1.sycdn.imooc.com/5d10987900012cfd19240520.png)

点进去，就能找到 RabbitMQ 的安装命令，如下:

```
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```

命令解释：

1. docker run 表示运行一个容器，如果这个容器本地镜像已经存在，则直接启动，如果这个容器本地景象不存在，则会自动先去 docker 仓库下载这个容器；
2. -d 表示让容器在后台运行；
3. –hostname 表示主机名；
4. –name 表示容器的名字；
5. -p 表示端口映射，因为我们将在宿主机中访问容器，宿主机中访问容器需要端口映射，这里配置了两个端口映射，分别是 15672 和 5672，其中 15672 是管理页面访问的端口，5672 则是消息通信端口；
6. 最后的 rabbitmq:3-management 则表示下载的镜像的名字。

好了，当在命令行执行完如上命令，如果是第一次执行，我们会看到 Docker 会自动去镜像站下载相关镜像，如下：

![图片描述](https://img1.sycdn.imooc.com/5d1098820001f8df19220620.png)

执行完成之后，我们在命令行输入 `docker ps -l` 表示查看最近创建的容器，执行结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d1098880001f25333240166.png)

这就表示 RabbitMQ 已经安装成功了。

接下来，我们在浏览器中访问 RabbitMQ 的管理界面，如下：

![图片描述](https://img1.sycdn.imooc.com/5d10988e000129b013980498.png)

我这里因为是直接在 Mac 安装的，所以访问的 IP 地址就是本机地址。如果是在 Linux 中安装 Docker 的话，那么访问地址就是 Linux 的 IP 地址，访问端口则是我们安装 RabbitMQ 时配置的默认端口。这里的默认用户名 / 密码都是 guest 。

登录成功的页面如下：
![图片描述](https://img1.sycdn.imooc.com/5d109894000170ee33361514.png)

不知道读者中有没有人在 Linux 上直接安装过 RabbitMQ ？ 如果有的话，就能体会出使用 Docker 安装 RabbitMQ 是多么的清爽。

使用如下命令可以关闭 RabbitMQ：

```
docker stop some-rabbit
```

some-rabbit 是指容器的 name 。

执行结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d10989f00011ee006460084.png)

表示容器已经成功关闭。



**安装 Kafka**

那么我们趁热打铁，顺便再来安装一下 Kafka。Kafka 我们一般采用一个第三方的镜像，Kafka 安装命令如下：

```
docker run -d --name zookeeper -p 2181 -t wurstmeister/zookeeper
docker run -d --name kafka --publish 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 --env KAFKA_ADVERTISED_HOST_NAME=127.0.0.1 --env KAFKA_ADVERTISED_PORT=9092 wurstmeister/kafka:latest
```

这里的安装分为两步，首先是安装 zookeeper ，然后才是 Kafka，在 Kafka 启动时，使用容器连接的方式来使用 zookeeper 提供的服务。

执行完之后，我们的 Kafka 就算安装成功了，在命令行执行 `docker ps -l` 来查看刚刚创建的容器：

![图片描述](https://img1.sycdn.imooc.com/5d1098ab000152fc22380112.png)

可以看到 Kafka 容器目前的状态是 Up，即正在运行。

接下来执行如下命令进入 Kafka 容器中：

```
docker exec -it kafka /bin/bash
```

执行结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d1098b20001d82507820080.png)

再执行如下命令，进入 Kafka 的安装目录：

```
cd /opt/kafka_2.12-2.2.0/
```

![图片描述](https://img1.sycdn.imooc.com/5d1098b80001de2d12700140.png)

然后我们来创建一个主题和一个消息生产者：

```
bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic mykafka
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic mykafka 
```

执行结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d1098bd0001ae1e19500144.png)

接下来打开一个新的窗口，并且进入到 Kafka 容器中，再创建一个消息消费者，命令如下：

```
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mykafka --from-beginning
```

此时在消息生产者控制台输入消息，消息消费者就可以收到消息了，如下图：

![图片描述](https://img1.sycdn.imooc.com/5d1098c30001166817400364.png)

**小结**

本文主要带领大家简单领略下 Docker 的魅力，同时安装好我们后文需要的中间件环境，使用 Docker 来搭建环境，确实能让我们省不少事情，使我们专注于业务的开发。

#### 2）Spring Cloud Bus 整合 RabbitMQ 与 Kafka

上篇文章和大家聊了 Docker 以及 RabbitMQ 和 Kafka 在 Docker 中的安装。软件装好之后，接下来我们就来看看 Spring Cloud Bus 给我们的微服务开发带来了哪些便利。



**Spring Cloud Bus 简介**

Spring Cloud Bus （消息总线）通过轻量级消息代理连接各个微服务，可以用来广播配置文件的更改或者服务监控的管理。在实际生产环境中，Spring Cloud Bus 主要是用来做微服务的监控或者微服务应用程序之间的通信，目前常见的实现方式是通过 AMQP 消息代理作为通道。



**简单实践**

首先我们先来启动 Docker 中安装的 RabbitMQ。如果你的 RabbitMQ 在上篇文章学习完之后，已经关闭了，那么本文不需要再运行 docker run 命令去启动 RabbitMQ 了，直接执行如下命令，启动已有的 docker 容器即可：

```
docker start some-rabbit
```

如下：

![图片描述](https://img1.sycdn.imooc.com/5d1099170001adfe06580076.png)

其中，some-rabbit 表示启动的容器名称，这样我们启动的是一个已有的 RabbitMQ 实例，相关参数和我们上文的都是一样的（如果需要再创建一个 RabbitMQ 容器，则可以继续执行上文的 docker run 命令，但是注意宿主机的端口、容器的名字不可以重复）。

容器启动成功之后，先通过一个简单的 Spring Boot 工程来和大家演示一下 RabbitMQ 消息的收发过程。

首先我们来创建一个名为 rabbitmq 的 Spring Boot 项目，创建时勾选两个依赖：Web 和 RabbitMQ ，如下：

![图片描述](https://img1.sycdn.imooc.com/5d1099200001478116861156.png)

工程创建完成后，我们首先在 application.properties 中配置一下 RabbitMQ 的基本信息，如下：

```properties
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

这个是 RabbitMQ 的基本连接信息，大家知道，这些信息将被注入到相应的 Bean 中，这里是注入到 RabbitProperties 对象中去，我们来看一点点这个对象的源码：

```java
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitProperties {

	/**
	 * RabbitMQ host.
	 */
	private String host = "localhost";

	/**
	 * RabbitMQ port.
	 */
	private int port = 5672;

	/**
	 * Login user to authenticate to the broker.
	 */
	private String username = "guest";

	/**
	 * Login to authenticate against the broker.
	 */
	private String password = "guest";

    //other
}
```

大家看到，这里每一项都有一个默认值，而且默认值我们写的也是一致的，所以，如果你的 RabbitMQ 的访问地址是本机地址，并且端口、用户名、密码都是默认的话，那么这里其实也可以不用配置。

在 RabbitMQ 中，所有的消息生产者提交的消息都会交由 Exchange 进行再分配，Exchange 会根据不同的策略将消息分发到不同的 Queue 中。 RabbitMQ 中一共提供了四种不同的 Exchange 策略，分别是 Direct 、 Fanout 、 Topic 以及 Header ，这四种不同的策略，前三种使用频率较高，第四种使用频率较低，下面分别对这四种不同的Exchange Type 进行简单介绍。



**Direct**

DirectExchange 的路由策略是将消息队列绑定到一个 DirectExchange 上，当一条消息到达 DirectExchange 时会被转发到与该条消息 routing key 相同的 Queue 上，例如消息队列名为 “hello-queue” ，则 routing key 为 “hello-queue” 的消息会被该消息队列接收。DirectExchange 的配置如下：

```java
@Configuration
public class RabbitDirectConfig {
    public final static String DIRECTNAME = "sang-direct";
    @Bean
    Queue queue() {
        return new Queue("hello-queue");
    }
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECTNAME, true, false);
    }
    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange()).with("direct");
    }
}
```

代码解释：

1. 首先提供一个消息队列Queue，然后创建一个DirectExchange对象，三个参数分别是名字，重启后是否依然有效以及长期未用时是否删除；
2. 创建一个Binding对象将Exchange和Queue绑定在一起；
3. DirectExchange和Binding两个Bean的配置可以省略掉，即如果使用DirectExchange，可以只配置一个Queue的实例即可。

接下来配置一个消费者，如下：

```java
@Component
public class DirectReceiver {
    @RabbitListener(queues = "hello-queue")
    public void handler1(String msg) {
        System.out.println("DirectReceiver:" + msg);
    }
}
```

通过 @RabbitListener 注解指定一个方法是一个消息消费方法，方法参数就是所接收到的消息。然后在单元测试类中注入一个 RabbitTemplate 对象来进行消息发送，如下：

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void directTest() {
        rabbitTemplate.convertAndSend("hello-queue", "hello direct!");
    }
}
```

确认RabbitMQ已经启动，然后启动 Spring Boot 项目，启动成功后，运行该单元测试方法，在 Spring Boot 控制台打印日志如下图：

![图片描述](https://img1.sycdn.imooc.com/5d10992c00016c2305980112.png)



**Fanout**

FanoutExchange 的数据交换策略是把所有到达 FanoutExchange 的消息转发给所有与它绑定的 Queue 上，在这种策略中，routing key 将不起任何作用，FanoutExchange 配置方式如下：

```java
@Configuration
public class RabbitFanoutConfig {
    public final static String FANOUTNAME = "sang-fanout";
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUTNAME, true, false);
    }
    @Bean
    Queue queueOne() {
        return new Queue("queue-one");
    }
    @Bean
    Queue queueTwo() {
        return new Queue("queue-two");
    }
    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }
    @Bean
    Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }
}
```

在这里首先创建 FanoutExchange ，参数含义与创建 DirectExchange 参数含义一致，然后创建两个 Queue ，再将这两个 Queue 都绑定到 FanoutExchange 上。接下来创建两个消费者，如下：

```java
@Component
public class FanoutReceiver {
    @RabbitListener(queues = "queue-one")
    public void handler1(String message) {
        System.out.println("FanoutReceiver:handler1:" + message);
    }
    @RabbitListener(queues = "queue-two")
    public void handler2(String message) {
        System.out.println("FanoutReceiver:handler2:" + message);
    }
}
```

两个消费者分别消费两个消息队列中的消息，然后在单元测试中发送消息，如下：

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void fanoutTest() {
        rabbitTemplate
        .convertAndSend(RabbitFanoutConfig.FANOUTNAME, 
                null, "hello fanout!");
    }
}
```

注意这里发送消息时不需要 routing key ，指定 exchange 即可，routing key 可以直接传一个 null。
确认RabbitMQ已经启动，然后启动Spring Boot项目，启动成功后，执行单元测试方法，控制台打印日志如下图：

![图片描述](https://img1.sycdn.imooc.com/5d10993600016f7806240108.png)

可以看到，一条消息发送出去之后，所有和该 FanoutExchange 绑定的 Queue 都收到了消息。



**Topic**

TopicExchange 是比较复杂但也是比较灵活的一种路由策略，在 TopicExchange 中，Queue 通过 routing key 绑定到 TopicExchange 上，当消息到达 TopicExchange 后，TopicExchange 根据消息的 routing key 将消息路由到一个或者多个 Queue上。TopicExchange 配置如下：

```java
@Configuration
public class RabbitTopicConfig {
    public final static String TOPICNAME = "sang-topic";
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }
    @Bean
    Queue xiaomi() {
        return new Queue("xiaomi");
    }
    @Bean
    Queue huawei() {
        return new Queue("huawei");
    }
    @Bean
    Queue phone() {
        return new Queue("phone");
    }
    @Bean
    Binding xiaomiBinding() {
        return BindingBuilder.bind(xiaomi()).to(topicExchange())
                .with("xiaomi.#");
    }
    @Bean
    Binding huaweiBinding() {
        return BindingBuilder.bind(huawei()).to(topicExchange())
                .with("huawei.#");
    }
    @Bean
    Binding phoneBinding() {
        return BindingBuilder.bind(phone()).to(topicExchange())
                .with("#.phone.#");
    }
}
```

代码解释：

1. 首先创建 TopicExchange ，参数和前面的一致。然后创建三个 Queue ，第一个 Queue 用来存储和 “xiaomi” 有关的消息，第二个 Queue 用来存储和 “huawei” 有关的消息，第三个 Queue 用来存储和 “phone” 有关的消息；
2. 将三个 Queue 分别绑定到 TopicExchange 上，第一个 Binding 中的 “xiaomi.#” 表示消息的 routing key 凡是以 “xiaomi” 开头的，都将被路由到名称为 “xiaomi” 的 Queue 上；第二个 Binding 中的 “huawei.#” 表示消息的 routing key 凡是以 “huawei” 开头的，都将被路由到名称为 “huawei” 的 Queue 上；第三个 Binding 中的 “#.phone.#” 则表示消息的 routing key 中凡是包含 “phone” 的，都将被路由到名称为 “phone” 的 Queue 上。

接下来针对三个 Queue 创建三个消费者，如下：

```java
@Component
public class TopicReceiver {
    @RabbitListener(queues = "phone")
    public void handler1(String message) {
        System.out.println("PhoneReceiver:" + message);
    }
    @RabbitListener(queues = "xiaomi")
    public void handler2(String message) {
        System.out.println("XiaoMiReceiver:"+message);
    }
    @RabbitListener(queues = "huawei")
    public void handler3(String message) {
        System.out.println("HuaWeiReceiver:"+message);
    }
}
```

然后在单元测试中进行消息的发送，如下：

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void topicTest() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "xiaomi.news","小米新闻..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "huawei.news","华为新闻..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "xiaomi.phone","小米手机..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "huawei.phone","华为手机..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "phone.news","手机新闻..");
    }
}
```

根据 RabbitTopicConfig 中的配置，第一条消息将被路由到名称为 “xiaomi” 的 Queue 上，第二条消息将被路由到名为 “huawei” 的 Queue 上，第三条消息将被路由到名为 “xiaomi” 以及名为 “phone” 的 Queue 上，第四条消息将被路由到名为 “huawei” 以及名为 “phone” 的 Queue 上，最后一条消息则将被路由到名为 “phone” 的 Queue 上。
确认 RabbitMQ 已经启动，然后启动 Spring Boot 项目，启动成功后，运行单元测试方法，控制台打印日志如下图：

![图片描述](https://img1.sycdn.imooc.com/5d10996d0001c5c606080130.png)
![图片描述](https://img1.sycdn.imooc.com/5d10997d0001cb5e04100170.png)



**Header**

HeadersExchange 是一种使用较少的路由策略，HeadersExchange 会根据消息的 Header 将消息路由到不同的 Queue 上，这种策略也和 routing key 无关，配置如下：

```java
@Configuration
public class RabbitHeaderConfig {
    public final static String HEADERNAME = "sang-header";
    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERNAME, true, false);
    }
    @Bean
    Queue queueName() {
        return new Queue("name-queue");
    }
    @Bean
    Queue queueAge() {
        return new Queue("age-queue");
    }
    @Bean
    Binding bindingName() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "sang");
        return BindingBuilder.bind(queueName())
                .to(headersExchange()).whereAny(map).match();
    }
    @Bean
    Binding bindingAge() {
        return BindingBuilder.bind(queueAge())
                .to(headersExchange()).where("age").exists();
    }
}
```

这里的配置大部分和前面介绍的一样，差别主要体现的 Binding 的配置上。第一个 bindingName 方法中，whereAny 表示消息的 Header 中只要有一个 Header 匹配上 map 中的 key/value ，就把该消息路由到名为 “name-queue” 的 Queue 上。这里也可以使用 whereAll 方法，表示消息的所有 Header 都要匹配。whereAny 和 whereAll 实际上对应了一个名为 x-match 的属性。bindingAge 中的配置则表示只要消息的 Header 中包含 age ，不管 age 的值是多少，都将消息路由到名为 “age-queue” 的 Queue 上。

接下来创建两个消息消费者：

```java
@Component
public class HeaderReceiver {
    @RabbitListener(queues = "name-queue")
    public void handler1(byte[] msg) {
        System.out.println("HeaderReceiver:name:"
                + new String(msg, 0, msg.length));
    }
    @RabbitListener(queues = "age-queue")
    public void handler2(byte[] msg) {
        System.out.println("HeaderReceiver:age:"
                + new String(msg, 0, msg.length));
    }
}
```

注意这里的参数用 byte 数组接收。然后在单元测试中创建消息的发送方法，这里消息的发送也和 routing key 无关，如下：

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void headerTest() {
        Message nameMsg = MessageBuilder
                .withBody("hello header! name-queue".getBytes())
                .setHeader("name", "sang").build();
        Message ageMsg = MessageBuilder
                .withBody("hello header! age-queue".getBytes())
                .setHeader("age", "99").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, ageMsg);
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, nameMsg);
    }
}
```

这里创建两条消息，两条消息具有不同的 header ，不同 header 的消息将被发到不同的 Queue 中去。
确认 RabbitMQ 已经启动，然后启动 Spring Boot 项目，启动成功后，执行单元测试方法，结果如下图：

![图片描述](https://img1.sycdn.imooc.com/5d1099880001bf9c06680106.png)

好了，上面这是和大家分享一下 RabbitMQ 的基本用法 。



**动态刷新配置**

使用 Spring Cloud Bus 我们可以轻松实现配置文件的动态刷新，在使用 Spring Cloud Bus 之前，我们动态刷新配置文件大致的架构图如下：

![图片描述](https://img1.sycdn.imooc.com/5d10998e0001a66006870511.png)

可以看到，当配置文件发生变化时，我们需要挨个向 Config Client 发送 `/actuator/refresh` 请求，才能实现 Config Client 上配置文件的动态刷新，这种操作显然很麻烦很费事，结合 Spring Cloud Bus ，我们可以对这个图做进一步的优化，如下：

![图片描述](https://img1.sycdn.imooc.com/5d109994000141be07180610.png)

可以看到，当引入 Spring Cloud Bus 之后，当我们配置文件发生变化时，我们可以指向 Config Server 发送一条更新请求，再由 Config Server 给 Spring Cloud Bus 发送消息；Spring Cloud Bus 收到消息之后，再去自动通知 Config Client 去完成数据更新。在整个过程中，开发者只需要向 Config Server 发送一条消息即可，很明显，这种方式的效率比我们之前动态刷新配置的效率要高很多，接下来我们就来看下这个东西要怎么实现。

这种更新方式实际上分为两种策略，一种是 Spring Cloud Bus 通知所有的 Config Client 更新配置文件，另外一种则是 Spring Cloud Bus 通知部分 Config Client 更新配置文件（由于配置仓库中保存了很多 Config Client 的配置数据，有的时候配置文件发生变化，只是某一个 Config Client 的配置发生变化，这种情况下就没有必要通知所有的 Config Client去更新数据），两种更新方式也有略微的差别，下面我来分别介绍。



**批量刷新**

首先我们需要搭建 Spring Cloud Config 环境，这里简单起见，我就不重复搭建了，直接在 8-3 小节的基础上来完成。

首先我们需要在 config_server 和 config_client 两个模块上分别添加 Spring Cloud Bus 相关的依赖，如下：

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```

添加完成后，再分别给 config_client 和 config_server 模块配置 RabbitMQ，配置信息如下：

```properties
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

由于我们的 config_server 一会儿将提供 /actuator/bus-refresh 接口，因此我们需要配置让这个端口暴露出来，如下：

```properties
management.endpoints.web.exposure.include=bus-refresh
```

同时，由于我们给 config_server 中的所有接口添加了保护，因此 /actuator/bus-refresh 是无法直接访问的，我再添加一个 Spring Security 的配置类，在配置类中对权限再做一些配置，如下：

```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
```

**注意，这里的配置首先是配置所有的请求都必须登录后才能访问，然后配置允许 HttpBasic 登录，这样我们在发起 /actuator/bus-refresh 请求时，就可以直接通过 HttpBaisc 来配置认证信息了。**

配置完成后，分别启动 eureka、config_server 以及 config_client，访问 config_client 的 /hello 接口，结果如下：
![图片描述](https://img1.sycdn.imooc.com/5d10999e0001ac9908660330.png)

此时，我们修改配置文件，提交到远程仓库，然后向 config_server 发送一个 POST 请求，如下：
![图片描述](https://img1.sycdn.imooc.com/5d1099a40001bcbe19860856.png)

注意这个请求，我们设置了 Authorization 的方式为 Basic Auth ，然后填入我们的用户名密码信息，再发送 POST 请求，否则请求响应码为 401 。请求成功之后，我们再次访问 config_client 的 /hello 接口，发现数据已经发生变化了。

![图片描述](https://img1.sycdn.imooc.com/5d1099b4000146b619800596.png)

这种方式，所有的 config_client 都会收到 Spring Cloud Bus 的消息，然后去更新自身的数据，但有的时候我们可能只需要某一部分 config_client 更新数据，其它的不更新数据，那么这种需求该如何处理呢？



**逐个刷新**

首先我们来对 config_client 做一点点改造，给每一个 config_client 实例取一个 instance-id ，添加如下配置即可：

```properties
eureka.instance.instance-id=${spring.application.name}:${server.port}
```

这行配置表示 config_client 的实例 id 是由 `服务名:端口` 组成，配置完成后，点击 IDEA 右边的 Maven Project 对 config_client 进行打包，如下：

![图片描述](https://img1.sycdn.imooc.com/5d1099bf0001011d06740754.png)

打包完成后，进入到 target 目录下，执行如下命令先启动一个 config_client 实例：

```
java -jar config_client-0.0.1-SNAPSHOT.jar --server.port=8002
```

然后换个端口再启动一个 config_client 实例：

```
java -jar config_client-0.0.1-SNAPSHOT.jar --server.port=8003
```

两个实例都启动之后，它们的 instance-id 是不一样的，一个是 client1-8002 ，另外一个是 client1-8003 ，接下来我们再次更新配置文件并且上传到远程仓库，然后给 config_server 发送请求时，像下面这样去发送：

![图片描述](https://img1.sycdn.imooc.com/5d1099c60001e7fc19840886.png)

现在的请求地址变为了 `http://localhost:8001/actuator/bus-refresh/client1:8003` ，最后面的地址就是指 config_client 的 id ，这个表示只发送更新通知给 instance-id 为 client1:8003 的 config_client，其它的 config_client 将不会收到配置文件更新通知。

当这个 POST 请求发送成功之后，我们刷新端口为 8002 的 config_client 发现没有什么变化，再去刷新端口为 8003 的 config_client ，发现数据已经更新了。

**小结**

本文主要和大家聊了聊 RabbitMQ 的基本用法以及利用 Spring Cloud Bus 实现配置文件的动态刷新，相比前面第 8 章学到的配置文件动态刷新方式，这种动态刷新方式效率更高。那么这就是最好的方案吗？其实不见得，后面我们还会向大家介绍 Spring Cloud Alibaba 中的相关组件，可以让大家感受到更加丝滑的配置文件刷新。

### 9、数据流 Stream

#### 1）构建消息驱动的微服务

上篇文章和大家聊了 Spring Cloud Bus 的基本使用，同时给大家演示了如何使用 Spring Cloud Bus 实现配置文件的动态刷新，今天我们在上文的基础上，继续来学习消息驱动的微服务 Spring Cloud Stream 。

根据 Spring Cloud Stream 官方文档的介绍，Spring Cloud Stream 是一个用于构建消息驱动的微服务应用程序的框架。 Spring Cloud Stream 构建于 Spring Boot 之上，用于创建独立的生产级 Spring 应用程序，并使用 Spring Integration 提供与消息代理的连接。它提供了来自多个供应商的中间件的固定配置，定义了发布、订阅、分组以及分区的概念。接下来我们就来向大家介绍下 Spring Cloud Stream 的具体用法。



**核心概念**

在 Spring Cloud Stream 中，我们的微服务通过 inputs 或者 outputs 来与 Spring Cloud Stream 中的 Binder 进行交互，而这里的 Binder 相当于微服务和消息中间件之间的一个粘合剂，这个 Binder 则可以负责与消息中间件如 RabbitMQ 或者 Kafka 进行交互，这个时候对于开发者而言，我们只需要关注微服务和 Spring Cloud Stream 之间的通信方式，即消息要怎么样发送、怎么样订阅，做好这些工作之后，剩下的事情就交给 Spring Cloud Stream 来做，它会帮助我们完成和消息中间件之间的交互。在整个过程中，有几个关键的概念，我们来了解下。



**通信模型**

Spring Cloud Stream 应用程序由中间件驱动，应用程序通过 Spring Cloud Stream 提供的输入和输出通道与外界通信，整个过程通过中间件特定的 Binder 来实现，通道连接到外部代理，官网提供了一张比较形象的工作模型图，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f6e00001922603730310.png)



**Binder**

Spring Cloud Stream 默认为 Kafka 和 RabbitMQ 提供了 Binder 的实现。所谓的 Binder 实际上是一个抽象的概念，如上文所说，它是应用程序和消息中间件之间的一个粘合剂。使用 Binder ，我们可以在程序运行时，动态修改消息的 destination，具体到 RabbitMQ 中就是 exchange ，具体到 Kafka 中就是 topic ，这些我们都可以通过外部属性或者其它 Spring Boot 支持的配置方式（如 application.properties 或 application.yaml）来实现，甚至不需要改变一行代码。



**Publish-Subscribe**

消息驱动最经典的模式莫过于发布订阅了（Publish-Subscribe），在这个过程中数据通过共享主题广播，消息生产者通过某一个 topic 将消息广播出去，其它的微服务则通过订阅这个 topic 来消费消息，这种模式使得消息生产者和消费者进行了极大的解耦，未来如果有新的消息生产者加进来或者新的消息消费者加进来，都不必改变项目的原有架构！



**Consumer Groups**

在真正的生产环境下，微服务通常都是集群化部署，而不会以单节点的方式运行在生产环境，当一个微服务进行集群化部署时，它的所有实例都会绑定到同一个消息通道的 Topic 上。 那么在默认情况下，当消息生产者发出一条消息到绑定的 Topic 上时，这条消息会产生多个副本被每个消息消费者实例接收和处理，但是更多的情况下，我们可能只需要其中一个消息消费者来消费这个消息，此时我们通过 Consumer Groups 功能就能实现这个功能，分组之后，就能够确保消息只被某一个实例消费一次。



**Consumer Types**

Spring Cloud Stream 支持两种类型的消费者：

- 消息驱动（有时称为异步）
- 轮询（有时称为同步）

在2.0版之前，Spring Cloud Stream 仅支持异步使用者，即消息一旦可用就会传递，并且可以使用一个线程来处理它。如果需要控制处理消息的速率，需要使用同步使用者。



**Durability**

Spring Cloud Stream 可以动态选择一个消息队列是持久化，还是 present。对于匿名订阅本质上是非持久的。对于某些绑定器实现（例如RabbitMQ），可以具有非持久的组订阅。



**Partitioning Support**

Partitioning Support 即分区支持，Spring Cloud Stream 支持在给定应用程序的多个实例之间对数据进行分区。例如在某些场景下，我们需要同一个特征的数据被同一个实例消费，这种情况下，单纯的消息分组就不能满足我的需求了，于是 Spring Cloud Stream 又引入了消息分区的概念，通过消息分区，可以确保同一特征的消息始终被同一个消息消费者处理。

![图片描述](https://img1.sycdn.imooc.com/5d27f70900010ef504900260.png)



**Spring Cloud Stream 基本用法**

前面和大家大概理了一下 Spring Cloud Stream 的一些核心概念，接下来我们就来通过一个两个简单的案例向大家来演示一下 Spring Cloud Stream 中基本的消息收发机制。

那么在开始学习之前，我们需要先来创建一个工程，这里我直接创建一个名为 hellostream 的工程，创建时候添加三个依赖 `Web` 、`RabbitMQ` 和 `Cloud Stream`，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f70f0001babc16881162.png)

Spring Boot 创建完成后，接下来我们还需要确保 Docker 容器中的 RabbitMQ 已经在运行了，然后我们就可以来看看 Spring Cloud Stream 的一个基本用法了。



**基本用法**

创建完成后，首先我们来在 application.properties 中配置一下 RabbitMQ 的基本信息：

```properties
spring.rabbitmq.password=guest
spring.rabbitmq.username=guest
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
```

接下来我们来创建一个简单的消息接收器，如下：

```java
@EnableBinding(Sink.class)
public class MsgReceiver {
    @StreamListener(Sink.INPUT)
    public void receive(Object playload) {
        System.out.println("Received:"+playload);
    }
}
```

在这里，我们首先使用了 @EnableBinding 注解实现对消息通道的绑定，哪个消息通道呢？就是参数 Sink ，事实上，这里的参数可以有多个，Sink 是一个默认定义的消息通道。接下来我们在 MsgReceiver 类中定义了 receive 方法，并在该方法上添加了 @StreamListener 注解，该注解表示该方法为消息中间件上数据流的事件监听器，Sink.INPUT 参数表示这是 input 消息通道上的监听处理器（在 Spring Cloud Stream 中可以有多个通道）。

定义完成后，启动我们的 Spring Boot 项目，启动日志中，可以看到如下信息：

![图片描述](https://img1.sycdn.imooc.com/5d27f7160001728520820294.png)

看到这条日志说明我们的 Spring Boot 工程已经连接上 RabbitMQ 了。接下来我们登录 RabbitMQ 管理页面，通过管理页面发送一条消息，看看我们的 Spring Boot 工程是否能够收到这条消息，登录 RabbitMQ 消息管理页面之后，在 Queue 选项卡中，找到我们刚刚的消息通道，如下：
![图片描述](https://img1.sycdn.imooc.com/5d27f71b0001e62b19601180.png)

点进去，然后找到 Publish Message ，发送一条消息，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f7210001c2d626221624.png)

发送完成后，我们发现 Spring Boot 项目的控制台已经打印出日志了，表示消息已经成功发送并且消费了。



**自定义消息通道**

上面的案例是使用 RabbitMQ 的控制台进行消息的发送，在真正的生产环境中，这种需求一般不多，我们都是通过代码进行消息的发送。接下来我们就看看如何自定义消息通道。

首先我们创建一个类名为 MyChannel ，如下：

```java
public interface MyChannel {
    String INPUT = "mychannel-input";
    String OUTPUT = "mychannel-output";

    @Output(OUTPUT)
    MessageChannel output();
    
    @Input(INPUT)
    SubscribableChannel input();
}
```

代码解释：

- 首先我们定义了两个消息通道的名字，两个名字是不一样的；
- 接下来定义了一个消息输出通道，什么是输出通道呢？其实就是消息发送通道；
- 最后定义了一个消息输入通道，所谓的消息输入通道就是消息接收通道；
- 一会我们在消息发送通道发送消息，在消息接收通道接收消息，有人可能会说这两个明明都不在同一个通道，能收到消息吗？不在同一个通道当然是收不到消息的，但是从 Sprint Cloud Finchley 版开始，默认使用通道名作为相应的实例名，因此这里我们不能使用相同的通道名，否则实例将创建失败，进而导致项目启动失败。一会我们将在 application.properties 中做一些额外配置，使消息接收通道能够收到消息。

接下来我们再定义一个消息消费者，消费我们自己通道上的消息，如下：

```java
@EnableBinding(MyChannel.class)
public class MsgReceiver2 {
    @StreamListener(MyChannel.INPUT)
    public void receive(Object playload) {
        System.out.println("Received2:"+playload);
    }
}
```

这个消息消费者的定义和我们前面的定义差不多，主要是监控的通道变了，变成了我们自己的消息通道了。

然后再来定义一个消息生产者，如下：

```java
@RestController
public class HelloController {
    @Autowired
    MyChannel myChannel;

    @GetMapping("/test1")
    public void hello() {
        myChannel.output().send(MessageBuilder.withPayload("hello stream!").build());
    }
}
```

调用 MyChannel 对象中的 output 方法，就可以成功发送一条消息出去，这条消息将在消息发送通道上发出！消息本身使用 MessageBuilder 来构建。

这样消息就能成功收发了吗？理论上来说是没错的，但是运行之后你会发现收不到消息，怎么回事呢？消息发送成功没？成功了！消息接收到了吗？没有！什么原因呢？这就是我们刚刚开头说的，消息收发目前不在一个通道上，所以发出去的消息，没法收到，那么怎么办呢？很简单，只需要我们在配置文件 application.properties 中，再添加如下两行配置:

```properties
spring.cloud.stream.bindings.mychannel-input.destination=javaboy-topic
spring.cloud.stream.bindings.mychannel-output.destination=javaboy-topic
```

这样就使得我们的消息收发在同一个通道上了，此时，启动 Spring Boot 项目，然后在浏览器中发送 `http://localhost:8080/test1` 请求，此时，我们可以看到 IntelliJ IDEA 控制台打印出来日志，表示消息已经被收到了：

![图片描述](https://img1.sycdn.imooc.com/5d27f72b000199ea10180204.png)

这样一个简单的例子向大家展示了自定义消息通道。



**消息分组**

消息分组我们在文章一开头的时候和大家说过，就是一条消息默认情况下被同一个微服务的所有实例消费（该微服务集群化部署），有的时候我们只需要被其中一个实例消费即可，此时我们需要进行消息分组配置。

配置方式很简单，在 application.properties 中添加如下配置：

```properties
spring.cloud.stream.bindings.mychannel-input.group=g1
spring.cloud.stream.bindings.mychannel-output.group=g1
```

表示消息输入输出通道都是属于消费组 g1 的，配置完成后，我们将 Spring Boot 项目打成 jar 包，点击右边 Maven Project 中的 package 按钮，如下：
![图片描述](https://img1.sycdn.imooc.com/5d27f73000015f3805940594.png)

打包成功之后，分别在定位到 jar 包所在的目录，分别执行如下两行命令，启动两个端口不同的实例：

```
java -jar hellostream-0.0.1-SNAPSHOT.jar --server.port=8080
java -jar hellostream-0.0.1-SNAPSHOT.jar --server.port=8081
```

启动成功之后，我们再次调用 `http://localhost:8080/test1` 接口，发现每次消息只被一个实例消费（每次只有一个实例的控制台有日志打印出来）。



**消息分区**

还有一个概念叫做消息分区，就是说具有相同特征的消息总是被同一个实例处理，单纯的消息分组是无法实现这个功能的。在前面的消息分组中，相同特征的消息也会被发送到不同的实例上去执行。如果想发送到一个实例上去执行，我们只需要添加如下配置即可（下面的配置是在消息分组的基础上配置的）:

```properties
spring.cloud.stream.bindings.mychannel-input.consumer.partitioned=true
spring.cloud.stream.instance-count=2
spring.cloud.stream.instance-index=0
spring.cloud.stream.bindings.mychannel-output.producer.partition-key-expression=1
spring.cloud.stream.bindings.mychannel-output.producer.partitionCount=2
```

代码解释：

- 首先第一行配置表示开启消息分区；
- 第二行配置消息消费者实例的个数；
- 第三行配置表示当前实例的下标；
- 第四行配置表示这个消息将被下标为 1 的消息消费者所消费；
- 第五行表示消费端的节点数量为 2；
- 由于消息消费者和消息生产者在同一个项目中，因此这里的配置我写在了一起；如果消息消费者和生产者是两个项目，那么前三行消息消费者相关的配置写在消息消费者中，后两行消息生产者相关的配置写在消息生产者中。

配置完成后，我们将项目重新打包，然后执行如下命令启动两个消息消费者实例：

```
java -jar hellostream-0.0.1-SNAPSHOT.jar --server.port=8080 --spring.cloud.stream.instance-index=0
java -jar hellostream-0.0.1-SNAPSHOT.jar --server.port=8081 --spring.cloud.stream.instance-index=1
```

注意在启动命令中需要标记实例的 ID ，即 `spring.cloud.stream.instance-index` 参数。启动成之后，我们再次调用 `http://localhost:8080/test1` 接口发送消息，消息就只会被 ID 为 1 的实例所接收。

**小结**

好了，本文主要向读者介绍了 Spring Cloud Stream 中的一些核心概念，使大家对于 Spring Cloud Stream 的用法有一个基本认识，然后向大家介绍了 Spring Cloud Stream 的一些基本用法，包括默认的消息发送、自定义消息通道、消息分组以及消息分区等，通过这几个案例，相信大家对于 Spring Cloud Stream 已经有了一个基本的认知

#### 2）Spring Cloud Stream 深入实践

上篇文章和大家聊了 Spring Cloud Stream 的基本架构和基本用法，包括基本的消息收发、自定义消息通道、消息分组以及消息分区等。相信学习完之后，大家对于 Spring Cloud Stream 已经有了一个基本的认知。本文我想结合具体项目中的一些使用场景，再来带大家看看 Spring Cloud Stream 的用法。



**异步处理**



**案例介绍**

很多场景下，我们都是使用消息中间件而不是多线程来处理一些异步任务，这样可以更好地实现应用程序的解耦。一个常见的使用场景就是用户注册流程。一般来说，用户注册一个网站，可能都需要验证手机号码或者邮箱地址，如果不使用异步处理的话，我们的流程可能是这样的：

![图片描述](https://img1.sycdn.imooc.com/5d27f76e0001451008900180.png)

引入异步处理之后，我们就可以将验证信息的发送交给消息中间件去做，然后就可以快速给前端一个响应，优化后的流程像下面这样：
![图片描述](https://img1.sycdn.imooc.com/5d27f774000100f006190408.png)

此时注册效率就会得到极大地提高。假设优化前每个流程需要 500ms ，那么总共需要 2.5s ，优化后则只需要 1.5s 就可以执行完步骤了。

接下来，我就通过一个简单的注册案例来向大家展示下 Spring Cloud Stream 在这个场景下的使用。



**案例展示**

首先我们来创建一个名为 streamdemo 的 Spring Boot 项目，创建时候添加四个依赖 `Web`、`RabbitMQ` 、`Cloud Stream`、`mail` 以及 `Thymeleaf`，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f77b00016f0d16781166.png)

前三个依赖好理解，这和我们上篇文章所需要的依赖一样，后面两个则是用来发送邮件的，Mail 依赖用来添加邮件发送支持，Thymeleaf 则用来构建邮件发送模版。

Spring Boot 创建完成后，接下来我们还需要启动 Docker 容器中的 RabbitMQ 中间件，中间件启动成功之后，我们在 streamdemo 项目的 application.properties 中添加如下配置：

```properties
spring.rabbitmq.password=guest
spring.rabbitmq.username=guest
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
```

这样首先确保我们的 Spring Boot 具有连接消息中间件的能力，然后我们来添加一个简单的注册接口：

```java
@RestController
public class RegController {
    @Autowired
    RegService regService;
    @PostMapping("/doReg")
    public Map<String, Object> reg(String email, String phone, String password) {
        return regService.reg(email, phone, password);
    }
}
@Service
public class RegService {

    @Autowired
    RegChannel regChannel;

    public Map<String, Object> reg(String email, String phone, String password) {
        //数据写入数据库
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("phone", phone);
        regChannel.output().send(MessageBuilder.withPayload(map).build());
        map.put("msg", "验证短信已经发送，请注意查收！");
        return map;
    }
}
```

这里为了简单处理，写入数据库的操作我就直接省略了。当服务端收到用户的注册信息时，先将信息保存到数据库中，然后向消息中间件发送消息。发送完成之后，剩下的验证消息发送就是其它服务模块的事情了，注册流程此时就可以直接返回了。

RegChannel 是一个自定义的消息通道，如下：

```java
public interface RegChannel {
    String INPUT = "reg-input-channel";
    String OUTPUT = "reg-output-channel";

    @Output(OUTPUT)
    MessageChannel output();
    @Input(INPUT)
    SubscribableChannel input();
}
```

这里定义了两个消息通道，一个发送消息一个接收消息，应该不需要过多解释，和上篇文章基本一致。在实际生产环境中，根据项目的实际情况，我们可能会单独创建一个消息发送微服务，这里为了方便给大家演示，我将消息发送和接收放在同一个服务之中。当然，我们前文说过，这样定义之后，由于消息发送和接收不在同一个通道上，发送的消息是无法收到的，所以我们还需要在 application.properties 文件中继续添加如下配置：

```properties
spring.cloud.stream.bindings.reg-input-channel.destination=javaboy-topic
spring.cloud.stream.bindings.reg-output-channel.destination=javaboy-topic
```

然后我们再来定义一个消息消费者，用来读取消息中间件中的消息，如下：

```java
@EnableBinding(RegChannel.class)
public class SendVerifyCodeService {
    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    MailService mailService;

    @StreamListener(RegChannel.INPUT)
    public void sendVerifyCode(Map<String, Object> map) {
        //发送验证邮件和短信
        System.out.println("receive:" + map);
        Context ctx = new Context();
        String email = (String) map.get("email");
        ctx.setVariable("email", email);
        ctx.setVariable("code",(int)(Math.random()*10000));
        String mail = templateEngine.process("mailtemplate.html", ctx);
        mailService.sendHtmlMail("1510161612@qq.com",
                email,
                "欢迎注册XXX网站",
                mail);

    }

}
@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendHtmlMail(String from, String to,
                             String subject, String content){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("发送失败");
        }
    }
}
```

代码解释：

- 首先注入 TemplateEngine ，当我们在项目中引入 Thymeleaf 的依赖之后，就自动具备了这个 Bean 了，这个 Bean 一会儿用来将 Thymeleaf 模版渲染成 HTML 页面；
- 注入 MailService，这是一个我们封装好的邮件发送工具类；
- 监听邮件发送消息通道，在收到消息后，首先创建一个 Context 实例，这个实例中保存了我们即将渲染到 Thymeleaf 中的数据，然后向 Context 中保存两个变量，分别是 email 和生成的随机校验码 code ，这两个数据我们将在 Thymeleaf 模版中使用；
- 调用 TemplateEngine 中的 process 方法，将 Thymeleaf 模版渲染成 HTML 页面；
- 调用 MailService 中的 sendHtmlMail 方法，执行邮件发送工作。

当然，要实现邮件发送工作，我们还需要在 application.properties 中配置一下连接邮件服务器的必备信息：

```properties
spring.mail.host=smtp.qq.com
spring.mail.port=465
spring.mail.username=1510161612@qq.com
spring.mail.password=igprkcldlddxiiae
spring.mail.default-encoding=UTF-8
spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
spring.mail.properties.mail.debug=true
```

这里的配置信息，我们在前面第 6 章中提到过，这里我就不再赘述了。唯一需要说的是，password 字段不是真正的 password ，是我们申请到的一个授权码，授权码的具体申请方式参考本文附录。最后我们再来看看放在 resources/templates 目录下的邮件模版：

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>注册验证</title>
</head>
<body>
<div>注册验证</div>
<div>您的注册信息是：
    <table border="1">
        <tr>
            <td>邮箱地址</td>
            <td th:text="${email}"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td th:text="${code}"></td>
        </tr>
    </table>
</div>
<div>
    如果您未注册本站，请忽略本邮件。
</div>
</body>
</html>
```

在邮件模版中，我们将动态渲染邮箱地址和验证码两个变量。好了，做完这两个操作之后，接下来我们就可以启动我们的 Spring Boot 项目了。启动成功之后，通过 POSTMAN 发送一个注册请求，发送成功之后，我们就可以收到注册邮件了，这个比较容易，我就不展示了。



**定时任务**

定时任务各种各样，常见的定时任务比如日志备份，我们可能在每天凌晨 3 点去备份，这种固定时间的定时任务我们一般采用 cron 表达式就能轻松实现。还有一些比较特殊的定时任务，像大家看电影中的定时炸弹，3分钟后爆炸，这种定时任务就不太好用 cron 去描述，因为开始时间不确定，我们开发中有的时候也会遇到类似的需求，此时通过消息中间件就能够很方便地解决。

整体上来说，在 RabbitMQ 上实现定时任务有两种方式：

- 利用 RabbitMQ 自带的消息过期和私信队列机制，实现定时任务，这种方式较复杂；
- 使用 RabbitMQ 的 rabbitmq_delayed_message_exchange 插件来实现定时任务，这种方案较简单，使用较普遍。

这里主要向大家展示第二种用法。



**实践案例**

首先我们需要下载 rabbitmq_delayed_message_exchange 插件。

[rabbitmq_delayed_message_exchange插件下载](https://dl.bintray.com/rabbitmq/community-plugins/3.7.x/rabbitmq_delayed_message_exchange/rabbitmq_delayed_message_exchange-20171201-3.7.x.zip)

下载完成后解压，然后在命令行执行如下命令，将下载文件拷贝到 Docker 容器中去：

```
docker cp /Users/sang/Downloads/rabbitmq_delayed_message_exchange-20171201-3.7.x.ez some-rabbit:/plugins
```

这里第一个参数是宿主机上的文件地址，第二个参数是拷贝到容器的位置。

接下来再执行如下命令进入到 RabbitMQ 容器中：

```
docker exec -it some-rabbit /bin/bash
```

进入到容器之后，执行如下命令启用插件：

```
rabbitmq-plugins enable rabbitmq_delayed_message_exchange
```

启用成功之后，还可以通过如下命令查看所有安装的插件，看看是否有我们刚刚安装过的插件，如下：

```
rabbitmq-plugins list
```

命令的完整执行过程如下图：

![图片描述](https://img1.sycdn.imooc.com/5d27f79a0001a39821221024.png)

OK，配置完成之后，接下来我们执行 `exit` 命令退出 RabbitMQ 容器，然后开始编码，接下来的案例我们直接在前文的基础上进行，我就不再另外单独搭建工程了。

首先我们来自定义一个消息通道，如下：

```java
public interface DelayMsgChannel {
    String INPUT = "delay_msg_input";
    String OUTPUT = "delay_msg_output";

    @Input(INPUT)
    SubscribableChannel input();

    @Output(OUTPUT)
    MessageChannel output();
}
```

这里无需多做解释，接下来我们再来定义一个消息消费者：

```java
@EnableBinding(DelayMsgChannel.class)
public class DelayMessageRecevier {
    @StreamListener(DelayMsgChannel.INPUT)
    public void recevier(String msg) {
        System.out.println("receive:" + msg + ">>>" + new Date());
    }

}
```

大家看到，这里的所有定义，都是和前面的案例一样，好像并没有体现出消息延迟相关的配置。

接下来，我们再在 application.properties 中添加如下配置：

```properties
spring.cloud.stream.bindings.delay_msg_input.destination=delay_msg
spring.cloud.stream.bindings.delay_msg_output.destination=delay_msg
spring.cloud.stream.rabbit.bindings.delay_msg_output.producer.delayed-exchange=true
spring.cloud.stream.rabbit.bindings.delay_msg_input.consumer.delayed-exchange=true
```

- 前两行配置表示配置消息队列；
- 后面两行表示分别在消息消费者和生产者中启用消息延迟功能。

配置完成之后，在添加一个消息生产者，如下：

```java
@RestController
public class DelayMsgController {
    @Autowired
    DelayMsgChannel delayMsgChannel;
    @GetMapping("/delay")
    public void hello() {
        System.out.println("message send："+new Date());
        delayMsgChannel.output().send(MessageBuilder.withPayload("delay message!").setHeader("x-delay", 3000).build());
    }
}
```

注意，和前文不一样的地方是，这里的消息生产者多了一个延迟的头字段。另外，我们在消息发送时还打印出时间日志，这样方便判断消息是否延迟。

做完这些事情之后，我们就可以启动项目了，启动成功之后，访问 `/delay` 接口，消息消费者就可以收到消息了。对比消息发送和接收时间，就可以发现消息延迟了三秒之后才收到，如下图：
![图片描述](https://img1.sycdn.imooc.com/5d27f7a10001143308340250.png)



**限流削峰**

消息中间件另外一个广泛使用的场景就是限流削峰，大家知道解决高并发问题是一揽子方案，而不是靠某一种策略就能解决高并发问题的，那么限流削峰就是这一揽子方案中的一个。

以商品秒杀为例，请求如果直接进入到业务层，由于业务层处理比较复杂，例如库存检查、库存冻结、余额检查、余额冻结、订单生成、余额扣减、库存扣减、生成流水、余额解冻以及库存解冻等，这一套流程下来，耗时还是比较长的，在高并发环境下可能会把业务层搞瘫痪。

此时我们可以加入一个消息队列实现限流削峰，即所有的请求都先进入到消息队列中，业务模块再去消息队列中读取消息、挨个处理，整个过程还可以进行流量控制，这样就可以有效降低业务模块的压力。同时，在秒杀过程中，那些进入消息队列较晚的消息，肯定是秒杀不到商品的，这时这个请求就可以直接处理，可以直接给用户返回秒杀失败或者商品已售空。

**小结**

本文通过一个简单的例子向大家展示了 Spring Cloud Stream 在项目中的使用。实际上，Spring Cloud Stream 使用场景还是非常多的，例如 A 服务调用 B 服务，如果不需要及时知道 B 服务的执行结果，此时就可以引入消息中间件，如果 A 需要当时就知道 B 的执行结果，那么此时引入消息中间件就不合理了。把握住这一点，就能在项目中合理使用消息中间件和 Spring Cloud Stream 了。通过本文的介绍，相信大家已经发现，无论是哪一种场景，如果单纯从技术角度来说，用法基本上都是一样的，所以我们这里就给大家举两个典型例子就可以了。



**附录**



**邮件协议**

我们经常会听到各种各样的邮件协议，比如 SMTP、POP3、IMAP，那么这些协议有什么作用、有什么区别？我们先来讨论一下这个问题。

SMTP 是一个基于 TCP/IP 的应用层协议，江湖地位有点类似于 HTTP，SMTP 服务器默认监听的端口号为 25 。看到这里，小伙伴们可能会想到，既然 SMTP 协议是基于 TCP/IP 的应用层协议，那么我是不是也可以通过 Socket 发送一封邮件呢？回答是肯定的。

生活中我们投递一封邮件要经过如下几个步骤：

1.深圳的小王先将邮件投递到深圳的邮局；
2.深圳的邮局将邮件运送到上海的邮局 ；
3.上海的小张来邮局取邮件 。

这是一个缩减版的生活中邮件发送过程。这三个步骤可以分别对应我们的邮件发送过程，假设从 [aaa@qq.com](mailto:aaa@qq.com) 发送邮件到 [111@163.com](mailto:111@163.com)：

1. [aaa@qq.com](mailto:aaa@qq.com) 先将邮件投递到腾讯的邮件服务器；
2. 腾讯的邮件服务器将我们的邮件投递到网易的邮件服务器；
3. 111@163.com登录网易的邮件服务器查看邮件。

邮件投递大致就是这个过程，这个过程就涉及到了多个协议，我们来分别看一下。

SMTP 协议全称为 Simple Mail Transfer Protocol ，译作简单邮件传输协议。它定义了邮件客户端软件与 SMTP 服务器之间，以及 SMTP 服务器与 SMTP 服务器之间的通信规则。也就是说 [aaa@qq.com](mailto:aaa@qq.com) 用户先将邮件投递到腾讯的 SMTP 服务器这个过程就使用了 SMTP 协议，然后腾讯的 SMTP 服务器将邮件投递到网易的 SMTP 服务器这个过程也依然使用了 SMTP 协议， SMTP 服务器就是用来收邮件。而 POP3 协议全称为 Post Office Protocol，译作邮局协议，它定义了邮件客户端与 POP3 服务器之间的通信规则。那么该协议在什么场景下会用到呢？当邮件到达网易的 SMTP 服务器之后，111@163.com 用户需要登录服务器查看邮件，这个时候该协议就用上了：邮件服务商都会为每一个用户提供专门的邮件存储空间，SMTP服务器收到邮件之后，就将邮件保存到相应用户的邮件存储空间中，如果用户要读取邮件，就需要通过邮件服务商的 POP3 邮件服务器来完成。最后，可能也有小伙伴们听说过 IMAP 协议，这个协议是对 POP3 协议的扩展，功能更强，作用类似，这里不再赘述。



**发送QQ邮件准备工作**

安全起见，QQ 邮箱在使用 Java 代码发送邮件时，无法直接使用密码，而是需要通过授权码认证，授权码获取需要首先登录QQ邮箱网页版，点击上方的设置按钮：

![图片描述](https://img1.sycdn.imooc.com/5d27f7aa00016b0605470315.jpg)

然后点击账户选项卡：

![图片描述](https://img1.sycdn.imooc.com/5d27f7b00001b75a04810181.jpg)

在账户选项卡中找到开启POP3/SMTP选项，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f7b60001050d06900179.jpg)

点击开启，开启相关功能，开启过程需要手机号码验证，按照步骤操作即可，不赘述。开启成功之后，即可获取一个授权码，将该号码保存好，在使用 Java 代码登录时，这个授权码就是密码。

### 10、数据跟踪 Sleuth

#### 1）**分布式链路跟踪和 Spring Cloud Sleuth**

当代互联网服务，通常都是用复杂的、大规模分布式集群来实现的。互联网应用构建在不同的软件模块集上，而这些软件模块，可能是由不同的团队开发、使用不同的编程语言来实现，可能分布在了几千台服务器上、横跨多个不同的数据中心。因此，就需要一些可以帮助理解系统行为、用于分析性能问题的工具。

Spring Cloud Sleuth 的诞生便是为了帮助解决此类问题。在学习 Spring Cloud Sleuth 之前，我们需要先了解一下什么是分布式链路跟踪，为什么我们需要分布式链路跟踪，以及它解决了什么样的问题。

在微服务架构中，服务被切割成了很多的微服务，这些微服务相互之间通过 Http 的方式交互。在一个小型的微服务架构中，一次请求会涉及十几次不同项目之间的调用；在一个中型的互联网公司，一次请求平均会几百次的调用请求。因此在出现问题时，我们可能需要了解这些问题:

- 如何快速发现问题？
- 一次请求都调用了哪些服务？
- 为什么请求这么慢，到底是哪里出现了问题？
- 请求调用失败时，究竟是哪个服务调用失败了？

如果按照传统的方式根据日志来跟踪，那么当项目出现问题时，可能需要运维查询上百台甚至上万台服务日志来定位，仅日志收集一项就会产生巨大的工作量。即便使用 ELK 套件解决日志的收集问题，将这些日志进行关联、定位也将是一个巨大的工作量。有更好的解决方案吗？这就涉及到了分布式链路跟踪的概念。



**分布式链路跟踪**

现今业界分布式链路跟踪的理论基础主要来自于 Google 的一篇论文[《Dapper, a Large-Scale Distributed Systems Tracing Infrastructure》](https://storage.googleapis.com/pub-tools-public-publication-data/pdf/36356.pdf)。我们先根据一张图来了解一下一次请求的调用。

![图片描述](https://img1.sycdn.imooc.com/5d27f7ea0001e8cb04740451.png)

> 图来源于 Google Dapper

图中 A-E 分别表示五个服务，用户发起一次 X 请求到前端系统 A，然后 A 分别发送 RPC 请求到中间层 B 和 C，B 处理请求后返回，C 还要发起两个 RPC 请求到后端系统 D 和 E。

以上完整调用回路中，一次请求需要经过多个系统处理完成，并且追踪系统是持续跟踪到请求的每一步，也就是说分布式链路跟踪需要记录、跟踪一次请求的所有相关数据。在前端用户发起一次 X 请求的时候，就需要给这个请求生产一个唯一的 ID，在后面的所有请求调用中都需要带着这个 ID，最后根据这个 ID 将整个请求串联起来。

一个完成的分布式链路跟踪系统主要有三部分：数据收集、数据存储和数据展示。数据收集需要在调用的过程中，记录每一次请求的开始时间、结束时间、服务ID等其它相关数据；数据存储需要在短时间内快速存储大量的跟踪数据，并且需要满足快速检索的需求；数据展示，根据不同的维度以图形化的形式将收集的数据展示到页面，方便运营人员对问题进行分析、定位。

Spring Cloud Sleuth 属于分布式链路跟踪系统中数据收集的一个实现，它支持集成 Zipkin 等产品以图形化的方式展示分布式链路中收集的数据。



**Spring Cloud Sleuth 介绍**

Spring Cloud Sleuth 为 Spring Cloud 实现了分布式链路跟踪解决方案。Spring Cloud Sleuth 的实现过程也是充分吸收借鉴了 Google Dapper 的思想，并且沿用了一些 Google Dapper 术语。

Spring Cloud Sleuth 为服务之间调用提供了链路追踪，通过 Sleuth 可以很清楚的了解到一个服务请求经过了哪些服务，每个服务处理花费了多长时间，从而让我们可以很方便的理清各微服务间的调用关系。此外 Sleuth 还可以帮助我们：

- 耗时分析: 通过 Spring Cloud Sleuth 可以很方便的了解到每个采样请求的耗时，从而分析出哪些服务调用比较耗时；
- 可视化错误: 对于程序未捕捉的异常，可以通过集成 Zipkin 服务界面上看到；
- 链路优化: 对于调用比较频繁的服务，可以针对这些服务实施一些优化措施。



**Sleuth 相关术语**

**Trace**

服务追踪的追踪单元是从客户发起请求（request）抵达被追踪系统的边界开始，到被追踪系统向客户返回响应（response）为止的过程，称为一个“trace”。Trace 由一组 Span 形成树状结构，例如，如果运行分布式大数据存储，则可能由 PUT 请求形成 trace。

**Span**

每个 Trace 中会调用若干个服务，为了记录调用了哪些服务，以及每次调用的消耗时间等信息，在每次调用服务时，埋入一个调用记录，称为一个“span”。 Span 是 Sleuth 的基本工作单元，若干个有序的 Span 组成一个 trace。Span 由唯一的 64 位 ID 标识，还有另外一个 64 位 ID 标识其所属的 Trace。

Span 可以启动和停止，它们可以追踪自己的时间信息，创建 span 后，必须在将来的某个时刻停止它。

> 启动 Trace 的初始 span 称为 root span，该 span 的 ID 值等于 trace ID。

**Annotation**

Annotation 相当于 Span 记录的语法，描述 Span 现在所处的状态，它主要由四个概念：

- cs : Client Sent 客户端发送。表示一个 Span 的起始。
- sr : Server Received 服务端接收。表示服务端接收到请求，并开始处理。如果减去 cs 的时间戳，则表示网络传输时长。
- ss : Server Sent 服务端完成请求处理，应答信息被发回客户端。如果减去 sr 的时间戳，则表示服务端处理请求的时长。
- cr : Client Received 客户端接收。标志着 Span 的结束，客户端成功的接收到服务端的应答信息。如果减去 cs 的时间戳，则表示请求的响应时长。



**记录过程**

了解完这些概念之后，我们来看一下 Spring Cloud Sleuth 如何使用这些术语来完成一次 Trace 的记录。

![图片描述](https://img1.sycdn.imooc.com/5d27f7f5000117f908900476.png)

> 图来源于 Spring Cloud Sleuth 官网。

图中可以看出请求涉及到四个服务，每一次的请求和响应都会产生一个 Span 状态，在 Span 中会存储 Span id 和 Trace id 用来标记他们的所属关系，同时 Span 中会使用 Annotation 标记每一个 Span 当前的状态。通过以上信息的有序组合很直观的展示了一次请求（Trace）的调用过程。

图中标记的每种颜色表示一个 span（有七个 span — 从 A 到 G），Span 的格式如下：

```
Trace Id = X # 所属 Trace id
Span Id = D  # 自身 id
Client Sent  # 状态
```

此标记表示当前 Span 的 Trace Id 设置为 X，Span Id 设置为 D，此外，还发生了 Client Sent 事件。

Span 相互之间存在着父子关系，最开始的 Span 为初始 Span 没有父级，前面调用的 Span 是后面 Span 的父级。依此类推上图中七个 Span 的父子关系如下：
![图片描述](https://img1.sycdn.imooc.com/5d27f7fc000185aa06660212.png)

> 图来源于 Spring Cloud Sleuth 官网。



**跟踪原理**

当我们项目中引入`spring-cloud-starter-sleuth`包后，每次链路请求都会添加一串追踪信息，格式是`[server-name, main-traceId,sub-spanId,boolean]`。

- server-name：服务结点名称；
- main-traceId：一条链路唯一的 ID，为 TraceID；
- sub-spanId：链路中每一环的 ID，为 SpanID；
- boolean：是否将信息输出到 Zipkin 等服务收集和展示。

这种机制是如何实现的呢？我们知道 Spring Cloud 微服务是通过 Http 协议通信的，所以 Sleuth 的实现也是基于 Http 的，为了在数据的收集过程中不影响到正常业务，Sleuth 会在每个请求的 Header 上添加跟踪需求的重要信息，例如：

```
X-A1-TraceId：对应 TraceID；
X-A1-SpanId：对应 SpanID；
X-A1-ParentSpanId：前面一环的 SpanID；
X-A1-Sampled：是否被选中抽样输出；
X-Span-Name：工作单元名称。
```

这样在数据收集时，只需要将 Header 上的相关信息发送给对应的图像工具即可，图像工具根据上传的数据，按照 Span 对应的逻辑进行分析、展示。

**小结**

本节为大家介绍了分布式链路跟踪产生的背景，以及它解决了哪些问题。Spring Cloud Sleuth 是 Spring Cloud 体系内分布式跟踪解决方案的组件之一，使用 Spring Cloud Seuth 可以轻松收集微服务架构中，每个请求的调用数据。根据这些数据，我们能方便的解决服务性能优化、快速定位等问题。

#### 2）**Spring Cloud Sleuth 实践**

上一节课我们介绍了 Spring Cloud Sleuth 相关术语和工作原理，这节课我们将学习如何使用 Spring Cloud Sleuth 进行信息采集。

我们先来一个最简单的 Hello World。



**快速入手**

创建示例项目 spring-cloud-sleuth，按照以下步骤进行配置。

**添加依赖**

应用中增加 Sleuth 非常简单，只需在 pom.xml 增加以下的依赖：

```
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
   <dependency>
	 <groupId>org.springframework.cloud</groupId>
	 <artifactId>spring-cloud-starter-sleuth</artifactId>
   </dependency>
</dependencies>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

添加 `spring-boot-starter-web` 依赖包，是因为下面我们需要模拟测试 Web 请求。

**创建服务**

我们来创建一个 hello world 服务，打印一行日志来看看 Sleuth 都干了哪些事。

```java
@RestController
public class SleuthController {
    private static final Log log = LogFactory.getLog(SampleController.class);   
    @RequestMapping("/hello")
    public String hello() {
        log.info("Doing some work");
        return "hello world";
    }
}
```

一个很简单的服务，打印日志是因为 Sleuth 和日志已经做了深度融合，会将 Sleuth 收集的信息打印出来。

**测试**

上面工作准备完成之后，启动项目，在浏览器中访问地址：`http://localhost:8080/hello` 调用上面创建好的服务，这时会在控制台看到这样一行日志：

```
2019-05-03 10:48:54.890  INFO [Spring Cloud Sleuth,4e088a46074173ee,4e088a46074173ee,false] 20124 --- [nio-8080-exec-2] com.justdojava.sleuth.HelloController    : Doing some work
```

`[Spring Cloud Sleuth,4e088a46074173ee,4e088a46074173ee,false]` 即为本次 Sleuth 输出的内容，日志的格式为：[application name, traceId, spanId, export]，上节我们已经做过解释，分别是应用名、traceId、spanId 和是否对外输出。

这样最简单的一个 Sleuth 测试就完成了。



**请求调用**

上面只是一个最简单的调用示例，我们来看看如果在方法中调用另外一个方法，Sleuth 是如何记录数据的。

创建一个 hi () 方法，通过 restTemplate 去调用 hi2 () 方法。代码如下：

```java
@RequestMapping("/")
public String hi() throws InterruptedException {
    log.info("hi!");
    Thread.sleep(this.random.nextInt(1000));

    String s = this.restTemplate
            .getForObject("http://localhost:" + this.port + "/hi2", String.class);
    return "hi/" + s;
}

@RequestMapping("/hi2")
public String hi2() throws InterruptedException {
    log.info("hi2!");
    int millis = this.random.nextInt(1000);
    Thread.sleep(millis);
    this.tracer.currentSpan().tag("random-sleep-millis", String.valueOf(millis));
    return "hi2";
}
```

添加完成后重新启动项目，在浏览器中访问访问地址：`http://localhost:8080/`，查看控制台日志的打印信息。

```
2019-05-03 12:59:42.745  INFO [Spring Cloud Sleuth,063ad9837aebfe4a,063ad9837aebfe4a,true] 29536 --- [nio-8080-exec-5] com.justdojava.sleuth.SampleController   : hi!
2019-05-03 12:59:43.216  INFO [Spring Cloud Sleuth,063ad9837aebfe4a,e5a424ae0f3007f2,true] 29536 --- [nio-8080-exec-6] com.justdojava.sleuth.SampleController   : hi2!
```

因为涉及到两次调用，因此产生了两个 Span , 第一个 Span 和第二个 Span 的 ID 不同，从日志打印也可以看出两个 Span 有着同样的 traceId，表面它们属于同一个 Trace。



**异步调用**

我们再来模拟以下异步线程调用时，Sleuth 是如何记录 Span 信息的。下面进行演示：

首先需要在启动类添加注解 `@EnableAsync`，开启应用异步调用的功能。

```java
@EnableAsync
public class SleuthApplication {
}
```

创建一个 SleuthService 类，代码如下：

```java
public class SleuthService {
    private static final Log log = LogFactory.getLog(SleuthController.class);
    @Autowired
    private Tracer tracer;
    private Random random = new Random();
    @Async
    public void background() throws InterruptedException {
        log.info("background");
        int millis = this.random.nextInt(1000);
        Thread.sleep(millis);
        this.tracer.currentSpan().tag("background-sleep-millis", String.valueOf(millis));
    }
}
```

- `@Async`，添加此注解的方法会自动异步执行。接下来在 SleuthController 中添加调用此方法的入口。

```java
@RequestMapping("/async")
public String async() throws InterruptedException {
    log.info("async");
    this.background.background();
    return "async";
}
```

添加完之后，重新启动项目，访问地址 `http://localhost:8080/async`，查看控制台日志的打印信息。

```
2019-05-03 13:18:42.279  INFO [Spring Cloud Sleuth,36d6f60de86c3e6f,36d6f60de86c3e6f,true] 2064 --- [nio-8080-exec-1] com.justdojava.sleuth.SleuthController   : async
2019-05-03 13:18:42.293  INFO [Spring Cloud Sleuth,36d6f60de86c3e6f,31c32c5f44694e80,true] 2064 --- [         task-1] com.justdojava.sleuth.SleuthController   : background
```

从日志的打印情况来看和上面请求调用比较类型，同属于一个 TraceId，各自有各自的 SpanId。通过此示例可以表明 Sleuth 支持异步调用的信息收集。



**定时任务**

接下来我们测试 Sleuth 在定时任务 `@Scheduled` 中的信息收集情况。

首先在启动类上添加 `@EnableScheduling` 注解，开启应用的定时任务功能。

```java
@EnableScheduling
public class SleuthApplication {
}
```

在 SleuthService 类中添加定时任务，定时任务中去调用 background () 方法。

```java
@Scheduled(fixedDelay = 36000)
public void scheduledWork() throws InterruptedException {
    log.info("Start some work from the scheduled task");
    this.background();
    log.info("End work from scheduled task");
}
```

我们设置每 36 秒调用一次，添加完成后重新启动项目，查看控制台的日志输出信息。

```
2019-05-03 13:40:02.431  INFO [Spring Cloud Sleuth,48adb9bab82b50cb,48adb9bab82b50cb,true] 29084 --- [   scheduling-1] com.justdojava.sleuth.SleuthController   : Start some work from the scheduled task
2019-05-03 13:40:02.431  INFO [Spring Cloud Sleuth,48adb9bab82b50cb,48adb9bab82b50cb,true] 29084 --- [   scheduling-1] com.justdojava.sleuth.SleuthController   : background
2019-05-03 13:40:03.381  INFO [Spring Cloud Sleuth,48adb9bab82b50cb,48adb9bab82b50cb,true] 29084 --- [   scheduling-1] com.justdojava.sleuth.SleuthController   : End work from scheduled task
2019-05-03 13:40:39.382  INFO [Spring Cloud Sleuth,51d22d621a0f96d1,51d22d621a0f96d1,true] 29084 --- [   scheduling-1] com.justdojava.sleuth.SleuthController   : Start some work from the scheduled task
2019-05-03 13:40:39.383  INFO [Spring Cloud Sleuth,51d22d621a0f96d1,51d22d621a0f96d1,true] 29084 --- [   scheduling-1] com.justdojava.sleuth.SleuthController   : background
2019-05-03 13:40:39.653  INFO [Spring Cloud Sleuth,51d22d621a0f96d1,51d22d621a0f96d1,true] 29084 --- [   scheduling-1] com.justdojava.sleuth.SleuthController   : End work from scheduled task
...
```

通过日志分析可以看出，每次定时任务都会产生一个新的 Trace，并且调用过程中 SpanId 都是一致的。说明定时任务调用和页面调用是不同的，页面调用异步方法时会产生新的 Span ，而定时任务调用异步方法仍然使用的时同一个 Span。通过该实验也可以说明 Sleuth 完全支持定时任务信息收集。



**总结**

本节我们学习了 Spring Cloud Sleuth 在单体应用中如何收集数据信息，实践了 Sleuth 在 Web 调用、异步调用、定时任务中的实验方式。在真正的项目中，一般不会单独的使用 Spring Cloud Sleuth ，往往是结合 ZipKin 等图形界面软件一起使用。Zipkin 的介绍和使用在下一节会再给大家介绍。

### 11、**链路跟踪 Zipkin**

#### 1）**Zipkin 入门介绍**

Spring Cloud 中的各大组件我们已经介绍了很多，相信经过前面的学习大家对于 Spring Cloud 的组件生态也已经有了一个基本的认知，可以在心中绘制出一副 Spring Cloud 生态图了。不过我们的介绍仍未结束，今天要和大家再来聊一个组件，那就是 Zipkin。



**Zipkin 简介**

Zipkin 架构从整体上来说，可以分为 Zpikin Server 和 Zipkin Client 两部分，其中 Zipkin Server 提供了数据采集、分析以及展示等功能，Zipkin Client 则是一些机遇不同开发语言封装的客户端工具，这些工具用来实现追踪数据的生成与上报功能，反映到我们的微服务架构中，一个一个的微服务就相当于 Zipkin Client ，下面对这两个，我们分别来介绍。



**Zipkin Server**

Zipkin 是一个开放源代码的分布式跟踪系统，由 Twitter 公司开源，它致力于收集服务的定时数据，以解决微服务架构中的延迟问题，包括数据的收集、存储、查找和展现。

每个服务向 Zipkin 报告计时数据，Zipkin 会根据调用关系通过 Zipkin UI 生成依赖关系图，显示多少跟踪请求通过每个服务。该系统让开发者可通过一个 Web 前端轻松的收集和分析数据，例如用户每次请求服务的处理时间等，来方便的监测系统中存在的瓶颈。

Zipkin 提供了可插拔数据存储方式：In-Memory、MySql、Cassandra 以及 Elasticsearch ，一般在生产环境中我们推荐使用 Elasticsearch。

我们先来看一张 Zipkin 的工作流程图：

![图片描述](https://img1.sycdn.imooc.com/5d27f88d000124fd06610504.png)

这是一张来自 Zipkin 官网的工作流程图，从这个图中，我们可以看到 Zipkin 一共有如下四个工作模块：

- Collector

Collector 主要用来收集数据，一旦跟踪数据到达 Zipkin 的 Collector，它就会被 Collector 验证、存储和索引以支持后面的操作。

- Storage

Zipkin 最初是为了在 Cassandra 上存储数据而构建的，因为 Cassandra 是可扩展的，具有灵活的模式，并且在 Twitter 中被大量使用。但 Zipkin 中的存储组件也是可插拔的，除了 Cassandra，也支持 ElasticSearch 和 MySQL 等，当然这些数据也可以直接存储在内存中，而不进行持久化操作。 Storage 主要用来处理 Collector 接收到的跟踪信息，将这些跟踪信息进行持久化（如果需要的话）。

- RESTful API

一旦数据被存储和索引，我们需要一种方法来提取它，查询守护程序提供了一个简单的 JSON API，通过这些 API 可以将跟踪信息展示给客户端，此 API 的主要使用者是 Web UI。

- Web UI

Web UI 是一个很好的数据可视化界面，它提供了一种基于服务、时间和注释查看跟踪的方法，可以非常直观的查看和分析跟踪数据。另外需要注意：UI 中没有内置身份验证。



**Zipkin Client**

Zipkin Client 包含的客户端工具还是非常丰富的，除了官方支持的语言，还有大量社区支持的语言版本，例如 Java、C++、Python、C#、Go、JavaScript、PHP 以及 Elixir 等，其中光是 Java 支持的库就不止 Spring Cloud Sleuth （虽然我们后文的案例是基于此），也还不包括 htrace、Dropwizard Zipkin、cassandra-zipkin-tracing、Wingtips 等，其中，在 Spring Cloud Sleuth 中，可以基于 HTTP 来传输数据，也可以基于消息中间件来传输数据，对 Java 版本的要求是至少 Java7 以上。

> 编著 @
>
> 其中光是 Java 支持的库就不止 Spring Cloud Sleuth （虽然我们后文的案例是基于此），也还不包括 htrace、Dropwizard Zipkin、cassandra-zipkin-tracing、Wingtips 等
>
> 麻烦确定此句表述是否有问题。

大家在网上看到的关于 Zipkin 的教程，大部分都会教你先搭建一个 Zipkin Server ，这种方式也不能算错误，只是它是一种过时的写法。从 Spring Cloud Finchley 版本开始，这种方式就已经不被推荐了，而是需要我们单独的安装 Zipkin 软件来实现数据的收集。大家在创建一个 Spring Boot 项目时，如果采用了最新版本，你会发现在官方可选的依赖中就没有 Zipkin 的依赖，因此，我们在学习 Zipkin 的过程中，需要先来安装相关的环境。



**环境配置**

环境的安装配置我们依然选择和前面一样的配置，使用 Docker 来进行安装。

在后文的案例中，我们使用 Elasticsearch 来做数据存储，使用 RabbitMQ 来做数据传输，因此在安装 Zipkin 之前我们需要先确保 Elasticsearch 和 RabbitMQ 已经安装成功了。



**Elasticsearch 安装**

首先我们来看在 Docker 中安装 Elasticsearch ，主要装两个东西，一个是 Elasticsearch 本身，另一个是可视化工具 Elasticsearch-head ，分别来看：

**Elasticsearch 安装**

Elasticsearch 安装比较容易， Docker 中的安装命令如下 (这里我们安装的是本文写作时最新的 Elasticsearch 7.1.0 版)：

```docker
docker run -d --name elasticsearch  -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.1.0
```

执行结果如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f8a700012f5c22360108.png)

安装成功之后，我们在浏览器中输入 [http://localhost:9200](http://localhost:9200/) ，看到如下页面表示安装成功：

![图片描述](https://img1.sycdn.imooc.com/5d27f8b50001ffa409480614.png)

elasticsearch 本身安装成功之后，再来安装 elasticsearch-head：

**Elasticsearch-head 可视化工具安装**

elasticsearch-head 是一个 elasticsearch 的可视化工具，有三种方式来使用这个工具：

- 直接下载软件本身安装
- 通过 Docker 安装
- 通过安装 Chrome 插件来使用

本文采用第三种方案，直接在 Chrome 商店中搜索 elasticsearch-head ，结果如下图：

![图片描述](https://img1.sycdn.imooc.com/5d27f8bd0001d79224561728.png)

安装成功之后，打开浏览器插件，连接上我们的 elasticsearch 即可，如下：
![图片描述](https://img1.sycdn.imooc.com/5d27f8c60001e62019440406.png)

读者有兴趣的话也可以安装一个 Kibana ，一样可以通过可视化页面来查看 Elasticsearch 中的数据，因为这个安装方式比较简单，我这里就不再介绍了。



**RabbitMQ 安装**

RabbitMQ 我们在前文已经安装过并且使用过多次了，这里我就不再重复安装的步骤了，大家只需要执行如下命令启动已有的 RabbitMQ 容器即可（如果 RabbitMQ 容器已经启动，则本步骤可以忽略）：

```docker
docker start some-rabbit
```



**Zipkin 安装**

最后，我们再来使用 Docker 安装 Zipkin ，非常容易，一行命令即可：

```docker
docker run -d -p 9411:9411 --name zipkin -e ES_HOSTS=192.168.0.109 -e STORAGE_TYPE=elasticsearch -e ES_HTTP_LOGGING=BASIC -e RABBIT_URI=amqp://guest:guest@192.168.0.109:5672 openzipkin/zipkin
```

虽然只有一行命令，不过这一行命令有点长，我们来给大家解释一下：

- -d 表示让容器在后台运行
- -p 表示让宿主机的 9411 端口映射到容器的 9411 端口
- –name 表示给容器取一个名字
- ES_HOSTS 表示 elasticsearch 的地址
- STORAGE_TYPE 表示容器数据的存储容器
- RABBIT_URI 表示 RabbitMQ 的地址

这行命令执行成功之后，我们就成功安装 Zipkin 了，同时还将前面安装的 Elasticsearch 和 RabbitMQ 都整合进来了，此时我们在浏览器中输入 [http://localhost:9411](http://localhost:9411/) , 就可以看到如下页面：

![图片描述](https://img1.sycdn.imooc.com/5d27f8ce00016f0a32980918.png)

看到这个页面则表示 Zipkin 已经安装成功了。

**注意**

在连接容器地址时，不要直接写 127.0.0.1 或者 localhost ，这样会去容器本身查找相关的应用，这里应该写宿主机的地址，才能正确找到应用。

**小结**

经过上面的准备工作之后，相信大家对 Zipkin 已经有一个基本认知了，同时也已经准备好 Zipkin 所需的各种环境，下篇文章我们就来看看 Zipkin 在微服务中的具体使用。

#### 2）**Zipkin 实践**

上篇文章带领大家了解了 Zipkin 的基本概念，以及 Zipkin 中环境的搭建，现在是万事俱备只欠东风了，本文就来和大家聊一下这搭好的环境要如何使用。



**创建 provider**

要演示链路追踪，我需要提前准备好两个微服务，两个服务之间互相调用，然后我们来观察链路追踪情况。因此需要首先创建一个名为 zipkin 的 maven 父工程，然后在 zipkin 项目中创建一个名为 provider 的 module ，创建时分别添加 Web、Sleuth、RabbitMQ、Spring Cloud Stream 以及 Zipkin 依赖，如下：
![图片描述](https://img1.sycdn.imooc.com/5d27f8f90001522f16881176.png)

工程创建完成后，pom.xml 文件核心依赖如下：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-stream</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-stream-binder-rabbit</artifactId>
</dependency>
```

创建完成后，我们首先在 application.properties 中添加 stream、zipkin 以及 rabbitmq 相关的配置：

```properties
spring.application.name=provider
spring.sleuth.web.client.enabled=true
spring.sleuth.sampler.probability=1
spring.zipkin.base-url=http://localhost:9411
spring.zipkin.enabled=true
spring.zipkin.sender.type=rabbit
spring.rabbitmq.addresses=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
server.port=8080
```

这些配置有一些是大家面熟的，也有一些可能是第一次接触到的，主要是 sleuth 和 zipkin 的配置可能第一次接触，我这里就主要来介绍一下这两个相关的配置的含义吧：

- spring.sleuth.web.client.enabled 表示开启链路追踪；
- spring.sleuth.sampler.probability 表示追踪信息导出到 zipkin 的比例，这里默认是 0.1 ，即 10% 的追踪信息导出到 zipkin ，我们这里将之配置为 1 ；
- spring.zipkin.base-url 表示指定 zipkin server 的地址；
- spring.zipkin.base-url 表示开启 zipkin ；
- spring.zipkin.sender.type 表示设置追踪信息的发送类型。

配置完成后，我们再添加一个 HelloController ，提供一个测试接口，如下：

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name + " !";
    }
}
```

接下来我们就可以启动 provider 了。provider 启动成功之后，先放着，我们再来看 consumer 的创建。



**创建 consumer**

consumer 的创建和 provider 的步骤基本一致，需要添加的依赖以及 application.properties 中的配置都是一样的（除了项目启动端口不一致），因此这个步骤我就不再赘述，当 application.properties 配置完成后，我们在 consumer 中首先配置一个 RestTemplate 的 Bean ，如下：

```java
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

注意，这里的 RestTemplate 的实例我没有开启负载均衡功能，所以这里主要是给大家展示链路追踪的用法，没有引入服务注册中心，因此也没有引入负载均衡的注解。最后再添加一个 Controller 去消费 provider 中提供的接口，如下：

```java
@RestController
public class UseHelloController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/sayhello")
    public void hello() {
        String s = restTemplate.getForObject("http://localhost:8080/hello?name={1}", String.class, "javaboy");
        System.out.println(s);
    }
        
}
```

这段代码也很简单，配置完成之后，我们再来启动 consumer 工程。consumer 启动成功之后，我们先尝试在浏览器中发送请求调用 `/sayhello` 接口：`http://localhost:8081/sayhello`。



**查看链路追踪**

当 consumer 中的请求发送完成之后，接下来我们刷新 zipkin 的调用页面，发现已经有了一条调用记录，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f9210001ffeb32561008.png)

如果服务比较多，可以使用该页面提供的搜索功能进行搜索，就能快速定位到自己需要的服务。

点开这条调用记录，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f93000013d6632680770.png)

可以看到整个调用链以及请求分别在 `/sayhello` 和 `/hello` 接口上所花费的时间。点击某一个接口，还可以看到具体的数据：

![图片描述](https://img1.sycdn.imooc.com/5d27f93a0001045715801342.png)

这里可以看到每一个步骤的详细信息，包括请求方法、对应的 method 、相关的 Controller 以及客户端的地址等。由于这里是 `/sayhello` 接口，因此没有 parentId ，下一个请求开始就有 parentId 了。

也可以点击右上角的 Try Lens UI 按钮，换一个 UI 风格：

![图片描述](https://img1.sycdn.imooc.com/5d27f9430001770433602346.png)

然后我们打开 Elasticsearch-head ，可以看到数据已经存储到 Elasticsearch-head 上了，如下：
![图片描述](https://img1.sycdn.imooc.com/5d27f94c00010c3a33601516.png)

最后我们再打开 RabbitMQ 的管理面板，也可以看到有一个名为 zipkin 的队列，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27f9540001f87115761762.png)

**小结**

经过上面的步骤之后，一个分布式的服务链路追踪系统就算完成了，我们平时只需要通过 zipkin 的 WebUI 界面就能快速查看每一个请求的状况，包括在每一个微服务上花费的时间，就能快速定位出性能瓶颈。

### 12、微服务监控 admin

#### 1）Spring Boot Admin 介绍

在前面的文章中，我们介绍了 Spring Boot Actuator 的使用，并且结合 Prometheus 和 Grafana 进行了数据展示，其中Spring Boot Actuator 提供了对单个 Spring Boot 的监控，监控信息包含：应用状态、内存、线程、堆栈等等，比较全面的监控了 Spring Boot 应用的整个生命周期。

不过它也有一些不足之处：

- 所有的监控都需要调用固定的接口来查看，如果全面查看应用状态需要调用很多接口，并且接口返回的 Json 信息不方便运营人员理解；
- 如果 Spring Boot 应用集群非常大，每个应用都需要调用不同的接口来查看监控信息，操作非常繁琐低效。

我们之前通过 Prometheus + Grafana 将信息聚合到一起集中显示，今天则要和大家来说说另一个展示工具 Spring Boot Admin 。



**Spring Boot Admin 介绍**

Spring Boot Admin 是一个管理和监控 Spring Boot 应用程序的开源软件:

- [项目 GitHub 地址](https://github.com/codecentric/spring-boot-admin)

在 Spring Boot Admin 体系中，每个应用都是一个客户端，通过 HTTP 或者使用 Eureka 注册到 Admin Server 中进行展示，Spring Boot Admin UI 部分使用 VueJs 将数据展示在前端，是一套目前非常流行的技术架构！Spring Boot Admin 主要提供了如下数据展示功能：

- 展示客户端的健康状况
- 展示应用的一些详细信息，例如 JVM 运行状况、内存使用情况、数据库使用情况以及缓存情况等
- 展示项目构建信息
- 查看项目运行日志
- 查看 Spring Boot 配置信息
- 查看 JVM 和环境信息
- 支持 Spring Cloud 的 postable /env- 和 /refresh-endpoint
- 容易的日志级别管理
- 可以方便的与 JMX-beans 进行交互
- 查看线程堆栈
- 查看 HTTP 追踪信息
- 查看 auditevents、http-endpoints、定时任务、数据库迁移
- 下载 headump
- 邮件报警
- 等等…



**快速开始**

接下来我们通过一个简单的案例来看看 Spring Boot Admin 的基本使用。

首先我们创建一个名为 monitor 的空的 Maven 父工程，这一步和前面的微服务基本一致，比较简单，我就不再赘述。



**创建 Admin Server**

在 monitor 中创建一个名为 adminserver 的 Spring Boot 工程，创建时需要添加 Web 和 Admin Server 依赖，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27fa2300013ce618641160.png)

创建成功之后，项目的依赖如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-starter-server</artifactId>
    </dependency>
</dependencies>
```

项目创建成功之后，在启动类上添加 `@EnableAdminServer` 注解，表示开启 AdminServer：

```java
@SpringBootApplication
@EnableAdminServer
public class AdminserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminserverApplication.class, args);
    }

}
```

配置完成之后，就可以启动项目了。项目启动成功之后，浏览器中输入 [http://localhost:8080](http://localhost:8080/) ，我们就可以看到项目的启动页面，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27fa310001d03629840598.png)

此时因为并没有客户端注册到 Admin Server ，所以实例数为 0 。



**创建 Client**

接下来，我们创建一个 adminclient ，注册到 adminserver 上，adminclient 就是我们微服务开发中一个一个的服务，这里我们暂时先不引入微服务那一套，就先来一个单机版的服务。因此，创建 adminclient ，我们添加两个依赖，一个 Web，另一个 Admin Client ，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27fa3a0001042618701156.png)

项目创建成功后的 pom.xml 文件如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-starter-client</artifactId>
    </dependency>
</dependencies>
```

然后我们在 application.properties 中添加如下一些配置信息：

```properties
server.port=8081
spring.boot.admin.client.url=http://localhost:8080
```

这里就配置两项：

- 第一个端口号，这个不需多说；
- 第二个配置表示配置 admin server 的地址，当 admin client 启动后，会自动注册到 admin server 上去。

配置完成后，这个时候就可以启动 adminclient 了。启动成功之后，我们再回到 adminserver 的管理页面，不用刷新， Admin Server 会自动监测到服务上线、下线等事件，如下：
![图片描述](https://img1.sycdn.imooc.com/5d27fa4800018b9829300758.png)

可以看到注册上来的客户端信息已经显示出来了。

点进到服务里边之后，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27fa4f0001189333281318.png)

我们可以看到，只展示出来了 Info 和 Helath ，这是因为默认有一些端点没有暴露，此时我们需要回到 adminclient 中，再添加一行暴露所有 endpoint 的配置，如下：

```
management.endpoints.web.exposure.include=*
```

配置完成之后，重启项目，再来看这个页面，此时效果如下：

![图片描述](https://img1.sycdn.imooc.com/5d27fa570001dd5833602702.png)

点击左侧的菜单，可以查看详细信息。

点击右上角的 Wallboard 可以看到目前注册上来的所有服务，当然当前只有一个：

![图片描述](https://img1.sycdn.imooc.com/5d27fa5f0001408927681660.png)

点击 Journal 可以看到项目的一些事件信息，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27fa7000017aad28000874.png)

**小结**

本文主要和大家聊了一下 Spring Boot Admin 的基本功能和基本用法，对服务监控的基本支持。可以说，这个东西还是非常方便的，只是本文我们还没有引入微服务，注册的配置都要挨个配置，略微有一些麻烦，下一篇文章和大家再来详细说说 Spring Boot Admin 结合微服务的用法，以及相关的报警机制。

#### 2）**Spring Boot Admin 实践**

上篇文章和大家聊了 Spring Boot Admin 的基本功能和基本使用，使大家了解到使用 Spring Boot Admin 我们可以方便的通过一个比较炫的 UI 页面将应用的监控信息聚合展示出来，这样就不需要运维人员去挨个查看，使用在数据分析之中也非常方便。

Spring Boot Admin 虽然好用，但由于我们上篇文章中没有引入微服务，这就导致 Admin Client 上需通过硬编码的方式来指定 Admin Server 的位置，一旦 Admin Server 发生变化，所有的 Admin Client 都需要修改重新部署，这样成本就太高了。通过引入 Eureka 实现服务化，我们就可以有效解决这个问题。



**服务化**

首先我们来创建一个名为 monitor 的 Maven 父工程，然后创建一个名为 eureka 的 module 作为我们的注册中心。关于 eureka 的创建与启动，我这里就不再多介绍了，通过前面文章的学习，相信大家对于这个应该已经很熟悉了。eureka 配置完成之后，将 eureka 启动。

然后我们再来创建一个 Spring Boot Admin 项目，这次添加的依赖除了 Web、Admin Server 之外，还需要添加 Eureka Discovery ，如下：

![图片描述](https://img1.sycdn.imooc.com/5d27fa9d0001558d18601156.png)

创建成功之后，核心依赖如下：

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
		<groupId>de.codecentric</groupId>
		<artifactId>spring-boot-admin-starter-server</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
	</dependency>
</dependencies>
```

创建成功之后，我们在 application.properties 中添加如下配置，将 adminserver 注册到 eureka 上：

```properties
spring.application.name=adminserver
eureka.client.service-url.defaultZone=http://localhost:1111/eureka
management.endpoints.web.exposure.include=*
```

这里我们添加了三行配置：

- 第一行配置表示设置服务名称；
- 第二行配置表示配置服务注册地址；
- 第三行配置表示开启所有被隐藏的端点。

可能有人会觉得奇怪，这个是 Admin Server 项目，为什么还需要开启被隐藏的端点？原因很简单，因为 Admin Server 本身的运行状况我一样也要进行监控，所以这里要开启 Admin Server 的端点数据。

配置完成后，再在启动类上添加 `@EnableAdminServer` 注解，如下：

```java
@SpringBootApplication
@EnableAdminServer
public class AdminserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminserverApplication.class, args);
	}

}
```

然后就可以启动 adminserver 项目了。启动成功之后，我们再来创建一个 adminclient 项目，和上篇文章相比，这里的 adminclient 多出来一个依赖，就是 Eureka Discovery，如下：
![图片描述](https://img1.sycdn.imooc.com/5d27faa8000194ea18701162.png)

创建成功之后，在 adminclient 的 application.properties 中添加如下配置：

```properties
spring.application.name=adminclient
server.port=8081
eureka.client.service-url.defaultZone=http://localhost:1111/eureka/
management.endpoints.web.exposure.include=*
```

这里的配置含义上文都已经说过，不再多说。

这样我们的 adminclient 就算是配置完成了。很神奇吧？ adminclient 中不需要任何和 adminserver 相关的配置，开发者只需要将 adminclient 注册到 eureka 上即可，剩下的事情由系统自动安排！

接下来启动 adminclient ，启动成功之后，我们访问 `http://localhost:8080` 地址，就可以看到如下页面：

![图片描述](https://img1.sycdn.imooc.com/5d27fab10001b72728520896.png)
可以看到所有的服务都展示出来了，包括 adminserver ，在 Wallboard 中一样可以看到全部数据：

![图片描述](https://img1.sycdn.imooc.com/5d27fabf0001e6f730341714.png)

其他的日志信息、详细运行数据也是一样的：

![图片描述](https://img1.sycdn.imooc.com/5d27fac80001d3f333602784.png)

![图片描述](https://img1.sycdn.imooc.com/5d27fad30001b2ec28401096.png)



**异常报警**

服务上线之后，运维工程师不可能 24 小时盯着服务，查看运行数据，如果服务运行发生异常状况，最好有自动报警机制。类似于我们使用 Prometheus+Grafana 时采用的自动报警机制一样，Spring Boot Admin 中也提供了类似的功能。

首先我们要在 adminserver 中添加邮件发送依赖支持：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

然后在 adminserver 的 application.properties 文件中配置邮件发送基本信息：

```properties
spring.mail.host=smtp.qq.com
spring.mail.port=465
spring.mail.username=xxx@qq.com
spring.mail.password=授权码
spring.mail.default-encoding=UTF-8
spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
spring.mail.properties.mail.debug=true
spring.boot.admin.notify.mail.from=xxx@qq.com
spring.boot.admin.notify.mail.to=xxx@qq.com
spring.boot.admin.notify.mail.cc=xxx@qq.com
spring.boot.admin.notify.mail.ignore-changes=
```

关于邮件发送配置读者可以参考 10-2 小节，这里多出来的配置是最后四行配置，分别表示：

- 报警邮件的发送者
- 报警邮件收件人
- 报警邮件抄送地址
- 忽略掉的事件

默认情况下，当被监控应用的状态变为 UNKNOWN 或者 UP 时不会发送报警邮件，而这里的配置表示被监控应用的任何变化都会发送报警邮件（即不忽略任何变化）。

配置完成后，重新启动 AdminServer ，然后启动被监控应用，此时就会收到应用上线的邮件报警：
![图片描述](https://img1.sycdn.imooc.com/5d27fae00001c91210980872.png)

此时关闭被监控应用，就会收到应用下线的邮件报警：

![图片描述](https://img1.sycdn.imooc.com/5d27fae80001d86d12381090.png)

**小结**

本文主要和大家分享了 Spring Boot Admin 服务化，这个过程其实很简单，Admin Server 和其他服务分别注册到服务注册中心就可以了，Admin Server 会自动找到各个微服务然后将监控数据展示出来。最后还和大家聊了邮件监控，当服务发生异常情况时，Admin Server 能够自动发送报警邮件，方便运维工程师及时获取到服务异常信息，进而及时处理。

### 13、**SpringCloud和Alibaba**

#### 1）**Spring Cloud Alibaba 现状**

Spring Cloud 学到现在，大部分组件都涉及到了，大家对 Spring Cloud 的原理、各个组件以及组件的作用也都有了一定的认知。

关注 Spring Cloud 时间较久的小伙伴可能也了解到去年 Spring Cloud 社区发生的停更风波，Netflix 公司决定停止 Eureka2 的开源工作，随后有多个 Netflix 体系的组件停更，这动摇了不少使用 Spring Cloud 的工程师的决心，记得当时还有人在微信上问我这个 Spring Cloud 到底还有没有必要去学习？我说当然有必要！老实说，停更对国内公司影响并不大，因为大部分都是使用 Eureka1.0 来做服务注册的，退一万步讲，即使 Eureka 真的用不了了，还有很多其他可以替代的工具，例如 Zookeeper、Consul 等，都是很好的替代方案；再到 2018 年 11 月，Netflix 团队突然宣布 Hystrix 停止开发新版本，但仍然会维护后期可能出现的 Bug；其实除过 Hystrix 外， Spring Cloud 体系内同样存在几款替代框架，比如 Resilience4J、Sentinel 等，所以，Netflix 公司的停更影响其实非常有限，因为基本上每一个停更的组件都有对应的替代品，而在这众多的替代品中，有一个非常抢眼的替代品，那就是 Spring Cloud Alibaba。



**Spring Cloud Alibaba 简介**

那么什么是 Spring Cloud Alibab 呢？本文就来和大家聊一聊这个问题。

Spring Cloud Alibaba 是阿里巴巴公司提供的一套微服务开发的一站式解决方案，大家都知道，淘宝和天猫在最近几年的双十一活动中积累下来了大量的高并发经验与分布式数据处理经验，基于此，阿里巴巴为 Java 领域贡献了很多优质的开源项目，而 Spring Cloud Alibaba 就是其中之一。该项目包含开发分布式应用微服务的必需组件，方便开发者通过 Spring Cloud 编程模型轻松使用这些组件来开发分布式应用服务。

Spring Cloud Alibaba 可以非常方便的和我们现有的微服务项目整合，只需要通过少量的注解，我们就可以将我们现有的微服务项目接入到阿里巴巴的微服务解决方案体系中，进而使用阿里巴巴的中间件来增强我们的项目。

当前，Spring Cloud Alibaba 主要提供了如下功能：

- 服务限流降级：默认支持 Servlet、Feign、RestTemplate、Dubbo 和 RocketMQ 限流降级功能的接入，可以在运行时通过控制台实时修改限流降级规则，还支持查看限流降级 Metrics 监控。
- 服务注册与发现：适配 Spring Cloud 服务注册与发现标准，默认集成了 Ribbon 的支持。
- 分布式配置管理：支持分布式系统中的外部化配置，配置更改时自动刷新。
- 消息驱动能力：基于 Spring Cloud Stream 为微服务应用构建消息驱动能力。
- 分布式事务：使用 @GlobalTransactional 注解， 高效并且对业务零侵入地解决分布式事务问题。。
- 阿里云对象存储：阿里云提供的海量、安全、低成本、高可靠的云存储服务。支持在任何应用、任何时间、任何地点存储和访问任意类型的数据。
- 分布式任务调度：提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。同时提供分布式的任务执行模型，如网格任务。网格任务支持海量子任务均匀分配到所有 Worker（schedulerx-client）上执行。
- 阿里云短信服务：覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

从官方给出的这些功能列表中，我们可以看到，对于 Spring Cloud 原本就有的功能， Spring Cloud Alibaba 基本上都是支持的，除此之外，还提供了大量的组件，使我们的项目可以非常方便的整合到阿里云服务中。对于使用了阿里云服务的开发者来说，这无疑是具有吸引力的，如果没有使用阿里云服务，则忽略这些特性即可。

另一方面，Spring Cloud Alibaba 提供了如下组件：

- Sentinel：把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。
- Nacos：一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。
- RocketMQ：一款开源的分布式消息系统，基于高可用分布式集群技术，提供低延时的、高可靠的消息发布与订阅服务。
- Dubbo：Apache Dubbo 是一款高性能 Java RPC 框架，曾经因为停更，错过了几年的黄金期，被 Spring Cloud 迎头赶上，不过从 2017 年 9 月开始已经恢复更新了。
- Seata：阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案。
- Alibaba Cloud ACM：一款在分布式架构环境中对应用配置进行集中管理和推送的应用配置中心产品。
- Alibaba Cloud OSS: 阿里云对象存储服务（Object Storage Service，简称 OSS），是阿里云提供的海量、安全、低成本、高可靠的云存储服务。您可以在任何应用、任何时间、任何地点存储和访问任意类型的数据。
- Alibaba Cloud SchedulerX: 阿里中间件团队开发的一款分布式任务调度产品，提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。
- Alibaba Cloud SMS: 覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

这些组件基本上覆盖了我们开发中的大部分场景，而且如果想在 Spring Cloud 中集成 Spring Cloud Alibaba 这些组件，操作还是非常方便的，这个我们在后面会为大家介绍 Sentinel 和 Nacos 的使用。



**优势**

对于国内开发者而言，使用 Spring Cloud Alibaba 还是有很多优势的，随便举出几个：

1. 不同于官方的 Spring Cloud 组件，Spring Cloud Alibaba 的文档都是中文，虽然我们常说作为一个专业的开发者，英文肯定不能太差，不过，既然 Spring Cloud Alibaba 提供了完整的中文文档，对于一些英文差的读者还是非常友好的。
2. Spring Cloud Alibaba 并没有另起炉灶，而是通过简单的修改就可以非常方便的集成到现有的 Spring Cloud 项目中，这一套平滑的过渡方案对于开发者来说也可以说是非常友好。
3. 基于阿里巴巴本身在高并发、高性能开发方面的经验，我们也有理由相信这些组件质量足够可靠。



**前景**

打开 GitHub 上 Spring Cloud Alibaba 仓库 https://github.com/spring-cloud-incubator/spring-cloud-alibaba ，查看最近的提交记录，我们发现 Spring Cloud Alibaba 的更新还是相当频繁的，这是一个非常活跃的项目，因此可以放心使用。阿里因为之前 Dubbo 停更的问题，让有的人觉得阿里的开源组件不靠谱，不过 Dubbo 现在已经恢复更新，再看看阿里巴巴最近今年在开源领域的贡献，我觉得我们可以放心使用 Spring Cloud Alibaba。

其实单纯从微服务本身来说，Spring Cloud Alibaba 可以说是值得信任并且使用的，至于一些和阿里云服务绑定的组件，个人觉得在使用时候，还是要认真考虑，这些组件用了后，以后要想切换云服务估计就不太容易了！



**总结**

本文主要是对 Spring Cloud Alibaba 做了一个简单的介绍，后面的文章将来向大家介绍 Spring Cloud Alibaba 中具体组件的用法。

#### 2）**Nacos 基础用法**

上篇文章我们和大家介绍了 Spring Cloud Alibaba 的基本概念以及发展前景，使大家对 Spring Cloud Alibaba 有一个基本的认知，本文我们就来看看 Spring Cloud Alibaba 中 Nacos 的具体用法。



**Nacos 简介**

先来看看 Nacos 到底是什么！



**基本介绍**

Nacos 提供了动态服务发现、服务配置和服务管理功能，乍一看你可能会觉得这不就是 Eureka 或者 Consul 的翻版嘛！这句话也没错，不过 Nacos 的功能可不止这些！用官方的话来说，Nacos 是构建以“服务”为中心的现代应用架构 (例如微服务范式、云原生范式) 的服务基础设施。



**关键特性**

那么 Nacos 都包含那些基本特性呢？

1. 服务发现和服务健康监测：Nacos 支持基于 DNS 和 RPC 的服务发现，并且提供了基于传输层和应用层的服务健康检查，自动剔除不健康的主机或者实例，Nacos 还提供了统一的健康检查仪表盘，使运维工程师可以快速发现问题。
2. 动态配置服务，这个功能有点类似于我们前面学过的 Spring Cloud Config 的作用，不过这里 Nacos 也提供了一样的功能。
3. 动态 DNS 服务，动态 DNS 服务支持权重路由，这样开发者可以更容易地实现中间层负载均衡、更灵活的路由策略、流量控制以及数据中心内网的简单DNS解析服务。动态 DNS 服务还能让开发者通过 DNS 协议实现服务发现，这样可以避免耦合到厂商私有服务发现 API。
4. 服务及其元数据管理，Nacos 能让开发者从微服务平台建设的视角管理数据中心的所有服务及元数据，包括管理服务的描述、生命周期、服务的静态依赖分析、服务的健康状态、服务的流量管理、路由及安全策略、服务的 SLA 以及最首要的 metrics 统计数据。



**生态**

我们来看一张 Nacos 官方给出的 Nacos 生态图：
![图片描述](https://img1.sycdn.imooc.com/5d39244c00019a5a13960902.png)根据上图，我们可以看出，Nacos 可以无缝集成到主流的开源生态体系中，例如：

- Spring Cloud
- Apache Dubbo and Dubbo Mesh TODO
- Kubernetes and CNCF TODO

使用 Nacos 简化服务发现、配置管理、服务治理及管理的解决方案，让微服务的发现、管理、共享、组合更加容易。



**基本用法**

说了这么多官方的介绍，接下来我们就来简单实践下。



**Nacos 安装**

安装方式主要给大家介绍两种，一种就是直接安装，另一种则是通过 Docker 来安装。

**直接安装**

首先我们来看看 Nacos 的安装步骤，我们可以下载源码包编译安装也可以直接下载官方编译好的压缩包，这里我们采用第二种方式，下载地址：

- [Nacos 下载地址](https://github.com/alibaba/nacos/releases/download/1.0.0/nacos-server-1.0.0.tar.gz)

下载完成后，解压进入 bin 目录下，如果是 Windows 系统，直接双击 startup.cmd 启动项目，如果是 Linux/Unix/Mac 系统，执行如下命令启动项目：

```
sh startup.sh -m standalone
```

启动命令中的 standalone 表示项目以单机模式启动，项目启动 Logo 如下：
![图片描述](https://img1.sycdn.imooc.com/5d39247900018d8917800520.png)项目启动成功之后，浏览器输入 http://localhost:8848/nacos ，我们可以看到如下管理台页面：
![图片描述](https://img1.sycdn.imooc.com/5d3924a30001ed9533601558.png)默认的登录用户名和密码都是 nacos ，登录成功后，就可以看到后台管理页面：
![图片描述](https://img1.sycdn.imooc.com/5d3924d7000111f833601104.png)可以看到左侧菜单栏的两个选项**配置管理**和**服务管理**，这就是 Nacos 两大核心功能，我们一会来和大家仔细介绍。

**Docker 安装**

使用 Docker 安装，比较容易，首先我们先下载相关脚本：

- [nacos docker 下载脚本](https://github.com/nacos-group/nacos-docker/archive/master.zip)

下载完成后，解压，进入解压目录中，可以以单机的形式启动 nacos ，也可以以集群方式启动 nacos ，单机版启动命令如下：

```
docker-compose -f example/standalone-derby.yaml up
```

以集群形式启动 nacos 命令如下：

```
docker-compose -f example/cluster-hostname.yaml up 
```

我们通过观察下载的 nacos-docker 中的 example 目录下的 standalone-derby.yaml 和 cluster-hostname.yaml 脚本，发现两者都集成了 prometheus 和 grafana 进来。因此无论是集群版启动，还是单机版启动，启动成功之后，我们也都可以直接访问 Prometheus 和 Grafana ，关于 Prometheus 和 Grafana 的用法，读者可以参考本专栏前面的文章。

运行完 Docker 命令后，会有一个下载过程，稍等片刻，Docker 版的 Nacos 就启动成功了。



**配置中心**

将 Nacos 作为配置中心，作用类似于我们之前讲过的 Spring Cloud Config ，但是很明显这里要比 Spring Cloud Config 方便一些，因为配置中心+注册中心二合一，一个服务做两件事。而且都是可视化操作，我们就先来看一下配置中心要怎么使用。

**Nacos 服务搭建**

首先我们登录到 Nacos 后台管理页面，在 `配置管理->配置列表` 选项中，点击右边的添加按钮，先来配置一个基本的数据项，如下：
![图片描述](https://img1.sycdn.imooc.com/5d3925080001a8d833601584.png)这里的配置我们主要配置了三个动心，分别是 Data ID、Group 以及配置内容。

Data ID 的完成格式是：

```
${prefix}-${spring.profile.active}.${file-extension}
```

- `${prefix}` 默认为 [spring.application.name](http://spring.application.name/) 的值，当然开发者也可以直接在 Spring Boot 项目中通过 spring.cloud.nacos.config.prefix 属性来指定。
- `${spring.profile.active}` 表示当前项目所处的环境，即对应 Spring Boot 中的 spring.profile.active 属性，这是可选的，如果这个选项省略了，对应的 `-` 也将不复存在。
- `${file-extension}` 表示配置的数据格式。

经过这样的配置之后，每个服务连接上来之后，都能找到自己的配置了。

配置完成后，点击右下角的 发布 按钮，完成发布：
![图片描述](https://img1.sycdn.imooc.com/5d39255c0001607b33600902.png)好了，这里就算先告一段落。

**Spring Boot 服务创建**

接下来，我们再来创建一个 Spring Boot 项目，创建时引入 Web 依赖即可，创建成功之后再手动加入 Nacos 依赖，由于 Spring Cloud Alibaba 目前尚未纳入到 Spring Cloud 的主版本库中，因此我们需要手动配置一下 Nacos 版本，最终的 pom.xml 文件如下：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-alibaba-nacos-config</artifactId>
        <version>0.9.0.RELEASE</version>
    </dependency>
</dependencies>
```

创建成功之后，由于我们要加载远程配置，和前面的 Spring Cloud Config 一样，我们需要在 resources 目录下创建一个名为 bootstrap.properties 的文件，在该文件中配置远程配置中心的地址以及当前服务的名称：

```properties
spring.application.name=nacos
spring.cloud.nacos.config.server-addr=127.0.0.1:8848
spring.cloud.nacos.config.file-extension=properties
```

这样就可以确保在 Spring Boot 项目启动时自动去 Nacos 上加载相关的配置文件，我们再创建一个新的 Controller ，来展示加载到的数据，如下：

```java
@RestController
@RefreshScope
public class HelloController {
    @Value(value = "${name}")
    String name;
    @GetMapping("/hello")
    public String hello() {
        return "hello " + name;
    }
}
```

这里我们使用到的都是 Spring 的原生注解，最大限度和 Nacos 解耦。其中，为了实现动态刷新配置文件，我们添加了 @RefreshScope 注解。

接下来我们启动 Nacos 项目，启动成功之后，我们访问 `/hello` 接口，结果如下：
![图片描述](https://img1.sycdn.imooc.com/5d3925a0000166c107080166.png)此时如果我们通过 Nacos 后台管理页面动态修改配置数据，不用重启 Spring Boot 项目，直接刷新页面，我们就可以看到数据已经更新。

大家有没有觉得很方便呢？还是比 Spring Cloud Config 要方便那么一丢丢！



**注册中心**

接下来我们再来看 Nacos 第二个使用场景，就是作为注册中心。扮演的角色相当于 Eureka。先来看 Nacos 官网的一张架构图：
![图片描述](https://img1.sycdn.imooc.com/5d39260f0001f75410520578.png)和我们之前使用 Eureka 或者 Consul 的架构基本一致，首先我们搭建 Nacos Server 作为服务注册中心，然后 provider 注册到服务注册中心，consumer 再从服务注册中心获取到 provider 的信息，然后 consumer 就可以通过 RestTemplate 等工具调用 provider 了，就是这样一个简单的架构，我们来看下如何实现。

**服务提供者**

先来看服务提供者。

Nacos 本身不用变，还是上面的 Nacos ，我们首先在 Spring Boot 项目中引入服务发现依赖（这里就不创建新的 Spring Boot 项目了，继续在上文的基础上完成）：

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    <version>0.9.0.RELEASE</version>
</dependency>
```

然后在 Spring Boot 的 application.properties 中添加一行配置，就可以将 Spring Boot 注册到 Eureka 上，如下：

```properties
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```

因为我们一会要将这个项目以集群的方式启动，在服务调用时，为了辨别是哪一个实例提供的服务，我将 HelloController 稍作修改：

```java
@RestController
@RefreshScope
public class HelloController {
    @Value(value = "${name}")
    String name;
    @Value("${server.port}")
    Integer port;

    @GetMapping("/hello")
    public String hello() {
        return "hello " + name + ">>>" + port;
    }
}
```

这里多注入了一个字段 port ，通过 port 就可以区分到底是哪一个实例提供的服务了。

配置完成后，我们将 Spring Boot 项目打包，启动两个实例，方便我们后期测试：

首先点击右边的 `Maven Project -> Lifecycle -> package` 进行打包：

![图片描述](https://img1.sycdn.imooc.com/5d39266e000152a606840660.png)打包成功后，进入到打包目录中，执行如下命令，分别启动两个 Spring Boot 项目实例：

```
java -jar nacos-0.0.1-SNAPSHOT.jar --server.port=8080
java -jar nacos-0.0.1-SNAPSHOT.jar --server.port=8081
```

启动成功之后，我们再去观察 Nacos 管理页面，可以看到服务已经成功注册上来了：
![图片描述](https://img1.sycdn.imooc.com/5d39273800017c0f33600860.png)点击详情，可以查看详细信息：
![图片描述](https://img1.sycdn.imooc.com/5d39279e000114da33601554.png)如此之后，我们的服务提供者就算是配置成功了。

**服务消费者**

接下来，我们需要配置服务消费者。

此时，我们创建一个新的 Spring Boot 工程，创建时引入 Web 依赖，创建成功后，引入 Nacos 服务发现依赖，最终的 pom.xml 文件如下图：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        <version>0.9.0.RELEASE</version>
    </dependency>
</dependencies>
```

然后在 application.properties 文件中配置一下 Nacos 地址，如下：

```properties
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
server.port=8082
```

配置完成后，我们就可以像以前一样，使用 RestTemplate 去调用另一个微服务提供的服务了。

我们首先在配置类中提供一个 RestTemplate 实例，并且添加负载均衡功能：

```java
@SpringBootApplication
public class NacosClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

然后在 Controller 中调用相关的服务，如下：

```java
@RestController
public class HelloController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForObject("http://nacos/hello", String.class);
    }
}
```

在这里我们注入 RestTemplate ，然后通过调用 RestTemplate 中的 getForObject 方法去调用另外一个服务。
![图片描述](https://img1.sycdn.imooc.com/5d3927ee00012d7c06800176.png)刷新一下，就换一个实例提供服务，即 8080 和 8081 来回切换显示。但是我们的所有用法都和前面学过的一样，并没有变化，这就是 Spring Cloud 的魅力之一，对调用 API 做了统一规范，无论是 Netflix 还是 Spring Cloud Alibaba ，都只是其中一个实现而已。



**总结**

本文主要向大家介绍了 Spring Cloud Alibaba 中 Nacos 组件的基本用法，通过本文，希望大家不仅掌握 Nacos 的基本用法，更重要的是可以加深对前面学习知识点的理解，前面我们和大家聊的负载均衡注解 @LoadBalanced 以及 RestTemplate 工具，在 Nacos 中都可以无缝集成进来使用。

#### 3）**Sentinel 基本用法**

前面和大家聊了 Spring Cloud Alibaba 中的 Nacos 组件，主要带着大家实现了用 Nacos 做配置中心和注册中心，本文我们来继续学习 Spring Cloud Alibaba 中的另外一个组件 Sentinel 。



**Sentinel 简介**

根据官方文档的介绍，Sentinel 被称作**分布式系统的流量防卫兵**，看到这个名字，我相信很多小伙伴都会想到 Hystrix ，可是前面的文章我们也已经说过，Hystrix 早已是明日黄花了，Netflix 都说了这个东西不再维护，因此我们在前面的文章中向大家介绍了 Spring Cloud 官方推荐的替代品 Resilience4j ，可是除了这个替代品 Resilience4j 之外， Sentinel 也是一个可以考虑的方案。

那么到底什么是 Sentinel 呢？它又有哪些特性呢？我们先来了解下。

Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。根据官方文档的介绍，Sentinel 主要有如下特征：

- 丰富的应用场景：Sentinel 承接了阿里巴巴近 10 年的双十一大促流量的核心场景，例如秒杀（即突发流量控制在系统容量可以承受的范围）、消息削峰填谷、集群流量控制、实时熔断下游不可用应用等。
- 完备的实时监控：Sentinel 同时提供实时的监控功能。开发者可以在控制台中看到接入应用的单台机器秒级数据，甚至 500 台以下规模的集群的汇总运行情况。
- 广泛的开源生态：Sentinel 提供开箱即用的与其它开源框架/库的整合模块，例如与 Spring Cloud、Dubbo、gRPC 的整合。开发者只需要引入相应的依赖并进行简单的配置即可快速地接入 Sentinel。
- 完善的 SPI 扩展点：Sentinel 提供简单易用、完善的 SPI 扩展接口。开发者可以通过实现扩展接口来快速地定制逻辑。例如定制规则管理、适配动态数据源等。

下面这张图完美诠释了 Sentinel 的核心功能：
![图片描述](https://img1.sycdn.imooc.com/5d39296f00014f9b14700686.png)
可以看到，曾经 Hystrix 支持的功能，这里都有！并且支持的更多！这也是去年以来，有读者在微信上老问我 Netflix 要跑路了 ，Spring Cloud 还值不值得学？我说没问题，学你的，多少公司想给 Spring Cloud 做实现呢！不用担心，学，没错！

当然大家知道，现在不管玩什么，都讲究一个**生态**，没有生态，也就意味着其他的框架都不和你玩，那你这个框架的价值就会大打折扣！那么 Sentinel 的生态又是怎么样的呢？我们来看一张来自 Sentinel 官方文档的生态图：
![图片描述](https://img1.sycdn.imooc.com/5d39405400015d8e17781074.png)从这张生态图中可以看到，Sentinel 对目前主流的服务都有很好的支持，都能方便的整合到其中，例如 Spring Cloud、Redis、Nacos、Apollo、RocketMQ 等。

从整体上来说，Sentinel 可以分为两个部分:

- 核心库（Java 客户端）不依赖任何框架/库，能够运行于所有 Java 运行时环境，同时对 Dubbo / Spring Cloud 等框架也有较好的支持。
- 控制台（Dashboard）基于 Spring Boot 开发，打包后可以直接运行，不需要额外的 Tomcat 等应用容器。

好了，这是我们对 Sentinel 的简单介绍，接下来，我们就来通过一个简单的例子来感受下 Sentinel 的基本用法。



**基本用法**



**Sentinel 仪表盘安装**

为了方便看到 Sentinel 的工作效果，我们需要首先安装好 Sentinel 仪表盘，官方提供的 Sentinel 仪表盘就是一个普通的 Spring Boot 工程，我们先将之下载下来：
下载下来之后，直接按照 Spring Boot 项目启动的套路来运行即可。如下：

```
java -jar sentinel-dashboard-1.6.1.jar
```

不过官方目前发布的 jar 并非是最新版，如果大家想使用最新版的 sentinel-dashboard ，可以下载最新的源码然后编译运行：

- [Sentinel Dashboard 最新源码(截止本文写作时最新源码)](https://github.com/alibaba/Sentinel/archive/master.zip)

下载完成后，解压，然后执行如下命令进行打包（如果需要修改启动端口等参数，可以按照 Spring Boot 项目的方式去修改，也可以在项目启动时指定相关参数，总之，这就是一个普通的 Spring Boot 工程，所有东西都按照 Spring Boot 的套路来即可）：

```
mvn clean package
```

不过由于打包时候要下载的东西比较多，打包过程比较慢，因此需要多等一会。打包成功后，进入到解压目录的 sentinel-dashboard/target 目录下，可以看到我们刚刚生成的 jar ，然后执行 `java -jar sentinel-dashboard.jar` 命令启动项目。

当 sentinel-dashboard 启动成功后，浏览器输入 `http://localhost:8080` ，就可以看到 Sentinel 的控制台登录页面：
![图片描述](https://img1.sycdn.imooc.com/5d3941740001338511980750.png)默认的用户名/密码都是 sentinel ，登录成功后的界面如下：
![图片描述](https://img1.sycdn.imooc.com/5d394194000150b433280672.png)如此之后，我们的 Sentinel 控制台就算安装成功了，接下来我们就可以开始创建 Spring Boot 项目了。



**整合 Spring Boot**

接下来我们来在 Spring Boot 项目中整合 Sentinel。

首先创建一个 Spring Boot 项目，创建时引入 Web 依赖即可，创建成功之后，手动引入 Sentinel 依赖，最终的 pom.xml 文件如下图：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        <version>0.9.0.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

项目创建成功之后，首先在 application.properties 中添加如下配置：

```properties
spring.cloud.sentinel.transport.dashboard=localhost:8080
spring.application.name=sentinel
server.port=8081
```

- 第一行配置表示指定 sentinel-dashborad 的位置
- 第二行和第三行配置分别表示指定服务的名字以及当前项目的端口号

配置完成后，我们再来创建一个 HelloController ，如下：

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot!";
    }
}
```

配置玩车后，启动项目。

项目启动成功之后，我们先来访问 /hello 这个接口，访问完成之后，我们打开 sentinel-dashboard 管理页面，就可以看到我们的服务了，如下：
![图片描述](https://img1.sycdn.imooc.com/5d3941b90001dfcb33602114.png)接下来我们来看一个简单的流量控制效果，我们点击左边的**簇点链路**按钮，然后点击右边的**流控**按钮：
![图片描述](https://img1.sycdn.imooc.com/5d3941db0001128c33201274.png)然后进行流量控制配置，如下：
![图片描述](https://img1.sycdn.imooc.com/5d3942380001caf633201580.png)这里我们配置 QPS 单机阈值为 5，表示1秒内可以处理 5 个请求，超过数量的请求将进行排队等待，等待超时时间是 1 s，即 1 s 之内还没处理，就会抛出超时。

配置完成后，在流控规则中可以看到我们刚刚添加的配置：
![图片描述](https://img1.sycdn.imooc.com/5d39424f0001c55633181196.png)然后我们在刚刚创建的 Spring Boot 工程中，写一个简单的单元测试：

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class SentinelApplicationTests {

    @Test
    public void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 15; i++) {
            String s = restTemplate.getForObject("http://localhost:8081/hello", String.class);
            System.out.println(i + ":" + s+":"+new Date());
        }
    }
}
```

执行这段代码，我们连续向刚刚的 Spring Boot 工程发送 15 个请求，查看请求日志，如下：
![图片描述](https://img1.sycdn.imooc.com/5d39426c0001364207760462.png)从日志中我们可以看到，每秒的请求个数不超过 5 个。

我们再来看看 sentinel-dashboard 中显示的情况：
![图片描述](https://img1.sycdn.imooc.com/5d39428000019c6733602114.png)流控功能已经实现了。是不是比我们前面学过的 Resilience4j 实现流控要容易一些。



**整合 Nacos**

上篇文章我们学习了 Nacos ，Sentinel 中的限流规则也可以配置在 Nacos 中，我们一起来看下如何实现。

还是上面的项目，我们继续添加 Nacos 依赖：

```xml
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-datasource-nacos</artifactId>
    <version>1.6.1</version>
</dependency>
```

然后再在 application.properties 中添加如下配置：

```properties
spring.cloud.sentinel.datasource.ds.nacos.server-addr=localhost:8848
spring.cloud.sentinel.datasource.ds.nacos.dataId=sentinel-rule
spring.cloud.sentinel.datasource.ds.nacos.groupId=DEFAULT_GROUP
spring.cloud.sentinel.datasource.ds.nacos.rule-type=flow
```

这里我们主要配置了四项，前三项的分别表示 Nacos 的地址，Nacos 中 dataId 的值，Nacos 中 groudId 的值。最后一项 rule-type 定义了规则类型，在 Sentinel 中，有不同的规则，例如热点参数限流、系统自适应限流等。

这里配置完成后，我们启动 Nacos ，并新建一项配置，如下：
![图片描述](https://img1.sycdn.imooc.com/5d39429a00019c5e33601696.png)这里的 dataId 和 Group 要和我们前面 application.properties 中配置的一致。至于配置内容，含义如下：

1. resource：这个指资源名称，一般来说就是我们配置的某一个接口或者某一个方法。
2. limitApp：流控针对的调用源，我们可以针对不同调用源给出不同的流控方案，default 则表示不区分调用源。
3. grade：阈值类型，0 表示并发线程数，1 表示根据 QPS。
4. count：单机阈值。
5. clusterMode：是否集群
6. strategy：流控模式
7. controlBehavior：流控效果

实际上，我们发现，这里的配置参数，和我们自己手动在 Sentinel 后台配置的参数一模一样！

这里配置完成后，我们再来重启一下我们的 Spring Boot 项目，注意观察启动日志：
![图片描述](https://img1.sycdn.imooc.com/5d3942b500018c7125100192.png)项目启动完成后，我们先在浏览器中访问项目的 /hello 接口，访问成功之后，我们刷新 Sentinel 后台管理页面，在流控规则一栏中，我们可以看到刚刚配置的流控规则：
![图片描述](https://img1.sycdn.imooc.com/5d3942ca0001c9b433601798.png)
看到这里，说明我们的配置已经成功了，接下来的测试，就和前文一模一样了，我就不再赘述了。



**总结**

本文主要向读者介绍了 Sentinel 的简单用法，相对于 Resilience4j ，个人感觉 Sentinel 还是更加方便一些，特别是在 Hystrix 停止更新的当下，Sentinel 似乎更加耀眼啦！

### 14、**微服务常见面试题分析**

随着越来越多的公司使用 Spring Cloud 技术，一些公司招聘岗位条件都会有一条 `Spring Cloud 实战项目经验优先`等描述。我在拉勾网上使用 springcloud 关键字进行检索，查询到了 30 多页的招聘需求，全部都是和 Java 工程师招聘相关。

可以预见的是，Spring Cloud 慢慢会成为大多数公司面试考察的知识点之一，本节课为大家梳理 Spring Cloud 技术栈中常见的考察点。回顾这些高频的面试题，其实也是对 Spring Cloud 知识体系做一次整体的梳理。



**微服务相关**



**谈谈你对微服务的理解**

微服务架构是一种架构模式或者说是一种架构风格，它提倡将单一应用程序划分为一组小的服务，每个服务运行在其独立的自己的进程中，服务之间相互协调、互相配合，为用户提供最终服务。

服务之间采用轻量级的通信机制互相沟通（通常是基于 HTTP 的 RESTful API）,每个服务都围绕着具体的业务进行构建，并且能够被独立的构建在生产环境、类生产环境等。

另外，应避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据业务上下文，选择合适的语言、工具对其进行构建，可以有一个非常轻量级的集中式管理来协调这些服务，可以使用不同的语言来编写服务，也可以使用不同的数据存储。



**微服务的优缺点？**

**微服务的优点**

- 复杂度可控：在将应用分解的同时，规避了原本复杂度无止境的积累。每一个微服务专注于单一功能，并通过定义良好的接口清晰表述服务边界。由于体积小、复杂度低，每个微服务可由一个小规模开发团队完全掌控，易于保持高可维护性和开发效率。
- 独立部署：由于微服务具备独立的运行进程，所以每个微服务也可以独立部署。当某个微服务发生变更时无需编译、部署整个应用。由微服务组成的应用相当于具备一系列可并行的发布流程，使得发布更加高效，同时降低对生产环境所造成的风险，最终缩短应用交付周期。
- 技术选型灵活：微服务架构下，技术选型是去中心化的。每个团队可以根据自身服务的需求和行业发展的现状，自由选择最适合的技术栈。由于每个微服务相对简单，故需要对技术栈进行升级时所面临的风险就较低，甚至完全重构一个微服务也是可行的。
- 容错：当某一组件发生故障时，在单一进程的传统架构下，故障很有可能在进程内扩散，形成应用全局性的不可用。在微服务架构下，故障会被隔离在单个服务中。若设计良好，其他服务可通过重试、平稳退化等机制实现应用层面的容错。
- 扩展：单块架构应用也可以实现横向扩展，就是将整个应用完整的复制到不同的节点。当应用的不同组件在扩展需求上存在差异时，微服务架构便体现出其灵活性，因为每个服务可以根据实际需求独立进行扩展。

**微服务的缺点**

- 技术难度提高，微服务架构下会比传统架构多出几倍的应用数，他们相互之间的调用复杂度成指数级别增长，传统的技术方案很难满足微服务架构模式，因此需要使用更多的技术来保障整个架构的稳定性。
- 运维复杂，微服务架构下对运维有了新的调整，一次性部署几百台服务成为了常见的工作，因此自动化部署、监控、运维手段都需要提升。
- 性能影响，微服务之间大多是跨进程访问，并且因为服务切割的粒度变小，调用的链条越长，所以在性能上有所损耗，需要权衡。



**微服务架构下如何解决数据问题**

每个微服务都有自己独立的数据库，导致后台关联查询业务实现起来比较复杂，是大家普遍都会遇到的一个问题。我们也算是踩过一段时间的坑。主要有三个解决方案。

严格按照微服务的划分来做，微服务相互独立，各微服务数据库也独立，后台需要展示数据时，调用各微服务的接口来获取对应的数据，再进行数据处理后展示出来，这是标准的用法，也是最麻烦的用法。

将业务高度相关的表放到一个库中，将业务关系不是很紧密的表严格按照微服务模式来拆分，这样既可以使用微服务，也避免了数据库分散导致后台系统统计功能难以实现，是一个折中的方案。

数据库严格按照微服务的要求来切分，以满足业务高并发，实时或者准实时将各微服务数据库数据同步到NoSQL数据库中，在同步的过程中进行数据清洗，用来满足后台业务系统的使用，推荐使用MongoDB、HBase等。

三种方案在不同的公司我都使用过，第一种方案适合业务较为简单的小公司；第二种方案，适合在原有系统之上，慢慢演化为微服务架构的公司；第三种适合大型高并发的互联网公司。

一般一个微服务享用这个数据库的管理权，其他服务如果需要写入或者读取此服务内的数据，都应该通过此服务的接口来调用。



**微服务架构下如何解决事务问题**

分布式事务就是指事务的参与者、支持事务的服务器、资源服务器以及事务管理器分别位于不同的分布式系统的不同节点之上。 简单的说，就是一次大的操作由不同的小操作组成，这些小的操作分布在不同的服务器上，且属于不同的应用，分布式事务需要保证这些小操作要么全部成功，要么全部失败。本质上来说，分布式事务就是为了保证不同数据库的数据一致性。

分布式事务的目的是保障分库数据一致性，而跨库事务会遇到各种不可控制的问题，如个别节点永久性宕机，像单机事务一样的 ACID 是无法奢望的。另外，业界著名的 CAP 理论也告诉我们，对分布式系统，需要将数据一致性和系统可用性、分区容忍性放在天平上一起考虑。

目前主流的方案有以下三种：

**二阶段提交 2PC，强一致性**

二阶段提交的算法思路可以概括为：参与者将操作成败通知协调者，再由协调者根据所有参与者的反馈情况，决定各参与者是否要提交操作还是中止操作。

2PC 的核心原理是通过提交分阶段和记日志的方式，记录下事务提交所处的阶段状态，在组件宕机重启后，可通过日志恢复事务提交的阶段状态，并在这个状态节点重试。

**消息机制，最终一致性**

核心思想是将需要分布式处理的任务通过消息或者日志的方式来异步执行，消息或日志可以存到本地文件、数据库或消息队列，再通过业务规则进行失败重试，它要求各服务的接口是幂等的。

借助消息队列，在处理业务逻辑的地方，发送消息，业务逻辑处理成功后，提交消息，确保消息是发送成功的，之后消息队列投递来进行处理，如果成功，则结束，如果没有成功，则重试，直到成功，不过仅仅适用业务逻辑中，第一阶段成功，第二阶段必须成功的场景。

**TCC 补偿模式，最终一致性**

TCC 属于补偿型柔性事务，本质也是一个两阶段型事务，这与 JTA 是极为相似的，但是与 JTA 的不同点是，JTA 属于资源层事务，而 TCC 是服务层事务。

在一个长事务（ long-running ）中 ，一个由两台服务器一起参与的事务，服务器 A 发起事务，服务器 B 参与事务，B 的事务需要人工参与，所以处理时间可能很长。如果按照 ACID 的原则，要保持事务的隔离性、一致性，服务器 A 中发起的事务中使用到的事务资源将会被锁定，不允许其他应用访问到事务过程中的中间结果，直到整个事务被提交或者回滚。这就造成事务A中的资源被长时间锁定，系统的可用性将不可接受。

WS-BusinessActivity 提供了一种基于补偿的 long-running 的事务处理模型。还是上面的例子，服务器 A 的事务如果执行顺利，那么事务 A 就先行提交，如果事务 B 也执行顺利，则事务 B 也提交，整个事务就算完成。但是如果事务 B 执行失败，事务 B 本身回滚，这时事务 A 已经被提交，所以需要执行一个补偿操作，将已经提交的事务 A 执行的操作反操作，恢复到未执行前事务 A 的状态。这样的 SAGA 事务模型，是牺牲了一定的隔离性和一致性的，但是提高了 long-running 事务的可用性。

**特别建议**：在微服务架构下，能不使用分布式事务尽量不要使用，如果非得使用的话，结合自己的业务分析，看看自己的业务比较适合哪一种，选择强一致，还是最终一致即可。



**Spring Cloud 相关**



**Spring Boot 和 Spring Cloud 有什么关系？**

Spring Boot 是一套快速开发工具集合，重构了整个开发流程，简化了人们使用 Spring 的难度，让普通开发人员可以基于 Spring Boot 快速构建应用开发。Spring Boot 专注于应用个体。

Spring Cloud 是一系列框架的有序集合。它利用 Spring Boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，Spring Cloud 专注于全局的服务治理。

总结一下，Spring Boot 是快速开发工具，专业于应用个体；Spring Cloud 基于 Spring Boot 开发，因此继承了 Spring Boot 的特性，另外 Spring Cloud 更专注于服务治理。



**使用 Spring Cloud 有什么优势？**

- Spring Cloud 来源于 Spring，质量、稳定性、持续性都可以得到保证
- Spring Cloud天然支持 Spring Boot，更加便于业务落地。
- Spring Cloud 发展非常的快，可以看到业界越来越多的公司选择了 Spring Cloud
- Spring Cloud 是 Java 领域最适合做微服务的框架。
- 相比于其它框架,Spring Cloud 对微服务周边环境的支持力度最大。
- 对于中小企业来讲，使用门槛较低。



**Spring Cloud 和 Dubbo 有什么区别**

- Dubbo，是阿里巴巴服务化治理的核心框架，并被广泛应用于中国各互联网公司；Spring Cloud 来源于 Spring 家族产品，Spring 是一家历史悠久的开源公司。
- Dubbo 是一个非常优秀的服务治理框架，并且在服务治理、灰度发布、流量分发比 Spring Cloud 更全面。
- Spring Cloud 几乎考虑了服务治理的方方面面，拥有 Spring Boot 的快速开发的特性，易用使用和部署。
- Dubbo 关注的领域是 Spring Cloud 的一个子集，Dubbo 专注服务治理，Spring Cloud 覆盖整个微服务架构领域。
- Dubbo 使用 RPC 调用效率很高一些，Spring Cloud 使用 Http 调用效率低，使用更简单。
- Dubbo 曾经使用范围更广泛，现在 Spring Cloud 使用更普遍。



**Netflix 和 Spring Cloud 有什么关系**

Netflix 是一家成功实践微服务架构的互联网公司，几年前，Netflix 就把它的几乎整个微服务框架栈开源贡献给了社区。Spring 背后的 Pivotal 公司在 2015 年推出的 Spring Cloud 开源产品，主要对 Netflix 开源组件的进一步封装，方便 Spring 开发人员构建微服务基础框架。

Netflix 在 Spring Cloud 体系内贡献的产品主要有：Eureka、Hystrix、Zuul、ribbon、turbine、archaius 等，最新版本中这些产品都处于维护状态。



**Rest 和 Rpc 对比**

- Rest 风格的系统交互更方便，Rpc 调用服务提供方和调用方式之间依赖太强
- Rest 调用系统性能较低，Rpc 调用效率比 Rest 高。
- Rest 的灵活性可以跨系统跨语言调用，Rpc 只能在同语言内调用
- Rest 可以和 swagger 等工具整合，自动输出接口 API 文档



**Spring Cloud 组件**



**Eeruka 续约与剔除**

服务实例启动后，会周期性地向 Eureka Server 发送心跳以续约自己的信息，避免自己的注册信息被剔除。续约的方式与服务注册基本一致：首先更新自身状态，再同步到其它 Peer。

如果 Eureka Server 在一段时间内没有接收到某个微服务节点的心跳，Eureka Serve r将会注销该微服务节点（自我保护模式除外）。



**Eeruka 可能会出现服务注册延迟的情况，为什么**

服务端的更改可能需要2分钟才能传播到所有客户端，这是因为 Eureka 有三处缓存和一处延迟造成的。

- Eureka Server 对注册列表进行缓存，默认时间为 30s。
- Eureka Client 对获取到的注册信息进行缓存，默认时间为 30s。
- Ribbon 会从上面提到的 Eureka Client 获取服务列表，将负载均衡后的结果缓存30s。

如果不是在 Spring Cloud 环境下使用这些组件(Eureka, Ribbon)，服务启动后并不会马上向 Eureka 注册，而是需要等到第一次发送心跳请求时才会注册。心跳请求的发送间隔默认是30s。Spring Cloud 对此做了修改，服务启动后会马上注册。



**Eureka 自我保护机制是什么**

默认情况下，如果 Eureka Server 在一定 90s 内没有接收到某个微服务实例的心跳，会注销该实例。但是在微服务架构下服务之间通常都是跨进程调用，网络通信往往会面临着各种问题，比如微服务状态正常，网络分区故障，导致此实例被注销。当 Eureka Server 检测到大规模服务异常时，会自动进入自我保护机制。

Eureka Server 进入自我保护机制，会出现以下几种情况：

- Eureka 不再从注册列表中移除因为长时间没收到心跳而应该过期的服务
- Eureka 仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上(即保证当前节点依然可用)
- 当网络稳定时，当前实例新的注册信息会被同步到其它节点中



**Eureka 和 Consul 有什么区别**

功能对比见下表：

| Feature              | Euerka                       | Consul                 |
| :------------------- | :--------------------------- | :--------------------- |
| 服务健康检查         | 可配支持                     | 服务状态，内存，硬盘等 |
| 多数据中心           | —                            | 支持                   |
| kv 存储服务          | —                            | 支持                   |
| 一致性               | —                            | raft                   |
| cap                  | ap                           | cp                     |
| 使用接口(多语言能力) | http（sidecar）              | 支持 http 和 dns       |
| watch 支持           | 支持 long polling/大部分增量 | 全量/支持long polling  |
| 自身监控             | metrics                      | metrics                |
| 安全                 | —                            | acl /https             |
| 编程语言             | Java                         | go                     |
| Spring Cloud 集成    | 已支持                       | 已支持                 |

Consul 服务注册相比 Eureka 会稍慢一些。因为 Consul 的 raft 协议要求必须过半数的节点都写入成功才认为注册成功, Leader 挂掉时，重新选举期间整个 Consul 不可用。Eureka 服务注册快，但可能会出现数据不一致的情况。



**Ribbon 和 Feign 有什么区别**

Ribbon
是一个基于 HTTP 和 TCP 客户端的负载均衡器
它可以在客户端配置 ribbonServerList（服务端列表），然后轮询请求以实现均衡负载。Feign 是在 Ribbon 的基础上进行了一次改进，是一个使用起来更加方便的 HTTP 客户端，让调用者更像是调用一个本地方法一样调用远程服务。

总结为三点：

- 启动类使用的注解不同，Ribbon 用的是 @RibbonClient，Feign 用的是 @EnableFeignClients。
- 服务的指定位置不同，Ribbon 是在 @RibbonClient 注解上声明，Feign 则是在定义抽象方法的接口中使用 @FeignClient 声明。
- 调用方式不同，Ribbon 需要自己构建 Http请求，模拟 Http 请求然后使用 RestTemplate 发送给其他服务，步骤相对繁琐。Feign 是在 Ribbon 的基础上进行了一次改进，采用接口的方式，将需要调用的其他服务的方法定义成抽象方法即可，不需要自己构建 Http 请求。不过要注意的是抽象方法的注解、方法签名要和提供服务的方法完全一致。



**什么是服务熔断？什么是服务降级？**

熔断机制是应对雪崩效应的一种微服务链路保护机制。当某个微服务不可用或者响应时间太长时，会进行服务降级，进而熔断该节点微服务的调用，快速返回“错误”的响应信息。当检测到该节点微服务调用响应正常后恢复调用链路。在 Spring Cloud 框架里熔断机制通过 Resilience4j 实现，Resilience4j 会监控微服务间调用的状况，当失败的调用到一定阈值如果失败，就会启动熔断机制。

服务降级，当某个服务熔断之后，客户端将不再调用此请求，此时客户端返回一个本地的 fallback 回调，返回一个缺省值。这样做，虽然会出现局部的错误，但可以避免因为一个服务挂机，而影响到整个架构的稳定性。



**服务网关的作用**

有以下作用：

- 简化客户端调用复杂度，统一处理外部请求。
- 数据裁剪以及聚合，根据不同的接口需求，对数据加工后对外。
- 多渠道支持，针对不同的客户端提供不同的网关支持。
- 遗留系统的微服务化改造，可以作为新老系统的中转组件。
- 统一处理调用过程中的安全、权限问题

Spring Cloud 体系内的网关有 Zuul、Spring Cloud Gateway，最新版本推荐使用后者。



**Spring Cloud bus 的作用**

Spring cloud bus 通过轻量消息代理连接各个分布的节点。这会用在广播状态的变化（例如配置变化）或者其他的消息指令。Spring bus 的一个核心思想是通过分布式的启动器对 Spring Boot 应用进行扩展，也可以用来建立一个多个应用之间的通信频道。

目前唯一实现的方式是用 AMQP 消息代理作为通道，同样特性的设置（有些取决于通道的设置）在更多通道的文档中。



**分布式追踪 Sleuth 工作原理**

当我们项目中引入`spring-cloud-starter-sleuth`包后，每次链路请求都会添加一串追踪信息，格式是`[server-name, main-traceId,sub-spanId,boolean]`。

- server-name：服务结点名称；
- main-traceId：一条链路唯一的 ID，为 TraceID
- sub-spanId：链路中每一环的 ID，为 SpanID
- boolean：是否将信息输出到 Zipkin 等服务收集和展示。

这种机制是如何实现的呢？我们知道 Spring Cloud 微服务是通过 Http 协议通信的，所以 Sleuth 的实现也是基于 Http 的，为了在数据的收集过程中不能影响到正常业务，Sleuth 会在每个请求的 Header 上添加跟踪需求的重要信息，例如：

```
X-A1-TraceId：对应 TraceID；
X-A1-SpanId：对应 SpanID；
X-A1-ParentSpanId：前面一环的 SpanID；
X-A1-Sampled：是否被选中抽样输出；
X-Span-Name：工作单元名称。
```

这样在数据收集时，只需要将 Header 上的相关信息发送给对应的图像工具即可，图像工具根据上传的数据，按照 Span 对应的逻辑进行分析、展示。



**总结**

本节为大家介绍了常见的 Spring Cloud 面试题，跟着面试题回顾了整个 Spring Cloud 生态技术，研究不同时期 Spring Cloud 技术栈的发展，也可以同步了解行业的技术动态。在日常工作中，遇到问题时多做思考，在面试时其实很容易覆盖掉 Spring Cloud 大多数面试问题。也希望大家在以后的面试中，遇到 Spring Cloud 相关问题，如数家珍。

### 15、总结

随着互联网不断快速发展，为了适应业务的快速变化，架构中的服务切分粒度越来越小，微服务架构便成一种必然趋势。Spring Cloud 的诞生极大的促进了微服务的发展，让广大的中小企业用很低的技术成本来实施他们的微服务架构。同时 Spring Cloud 体系内组件众多，实际生产中需根据企业特点灵活选择使用。

在本系列课程的最后一节，我们做两个回顾：第一个回顾是，回顾专栏课程，根据专栏模块整体回顾一下 Spring Cloud 体系；第二个回顾是，我们以组件角色的维度，回顾 Spring Cloud 生态体系内的产品，让大家对 Spring Cloud 全局性的认识。



**课程回顾**

本系列课程主要分了五大部分讲述 Spring Cloud，五部分内容层层递进，由浅入深的了解 Spring Cloud 技术。

**第一部分，微服务架构和 Spring Cloud**

Spring Cloud 是微服务架构落地的最佳技术，那么微服务架构是如何诞生的呢？第一部分给大家介绍了微服务相关的事情，让大家从技术发展、行业趋势的角度来理解，为什么需要 Spring Cloud。

Spring Cloud 本身具有很多的故事，比如早期为了快速构建起整个生态，大量采用了 Netflix 公司的开源产品，当然任何选择都是有代价的，随着 Netflix 出现一系列停更事件，Spirng Cloud 加大了自研力度。

Spring Cloud 依赖于 Spring Boot 进行开发，于是我们需要了解 Spring Boot 的基本特性，以及使用 Spring Boot 开发 Spring Cloud 会带来哪些便利，最后详细的阐述了 Spring Boot 和 Spring Cloud 之间的关系。

本专栏的第一部分，主要让大家站在一个更高的维度来了解 Spring Cloud ，这样在我们学习 Spring Cloud 产品时，才会对它的使用场景有更深的认识。

**第二部分，Spring Cloud 核心组件**

第二部分是本专栏最核心的内容，讲解 Spring Cloud 核心组件的使用。从最核心的组件注册中心讲起，介绍了注册中心的由来和基本原理。其中重点给介绍了 Eureka 和 Consul 两个产品，分别介绍了他们的特性、工作原理，以及如何使用。

注册中心的使用，让服务提供者和服务调用者进行了解耦，这样服务端才可根据情况动态扩容。解决了微服务架构中服务注册与发现后，如何让客户端高效调用服务端，变成了下一个关注点。Spring Cloud 体系内提供了两款产品 RestTemplate 和 Spring Cloud OpenFeign。

RestTemplate 是从 Spring3.0 开始支持的一个 HTTP 请求工具，它提供了常见的 REST 请求方案的模版。Feign 是一个声明式的 REST 客户端，它的目的就是让 REST 调用更加简单。两者各有特点，专栏给大家详细介绍了两个组件的使用。

在微服务架构中，服务网关是一个非常重要的角色，可以有效隔离内外部请求。本专栏给大家介绍了 Spring 官方出品的网关产品 Spring Cloud Gateway，经过近两年的孵化，如今 Spring Cloud Gateway 已经成为体系内的默认网关技术。

服务容错保护可以保障系统局部出现故障时，避免出现雪崩效应，保障架构整体稳定性。Resilience4j 是最新一代的熔断技术，它非常轻量级，但功能很全面，包含了请求熔断、限流、限时、缓存、隔离以及重试等，Resilience4j 也是 Greenwich 版本中推荐的容错保护技术。

除过上面这些产品，还有三个组件非常重要：Spring Cloud Config 解决了微服务架构下的分布式配置问题；Spring Cloud Bus 整合了消息中间件的使用；Spring Cloud Stream 用于构建高度可扩展的基于事件驱动的微服务，其目的是为了简化消息在 Spring Cloud 应用程序中的开发。三个组件都是在特定领域简化相关产品的使用。

**第三部分，Spring Cloud 辅助组件**

Spring Cloud 辅助组件是指，可以提供特定功能，帮助 Spring Cloud 监控微服务架构的运行情况，在本次专栏中主要介绍了三款产品：Spring Cloud Sleuth、Zipkin 以及 Spring Boot Admin。

Spring Cloud Sleuth 是为了解决在微服务架构中，分布式链路跟踪的问题，Sleuth 负责收集数据、Zipkin 对收集好的数据进行展示。Spring Boot Admin 在 Spring Boot Actuator 的基础上对数据进行了整合，方便我们以图形化的方式查看集群应用的状态。

**第四部分，介绍阿里里生态和 Spring Cloud 的关系**

2018年10月31日，Spring Cloud Alibaba 正式入驻了 Spring Cloud 官方孵化器，在入驻后不久，阿里就将相关中间件移植到了 Spring Cloud 生态中，比较重要的组件有 Naco、Sentinel、RocketMQ、Dubbo、Seata 等，本专栏为大家介绍了其中最重要的两个组件 Naco 和 Sentinel。

Naco 是一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台，Nacos 是注册中心的一个产品实现；Sentinel 是一个熔断保护产品，把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。从这两个组件也可以看出 Spring Cloud 相当于 Spring Cloud Alibaba 的一个分支。

目前 Spring Cloud Alibaba 还没有发布第一个正式版本，却一直在 Spring Cloud Alibaba 体系中添加阿里的相关中间件，相信未来 Spring Cloud Alibaba 也会有更好的发展。

**第五部分，专栏总结回顾**

第五部分比较简单，分析微服务常见面试题，带着大家回顾一下 Spring Cloud 生态中关键技术点，最后总体回顾一下整个专栏的内容，总结 Spring Cloud 体系生态技术。



**Spring Cloud 技术栈**

我们再从 Spring Cloud 技术栈的角度，来回顾一下本系列专栏所涉及的相关组件，如下图：
![图片描述](https://img1.sycdn.imooc.com/5d3943510001946411590556.png)

- 服务治理，主要讲解了 Eureka 和 Consul 的使用。
- 服务调用，介绍了 RestTemplate、Spring Cloud Loadbalancer、Spring Cloud OpenFeign 的调用方式。
- 服务容错，详细介绍了 Resilience4j 的使用，简单介绍和 Hystrix 的区别。
- 服务网关，介绍了 Spring Cloud Gateway 的使用，以及 Zuul 的简单介绍。
- 配置中心，配置中心产品 Spring Cloud Config 使用详解。
- 数据流，Spring Cloud Stream 的介绍与使用。
- 服务监控，分布式链接跟踪 Spring Cloud Sleuth、图形展示 Zipkin，以及 Spring Boot Admin 的使用说明。
- 消息总线，介绍了 Spring Cloud Bus 的使用。
- Spring Cloud Alibaba，介绍了阿里巴巴在 Spring Cloud 体系内发发展，重点介绍了 Naco 和 Sentinel 的使用。



**总结**

我们从整体上来看一下 Spring Cloud 各个组件如何来配套使用：
![图片描述](https://img1.sycdn.imooc.com/5d39438e0001593812411051.png)从上图可以看出 Spring Cloud 各个组件相互配合，合作支持了一套完整的微服务架构。

- 前端请求通过服务网关 Spring Cloud Gateway，将请求转发到相关服务。
- Eureka 负责服务的注册与发现，很好将各服务连接起来，替代技术方案 Consul。
- Resilience4j 负责监控服务之间的调用情况，连续多次失败进行熔断保护。
- Micrometer 负责监控 Resilience4j 的熔断情况，并给予图形化的展示
- Spring Cloud Config 提供了统一的配置中心服务
- 当配置文件发生变化的时候，Spring Cloud Bus 负责通知各服务去获取最新的配置信息
- 图中没有画出，可以根据 Spring Cloud Stream 构建消息驱动的微服务
- 最后我们使用 Sleuth+Zipkin 将所有的请求数据记录下来，方便我们进行后续分析

Spring Cloud 从设计之初就考虑了绝大多数互联网公司架构演化所需的功能，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等。这些功能都是以插拔的形式提供出来，方便我们系统架构演进的过程中，可以合理的选择需要的组件进行集成，从而在架构演进的过程中会更加平滑、顺利。

微服务架构是一种趋势，Spring Cloud 提供了标准化的、全站式的技术方案，有效推进服务端软件系统技术水平的进步。
使用 Spring Cloud 二年多，深感 Spring Cloud 给中小企业架构带来的改变。也希望大家通过此专栏课程的学习，能对 Spring Cloud 有更进一步的了解，在工作中有所帮助。