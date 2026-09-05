# Write your MySQL query statement below
-- SELECT e.name
-- FROM Employee AS e 
-- INNER JOIN Employee AS m ON e.id=m.managerId 
-- GROUP BY m.managerId 
-- HAVING COUNT(m.managerId) >= 5

select name from Employee
where id in(
    select managerId from Employee
    group by(managerId)
    having count(managerId)>=5
)