# 安装

yum install zlib-devel bzip2-devel openssl-devel ncurses-devel sqlite-devel readline-devel tk-devel gcc make

wget https://www.python.org/ftp/python/3.9.7/Python-3.9.7.tar.xz

tar -xvf Python-3.9.7.tar.xz

cd Python-3.9.7

./configure prefix=/usr/local/python3

make && make install

ln -s /usr/local/python3/bin/python3 /usr/bin/python3