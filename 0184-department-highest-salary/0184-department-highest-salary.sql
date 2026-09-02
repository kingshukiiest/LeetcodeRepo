# Write your MySQL query statement below
select d.name as Department,e.name as Employee,e.salary as Salary
from employee e
join department d
on e.departmentId=d.id
where e.salary=(
    Select MAX(salary)
    from employee
    where employee.departmentId=e.departmentId
);