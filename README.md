# Booking.com QA Automation
This project automates tests for the website Booking.com using Selenide.

## Description

This Selenide project automates various test scenarios on the Booking.com website. The tests are organized into different test classes based on the functionality.

## Technologies Used

* **Testing Frameworks:**
* Selenium WebDriver
* Selenide
* TestNG
* Allure (Reporting)

* **Project Management:**
* Maven

* **Utilities:**
* WebDriverManager
* Allure Environment Writer

## Test Cases

### RegistrationTests
* This test focuses on validating the registration process on Booking.com. It includes positive scenarios (valid email and strong password) as well as negative scenarios to ensure error handling (invalid email, weak/mismatched passwords).

### SearchTests
* This test aims to validate the search functionality on Booking.com. It includes selecting a destination, setting the number of adults and children, choosing dates, and performing a complete search scenario to ensure the search results match the specified criteria.

### LoginTests
* This test aims to validate the login functionality on Booking.com by testing both positive (successful login) and negative scenarios (invalid inputs, incorrect credentials). It also includes social login options (Apple, Google, Facebook), and account verifications.

### Localization
* This test focuses on validating the language change functionality on Booking.com. It ensures that the website content is properly displayed in the selected language.

### Accessibility 
* This test ensures performs an accessibility audit on the Booking.com website using the Axe-core library and generates a report.

### User Interface
* This test validates the UI elements on various pages of Booking.com, ensuring they are present, correctly attributed, and styled.

### Flights
* This test validates the flights search functionality on Booking.com, ensuring that the search results can be sorted by price and that clicking a deal opens a new window.

## Running the Project
To run the tests locally, follow these steps:

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Alinatkabladze/Bootcamp9_Team2.git
    ```

2. **Navigate to the Project Directory**:
    ```bash
    cd Bootcamp9_Team2
    ```

3. **Install Dependencies**:
    - Ensure you have Java Development Kit (JDK) installed.
    - Install Maven if you haven't already.

4. **Run the Tests**:
    ```bash
    mvn test
    ```
## Notes
* Ensure that the required environment variables and configurations are set up before running the tests.
* Make sure that the browser drivers are properly set up in your system for Selenium WebDriver to function correctly.
* Utilize Allure reporting to get detailed insights into your test executions.


  This README provides an overview and instructions for running the automated tests for Booking.com functionality. Adjust the repository link, project directory, and any specific configurations as per your project's setup.