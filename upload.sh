play war
cd target
jar xf *.war
cd upload
rm -rf *
cd ..
mv META-INF/ upload
mv WEB-INF/ upload
cd upload
git add .
git commit -m "$1"
git aws.push

