
CI/CD 및 쿠버네티스 실습 

개발 환경 Window, CI/CD 노트북 window virtualbox ubuntu 20.24.6 LTS, kubernates 1대 os : Ubuntu 24.04 LTS

개발 환경에서 개발후 git으로 push
ci/cd 환경에서 소스 빌드 후 컨테이너 이미지 생성 하여 docker hub로 업로드 (https://hub.docker.com/repository/docker/otteu/todo-api-test/general)
kubernates 에 배포 


참조 자료

소스 다운 -> 빌드 -> 배포
![jenkins](https://github.com/user-attachments/assets/61fe8585-6d0d-4464-8997-e100f1374d14)

source build
![source build](https://github.com/user-attachments/assets/a854c35a-cb3f-4c1e-9f52-5f078cb92038)

image build
![container build](https://github.com/user-attachments/assets/4b0f86a9-c1ec-4362-a71e-09d845391c25)

kubenates 배포
![쿠버네티스 배포](https://github.com/user-attachments/assets/7498e880-533b-4b9d-8bab-aa0467fdfaf7)

ci/cd
![CI CD 서버](https://github.com/user-attachments/assets/29bef790-e4e4-4471-bf08-bb537d03dc19)

kubenates
![쿠버네티스 서비](https://github.com/user-attachments/assets/a473d462-6bb5-4f85-bfe9-ee8a4ea551bd)

insert
![insert](https://github.com/user-attachments/assets/2fd2596a-0094-465e-8fe8-34a25669e64c)

![데이터 저장](https://github.com/user-attachments/assets/718ae3b8-dd40-4b99-acb9-0ac92eb46d26)

db
![db](https://github.com/user-attachments/assets/a5d9e202-5e06-44a4-b60a-0d1c69446828)




