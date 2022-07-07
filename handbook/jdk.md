JDK
---

### 安装

- CentOS


    cd ~

    wget https://download.java.net/java/GA/jdk17.0.1/2a2082e5a09d4267845be086888add4f/12/GPL/openjdk-17.0.1_linux-x64_bin.tar.gz
    
    tar -zxvf openjdk-17.0.1_linux-x64_bin.tar.gz

    mv jdk-17.0.1 jdk
    
    vim /etc/profile

            #JDK
            export JAVA_HOME=/root/jdk
            export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
            export PATH=$PATH:$JAVA_HOME/bin
    
    source /etc/profile

- mac


- Windows

