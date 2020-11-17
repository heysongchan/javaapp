# javaapp
package and run javaapp with maven
test
windows git daemon 服务器搭建

安装git ，使用不再赘
在文件夹repo 中执行git init新建git仓库
在 repo目录下执行git config --local receive.denyCurrentBranch updateInstead
执行git config --global sendpack.sideband false
在repo的上级目录中执行git daemon --reuseaddr --base-path=. --export-all --verbose --enable=receive-pack开启服务器
在新建文件夹中git clone git://127.0.0.1/repo，push此时也可用
