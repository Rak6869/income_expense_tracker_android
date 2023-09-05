# VTU 6th Sem MAD Project - Expense Tracker Android Application

Welcome to the VTU 6th Sem Mobile Application Development (MAD) project repository for the Expense Tracker Android Application. This application is designed to help users manage their expenses and income conveniently. It has been developed using Android with the Chipmunk framework.

## Project Details

- **Semester:** 6th Semester
- **Course:** Mobile Application Development (MAD)
- **Platform:** Android (Chipmunk)
- **Number of people that contributed** 3
- **SDK** minSdk 24
          targetSdk 32

## Project Overview

The Expense Tracker Android Application is designed to help users manage their income and expenses efficiently. Here are some key features:

### User Input

- Users can input their financial transactions, categorizing them as income or expenses.
- Categories are customizable and include options such as:
  - Grocery
  - Petrol
  - Bill
  - Restaurant
  - Misc
  - Salary
  - Pocket Money
- Users can also select the date of the transaction.

### Screens

1. **Transaction Input Screen**: Users can add income and expense transactions along with their respective categories and dates. The data is saved locally using Room Database.

2. **Retrieval Screen**: Users can perform various queries such as:
   - Querying only expenses
   - Querying only income
   - Querying by category
   Each retrieval displays the total amount for the selected criteria.

3. **Visualization Screen**: This screen displays a pie chart to visualize the user's income and expenses. The pie chart implementation is based on the tutorial available at [GeeksforGeeks](https://www.geeksforgeeks.org/how-to-add-a-pie-chart-into-an-android-application/).

## Development Environment

The project was developed using Android Studio, a popular integrated development environment (IDE) for Android app development.
