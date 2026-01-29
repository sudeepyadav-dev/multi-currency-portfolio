# Portfolio Report Java

This project is a simple Java application that processes stock buy and sell transactions
from different countries and currencies. All transaction values are converted into USD
using historical exchange rates, and a consolidated portfolio report is generated.

The focus of this project is on clean Java code, accurate financial calculations, and
clear separation of responsibilities.

---

## Features

- Supports BUY and SELL stock transactions
- Handles multiple currencies with date-based exchange rates
- Converts all values into USD
- Prevents invalid sell transactions (short selling)
- Uses BigDecimal for precise monetary calculations
- Generates a clean portfolio summary report

---

## Project Structure

- **model** – Holds plain data classes (Transaction, ExchangeRate, PortfolioEntry)
- **service** – Contains core business logic for processing transactions
- **report** – Responsible for generating the final output report
- **util** – Common utility methods for money handling
- **app** – Application entry point with the main method

---

## How to Run

1. Open the project in IntelliJ IDEA
2. Make sure Java 17 or higher is installed
3. Run the `PortfolioApplication.java` file
4. The portfolio report will be printed in the console

---

## Example Output

----- Portfolio Report (USD) -----
Ticker: AAPL | Shares: 6 | Total USD: 308.00
----- End of Report -----


---

## Assumptions

- Exchange rates are available for all transaction dates
- Sell transactions exceeding available shares are ignored
- All monetary values are rounded to two decimal places

---

## Notes

This project is implemented as a plain Java application without any frameworks.
Maven is used only for build management.
