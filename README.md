# Groww Simple Interest Calculator Automation

![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Selenium](https://img.shields.io/badge/Selenium-Automation-brightgreen)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Automating the **Groww Simple Interest Calculator** using **Java + Selenium WebDriver** with a **data-driven testing approach**.  
This project demonstrates how to automate financial calculator workflows and validate interest calculations dynamically.

---

## 🔹 Features
- Automates Groww’s **Simple Interest Calculator**.
- Accepts **multiple data sets** for principle, rate, and time.
- Uses **data-driven testing** to validate interest results.
- Selenium WebDriver with ChromeDriver for browser automation.
- Maven project structure for easy build and dependency management.

---

## 🔹 Tech Stack
- **Java 17**
- **Selenium WebDriver**
- **Maven**
- **VS Code / IntelliJ IDEA**

---

## 🔹 How to Run
1. Clone this repo:
   ```bash
   git clone https://github.com/<your-username>/<repo-name>.git

2. Navigate to project folder:
    ```bash
    cd data-driven-testing-java

3. Run with Maven:
    mvn test [If this command is not working then use below command]
    mvn clean test-compile exec:java


🔹 Sample Flow
    Open Groww Simple Interest Calculator.
    Enter principle, rate of interest, and time.
    Fetch dynamically calculated Total Interest.
    Validate against expected values.

🔹 Why This Project?
    This project shows how data-driven testing can be applied in real-world financial tools, ensuring accuracy and reliability in calculations.

🔹 Future Enhancements
    Add Excel/CSV integration for input data.
    Extend to other Groww calculators.
    Add TestNG / JUnit integration for structured test reports.