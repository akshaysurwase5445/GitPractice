void main() {

    List<Employee> employeeList = new ArrayList<Employee>();

    employeeList.add(new Employee(111, "Akshay Surwase", 27, "Male", "Developer", 2022, 72500));
    employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
    employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
    employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
    employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
    employeeList.add(new Employee(155, "Nima Roy", 27, "Transgender", "HR", 2013, 22700.0));
    employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
    employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
    employeeList.add(new Employee(188, "Wang Liu", 31, "Transgender", "Product Development", 2015, 34500.0));
    employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
    employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
    employeeList.add(new Employee(211, "Jasna Kaur", 27, "Transgender", "Infrastructure", 2014, 15700.0));
    employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
    employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
    employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
    employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
    employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
    employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


    //

    IO.println("--------Male Female count-----------");
    Map<String, Long> noOfMaleFemaleCount = employeeList.stream().collect(Collectors
            .groupingBy(Employee::getGender, Collectors.counting()));
    IO.println("Number of male female count:-" + noOfMaleFemaleCount);

    //Query 3.2 : Print the name of all departments in the organization?
    //Use distinct() method after
    // calling map(Employee::getDepartment) on the stream. It will return unique departments.

    IO.println("All department in the organization : ");

    Map<String, Long> departments = employeeList.stream().collect(Collectors.
            groupingBy(Employee::getDepartment, Collectors.counting()));
    IO.println(departments);
    IO.println("--------Department in the organization-----------");
    employeeList.stream().map(Employee::getDepartment).distinct()
            .collect(Collectors.toList())
            .forEach(System.out::println);

    //Query 3.3 : What is the average age of male and female employees?
    IO.println("Average age of male and female employees : ");
    Map<String, Double> avgAgeOfEmployee = employeeList.stream().
            collect(Collectors.
                    groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
    IO.println(avgAgeOfEmployee);

    IO.println("==================================");
    IO.println("=======highest paid Employee======");
    //Query 3.4 : Get the details of highest paid Employee in the organization?
    //Use Collectors.maxBy() method which returns maximum
    // element wrapped in an Optional object based on supplied Comparator.

    Optional<Employee> highestPaidEmployee = employeeList.stream().
            collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
    IO.println(highestPaidEmployee);

    IO.println("==================================");
    IO.println("Employees who joined after 2015 : ");
    //Query 3.5 : Get the names of all employees who have joined after 2015?
    //For such queries which require filtering of input elements, use
    // Stream.filter() method which filters input elements according to supplied Predicate.

    employeeList.stream()
            .filter(Employee -> Employee.yearOfJoining >= 2015)
            .map(Employee::getName)
            .collect(Collectors.toList()).forEach(System.out::println);

    //Query 3.6 : Count the number of employees in each department?
    //This query is same as query 3.1 but here we are grouping the elements by department.
    IO.println("==================================");
    IO.println("Number of employees in each department : ");
    Map<String, Long> numberOfEmploeeInDepartments = employeeList.stream().
            collect(Collectors.
                    groupingBy(Employee::getDepartment, Collectors.counting()));
    IO.println(numberOfEmploeeInDepartments);

    Set<Map.Entry<String, Long>> entries = numberOfEmploeeInDepartments.entrySet();

    for (Map.Entry<String, Long> entry : entries) {
        IO.println(entry.getKey() + ":" + entry.getValue());
    }

    IO.println("==================================");

    //Query 3.7 : What is the average salary of each department?
    IO.println("Average salary of each department");

    Map<String, Double> AvgSalaryOfEmployee = employeeList.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors
                    .averagingDouble(Employee::getSalary)));
    IO.println(AvgSalaryOfEmployee);
    Set<Map.Entry<String, Double>> avgsalary = AvgSalaryOfEmployee.entrySet();

    for (Map.Entry<String, Double> entry : avgsalary) {
        IO.println(entry.getKey() + ":" + entry.getValue());
    }
    IO.println("==================================");
    //Query 3.8 : Get the details of youngest male Employee in the product development department?
    //For this query, use Stream.filter() method to filter male employees in product development
    // department and to find youngest among them, use Stream.min() method.

    Optional<Employee> min = employeeList.stream().filter(Employee -> Employee.getDepartment() == "Product Development"
            && Employee.getGender() == "Male").min(Comparator.comparing(Employee::getAge));

    IO.println("Details Of Youngest Male Employee In Product Development");
    Employee youngestMaleEmployeeInProductDevelopment = min.get();

    IO.println("----------------------------------------------");

    IO.println("ID : " + youngestMaleEmployeeInProductDevelopment.getId());

    IO.println("Name : " + youngestMaleEmployeeInProductDevelopment.getName());

    IO.println("Age : " + youngestMaleEmployeeInProductDevelopment.getAge());

    IO.println("Year Of Joinging : " + youngestMaleEmployeeInProductDevelopment.getYearOfJoining());

    IO.println("Salary : " + youngestMaleEmployeeInProductDevelopment.getSalary());

    IO.println("==================================");
    //Query 3.9 : Who has the most working experience in the organization?
    //For this query, sort employeeList by yearOfJoining in natural order and first Employee
    // will have most working experience in the organization.
    // To solve this query, we will be using sorted() and findFirst() methods of Stream.

    Employee seniorMostEmployee = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst().get();
    IO.println("Senior Most Employee Details :");
    IO.println("----------------------------");
    IO.println("ID : " + seniorMostEmployee.getId());
    IO.println("Name : " + seniorMostEmployee.getName());
    IO.println("Age : " + seniorMostEmployee.getAge());
    IO.println("Gender : " + seniorMostEmployee.getGender());
    IO.println("Age : " + seniorMostEmployee.getDepartment());
    IO.println("Year Of Joinging : " + seniorMostEmployee.getYearOfJoining());
    IO.println("Salary : " + seniorMostEmployee.getSalary());

    //Query 3.10 : How many male and female employees are there in the sales and marketing team?
    IO.println("----------------------------");
    IO.println("Male Female Employee in the sales and marketing team");

    Map<String, Long> mFSalesAndMarketing = employeeList.stream().
            filter(s -> s.getDepartment() == "Sales and Marketing").
            collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    IO.println(mFSalesAndMarketing);

    Map<String, Long> countMaleFemaleEmployeesInSalesMarketing =
            employeeList.stream().
                    filter(e -> e.getDepartment() == "Sales And Marketing").
                    collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

    IO.println(countMaleFemaleEmployeesInSalesMarketing);

    //Query 3.11 : What is the average salary of male and female employees?
    IO.println("----------------------------");
    IO.println("Average salary of male and female employees are");

    Map<String, Double> avgSalMF = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
    IO.println(avgSalMF);

    IO.println("----------------------------");
    //Query 3.12 : List down the names of all employees in each department?
    //For this query, we will be using Collectors.groupingBy()
    // method by passing Employee::getDepartment as an argument.
    Map<String, List<Employee>> employeeFromAllDepartments = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

    Set<Map.Entry<String, List<Employee>>> entries1 = employeeFromAllDepartments.entrySet();

    for (Map.Entry<String, List<Employee>> entry : entries1) {
        IO.println("Employees In " + entry.getKey() + " : ");

        IO.println("--------------------------------------");

        List<Employee> list = entry.getValue();

        for (Employee e : list) {
            IO.println(e.getName());
        }
    }

    IO.println("=========================================");
    //Query 3.13 : What is the average salary and total salary of the whole organization?
    //For this query, we use Collectors.summarizingDouble() on Employee::getSalary
    // which will return statistics of the Employee salary like max, min, average and total.
    IO.println("Average salary and total salary of the whole organization");

    DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

    IO.println("Average Salary = " + employeeSalaryStatistics.getAverage());
    IO.println("Total Salary = " + employeeSalaryStatistics.getSum());
    IO.println("Min Salary = " + employeeSalaryStatistics.getMin());
    IO.println("Max Salary = " + employeeSalaryStatistics.getMax());
    IO.println("Count = " + employeeSalaryStatistics.getCount());
    IO.println("=========================================");

    //Query 3.14 : Separate the employees who are younger
    // or equal to 25 years from those employees who are older than 25 years.
    //For this query, we will be using Collectors.partitioningBy()
    // method which separates input elements based on supplied Predicate.

    Map<Boolean, List<Employee>> youngerEmployee = employeeList.stream().
            collect(Collectors.partitioningBy(r -> r.getAge() <= 25));

    Set<Map.Entry<Boolean, List<Employee>>> entryyset = youngerEmployee.entrySet();

    for (Map.Entry<Boolean, List<Employee>> listEntry : entryyset) {
        IO.println("--------------------------------");

        if (listEntry.getKey()) {
            IO.println("Employees older than 25 years :");
        } else {
            IO.println("Employees younger than or equal to 25 years :");
        }

        IO.println("----------------------------");
        List<Employee> value = listEntry.getValue();
        for (Employee e : value) {
            IO.println(e.getName());
        }

    }
    IO.println("=========================================");
    IO.println("Oldest Employee in the organization");
    //Query 3.15 : Who is the oldest Employee in the organization?
    // What is his age and which department he belongs to?

    Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
    Employee oldestEmployee = oldestEmployeeWrapper.get();
    IO.println("Name : " + oldestEmployee.getName());
    IO.println("Age : " + oldestEmployee.getAge());
    IO.println("Department : " + oldestEmployee.getDepartment());

    String str =
            "The first second was alright but the second second was tough.";

    str = Arrays.stream(str.split(" ")).distinct().collect(Collectors.joining(" "));
    IO.println(str);
}