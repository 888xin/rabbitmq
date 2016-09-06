# rabbitmq
rabbitmq示例代码，包括纯java运行和与spring结合运行。


Windows上安装RabbitMQ

需要先安装erlang。

erlang介绍：

    Erlang运行时环境是一个虚拟机，有点像Java虚拟机，这样代码一经编译，同样可以随处运行。
    它的运行时系统甚至允许代码在不被中断的情况下更新。另外如果你需要更高效的话，字节代码也可以编译成本地代码运行。 
Erlang特性： 
并发性 - Erlang支持超大量级的并发线程，并且不需要操作系统具有并发机制。 
分布式 - 一个分布式Erlang系统是多个Erlang节点组成的网络（通常每个处理器被作为一个节点） 
健壮性 - Erlang具有多种基本的错误检测能力，它们能够用于构建容错系统。 
软实时性- Erlang支持可编程的“软”实时系统，使用了递增式垃圾收集技术。 
热代码升级-Erlang允许程序代码在运行系统中被修改。旧代码能被逐步淘汰而后被新代码替换。在此过渡期间，新旧代码是共存的。
递增式代码装载-用户能够控制代码如何被装载的细节。 
外部接口-Erlang进程与外部世界之间的通讯使用和在Erlang进程之间相同的消息传送机制。 
Fail-fast（中文译为速错），即尽可能快的暴露程序中的错误。 
面向并发的编程(COP concurrency-oriented programming) 
函数式编程 
动态类型 
及早求值或严格求值 
脚本语言


安装步骤：

1.下载erlang  http://www.erlang.org/download.html（如果下载: OTP 17.1 Windows 64-bit Binary File (91.8 MB)）。
2.安装下载的exe文件，注意安装的目录中不要存在空格。
3.配置环境变量。在系统变量中建立变量名为“ERL_HOME”，值为erlang的安装目录。
4.在PATH变量中添加“%ERL_HOME%\bin”。
5.启动运行，在控制台输入“erl”，如果出现类似“Eshell V6.1 (abort with ^G)”字样，说明安装成功。

参考：
http://www.ibm.com/developerworks/cn/opensource/os-riak1/

http://www.cnblogs.com/studynote/p/3214020.html

rabbitmq下载地址
http://www.rabbitmq.com/download.html

直接双击安装rabbitmq
安装完，打开命令行命令行,进入RabbitMQ的安装目录: cd rabbitmq_server-3.5.2\sbin
输入 rabbitmqctl status , 如果出现以下的图，说明安装是成功的，并且说明现在RabbitMQ Server已经启动了,运行正常。

