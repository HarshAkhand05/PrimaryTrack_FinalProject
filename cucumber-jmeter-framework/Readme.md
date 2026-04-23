# 📘 Cucumber Selenium Java Automation Framework – DemoQA

## 📌 Overview

This project is a **comprehensive automation framework** built using:

* **Java**
* **Selenium WebDriver**
* **Cucumber (BDD)**
* **TestNG**
* **Excel (Apache POI) for data-driven testing**

It demonstrates multiple approaches to test automation:

1. ✅ **Scenario Outline (Cucumber native data-driven)**
2. ✅ **Excel-based data-driven testing (loop-based)**
3. ✅ **Excel → Dynamic test execution per row**
4. ✅ **Feature file generation from Excel (True BDD approach)**

This project is designed for **learning + practical implementation**, especially for students.

---

## 📁 Project Structure

```
src/test/java
│
├── base/                → WebDriver setup & teardown
├── pages/               → Page Object Model classes
├── stepdefinitions/     → Cucumber step definitions
├── runners/             → TestNG Cucumber runners
├── utils/               → Excel utilities & helpers
├── hooks/               → Before/After test hooks
│
src/test/resources
│
├── features/            → Feature files
├── testdata/            → Excel files + reference code
```

---

## 🎯 Key Features

* ✔ Modular framework (industry standard)
* ✔ Page Object Model (POM)
* ✔ Data-driven testing using Excel
* ✔ Multiple execution strategies
* ✔ Reusable utilities
* ✔ Student-friendly structure

---

## 🧪 Testing Approaches Implemented

### 1. Scenario Outline (Basic Cucumber)

* Uses `Examples` table inside `.feature` file
* Best for **small datasets**

**Example:**

```gherkin
Scenario Outline: Login test
  When user enters "<username>" and "<password>"

Examples:
  | username | password |
```

---

### 2. Excel Data (Loop inside Step Definition)

* Reads Excel data
* Executes all rows inside a loop

**Limitation:**

* ❌ Single scenario in report

---

### 3. Excel Data → Row-Level Execution

* Each row treated as separate execution
* Better reporting compared to loop

---

### 4. Feature File Generation from Excel (Best Practice)

* Excel data → Converted into feature file
* Each row becomes a **separate scenario**

✔ Best for:

* Real-world projects
* Clean reporting
* BDD compliance

---

## 🧰 Utility Classes Explained

---

### 🔹 `BaseTest.java`

**Purpose:**

* Initialize and close WebDriver

**Key Methods:**

```java
setup()
```

* Launches browser
* Opens DemoQA login page

```java
tearDown()
```

* Closes browser after execution

---

### 🔹 `LoginPage.java` (Page Object)

**Purpose:**

* Encapsulates UI actions for login page

**Key Methods:**

```java
enterUsername(String user)
```

* Enters username

```java
enterPassword(String pass)
```

* Enters password

```java
clickLogin()
```

* Clicks login button

```java
login(String user, String pass)
```

* Combined login action

---

### 🔹 `LoginSteps.java`

**Purpose:**

* Maps Gherkin steps to Java code

**Key Methods:**

```java
@Given user is on login page
```

* Opens browser and initializes page

```java
@When user enters username and password
```

* Inputs credentials

```java
@Then login result should be
```

* Validates login success/failure

---

### 🔹 `ExcelUtil.java`

**Purpose:**

* Reads data from Excel file

**Key Method:**

```java
getExcelData(String path, String sheetName)
```

**Returns:**

* `Object[][]` (2D array for test data)

---

### 🔹 `FeatureFileGenerator.java`

**Purpose:**

* Converts Excel data → Cucumber feature file

**Key Method:**

```java
generateFeatureFile()
```

**What it does:**

* Reads Excel rows
* Writes `.feature` file
* Creates scenario per row

---

### 🔹 `TestRunner.java`

**Purpose:**

* Executes Cucumber tests using TestNG

**Key Configuration:**

```java
@CucumberOptions(
  features = "...",
  glue = "...",
  plugin = "..."
)
```

---

### 🔹 `Hooks.java`

**Purpose:**

* Pre/Post execution setup

**Methods:**

```java
@Before
```

* Runs before each scenario

```java
@After
```

* Runs after each scenario

---

## 📊 Test Data Handling

### Excel Location:

```
src/test/resources/testdata/loginData.xlsx
```

### Format:

```
| username | password | result |
```

---

## 📦 Special Note (IMPORTANT FOR STUDENTS)

👉 Inside the `testdata` folder:

* You will find:

  * Step definition samples
  * Feature file samples

### ✅ Why this is added?

To help you:

* Quickly copy reusable code
* Understand different approaches
* Apply methods in real scenarios

---

## 🚀 How to Run the Project

### Step 1: Build Project

```bash
mvn clean install
```

### Step 2: Run Tests

```bash
mvn test
```

---

## 🧠 Learning Outcomes

After using this project, students will understand:

* BDD using Cucumber
* Selenium automation framework design
* Data-driven testing strategies
* Excel integration
* Real-world test architecture

---

## ⚠️ Best Practices

* Do not hardcode test data
* Use Page Object Model
* Keep feature files readable
* Use Excel for large datasets
* Prefer feature generation for real projects

---

## 🏁 Conclusion

This project provides a **complete learning path**:

```
Basic → Intermediate → Advanced Automation Framework
```

Students are encouraged to:

* Experiment with each approach
* Compare results
* Build their own hybrid frameworks

---

## 🙌 Happy Learning & Automation!
