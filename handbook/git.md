# 配置多个SSH账户

ssh-keygen -t rsa -C '邮箱甲' -f ~/.ssh/甲_id_rsa

ssh-keygen -t rsa -C '邮箱乙' -f ~/.ssh/乙_id_rsa

vim ~/.ssh/config

        # 甲
        Host 甲.com
        HostName 甲.com
        PreferredAuthentications publickey
        IdentityFile ~/.ssh/甲_id_rsa
        # 乙
        Host 乙.com
        HostName 乙.com
        PreferredAuthentications publickey
        IdentityFile ~/.ssh/乙_id_rsa

ssh -T git@甲.com

ssh -T git@乙.com

git config --global user.name "全局用户名"

git config --global user.email "全局邮箱"

cd 某个本地仓库甲

git config --local user.name "甲仓库专用用户名"

git config --local user.email "甲仓库专用邮箱"


---

# 清空Git提交记录

git checkout --orphan latest_branch

git add -A

git commit -am "init"

git branch -D master

git branch -m master

git push -f origin master