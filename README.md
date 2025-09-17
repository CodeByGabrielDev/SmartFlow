# 🚀 **SmartFlow - Invoice & Transaction Management System**

> **Note:** This project is still under development. Some features are in progress.

## 📌 **Description**

SmartFlow is a powerful Java-based system designed to streamline the management of **invoices**, **transactions**, **products**, and **customers**. It leverages **JPA/Hibernate** for persistence and **MySQL** for database management, ensuring optimal performance and scalability. 

This project implements the **MVC architecture** for clean separation of concerns, and follows **DAO** and **Service patterns** to ensure maintainability and testability of the codebase. It also includes advanced features like **stored procedures** and **database triggers** for efficient transaction management.

## ⚠️ **Project Status**
Currently in development. Some features, like advanced reporting and database trigger integration, are still being implemented.

## 🛠️ **Technologies Used**

- **Java 17+**
- **JPA / Hibernate**
- **MySQL**
- **DAO & Service Layers**
- **MVC Architecture**
- **Stored Procedures & Database Triggers**

## 📂 **Project Structure**

src/
├── DAO/ # Data Access Objects (CRUD operations)
├── Entities/ # Entity classes (Pessoa, NotaFiscal, Produto, etc.)
├── Controllers/ # Business logic controllers
├── Services/ # Services for transactions and invoices
├── Utils/ # Utility classes (e.g., JPAUtils)

markdown
Copiar código

## 🔑 **Main Entities**

- **Pessoa** (Customer)
- **PessoaFisica** (Individual Customer)
- **PessoaJuridica** (Corporate Customer)
- **Produto** (Product)
- **Movimentacao** (Transaction)
- **MovimentacaoItem** (Transaction Item)
- **NotaFiscal** (Invoice)
- **NotaFiscalItem** (Invoice Item)

## 🚀 **Features (In Progress)**

- Create and persist transactions (`Movimentacao`)
- Generate and manage invoices (`NotaFiscal`)
- Register and manage customers (`PessoaFisica` & `PessoaJuridica`)
- Implement reporting and queries
- Add validations and business rules
- Integrate advanced database triggers

## 📖 **How to Run**

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/smartflow.git
Import the project into your IDE (IntelliJ / Eclipse).

Configure your MySQL database and update persistence.xml.

Run the application and test the features.

📝 Roadmap
Add unit tests (JUnit)

Create REST API layer

Implement front-end integration

Expand reporting module

🤝 Contributing
This project is open for contributions and improvements. Feel free to fork the repository and submit pull requests.

📜 License
This project is licensed under the MIT License.
