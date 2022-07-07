wget http://mirror.bit.edu.cn/apache/zookeeper/zookeeper-3.5.6/apache-zookeeper-3.5.6-bin.tar.gz

tar zxvf apache-zookeeper-3.5.6-bin.tar.gz

mv apache-zookeeper-3.5.6-bin zk

cd zk

mv conf/zoo_simple.cfg zoo.cfg

mkdir /tmp/zookeeper

./bin/zkServer.sh start
  


