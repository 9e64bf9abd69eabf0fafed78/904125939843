     # 指定Nginx Worker进程运行用户以及用户组，默认由nobody账号运行。如果编译Nginx的时候指定了用户和用户组，该选项可以关闭
     user  nobody;
     # 指定Nginx需要开启的进程数，每个进程平均耗费10~12M内存。建议数量设置成与CPU内核的数量一致就可以了。
     # cpu的核心数可以使用 cat /proc/cpuinfo | grep flags | grep ' lm ' | wc -l 或 cat /proc/cpuinfo | grep name | cut -f2 -d: | uniq -c 命令进行查
     worker_processes  1;
     # 定义全局错误日志文件，后面可以设置输出级别：debug、info、notice、warn、error、crit
     error_log  logs/error.log;
     #error_log  logs/error.log  notice;
     #error_log  logs/error.log  info;
     # 用来指定进程id的存储文件位置
     pid        logs/nginx.pid;
     # 启用TCMalloc的设置，见上节相关的描述
     google_perftools_profiles /tmp/tcmalloc;
     # 用于绑定worker进程和CPU，该值必须和Linux内核打开文件数关联起来，如将该值设置为65535就必须在Linux命令行中执行 ulimit -HSn 65535
     worker_rlimit_nofile 65535;
     
     events {
         # 用来指定Nginx的工作模式，支持的模式有select、poll、kqueue、epool、rtsig和/dev/poll。其中select和poll都是标准的工作模式
         # kqueue和epoll是高效的工作模式，前者用在linux平台上，后者用于BSD系统。
         use epoll;
         # 定义每个进程的最大连接数，默认是1024，该参数的最大连接数受Linux系统进程的最大打开文件数限制，必须使用 ulimit命令
         # 另外，最大客户端连接数max_client=worker_processes*worker_connections，作为反向代理的话还需要除以4。
         worker_connections  65535;
     }
     
     http {
         # 引用外部文件，类似于Apache中的include
         include       mime.types;
         # 当出现无法解析的文件时，提示用户下载
         default_type  application/octet-stream;
     
         # 定义日志的格式，后面的main为格式的名称，可以在access_log指令中进行引用
         #log_format  main  '$remote_addr - $remote_user [$time_local] "$utils.request" '
         #                  '$status $body_bytes_sent "$http_referer" '
         #                  '"$http_user_agent" "$http_x_forwarded_for"';
     
         #access_log  logs/access.log  main;
     
         # 设定请求缓冲
         server_names_hash_bucket_size 128;
         client_header_buffer_size 32k;
         large_client_header_buffers 432k;
         # 设置客户端能够上传文件大小的限制
         client_max_body_size 600m;
     
         # 是否开启高效文件传输模式，将tcp_nopush和tcp_nodelay两个指令设置为on用于防止网络阻塞
         sendfile        on;
         tcp_nopush     on;
         tcp_nodelay  on;
     
         # 隐藏nginx的版本显示，增强安全性
         server_tokens off;
     
         # 用于设置客户端连接保持活动的超时时间，单位为秒，默认为75s
         #keepalive_timeout  0;
         keepalive_timeout  65;
         # 用于指定响应客户端的超时时间，这个超时仅限于两个连接活动之间的时间，默认为60s
         #send_timeout 60;
     
         # 下面是FastCGI的优化指令
         # 连接到后端FastCGI的超时时间
         fastcgi_connect_timeout 300;
         # 向FastCGI传送请求的超时时间
         fastcgi_send_timeout 300;
         # 接收FastCGI应答的超时时间
         fastcgi_read_timeout 300;
         # 指定读取FastCGI应答第一部分需要多大的缓冲区
         fastcgi_buffer_size 64k;
         fastcgi_buffers 464k;
         # 默认值是fastcgi_buffers的两倍
         fastcgi_busy_buffers_size 128k;
         # 表示在写入缓存文件时使用多大的数据块，默认为fastcgi_buffers的两倍
         fastcgi_temp_file_write_size 128k;
         # 为FastCGI缓存指定一个文件路径、目录结构等级、关键字区域存储时间和非活动删除时间
         #fastcgi_cache_path /usr/local/nginx/fastcgi_cache levels=1:2 keys_zone=TEST:10m inactive=5m;
         # 开启FastCGI缓存并为其设定一个名称。开启缓存可以有效降低CPU的负载，并且防止502错误的发生。
         # 但是同时也会引起很多问题，要视具体情况而定
         #fastcgi_cache TEST;
         # 用来指定应答代码的缓存时间，下面三条指令表示将200和303应答缓存1小时，301应答缓存1天，其他应答缓存1分钟。
         #fastcgi_cache_valid 200 302 1h;
         #fastcgi_cache_valid 301 1d;
         #fastcgi_cache_valid any 1m;
     
         # 配置Nginx的HttpGzip模块，开通的前提是安装的时候启用了该模块，使用 /usr/local/nginx/sbin/nginx -V 来查看安装的信息（大写的V）
         # 是否开通gzip
         gzip  on;
         # 允许压缩的页面最小字节数
         gzip_min_length 1k;
         gzip_buffers 416k;
         gzip_http_version 1.1;
         # 压缩比，从1到9，越大压缩率越高但越占资源，默认为1
         gzip_comp_level 2;
         # 指定压缩的类型，text/html总是被压缩
         gzip_types text/plainapplication/x-javascripttext/cssapplication/xml;
         # 是否让浏览器缓存压缩过的数据，默认为off
         gzip_vary on;
     
         # server 用于对虚拟主机的设置，建议每个站点的设置放到外部配置文件中，然后使用include进行引用
         # 这里设置一个默认的主机，当默认访问的时候返回403错误
         server {
             listen       80 default;
             server_name _;
             # 也可以修改成404或者500，根据自身情况进行设置
             return 403;
         }
     
         # 可以使用include将每个站点的配置引用进来，这样方便对站点进行管理
         include vhosts/examples.com.conf;
         include vhosts/abc.com.conf;
     }
