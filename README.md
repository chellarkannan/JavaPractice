Added this repository from local. Steps followed

#initialized git in the local repositor
git init

#git will point out to default branch master now. 
#Add git config
git config --global user.gmail "chellarkannan@gmail.com"
git config --global user.name "chellarkannan"

#check the config
git config --list

#add files
git add .

#do the commit
git commit -m "first commit"

#Use the Https to set the upstream
git remote add origin https://github.com/chellarkannan/JavaPractice.git

#check the remote connections. it will do git push and pull from backend.
git remote -v

#Push the local repo changes to remote. Changes can be seen in the git hub.
git push -f origin master
