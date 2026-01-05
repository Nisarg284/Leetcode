# Write your MySQL query statement below

-- Select Max(salary) as maxSalary
-- from Employee
-- order By salary Desc
-- skip(1);



SELECT 
    MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);
