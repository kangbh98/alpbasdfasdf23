# 

## Model
www.msaez.io/#/179681472/storming/alpb-code

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- user
- plan
- review
- diary
- order
- payment
- read


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- user
```
 http :8088/users userIdx="user_idx" email="email" password="password" nickname="nickname" profileImg="profile_img" refreshToken="refresh_token" credit="credit" 
```
- plan
```
 http :8088/plans planIdx="plan_idx" userIdx="user_idx" placeName="place_name" address="address" phone="phone" category="category" date="date" time="time" planStatus="plan_status" 
```
- review
```
 http :8088/reviews reviewIdx="review_idx" userIdx="user_idx" placeName="place_name" comment="comment" trafficScore="traffic_score" travelScore="travel_score" foodScore="food_score" totalScore="total_score" reviewStatus="review_status" 
```
- diary
```
 http :8088/diaries diaryId="diary_id" date="date" userIdx="user_idx" imageUrl="image_url" comment="comment" diaryStatus="diary_status" 
```
- order
```
 http :8088/orders orderId="order_id" userId="user_id" product="product" orderStatus="order_status" 
```
- payment
```
 http :8088/payments id="id" 
```
- read
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

