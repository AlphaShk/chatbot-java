FROM tensorflow/tensorflow


RUN apt-get update && \
    apt-get install -y openjdk-17-jdk ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64/
RUN export JAVA_HOME
CMD ["java", "-version"]

VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/chatbot-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
WORKDIR /usr/src/app

COPY requirements.txt ./

RUN pip install --no-cache-dir -r requirements.txt
RUN python -c "import tensorflow as tf; print(tf.reduce_sum(tf.random.normal([1000, 1000])))"

COPY . .
ENTRYPOINT ["java","-jar","/app.jar"]
