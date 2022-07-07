Redis
---
###安装
- Linux


    wget http://download.redis.io/releases/redis-stable.tar.gz
    
    tar zxvf redis-stable.tar.gz
    
    cd redis-stable
    
    make
    
    vim redis.conf
    
    nohup src/redis-server redis.conf &
- mac


    brew install redis

    brew services start redis

- Windows

