# 💸 Pocket Balance – Personal Finance Manager

**Pocket Balance** is a modern Spring Boot web app for managing personal finances, tracking income, expenses, and budget surplus—all with a clean dashboard UI and PostgreSQL cloud database.

---

## 🚀 Overview

Pocket Balance lets you:
- 💼 Track **all transactions**: salary, bills, recurring payments, savings
- 📊 See **total expenses** and remaining balance in real time
- ✍️ **Add, edit, or delete** transactions with instant feedback (modal dialogs)
- 🧾 Review your **full financial history**—amounts, periods, categories, and more
- 🧑‍💻 100% **open-source**: extend, remix, or adapt for your own needs!

---

## 🛠️ Tech Stack

<p align="left">
  <a href="https://spring.io/"><img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="Spring Boot" width="40" height="40"/></a>
  <a href="https://www.postgresql.org/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original-wordmark.svg" alt="PostgreSQL" width="40" height="40"/></a>
  <a href="https://getbootstrap.com/"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-original-wordmark.svg" alt="Bootstrap" width="40" height="40"/></a>
  <a href="https://www.thymeleaf.org/"><img src="https://www.thymeleaf.org/doc/logo.svg" alt="Thymeleaf" width="40" height="40"/></a>
  <a href="https://www.java.com/"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="40" height="40"/></a>
</p>

- **Spring Boot 3**
- **Java 17+**
- **PostgreSQL (Cloud hosted via Render.com)**
- **Spring Data JPA (Hibernate)**
- **Thymeleaf Templates**
- **Bootstrap 5 + FontAwesome**
- **Maven Build**

---

## 🖥️ Features

- **Dashboard** with salary, total expenses, and remaining funds
- **CRUD for all transactions** (period, name, amount, quantity)
- **Edit salary** directly from the UI (modal)
- **Responsive, modern UI** (Bootstrap + custom CSS)
- **Auto-updating timestamps** for every change
- **Relational data model**: separate tables for transactions and salary
- **Cloud database** out-of-the-box (just clone & run)

---

## 📁 Folder Structure

src/
├── main/
│ ├── java/com/PocketBalance/pocketBalance/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── domain/
│ │ └── repository/
│ ├── resources/
│ │ ├── templates/
│ │ │ └── finances/ (Thymeleaf fragments)
│ │ ├── static/
│ │ │ ├── css/
│ │ │ └── js/
│ │ └── application.properties


---

## ⚡ Getting Started

1. **Clone the repository**
    ```sh
    git clone https://github.com/JB1302/Projects.git
    cd Projects/SpringBoot/PocketBalance
    ```

2. **Configure Database**  
    By default, the app connects to a PostgreSQL cloud instance on Render.com.  
    (Credentials are in `application.properties`—**change them if deploying!**)

    ```properties
    spring.datasource.url=jdbc:postgresql://dpg-d1b07beuk2gs7397nji0-a.oregon-postgres.render.com:5432/pocketbalance
    spring.datasource.username=pocketbalance_user
    spring.datasource.password=wVxfPVBCI0B4Tr1XHi4hWwAyQESdks9D
    ```

    If you want to use a **local PostgreSQL**, update the connection string and credentials.

3. **Run the app**
    ```sh
    ./mvnw spring-boot:run
    ```
    Access [http://localhost/](http://localhost/) (or port 80 if running locally).

---

## 🗄️ Database Schema (MySQL Example)

Want to bootstrap your own DB?  
Here's the core schema for the `cuentas` table:

```sql
CREATE TABLE cuentas (
  id_transaccion    INT          NOT NULL AUTO_INCREMENT,
  periodo           INT          NOT NULL,
  nombre            VARCHAR(30)  NOT NULL,
  monto             INT          NOT NULL,
  cantidad          INT          NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL
    DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id_transaccion)
) DEFAULT CHARSET = utf8mb4;

Sample records included in the repo for quick testing.

---

## 👀 How It Works

    - Landing dashboard: View salary, total expenses, and what's left.
    - Table of transactions: Add, edit, or delete entries; edit your salary.
    - Auto-calculated balances: All totals update in real-time as you manage your finances.

---

## 📚 Extend & Remix

    - Change color themes or card styles in /static/css/styles.css
    - Add new financial categories or analytics widgets
    - Swap PostgreSQL for another DB by editing application.properties

## 🤝 Credits

Created by Jonathan Barrantes

## 📜 License

Open-source for personal and educational use.
Feel free to fork, extend, or build your own version!