C:\Program Files\RabbitMQ Server\rabbitmq_server-3.6.5\sbin>rabbitmqctl status
Status of node 'rabbit@Lifeix-pc' ...
[{pid,9788},
 {running_applications,[{rabbit,"RabbitMQ","3.6.5"},
                        {mnesia,"MNESIA  CXC 138 12","4.12.1"},
                        {os_mon,"CPO  CXC 138 46","2.2.15"},
                        {rabbit_common,[],"3.6.5"},
                        {xmerl,"XML parser","1.3.7"},
                        {ranch,"Socket acceptor pool for TCP protocols.",
                               "1.2.1"},
                        {sasl,"SASL  CXC 138 11","2.4"},
                        {stdlib,"ERTS  CXC 138 10","2.1"},
                        {kernel,"ERTS  CXC 138 10","3.0.1"}]},
 {os,{win32,nt}},
 {erlang_version,"Erlang/OTP 17 [erts-6.1] [64-bit] [smp:4:4] [async-threads:64]\n"},
 {memory,[{total,48083008},
          {connection_readers,0},
          {connection_writers,0},
          {connection_channels,0},
          {connection_other,0},
          {queue_procs,2704},
          {queue_slave_procs,0},
          {plugins,0},
          {other_proc,22122752},
          {mnesia,61640},
          {mgmt_db,0},
          {msg_index,51952},
          {other_ets,979696},
          {binary,23264},
          {code,19851942},
          {atom,711569},
          {other_system,4277489}]},
 {alarms,[]},
 {listeners,[{clustering,25672,"::"},{amqp,5672,"::"},{amqp,5672,"0.0.0.0"}]},
 {vm_memory_high_watermark,0.4},
 {vm_memory_limit,6851372646},
 {disk_free_limit,50000000},
 {disk_free,1131212800},
 {file_descriptors,[{total_limit,8092},
                    {total_used,2},
                    {sockets_limit,7280},
                    {sockets_used,0}]},

安装rabbitmq管理工具
打开RabbitMQ Command Prompt 命令提示窗口，输入以下命令
rabbitmq-plugins enable rabbitmq_management
既可以安装完成
启动rabbitmq之后就可以输入http://localhost:15672/ 进入Manager界面
输入 username和password guest，guest 即可

整个windows下的rabbitmq就安装完成了。


RabbitMQ windows 管理工具

RabbitMQ提供了两种管理rabbitmq的工具，一种是管理插件management plugin，一种是rabbitmqctl。
1. management plugin：包含两种插件，一种是基于Web UI管理插件，另一种是基于命令行方式的管理工具rabbitmqadmin,二者实现的功能基本基本一样，但后者更适合于脚本，rabbitmqadmin也是一个HTTP客户端。因为基于web的管理插件使用简单，所以主要介绍rabbitmqadmin，后面简单介绍web UI版的。
2. rabbitmqctl：官网文档
Management Plugin
RabbitMQ Management Command Line Tool (rabbitmqadmin)
获取rabbitmqadmin及基本功能

以下步骤的前提是管理插件management pluin已安装好。
1. 在浏览器中输入 (“server-name”为你rabbitmq的hostname)
http://server-name:15672/cli/
本机使用默认的localhost，在浏览器中输入
http://localhost:15672/cli/
2. 按照页面提示，右键保存下载链接，浏览器会下载rabbitmqadmin文件，并且自动加上后缀名txt，这个rabbitmqadmin.txt其实是一个Python内容的文件，所以需要用python解析，确保你电脑有python环境，并且是2.x版本，不支持3.x。
3. 将rabbitmqadmin.txt放到和python.exe同个路径，并把后缀txt去掉，然后通过下面的方式去调用rabbitmqadmin
python.exe rabbitmqadmin
4. 使用下面的命令可以查看使用说明
python.exe rabbitmqadmin --help
基本功能和网页版插件一样，包括：
- 查看exchanges, queues, bindings, vhosts, users, permissions, connections和channels.
- overview信息查看
- 声明，删除exchanges, queues, bindings, vhosts, users 和 permissions
- 发布或获取消息
- 关闭连接，释放队列
- 导入导出配置
5. rabbitmqadmin支持bash shell用tab键自动补齐，查看bash自动补齐脚本可以调用一下命令
python.exe rabbitmqadmin --bash-completion
实例

    获得exchanges列表
    python.exe rabbitmqadmin -V test list exchanges
    获得队列及指定的信息
    rabbitmqadmin list queues vhost name node messages message_stats.publish_details.rate
    获得队列的所有信息
    rabbitmqadmin -f long -d 3 list queues
    连接到其他host
    rabbitmqadmin -H myserver -u simon -p simon list vhosts
    声明exchange
    rabbitmqadmin declare exchange name=my-new-exchange type=fanout
    声明队列
    rabbitmqadmin declare queue name=my-new-queue durable=false
    发布消息
    rabbitmqadmin publish exchange=amq.default routing_key=test payload="hello, world"
    获取发布的消息
    rabbitmqadmin get queue=test requeue=false
    导出配置信息
    rabbitmqadmin export rabbit.config
    关闭所有连接
    rabbitmqadmin -q close connection name=${conn}

Management Plugin Web UI
安装及登录

    打开RabbitMQ Command Prompt 命令提示窗口，输入以下命令
    rabbitmq-plugins enable rabbitmq_management
    安装完毕后在浏览器地址栏中输入下面地址就可以找到web UI
    http://server-name:15672/
    其中server-name是hostname，rabbitmq3.0以前的版本端口号要改成55672
    在登录窗口中输入username和password，授权进入，默认二者均为guest。

简单介绍

Web UI的进行上面实例中的操作比较简单，只需按照页面提示来操作即可。下面介绍一些通用设置。
1. 权限 Permissions

这里写图片描述
user可以有不同的权限，包括 “management”,”policymaker”,”monitoring”,”administrator” 四种，这些权限类型以tags的形式赋予user，通过设置tags来设置权限。

这里写图片描述
2. 影响管理插件的配置信息(在配置文件中修改配置)
- 定义文件
配置文件为json格式，包含了整个broker的配置定义（包括队列，转发器，绑定，用户，权限等），可以导出观察，也可以导入，从而覆盖整个broker的配置。
- 消息速率
可以显示队列，通道，转发器，虚拟主机的速率，也可以显示他们间相互连接间的速率。
- 统计数据的间隔时间
设置 rabbit 中的 collect_statistics_interval 变量的值,然后重启RabbitMQ。
- Http请求日志
设置 rabbit_management 中的 http_log_dir 的路径，然后重启RabbitMQ，只有发送到API的请求可以被记录，其他的file的http的请求不能被记录。
例如，可以对tcp监听端口进行设置，统计数据更新周期和http请求日志等进行配置

[
  {rabbit,                    [ {tcp_listeners,               [5672]},
                                {collect_statistics_interval, 10000} ] },
  {rabbitmq_management,       [ {http_log_dir,  "/tmp/rabbit-mgmt"},
                                {rates_mode,    basic}] }
].
