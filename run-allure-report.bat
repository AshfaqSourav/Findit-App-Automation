@echo off

:: Step 1: Clean old Allure results (if any)
echo Cleaning old Allure results...
if exist allure-results rmdir /s /q allure-results

:: Step 2: Clean old Allure report (if any)
echo Cleaning old Allure report...
if exist allure-report rmdir /s /q allure-report

:: Step 3: Run tests and generate Allure results
echo Running tests and generating Allure results...
mvn test
if %ERROR LEVEL% neq 0 (
    echo Maven tests failed. Proceeding to generate the report anyway...
)

:: Step 4: Generate new Allure report
echo Generating new Allure report...
allure generate allure-results --clean -o allure-report
if %ERROR LEVEL% neq 0 (
    echo Failed to generate Allure report. Check if allure-results directory exists and contains results.
    pause
    exit /b 1
)

:: Step 5: Open Allure report in browser
echo Opening Allure report in browser...
allure open allure-report
if %ERROR LEVEL% neq 0 (
    echo Failed to open Allure report. Ensure Allure is installed and configured in the PATH.
    pause
    exit /b 1
)

:: End of script
pause