FROM rauldias98/maven-webdrivers

WORKDIR /usr/bin/

RUN export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
    echo $JAVA_HOME
    sudo chmod +x "/usr/bin/chromedriver"
    sudo chmod +x "/usr/bin/geckodriver"
    sudo chmod +x "/usr/bin/msedgedriver"
    sudo chmod -R 777 /builds/teste_automatizado