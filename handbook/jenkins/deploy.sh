#!/usr/bin/env bash
export BUILD_ID=dontkillme
project_name=${1}
profile=${2}
port=${3}
root=${4}
##################################################
format=.zip
project=prefix-${project_name}
echo "                                                                                        部署工程: ${project}                                     "
echo "                                                                                        打包配置: ${profile}                                      "
echo "                                                                                        使用端口: ${port}                                          "
echo "                                                                                        部署工程: ${project}                                      "
artifact=${project}-${profile}
last=${artifact}$(date +%y%m%d%H%M%S)${format}
artifact_home=${root}artifacts/${project_name}
if [[ ! -e ${artifact_home} ]];
then
echo "                                                                                                  归档目录(${artifact_home}) 不存在, 创建... "
mkdir -p ${artifact_home}
fi
work_home=${root}apps
if [[ ! -e ${work_home} ]];then
echo "                                                                                                  部署目录(${work_home}) 不存在, 创建... "
 mkdir -p ${work_home}
fi
bak_home=${work_home}/bak
if [[ ! -e ${bak_home} ]];then
echo "                                                                                                  备份目录(${bak_home}) 不存在, 创建... "
mkdir -p ${bak_home}
fi
##################################################
if [[ ! -e ${work_home}/${project} ]]; then
echo "                                                                                                  部署目录 : ${work_home}/${project} 尚未存在, 创建..."
mkdir  -p ${work_home}/${project}
fi
##################################################
rm -rf ${bak_home}/${project}
cp -R ${work_home}/${project} ${bak_home}
if  [[  -n  $(netstat -nlp | grep ':'${port}' ' | awk '{print $7}' | awk -F"/" '{ print $1 }')  ]];
then
echo "                                                                                                            ${port} 使用中, 销毁进程以释放端口..."
sh ${work_home}/${project}/bin/job-daemon.sh stop ${project_name}
else echo "                                                                                                                                     ${port} 未被使用..."
fi
rm -rf ${work_home}/${project}/lib
rm -rf ${work_home}/${project}/conf
rm -rf ${work_home}/${project}/bin
unzip -o ${artifact_home}/${artifact}${format} -d ${work_home}/${project}
sh ${work_home}/${project}/bin/job-daemon.sh start ${project_name}
sleep 10 # 启动慢的话可以调高等待时间
##################################################
if  [[  -n $(netstat -nlp | grep ':'${port}' ' | awk '{print $7}' | awk -F"/" '{ print $1 }') ]];then
echo "                                                                                                                                      ${project} 启动成功, 扫尾....."
rm -rf  ${artifact_home}/last
mkdir  -p ${artifact_home}/last
mv  ${artifact_home}/${artifact}${format} ${artifact_home}/last/${last}
echo "                                                                                                                                            部署完成 !"
exit
fi
#if  [[  ! -n $(netstat -nlp | grep ':'${port}' ' | awk '{print $7}' | awk -F"/" '{ print $1 }') ]];then
#echo "端口${port}未被使用, 疑似启动${project}失败, 回滚..."
#sh ${work_home}/${project}/bin/job-daemon.sh stop ${project_name}
#rm -rf ${work_home}/${project}
#mv  ${bak_home}/${project} ${work_home}/${project}
#sh ${work_home}/${project}/bin/job-daemon.sh start ${project_name}
#if  [[ ! -n  $(netstat -nlp | grep ':'${port}' ' | awk '{print $7}' | awk -F"/" '{ print $1 }') ]];then
#echo "回滚失败! 请手动操作!"
#exit
#fi
#fi
