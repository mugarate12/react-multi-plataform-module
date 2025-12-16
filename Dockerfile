FROM mobiledevops/android-sdk-image:latest
WORKDIR /app
COPY . .

RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix gradlew
RUN chmod +x gradlew

CMD ./gradlew clean assembleRelease