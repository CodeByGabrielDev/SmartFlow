# 💼 SmartFlow - Invoice & Transaction Management System

**SmartFlow** is a Java-based backend application designed to manage invoices, transactions, customers, and products with structured business rules. It uses **JPA/Hibernate** for persistence, follows the **MVC architecture**, and applies **DAO and Service layers** for clean separation of concerns and scalability.

> ⚠️ The project is in development. Some features may be incomplete or in progress.

---

## ⚙️ Key Features

- ✅ Create and manage sales transactions
- ✅ Auto-generate invoices linked to transactions
- ✅ Time-based cancellation rules (e.g., invoices cannot be canceled after 10 minutes)
- ✅ Entity relationship handling with automated Many-to-Many logic
- 🛠️ Business rules applied through service layer
- 🛠️ Prepared for integration with Spring (future)

---

## 🛠️ Tech Stack

- Java 17+
- JPA / Hibernate
- MySQL
- MVC Architecture
- DAO & Service Pattern
- Stored Procedures & Triggers (planned)

---

## 📂 Project Structure

src/
├── DAO/ # Data Access Objects
├── Entities/ # JPA Entities (Pessoa, Produto, NotaFiscal, etc.)
├── Services/ # Business logic & automation
├── Interfaces/ # DAO interfaces
├── Utils/ # Utility classes (JPA setup, etc.)
├── Controllers/ # (Planned for future)
└── resources/ # Configuration files (persistence.xml)

yaml
Copiar código

---

## 🧠 Business Logic Example

- When a `Movimentacao` (transaction) is registered:
  - Products are automatically linked via an intermediate table.
  - A `NotaFiscal` (invoice) is generated and persisted.
- If a cancellation is requested:
  - The system checks the time passed since the sale.
  - If more than **10 minutes** have passed, cancellation is **blocked**.
  - If not, both the transaction and invoice are automatically canceled.

This logic ensures **data integrity** and simulates **real-world fiscal constraints**.

---

## 🚀 Getting Started

1. **Clone the repository**

```bash
git clone https://github.com/your-username/smartflow.git
Import into your IDE (IntelliJ, Eclipse, etc.)

Configure the database

Update the persistence.xml file with your MySQL credentials and connection details.

Run the main class

Execute Main.java to start using the system.

📈 Roadmap (Coming Soon)
 Unit tests (JUnit)

 REST API (Spring Boot)

 Front-end integration

 Reporting & analytics module

 Stored procedures and DB triggers

🤝 Contributing
Pull requests are welcome. This project is open for learning, improvements, and community contributions.

📜 License
This project is licensed under the MIT License.
