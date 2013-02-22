play war
cd target
jar xf *.war
cd upload
rm -rf *
cd ..
mv META-INF/ foo
mv WEB-INF/ foo
cd upload
git add .
git commit -m "Uploading"
git aws.push

