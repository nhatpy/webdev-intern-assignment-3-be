# [GOLDEN OWL SOLUTIONS] JAVA INTERN - ABILITY TEST

## Common Information
- **Tên website**: G-Scores  
- **Giao diện**: Sử dụng template do [**Golden Owl Solutions**](https://github.com/GoldenOwlAsia) cung cấp  
- **Phát triển bởi**: [**Đỗ Long Nhật**](https://github.com/nhatpy)
- **Đối tượng sử dụng**: Học sinh và phụ huynh có nhu cầu tra cứu điểm thi  
- **Mục tiêu**: Cung cấp nền tảng tra cứu điểm thi nhanh chóng, dễ sử dụng và chính xác  
- **Mục đích sử dụng**: Bài kiểm tra ứng viên thực tập
- **Related Repository**: [Frontend Source](https://github.com/nhatpy/webdev-intern-assignment-3-fe)


## Getting Started
If you don't want to run on your local device, you can check this deployment on
```js
https://webdev-intern-assignment-3-fe.vercel.app/
```
###3 Prerequisites
1. JDK-21 is needed for run locally, so download JDK-21 from [this](https://www.oracle.com/vn/java/technologies/downloads/)
2. Please check your JDK version by
  ```sh
  java -version
  ```
3. Be sure that you have installed Redis and MySQL database (driver and its GUI client) on your device
### Docker setup
#### Installation
1. You need to install Docker Desktop on [this](https://www.docker.com/products/docker-desktop/)
2. Clone the repo
   ```sh
   git clone https://github.com/nhatpy/webdev-intern-assignment-3-be.git
   ```
3. Follow sample.env to config environment variable (create new .env file or config env variable depends on your Text Editor/IDE)
   ```js
   DB_HOST=<your_db_host>
   DB_PORT=<your_db_port>
   DB_NAME=<your_db_name>
   DB_USER=<your_db_user>
   ...
   ```
4. Run docker-compose.yml and wait for creating images and containers
   ```sh
    docker-compose up --build
   ```
### Local setup

#### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/nhatpy/webdev-intern-assignment-3-be.git
   ```
2. Install Maven dependency
   ```sh
   mvn clean install
   ```
3. Follow sample.env to config environment variable (create new .env file or config env variable depends on your Text Editor/IDE)
   ```js
   DB_HOST=<your_db_host>
   DB_PORT=<your_db_port>
   DB_NAME=<your_db_name>
   DB_USER=<your_db_user>
   ...
   ```
4. After that, run your api service by launch button on your Text Editor/IDE
   - If you use Text Editor like VSCode and similar Text Editor, create launch.json on .vscode folder. Don't forget to config your environtment on that json file
   - If you use IDE like Intellij, it has supported all for you

## Built With

#### Frontend
 [![React][React.js]][React-url]
 [![Tailwind][Tailwind.css]][Tailwind-url]
 [![Ant Design][Antd.img]][Antd-url]
 [![Vercel][Vercel.img]][Vercel-url]

#### Backend
 [![Spring Boot][Spring.img]][Spring-url]
 [![Render][Render.img]][Render-url]

#### Database
 [![MySQL][MySQL.img]][MySQL-url]
 [![Redis][Redis.img]][Redis-url]

#### Tools
 [![Swagger][Swagger.img]][Swagger-url]
 [![Docker][Docker.img]][Docker-url]
 [![VSCode][VSCode.img]][VSCode-url]

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/

[Tailwind.css]: https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css&logoColor=white
[Tailwind-url]: https://tailwindcss.com/

[Antd.img]: https://img.shields.io/badge/Ant_Design-0170FE?style=for-the-badge&logo=ant-design&logoColor=white
[Antd-url]: https://ant.design/

[Vercel.img]: https://img.shields.io/badge/Vercel-000000?style=for-the-badge&logo=vercel&logoColor=white
[Vercel-url]: https://vercel.com/

[Spring.img]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white
[Spring-url]: https://spring.io/projects/spring-boot

[Render.img]: https://img.shields.io/badge/Render-000000?style=for-the-badge&logo=render&logoColor=white
[Render-url]: https://render.com/

[MySQL.img]: https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white
[MySQL-url]: https://www.mysql.com/

[Redis.img]: https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white
[Redis-url]: https://redis.io/

[Swagger.img]: https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black
[Swagger-url]: https://swagger.io/

[Docker.img]: https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com/

[VSCode.img]: https://img.shields.io/badge/VSCode-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white
[VSCode-url]: https://code.visualstudio.com/
